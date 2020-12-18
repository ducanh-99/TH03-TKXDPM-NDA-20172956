package com.oms.bean.test.order;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.oms.bean.Order;
import com.oms.bean.OrderLine;

@RunWith(Parameterized.class)
public class TotalCostWhiteBoxTest {
	private Order order = new Order();
	private float expectedResult;
	
	
	public TotalCostWhiteBoxTest(ArrayList<OrderLine> orderLines, float expectedResult) {
		super();
		this.order.setOrderLines(orderLines);
		this.expectedResult = expectedResult;
	}
	

	@Parameterized.Parameters
	public static Collection<Object[]> primeNumbers() {
		ArrayList<OrderLine> order1 = new ArrayList<OrderLine>();
		order1.add(new OrderLine("1", "", 10, 2, 10));
		ArrayList<OrderLine> order2 = new ArrayList<OrderLine>();
		order2.add(new OrderLine("2", "", 10, 3, 10));
		order2.add(new OrderLine("2", "", 15, 3, 10));
		return Arrays.asList(new Object[][] { 
			{ order1 , 20},
			{ order2, 75 }
//			{ "Python", "Python Programming" }
		});
	}

	@Test
	public void getTotalOrder() {
		Object total =  this.order.getTotalCost();
//		float value = 0;
		assertEquals("not equals 0", total , expectedResult);

	}

}
