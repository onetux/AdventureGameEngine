/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

/**
 *
 * @author Marek Priban
 */
public class Commands {
 
    /**
     * Private constructor.
     */
    private Commands(){
    }
    /**
     * Array of all commands allowed in game.
     */
    private static final String[] commands ={
        "vlevo",
        "vpravo",
        "nahoru",
        "dolu",
        "zvedni",
        "poloz",
        "inventar"
    };
    /**
     * Methods to get command if exist.
     * @param command you want to check if exist.
     * @return true index of the same index as param command
     *         or -1 if command was not found.
     */
    public static int getCommand(String command){
        for(int i = 0; i < commands.length; i++){
            if(commands[i].toLowerCase().equals(command.toLowerCase())) {
                return i;
            }
         }
        return -1;
    }
    
    
}
