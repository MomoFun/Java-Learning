package com.momo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;

/*
 * 备选课程类
 */
public class ListTest {
	/*
	 * 用于存放备选课程的List
	 */
	public List<Course> coursesToSelect;
	public ListTest(){
		this.coursesToSelect = new ArrayList<Course>();
	}
	/*
	 *用于往coursesToSelect中添加备选课程
	 */
	public void testAdd(){
		//创建一个课程对象，并通过调用add方法，添加到备选课程List中
		Course cr1 = new Course("1","数据结构");
		coursesToSelect.add(cr1);
//		Course temp =  coursesToSelect.get(0);//对象存入集合都会变成Object类型，取出时需要类型转换
//		System.out.println("添加了课程：" + temp.getId() + ":" + temp.getName());
		
		Course cr2 = new Course("2","C语言");
		coursesToSelect.add(0, cr2);
//		Course temp2 = coursesToSelect.get(0);
//		System.out.println("添加了课程：" + temp2.getId() + ":" + temp2.getName());
		
		coursesToSelect.add(cr1);
//		Course temp0 = coursesToSelect.get(2);//对象存入集合都会变成Object类型，取出时需要类型转换
//		System.out.println("添加了课程：" + temp0.getId() + ":" + temp0.getName());
		
		
		//一下方法会抛出数组下标越界异常
//		Course cr3 = new Course("3","Java语言");
//		coursesToSelect.add(4, cr3);
		
		Course[] course = {new Course("3","离散数学"), new Course("4","汇编语言")};
		coursesToSelect.addAll(Arrays.asList(course));
		//从集合中取出课程
//		Course temp3 = (Course) coursesToSelect.get(3);
//		Course temp4 = (Course) coursesToSelect.get(4);
//		System.out.println("添加了两门课程：" + temp3.getId() + ":" + temp3.getName() + 
//				temp4.getId() + ":" + temp4.getName());
		
		Course[] course2 = {new Course("5","高等数学"),new Course("6","大学英语")};
		coursesToSelect.addAll(2, Arrays.asList(course2));
		Course temp5 = (Course)coursesToSelect.get(2);
//		Course temp6 = (Course)coursesToSelect.get(3);
//		System.out.println("添加了两门课程：" + temp5.getId() + ":" + temp5.getName() + 
//				temp6.getId() + ":" + temp6.getName());
	}
	
	/*
	 * 取得List中的元素的方法
	 */
	public void testGet(){
		int size = coursesToSelect.size();
		System.out.println("有如下课程待选：");
		for(int i = 0; i < size; i++){
			Course cr = coursesToSelect.get(i);
			System.out.println("课程" + cr.getId() + ":" + cr.getName());
		}
	}
	
	/*
	 * 通过迭代器来遍历List
	 */
	public void testIterator(){
		//通过集合的iterator方法，取得迭代器的实例
		Iterator<Course> it =  coursesToSelect.iterator();
		System.out.println("有如下课程待选（通过迭代器访问）：");
		while(it.hasNext()){
			Course cr = it.next();
			System.out.println("课程" + cr.getId() + ":" + cr.getName());
		}
	}
	
	/*
	 * 通过for each方法访问集合元素
	 */
	public void testForEach(){
		System.out.println("有如下课程待选（通过for each访问）：");
		for(Course courese:coursesToSelect){
			Course cr = courese;
			System.out.println("课程" + cr.getId() + ":" + cr.getName());
		}
	}
	
	/*
	 * 修改List中的元素
	 */
	public void testModify(){
		coursesToSelect.set(4, new Course("7","毛概"));
	}
	
	/*
	 * 删除List中的元素
	 */
	public void testRemove(){
//		Course cr = (Course) coursesToSelect.get(4);
//		System.out.println("我是课程：" + cr.getId() + ":" + cr.getName() + "我即将被删除");
//		coursesToSelect.remove(cr);
//		System.out.println("即将删除4位置上的课程");
//		coursesToSelect.remove(4);
		System.out.println("即将删除位置4和位置5上的课程");
		Course[] courses = {coursesToSelect.get(4), coursesToSelect.get(5)};
		coursesToSelect.removeAll(Arrays.asList(courses));
		System.out.println("成功删除课程");
		testForEach();	
	}
	
	/*
	 * 往List中添加一些奇怪的东西
	 */
//	public void testType(){
//		System.out.println("能否往List中添加一些奇怪的东西呢!?");
//		coursesToSelect.add("我不是课程，我只是一个无辜的字符串！！");	
//	}
	
	public static void main(String[] args) {
		ListTest lt = new ListTest();
		lt.testAdd();
//		lt.testType();
		lt.testForEach();
//		lt.testGet();
//		lt.testIterator();
		lt.testModify();
		lt.testForEach();
		lt.testRemove();
	}
}
