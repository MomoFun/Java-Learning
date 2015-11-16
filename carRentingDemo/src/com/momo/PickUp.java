package com.momo;

public class PickUp extends Car {
	/**
	* 用继承的方法实现皮卡类
	* 1.添加既能载客又能载货的特性：deadWeight 描述载货量；passengerCapacity 描述载客量；
	* 2.重写transport()方法，返回每辆车的总租金
	* 3.重写description()方法，返回每辆客车初始化后，形成的字符串,形式如" 皮卡雪6 450元/天 载人：4人 载货:2吨"；
	*/
	
	public int cargoCapacity;
	public int passengerCapacity;
	
	public PickUp(String name, int rent, int cargoCapacity, int passengerCapacity){
		this.name = name;
		this.rent = rent;
		this.cargoCapacity = cargoCapacity;
		this.passengerCapacity = passengerCapacity;
	}
	public int transport(int hireDay, int rent) {
		this.hireDay = hireDay;
		this.rent = rent;
		return this.hireDay * this.rent;
	}
	public String description() {
		return " "+this.name+" "+this.rent+"元/天"+" "+"载人："+this.passengerCapacity+"人" +" " +"载货："+this.cargoCapacity+"吨";
	}
}
