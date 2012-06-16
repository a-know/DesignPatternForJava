package builder;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TextBuilder b = new TextBuilder();
		Director  d = new Director(b);
		d.construct();
		String result = b.getResult();
		System.out.println(result);
	}

}
