package com.momo;

public class PassengerCar extends Car {
	/**
	* 用继承的方法实现客车类
	* 1.添加特有的特性：passengerCapacity 描述载客量；
	* 2.重写transport()方法，返回每辆车的总租金
	* 3.重写description()方法，返回每辆客车初始化后，形成的字符串,形式如" 金龙 800元/天 载人：20人"；
	*/
	
	public int passengerCapacity;
	public PassengerCar(String name, int rent, int passengerCapacity){
		this.name = name;
		this.rent = rent;
		this.passengerCapacity = passengerCapacity;
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
		return " "+this.name+" "+this.rent+"元/天"+" "+"载人："+this.passengerCapacity+"人";
	}

}
