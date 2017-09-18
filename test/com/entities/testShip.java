package com.entities;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class testShip {

	Ship ship = null;

	@Before
	public void initialize()
	{
		String[] strCells = {"C4", "D4","E4"};
		Set<String> cells = new HashSet<>();
		Arrays.stream(strCells).map(cells::add).collect(Collectors.toSet());
		ship = Ship.create(cells, ShipType.Q);
	}
	
	@Test
	public void testGetCellType()
	{
		assertEquals(ShipType.Q, ship.getCellType("C4"));
	}
}
