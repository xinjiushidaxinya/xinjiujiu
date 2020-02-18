package com.example.biye;

public class contacts {

    private String names;
    private int imageId;

    public contacts(String names,int imageId)
    {
        this.names = names;
        this.imageId = imageId;
    }

    public  String getNames(){
        return names;
    }
    public int getImageId(){
        return imageId;
    }
}
