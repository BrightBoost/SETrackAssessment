package com.individualTrack;

public class Tournament extends TournamentController {

    public static void main(String[] args) {
	TournamentController game = new TournamentController();
        //initializes all teams
        game.startGame();
        // Plays all rounds and returns winner
        Team winner = game.playRounds();
        // Prints final line
        game.finalPrint(winner);
    }
}
