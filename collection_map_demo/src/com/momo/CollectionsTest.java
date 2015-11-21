package com.momo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/*
 * 将要完成：
 * 1. 通过Collection.sort()方法，对Integer泛型的List进行排序；
 * 2. 对String泛型的List进行排序；
 * 3. 对其他类型泛型的List进行排序，以Student为例
 */
public class CollectionsTest {
	/*
	 * 1. 通过Collections.sort()方法，对Integer泛型的List进行排序
	 * 创建一个Integer泛型的List，插入十个100以内不重复的随机数
	 * 调用Collections.sort()方法对其进行排序
	 */
	public void testSort1(){
		List<Integer> integerList = new ArrayList<Integer>();
		//插入十个100以内不重复的随机数
		Random random = new Random();
		Integer k;
		for(int i = 0; i < 10; i++){
			do{
				k = random.nextInt(100);
			}while(integerList.contains(k)); //如果生成重复的随机数，则重新生成一次
			integerList.add(k);
			System.out.println("成功添加整数" + k);
		}
		System.out.println("---------------- 排序前----------------");
		for(Integer integer:integerList){
			System.out.println("元素：" + integer);		
		}
		Collections.sort(integerList);
		System.out.println("-----------------排序后-----------------");
		for(Integer integer:integerList){
			System.out.println("元素：" + integer);		
		}
	}
	
	/*
	 * 2. 通过Collections.sort()方法，对String泛型的List进行排序
	 * 创建一个String泛型的List，插入三个乱序的String
	 * 调用Collections.sort()方法对其进行排序
	 */
	public void testSort2(){
		List<String> stringList = new ArrayList<String>();
		stringList.add("microsoft");
		stringList.add("google");
		stringList.add("lenovo");
		System.out.println("------------------排序前-----------------");
		for (String string : stringList) {
			System.out.println("元素：" + string);
		}
		Collections.sort(stringList);
		System.out.println("------------------排序后-----------------");
		for (String string : stringList) {
			System.out.println("元素：" + string);
		}
	}
	
	/*
	 * 2. 通过Collections.sort()方法，对String泛型的List进行排序(版本2)
	 * 创建完List<String>之后，往其中添加十条随机字符串
	 * 每条字符串的长度为10以内的随机整数
	 * 每条字符串的每个字符都为随机生成的字符，字符可重复
	 * 每条随机字符串不可重复
	 */
	public String getRandomString(int length) { //length表示生成字符串的长度
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";   
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();   
	 }
	public void testSort3(){
		List<String> stringList = new ArrayList<String>();
		Random random = new Random();
		Integer k;
		for(int i = 0; i < 10; i++){
			k = random.nextInt(10);
			int length = k.intValue();
			stringList.add(getRandomString(length));
		}
		System.out.println("------------------排序前-----------------");
		for (String string : stringList) {
			System.out.println("元素：" + string);
		}
		Collections.sort(stringList);
		System.out.println("------------------排序后-----------------");
		for (String string : stringList) {
			System.out.println("元素：" + string);
		}
	}
	
	public void testSort4(){
		List<Student> studentList = new ArrayList<Student>();
		Random random = new Random();
		studentList.add(new Student(random.nextInt(1000) + "","Tom"));
		studentList.add(new Student(random.nextInt(1000) + "","Jack"));
		studentList.add(new Student(random.nextInt(1000) + "","Momo"));
		System.out.println("-------------------排序前----------------");
		for (Student student : studentList) {
			System.out.println("学生：" + student.getId() + ":" + student.getName());
		}
		Collections.sort(studentList);
		System.out.println("-------------------排序后----------------");
		for (Student student : studentList) {
			System.out.println("学生：" + student.getId() + ":" + student.getName());
		}
		Collections.sort(studentList, new StudentComparator());
		System.out.println("-----------------按照姓名排序后---------------");
		for (Student student : studentList) {
			System.out.println("学生：" + student.getId() + ":" + student.getName());
		}
	}
	
   

	public static void main(String[] args) {
		CollectionsTest ct = new CollectionsTest();
//		ct.testSort1();
//		ct.testSort2();
//		ct.testSort3();
		ct.testSort4();
	}

}
