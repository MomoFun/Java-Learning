package com.momo;
import java.util.ArrayList;
import java.util.List;

public class TestGeneric {
	/*
	 * ���з��� ����Course����List��������
	 */
	public List<Course> courses;
	
	public TestGeneric(){
		this.courses = new ArrayList<Course>();
	}
	
	/*
	 *������� 
	 */
	public void testAdd(){
		Course cr1 = new Course("1","��ѧ����");
		courses.add(cr1);
		//���ͼ����У�������ӷ��͹涨�����ͼ�������������Ķ��󣬷���ᱨ��
		//courses.add("�ܷ����һЩ��ֵĶ����أ�");
		Course cr2 = new Course("2","Java����");
		courses.add(cr2);
	}
	
	/*
	 * ����ѭ������
	 */
	public void testForEach(){
		for(Course cr:courses){
			System.out.println(cr.getId() + ":" + cr.getName());
		}
	}
	/*
	 * ���ͽ�Ͽ�����ӷ��͵������͵Ķ���ʵ��
	 */
	public void testChild(){
		ChildCourse ccr = new ChildCourse();
		ccr.setId("3");
		ccr.setName("���������͵Ŀγ̶���ʵ��~~~");
		courses.add(ccr);
	}
	
	/*
	 * ���Ͳ���ʹ�û�������
	 */
	public void testBasicType(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		System.out.println("�������ͱ���ʹ�ð�װ����Ϊ����!" + list.get(0));
	}
	
	public static void main(String[] args) {
		TestGeneric tg = new TestGeneric();
		tg.testAdd();
		tg.testForEach();
		tg.testChild();
		tg.testForEach();
		tg.testBasicType();
	}

}
