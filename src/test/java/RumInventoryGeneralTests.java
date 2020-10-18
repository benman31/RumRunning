import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Some general tests for the order of items in the RumInventory after
 * arbitrary insertions and removes from arbitray entrance points
 */
public class RumInventoryGeneralTests {

    RumInventoryTunnel rit;

    @Before
    public void init() {
        rit = new RumInventoryTunnel();
    }


//#########################################################################
// Adding two elements - ensure A is correct
//#########################################################################

    @Test
    public void removeAOn2ElementsAddAA() {
        rit.addA(1);
        rit.addA(2);

        assertEquals(2, rit.removeA());

    }

    @Test
    public void removeAOn2ElementsAddAB() {
        rit.addA(1);
        rit.addB(2);
        assertEquals(1, rit.removeA());
    }

    @Test
    public void removeAOn2ElementsAddBB() {
        rit.addB(1);
        rit.addB(2);
        assertEquals(1, rit.removeA());
    }

    @Test
    public void removeAOn2ElementsAddBC() {
        rit.addB(1);
        rit.addC(2);
        assertEquals(1, rit.removeA());
    }

    @Test
    public void removeAOn2ElementsAddCC() {
        rit.addC(1);
        rit.addC(2);
        assertEquals(1, rit.removeA());
    }

//#########################################################################
// Adding two elements - ensure the middle is correct
//#########################################################################

    @Test
    public void removeBOn2ElementsAddAA() {
        rit.addA(1);
        rit.addA(2);
        assertEquals(1, rit.removeB());

    }

    @Test
    public void removeBOn2ElementsAddAB() {
        rit.addA(1);
        rit.addB(2);
        assertEquals(2, rit.removeB());
    }

    @Test
    public void removeBOn2ElementsAddBB() {
        rit.addB(1);
        rit.addB(2);
        assertEquals(2, rit.removeB());
    }

    @Test
    public void removeBOn2ElementsAddBC() {
        rit.addB(1);
        rit.addC(2);
        assertEquals(2, rit.removeB());
    }

    @Test
    public void removeBOn2ElementsAddCC() {
        rit.addC(1);
        rit.addC(2);
        assertEquals(2, rit.removeB());
    }

//#########################################################################
// Adding two elements - ensure remove C is correct
//#########################################################################

    @Test
    public void removeCOn2ElementsAddAA() {
        rit.addA(1);
        rit.addA(2);
        assertEquals(1, rit.removeC());

    }

    @Test
    public void removeCOn2ElementsAddAB() {
        rit.addA(1);
        rit.addB(2);
        assertEquals(2, rit.removeC());
    }

    @Test
    public void removeCOn2ElementsAddBB() {
        rit.addB(1);
        rit.addB(2);
        assertEquals(2, rit.removeC());
    }

    @Test
    public void removeCOn2ElementsAddBC() {
        rit.addB(1);
        rit.addC(2);
        assertEquals(2, rit.removeC());
    }

    @Test
    public void removeCOn2ElementsAddCC() {
        rit.addC(1);
        rit.addC(2);
        assertEquals(2, rit.removeB());
    }

//#########################################################################
// A few More Complicated Tests
//#########################################################################

    @Test
    public void manyAddsAtA() {
        for (int i = 50; i >= 1; i--) {
            rit.addA(i);
        }
        int cnt = 1;
        for(int i : rit) {
            assertEquals(cnt, i);
            cnt++;
        }
    }


    @Test
    public void manyAddsAtB() {
        for (int i = 1; i < 10; i++) {
            rit.addB(i);
        }
        int [] solution = {1, 3, 5, 7, 9, 8, 6, 4, 2 };
        for(int i= 0; i < solution.length; i++) {
            assertEquals(solution[i], rit.removeA());
        }
    }

    @Test
    public void manyAddsAtC() {
        for (int i = 1; i < 10; i++) {
            rit.addC(i);
        }
        for(int i= 1; i < 10; i++) {

            assertEquals(i, rit.removeA());
        }
    }

    @Test
    public void mixedAdds() {
        final int MAX = 4;
        for (int i = 1; i < MAX; i++) {
            rit.addA(i);
            rit.addB(i+2*MAX);
            rit.addC(i+3*MAX);
        }
        int[] solution = {3, 2, 1, 10, 11, 9, 13, 14, 15};
        int cnt = 0;
        for(int i : rit) {
            assertEquals(solution[cnt], i);
            cnt++;
        }
    }

    @Test
    public void manyRemovesAtB() {
        final int MAX = 4;
        for (int i = 1; i < MAX; i++) {
            rit.addA(i);
            rit.addB(i+2*MAX);
            rit.addC(i+3*MAX);
        }
        ArrayList<Integer> solution = new ArrayList<>(Arrays.asList(3, 2, 1, 10, 11, 9, 13, 14, 15));
        int mid = solution.size()/2;

        for (int i = 1; i < 4; i++) {
            int ans = solution.get(mid);
            assertEquals( ans, rit.removeB());
            solution.remove(mid);
            mid = solution.size()/2;
        }

    }


    @Test
    public void getRandomTest() {
        for (int i = 0; i < 10; i++) {
            rit.addC(i);
        }
        for (int i = 0; i < 10; i++) {
            assertEquals(i, rit.get(i));
        }
    }
}
