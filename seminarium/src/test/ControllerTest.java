package test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.model.DTOs.ItemDTO;

public class ControllerTest {
	Controller contoller;
	
	@Before 
    public void init() {
		contoller = new Controller();
		contoller.addItemToSale("1");
    }

	@Test
	public void testController() {
		int expected = 3;
		int actual = contoller.itemRegistry.items.size();
		assertEquals(expected, actual);
		
		expected = 1;
		actual = contoller.sale.itemList.size();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetItemByID() {
		ItemDTO item = contoller.getItemByID("1");

		String expected = "1";
		String actual = item.itemIdentifier;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testAddItemToSale() {
		contoller.addItemToSale("3");

		String expected = "3";
		String actual = contoller.sale.itemList.get(1).itemIdentifier;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testIsItemExists() {
		boolean actual = contoller.isItemExists("3");
		boolean expected = true;
		assertEquals(expected, actual);
		
		actual = contoller.isItemExists("4");
		expected = false;
		assertEquals(expected, actual);
	}

}
