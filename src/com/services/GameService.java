package com.services;

import com.entities.Player;

public interface GameService {
	void playTurn(Player player1, Player player2) throws InterruptedException;
	boolean isGameOn(Player player1, Player player2);

}
