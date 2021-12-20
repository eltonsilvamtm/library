package reader;

import java.util.ArrayList;

public interface ReaderDataInterface {
	
	/**
	 * loads the data into memory
	 * @return an array of reader objects
	 */
	public ArrayList<ReaderRecords> LoadReaderData();
	
	/**
	 * gets all the readers saved in memory
	 * @return an array of reader objects
	 */
	public ArrayList<ReaderRecords> getAllReaders();
	
	/**
	 * sorts all the reader's data by name in alphabetical order
	 */
	public void BubleSortReader();
	
	/**
	 * sorts all the reader's data by email in alphabetical order 
	 */
	public void BubleSortEmail();
	
	/**
	 * sorts reader's id on ascending order
	 */
	public void BubleSortID();
	
	/**
	 * display all the readers required by the user
	 * @param id of readers
	 */
	public void printReaders(ArrayList<Integer> id);
	
	/**
	 * displays all readers of the archive to the user
	 */
	public void printAllReaders();
	
	/**
	 * look for a particular reader
	 * @param readerId
	 * @return true if found, false if not
	 */
	public boolean searchReaderID(int readerId);

}
