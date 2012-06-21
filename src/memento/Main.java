package memento;

import memento.game.Gamer;
import memento.game.Memento;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Gamer gamer = new Gamer(100);
		Memento m = gamer.createMemento();

		for(int i = 0; i < 100; i++){
			System.out.println("==== " + i);
			System.out.println("現状:" + gamer);

			gamer.bet();

			System.out.println("所持金は" + gamer.getMoney() + "円になりました。");

			//Mementoの取り扱いの決定
			if(gamer.getMoney() > m.getMoney()){
				System.out.println("所持金が増えたので、現在の状態を記録します。");
				m = gamer.createMemento();
			}else if(gamer.getMoney() < m.getMoney() / 2){
				System.out.println("所持金が減ったので、過去の状態に巻き戻します。");
				gamer.restorMemento(m);
			}

			//wait
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println("");
		}
	}

}
