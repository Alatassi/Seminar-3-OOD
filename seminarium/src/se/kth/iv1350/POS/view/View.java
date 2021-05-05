package se.kth.iv1350.POS.view;
import java.util.Scanner;

import se.kth.iv1350.POS.controller.*;

/**
 *create new view to start a new sale     
 */
public class View {
	private Controller contr;
	Scanner scan = new Scanner(System.in);

	public View(Controller contr) {
		this.contr = contr;
	}

	public void runFakeSale() {
		System.out.println("New sale was started.");
		String id = getNextItemId();
		while(!id.equals("0")) {
			boolean isItemExists = contr.isItemExists(id);
			if(isItemExists) {
				contr.addItemToSale(id);
				contr.printItem(id);
			} else {
				System.out.println("Item does not exists");
			}
			id = getNextItemId();
		}
		contr.endSale();
		contr.printReciept();
		System.out.println("----------------------------------");
		contr.sendToTax();
		contr.sendToPrintr();
	}
	
	private String getNextItemId() {
		System.out.println("Enter the item id (to end, enter 0): ");

		String result = scan.nextLine();
		//			scan.close();
		return result;
	}
}
