package com.oms.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import javax.swing.JPanel;

import com.oms.components.media.controller.UserMediaPageController;

public class UserPageFactory {
	private static UserPageFactory instance;

	private UserPageFactory() {
		super();
	}

	public static synchronized UserPageFactory getInstance() {
		if (instance == null)
			instance = new UserPageFactory();
		return instance;
	}

	private HashMap<String, Class<?>> m_RegisteredPage = new HashMap<String, Class<?>>();

	public void m_RegisteredPage(String type, Class<?> typeClass) {
		m_RegisteredPage.put(type, typeClass);
	}

	public <T> JPanel createProduct(String productID) throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> productClass = (Class<?>) m_RegisteredPage.get(productID);
		Constructor<?> productConstructor = productClass.getDeclaredConstructor(new Class[] {});

		UserMediaPageController page = (UserMediaPageController) productConstructor.newInstance(new Object[] {});
		return page.getDataPagePane();

	}
}
