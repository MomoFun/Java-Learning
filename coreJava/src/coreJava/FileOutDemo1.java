package coreJava;

import java.io.FileOutputStream;
import java.io.IOException;
/*
 * 向文件中写入
 */
public class FileOutDemo1 {
	public static void main(String[] args) throws IOException{
		// 如果文件不存在，则直接创建；如果存在，删除后创建
		FileOutputStream out = new FileOutputStream("demo/out.dat");
		//如果存在,在现有文件之后写
		//FileOutputStream out = new FileOutputStream("demo/out.dat",true);

		out.write('A');//写出‘A’的低八位
		out.write('B');//写出‘B’的低八位
		int a = 10;//write只能写八位，那么写一个int需要写4次，每次8位
		out.write(a >>> 24);
		out.write(a >>> 16);
		out.write(a >>> 8);
		out.write(a);
		byte[] gbk = "中国".getBytes("gbk");
		out.write(gbk);
		out.close();
		
		IOUtil.printHex("demo/out.dat");
		
	}

}
