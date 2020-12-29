package com.oms.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import javax.swing.JPanel;


import com.oms.components.media.controller.AdminMediaPageController;

public class AdminPageFactory {
	private static AdminPageFactory instance;

	private AdminPageFactory() {
		super();
	}

	public static synchronized AdminPageFactory getInstance() {
		if (instance == null)
			instance = new AdminPageFactory();
		return instance;
	}

	private HashMap<String, Class<?>> m_RegisteredProducts = new HashMap<String, Class<?>>();

	public void registerProduct(String productID, Class<?> productClass) {
		m_RegisteredProducts.put(productID, productClass);
	}

	public <T> JPanel createProduct(String productID) throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<?> productClass = (Class<?>) m_RegisteredProducts.get(productID);
		Constructor<?> productConstructor = productClass.getDeclaredConstructor(new Class[] {});

		AdminMediaPageController page = (AdminMediaPageController) productConstructor.newInstance(new Object[] {});
		return page.getDataPagePane();

	}
}
