package iterator;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BookShelf bookShelf = new BookShelf(4);
		bookShelf.appendBook(new Book("No1"));
		bookShelf.appendBook(new Book("No2"));
		bookShelf.appendBook(new Book("No3"));
		bookShelf.appendBook(new Book("No4"));

		Iterator it = bookShelf.iterator();

		while(it.hasNext()){
			Book book = (Book) it.next();
			System.out.println(book.getName());
		}

	}

}
