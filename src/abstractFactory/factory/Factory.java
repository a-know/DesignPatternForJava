package abstractFactory.factory;

public abstract class Factory {
	public static Factory getFactory(String className){
		Factory f = null;
		try{
			f = (Factory) Class.forName(className).newInstance();
		}catch(ClassNotFoundException e){
			System.err.println("クラス" + className + "が見つかりません。");
		}catch(Exception e){
			e.printStackTrace();
		}
		return f;
	}
	public abstract Link createLink(String caption, String url);
	public abstract Tray createTray(String caption);
	public abstract Page createPage(String title, String author);
}
