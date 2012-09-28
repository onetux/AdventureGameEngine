/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.util.ArrayList;

/**
 * Manager for manipulation with objects/items.
 * @author Marek Priban
 */
public class ItemManager {
    /**
     * Handling items manipulation.
     * @param item name of item
     * @param actRoom players position
     * @param playersBag players bag
     * @param operation 1 - pickUp, 2 - putDown
     */
    public static boolean manage(String item, Room actRoom,
                                  ArrayList<Item> playersBag,
                                  int operation){      
        switch(operation){
            //pickUp
            case 1: return pickUp(item, playersBag, actRoom);
            //putDown
            case 2: return putDown(item, playersBag, actRoom);
            default: {
                System.out.println("Operace není definována.");
            }
        }
        return false;
    }

    /**
     * Check if item is managable/moveable.
     * @param index of item in collection.
     * @param bag players bag.
     * @return true if item can be used/managed/moved.
     */
    private static boolean isUsable(int index, ArrayList<Item> bag){
        Item item = (Item) bag.get(index);
        return item.isUsable();
    }
    /**
     * Find index of item in collection.
     * @param item name of item.
     * @param bag players bag.
     * @return index of item or -1 if is not in bag.
     */
    private static int getIndex(String item, ArrayList<Item> bag){
        //return bag.indexOf(new ReplacableItem(item));
        Item tmp;
        for(int i = 0; i < bag.size(); i++){
            tmp = bag.get(i);
            if(tmp.toString().trim().equals(item.trim())) {
                return i;
            }
        }
        return -1;
        
    }
    /**
     * Put down item from bag to actual room.
     * @param item name of item to putDown.
     * @param bag players bag.
     * @param position actual position of player.
     * @return true if item was putted down.
     */
    private static boolean putDown(String item,
                                    ArrayList<Item> bag,
                                    Room position){
        int index;
        index = getIndex(item, bag);
        if(index != -1){
            if(isUsable(index, bag)){
                position.addItem((Item) bag.get(index));
                bag.remove(index);
                System.out.println("Předmět "+item+" byl položen");
                return true;
            }
            System.out.println("Předmět není možné položit.");
            return false;
        }
        System.out.println("Zadaný předmět v batohu není.");
        return false;
    }
    /**
     * Pick up item from room and put it in players bag.
     * @param item name of item.
     * @param bag players bag.
     * @param position players actual position.
     * @return true if item was picked up.
     */
    private static boolean pickUp(String item,
                                  ArrayList<Item> bag,
                                  Room position){
        int index;
        index = getIndex(item, position.getItems());
        if(index != -1){
            if(isUsable(index, position.getItems())){
                bag.add(position.getItems().get(index));
                position.getItems().remove(index);
                System.out.println("Předmět "+item+" byl zvednut");
                return true;
            }
            System.out.println("Předmět není možné zvednout.");
            return false;
        }
        System.out.println("Zadaný předmět v místnosti není.");
        return false;
    }
}
