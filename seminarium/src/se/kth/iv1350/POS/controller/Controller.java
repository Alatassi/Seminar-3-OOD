/**
 * 
 */
package se.kth.iv1350.POS.controller;

import se.kth.iv1350.POS.model.DTOs.ItemDTO;
import se.kth.iv1350.POS.model.dbHandler.ItemRegistry;
import se.kth.iv1350.POS.model.extrnalSystem.Tax;
import se.kth.iv1350.POS.model.extrnalSystem.Printer;
import se.kth.iv1350.POS.model.*;
/**
 * 
 *
 * 
 */

public class Controller {
	public Sale sale;
	public ItemRegistry itemRegistry;

	
	public Controller() {
		this.sale = new Sale();
		this.itemRegistry = new ItemRegistry();

	}

	public ItemDTO getItemByID(String id) {
		return itemRegistry.getItemByID(id);
	}

	public void addItemToSale(String id) {
		ItemDTO item = getItemByID(id);
		sale.addItem(item);
	}

	public void printReciept() {
		sale.printReciept();
	}

	public void printItem(String id) {
		ItemDTO item = getItemByID(id);
		item.print();
	}

	public boolean isItemExists(String id) {
		ItemDTO item = getItemByID(id);
		return item != null;
	}

	public void sendToTax() {
		int sendResult = Tax.sendToTax(sale.getSum().getPriceAfterVat(), sale.vat);
		if(sendResult == 200)
			System.out.println("The reciept is sent successfully to tax");
		else
			System.err.println("Error: cannot send the reciept to tax. The error code: " + sendResult);
	}

	public void endSale() {
		sale.endSale();
		
	}

	public void sendToPrintr() {
		boolean printResult = Printer.print(sale);
		if(printResult)
			System.out.println("Printed");
		else
			System.out.println("Error while printing");
		
	}
}
