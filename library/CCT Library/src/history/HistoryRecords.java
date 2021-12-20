package history;

import book.LibraryRecords;
import reader.ReaderRecords;

public class HistoryRecords {
	
	private LibraryRecords book = new LibraryRecords();
	private ReaderRecords reader = new ReaderRecords();
	
	public HistoryRecords(LibraryRecords book, ReaderRecords reader) {
		this.book = book;
		this.reader = reader;
	}

	public LibraryRecords getBook() {
		return book;
	}

	public ReaderRecords getReader() {
		return reader;
	}
	

}
