package history;

import java.util.ArrayList;

import book.LibraryRecords;
import reader.ReaderRecords;

public interface HistoryDataInterface {
	
	
	/**
	 * Load the data into an array list of history 
	 * that will contain a book and a reader
	 */
	public void LoadData();
	
	
	/**
	 * 
	 * @param bookId to search for the book
	 * @param readerId to search for the reader
	 * @return true if written, false if not
	 */
	public void WriteBorrow(int bookId, int readerId);
	
	
	/**
	 * 
	 * @param readerId to search for the reader
	 * @return an array list with all the books that a reader borrowed
	 */
	public ArrayList<LibraryRecords> FindBooks(int readerId);
	
	
	/**
	 * 
	 * @param bookId to search for the book
	 * @return an array list with all the readers that borrowed that book
	 */
	public ArrayList<ReaderRecords> FindReaders(int bookId);
	
	
	/**
	 * prints all the books that a reader has already borrowed
	 * @param readerId
	 */
	public void printBooks(int readerId);
	
	
	/**
	 * prints all the readers that a book has been already borrowed to
	 * @param bookId
	 */
	public void printReaders(int bookId);
	

}
