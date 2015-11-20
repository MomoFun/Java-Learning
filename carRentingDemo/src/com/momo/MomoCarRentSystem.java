package com.momo;
import java.util.Scanner;

public class MomoCarRentSystem {
	final int trunkNum = 2;
	final int passCarNum = 3;
	final int PickUpNum = 2;
	
	public Car[] showCarList(String[] name,int[]capacity,int[] rent,int[] piCarCapacity){
		Car totalCar[] =new Car[name.length] ;
		String list[] =new String[name.length];
		for (int i = 0;i<name.length;i++)
		{
			if(i<trunkNum){
				totalCar[i] = new Trunk(name[i],capacity[i],rent[i]);
			}else if(i>=trunkNum && i<(trunkNum+passCarNum)){
				totalCar[i] = new PassengerCar(name[i],capacity[i],rent[i]);
			}else if(i>=trunkNum+passCarNum && i<(trunkNum+passCarNum+PickUpNum)){
				totalCar[i] = new PickUp(name[i],capacity[i],rent[i],piCarCapacity[i-(trunkNum+passCarNum)]);
			}
			list[i] = totalCar[i].description();
		}
		System.out.println("欢迎使用沫沫租车系统：");
		System.out.println("您是否要租车：1是 0否");
		Scanner input = new Scanner(System.in);
	
		int yesOrNo = input.nextInt();
		if (yesOrNo == 1){
			System.out.println("您可租车的类型及其价目表：");
			System.out.println("序号 "+"汽车名称"+" 租金"+" 容量");
			for(int i=0;i<list.length;i++){
				System.out.println((1+i)+"."+list[i]);
			}
		}
		else{
			totalCar = null;
		}
		return totalCar;
	}
	
	public void createBill(Car[] carList){
		/*
		 * 功能：实现车型选择、天数输入、账单输出的功能
		 *
		 */
		//记录已经选择的车辆的序号，初始化完成时，数组中的每个元素值为0
		int[] indexSelected = new int[carList.length];
		//记录已租车辆的总的载客量
		int personCapicity=0;
		//记录已租车辆的总的载货量
		int cargoCapacity=0;
		//记录租车所需的总金额：
		int money=0;
		//记录所有已租客车的名单
		String passengerCarName="";
		//记录所有已租货车的名单
		String TrunkName="";
	
		System.out.println("请输入你要选择租用的车辆数量：");
		Scanner input = new Scanner(System.in);
		//记录要租的车辆的总数
		int totalCarNum = input.nextInt();
		//如果输入为0，重新输入
		if (totalCarNum <= 0){
			System.out.println("您输入的车辆数量有误，请重新输入！");
			totalCarNum = input.nextInt();
		}
		//根据租车的总数，逐辆选择车辆
		for(int i=0;i<totalCarNum;i++){
			System.out.println("请输入第"+(i+1)+"辆车的序号：");
			indexSelected[i]=input.nextInt();
			//System.out.println("indexSelected []"+i+" "+indexSelected[i]);
		}
		System.out.println("请输入租车的天数：");
		//输入租车的天数
		int hireDay = input.nextInt();
		//如果输入为0，重新输入
		if (hireDay <= 0){
			System.out.println("您输入的租车天数有误，请重新输入！");
			hireDay = input.nextInt();
		}
		System.out.println("您的账单：");
		//定义Car类型对象selectedcar，记录每次选择的车辆
		Car selectedcar ;
		for(int i=0;i<indexSelected.length;i++)
		{
			if(indexSelected[i]==0)
			{
				//当indexSelected中的元素值为0时退出循环
				break;
			}
			//因为每辆车的序号比它在数组的位置都大1，所以要减去1
			selectedcar =carList[indexSelected[i]-1];
			//用多态的形式访问每个carList数组的对象
			//如果carList数组中被选中的对象是PickUp类的子类，则进行以下操作
			if (selectedcar instanceof PickUp){
				//给记录能载客汽车名字的字符串加上皮卡车的名字
				passengerCarName +=" "+selectedcar.name;
				//给记录能载货汽车名字的字符串加上皮卡车的名字
				TrunkName += " "+selectedcar.name;
				/*
				 * 给记录总载客量的变量加上选中皮卡车的载客量，通过强制类型转换可以让父类访问子类，
				 * 因为我们初始化时，这个位置存放的就是PickUp类对象，所有是安全的
				 */
				personCapicity +=((PickUp)selectedcar).passengerCapacity;
				//给记录总载货量的变量加上选中皮卡车的载货量
				cargoCapacity += ((PickUp)selectedcar).cargoCapacity;
				//给记录总金额的变量加上选中租用皮卡车所需要的金额
				money += ((PickUp)selectedcar).transport(hireDay,((PickUp)selectedcar).rent);
			}else if(selectedcar instanceof Trunk){
				TrunkName += " "+selectedcar.name;
				/*
				 * 给记录总载客量的变量加上选中货车的载货量，通过强制类型转换可以让父类访问子类，
				 * 因为我们初始化时，这个位置存放的就是GoodsVan类对象，所有是安全的
				 */
				cargoCapacity += ((Trunk)selectedcar).cargoCapacity;
				//给记录总金额的变量加上选中租用客车所需要的金额
				money += ((Trunk)selectedcar).transport(hireDay,((Trunk)selectedcar).rent);
			}else if(selectedcar instanceof PassengerCar){
				passengerCarName +=" "+selectedcar.name;
				/*
				 * 给记录总载客量的变量加上选中客车的载客量，通过强制类型转换可以让父类访问子类，
				 * 因为我们初始化时，这个位置存放的就是PassengerCar类对象，所有是安全的
				 */
				personCapicity +=((PassengerCar)selectedcar).passengerCapacity;
				//给记录总金额的变量加上选中租用皮卡车所客车的金额
				money += ((PassengerCar)selectedcar).transport(hireDay,((PassengerCar)selectedcar).rent);
				}
			}
			if(personCapicity != 0){
				//显示账单中的客车信息
				System.out.println("***可载人的车有：");
				System.out.println(passengerCarName+" "+"共载人："+personCapicity+"人");
			}
			if(cargoCapacity != 0){
				//显示账单中的货车信息
				System.out.println("***可载货的车有：");
				System.out.println(TrunkName+" "+"共载货："+cargoCapacity+"吨");
			}
			if(money !=0){
				//显示账单中的金额信息
				System.out.println("***租车总价格："+money+"元");
			}
	}
	
	
	
	
	public static void main(String[] args) {
		//所有的车名
		String[] name={"松花江","依维柯","奥迪A4","马自达6","金龙","皮卡雪6","皮卡2"};
		//容量：客车的载客量、货车的载货量、皮卡的载客量
		int capacity[] ={4,20,4,4,20,4,6};
		//皮卡的载货量
		int piCarCapacity[]={2,5};
		//每辆车的租金
		int[] rent={400,1000,500,400,800,450,500};
		//定义Car类型的数组用于存放所有已经初始化的汽车的对象
		Car All[] = new Car[name.length];
		//定义一个DaDa租车系统对象
		Momo testList =new Momo();
		//调用Momo租车系统对象的showCarList方法，显示所有车辆列表并返回包含所有车辆对象的Car类型数组
		All = testList.showCarList(name,capacity,rent,piCarCapacity);
	
		if (All != null){
			//如果要租车，选择"1"时，调用createBill()方法生成账单
			testList.createBill(All);
		}
		else{
			//如果不想租车，退出
			System.out.println("感谢光临，再见");
		}
	}	
}

