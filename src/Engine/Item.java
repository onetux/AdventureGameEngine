/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

/**
 * Superclass Item which subclasses can be added to rooms.
 * @author Marek Priban
 */
public abstract class Item implements IUsable{
    /**
     * Name of item.
     */
    protected String name;
    /**
     * Item constructor
     * @param name 
     */
    public Item(String name) {
        this.name = name;
    }
    
    /**
     * @return name of item
     */
    @Override
    public String toString() {
        return name;
    }
    
     
}
