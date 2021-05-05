/**
 * 
 */
package se.kth.iv1350.POS.startUp;
import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.view.*;
/**
 * @author Sadeq
 *
 */
public class Main {

	/**
	 * @param args
	 * change the comment in main 
	 */
	public static void main(String[] args) {
		Controller contr = new Controller();
        View view = new View(contr);
        view.runFakeSale();
	}

}
