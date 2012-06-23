package flyweight;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length == 0){
			System.exit(0);
		}
		BigString bs = new BigString(args[0]);
		bs.print();
	}

}
