package com.momo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PlayerProcess {
	public Scanner console;
	public Map<String, Player> players;
	//构造器中初始化属性
	public PlayerProcess(){
		this.players = new HashMap<String, Player>();
		this.console = new Scanner(System.in);
	}
	/*
	 * 创建两个玩家：输入玩家ID，判断玩家是否存在
	 * 若不存在，输入姓名，创建新的玩家，并添加到players中
	 */
	public void creatPlayers(){
		int i = 0;
		while(i < 2){
			System.out.println("请输入" + (i+1) + "号玩家的ID：");
			String id = console.next();
			Player player = players.get(id);
			if(player == null){
				System.out.println("请输入" + (i + 1) + "号玩家的姓名：");
				String name = console.next();
				Player newPlayer = new Player(id,name);
				players.put(id, newPlayer);
				System.out.println("成功添加玩家" + players.get(id).name);
				i++;
			}else{
				System.out.println("该ID已被占用，请重新输入！");
				continue;
			}
		}
	}
	/*
	 * 输出玩家信息
	 */
	public void showPlayers(){
		Set<String> playerIDs = players.keySet();
		System.out.println("总共有" + players.size() + "个玩家，他们的信息如下：");
		for (String playId: playerIDs) {
			Player plyr = players.get(playId);
			System.out.println("玩家姓名:" + plyr.name);
		}
	}
	/*
	 * 给玩家分牌
	 * 对Player的handPockers进行操作
	 */
	public void dealCards(){
		PokerProcess pokerP = new PokerProcess();
		pokerP.creatPoker();
		List<Poker> pokerCards = pokerP.shufflePokers();
		Set<String> playerIDs = players.keySet();
		List<Poker> maxCardsofPlayers = new ArrayList<Poker>();
		String[] handPokerInf = new String[2];
		int i = 0;//被分牌的序号
		int j = 0;
		for (String playId : playerIDs) {
			List<Poker> poker = players.get(playId).handPockers;
			int n = 0;//分牌次数
			while(n < 2){
				poker.add(pokerCards.get(i));
				i += 2;
				n++;
			}
			handPokerInf[j] =  players.get(playId).name + "的手牌为:[" + poker.get(0).type + poker.get(0).num + poker.get(1).type + poker.get(1).num + "]";
			j++;
			i = 1;
			
//			System.out.println("ID:" + playId + ", Name:" + players.get(playId).name );
//			System.out.println("手牌:[" + poker.get(0).type + poker.get(0).num + poker.get(1).type + poker.get(1).num + "]");

			Poker maxPoker;
			if(poker.get(0).compareTo(poker.get(1)) > 0){
				maxPoker = poker.get(0);	
			}else{
				maxPoker = poker.get(1);	
			}
			
//			System.out.println("ID:" + playId + ", Name:" + players.get(playId).name );
//			System.out.println("排序后手牌:[" + poker.get(0).type + poker.get(0).num + poker.get(1).type + poker.get(1).num + "]");
//			System.out.println("玩家" + playId + "的最大手牌为：" + maxPoker.type + maxPoker.num);
			
			maxCardsofPlayers.add(maxPoker);
		}
		//比较两个玩家的手牌大小
		if(maxCardsofPlayers.get(0).compareTo(maxCardsofPlayers.get(1)) > 0){
			System.out.println("玩家1获胜！");
		}else{
			System.out.println("玩家2获胜！");
		}
		
		for(int k = 0; k < 2; k++){
			System.out.println(handPokerInf[k]);
		}
	}	
}
