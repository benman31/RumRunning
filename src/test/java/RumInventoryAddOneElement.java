import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit-tests related to adding a single element to the RumInventory
 */
public class RumInventoryAddOneElement {

    RumInventoryTunnel rit;

    @Before
    public void init() {
        rit = new RumInventoryTunnel();
    }

//#########################################################################
// Simple tests for basic set-up - adding a single element
//#########################################################################
    @Test
    public void addARemoveA() {
        rit.addA(10);

        assertEquals(10, rit.removeA());
    }

    @Test
    public void addARemoveB() {
        rit.addA(10);

        assertEquals(10, rit.removeB());
    }

    @Test
    public void addARemoveC() {
        rit.addA(10);

        assertEquals(10, rit.removeC());
    }

    @Test
    public void addAGet0() {
        rit.addA(10);
        assertEquals(10, rit.get(0));
    }

    @Test
    public void addAIterateNext() {
        rit.addA(10);
        assertEquals(10, (int)rit.iterator().next());
    }

    @Test
    public void addAIteratehasNext() {
        rit.addA(10);
        assertTrue(rit.iterator().hasNext());
    }

    @Test
    public void addBRemoveA() {
        rit.addB(10);
        assertEquals(10, rit.removeA());
    }

    @Test
    public void addBRemoveB() {
        rit.addB(10);


        assertEquals(10, rit.removeB());
    }

    @Test
    public void addBRemoveC() {
        rit.addB(10);


        assertEquals(10, rit.removeC());
    }

    @Test
    public void addBGet0() {
        rit.addB(10);
        assertEquals(10, rit.get(0));
    }

    @Test
    public void addBIterateNext() {
        rit.addB(10);
        assertEquals(10, (int)rit.iterator().next());
    }

    @Test
    public void addBIteratehasNext() {
        rit.addB(10);
        assertTrue(rit.iterator().hasNext());
    }

    @Test
    public void addCRemoveA() {
        rit.addC(10);

        assertEquals(10, rit.removeA());
    }

    @Test
    public void addCRemoveB() {
        rit.addC(10);


        assertEquals(10, rit.removeB());
    }

    @Test
    public void addCRemoveC() {
        rit.addC(10);


        assertEquals(10, rit.removeC());
    }

    @Test
    public void addCGet0() {
        rit.addC(10);
        assertEquals(10, rit.get(0));
    }

    @Test
    public void addCIterateNext() {
        rit.addC(10);
        assertEquals(10, (int)rit.iterator().next());
    }

    @Test
    public void addCIteratehasNext() {
        rit.addC(10);
        assertTrue(rit.iterator().hasNext());
    }


}
