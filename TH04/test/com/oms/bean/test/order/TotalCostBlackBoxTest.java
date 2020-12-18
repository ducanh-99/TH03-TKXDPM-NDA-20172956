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
public class TotalCostBlackBoxTest {
	private Order order = new Order();
	private float expectedResult;

	public TotalCostBlackBoxTest(ArrayList<OrderLine> orderLines, String address, float expectedResult) {
		super();
		this.order.setOrderLines(orderLines);
		this.order.setCustomerAddress(address);
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> primeNumbers() {
		ArrayList<OrderLine> order1 = new ArrayList<OrderLine>();
		order1.add(new OrderLine("1", "", 10, 2, 2));
		ArrayList<OrderLine> order2 = new ArrayList<OrderLine>();
		order2.add(new OrderLine("2", "", 10, 3, 1));
		order2.add(new OrderLine("2", "", 15, 3));
		
		ArrayList<OrderLine> order3 = new ArrayList<OrderLine>();
		order3.add(new OrderLine("1", "", 10, 2, 10));
		ArrayList<OrderLine> order4 = new ArrayList<OrderLine>();
		order4.add(new OrderLine("1", "", -5, 2, 10));
		return Arrays.asList(new Object[][] { { order1, "hn", 22020 },
			{order2, "Bac giang", 30075},
			{ order3, "Thành phố hcm", 57020 },
			{ order4, "Ninh Binh", 0 },
//			{ "Python", "Python Programming" }
		});
	}

	@Test
	public void getTotalOrder() {
		Object total = this.order.getTotalCost();
//		float value = 0;
		assertEquals("not equals 0", total, expectedResult);
	}

}
