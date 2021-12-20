package borrowings;

import java.util.ArrayList;

public interface BorrowABookInterface {
	
	/**
	 * Responsible for checking whether the book was borrowed or not.
	 * @BookID the bookID that will be checked 
	 * @return true for borrowed or false for not borrowed
	 */
	public boolean isBookBorrowed(int BookID);
	
	/**
	 * Responsible for borrowing a book.
	 * First check if the book is borrowed.
	 * If not, it will add the book id and the reader id 
	 * into an array list via a Borrowing object.
	 * Add the item into the borrowings array.
	 * Call method to clear the borrowings file.
	 * Update the file with all the entries from the array.
	 * @return true if book was borrowed, false if not
	 * @BookID book that will be borrowed
	 * @ReaderID reader that will borrow the book
	 */
	public boolean borrow(int BookID, int ReaderID);
	
	/**
	 * Returns the book to the library
	 * Call isBookBorrowed.
	 * Proceed only if false.
	 * Remove object from the array.
	 * Overwrite Borrowings file.
	 * @BookID book to be returned
	 * @return true for returned or false if not returned
	 */
	public boolean returnBook(int BookID);
	
	/**
	 * Clear the current file and
	 * writes the full array into the Borrowings file.
	 * 
	 * @param list of borrowings
	 */
	public void WriteToBorrowings(ArrayList<Borrowing> borrowings);
	
	/**
	 * Reads Content from the Borrowings file.
	 * Save into an array of Borrowings
	 * @return a list of Borrowings
	 */
	public ArrayList<Borrowing> ReadFromBorrowings();
	
	/**
	 * Deletes the existent Borrowings file.
	 * Creates an empty file that will be used to store new records
	 * @return whether the file is empty or not
	 */
	public boolean ClearBorrowingsFile();
	
	
	/**
	 * Verifies if the array is empty
	 * @borrowings the array that contains all the borrowings
	 * @return @true if it is empty and @false if it is not empty
	 */
	public boolean isArrayEmpty(ArrayList<Borrowing> borrowings);

}
