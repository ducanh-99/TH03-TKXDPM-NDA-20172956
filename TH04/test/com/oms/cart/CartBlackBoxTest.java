package com.oms.cart;

import static org.junit.Assert.*;

import org.junit.Test;

import com.oms.components.cart.controller.CartController;

public class CartBlackBoxTest {
	private CartController controller = new CartController();
	

	@Test
	public void test() {
		controller.addToCart("", "", 1, 1, 1);
		String value = "Your cart has 1 products. Total Cost: 1";
		assertEquals("Size is 1", controller.getPresentationText(),value);
	}

}
