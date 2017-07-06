package mae.fhdo.appgebrueht.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mae.fhdo.appgebrueht.R;
import mae.fhdo.appgebrueht.entities.Rezept;

/**
 * Created by Marvin Jakob.
 */

public class RezeptListAdapter extends ArrayAdapter<Rezept> {

    Context context;
    int layoutResourceId;
    List<Rezept> rezeptList = null;

    public RezeptListAdapter(Context context, int layoutResourceId, List<Rezept> rezeptList) {
        super(context, layoutResourceId, rezeptList);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.rezeptList = rezeptList;
    }

    private class RezeptHolder{
        ImageView rezept_Foto;
        TextView rezept_Titel;
        TextView rezept_Like;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        RezeptHolder rezeptHolder = null;

        if (row == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layoutResourceId, parent, false);

            rezeptHolder = new RezeptHolder();
            rezeptHolder.rezept_Foto = (ImageView) row.findViewById(R.id.imageView_Rezept_Foto);
            rezeptHolder.rezept_Titel = (TextView) row.findViewById(R.id.textView_Rezept_Titel);
            rezeptHolder.rezept_Like = (TextView) row.findViewById(R.id.textView_Rezept_Like);

            row.setTag(rezeptHolder);
        }
        else {
            rezeptHolder = (RezeptHolder)row.getTag();
        }

        Rezept rezept = rezeptList.get(position);
        rezeptHolder.rezept_Foto.setImageResource(rezept.getFoto());
        rezeptHolder.rezept_Titel.setText(rezept.getTitel());
        rezeptHolder.rezept_Like.setText(String.valueOf(rezept.getLikes()));

        return row;
    }
}
