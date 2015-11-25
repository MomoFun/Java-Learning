package coreJava;

import java.io.File;
import java.io.IOException;
//�г�File���һЩ���ò�����������ˣ������Ȳ���
public class FileUtils {
	/*
	 * �г�ָ��Ŀ¼�£���������Ŀ¼���������ļ�
	 */
	public static void listDirectory(File dir)throws IOException{
		if(!dir.exists()){
			throw new IllegalArgumentException("Ŀ¼" + dir + "�����ڣ�");
		}
		if(!dir.isDirectory()){
			throw new IllegalArgumentException(dir + "����Ŀ¼");
		}
		
		//���Ҫ������Ŀ¼�µ����ݣ�����Ҫ�����File�������ݹ������File�ṩ��ֱ��File�����API
		File[] files = dir.listFiles();//���ص���ֱ����Ŀ¼���ļ����ĳ���
		if(files != null && files.length > 0){
			for (File file : files) {
				if(file.isDirectory()){
					//�ݹ�
					listDirectory(file);
				}else{
					System.out.println(file);
				}
			}
		}
	}
}
