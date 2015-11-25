package coreJava;

import java.io.IOException;

public class IOUtilTest2 {

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		IOUtil.printHexByArray("/Users/funmomo/GitHub/Java-Learning/BubbleSort.java");
		System.out.println();
		long end = System.currentTimeMillis();
		System.out.println("文件读入时间为：" + (end - start));
	}
}
