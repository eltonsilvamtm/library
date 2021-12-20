package borrowings;

public class Borrowing {
	
	private int BookID;
	private int ReaderID;

	
	public Borrowing(int bookID, int readerID) {
		this.BookID = bookID;
		this.ReaderID = readerID;
	}


	public int getBookID() {
		return BookID;
	}

	public int getReaderID() {
		return ReaderID;
	}
	
	
	

}
