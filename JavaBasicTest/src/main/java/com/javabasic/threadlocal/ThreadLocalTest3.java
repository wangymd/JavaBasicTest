package com.javabasic.threadlocal;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalTest3 {
	
	private static int threadNum = 0;


	private ThreadLocal<Map<String , String>> threadLocalVar = new ThreadLocal<Map<String , String>>() {
		protected synchronized Map<String, String> initialValue() {
			threadNum ++ ;
			return new HashMap<String, String>(0);
		}
	};
	
	public Map<String , String> getThreadLocalManager(){
		return threadLocalVar.get();
	}
	
	public void setAttibute(String key,String value){
		getThreadLocalManager().put(key, value);
	}
	
	public String getAttibute(String key){
		return getThreadLocalManager().get(key);
	}
	
	public void removeAttibute(String key){
		getThreadLocalManager().remove(key);
	}
	
	public void clearAllAttibute(){
		getThreadLocalManager().clear();
	}

	public static int  getThreadNum() {
		return threadNum;
	}
}
