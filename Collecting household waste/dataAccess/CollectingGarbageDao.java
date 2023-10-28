
package dataAccess;

import common.Library;
import java.util.ArrayList;
import model.GarbageStation;
import model.GarbageTruck;

public class CollectingGarbageDao {
    Library l = new Library();
    private static CollectingGarbageDao instance = null;

    public static CollectingGarbageDao Instance() {
        if (instance == null)
            synchronized (CollectingGarbageDao.class) {
                if (instance == null)
                    instance = new CollectingGarbageDao();
            }
        return instance;
    }

    // public void getFakeInput(ArrayList<GarbageStation> garbageStations) {
    // 1765 2808 952 4206 3102 3902 1292 3985 8324 1928 4426 397 3277
    // garbageStations.add(new GarbageStation(1, 1765));
    // garbageStations.add(new GarbageStation(2, 2808));
    // garbageStations.add(new GarbageStation(3, 952));
    // garbageStations.add(new GarbageStation(4, 4206));
    // garbageStations.add(new GarbageStation(5, 3102));
    // garbageStations.add(new GarbageStation(6, 3902));
    // garbageStations.add(new GarbageStation(7, 1292));
    // garbageStations.add(new GarbageStation(8, 3985));
    // garbageStations.add(new GarbageStation(9, 8324));
    // garbageStations.add(new GarbageStation(10, 1928));
    // garbageStations.add(new GarbageStation(11, 4426));
    // garbageStations.add(new GarbageStation(12, 397));
    // garbageStations.add(new GarbageStation(13, 3277));
    // }
    public void enterInput(ArrayList<GarbageStation> garbageStations) {
        int id = generateId(garbageStations);
        int amount = l.getInt("Amount: ");
        garbageStations.add(new GarbageStation(id, amount));
    }

    public void getInput(GarbageTruck g) {
        enterInput(g.getGarbageStations());
        // getFakeInput(g.getGarbageStations());
        System.out.println("Added successfully");
    }

    public void printTheCost(GarbageTruck g) {
        System.out.println(g);
    }

    private int generateId(ArrayList<GarbageStation> garbageStations) {
        return garbageStations.size() + 1;
    }
}
