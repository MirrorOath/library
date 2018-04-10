package service;

import org.aspectj.lang.ProceedingJoinPoint;

public class Aop {
	public void begin(){
		System.out.println("Start");
	}
	public void after(){
		System.out.println("End");
	}
	public void around(ProceedingJoinPoint pip){
		
		/*System.out.println("Start");
		try {
			pip.proceed(pip.get);//目标对象中的方法执行
		} catch (Throwable e) {
			//异常信息记录到日志中
		}
		System.out.println("End");*/
	}
}
