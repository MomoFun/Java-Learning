package com.momo;
import java.io.IOException;
import java.lang.Exception;

public class ThrowsTest {
	//如果一个方法可能会出现异常，但是没有能力处理这种异常，可以在方法声明处用throws子句来声明抛出异常。
//	static void pop() throws NegativeArraySizeException{
//		//当方法抛出异常列表的异常时，方法将不对这些类型及其子类型的异常做处理，
//		//而是抛向调用该方法的方法，由他去处理
//		int[] arr = new int[-3];
//	}
	
//	public static void main(String[] args) {
//		try{
//			pop();
//		}catch(NegativeArraySizeException e){
//			System.out.println("pop方法抛出异常");
//		}
//	}


//调用抛出异常的几种方式
//	void method1() throws IOException{};
//	void method2() throws IOException{
//		method1();
//	}
//	void method3() throws Exception{
//		method1();
//	}
//	void method4(){
//		try{
//			method1();
//		}catch(IOException e){
//			System.out.println("method1()出现异常");
//		}
//	}
//	void method5() throws Exception{
//		try{
//			method1();
//		}catch(IOException e){
//			throw new Exception();
//		}
//	}
	
	
	/*
	 * 使用Throw抛出异常的实例
	 * */
	static int quotient(int x, int y) throws MyException{
		if(y < 0){
			throw new MyException("除数不能为负");
		}
		return x / y;
	}
	
	public static void main(String[] args) {
		int a = 3;
		int b = -1;
		try{
			int result = quotient(a, b);
		}catch(MyException e){
			System.out.println(e.getMessage());
		}catch(ArithmeticException e){
			System.out.println("除数不能为零");
		}catch(Exception e){
			System.out.println("程序发生了其他异常");
		}
	}
}

/*
 * 创建自定义异常类
 * 定义一个可以返回信息的异常类
 * */
class MyException extends Exception{
	String message;
	public MyException(String ErrorMessager){
		message = ErrorMessager;
	}
	
	public String getMessage(){
		return message;
	} 
	
}