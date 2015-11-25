package com.momo;

import java.util.ArrayList;
import java.util.List;

/*
 * 扑克牌类
 * 包含两个属性：1.序号 2.花色和大小
 */
public class Poker implements Comparable<Poker> {
	public String type;
	public String num;
	public int typeIndex;
	public int numIndex;
	
	public Poker(String type, String num, int typeIndex, int numIndex) {
		this.type = type;
		this.num = num;
		this.typeIndex = typeIndex;
		this.numIndex = numIndex;
	}

	@Override
	public int compareTo(Poker o) {
		if(this.numIndex == o.numIndex){
			if(this.typeIndex > o.typeIndex){
				return 1;
			}else if(this.typeIndex == o.typeIndex){
				return 0;
			}else{
				return -1;
			}
		}else if(this.numIndex > o.numIndex){
			return 1;
		}else{
			return -1;
		}
	}
	
}
