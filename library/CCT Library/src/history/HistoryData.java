package history;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import book.LibraryData;
import book.LibraryRecords;
import reader.ReaderData;
import reader.ReaderRecords;

public class HistoryData implements HistoryDataInterface{
	
	private LibraryData book = new LibraryData();
	private ReaderData reader = new ReaderData();
	private File history = new File("history.csv");
	private ArrayList<HistoryRecords> records = new ArrayList<>();
	private HistoryRecords data;
	
	
	public HistoryData() {
		LoadData();
	}

	@Override
	public void LoadData() {
		
		String currentLine;
		String [] data = new String[2];
		int bookId, readerId;
		
		try {
			
			BufferedReader readHistory = new BufferedReader(new FileReader(history)); //instance of the bufferedReader class
			
			while((currentLine = readHistory.readLine()) != null) { //read all the lines
				
				data = currentLine.split(",");
				bookId = Integer.parseInt(data[0]); //retrieve the book id
				readerId = Integer.parseInt(data[1]); //retrieve the reader id
				records.add(new HistoryRecords(book.getBook(bookId),reader.getAreader(readerId))); //add new entry on the 
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void WriteBorrow(int bookId, int readerId) {
		
		try {
			
			BufferedWriter writeHistory = new BufferedWriter(new FileWriter(history, true)); //true to enable appending the file
			
			records.add(new HistoryRecords(book.getBook(bookId),reader.getAreader(readerId))); //add a new entry to the records array list
			
			writeHistory.write(bookId + "," + readerId);
			writeHistory.newLine();
			writeHistory.flush();
			writeHistory.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<LibraryRecords> FindBooks(int readerId) {
		
		ArrayList<LibraryRecords> books = new ArrayList<>();
		
		for(int i = 0; i < records.size(); i++) { //loop through the entire array of books
			
			data = records.get(i); //gets a history records object
			
			if((reader.getAreader(readerId)) == (data.getReader())) { //compare reader objects from the array
				books.add(records.get(i).getBook()); //adds the book to the array of books that the user has already borrowed
			}
		}
		
		return books;
	}

	@Override
	public ArrayList<ReaderRecords> FindReaders(int bookId) {
		
		ArrayList<ReaderRecords> readers = new ArrayList<>();
		
		for(int i = 0; i < records.size(); i++) { //loop through the entire array of readers
			
			data = records.get(i); //gets a history records object
			
			if((book.getBook(bookId)) == (data.getBook())) { //compare reader objects from the array
				readers.add(records.get(i).getReader()); //adds the reader to the array of books that the user has already borrowed
			}
		}
		
		return readers;
	}
	
	@Override
	public void printBooks(int readerId) {
		ArrayList<LibraryRecords> books = new ArrayList<>();
		books = FindBooks(readerId);
		
		System.out.println(books.size() + " results were found on this book's history.");
		
		if(!books.isEmpty()) { //will only print if any book was found
		for(int i = 0; i < books.size(); i++) { //loop through all the books that were found and print one by one
			
			System.out.println("");
			System.out.print("id: "); System.out.println(books.get(i).getId());
			System.out.print("Title: "); System.out.println(books.get(i).getTitle());
			System.out.print("Author: "); System.out.println(books.get(i).getAuthor());
			System.out.println("");
			
		}
		
		}else { //no books found
			System.out.println("There are no books listed for this reader.");
		}
	}
	
	@Override
	public void printReaders(int bookId) {
		ArrayList<ReaderRecords> readers = new ArrayList<>();
		readers = FindReaders(bookId);
		
		System.out.println(readers.size() + " results were found on this book's history.");
		
		if(!readers.isEmpty()) { //will only print if any reader was found
		for(int i = 0; i < readers.size(); i++) { //loop through all the readers that were found and print one by one
			
			System.out.println("");
			System.out.print("id: "); System.out.println(readers.get(i).getId());
			System.out.print("Name: "); System.out.println(readers.get(i).getFullName());
			System.out.print("email: "); System.out.println(readers.get(i).getEmail());
			System.out.println("");
			
		}
		}else { //no readers found
			System.out.println("There are no readers listed for this book.");
		}
	}
	
	

}
