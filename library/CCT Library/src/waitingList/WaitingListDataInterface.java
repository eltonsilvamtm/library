package waitingList;

import java.util.ArrayList;
import java.util.HashMap;

import book.LibraryRecords;
import reader.ReaderRecords;

public interface WaitingListDataInterface {
	
	
	/**
	 * Read the data from the file and load it in memory
	 */
	public void ReadData();
	
	
	/**
	 * Clear current file, creates a new empty file then
	 * writes the data from the hash map on the file 
	 * @param allTheLists
	 */
	public void WriteData();
	
	
	/**
	 * Deletes the current file and creates a new empty file
	 * @return 
	 */
	public boolean ClearFile();
	
	
	/**
	 * Check whether the reader is on the arraylist inside of the waiting list object
	 * @return true if the reader is on the waiting list, false if not
	 */
	public boolean isReaderQueued(int bookId, int readerId);
	
	
	/**
	 * Check if the book is borrowed
	 * Check whether there is a waiting list for the book
	 * @return true if the book has a waitingList, false if not
	 */
	public boolean isBookQueued(int bookId);
	
	
	/**
	 * run isBookQueued then
	 * Creates a new waiting list for a book
	 * @param bookId
	 * @param readerId
	 * @return the updated hash map
	 */
	public boolean enqueueBook(int bookId, int readerId);
	
	
	/**
	 * Adds a new reader to the waiting list of a book
	 * @param bookId
	 * @param readerId
	 * @return the updated hash map
	 */
	public boolean enqueueReader(int bookId, int readerId);
	
	
	/**
	 * Deletes the waiting list of a book when the last reader borrows the book
	 * @param bookId
	 * @return the updated hash map
	 */
	public void dequeueBook(int bookId);
	
	/**
	 * deletes a reader when he/she borrows the book
	 * @param bookId
	 * @param readerId
	 * @return the updated hash map
	 */
	public void dequeueReader(int bookId);
	
	
	/**
	 * Gets the next reader who will borrow the book
	 * @return the next reader on the position 0 of the array
	 */
	public ReaderRecords getNextReader(int bookId);

}
