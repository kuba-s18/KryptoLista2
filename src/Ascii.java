import java.util.ArrayList;
import java.util.List;

public class Ascii {

    public ArrayList<Integer> ascii = new ArrayList<>();

    public Ascii() {

        ascii.add((int) ' ');
        ascii.add((int) '!');
        ascii.add((int) '.');
        ascii.add((int) ',');
        ascii.add((int) '?');
        ascii.add((int) ':');
        ascii.add((int) '-');
        ascii.add((int) ';');
        ascii.add((int) '(');
        ascii.add((int) ')');
        ascii.add((int) '"');
        ascii.add((int) ';');
        ascii.add((int) '\'');
        ascii.add((int) '+');


/*
        ascii.add((int) '%');
        ascii.add((int) '[');
        ascii.add((int) ']');
        ascii.add((int) '\'');
        ascii.add((int) '{');
        ascii.add((int) '}');
        ascii.add((int) '_');
*/

        //0-9
        for (int i = 48; i <= 57; i++) {
            ascii.add(i);
        }


        //A-Z
        for (int i = 65; i <= 90; i++) {
            ascii.add(i);
        }

        //a-z
        for (int i = 97; i <= 122; i++) {
            ascii.add(i);
        }


    }



    public List<Integer> getascii() {
        return ascii;
    }

}