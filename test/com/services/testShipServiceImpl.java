package com.services;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.entities.Ship;
import com.entities.ShipType;
import com.services.impl.ShipServiceImpl;

public class testShipServiceImpl {

	ShipService shipService;

	@Before
	public void initialize() {
		shipService = new ShipServiceImpl();
	}

	@Test
	public void testCreateHeight() {
		String[] strCells = { "D4","D5"};
		Set<String> cells = new HashSet<>();
		Arrays.stream(strCells).map(cells::add).collect(Collectors.toSet());
		assertEquals(Ship.create(cells, ShipType.Q), shipService.create(ShipType.Q, 2, 1, "D4"));
	}

	@Test
	public void testCreatShip() {

		String[] strCells = {"C4", "D4","E4", "C5", "D5","E5","C6", "D6","E6"};
		Set<String> cells = new HashSet<>();
		Arrays.stream(strCells).map(cells::add).collect(Collectors.toSet());
		assertEquals(Ship.create(cells, ShipType.P), shipService.create(ShipType.P, 3, 3, "C4"));
		
	}

	@Test
	public void testCreateWidth() {

		String[] strCells = {"C4", "D4","E4"};
		Set<String> cells = new HashSet<>();
		Arrays.stream(strCells).map(cells::add).collect(Collectors.toSet());
		assertEquals(Ship.create(cells, ShipType.Q), shipService.create(ShipType.Q, 1, 3, "C4"));

	}

	
	@Test
	public void testUpdate() {
		String[] strCells = { "D4","D5"};
		Set<String> cells = new HashSet<>();
		Arrays.stream(strCells).map(cells::add).collect(Collectors.toSet());
		Ship ship = Ship.create(cells, ShipType.Q);
		shipService.update(ship, "D4");
		assertTrue(ShipType.P.equals(ship.getCellType("D4")));
		assertTrue(ship.contains("D4"));
	}

	@Test
	public void testUpdatewithRemoval() {
		String[] strCells = { "D4","D5"};
		Set<String> cells = new HashSet<>();
		Arrays.stream(strCells).map(cells::add).collect(Collectors.toSet());
		Ship ship = Ship.create(cells, ShipType.P);
		shipService.update(ship, "D4");
		assertFalse(ship.contains("D4"));
		assertTrue(ship.contains("D5"));
	}

}
