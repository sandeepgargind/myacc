package com.services;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.entities.BattleArea;
import com.entities.Ship;
import com.entities.ShipType;
import com.services.impl.BattleAreaServiceImpl;

public class testBattleAreaServiceImpl {

	BattleAreaService battleAreaService;
	Ship ship;
	BattleArea battleArea;

	@Before
	public void initialize() {
		battleAreaService = new BattleAreaServiceImpl();
		battleArea = battleAreaService.create(3, 'E');

	}

	@Test
	public void testCreate() {
		BattleArea battleAreaNew = battleAreaService.create(3, 'E');
		assertEquals('E', battleAreaNew.getRows());
		assertEquals(3, battleAreaNew.getColumns());
	}

	@Test
	public void testPlot() {
		battleAreaService.plot(battleArea);
		assertTrue(true);
	}

	@Test
	public void testPlaceShip() {

		String[] strCells = { "E1", "E2" };
		Set<String> cells = new HashSet<>();
		Arrays.stream(strCells).map(cells::add).collect(Collectors.toSet());
		ship = Ship.create(cells, ShipType.P);
		battleAreaService.place(battleArea, ship);
		assertEquals("[E1, E2]", battleArea.getShipLocations());
		battleAreaService.plot(battleArea);
	}

	@Test
	public void testOnAttack() {
		String[] strCells = { "E1", "E2" };
		Set<String> cells = new HashSet<>();
		Arrays.stream(strCells).map(cells::add).collect(Collectors.toSet());
		ship = Ship.create(cells, ShipType.Q);
		battleAreaService.place(battleArea, ship);
		assertEquals("[E1, E2]", battleArea.getShipLocations());

		battleAreaService.onAttack(battleArea, "E1");
		System.out.println(battleArea.getShipLocations());
		Assert.assertTrue(battleAreaService.isOccupiedbyShip(battleArea, "E1"));
		Ship s = battleAreaService.getShiponCell(battleArea, "E1");
		assertEquals(ShipType.P, s.getCellType("E1"));

	}

	@Test
	public void testGetShipOnCell() {
		String[] strCells = { "E1", "E2" };
		Set<String> cells = new HashSet<>();
		Arrays.stream(strCells).map(cells::add).collect(Collectors.toSet());
		ship = Ship.create(cells, ShipType.Q);
		battleAreaService.place(battleArea, ship);
		assertEquals("[E1, E2]", battleArea.getShipLocations());
		Ship s1 = battleAreaService.getShiponCell(battleArea, "E1");
		assertEquals(ShipType.Q, s1.getCellType("E1"));
	}

	@Test
	public void testHasAnyShip() {
		assertFalse(battleAreaService.hasAnyShip(battleArea));

	}

	@Test
	public void testRemoveShipOnCell() {
		String[] strCells = { "E1", "E2" };
		Set<String> cells = new HashSet<>();
		Arrays.stream(strCells).map(cells::add).collect(Collectors.toSet());
		ship = Ship.create(cells, ShipType.P);
		battleAreaService.place(battleArea, ship);
		assertEquals("[E1, E2]", battleArea.getShipLocations());

		battleAreaService.onAttack(battleArea, "E1");
		System.out.println(battleArea.getShipLocations());
		Assert.assertFalse(battleAreaService.isOccupiedbyShip(battleArea, "E1"));

	}
}
