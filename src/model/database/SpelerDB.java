package model.database;

import model.domain.Speler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * @Author team
 */
public class SpelerDB {
    Map<String, Speler> spelers;


    public SpelerDB() throws FileNotFoundException {
        this.spelers = new HashMap<>();
        scanFile();
    }

    public void scanFile() {
        try {
            File spelersFile = new File("src/bestanden/speler.txt");
            Scanner scanner = new Scanner(spelersFile);
            while (scanner.hasNextLine()) {
                String regel = scanner.nextLine();
                List<String> lijst = Arrays.asList(regel.split(","));
                Speler speler = new Speler(lijst.get(1), lijst.get(0), lijst.get(2), Double.parseDouble(lijst.get(3)));
                spelers.put(speler.getSpelersnaam(),speler);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveFile(){
        try{
            FileWriter fileWriter = new FileWriter("../../bestanden/speler.txt");
/*            Iterator<String> spelerIterator = spelers.keySet().iterator();
            while(spelerIterator.hasNext()){
                String key = spelerIterator.next();
                Speler s = spelers.get(key);
                fileriter.write(speler.toTextBestand());
            }*/

            for(Map.Entry mapElement : spelers.entrySet()){
                Speler speler = (Speler)mapElement.getValue();
                fileWriter.write(speler.toTextBestand());
            }
            fileWriter.close();
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public Map<String, Speler> getSpelers() {
        return spelers;
    }
}
