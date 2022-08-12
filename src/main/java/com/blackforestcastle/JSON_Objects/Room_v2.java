package com.blackforestcastle.JSON_Objects;

import java.util.ArrayList;
import java.util.List;

public class Room_v2 {
    //fields are set by json parser and may not directly reflect being referenced or set
    private String name, desc;

    //directions hold next room name
    //maybe other room information should be held at a higher level
    //private String north,south,east,west;


    //list of items in the room
    private List<Item> items;
    //list of npcs in the room
    private List<NPC> npcs;

    public Room_v2() {
        setItems(new ArrayList());
        setNpcs(new ArrayList());
    }

    public Room_v2(String theName, String theDesc) {
        this();
        setName(theName);
        setDesc(theDesc);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<NPC> getNpcs() {
        return npcs;
    }

    public void setNpcs(List<NPC> npcs) {
        this.npcs = npcs;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder =new StringBuilder();
        stringBuilder.append(getName()+"\n"+getDesc()+"\n");
        stringBuilder.append("Items in the room... ");
        for (Item item :
                getItems()) {
            stringBuilder.append("\t"+item.getName());
        }
        stringBuilder.append("\n"+"Enemies in the room... ");
        for (NPC npc :
                getNpcs()) {
            stringBuilder.append("\t"+npc.getName());
        }
        
        
        return stringBuilder.toString();
    }
}

