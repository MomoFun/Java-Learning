package coreJava;

import java.io.File;
import java.io.IOException;
/*
 * 文件的基本处理
 */
public class FileDemo {
	public static void main(String[] args) {
		//了解构造函数的情况几种方式 查帮助 alt+/
		File file = new File("/Users/funmomo/GitHub/Java-Learning/momo");//打开文件
		System.out.println(file.exists());
		if(!file.exists()){
			file.mkdirs();
		}
		//是否是一个目录，如果是目录返回true，如果不是目录或者目录不存在返回false
		System.out.println(file.isDirectory());
		//是否是文件，如果是文件返回true，如果不是文件或者目录不存在返回false
		System.out.println(file.isFile());
		System.out.println("==================================");

		//两种文件打开方式
//		File file2 = new File("/Users/funmomo/GitHub/Java-Learning/momo/i.txt");
		File file2 = new File("/Users/funmomo/GitHub/Java-Learning/momo/","i.txt");
		if(!file2.exists()){
			try {
				file2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//常用的File对象的API
		System.out.println(file2);
		System.out.println(file2.getAbsolutePath());
		System.out.println(file.getName());
		System.out.println(file2.getName());
		System.out.println(file.getParent());
		System.out.println(file2.getParent());
		System.out.println(file.getParentFile().getAbsolutePath());

	}
}
