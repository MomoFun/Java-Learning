package coreJava;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
/*
 * ���ļ��Ķ�д����
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
			//ָ���λ��
			System.out.println("ָ�����ʼλ��Ϊ" + raf.getFilePointer());
			
			raf.write('A');//ֻд��һ���ֽ�
			System.out.println("���롮A��֮��ָ���λ��Ϊ" + raf.getFilePointer());
			raf.write('B');//ֻд��һ���ֽ�
			System.out.println("���롮B��֮��ָ���λ��Ϊ" + raf.getFilePointer());
			
			int i = 0x7fffffff;//��������
			//��write����ÿ��ֻ��дһ���ֽڣ����Ҫ��iд��ȥ��Ҫд4��
			raf.write(i >>> 24);//��8λ
			raf.write(i >>> 16);
			raf.write(i >>> 8);
			raf.write(i);
			System.out.println("int����ռ4�ֽڣ�����ֽ�д��������0x7fffffff����ָ���λ��Ϊ" + raf.getFilePointer());
			
			//ֱ��дһ��int
			raf.writeInt(i);
			System.out.println("ֱ��д��������0x7fffffff����ָ���λ��Ϊ" + raf.getFilePointer());
			
			String s = "��";
			byte[] gbk = s.getBytes("gbk");
			raf.write(gbk);
			System.out.println("����ռ�����ֽڣ�����һ������֮��ָ���λ��Ϊ" + raf.getFilePointer());
			
			//���ļ��������ָ���Ƶ�ͷ��
			raf.seek(0);
			//һ���Զ�ȡ�����ļ��е����ݶ������ֽ�������
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
