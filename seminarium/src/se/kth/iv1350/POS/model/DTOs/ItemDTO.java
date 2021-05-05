package se.kth.iv1350.POS.model.DTOs;

/**
 * 
 *all items attributes 
 */
public class ItemDTO {
	public String name ;
	public Amount price;
	public double vatRate;
	public String itemIdentifier;

	/**
	 * creates a new instance representing a new item; 
	 * @param  name      		the name of an item
	 * @param  price     		the price of an item
	 * @param  vatRate 	 		the rate of VAT in percent for every item
	 * @param  itemIdentifier 	the identification of an item  
	 */
	public ItemDTO(String name, Amount price, double vatRate, String itemIdentifier) {
		this.name = name;
		this.price = price;
		this.vatRate = vatRate;
		this.itemIdentifier = itemIdentifier;
	}

	/**
	 * returns the name of an item 
	 *@return the name of an item  
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * returns the price of an item 
	 *@return the name of an item  
	 */
	public Amount getPrice() {
		return this.price;
	}

	/**
	 * returns the VAT Rate of an item 
	 *@return the VAT rate of an item  
	 */
	public double getVateRate() {
		return this.vatRate;
	}

	/**
	 * returns the identification of an item 
	 *@return the identification of an item  
	 */
	public String  getItemIdentifier() {
		return this.itemIdentifier;
	}

	/**
	 * returns the price according VAT
	 * @return amount of money
	 */
	public double getPriceAfterVat() {
		return this.price.getAmount() + (1.0 * this.vatRate) ;
	}
	/**
	 *prints item parameter    
	 */
	public void print() {
		System.out.print("id:" + this.itemIdentifier + "    ");
		System.out.print(this.name + "    ");
		System.out.print("VAT:" + this.vatRate + "    ");
		System.out.println(this.price.getAmount() + this.price.getCurrency());
	}

}
