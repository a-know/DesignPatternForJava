package facade.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PageMaker {
	private PageMaker(){

	}
	public static void makeWelcomePage(String mailadr, String filename){
		try{
			Properties mailprop = Database.getProperties("maildata");
			String username = mailprop.getProperty(mailadr);
			HtmlWriter writer = new HtmlWriter(new FileWriter(filename));

			writer.title("Welcome!");
			writer.paragraph(username + "のページへようこそ。");
			writer.mailto(mailadr, username);
			writer.close();
			System.out.println(filename + " is created for " + mailadr + "(" + username + ")");
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
