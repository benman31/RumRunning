import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * A driver class for the RumInventoryTunnel class. Takes an integer as input indicating  the number of commands
 * that the console should expect. Commands follow the format 'add X Y' and 'remove X' where X can be either A, B or C
 * and Y is an integer from 0 to 100. The user can type -1 (or any negative integer) to finish
 */
public class RumRunner {
    public static void main(String[] args) {

        final int MAX_VOLUME = 100;
        final int MIN_VOLUME = 0;

        RumInventoryTunnel rumRunner = new RumInventoryTunnel();

        boolean done = false;

        while(!done){
            System.out.println("Please enter the number of commands you wish to perform, or enter -1 to quit");

            Scanner in = new Scanner(System.in);
            int numOfCommands = in.nextInt();
            in.nextLine();

            System.out.println("Please enter " + numOfCommands + " command(s).");
            List<String> coms = new ArrayList<>();

            while (numOfCommands > 0) {
                String input = in.nextLine();
                coms.add(input.toLowerCase());
                numOfCommands--;
            }
            for (String command: coms) {
                Scanner lineScan = new Scanner(command);
                List<String> commandString = new ArrayList<>();
                while(lineScan.hasNext()){
                    commandString.add(lineScan.next());
                }
                lineScan.close();

                if (commandString.get(0).equals("add")) {
                    if (commandString.get(1).equals("a")){
                        errorCheck(Integer.parseInt(commandString.get(2)), MAX_VOLUME, MIN_VOLUME);
                        rumRunner.addA(Integer.parseInt(commandString.get(2)));
                    }
                    else if (commandString.get(1).equals("b")){
                        errorCheck(Integer.parseInt(commandString.get(2)), MAX_VOLUME, MIN_VOLUME);
                        rumRunner.addB(Integer.parseInt(commandString.get(2)));
                    }
                    else if (commandString.get(1).equals("c")){
                        errorCheck(Integer.parseInt(commandString.get(2)), MAX_VOLUME, MIN_VOLUME);
                        rumRunner.addC(Integer.parseInt(commandString.get(2)));
                    }
                    else throw new IllegalArgumentException("Invalid Command");
                }
                else if (commandString.get(0).equals("remove")){
                    if (commandString.get(1).equals("a")) {
                        rumRunner.removeA();
                    }
                    else if (commandString.get(1).equals("b")){
                        rumRunner.removeB();
                    }
                    else if (commandString.get(1).equals("c")){
                        rumRunner.removeC();
                    }
                    else throw new IllegalArgumentException("Invalid Command");
                }
                else throw new IllegalArgumentException("Invalid Command");
            }
            if (numOfCommands < 0 ) {done = true;}
        }

    }

    /**
     * Throws an exception if amtOfRum is less than min or greater than max
     * @param amtOfRum the amount of rum to be added to a Barrel
     * @param max the maximum amount of rum allowed
     * @param min the minimum amount of rum allowed
     */
    public static void errorCheck(int amtOfRum, int max, int min){
        if (amtOfRum < min || amtOfRum > max){
            throw new IllegalArgumentException("Volume must be an integer from 0 to 100");
        }
    }
}
