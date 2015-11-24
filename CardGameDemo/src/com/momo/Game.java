package com.momo;

public class Game {
	
	public static void main(String[] args) {
		PokerProcess pokerP = new PokerProcess();
		PlayerProcess playerP = new PlayerProcess();
		pokerP.creatPoker();
		System.out.println("-----------------------------创建扑克牌-------------------------------");
		System.out.println("---------------------------以下扑克牌被创建-----------------------------");
		pokerP.showPokers();
		System.out.println("----------------------------扑克牌创建成功！----------------------------");
		pokerP.shufflePokers();
		System.out.println("--------------------------------洗牌----------------------------------");
		System.out.println("----------------------------以下是打乱后的扑克牌--------------------------");
		pokerP.showPokers();
		System.out.println("-------------------------------洗牌结束！-------------------------------");
		System.out.println("--------------------------------创建玩家-------------------------------");
		playerP.creatPlayers();
		playerP.showPlayers();
		playerP.dealCards();
	}
}
