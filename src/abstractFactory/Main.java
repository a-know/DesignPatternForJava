package abstractFactory;

import abstractFactory.factory.Factory;
import abstractFactory.factory.Link;
import abstractFactory.factory.Page;
import abstractFactory.factory.Tray;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Factory f = Factory.getFactory("abstractFactory.listfactory.ListFactory");

		Link asahi = f.createLink("朝日新聞", "asahi");
		Link yomiuri = f.createLink("読売新聞", "yomiuri");

		Link us_yahoo = f.createLink("Yahoo!", "yahoo");
		Link jp_yahoo = f.createLink("Yahoo! Japan", "yahoojp");
		Link google = f.createLink("google", "google");

		Tray traynews = f.createTray("新聞");
		traynews.add(asahi);
		traynews.add(yomiuri);

		Tray trayyahoo = f.createTray("Yahoo!");
		trayyahoo.add(us_yahoo);
		trayyahoo.add(jp_yahoo);

		Tray traysearch = f.createTray("サーチエンジン");
		traysearch.add(trayyahoo);
		traysearch.add(google);

		Page p = f.createPage("LinkPage", "a-know");
		p.add(traynews);
		p.add(traysearch);
		p.output();
	}

}
