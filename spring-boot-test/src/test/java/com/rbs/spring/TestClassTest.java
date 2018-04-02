package com.rbs.spring;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mock;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.MockGateway;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({IgniteRdxApi.class, TestClass.class})
public class TestClassTest {

	private IgniteRdxApi igniteRdxApi;

	@Before
	public void setupMock() {
		igniteRdxApi = mock(IgniteRdxApi.class);
	}

	@Test
	public void testMockCreation() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		MockGateway.MOCK_GET_CLASS_METHOD = true;
		TestClass testClass = new TestClass(igniteRdxApi);
		Method method = IgniteRdxApi.class.getDeclaredMethod("sayHello");
		Mockito.doReturn(IgniteRdxApi.class).when(igniteRdxApi).getClass();
		
		Mockito.doReturn(method).when(igniteRdxApi).getClass().getDeclaredMethod("sayHello");
//		Mockito.when(classs.getDeclaredMethod("sayHello")).thenReturn(method);
		assertEquals(IgniteRdxApi.class, igniteRdxApi.getClass());
//		assertNull(igniteRdxApi.getClass());
//		when(igniteRdxApi.getClass()).thenReturn(new Object());
		testClass.getClassForTest();

		
	}

}
