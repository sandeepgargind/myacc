package com.services;

import com.entities.BattleArea;
import com.entities.Player;

public interface PlayerService {
	Player initialize(String playerName, BattleArea battleArea);
	boolean hasLost(Player player);
}
