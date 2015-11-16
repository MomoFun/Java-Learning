package com.momo;

public abstract class Car {
	/*
	 * 抽象类定义被租车辆公有的特性：名称和租金，以及总租金
	 * name 汽车名
	 * hireDay 租车天数
	 * rent 租金
	 * transport():计算总租金
	 * description():描述汽车信息，返回汽车信息
	 * */
	
	public String name;
	public int hireDay;
	public int rent;
	
	public int transport(int hireDay, int rent) {
		// TODO Auto-generated method stub
		this.hireDay = hireDay;
		this.rent = rent;
		return this.hireDay * this.rent;
	}
	
	public abstract String description();
	
}
