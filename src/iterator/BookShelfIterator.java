package iterator;

public class BookShelfIterator implements Iterator{
	private BookShelf bookshelf;
	private int index;

	public BookShelfIterator(BookShelf bookShelf){
		this.bookshelf = bookShelf;
		this.index = 0;
	}
	public boolean hasNext(){
		if(index < bookshelf.getLength()){
			return true;
		}else{
			return false;
		}
	}
	public Object next(){
		Book book = bookshelf.getBookAt(index);
		index++;
		return book;
	}
}
