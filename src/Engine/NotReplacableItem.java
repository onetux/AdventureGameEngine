/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

/**
 *
 * @author Marek Priban
 */
public class NotReplacableItem extends Item{
  /**
     * Constructor of subclass.
     *
     * @param name of Item.
     */
    public NotReplacableItem(String name) {
        super(name);
    }
    /**
     * Implements Usable interface - notreplacable items.
     * @return false
     */
    @Override
    public boolean isUsable() {
        return false;
    }
    
    
}
