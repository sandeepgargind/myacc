package com.services;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.entities.BattleArea;
import com.entities.Player;
import com.services.impl.BattleAreaServiceImpl;
import com.services.impl.PlayerServiceImpl;

public class testPlayServiceImpl {

	Player player = null;
	PlayerService playerService;
	BattleArea battleArea = null;
	BattleAreaService battleAreaService;
	
	@Before
	public void initialize()
	{
		playerService = new PlayerServiceImpl();
		battleAreaService = new BattleAreaServiceImpl();
		battleArea = battleAreaService.create(3, 'E');
		player = new Player(battleArea, "Player 1");
	}

	@Test
	public void testInitialize()
	{
		player = playerService.initialize("Player 1", battleArea);
		assertEquals("Player 1", player.getName());
		assertEquals(battleArea.getRows(), player.getBattleArea().getRows());
	}

	
	
}
