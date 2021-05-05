package model.database.loadSaveStrategy;


import java.util.HashMap;
import java.util.Map;

public interface LoadSaveStrategy<Key,Value> {

    public Map<Key, Value> load(String filenaam);
    public void save(String filename, HashMap<Key, Value> lijst);
}
