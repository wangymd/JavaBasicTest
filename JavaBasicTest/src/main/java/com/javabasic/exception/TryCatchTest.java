package com.javabasic.exception;

public class TryCatchTest {
	
	public static void main(String[] args) throws Exception{
		
		int sum = 0;
		
		try {
			System.out.println("try发生异常前！");
			sum = ( 2 + 4) / 0;
			System.out.println("try发生异常后！");
		} catch (Exception e) {
			System.out.println("catch捕获到异常！");
//			System.exit(110); //导致finally代码无法执行
		}finally {
			System.out.println("finally最后处理！");
		}
		
	}

}
