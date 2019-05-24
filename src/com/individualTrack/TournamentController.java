package com.individualTrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TournamentController {

    private List<Team> teamList = new ArrayList<Team>();
    private String[] teamNames = {"team1","team2","team3","team4","team5","team6","team7","team8"};
    //private List<AmateurTeam> amList = new ArrayList<AmateurTeam>();
    //private List<ProfTeam> proList = new ArrayList<ProfTeam>();

    public TournamentController(){
    }

    protected void startGame() {
        Random random = new Random();
        boolean pro = random.nextBoolean();
        for (String name : teamNames) {
            if (pro) {
                teamList.add(new ProfTeam(name));

            } else {
                teamList.add(new AmateurTeam(name));
            }
            pro = !pro;

        }
        System.out.println("Let's start the game!");
    }
    private Game getMatchUp() {
        Game game = new Game(getFittingTeam(), getFittingTeam());
        return game;
    }
    private Team playGame(Game match) {
        // create 2 random scores from 0-4
        Random rand = new Random();
        int score1 = rand.nextInt(5);
        int score2 = rand.nextInt(5);
        // Check whether it's a draw and add one point to random winner
        if (score1 == score2) {
            int winningPoint = rand.nextInt(2);
            if (winningPoint == 0) {
                score1++;
            } else {
                score2++;
            }
        }
        String finalScore = "The final score was: " + score1 + " - " + score2 + ".";
        // Check what team wins and set the other team to lost.
        if (score1 > score2) {
            // team1 wins
            match.getTeam2().setLost(true);
            System.out.println(match.getTeam1().getName() + " wins from " + match.getTeam2().getName() + "! " + finalScore);
            return match.getTeam1();
        } else {
            // team2 wins
            match.getTeam1().setLost(true);
            System.out.println(match.getTeam1().getName() + " loses from " + match.getTeam2().getName() + "! " + finalScore);
            return match.getTeam2();
        }
    }

    private Team getFittingTeam() {
        // generate two random teams which haven't played is this round and have not lost yet.
        Random rand = new Random();
        Team team = null;
        //TODO: get better way to check team is initialized
        while (team == null) {
            int n = rand.nextInt(8);
            if (!teamList.get(n).isPlayed() && !teamList.get(n).isLost()) {
                team = teamList.get(n);
                team.setPlayed(true);
            }
        }
        return team;
    }

    protected Team playRounds() {
        // Play the tournament with 4, then 2 rounds and a final round returning the winner.
        System.out.println("Round 1!");
        for (int i = 0; i < 4; i++) {
            playGame(getMatchUp());
        }
        resetIsPlayed();
        System.out.println("Round 2!");
        for (int i = 0; i < 2; i++) {
            playGame(getMatchUp());
        }
        System.out.println("Final round!");
        resetIsPlayed();
        return playGame(getMatchUp());
    }

    private void resetIsPlayed() {
        for (Team team : teamList) {
            team.setPlayed(false);
        }
    }

    protected void finalPrint(Team winner) {
        System.out.println(winner.finalPrint());
    }
}
