package mae.fhdo.appgebrueht.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import mae.fhdo.appgebrueht.R;
import mae.fhdo.appgebrueht.activities.adapter.ImageAdapter;
import mae.fhdo.appgebrueht.db.RezeptManager;
import mae.fhdo.appgebrueht.entities.Rezept;

public class ActivityRezeptDetailansicht extends AppCompatActivity {

    private RezeptManager rezeptManager;
    private Rezept rezept;
    private ImageAdapter imageAdapter;

    private static final int REQUEST_TAKE_PHOTO = 1;
    private String mCurrentPhotoPath;
    private static final int MY_PERMISSIONS_REQUEST_CAMERA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezept_detailansicht);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Intent intent = this.getIntent();
        int rezeptId = intent.getIntExtra("rezeptId", -1);

        if (rezeptId < 0) {
            Toast.makeText(this, "Rezept-ID ist ungültig - kehre zur Rezeptliste zurück", Toast.LENGTH_SHORT).show();
            this.finish();
        } else {

            // Rezeptdaten aus der DB holen
            this.rezeptManager = RezeptManager.getInstance(this);
            this.rezept = rezeptManager.getRezeptById(rezeptId);

            // Rezept-Entity-Attribute auf der Oberfläche anzeigen
            this.rezeptAnzeigen();
        }


        // Berechtigungen prüfen
        if (ContextCompat.checkSelfPermission(ActivityRezeptDetailansicht.this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(ActivityRezeptDetailansicht.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED
            )
        {

            // Soll eine Erklärung angezeigt werden, warum die Berechtigung benötigt wird?
            if(ActivityCompat.shouldShowRequestPermissionRationale(ActivityRezeptDetailansicht.this,
                    Manifest.permission.CAMERA)) {

            } else {
                ActivityCompat.requestPermissions(ActivityRezeptDetailansicht.this,
                        new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_CAMERA);
            }
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menu_rezepte:
                startActivity(new Intent(this, ActivityRezeptUebersicht.class));
                //Toast.makeText(ActivityRezeptUebersicht.this, "Rezept Übersicht ist ausgewählt", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.menu_hot_or_not:
                startActivity(new Intent(this, ActivityHotOrNot.class));
                //Toast.makeText(ActivityRezeptUebersicht.this, "Hot or Not ist ausgewählt", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        Button fotoButton = (Button) findViewById(R.id.rezeptFotoMachen);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CAMERA: {
                // Wenn Rechteanfrage vom Benutzer geschlossen wird, ist das Array leer (= keine Berechtigung)
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Toast.makeText(ActivityRezeptDetailansicht.this, "Rezept Übersicht ist ausgewählt", Toast.LENGTH_LONG).show();
                    fotoButton.setVisibility(View.VISIBLE);
                } else {
                    fotoButton.setVisibility(View.INVISIBLE);
                }
                return;
            }
        }
    }




    public void onFoto(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {

            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }

            // Continue only if the File was successfully created
            if (photoFile != null) {
                try {
                    Uri photoURI = FileProvider.getUriForFile(this,
                            "mae.fhdo.appgebrueht.fileprovider",
                            photoFile);
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                    startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
                }catch(Exception ex){
                    Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }
    }


    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == RESULT_OK) {
            Toast.makeText(this, "Bild wurde eingestellt", Toast.LENGTH_SHORT).show();
            //this.imageAdapter.addCameraImage(mCurrentPhotoPath);
        }
    }



    public void onLike(View view) {
        this.rezept.setLikes(this.rezept.getLikes() + 1);
        this.rezeptManager.updateRezept(this.rezept);
        this.rezeptAnzeigen();
    }


    private void rezeptAnzeigen(){
        // Rezept-Fotos
        ViewPager rezeptFotos = (ViewPager) findViewById(R.id.rezeptFotos);
        this.imageAdapter = new ImageAdapter(this, this.rezept.getFotos());
        rezeptFotos.setAdapter(this.imageAdapter);

        // Rezept-Titel
        TextView rezeptTitel = (TextView) findViewById(R.id.rezeptTitel);
        rezeptTitel.setText(rezept.getTitel());

        // Rezept-Likes
        TextView rezeptLikes = (TextView) findViewById(R.id.rezeptLikes);
        rezeptLikes.setText("Likes: " + rezept.getLikes());

        // Rezept-Beschreibung
        TextView rezeptBeschreibung = (TextView) findViewById(R.id.rezeptBeschreibung);
        rezeptBeschreibung.setText(rezept.getBeschreibung());
    }


}
