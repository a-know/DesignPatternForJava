package strategy;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int seed1 = 15;
		int seed2 = 314;

		Player p1 = new Player("Taro", new WinningStrategy(seed1));
		Player p2 = new Player("hana", new ProbStrategy(seed2));

		for(int i = 0; i < 10000; i++){
			Hand n1 = p1.nextHand();
			Hand n2 = p2.nextHand();

			if(n1.isStrongerThan(n2)){
				System.out.println("Winner:" + p1);
				p1.win();
				p2.lose();
			}else if(n2.isStrongerThan(n1)){
				System.out.println("Winner:" + p2);
				p1.lose();
				p2.win();
			}else{
				System.out.println("Even...");
				p1.even();
				p2.even();
			}
		}
		System.out.println("Total result:");
		System.out.println(p1.toString());
		System.out.println(p2.toString());
	}

}
