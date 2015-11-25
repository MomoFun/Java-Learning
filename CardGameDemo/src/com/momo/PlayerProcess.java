package com.momo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
/*
 * 扑克牌比大小系统
 */
public class PlayerProcess {
	public Scanner console;
	public Map<String, Player> players;
	public static List<Poker> initPoker;
	public static List<Poker> randomPoker;
	public static PokerProcess pokerP = null;
	public Set<String> playerIDs;

	
	//构造器中初始化属性
	public PlayerProcess(){
		this.players = new HashMap<String, Player>();
		this.console = new Scanner(System.in);
		pokerP = new PokerProcess();
		initPoker = pokerP.creatPoker();
		randomPoker = pokerP.shufflePokers();	
		playerIDs = players.keySet();
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
			//显示玩家信息
			System.out.println("总共有" + players.size() + "个玩家，他们的信息如下：");
			for (String playId: playerIDs) {
				Player plyr = players.get(playId);
				System.out.println("玩家姓名:" + plyr.name);
			}
		}
	}

	/*
	 * 给玩家分牌
	 * 对Player的handPockers进行操作
	 */
	public void dealCards(){

		List<Poker> maxCardsofPlayers = new ArrayList<Poker>();
		String[] handPokerInf = new String[2];
		int i = 0;//被分牌的序号
		int j = 0;
		for (String playId : playerIDs) {
			List<Poker> poker = players.get(playId).handPockers;
			int n = 0;//分牌次数
			while(n < 2){
				poker.add(randomPoker.get(i));
				i += 2;
				n++;
			}
			handPokerInf[j] =  players.get(playId).name + "的手牌为:[" + poker.get(0).type + poker.get(0).num + poker.get(1).type + poker.get(1).num + "]";
			j++;
			i = 1;
			
//			int i = 0;//被分牌的序号
//			int j = 0;
//			for (String playId : playerIDs) {
//				List<Poker> poker = players.get(playId).handPockers;
//				int n = 0;//分牌次数
//				while(n < 2){
//					poker.add(randomPoker.get(i));
//					i += 2;
//					n++;
//				}
//				handPokerInf[j] =  players.get(playId).name + "的手牌为:[" + poker.get(0).type + poker.get(0).num + poker.get(1).type + poker.get(1).num + "]";
//				j++;
//				i = 1;
			

			Poker maxPoker;
			if(poker.get(0).compareTo(poker.get(1)) > 0){
				maxPoker = poker.get(0);	
			}else{
				maxPoker = poker.get(1);	
			}
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
	
	public void PlayerComparison(){
		
	}
	
	public static void main(String[] args) {
		PlayerProcess playerP = new PlayerProcess();
		System.out.println("-----------------------------创建扑克牌-------------------------------");
		System.out.println("---------------------------以下扑克牌被创建-----------------------------");
		pokerP.showPokers(initPoker);
		System.out.println("----------------------------扑克牌创建成功！----------------------------");
		System.out.println("--------------------------------洗牌----------------------------------");
		System.out.println("----------------------------以下是打乱后的扑克牌--------------------------");
		pokerP.showPokers(randomPoker);
		System.out.println("-------------------------------洗牌结束！-------------------------------");
		System.out.println("--------------------------------创建玩家-------------------------------");
		playerP.creatPlayers();
		playerP.dealCards();
	}
}
