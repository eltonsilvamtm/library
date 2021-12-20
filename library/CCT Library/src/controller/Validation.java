package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import book.LibraryData;
import book.LibraryRecords;
import history.HistoryData;
import reader.ReaderData;
import reader.ReaderRecords;
import search.Search;
import view.Screen;

/**
 * this class takes care of the entire validation section of this program
 * it checks all inputs if they are empty, or if there is non matching characters on the inputs
 * @author elton
 *
 */
public class Validation{
	
	private Screen screenOBJ = new Screen();
	private LibraryData books = new LibraryData();
	private ReaderData readers = new ReaderData();
	private HistoryData history = new HistoryData();
	private Search NewSearch = new Search();
	
	
	public String inputReader() {
		
		String input = null;
		BufferedReader InputReader = new BufferedReader(new InputStreamReader(System.in)); //reads the keyboard
		do {
		try {
			input = InputReader.readLine().trim(); //eliminate unnecessary spaces
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		}while(input.isEmpty()); //run this loop while the input is empty
		
		return input;
	}
	
	
	public int validateMainMenu() {
		
		boolean validate = false;
		String choice;
		int number = 0;
		
		do{ //it forces to run the loop the first time
			
			choice = inputReader(); //looks for empty or white spaces entries
			validate = choice.matches("^\\d{1,1}$"); //must enter a number that has only one digit
			
			if(validate == true) { //if the user entered the right format then it checks if it corresponds to one of the actions
				number = Integer.parseInt(choice); //parsing string to integer
			}else if(number > 5 || !validate) { //must be smaller than 6 to be validated
				validate = false;
				System.out.print("Please enter one of the options above:");
			}
		
		}while(!validate); //runs this loop until the user enters a correct format 
			
		return number;
	}
	
	public int validateSubMenu() {
		
		boolean validate = false;
		String choice;
		int number = 0;
		
		do { //it forces to run the loop the first time
			
			choice = inputReader(); //checks for empty or white spaces entries
			validate = choice.matches("^\\d{1,1}$"); //must match one digit format
			
			if(validate == true) {
				number = Integer.parseInt(choice); //parsing string to integer
			}else if(number > 2 || !validate) { //must be smaller than 3 to be validated
				validate = false;
				System.out.print("Please enter one of the options above:");
			}
			
		}while(!validate); //runs this loop until the user enters a correct format 
		
		return number;
	}
	
	
	public int validateID() {
		
		int ID = 0;
		String conversion;
		boolean validate = false;
		
		do { //it forces to run the loop the first time
			conversion = inputReader();  //checks for empty or white spaces entries
			validate = conversion.matches("(^\\d{1,10}$)"); //must match a one or two digit format
			
			if(validate) {
				ID = Integer.parseInt(conversion); //parsing string to integer
			}else {
				System.out.print("Incorrect ID format, try again: ");
			}
			
		}while(!validate); //runs this loop until the user enters a correct format 
		
		return ID;
	}
	
	
	public int[] validateBookAndReaderID() {
		
		int[] data = new int[2];
		
		boolean validateBook = false;
		boolean validateReader = false;
		
		do { //it forces to run the loop the first time
		
		screenOBJ.getBookID(); //output request message
		data[0] = validateID(); //validate whether the input is an id or not
		validateBook = books.searchBookID(data[0]); //check if the book exists
		
		}while(!validateBook);
		
		do { //it forces to run the loop the first time
		
		screenOBJ.GetReaderID(); //output request message
		data[1] = validateID(); //validate whether the input is an id or not
		validateReader = readers.searchReaderID(data[1]); //check if the reader exists
		
		}while(!validateReader); //runs this loop until the user enters a correct format
		
		return data;
	}
	
	
	public void analyseInputBooks(String term) {
		
		if(term.equals("titles")){ //performs sorting algorithm by title
			
			books.BubleSortTitles();
			books.printLibrary();
			
		}else if(term.equals("authors")) { //performs sorting algorithm by authors
			
			books.BubleSortAuthors();
			books.printLibrary();
			
		}else if(term.equals("id")) { //performs sorting algorithm by id
			
			books.BubleSortID();
			books.printLibrary();
			
		}else { //searches a specific term on the archive
			ArrayList<Integer> booksIndexes = NewSearch.linearSearchBooks(books.getLibrary(), term); //store all the ids of all the titles or author that contain the term searched
			
			if(booksIndexes.size() > 0) { //multiple results found
				
				System.out.println(booksIndexes.size() + " result(s) found for '" + term + "':");
				books.printBooks(booksIndexes); //print all results found
				
			}else { //no results found
				
				System.out.println("No results found for '" + term + "'.");
				
			}
		}
		
		
	}
	
	
	public void analyseInputReaders(String term) {
		
		if(term.equals("readers")){ //performs sorting algorithm by name
			
			readers.BubleSortReader();
			readers.printAllReaders();
			
		}else if(term.equals("emails")) { //performs sorting algorithm by email
			
			readers.BubleSortEmail();
			readers.printAllReaders();
			
		}else if(term.equals("id")) { //performs sorting algorithm by id
			
			readers.BubleSortID();
			readers.printAllReaders();
			
		}else { //searches a specific term on the archive
			ArrayList<Integer> readerIndexes = NewSearch.linearSearchReaders(readers.getAllReaders(), term); //store all the ids of all the titles or author that contain the term searched
			
			if(readerIndexes.size() > 0) { //multiple results found
				
				System.out.println(readerIndexes.size() + " result(s) found for '" + term + "':");
				readers.printReaders(readerIndexes);
				
			}else { //no results found
				
				System.out.println("No results found for '" + term + "'.");
				
			}
		}
		
	}

}
