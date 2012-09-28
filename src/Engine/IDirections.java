/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

/**
 * Defines possible/allowed directions from Rooms.
 * @author Marek Priban
 */
public interface IDirections {
    /**
     * 
     * @return true if left way is possible.
     */
    boolean left();
    /**
     * 
     * @return true if right way is possible.
     */
    boolean right();
    /**
     * 
     * @return true if up way is possible.
     */
    boolean up();
    /**
     * 
     * @return true if down way is possible.
     */
    boolean down();
}
