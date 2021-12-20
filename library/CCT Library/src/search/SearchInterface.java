package search;

import java.util.ArrayList;

import book.LibraryRecords;
import reader.ReaderRecords;

public interface SearchInterface {
	
	/**
	 * performs a full linear search on the reader archive 
	 * @param readers from the archive
	 * @param target what the user typed
	 * @return an array of ids that match with the target
	 */
	public ArrayList<Integer> linearSearchReaders(ArrayList<ReaderRecords> readers, String target);
	
	/**
	 * performs a full linear search on the books archive 
	 * @param books from the archive
	 * @param target what the user typed
	 * @return an array of ids that match with the target
	 */
	public ArrayList<Integer> linearSearchBooks(ArrayList<LibraryRecords> books, String target);

}
