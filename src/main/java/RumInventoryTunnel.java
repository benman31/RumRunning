import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 Add comments about this class here
 it is currently just stubs methods waiting to be completed
 */
public class RumInventoryTunnel implements Tunnel{

    private final int MAX_TUNNEL_CAPACITY;
    public final int MAX_VOLUME;
    public final int MIN_VOLUME;

    private int size;
    private Barrel first;
    private Barrel middle;
    private Barrel last;

    /**
     * Constructs empty RumInventoryTunnel
     */
    public RumInventoryTunnel() {
        MAX_TUNNEL_CAPACITY = 1000000000;
        MAX_VOLUME = 100;
        MIN_VOLUME = 0;
        size = 0;
        first = null;
        middle = null;
        last = null;
    }

    /**
     * Add a barrel with amtOfRum to the tunnel from House A
     * This method runs in O(1) time
     * @param amtOfRum the amount of rum in this barrel
     */
    public void addA(int amtOfRum) {
        if (amtOfRum < MIN_VOLUME || MAX_VOLUME < amtOfRum){
            throw new IllegalArgumentException("Argument must be integer between 0 and 100 inclusive");
        }
        if (size == MAX_TUNNEL_CAPACITY){throw new IndexOutOfBoundsException("Maximum Tunnel capacity reached");}
        Barrel newBarrel = new Barrel();
        newBarrel.volume = amtOfRum;
        newBarrel.next = first;
        newBarrel.previous = null;
        if(first == null){
            last = newBarrel;
            middle = newBarrel;
        }
        else{first.previous = newBarrel;}
        first = newBarrel;
        size++;
        if (size == 2){
            middle = first;
            last = first.next;
        }
        else if (size == 3){
            middle = first.next;
            last = middle.next;
        }
        else if (size > 3 && size % 2 == 0){
            middle = middle.previous;
        }
    }

    /**
     * Remove a barrel from the tunnel through House A
     * This method runs in O(1) time
     * throws NoSuchElement exception if the tunnel is empty
     * @return the amount of rum in the barrel that is removed
     */
    public int removeA() {
        if (first == null){throw new NoSuchElementException();}
        int amtOfRum = first.volume;
        first = first.next;
        if (first == null){
            middle = null;
            last = null;
        }
        else{first.previous = null;}

        size--;
        if (size == 1){
            middle = first;
            last = first;
        }
        else if (size == 2){
            middle = first;
            last = first.next;
        }
        else if (size == 3){
            middle = first.next;
            last = middle.next;
        }
        else if (size > 3 && size % 2 == 1){
            middle = middle.next;
        }
        return amtOfRum;
    }

    @Override
    public void addB(int amtOfRum) {

    }

    @Override
    public int removeB() {
        return 0;
    }

    /**
     * Add a barrel with amtOfRum to the tunnel from House C
     * This method runs in O(1) time
     * @param amtOfRum the amount of rum in this barrel
     */
    public void addC(int amtOfRum) {
        if (amtOfRum < MIN_VOLUME || MAX_VOLUME < amtOfRum){
            throw new IllegalArgumentException("Argument must be integer between 0 and 100 inclusive");
        }
        if (size == MAX_TUNNEL_CAPACITY){throw new IndexOutOfBoundsException("Maximum Tunnel capacity reached");}
        Barrel newBarrel = new Barrel();
        newBarrel.volume = amtOfRum;
        newBarrel.previous = last;
        newBarrel.next = null;
        if(last == null){
            first = newBarrel;
            middle = newBarrel;
        }
        else{last.next = newBarrel;}
        last = newBarrel;
        size++;

        if (size == 2){
            middle = last.previous;
            first = last.previous;
        }
        else if (size == 3){
            middle = last.previous;
            first = middle.previous;
        }
        else if (size > 3 && size % 2 == 1){
            middle = middle.next;
        }

    }
    /**
     * Remove a barrel from the tunnel through House C
     * This method runs in O(1) time
     * throws NoSuchElement exception if the tunnel is empty
     * @return the amount of rum in the barrel that is removed
     */
    public int removeC() {
        if (last == null){throw new NoSuchElementException();}
        int amtOfRum = last.volume;
        last = last.previous;
        if (last == null){
            middle = null;
            first = null;
        }
        else{last.next = null;}

        size--;
        if (size == 1){
            middle = last;
            first = last;
        }
        else if (size == 2){
            middle = last.previous;
            first = last.previous;
        }
        else if (size == 3){
            middle = last.previous;
            first = middle.previous;
        }
        else if (size > 3 && size % 2 == 0){
            middle = middle.previous;
        }
        return amtOfRum;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int get(int index) {
        return 0;
    }

    class Barrel{

        public int volume;
        public Barrel next;
        public Barrel previous;
    }

    /**
     * A helper method that decrements the size of the Barrel list and updates the first, middle and last references
     */
    private void downSize(){
        size--;
        if (size == 1){
            middle = first;
            last = first;
        }
        else if (size == 2){
            middle = first;
            last = first.next;
        }
        else if (size == 3){
            middle = first.next;
            last = middle.next;
        }
        else if (size > 3 && size % 2 == 1){
            middle = middle.next;
        }
    }

    /**
     * A helper method that increments the size of the Barrel list and updates the first, middle and last references
     */
    private void upSize(){
        size++;
        if (size == 2){
            middle = first;
            last = first.next;
        }
       else if (size == 3){
            middle = first.next;
            last = middle.next;
        }
        else if (size > 3 && size % 2 == 0){
            middle = middle.previous;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        //this just added to allow the code to compile
        //remove this an replace with proper solution
        return Collections.singletonList(0).iterator();
    }
}
