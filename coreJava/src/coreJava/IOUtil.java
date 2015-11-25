package coreJava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtil {
	/*
	 * ��ȡָ���ļ����ݣ�����16�������������̨
	 * ����ÿ���10��byte����
	 */
	/*
	 * ���ֽڶ�ȡ���������ڴ��ļ�
	 */
	public static void printHex(String fileName) throws IOException{
		//���ļ���Ϊ�ֽ������ж�����
		FileInputStream in = new FileInputStream(fileName);
		int b;
		int i = 1;
		while((b = in.read())!=-1){
			if(b <= 0xf){
				//��λ��ǰ�油��
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
	 * ������ȡ���Դ��ļ�����Ч�ʸߣ�Ҳ��������õĶ��ļ��ķ�ʽ
	 */
	public static void printHexByArray(String fileName) throws IOException{
		FileInputStream in = new FileInputStream(fileName);
		byte[] buf = new byte[20 * 1024];//��ʼ����СΪ20K���ַ�����
		//��in��������ȡ�ֽڣ����뵽buf����ֽ��У���0��λ�ÿ�ʼ�ţ�����buf.length��
		//���ص��Ƕ����ֽڵĸ���
		int bytes = 0;
		int j = 1;
		while((bytes = in.read(buf,0,buf.length)) != -1){ //һ���Զ��꣬˵���ֽ������㹻��
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
	 * �ļ��Ŀ�������
	 */
	public static void copyFile(File srcFile, File destFile) throws IOException{
		if(!srcFile.exists()){
			throw new IllegalArgumentException("�ļ������ڣ�");
		}
		if(!srcFile.isFile()){
			throw new IllegalArgumentException(srcFile + "�����ļ���");
		}
		FileInputStream in = new FileInputStream(srcFile);//������
		FileOutputStream out = new FileOutputStream(destFile);//д������destFile������ʱ�����Զ�����
		byte[] buf = new byte[8 * 1024];
		int b;
		while((b = in.read(buf,0,buf.length))!=-1){
			out.write(buf, 0, b);
			out.flush();//��ü���
		}
		in.close();
		out.close();
	}
	
}
