package model.database.loadSaveStrategy;


import jxl.read.biff.BiffException;
import jxl.write.WriteException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/**
 * @Author team
 */
public interface LoadSaveStrategy<Key,Value> {

    public Map<Key, Value> load(String filenaam) throws IOException, BiffException;
    public void save(String filename, HashMap<Key, Value> lijst) throws WriteException, IOException, BiffException;
}
