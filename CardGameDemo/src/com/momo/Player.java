package com.momo;

import java.util.ArrayList;
import java.util.List;

/*
 * 玩家类
 * 包含三个属性：玩家id，玩家姓名，玩家手牌
 */
public class Player {
	public String id;
	public String name;
	public List<Poker> handPockers;
	public Player(String id,String name){
		this.id = id;
		this.name = name;
		this.handPockers = new ArrayList<Poker>();
	}
}
