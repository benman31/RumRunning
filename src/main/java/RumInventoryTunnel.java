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
            middle = first.next;
            last = first.next;
        }
        else if (size == 3){
            middle = first.next;
            last = middle.next;
        }
        else if (size > 3 && size % 2 == 1){
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
            middle = first.next;
            last = first.next;
        }
        else if (size == 3){
            middle = first.next;
            last = middle.next;
        }
        else if (size > 3 && size % 2 == 1){
            middle = middle.previous;
        }
        return amtOfRum;
    }

    /**
     * Add a barrel with amtOfRum to the tunnel from House B
     * This method runs in O(1) time
     * @param amtOfRum the amount of rum in this barrel
     */
    public void addB(int amtOfRum) {
        if (amtOfRum < MIN_VOLUME || MAX_VOLUME < amtOfRum){
            throw new IllegalArgumentException("Argument must be integer between 0 and 100 inclusive");
        }
        if (size == MAX_TUNNEL_CAPACITY){throw new IndexOutOfBoundsException("Maximum Tunnel capacity reached");}
        Barrel newBarrel = new Barrel();
        newBarrel.volume = amtOfRum;
        size++;
        if(size == 1){
            first = newBarrel;
            middle = newBarrel;
            last = newBarrel;
        }
        else if (size == 2){
            first.next = newBarrel;
            newBarrel.previous = first;
            middle = newBarrel;
            last = newBarrel;
        }
        else if (size == 3){
            newBarrel.previous = first;
            newBarrel.next = last;
            first.next = newBarrel;
            last.previous = newBarrel;
            middle = newBarrel;
        }
        else if(size % 2 == 0){
            newBarrel.next = middle.next;
            newBarrel.previous = middle;
            middle.next.previous = newBarrel;
            middle.next = newBarrel;
            middle = newBarrel;
        }
        else if (size % 2 == 1){
            newBarrel.next = middle;
            newBarrel.previous = middle.previous;
            middle.previous.next = newBarrel;
            middle.previous = newBarrel;
            middle = newBarrel;
        }

    }

    /**
     * Remove a barrel from the tunnel through House B
     * This method runs in O(1) time
     * throws NoSuchElement exception if the tunnel is empty
     * @return the amount of rum in the barrel that is removed
     */
    public int removeB() {
        if(middle == null){throw new NoSuchElementException();}
        int amtOfRum = middle.volume;

        if (size == 1){
            first = null;
            middle = null;
            last = null;
        }
        else if(size == 2){
            first.next = null;
            middle = first;
            last = first;
        }
        else if(size == 3){
            first.next = last;
            last.previous = first;
            middle = last;
        }
        else{
            middle.previous.next = middle.next;
            middle.next.previous = middle.previous;
            if (size % 2 == 1){
                middle = middle.next;
            }
            else if (size % 2 == 0){
                middle = middle.previous;
            }
        }
        size --;
        return amtOfRum ;
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
            middle = last;
            first = last.previous;
        }
        else if (size == 3){
            middle = last.previous;
            first = middle.previous;
        }
        else if (size > 3 && size % 2 == 0){
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
            middle = last;
            first = last.previous;
        }
        else if (size == 3){
            middle = last.previous;
            first = middle.previous;
        }
        else if (size > 3 && size % 2 == 0){
            middle = middle.next;
        }
        return amtOfRum;
    }

    /**
     * A simple getter method to return the size of the rum barrel inventory
     * @return the number of barrels in the tunnel
     */
    public int size() {
        return size;
    }

    @Override
    public int get(int index) {
        if (size == 0){throw new NoSuchElementException("Tunnel is empty");}
        else if (index > size -1 ){throw new NoSuchElementException("Index out of bounds, index must be between zero and" + (size -1));}
        else if (index < 0){throw new NoSuchElementException("Index out of bounds, index must be between zero and" + (size -1));}

        int result = 0;
        Iterator<Integer> tunnelIter = this.iterator();
        for (int i = 0; i <= index; i++){
            result = tunnelIter.next();
        }
        return result;
    }

    class Barrel{

        public Integer volume;
        public Barrel next;
        public Barrel previous;
    }

    @Override
    public Iterator<Integer> iterator() {

        return new TunnelIterator<>();
    }

    class TunnelIterator<Integer> implements Iterator<Integer> {

        private Barrel position;
        //private Barrel previous;
        //private boolean isAfterNext;

        public TunnelIterator(){
            position = null;
            //previous = null;
            //isAfterNext = false;
        }

        @Override
        public boolean hasNext() {
            if (position == null){
                return first != null;
            }
            else{
                return position.next != null;
            }
        }

        @Override
        public Integer next() {
            if(hasNext() == false){throw new NoSuchElementException();}
            //isAfterNext = true;
            //previous = position;

            if(position == null)
            {
                position = first;
            }
            else{
                position = position.next;
            }
            return (Integer) position.volume;
        }
    }

}
