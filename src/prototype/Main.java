package prototype;

import prototype.framework.Manager;
import prototype.framework.Product;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//prepare
		Manager manager = new Manager();
		UnderLinePen upen = new UnderLinePen('~');
		MessageBox mbox = new MessageBox('*');
		MessageBox sbox = new MessageBox('/');
		manager.register("strong message", upen);
		manager.register("warning box", mbox);
		manager.register("slash box", sbox);

		//generate
		Product p1 = manager.create("strong message");
		p1.use("Hello.");
		Product p2 = manager.create("warning box");
		p2.use("Hello.");
		Product p3 = manager.create("slash box");
		p3.use("Hello.");
	}

}
