package com.example.wexhat.bean;

public class People {
    private int tuxiang;
    private String name;
    private String time;
    private String t_a;

    public String getT_a() {
        return t_a;
    }

    public void setT_a(String t_a) {
        this.t_a = t_a;
    }

    public People(int tuxiang, String name, String time) {
        this.tuxiang = tuxiang;
        this.name = name;
        this.time = time;
    }
    public People( String name, String t_a,int tuxiang) {
        this.tuxiang = tuxiang;
        this.name = name;
        this.t_a = t_a;
    }

    public People(String t_a) {
        this.t_a = t_a;
    }

    public People(String name, int tuxiang) {
        this.tuxiang = tuxiang;
        this.name = name;
    }

    public People() {
    }

    public int getTuxiang() {
        return tuxiang;
    }

    public void setTuxiang(int tuxiang) {
        this.tuxiang = tuxiang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
