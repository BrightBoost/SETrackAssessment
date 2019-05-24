package com.individualTrack;

public abstract class Team {
    private String name;
    private boolean lost = false;
    private boolean played = false;

    public Team() {
        //this.name = "";
    }
    public Team(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }

    public boolean isPlayed() {
        return played;
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }

    abstract String finalPrint();


}
