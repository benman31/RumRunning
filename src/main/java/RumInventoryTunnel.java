import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 RumInventoryTunnel is a doubly LinkedList with the addition of a middle reference which allows nodes (called Barrels)
 to be added to the middle of the LinkedList in addition to the typical methods for adding to the first and last positions
 of the list. The class makes use of private internal classes for the node (Barrel class) and iterator(TunnelIterator).
 The iterator is one-directional from nodes 0 to N and serves only to support the get() method which allows a
 node at a given index to be accessed and the data retrieved. All add and remove methods operate with a constant number
 of primitive operations therefore they are all O(1). The get method is O(n) because in the worst case must iterate through
 n-1 elements to reach a given index.
 */
public class RumInventoryTunnel implements Tunnel{

    private final int MAX_TUNNEL_CAPACITY;

    private int size;
    private Barrel first;
    private Barrel middle;
    private Barrel last;

    /**
     * Constructs empty RumInventoryTunnel
     */
    public RumInventoryTunnel() {
        MAX_TUNNEL_CAPACITY = 1000000000;
        size = 0;
        first = null;
        middle = null;
        last = null;
    }

    /**
     * Add a barrel with amtOfRum to the tunnel from House A and adjust neighboring reference variables
     * This method runs in O(1) time
     * @param amtOfRum the amount of rum in this barrel
     */
    public void addA(int amtOfRum) {
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
     * Removes a barrel from the tunnel through House A, returns the volume of rum in the removed barrel
     *      * and adjusts neighboring reference variables
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
            middle = middle.next;
        }
        return amtOfRum;
    }

    /**
     * Add a barrel with amtOfRum to the tunnel from House B and adjust neighboring reference variables
     * This method runs in O(1) time
     * @param amtOfRum the amount of rum in this barrel
     */
    public void addB(int amtOfRum) {
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
     * Removes a barrel from the tunnel through House B, returns the volume of rum in the removed barrel
     * and adjusts neighboring reference variables
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
     * Add a barrel with amtOfRum to the tunnel from House C and adjust neighboring reference variables
     * This method runs in O(1) time
     * @param amtOfRum the amount of rum in this barrel
     */
    public void addC(int amtOfRum) {
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
     * Removes a barrel from the tunnel through House C, returns the volume of rum in the removed barrel
     * and adjusts neighboring reference variables
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
            middle = middle.previous;
        }
        return amtOfRum;
    }

    /**
     * Get the size of the rum barrel inventory
     * @return the number of barrels in the tunnel
     */
    public int size() {
        return size;
    }

    /**
     * Get a barrel of rum at a given index and return its volume
     * @param index the index from 0 to N of the barrel to be retreived
     * @return volume of the barrel of rum
     */
    public int get(int index) {
        if (size == 0){throw new NoSuchElementException("Tunnel is empty");}
        else if (index > size -1 ){throw new NoSuchElementException("Index out of bounds");}
        else if (index < 0){throw new NoSuchElementException("Index out of bounds");}

        int result = 0;
        Iterator<Integer> tunnelIter = this.iterator();
        for (int i = 0; i <= index; i++){
            result = tunnelIter.next();
        }
        return result;
    }

    /**
     * An internal node class called Barrel, which stores position references to previous Barrels and next Barrels
     * along with the volume of rum contained in the barrel (the data value of the node)
     */
    private class Barrel{

        public int volume;
        public Barrel next;
        public Barrel previous;
    }

    /**
     * A method to instantiate a new TunnelIterator for the RumInventoryTunnel
     * @return a new TunnelIterator
     */
    public Iterator<Integer> iterator() {
        return new TunnelIterator();
    }

    /**
     * An internal iterator class that can only move sequentially in a list from 0 to N
     */
    private class TunnelIterator implements Iterator<Integer> {

        private Barrel position;

        public TunnelIterator(){
            position = null;
        }

        /**
         * A method that returns true if there is a barrel in the next position to the current barrel
         * @return return false if the next barrel is null, or true otherwise
         */
        public boolean hasNext() {
            if (position == null){
                return first != null;
            }
            else{
                return position.next != null;
            }
        }

        /**
         *A method that iterates through a list of barrels sequentially with each method call
         * @return the barrel in the next position to the current barrel;
         */
        public Integer next() {
            if(hasNext() == false){throw new NoSuchElementException();}

            if(position == null)
            {
                position = first;
            }
            else{
                position = position.next;
            }
            return position.volume;
        }
    }

}
