package abstractFactory.listfactory;

import java.util.Iterator;

import abstractFactory.factory.Item;
import abstractFactory.factory.Page;

public class ListPage extends Page{
	public ListPage(String title, String author){
		super(title, author);
	}
	public String makeHTML(){
		StringBuffer b = new StringBuffer();
		b.append("<html><head><title>" + title + "</title></head>\n");
		b.append("<body>\n");
		b.append("<h1>" + title + "</h1>\n");
		b.append("<ul>\n");
		Iterator it = content.iterator();
		while(it.hasNext()){
			Item i = (Item) it.next();
			b.append(i.makeHTML());
		}
		b.append("</ul>\n");
		b.append("<hr><address>" + author + "</address>");
		b.append("</body></html>\n");
		return b.toString();
	}
}
