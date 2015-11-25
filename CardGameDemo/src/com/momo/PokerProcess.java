package com.momo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PokerProcess {
	/*
	 * 扑克牌创建类
	 * 用于创建除大小王之外的所有扑克牌
	 */
	public List<Poker> pokerCards = new ArrayList<Poker>();
	
	//向pokerCards中添加扑克牌
	public List<Poker> creatPoker(){
		String[] type = new String[4];
		type[0] = "黑桃";
		type[1] = "红桃";
		type[2] = "梅花";
		type[3] = "方片";
		String[] num = new String[13];//保存扑克牌编号的数组
		for(int i = 0; i < 8 ; i++){
			num[i] = String.valueOf(i + 3);
		}
		num[8] = "J";
		num[9] = "Q";
		num[10] = "K";
		num[11] = "A";
		num[12] = "2";
		
		//计算序号为i的扑克牌对应的花色和大小
		for(int i = 0; i < 52; i++){
			int m = i / 13;
			int n = i % 13;
			Poker poker = new Poker(type[m], num[n],m,n);
			pokerCards.add(poker);
		}
		return pokerCards;
	}
	
	//打印扑克牌信息
	public void showPokers(List<Poker> pokerCards){
		System.out.print("[");
		for (Poker poker : pokerCards) {
			System.out.print(poker.type + poker.num + " ");
		}
		System.out.println("]");
	}
	
	//洗牌
	public List<Poker> shufflePokers(){
		Collections.shuffle(pokerCards);
		return pokerCards;
	}
	
}
