/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

/**
 * Base class for concrete game.
 * @author Marek Priban
 */
public abstract class Game {
    /**
     * Concrete game service.
     */
    private GameService service;
    private Player player;

    /**
     * Game constructor.
     * @param service
     */
    public Game(GameService service) {
        this.service = service;
        this.player = Player.getInstance();
    }
    
    /**
     * Run the main game loop.
     */
    public void run(){
        do{
            service.doActions();
        }while(!service.checkVictory());
    }
}
