package coreJava;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
/*
 * 对文件的读写操作
 */
public class RafDemo{

	private static RandomAccessFile raf;

	public static void main(String[] args) throws IOException{
		File demo = new File("demo");
		if(!demo.exists()){
			demo.mkdir();
			File file = new File(demo,"raf.txt");
			if(!file.exists()){
				file.createNewFile();
			}
			raf = new RandomAccessFile(file,"rw");
			//指针的位置
			System.out.println("指针的起始位置为" + raf.getFilePointer());
			
			raf.write('A');//只写了一个字节
			System.out.println("读入‘A’之后指针的位置为" + raf.getFilePointer());
			raf.write('B');//只写了一个字节
			System.out.println("读入‘B’之后指针的位置为" + raf.getFilePointer());
			
			int i = 0x7fffffff;//最大的整数
			//用write方法每次只能写一个字节，如果要把i写进去需要写4次
			raf.write(i >>> 24);//高8位
			raf.write(i >>> 16);
			raf.write(i >>> 8);
			raf.write(i);
			System.out.println("int类型占4字节，逐个字节写入整数（0x7fffffff）后指针的位置为" + raf.getFilePointer());
			
			//直接写一个int
			raf.writeInt(i);
			System.out.println("直接写入整数（0x7fffffff）后指针的位置为" + raf.getFilePointer());
			
			String s = "中";
			byte[] gbk = s.getBytes("gbk");
			raf.write(gbk);
			System.out.println("汉字占两个字节，读入一个汉字之后，指针的位置为" + raf.getFilePointer());
			
			//读文件，必须把指针移到头部
			raf.seek(0);
			//一次性读取，把文件中的内容都读到字节数组中
			byte[] buf = new byte[(int)raf.length()];
			raf.read(buf);
			
			System.out.println(Arrays.toString(buf));
			for (byte b : buf) {
				System.out.print(Integer.toHexString(b & 0xff) + " ");
			}
			raf.close();
		}
	}
}
