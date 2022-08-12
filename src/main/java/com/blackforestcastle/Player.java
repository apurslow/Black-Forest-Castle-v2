package com.blackforestcastle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Player extends Character {

    private Room currentRoom;
    private int experiencePoints;
    private String name;

    public Player() {

    }
    public Player(Room theRoom){
        this();
        setCurrentRoom(theRoom);
    }

    public Player(Room theCurrentRoom, int theHp) {
        this(theCurrentRoom);
        super.setHP(theHp);
    }

    @Override
    public void attack(Character npc) {
        getPlayerAttackPower();
        int damageDone = getAttackPower() + randomNumber(10,0);
        npc.setHP(npc.getHP() - damageDone);
        UI.textPrint("You did " + damageDone + " damage. The enemies health now is " + npc.getHP());
    }

    public void heal()
    {
        this.setHP(getHP()+10);
        UI.textPrint("You have gained 10 health points!");
    }

    // helper for attack method
    public void getPlayerAttackPower() {
        // knife, sword, bow, arrow
        for (Item item : super.getInventory()) {
            if (item.getName().equals("bow")) {
                for (Item item0 : super.getInventory()) {
                    if (item0.getName().equals("arrows")) {
                        setAttackPower(15);
                    }
                }

            } else if (item.getName().equals("sword")) {
                setAttackPower(10);
            } else if (item.getName().equals("knife")) {
                setAttackPower(5);
            }

        }
    }

    public void showInventory() {
        System.out.print("Inventory: ");
        for (Item item : super.getInventory()) {
            System.out.print(item.getName() + ", ");
        }
        System.out.println();
    }

    public Item checkInventoryForItem(String item) {
        for (Item itemObject : super.getInventory()) {
            if (item.equals(itemObject.getName())) {
                return itemObject;
            }
        }
        return null;
    }

    public List<Item> getInventory() {
        return super.getInventory();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public int getExperiencePoints()
    {
        return experiencePoints;
    }

    public void addExperiencePoints(int experiencePoints)
    {
        this.experiencePoints = experiencePoints;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public String getName()
    {
        if(this.name == null)
            return "Anonymous";
        else return this.name;
    }

    public boolean keepsFighting()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter \"Q\" to exit the battle\nTo continue, enter any other key.");
        String input = scanner.nextLine();
        if(input.trim().equalsIgnoreCase("q"))
            return false;
        return true;
    }


}
