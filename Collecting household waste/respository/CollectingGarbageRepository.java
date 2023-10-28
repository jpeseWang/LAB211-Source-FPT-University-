
package respository;

import dataAccess.CollectingGarbageDao;
import model.GarbageTruck;

public class CollectingGarbageRepository implements ICollectingGarbageRepository {

    @Override
    public void getInput(GarbageTruck g) {
        CollectingGarbageDao.Instance().getInput(g);
    }

    @Override
    public void printTheCost(GarbageTruck g) {
        CollectingGarbageDao.Instance().printTheCost(g);
    }

}
