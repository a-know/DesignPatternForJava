package factory;

import factory.framework.Factory;
import factory.framework.Product;
import factory.idcard.IDCardFactory;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Factory factory = new IDCardFactory();
		Product card1 = factory.create("a-know");
		Product card2 = factory.create("b-know");
		Product card3 = factory.create("c-know");
		card1.use();
		card2.use();
		card3.use();
	}

}
