import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BonusTests {

    RumInventoryTunnel rit;

    //This class has some dependence on the size of the heap

    final int SMALL_TIMEOUT = RumInventoryTimingTests.SMALL_TIMEOUT;
    final int LARGE_TIMEOUT = SMALL_TIMEOUT * 20; //ALLOW SOME LEEWAY

    final int SMALL_MAX = 1000000;//1 MILLION!
    final int LARGE_MAX = 10 * SMALL_MAX;

    @Before
    public void init() {
        rit = new RumInventoryTunnel();
    }

//#########################################################################
// Bonus timing tests
//#########################################################################

    @Test(timeout=SMALL_TIMEOUT)
    public void randomAccessTests() {
        for (int i = 0; i < SMALL_MAX; i++) {
            rit.addC(i);
        }
        for(int i = 0; i < SMALL_MAX; i++){
            assertEquals(i, rit.get(i));
        }
    }

    @Test(timeout=LARGE_TIMEOUT)
    public void largeRandomAccessTests() {
        for (int i = 0; i < LARGE_MAX; i++) {
            rit.addC(i);
        }
        for(int i = 0; i < LARGE_MAX; i++){
            assertEquals(i, rit.get(i));
        }
    }


}