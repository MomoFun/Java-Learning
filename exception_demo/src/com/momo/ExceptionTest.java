package com.momo;

public class ExceptionTest {

	public static void main(String[] args) {
//		int a = 6;
//		int b = 0;
//		try{
//			//if(b == 0) throw new ArithmeticException(); 系统会自动抛出异常
//			System.out.println("a/b的值是：" + a / b);
//		}catch(ArithmeticException e){
//			System.out.println("程序出现异常，变量b不能为0");
//		}
//		System.out.println("程序正常结束");
		
		//程序可能存在除数为0或者数组下标越界异常
		int[] intArray = new int[3];
		try{
			for(int i = 0; i <= intArray.length; i++){
				intArray[i] = i;
				System.out.println("intArray[" + i + "] = " + intArray[i]);
				System.out.println("intArray[" + i + "]模" + (i-3) + "的值：" + intArray[i] % (i-3));
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("intArray数组下标越界异常");
		}catch(ArithmeticException e){
			System.out.println("除数为0异常");
		}
		System.out.println("程序正常结束！");
	}

}
