package coreJava;

import java.io.File;
import java.io.IOException;
/*
 * �ļ��Ļ�������
 */
public class FileDemo {
	public static void main(String[] args) {
		//�˽⹹�캯����������ַ�ʽ ����� alt+/
		File file = new File("/Users/funmomo/GitHub/Java-Learning/momo");//���ļ�
		System.out.println(file.exists());
		if(!file.exists()){
			file.mkdirs();
		}
		//�Ƿ���һ��Ŀ¼�������Ŀ¼����true���������Ŀ¼����Ŀ¼�����ڷ���false
		System.out.println(file.isDirectory());
		//�Ƿ����ļ���������ļ�����true����������ļ�����Ŀ¼�����ڷ���false
		System.out.println(file.isFile());
		System.out.println("==================================");

		//�����ļ��򿪷�ʽ
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
		//���õ�File�����API
		System.out.println(file2);
		System.out.println(file2.getAbsolutePath());
		System.out.println(file.getName());
		System.out.println(file2.getName());
		System.out.println(file.getParent());
		System.out.println(file2.getParent());
		System.out.println(file.getParentFile().getAbsolutePath());

	}
}
