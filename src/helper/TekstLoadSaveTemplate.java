package helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author team
 */
public abstract class TekstLoadSaveTemplate<Key, Value> {

    public final void save(String filename, HashMap<Key, Value> lijst) {
        try {
            FileWriter fileWriter = new FileWriter("src/bestanden/" + filename + ".txt");
            for (Map.Entry mapElement : lijst.entrySet()) {
                fileWriter.write(toBestand(mapElement.getValue())); //Voor Speler klasse hebben we een methode toTextBestand() geschreven, hoe kunnen we zo iets doen voor alle objecten?
            }
            fileWriter.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public final Map<Key, Value> load(String filename){
        Map<Key, Value> lijst = new HashMap<>();
        try {
            File file = new File("src/bestanden/" + filename + ".txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String regel = scanner.nextLine();
                Value o = objectVanString(regel);
                lijst.put(getKeyOfObject(o), o);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lijst;
    }

    //Deze moeten geimplementeerd worden in de subklassen van deze klasse
    //operation1
    protected abstract Value objectVanString(String regel);

    //operation2
    protected abstract Key getKeyOfObject(Value o);

    //operation3
    protected abstract String toBestand(Object o);
}
