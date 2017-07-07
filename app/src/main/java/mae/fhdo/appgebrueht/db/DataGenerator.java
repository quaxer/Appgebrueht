package mae.fhdo.appgebrueht.db;

import android.content.Context;

import mae.fhdo.appgebrueht.R;
import mae.fhdo.appgebrueht.entities.Rezept;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Marvin Jakob.
 */

public class DataGenerator {
    public DataGenerator() {

    }

    public void generateData(Context context){
        RezeptManager rezeptManager = RezeptManager.getInstance(context);

        List<Integer> lasagneFotos = new ArrayList<Integer>();
        List<Integer> nudelsalatFotos = new ArrayList<Integer>();
        List<Integer> nudelauflaufFotos = new ArrayList<Integer>();
        List<Integer> spaghettiFotos = new ArrayList<Integer>();
        List<Integer> pizzaFotos = new ArrayList<Integer>();

        lasagneFotos.add(R.drawable.lasagne1);
        lasagneFotos.add(R.drawable.lasagne2);
        nudelsalatFotos.add(R.drawable.salat1);
        nudelsalatFotos.add(R.drawable.salat2);
        nudelsalatFotos.add(R.drawable.salat3);
        nudelauflaufFotos.add(R.drawable.lasagne3);
        spaghettiFotos.add(R.drawable.spaghetti1);
        spaghettiFotos.add(R.drawable.spaghetti2);
        spaghettiFotos.add(R.drawable.spaghetti3);
        pizzaFotos.add(R.drawable.pizza1);
        pizzaFotos.add(R.drawable.pizza2);
        pizzaFotos.add(R.drawable.pizza3);

        rezeptManager.addRezept(new Rezept("Lasagne", "Möhre, Sellerie, Zwiebel und Knoblauch putzen und in Würfel schneiden. Das Öl erhitzen, Würfel gut anbraten und wieder aus der Pfanne nehmen. \n" +
                "\n" +
                "Nun das Hackfleisch zur Hälfte zufügen und krümelig bzw. kross anbraten. Wieder aus der Pfanne nehmen und das restliche Hack anbraten. Das bereits gebratene Hack und Gemüse wieder zufügen, mit dem Wein ablöschen und fast verkochen lassen. Tomatenmark dazugeben, etwas angehen lassen und mit der Brühe auffüllen. Mit Deckel sämig einkochen lassen. Mit Salz, Pfeffer und einer Prise Zucker würzen.\n" +
                "\n" +
                "Für die Béchamel die Butter in einem Topf zerlassen. Das Mehl einrühren und kurz anschwitzen, dann unter Rühren nach und nach die Milch zugießen. Mit Muskat und Salz abschmecken und einmal aufkochen lassen.\n" +
                "\n" +
                "Eine Auflaufform fetten und mit Lasagneblättern belegen. Einige Löffel Béchamel darauf verteilen, mit etwas Parmesan bestreuen und etwas von der Bolognese darüber geben. So weiter schichten, bis alle Zutaten verbraucht sind. Die oberste Schicht sollte aus der Béchamelsauce bestehen, die gleichmäßig mit dem Parmesan bestreut wird.\n" +
                "\n" +
                "Im vorgeheizten Backofen bei 180 °C ca. 20 Minuten überbacken. Bevor die Lasagne portioniert wird, einige Minuten ruhen lassen.", lasagneFotos));
        rezeptManager.addRezept(new Rezept("Nudelsalat", "Die Nudeln nach Packungsanweisung kochen und unter kaltem Wasser abtropfen lassen. Gurken in Scheiben schneiden. Fleischwurst würfeln.\n" +
                "\n" +
                "In einer Schüssel Joghurt, Mayonnaise, Gurkenwasser, Hühnerbrühe, Paprikapulver und Knoblauchpulver vermischen und zu den Nudeln geben. Mais, Erbsen, Gurken und die Fleischwurst zu den Nudeln fügen und alle Zutaten miteinander vermengen.\n" +
                "\n" +
                "Dieser Nudelsalat muss nicht durchziehen. Guten Appetit." , nudelsalatFotos));
        rezeptManager.addRezept(new Rezept("Nudelauflauf", "Zuerst die Penne so lange in Salzwasser kochen, bis sie gut bissfest sind. Anschließend abtropfen lassen. \n" +
                "\n" +
                "Für die Sauce Olivenöl, Sahne, die ganze Tube Tomatenmark, Kräuter und Gewürze miteinander vermischen und mit Salz und Pfeffer abschmecken. Die Knoblauchzehen schälen, klein schneiden und zu der Sauce geben. Je nach Geschmack mehr oder weniger Olivenöl und Knoblauch beigeben.\n" +
                "\n" +
                "Die Nudeln mit der Sauce gut vermischen und in eine sehr große Auflaufform geben. 1/3 von der Käsemenge unter die Penne mischen. Anschließend die Tomaten vierteln und auf die Penne legen. Danach den Käse oben drüber streuen und in den Backofen schieben. \n" +
                "\n" +
                "Den Auflauf ca. 30 Minuten im vorgeheizten Backofen bei 180°C Umluft überbacken, bis der Käse schön zerlaufen ist. Sofort servieren." , nudelauflaufFotos));
        rezeptManager.addRezept(new Rezept("Spaghetti Bolognese", "In einem großen Topf Speck und Rosmarin in Olivenöl goldgelb anbraten. Zwiebeln und Knoblauch zugeben und 3 Minuten unter Rühren anschmoren. Dann Hackfleisch zugeben und anbraten. Danach Wein zugeben und die Flüssigkeit etwas reduzieren lassen. Dann Oregano, Möhren und Tomaten und n.B. etwas Tomatenmark zugeben. Mit Gewürzen, außer Basilikum, gut abschmecken, nochmals aufkochen, die Hitze fast ganz runter nehmen, Deckel drauf und 1,5 bis 2 Stunden leise köcheln lassen. \n" +
                "\n" +
                "Kurz vor Ende die Nudeln nach Packungsanleitung al dente kochen. In die fertige Sauce das frisch zerkleinerte Basilikum geben und mit frisch geriebenem Parmesan und Rotwein servieren." , spaghettiFotos));
        rezeptManager.addRezept(new Rezept("Vegetarische Pizza", "Mehl, Hefe, Salz, Zucker, das Ei, Milch, Olivenöl und das lauwarme Wasser in der Küchenmaschine etwa 12 Min. vermischen und gut durchkneten. Den Pizzateig mit einem Tuch bedecken und ca. 15 min ruhen lassen.\n" +
                "\n" +
                "Backofen auf 180°C vorheizen.\n" +
                "Den Teig sehr gut durchkneten und in 4 Stücke teilen. Pizza- oder Springform einfetten. Teig ausrollen oder mit den Fingern in die Form drücken. Den Pizzateig 5-8 Min. vorbacken.\n" +
                "\n" +
                "Zwiebeln und Knoblauch im heißen Olivenöl 2 Min. braten. Spinat dazu geben mit Salz, Pizzagewürz und Pfeffer würzen, verrühren und etwa 5 Min. köcheln lassen. Die Pilze schneiden und im heißen Ölivenöl ca. 2 Min. braten.\n" +
                "Den Pizzateig damit belegen, mit Käse bestreuen. 15-20 Min. backen, bis der Käse goldbraun ist." , pizzaFotos));
    }
}
