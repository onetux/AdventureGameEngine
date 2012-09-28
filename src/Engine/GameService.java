/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;


import java.util.NoSuchElementException;
import java.util.Scanner;



/**
 * Base class for handling game commands.
 * @author Marek Priban
 */
public abstract class GameService {
    /**
     * Running all game actions
     */
    public void doActions(){
        Player p;
        p = Player.getInstance();
        //show situation in game
        System.out.println(p.getPositon().toString());
        handleResponse();
    }
    /**
     * Handling response of player.
     */
    private void handleResponse(){
        Scanner scan = new Scanner(System.in);
        String typedCommand;
        int command;
        //read firts word from console - command.
        try{
            typedCommand = scan.next();
            command = Commands.getCommand(typedCommand);
            performCommand(command, scan);
        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }
    /**
     * Performing command typed by player of the game.
     * @param command scanned command from console
     * @param scan Scanner for read from console
     */
    private void performCommand(int command, Scanner scan){
        Player player = Player.getInstance();
        String item;
        
        switch(command){
            //vlevo
            case 0: player.goLeft(); break;
            //vpravo
            case 1: player.goRight(); break;
            //nahoru
            case 2: player.goUp(); break;
            //dolu
            case 3: player.goDown(); break;
            //zvedni
            case 4: {
                //read next word of command - name of item
                item = scan.nextLine();
                player.pickUp(item);
                break;
            }
            //poloz
            case 5:{
            //read next word of command - name of item
                item = scan.nextLine();
                player.putDown(item);
                break;
            }
            case 6: player.inventory(); break;
            default: System.out.println("Zadany prikaz neni platny");
}
    }
    
    /**
     * 
     * @return true if player win the game.
     */
    public abstract boolean checkVictory();
}
