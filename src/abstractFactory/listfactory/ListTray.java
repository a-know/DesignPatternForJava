package abstractFactory.listfactory;

import java.util.Iterator;

import abstractFactory.factory.Item;
import abstractFactory.factory.Tray;

public class ListTray extends Tray {

	public ListTray(String caption) {
		super(caption);
	}

	public String makeHTML(){
		StringBuffer b = new StringBuffer();
		b.append("<li>\n");
		b.append(caption + "\n");
		b.append("<ul>\n");
		Iterator it = tray.iterator();
		while(it.hasNext()){
			Item i = (Item) it.next();
			b.append(i.makeHTML());
		}
		b.append("</ul>\n");
		b.append("</li>\n");
		return b.toString();
	}

}
