/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.util.ArrayList;
/**
 * Player of the game.
 * @author Marek Priban
 */
public class Player {
    /**
     * Name of player.
     */
    private String name;
    /**
     * Actual position of player.
     */
    private Room positon;
    /**
     * Items that player hold.
     */
    private ArrayList<Item> bag;
    // Singletone? 
    private Player() {
        this.bag = new ArrayList<Item>();
    }
    
    public static Player getInstance() {
        return PlayerHolder.INSTANCE;
    }
   
    private static class PlayerHolder {

        private static final Player INSTANCE = new Player();
    }
    /*
    public Player(String name){
        this.name = name;  
    }
    */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Sets position of the player.
     * @param positon new position of the player.
     */
    public void setPositon(Room positon) {
        this.positon = positon;
    }
    /**
     * Get position of player.
     * @return postion of the player.
     */
    public Room getPositon() {
        return positon;
    }
    /**
     * 
     * @param item
     * @return true if item was picked up.
     */
    public boolean pickUp(String item) {
        return ItemManager.manage(item, positon, bag, 1);
    }
    /**
     * Put down item from bag to actual room.
     * @param item name of item.
     * @return true if item was putted down.
     */
    public boolean putDown(String item){
        return ItemManager.manage(item, this.positon, this.bag, 2);
    }
    public void inventory(){
        System.out.println("V batohu - "+this.bag.toString());
    }
    public void goLeft(){
        //Can go left?
        if(this.positon.left()){
           //go left
           this.setPositon(this.positon.getLeftRoom());
        }else{
           System.out.println("Doleva cesta nevede.");
        }
    }
    public void goRight(){
         //Can go right?
        if(this.positon.right()){
           //go right
           this.setPositon(this.positon.getRightRoom());
        }else{
           System.out.println("Doprava cesta nevede.");
        }
    }
    public void goUp(){
         //Can go up?
        if(this.positon.up()){
           //go up
           this.setPositon(this.positon.getUpperRoom());
        }else{
           System.out.println("Nahoru cesta nevede.");
        }
    }
    public void goDown(){
         //Can go down?
        if(this.positon.down()){
           //go down
           this.setPositon(this.positon.getDownRoom());
        }else{
           System.out.println("Dolu cesta nevede.");
        }
    }
    
    
    
    
}
