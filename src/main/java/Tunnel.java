import java.util.Iterator;

/**
 * The Tunnel Interface
 */
public interface Tunnel extends Iterable<Integer>  {

    /**
     * Add a barrel with amtOfRum to the tunnel from House A
     * This method runs in O(1) time
     *
     * @param amtOfRum the amount of rum in this barrel
     **/
    public void addA(int amtOfRum);

    /**
     Remove a barrel from the tunnel through House A
     This method runs in O(1) time
     throws NoSuchElement exception if the tunnel is empty
     @return the amount of rum in the barrel that is removed
     **/
    public int removeA();

    /**
     Add a barrel with amtOfRum to the tunnel from House B
     This method runs in O(1) time
     @param amtOfRum the amount of rum in this barrel
     **/
    public void addB(int amtOfRum);

    /**
     Remove a barrel from the tunnel through House B
     This method runs in O(1) time
     throws NoSuchElement exception if the tunnel is empty
     @return the amount of rum in the barrel that is removed
     **/
    public int removeB();

    /**
     Add a barrel with amtOfRum to the tunnel from House C
     This method runs in O(1) time
     @param amtOfRum the amount of rum in this barrel
     **/
    public void addC(int amtOfRum);

    /**
     Remove a barrel from the tunnel through House C
     This method runs in O(1) time
     throws NoSuchElement exception if the tunnel is empty
     @return the amount of rum in the barrel that is removed
     **/
    public int removeC();


    /**
     return the number of barrels of rum in the tunnel
     **/
    public int size();


    /**
     Retrieve an iterator over the barrels in the order of their
     index position
     **/
    public Iterator<Integer> iterator();


    /**
     Access the barrel in index position index
     throws NoSuchElementException if this is not a valid index
     **/
    public int get(int index);

}