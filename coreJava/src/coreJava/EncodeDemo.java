package coreJava;

import java.io.UnsupportedEncodingException;
/*
 * Java�ļ��ı���
 */
public class EncodeDemo {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "ĭĭҪŬ��ABC";
		byte[] byte1 = s.getBytes();//ת�����ֽ������õ�����ĿĬ�ϱ���
		for (byte b : byte1) {
			//���ֽ�ת����int����16���Ƶķ�ʽ��ʾ
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		
		//gbk���룬����ռ��2���ֽڣ�Ӣ��ռ��1���ֽ�
		byte[] bytes2 = s.getBytes("gbk");
		for (byte b : bytes2) {
			//���ֽ�ת����int����16���Ƶķ�ʽ��ʾ
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		
		//utf-8��������ռ��3���ֽڣ�Ӣ��ռ��1���ֽ�
		byte[] bytes3 = s.getBytes("utf-8");
		for (byte b : bytes3) {
			//���ֽ�ת����int����16���Ƶķ�ʽ��ʾ
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		
		//Java��˫�ֽڱ��룬utf-16be
		//utf-16be ����ռ��2���ֽڣ�Ӣ��ռ��2���ֽ�
		byte[] bytes4 = s.getBytes("utf-16be");
		for (byte b : bytes4) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();
		
		/*
		 * ������ֽ�������ĳ�ֱ���ʱ����ʱ������ֽ����б���ַ�����
		 * Ҳ��Ҫ���ֱ��뷽ʽ��������������
		 */
		String str1 = new String(bytes4);//����ĿĬ�ϱ���
		System.out.println(str1);
		String str2 = new String(bytes4,"utf-16be");
		System.out.println(str2);
		/*
		 * �ı��ļ��������ֽ�����
		 * ���������������ֽ�����
		 * ������������Ļ�����ֱ�Ӵ����ı��ļ�����ô���ı��ļ�ֻ��ʶansi����
		 */
	}
}
