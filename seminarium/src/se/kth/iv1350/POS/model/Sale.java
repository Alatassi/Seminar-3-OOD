package se.kth.iv1350.POS.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.POS.model.DTOs.Amount;
import se.kth.iv1350.POS.model.DTOs.ItemDTO;
/**
 * make new instance of sale    
 */
public class Sale {
	public List<ItemDTO> itemList;
	private String dateAndTime;
	public Sale() {
		itemList = new ArrayList<>();
		dateAndTime = LocalDateTime.now().toString();

	}
	/**
	 * add item to the receipt 
	 * @param item to be added to receipt 
	 */
	public void addItem(ItemDTO item) {
		itemList.add(item);
	}

	/** 
	 *@return the total price of all items in the receipt  
	 */
	public ItemDTO getSum() {
		double finalPrice = 0;
		for (ItemDTO item : itemList) {
			finalPrice += item.getPriceAfterVat();
		}
		Amount amount = new Amount((int)finalPrice, itemList.get(0).getPrice().getCurrency());
		return new ItemDTO("total", amount, 1, "total");
	}

	/**
	 *@return prints all items in the receipt in addition to the total price
	 */
	public double vat = 0.00;
	public void printReciept() {
		for (ItemDTO item : itemList) {
			item.print();
		}
		if(itemList.size()>0) {
			System.out.println(dateAndTime);
			ItemDTO total = getSum();
			System.out.println("total vat: " + vat + total.getPrice().getCurrency());
			System.out.println("total price including vat: " + (total.getPriceAfterVat()+ vat));
			
		}

	}
	public void endSale() {
		setFinalVat();
	}
	private void setFinalVat() {
		for (ItemDTO item : itemList) {
			vat += item.getPrice().getAmount() * item.getVateRate();
		}
	}
}
