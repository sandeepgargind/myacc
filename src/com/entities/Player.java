package com.entities;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Player {

	public Player(BattleArea battleArea, String name) {
		super();
		this.battleArea = battleArea;
		this.name = name;
	}

	public BattleArea getBattleArea() {
		return battleArea;
	}

	public BlockingQueue<String> getSequenceofAttacks() {
		return sequenceofAttacks;
	}

	public String getName() {
		return name;
	}

	BattleArea battleArea;
	BlockingQueue<String> sequenceofAttacks;
	String name;

	public void setSequenceofAttacks(List<String> listOfAttacks) throws InterruptedException {
		sequenceofAttacks = new ArrayBlockingQueue<>(100);
		for (String attack : listOfAttacks)
			sequenceofAttacks.put(attack);
	}


	public String getNextSequenceofAttack() throws InterruptedException {
		return sequenceofAttacks.take();
	}

	public boolean hasMoreAttacks() {
		return !sequenceofAttacks.isEmpty();
	}

}
