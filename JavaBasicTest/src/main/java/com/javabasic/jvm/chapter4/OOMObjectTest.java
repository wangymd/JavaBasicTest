package com.javabasic.jvm.chapter4;

import java.util.ArrayList;
import java.util.List;

/**
 * jconsole
 * @author win7
 *
 */
public class OOMObjectTest {
	
	static class OOMObject{
		public byte[] placeHolder = new byte[64 * 1024];
	}
	
	public static void fileHeap(int num) throws Exception {
		List<OOMObject> list = new ArrayList<OOMObject>();
		for (int i = 0; i < num; i++) {
			Thread.sleep(100);
			list.add(new OOMObject());
		}
		System.gc();
	}

	public static void main(String[] args) throws Exception {
		fileHeap(1000);
		System.out.println("执行完成。。。");
	}

}
