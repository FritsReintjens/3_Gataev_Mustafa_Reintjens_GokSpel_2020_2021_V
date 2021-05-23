package model.database;

import model.StrategyData;
import model.gokstrategy.GokStrategyEnum;

import java.util.HashMap;
import java.util.Map;

public class GokStrategyDB {
    private Map<String, StrategyData> strategyData;

    public GokStrategyDB(){
        this.strategyData = new HashMap<>();
        for (GokStrategyEnum gokStrategyEnum : GokStrategyEnum.values()){
            this.strategyData.put(gokStrategyEnum.getKlassenaamSimpel(),new StrategyData(gokStrategyEnum.getKlassenaamSimpel()));
        }
    }
    public Map<String, StrategyData> getStrategyData() {
        return strategyData;
    }
}
