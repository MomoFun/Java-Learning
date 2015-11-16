package com.momo;

public class Trunk extends Car {
	/*
	 * 用继承的方法实现货车类
	 * 1. 添加货车特有的特性：cargoCapacity描述载货量；
	 * 2. 重写transport()方法
	 * 3. 重写description()方法，返回每辆货车初始化后，形成的字符串
	 * */
	public int cargoCapacity;
	public Trunk(String name, int cargoCapacity, int rent){
		this.name = name;
		this.cargoCapacity = cargoCapacity;
		this.rent = rent;
	}
	@Override
	public int transport(int hireDay, int rent) {
		// TODO Auto-generated method stub
		this.hireDay = hireDay;
		this.rent = rent;
		return this.hireDay * this.rent;
	}
	@Override
	public String description() {
		// TODO Auto-generated method stub
		return " "+this.name+" "+this.rent+"元/天"+" "+"载货："+this.cargoCapacity+"吨";
	}
	
}
