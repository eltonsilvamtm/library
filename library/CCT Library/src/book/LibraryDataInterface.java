package book;

import java.util.ArrayList;

public interface LibraryDataInterface {
	
	/**
	 * loads the data from the file in memory  
	 * @return an array of books
	 */
	public ArrayList<LibraryRecords> LoadLibraryData();
	
	/**
	 * sorts the authors in alphabetical order
	 */
	public void BubleSortAuthors();
	
	/**
	 * sorts the titles in alphabetical order
	 */
	public void BubleSortTitles();
	
	/**
	 * sorts the ids in low to high order
	 */
	public void BubleSortID();
	
	/**
	 * gets the library as an array of library records
	 * @return an array of books
	 */
	public ArrayList<LibraryRecords> getLibrary();
	
	/**
	 * display the books that were selected 
	 * @param id of the books that are going to be printed
	 */
	public void printBooks(ArrayList<Integer> id);
	
	/**
	 * prints the whole library
	 */
	public void printLibrary();
	
	/**
	 * searches for a book
	 * @param bookId
	 * @return true if the book was found, false if not
	 */
	public boolean searchBookID(int bookId);

}
