
package respository;

import model.GarbageTruck;

public interface ICollectingGarbageRepository {
    void getInput(GarbageTruck g);

    void printTheCost(GarbageTruck g);
}
