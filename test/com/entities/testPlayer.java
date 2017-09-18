package com.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.junit.Before;
import org.junit.Test;

public class testPlayer {

	Player player = null;
	String[] attacks = { "A1" , "P1" , "P3" , "P3", "P5" };
	
	@Before
	public void setup() throws InterruptedException
	{
		player = new Player(null, "Player1"); 
		player.setSequenceofAttacks(Arrays.asList(attacks));
	}
	
	@Test 
	public void testSequenceofAttacks() throws InterruptedException
	{
		BlockingQueue<String> expectedPlayerAttacks = new ArrayBlockingQueue<>(100);
		for (String attack: attacks)
			expectedPlayerAttacks.put(attack);
		assertEquals(5, player.getSequenceofAttacks().size());
		assertTrue(player.getSequenceofAttacks().contains("P1"));
		assertTrue(player.getSequenceofAttacks().contains("P5"));
		assertTrue(player.getSequenceofAttacks().contains("A1"));
	}
	
	
	@Test
	public void testHasMoreAttacks() throws InterruptedException
	{
		assertTrue(player.hasMoreAttacks());
	}
	
	@Test
	public void testHasNoMoreAttacks() throws InterruptedException
	{
		String[] attacks = { };
		player.setSequenceofAttacks(Arrays.asList(attacks));
		assertFalse(player.hasMoreAttacks());
	}
	
	@Test
	public void testNextAttack() throws InterruptedException 
	{
		String[] attacks = { "A1" , "P1" , "P3" , "P3", "P5" };
		player.setSequenceofAttacks( Arrays.asList(attacks));
		assertEquals("A1", player.getNextSequenceofAttack());
		assertEquals("P1", player.getNextSequenceofAttack());
		assertEquals("P3", player.getNextSequenceofAttack());
		assertEquals("P3", player.getNextSequenceofAttack());
		assertEquals("P5", player.getNextSequenceofAttack());
	}

}
