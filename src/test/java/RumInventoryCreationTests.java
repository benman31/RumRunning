import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Unit-tests relating to creating a RumInventory Object and its initial properties
 */
public class RumInventoryCreationTests {

    RumInventoryTunnel rit;

    @Before
    public void init() {
        rit = new RumInventoryTunnel();
    }

    //#########################################################################
// Creation tests and exceptions
//#########################################################################
    @Test
    public void sizeZeroOnCreation() {
        assertEquals(0, rit.size());
    }

    @Test
    public void iteratorHasNextFalseOnCreation(){
        assertFalse(rit.iterator().hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void getExceptionTooLargeIndex() {
        rit.get(0);
    }

    @Test(expected = NoSuchElementException.class)
    public void getExceptionNegativeIndex() {
        rit.get(-1);
    }

    @Test(expected = NoSuchElementException.class)
    public void removeAFromEmpty() {
        rit.removeA();
    }

    @Test(expected = NoSuchElementException.class)
    public void removeBFromEmpty() {
        rit.removeB();
    }

    @Test(expected = NoSuchElementException.class)
    public void removeCFromEmpty() {
        rit.removeC();
    }


}
