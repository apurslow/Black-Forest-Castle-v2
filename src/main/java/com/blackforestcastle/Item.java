package com.blackforestcastle;

class Item
{

    String name;
    String description;

    public Item(String name, String description)
    {
        this.name = name;
        this.description = description;
    }

    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }


    //NOTE: for the three methods below, the boost points must be a 4 character string directly after the colon
    //      no more no less
    public int getHpPointsForItem()
    {
        String desc = getDescription();
        int phraseLength = "hp increase:".length();
        int index   = desc.indexOf("hp increase:");
        return ((index )!= -1) ? Integer.parseInt(desc.substring(index+phraseLength, index+phraseLength+4).trim()) : 0;
    }

    public int getAttackPointsForItem()
    {
        int phraseLength = "attack increase:".length();
        String desc = getDescription();
        int index   = desc.indexOf("attack increase:") ;
        return ((index )!= -1) ? Integer.parseInt(desc.substring(index+phraseLength, index+phraseLength+4).trim()) : 0;
    }

    public int getDefensePointsForItem()
    {
        String desc = getDescription();
        String searchPhrase = "defense increase:";
        int phraseLength = searchPhrase.length();
        int index   = desc.indexOf(searchPhrase) ;
        return ((index )!= -1) ? Integer.parseInt(desc.substring(index+phraseLength, index+phraseLength+4).trim()) : 0;
    }

}
