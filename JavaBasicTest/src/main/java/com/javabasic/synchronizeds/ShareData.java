package com.javabasic.synchronizeds;

public class ShareData {
	
	int num;
	
	public synchronized void increase1() {
		num++;
	}
	
	public void increase2() {
		synchronized(this) {
			num++;
		}
	}
	
	public void increase3() {
		synchronized(ShareData.class) {
			num++;
		}
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
