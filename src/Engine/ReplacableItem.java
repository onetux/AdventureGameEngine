/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

/**
 *
 * @author Marek Priban
 */
public class ReplacableItem extends Item {

    /**
     * Constructor of subclass.
     *
     * @param name of Item.
     */
    public ReplacableItem(String name) {
        super(name);
    }
    /**
     * Implements Usable interface - replacable items.
     * @return false
     */
    @Override
    public boolean isUsable() {
        return true;
    }
}
