package com.example.muscle_studio_100;

public class Coach {

    private int img;
    private String name ;
    private String desc;

    public Coach(int img, String name, String desc) {
        this.img = img;
        this.name = name;
        this.desc = desc;
    }
    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
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


}
