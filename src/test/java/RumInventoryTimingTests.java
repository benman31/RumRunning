import org.junit.Before;
import org.junit.Test;

public class RumInventoryTimingTests {

    RumInventoryTunnel rit;

    //This class has some dependence on the size of the heap

    static final int SMALL_TIMEOUT = 60;//THIS SHOULD BE ADJUSTED AS PER THE COMPUTER RUNNING THE TESTS
    static final int LARGE_TIMEOUT = SMALL_TIMEOUT * 20; //ALLOW SOME LEEWAY

    final int SMALL_MAX = 1000000;//1 MILLION!
    final int LARGE_MAX = 10 * SMALL_MAX;

    @Before
    public void init() {
        rit = new RumInventoryTunnel();
    }

//#########################################################################
// General timing tests
//#########################################################################

    @Test (timeout=SMALL_TIMEOUT)//100 ms limit
    public void smallMaxAddsRemovesAtA() {
        for (int i = 0; i < SMALL_MAX; i++) {
            rit.addA(i);
        }
        for (int i = 0; i < SMALL_MAX; i++) {
            rit.removeA();
        }
    }

    @Test (timeout=SMALL_TIMEOUT)//100 ms limit
    public void smallMaxAddsRemovesAtB() {
        for (int i = 0; i < SMALL_MAX; i++) {
            rit.addB(i);
        }
        for (int i = 0; i < SMALL_MAX; i++) {
            rit.removeB();
        }
    }

    @Test (timeout=SMALL_TIMEOUT)//100 ms limit
    public void smallMaxAddsRemovesAtC() {
        for (int i = 0; i < SMALL_MAX; i++) {
            rit.addC(i);
        }
        for (int i = 0; i < SMALL_MAX; i++) {
            rit.removeC();
        }
    }

    @Test (timeout=LARGE_TIMEOUT)//100 ms limit
    public void largeMaxAddsRemovesAtA() {
        for (int i = 0; i < LARGE_MAX; i++) {
            rit.addA(i);
        }
        for (int i = 0; i < LARGE_MAX; i++) {
            rit.removeA();
        }
    }

    @Test (timeout=LARGE_TIMEOUT)//100 ms limit
    public void largeMaxAddsRemovesAtB() {
        for (int i = 0; i < LARGE_MAX; i++) {
            rit.addB(i);
        }
        for (int i = 0; i < LARGE_MAX; i++) {
            rit.removeB();
        }
    }

    @Test (timeout=LARGE_TIMEOUT)//100 ms limit
    public void largeMaxAddsRemovesAtC() {
        for (int i = 0; i < LARGE_MAX; i++) {
            rit.addC(i);
        }
        for (int i = 0; i < LARGE_MAX; i++) {
            rit.removeC();
        }
    }

}
