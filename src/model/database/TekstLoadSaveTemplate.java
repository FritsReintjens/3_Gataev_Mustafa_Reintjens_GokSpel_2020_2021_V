package model.database;

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

    public void save(String filename, HashMap<Key, Value> lijst) {
        try {
            FileWriter fileWriter = new FileWriter("src/bestanden/" + filename + ".txt");
            for (Map.Entry mapElement : lijst.entrySet()) {
                fileWriter.write(mapElement.getValue().toString()); //Voor Speler klasse hebben we een methode toTextBestand() geschreven, hoe kunnen we zo iets doen voor alle objecten?
            }
            fileWriter.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public Map<Key, Value> load(String filename){
        Map<Key, Value> lijst = new HashMap<>();
        try {
            File file = new File("/src/bestanden/" + filename + ".txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String regel = scanner.nextLine();
                Value o = objectVanString(); //We zouden in de Speler klasse een methode tekstNaarSpeler(String tekst) kunnen schrijven, maar hoe doe je het algemeen voor alle objecten?
                lijst.put(o.getKey(), o); //Maak een getKey() methode die de key van een object teruggeeft (voor speler spelersnaam)
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return lijst;
    }
}
