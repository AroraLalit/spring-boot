package com.rbs.spring;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClass {
	
	private IgniteRdxApi igniteRdxApi;
	
	public TestClass(IgniteRdxApi igniteRdxApi) {
		this.igniteRdxApi = igniteRdxApi;
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		TestClass testClass = new TestClass(new IgniteRdxApi());
		System.out.println(testClass.getClassForTest());
	}
	
//	private void testMethod(){
//		getClassForTest();
//	}
	
	public Class<? extends IgniteRdxApi> getClassForTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println(igniteRdxApi.getClass());
		Method sayHello = igniteRdxApi.getClass().getDeclaredMethod("sayHello");
		String string = (String) sayHello.invoke(igniteRdxApi);
		System.out.println(string+"gessaadf adfas");
		return igniteRdxApi.getClass();
	}

}
