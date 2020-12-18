package com.oms.bean;

import java.util.*;

public class Order {
	private String id;
	private String code;
	private String customerName;
	private String customerPhoneNumber;
	private String customerAddress;
	private ArrayList<OrderLine> orderLines;
	private float totalCost;

	public Order() {
		orderLines = new ArrayList<OrderLine>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public ArrayList<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(ArrayList<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public float getTotalCost() {
		float res = 0;
		if (orderLines != null) {
			Iterator<OrderLine> iter = orderLines.iterator();
			while (iter.hasNext()) {
				OrderLine ol = iter.next();
				if (ol.getProductCost() < 0 || ol.getProductQuantity() < 0)
					return 0;
				res += ol.getProductCost() * ol.getProductQuantity();
			}
		}
//		System.out.println(this.getTotalShip());
		System.out.println(res + this.getTotalShip());
		return res + this.getTotalShip();
	}

	private boolean checkHaNoiorHoChiMinh() {
		String address = this.getCustomerAddress();
		System.out.println(this.getCustomerAddress());
		if (address.contains("hn") || address.contains("hà nội") || address.contains("hcm")
				|| address.contains("hồ chí minh")) {
			System.out.println("check true");
			return true;
		}
		return false;
	}

	private float getTotalShip() {
		float res = 0;
		float totalWeight = this.getTotalWeight();
		if (this.getCustomerAddress() == null)
			return res;
		if (this.checkHaNoiorHoChiMinh()) {
			res = 22000;
			if (totalWeight >= 3) {
				res += ((int) (totalWeight - 3) / 0.5) * 2500;
			}
		} else {
			res = 30000;
			if (totalWeight >= 0.5) {
				res += ((int) (totalWeight - 0.5) / 0.5) * 2.5;
			}
		}
		return res;
	}

	public float getTotalWeight() {
		float res = 0;
		if (orderLines != null) {
			Iterator<OrderLine> iter = orderLines.iterator();
			while (iter.hasNext()) {
				OrderLine ol = iter.next();
				res += ol.getProductWeight();
			}
		}
		return res;
	}

	public void addOrderLine(OrderLine orderLine) {
		boolean existed = false;
		for (OrderLine ol : orderLines) {
			if (ol.getProductId().equals(orderLine.getProductId())) {
				ol.setProductQuantity(ol.getProductQuantity() + orderLine.getProductQuantity());
				existed = true;
				break;
			}
		}

		if (!existed) {
			orderLines.add(orderLine);
		}
	}

	public boolean search(Order order) {
		if (this.id != null && !this.id.equals("") && !this.id.contains(order.id)) {
			return false;
		}
		if (this.code != null && !this.code.equals("") && !this.code.contains(order.code)) {
			return false;
		}
		if (this.customerName != null && !this.customerName.equals("")
				&& !this.customerName.contains(order.customerName)) {
			return false;
		}
		if (this.totalCost != 0 && this.totalCost != order.totalCost) {
			return false;
		}
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Order) {
			return this.code.equals(((Order) obj).code);
		}
		return false;
	}
}