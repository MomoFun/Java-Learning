package coreJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtil {
	/*
	 * 读取指定文件内容，按照16进制输出到控制台
	 * 并且每输出10个byte换行
	 */
	/*
	 * 单字节读取，不适用于大文件
	 */
	public static void printHex(String fileName) throws IOException{
		//把文件作为字节流进行读操作
		FileInputStream in = new FileInputStream(fileName);
		int b;
		int i = 1;
		while((b = in.read())!=-1){
			if(b <= 0xf){
				//单位数前面补零
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b) + " ");
			if(i++%10 == 0){
				System.out.println();
			}
		}
		in.close();
	}
	/*
	 * 批量读取，对大文件而言效率高，也是我们最常用的读文件的方式
	 */
	public static void printHexByArray(String fileName) throws IOException{
		FileInputStream in = new FileInputStream(fileName);
		byte[] buf = new byte[20 * 1024];//初始化大小为20K的字符数组
		//从in中批量读取字节，放入到buf这个字节中，从0个位置开始放，最多放buf.length个
		//返回的是读到字节的个数
		int bytes = 0;
		int j = 1;
		while((bytes = in.read(buf,0,buf.length)) != -1){ //一次性读完，说明字节数组足够大
			for(int i = 0; i < bytes; i++){
				if((buf[i] & 0xff) <= 0xf){
					System.out.print("0");
				}
				System.out.print(Integer.toHexString(buf[i] & 0xff) + " ");
				if(j++ % 10 == 0){
					System.out.println();
				}
			}
		}
		in.close();
	}
	/*
	 * 文件的拷贝操作
	 */
	public static void copyFile(File srcFile, File destFile) throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("文件不存在！");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile + "不是文件！");
		}
		FileInputStream in = new FileInputStream(srcFile);//读操作
		FileOutputStream out = new FileOutputStream(destFile);//写操作，destFile不存在时，会自动创建
		byte[] buf = new byte[8 * 1024];
		int b;
		while((b = in.read(buf,0,buf.length))!=-1){
			out.write(buf, 0, b);
			out.flush();//最好加上
		}
		in.close();
		out.close();
	}
	
}
