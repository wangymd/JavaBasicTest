package com.javabasic.enums;

public class Pizza {
	private PizzaStatus status;

	public enum PizzaStatus {
		ORDERED, READY, DELIVERED;
	}

	public boolean isDeliverable() {
		if (getStatus() == PizzaStatus.READY) {
			return true;
		}
		return false;
	}

	public PizzaStatus getStatus() {
		return status;
	}

	public void setStatus(PizzaStatus status) {
		this.status = status;
	}
	

	public void deliver() {
	    if (isDeliverable()) {
	        PizzaDeliverySystemConfiguration.getInstance().getDeliveryStrategy().deliver(this);
	        this.setStatus(PizzaStatus.DELIVERED);
	    }
	}
	
	public static void main(String[] args) {
//		Pizza testPz = null;
//		if(testPz.getStatus().equals(Pizza.PizzaStatus.DELIVERED));//java.lang.NullPointerException
		
		Pizza testPz = new Pizza();
		//if(testPz.getStatus().equals(Pizza.PizzaStatus.DELIVERED));//java.lang.NullPointerException
		if(testPz.getStatus() == Pizza.PizzaStatus.DELIVERED);
		System.out.println(1);
	}
}