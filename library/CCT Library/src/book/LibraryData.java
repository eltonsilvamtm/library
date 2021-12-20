
package book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * this class contains most of the operations that this program uses to treat the library data
 * from searching for a title to sorting the library archive in many different ways 
 * @author elton
 *
 */
public class LibraryData implements LibraryDataInterface{
	
	private File booksCatalog = new File("booksCatalog.csv");
	private ArrayList<LibraryRecords> records = new ArrayList<>();
	private ArrayList<LibraryRecords> swap = new ArrayList<>();
	
	public LibraryData() {
		
		LoadLibraryData();
		
	}
	

	public ArrayList<LibraryRecords> LoadLibraryData() {
		
		String data[];
		String Content, title, author;
		int id;
		
		try {
			
			BufferedReader MyBook = new BufferedReader(new FileReader(booksCatalog));
			Content = MyBook.readLine();
			
			while(Content != null) {
				
				data = Content.split(",");
				id = Integer.parseInt(data[0]);
				title = data[1];
				author = data[2];
				
				records.add(new LibraryRecords(id, title, author));
				Content = MyBook.readLine();
			}
			
			MyBook.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return records;
	}

	
	public void BubleSortAuthors() {
		
		String AuthorA, AuthorB; 
		
		for(int i = 0; i < records.size() ; i++) { // loop through the array of books one by one to check its neighbour
			
			for(int j = i + 1; j < records.size(); j++) { //loop through the array of books to get the next book
				
				AuthorA = records.get(i).getAuthor(); //saves the author of the position '0' to compare
				AuthorB = records.get(j).getAuthor(); //saves the author of the position '1' to compare
				
				if((AuthorA.compareToIgnoreCase(AuthorB)) > 0) { //if A is bigger than B both objects need to be swapped
					
					swap.add(records.get(i)); //saves the record on the temporary array
					records.set(i, records.get(j)); //moves B where A was
					records.set(j, swap.get(0)); //moves A where B was
					swap.clear(); // clears the temporary array
					
				}
			}
		}
	}


	public void BubleSortTitles() {
		
		String titleA, titleB;
		
		for(int i = 0; i < records.size() ; i++) { // loop through the array of books one by one to check its neighbour
			
			for(int j = i + 1; j < records.size(); j++) { //loop through the array of books to get the next book
				
				titleA = records.get(i).getTitle(); //saves the title of the position '0' to compare
				titleB = records.get(j).getTitle(); //saves the title of the position '1' to compare
				
				if((titleA.compareToIgnoreCase(titleB)) > 0) { //if A is bigger than B both objects need to get swapped
					
					swap.add(records.get(i)); //saves the record on the temporary array
					records.set(i, records.get(j)); //moves B where A was
					records.set(j, swap.get(0)); //moves A where B was
					swap.clear(); // clears the temporary array
					
				}
			}
		}
	}
	
	
	public void BubleSortID() {
		
		int idA, idB;
		
		for(int i = 0; i < records.size() ; i++) { // loop through the array of books one by one to check its neighbour
			
			for(int j = i + 1; j < records.size(); j++) { //loop through the array of books to get the next book
				
				idA = records.get(i).getId(); //saves the title of the position '0' to compare
				idB = records.get(j).getId(); //saves the title of the position '1' to compare
				 
				if(idA > idB) { //if A is bigger than B both objects need to get swapped
					
					swap.add(records.get(i)); //saves the record on the temporary array
					records.set(i, records.get(j)); //moves B where A was
					records.set(j, swap.get(0)); //moves A where B was
					swap.clear(); // clears the temporary array
					
				}
			}
		}
	}
	
	
//	private void InsertSortLibraryData() {
//		
//		for(int i = 1; i < records.size(); i++) {
//			
//			int j = i;
//			swap.add(records.get(i));
//			String titleA = records.get(i).getTitle();
//			String titleB = records.get(j-1).getTitle();
//			
//			while(j > 0 && titleB.compareToIgnoreCase(titleA) > 0) {
//				
//				records.set(j, records.get(j-1));
//				j--;
//			}
//			
//			records.set(j, swap.get(0));
//			swap.clear();
//		}
//	}
	
	
	public ArrayList<LibraryRecords> getLibrary(){
		return records;
	}
	
	
	public void printBooks(ArrayList<Integer> id) {
		
		for(int i = 0; i < id.size();i++) {
				
				System.out.print("ID: " + records.get(id.get(i)).getId());
				System.out.print("  ");
				System.out.print("Title: " + records.get(id.get(i)).getTitle());
				System.out.print("  ");
				System.out.print("Author: " + records.get(id.get(i)).getAuthor());
				System.out.println("");
				
			}
	}
	
	
	public void printLibrary() {
		
		for(int i = 0; i < records.size();i++) {
			
			System.out.print(records.get(i).getId());
			System.out.print("   ");
			System.out.print(records.get(i).getTitle());
			System.out.print("   ");
			System.out.print(records.get(i).getAuthor());
			System.out.println();
			
		}
	}
	
	
	public boolean searchBookID(int bookId) {
		
		boolean isBookId = false;
		
		for(int i = 0; i < records.size(); i++) { //loop through the array to find a book which the id matches with the id that the user is looking for
			if(bookId == records.get(i).getId()) { //if true then the book was found
				isBookId = true;
			}
		}
		return isBookId;
	}
	
	
	public LibraryRecords getBook(int bookId) {
		LibraryRecords book = new LibraryRecords();
		
		for(int i = 0; i < records.size(); i++) { //loop through the array to find a book which the id matches with the id that the user is looking for
			if(bookId == records.get(i).getId()) { //if true then the book was found
				book = records.get(i);
				return book;
			}
		}
		
		return book;
	}
	
}
