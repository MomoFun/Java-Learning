package com.momo;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MapTest {
	public Scanner console;
	/*
	 * 用来承装学生类型对象
	 */
	public Map<String,Student> students;
	/*
	 * 在构造器中初始化students属性
	 */
	public MapTest(){
		this.students = new HashMap<String,Student>();
		this.console =new Scanner(System.in);
	}
	
	/*
	 * 测试添加：输入学生ID，判断是否有学生对象，
	 * 判断是否被占用，若未被占用，则输入姓名，创建新学生对象，并且添加到students中
	 */
	public void testPut(){
		int i = 0;
		while(i < 3){
			System.out.println("请输入学生ID：");
			String ID = console.next();
			//判断ID是否被占用
			Student st = students.get(ID);
			if(st == null){
				//提示输入学生姓名
				System.out.println("请输入学生姓名：");
				String name = console.next();
				//创建新的学生对象
				Student newStudent = new Student(ID,name);
				//通过调用students的put方法，添加ID-学生映射
				students.put(ID, newStudent);
				System.out.println("成功添加学生：" + students.get(ID).getName());
				i++;
			}else{
				System.out.println("该学生ID已被占用！");
				continue;
			}
		}
	}
	
	/*
	 * 测试Map的KeySet方法
	 */
	public void testKeySet(){
		//通过keySet方法，返回Map中的所有“键的集合”
		Set<String> keySet = students.keySet(); 
		//取得students的容量
		System.out.println("总共有："  + students.size() + "个学生");
		//遍历keySet对象，取得每一个键，再调用get方法，取得每个键对应的value
		for(String stuId: keySet){
			Student st = students.get(stuId);
			if(st != null){
				System.out.println("学生：" +st.getName());
			}
		}
	}
	
	/*
	 * 测试删除Map中已有的映射
	 */
	public void testRemove(){
		//获取从键盘输入的学生ID字符串
		while(true){
			//提示用户待删除学生的ID
			System.out.println("请输入要删除的学生ID！");
			String ID = console.next();
			//判断该ID是否有对应的学生对象
			Student st = students.get(ID);
			if(st == null){
				//提示输入的ID并不存在
				System.out.println("该ID不存在！");
				continue;
			}
			students.remove(ID);
			System.out.println("成功删除学生：" + st.getName());
			break;
		}
		
	}
	
	/*
	 * 通过entrySet方法遍历Map
	 */
	public void testEntrySet(){
		//通过entrySet方法，返回Map中所有键值对
		Set<Entry<String, Student>> entrySet = students.entrySet();
		for(Entry<String, Student> entry:entrySet){
			System.out.println("取得键：" + entry.getKey());
			System.out.println("对应的值为：" + entry.getValue().getName());	
		}
		
		
	}
	
	/*
	 * 利用put方法修改Map中的已有映射
	 */
	public void testModify(){
		//提示输入要修改的学生ID
		System.out.println("请输入要修改的学生ID");
		while(true){
			//取得从键盘输入的学生ID
			String stuID = console.next();
			//从students中查找该学生ID对应的学生对象
			Student student = students.get(stuID);
			if(student == null){
				System.out.println("该ID不存在，请重新输入");
				continue;
			}
			//提示当前学生对象的姓名
			System.out.println("当前ID所对应的学生为：" + student.getName());
			//提示输入新学生姓名，来修改已有映射
			System.out.println("请输入新的学生姓名：");
			String name = console.next();
			Student newStudent = new Student(stuID,name);
			students.put(stuID, newStudent);
			System.out.println("修改成功！");
			break;
		}		
	}
	
	/*
	 * 测试Map中是否包含某个Key值或某个Value值
	 */
	public void testContainsKeyOrValue(){
		//提示用户输入学生ID
		System.out.println("请输入要查询的学生ID");
		String id = console.next();
		//在Map中，用containsKey()方法，来判断是否包含某个Key值
		System.out.println("您输入的学生ID为：" + id + "，在学生映射表中是否存在？" + students.containsKey(id));
		if(students.containsKey(id)){
			System.out.println("对应的学生为：" + students.get(id).getName());
		}
		//提示输入学生姓名
		System.out.println("请输入要查询的学生姓名：");
		String name = console.next();
		//用containsValue()方法，来判断是否包含某个Value值
		if(students.containsValue(new Student(null,name))){
			System.out.println("学生映射表中确实包含学生" + name);
		}else{
			System.out.println("不存在这个学生！");
		}
		
	}
	
	public static void main(String[] args) {		
		MapTest mt = new MapTest();
		mt.testPut();
		mt.testKeySet();
//		mt.testRemove();
//		mt.testEntrySet();
		mt.testModify();
		mt.testEntrySet();
	}

}
