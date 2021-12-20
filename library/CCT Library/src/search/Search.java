package search;

import java.util.ArrayList;

import book.LibraryRecords;
import reader.ReaderRecords;

public class Search {
	private String target;
	
	public Search() {
		
	}
	
	public String getCustomSearch() {
		return target;
	}
	
	public void setCustomSearch(String target) {
		this.target = target;
	}
	
	public ArrayList<Integer> linearSearchReaders(ArrayList<ReaderRecords> readers, String target) { //takes the readers and what the user has typed
		
		ArrayList<Integer> results = new ArrayList<>();
		
		for(int i = 0; i < readers.size(); i++) { //loop through all the readers to check for matches
			if(target.contains(Integer.toString(readers.get(i).getId()))) { //add the reader id to the results array if the target matches with the content of the reader array
				results.add(i);
			}else if(readers.get(i).getFullName().toLowerCase().contains(target.toLowerCase())) { //add the reader id to the results array if the target matches with the content of the reader array
				results.add(i);
			}else if (readers.get(i).getEmail().toLowerCase().contains(target.toLowerCase())) { //add the reader id to the results array if the target matches with the content of the reader array
				results.add(i);
			}
				
		}
		
		return results;
	}
	
	
	public ArrayList<Integer> linearSearchBooks(ArrayList<LibraryRecords> books, String target) {
		
		ArrayList<Integer> results = new ArrayList<>();
		
		for(int i = 0; i < books.size(); i++) { //loop through all the readers to check for matches
			
			if(target.contains(Integer.toString(books.get(i).getId()))) { //add the book id to the results array if the target matches with the content of the book array
				results.add(i);
				
			}else if(books.get(i).getTitle().toLowerCase().contains(target.toLowerCase())) { //add the book id to the results array if the target matches with the content of the book array
				results.add(i);
				
			}else if(books.get(i).getAuthor().toLowerCase().contains(target.toLowerCase())) { //add the book id to the results array if the target matches with the content of the book array
				results.add(i);
				
			}
			
		}
		return results;
	}

}
