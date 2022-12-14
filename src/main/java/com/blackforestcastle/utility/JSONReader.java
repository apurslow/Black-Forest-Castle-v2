package com.blackforestcastle.utility;

import com.blackforestcastle.JSON_Objects.GameInfo;
import com.blackforestcastle.JSON_Objects.Item;
import com.blackforestcastle.JSON_Objects.NPC;
import com.blackforestcastle.JSON_Objects.Room_v2;
import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class JSONReader {
    private Gson gson;
    private Reader reader;

    public JSONReader(){
        setGson(new Gson());
    }

    public Room_v2[] makeRoomObjects() {
        //give the reader the appropriate object class to build
        setReader(new InputStreamReader(Room_v2.class.getResourceAsStream("/room_name&desc.json")));
        Room_v2[] rooms_ALL = gson.fromJson(reader, Room_v2[].class);
        return rooms_ALL;
    }

    // This method parses the gameInfo.json file and returns a GameInfo Object that contains the required information.
    public GameInfo makeGameInfoObjects() {
        setReader( new InputStreamReader(GameInfo.class.getResourceAsStream("/gameInfo.json")));
        GameInfo info = gson.fromJson(reader, GameInfo.class);
        return info;
    }

    public List<Item> makeItemObjects() {
       setReader(new InputStreamReader(Item.class.getResourceAsStream("/items.json")));
        Item[] items_ALL = gson.fromJson(reader, Item[].class);
        return Arrays.asList(items_ALL);
    }

    public List<NPC> makeNPCObjects() {
        setReader( new InputStreamReader(NPC.class.getResourceAsStream("/npc.json")));
       NPC[] npcs_ALL = gson.fromJson(reader, NPC[].class);
        return Arrays.asList(npcs_ALL);
    }

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }
}