package com.individualTrack;

public class ProfTeam extends Team {
    private String sponsor;
    private double budget;

    public ProfTeam(String name) {
        super.setName(name);
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
    public String finalPrint() {
        return (getName() + " wins and parties with its sponsor!");
    }
}
