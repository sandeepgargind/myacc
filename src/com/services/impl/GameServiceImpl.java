package com.services.impl;

import com.entities.BattleArea;
import com.entities.Player;
import com.services.BattleAreaService;
import com.services.GameService;
import com.services.PlayerService;

public class GameServiceImpl implements GameService {

	PlayerService playerService = new PlayerServiceImpl();
	BattleAreaService battleAreaService = new BattleAreaServiceImpl();
	String message = " playerName fires a missile with target targetCell which got hitormiss";

	@Override
	public void playTurn(Player player, Player opponentPlayer) throws InterruptedException {
		boolean isSuccessfulHit = true;
		while (player.hasMoreAttacks() && isSuccessfulHit)
		{
			String cell = player.getNextSequenceofAttack();	
			BattleArea opponentBattlearea = opponentPlayer.getBattleArea();
			isSuccessfulHit = battleAreaService.onAttack(opponentBattlearea, cell);
			System.out.println(message.replace("playerName", player.getName()).replace("targetCell", cell).replace("hitormiss", isSuccessfulHit? "hit": "miss"));
		}
	}


	@Override
	public boolean isGameOn(Player player, Player opponentPlayer)
	{
		return player.hasMoreAttacks() || opponentPlayer.hasMoreAttacks();
	}
	
}
