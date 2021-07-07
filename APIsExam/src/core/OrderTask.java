package core;

import java.time.LocalDateTime;
import java.util.Set;

public class OrderTask extends Thread {
	
	private Set<Order> orders;
	private boolean monitoringActive;
	
	
	/**
	 * @param orders
	 */
	public OrderTask(Set<Order> orders) {
		super();
		this.orders = orders;
	}
	
	public void startMonitoring() {
		if (monitoringActive == false) {
			this.start();
			monitoringActive = true;
		}else {
			throw new RuntimeException("order monitoring is already active");
		}
	}
	
	public void stopMonitoring() {
		monitoringActive = false;
	}

	public void cheackOrederReady() {
		LocalDateTime now = LocalDateTime.now();
		for (Order order : orders) {
			if(order.getReadyOn().isBefore(now) && !order.isPoped()) {
				System.out.println(">>>>>>>  ORDER READY: " + order);
				order.setPoped(true);
				
				if (order.isImportant()) {
					Thread importantOrder = new ImportantOrederTask(order);
					importantOrder.start();
					
				}
			}
		}
	}
	


	@Override
	public void run() {
		System.out.println("Started monitoring orders");
		
		while (monitoringActive) {
			cheackOrederReady();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("Stoped monitoring orders");

	}
	
	public class ImportantOrederTask extends Thread {
		
		private Order order;
		
		
		public ImportantOrederTask(Order order) {
			super();
			this.order = order;
		}
		
		
		@Override
		public void run() {
			
			for (int i = 0; i < 3; i++) {
				try {
					Thread.sleep(60 * 1_000);
					System.out.println(">>>>>>>  " + "ORDER READY: Reminder "  + (i+1) + ": "  + order);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}


}
