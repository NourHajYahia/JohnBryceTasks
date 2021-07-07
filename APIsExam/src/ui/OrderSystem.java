package ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import core.Order;
import core.OrderTask;

public class OrderSystem {

	private static final Scanner sc = new Scanner(System.in);
	private boolean systemOn = true;
	private Set<Order> orders = new TreeSet<Order>();
	private OrderTask task = new OrderTask(orders);

	public static void main(String[] args) {
		OrderSystem app = new OrderSystem();
		app.start();

	}

	private boolean addOrder(Order order) {
		return orders.add(order);
	}


	private void getOrderFromUser() throws Exception {
		System.out.print("order descripstion: ");
		String description = sc.nextLine();
		System.out.print("order time (hh:mm:ss): ");
		String time = sc.nextLine();
		LocalTime localTime = LocalTime.parse(time);
		
		if (LocalTime.now().isBefore(localTime)) {
			System.out.print("is the order important [yes / no]: ");
			String importance = sc.nextLine();
			LocalDateTime readyOn = LocalDateTime.of(LocalDate.now(), LocalTime.parse(time));
			if (importance.equalsIgnoreCase("yes")) {
				Order order = new Order(readyOn, description, true);
				if (!addOrder(order)) {
					throw new Exception("the requested order is already added");
				}
			} else if (importance.equalsIgnoreCase("no")) {
				Order order = new Order(readyOn, description, false);
				if (!addOrder(order)) {
					throw new Exception("the requested order is already added");
				}
			} else {
				throw new Exception("invalid input type: yes or no to answer the quition");
			}

		}else {
		throw new Exception("order time is in the past, enter a futer time");
		}
	}

	private void doDisplay() {
		System.out.println("========== All Order ==========");
		for (Order order : orders) {
			System.out.println(order);
		}

		System.out.println("==============================");
	}

	private void doQuit() {
		sc.close();
		task.stopMonitoring();
		systemOn = false;
	}

	private void orderMenu() {
		System.out.println();
		System.out.println("========== Order Menu ==========");
		System.out.println("add order .......................................... 1 / add");
		System.out.println("show orders ..................................... 2 / disp");
		System.out.println("quit ........................................................ 0 / q");
		System.out.println("================================");

	}

	private void start() {
		task.startMonitoring();

		try {
			Thread.sleep(1_000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (systemOn) {
			orderMenu();
			System.out.print("Please enter your choice from above: ");
			String choice = sc.nextLine();

			try {
				switch (choice) {
				case "1":
				case "add":
					getOrderFromUser();
					break;

				case "2":
				case "disp":
					doDisplay();
					break;

				case "0":
				case "q":
					doQuit();
					break;

				default:
					break;
				}
			} catch (Exception e) {
				System.out.println("Error is: " + e.getMessage());
			}
		}
	}
}
