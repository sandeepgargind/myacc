package com.services.impl;

import java.util.List;
import com.entities.BattleArea;
import com.entities.Player;
import com.services.BattleAreaService;
import com.services.PlayerService;

public class PlayerServiceImpl implements PlayerService {

	BattleAreaService battleAreaService = new BattleAreaServiceImpl();
	
	@Override
	public Player initialize(String playerName, BattleArea battleArea) {
		Player player = new Player(battleArea, playerName);
		return player;
	}
	
	@Override
	public boolean hasLost(Player player)
	{
		BattleArea battleArea = player.getBattleArea();
		return !battleAreaService.hasAnyShip(battleArea);
	}


}
