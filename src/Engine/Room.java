/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * Represents place/room in game.
 * @author Marek Priban
 */
public class Room implements IDirections{
    /**
     * Name of room.
     */
    protected String name;
    /**
     * Description of room for better player orientation.
     */
    protected String description;
    /**
     * Collection of items in room.
     */
    protected ArrayList<Item> items;
    /**
     * Room on the left side.
     */
    private Room leftRoom;
    /**
     * Room on the right side.
     */
    private Room rightRoom;
    /**
     * Room on the upper side.
     */
    private Room upperRoom;
    /**
     * Room on the down side.
     */
    private Room downRoom;

    /**
     * Room constructor for room without escape.
     * Escapes can be added through setLeft etc. methods.
     * @param name
     * @param description without items in room.
     */
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.leftRoom = null;
        this.rightRoom = null;
        this.downRoom = null;
        this.upperRoom = null;
        this.items = new ArrayList<Item>();
    }
    /**
     * 
     * @param name
     * @param description without items in room
     * @param leftRoom room on the left path from this room.
     * @param rightRoom room on the right path.
     * @param upperRoom room on the up path.
     * @param downRoom room on the down path.
     */
    public Room(String name, String description,
                Room leftRoom, Room rightRoom,
                Room upperRoom, Room downRoom) {
        this.name = name;
        this.description = description;
        this.leftRoom = leftRoom;
        this.rightRoom = rightRoom;
        this.upperRoom = upperRoom;
        this.downRoom = downRoom;
        this.items = new ArrayList<Item>();
    }
    
    /**
     * Add item.
     * @param item 
     */
    public void addItem(Item item){
        this.items.add(item);
    }
    /**
     * Delete item on specified index.
     * @param index
     */
    public void delItem(int index){
        this.items.remove(index);        
    }
    /**
     * 
     * @return text representation of room.
     */
    @Override
    public String toString() {
        return "Jste v mistnosti nazvane "+ name +
                ". " + description + "." + this.printItems();
    }
    /**
     * Print items if any exists.
     * @return text representation of items in room.
     */
    private String printItems(){
        String itemsToText;
        
        if(this.items.isEmpty()){
            itemsToText = "";
        }else{        
        itemsToText = "V mistnosti je take nekolik predmetu ";
           Iterator iterator = this.items.iterator();
          while(iterator.hasNext()){
            Object object = iterator.next();
             itemsToText += object.toString()+ ",";
          }
          itemsToText += ".";
        }
        return itemsToText;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Room getLeftRoom() {
        return leftRoom;
    }

    public void setLeftRoom(Room leftRoom) {
        this.leftRoom = leftRoom;
    }

    public Room getRightRoom() {
        return rightRoom;
    }

    public void setRightRoom(Room rightRoom) {
        this.rightRoom = rightRoom;
    }

    public Room getUpperRoom() {
        return upperRoom;
    }

    public void setUpperRoom(Room upperRoom) {
        this.upperRoom = upperRoom;
    }

    public Room getDownRoom() {
        return downRoom;
    }

    public void setDownRoom(Room downRoom) {
        this.downRoom = downRoom;
    }

    @Override
    public boolean left() {
        if(this.leftRoom == null){
            return false;
        }
        return true;    
    }

    @Override
    public boolean right() {
          if(this.rightRoom == null){
            return false;
        }
        return true;  
    }

    @Override
    public boolean up() {
          if(this.upperRoom == null){
            return false;
        }
        return true;  
    }

    @Override
    public boolean down() {
          if(this.downRoom == null){
            return false;
        }
        return true;  
    }
    
    
   
    
}
