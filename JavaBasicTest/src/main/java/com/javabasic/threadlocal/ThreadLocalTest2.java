package com.javabasic.threadlocal;

public class ThreadLocalTest2 {
	
	private static int threadNum = 0;

	private String userid;
	
	private String password;

	private static ThreadLocal<ThreadLocalTest2> threadLocal = new ThreadLocal<ThreadLocalTest2>() {
		protected synchronized ThreadLocalTest2 initialValue() {
			threadNum ++ ;
			return new ThreadLocalTest2();
		}
	};
	
	public static ThreadLocalTest2 getThreadLocalManager(){
		return threadLocal.get();
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public static int  getThreadNum() {
		return threadNum;
	}
}
