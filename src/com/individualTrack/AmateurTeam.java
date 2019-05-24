package com.individualTrack;

public class AmateurTeam extends Team {
    private String mascot;
    private String bar;

    public AmateurTeam(String name) {
        super.setName(name);
    }

    public String getMascot() {
        return mascot;
    }

    public void setMascot(String mascot) {
        this.mascot = mascot;
    }

    public String getBar() {
        return bar;
    }

    public void setBar(String bar) {
        this.bar = bar;
    }

    public String finalPrint() {
        return (getName() + " wins and parties with its mascot!");
    }
}
