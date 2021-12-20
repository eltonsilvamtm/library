package borrowings;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import history.HistoryData;
import waitingList.WaitingListData;
/**
 * this class implements most of the operations that involved the act of borrowing and returning books
 * 
 * @author elton
 *
 */
public class BorrowABook implements BorrowABookInterface{
	
	private File BorrowingsFile = new File("borrowings.csv");
	private HistoryData history = new HistoryData();
	private ArrayList<Borrowing> myBorrowings = new ArrayList<>();
	
	public BorrowABook() {
		ReadFromBorrowings();
	}
	
	
	public boolean isBookBorrowed(int BookID) {
		
		boolean isBookBorrowed = false;
		boolean isNull = isArrayEmpty(myBorrowings);
		
		if(!isNull) {
		for(int i = 0; i < myBorrowings.size(); i++) { //loop through the array trying to find out if the book was borrowed
			
			if(BookID == myBorrowings.get(i).getBookID()) { //returns true if the book was borrowed
				isBookBorrowed = true;
				return isBookBorrowed;
			}
		}
		}
		
		return isBookBorrowed;
	}
	
	
	public boolean borrow(int bookId, int readerId) {
		
		boolean borrowed = false;
		borrowed = isBookBorrowed(bookId);
		
		if(!borrowed) { //this happens only if the book was borrowed
			
			myBorrowings.add(new Borrowing(bookId,readerId)); //adds a new borrowing object to the array
			history.WriteBorrow(bookId, readerId); //saves the borrow to the history file
			WriteToBorrowings(myBorrowings); //writes the new borrow on the borrowings file
			borrowed = true;
			return borrowed;
		
		}else { //book is already borrowed
			borrowed = false;
			return borrowed;
		}
	}
	
	
	public boolean returnBook(int BookID) {
		
		boolean bookReturned = false;
		boolean isNull = isArrayEmpty(myBorrowings);
		boolean isBorrowed = isBookBorrowed(BookID); //if the book is borrowed then bookReturned needs to be false
		
		if(isBorrowed && !isNull) { //can only loop through the array if the array is not null and the book is borrowed
				
				for(int i = 0; i < myBorrowings.size(); i++) {
					
					if(BookID == myBorrowings.get(i).getBookID()) {
						
						myBorrowings.remove(i); //removes the record that corresponds to the id entered
						WriteToBorrowings(myBorrowings); //updates the file
						bookReturned = true; //book was successfully returned
						return bookReturned; //book was successfully borrowed!	
						
					} else {
							//if the last borrowing was removed from the array,
							//then the file needs to be removed and replaced with an empty one
							ClearBorrowingsFile();
						}
					}
			}else { //book was not returned
				return bookReturned;
			}
			
		return bookReturned;
	}
	
	
	public void WriteToBorrowings(ArrayList<Borrowing> borrowings) {
		
		boolean isFileClear = false;
		
		//delete the existing file to create a new one and update it.
		isFileClear = ClearBorrowingsFile();
		
		if(!isFileClear) {
			//issues deleting the file
			System.out.println("issues deleting the file");
		}else {
			
		try {
		
			BufferedWriter writeToBorrowings = new BufferedWriter(new FileWriter(BorrowingsFile, true));
			
			//loop through the array in order to write all the books into the file
			for(int i = 0; i < myBorrowings.size(); i++) {
				
				//writes the book id and the reader id in the borrowings file
				writeToBorrowings.write(myBorrowings.get(i).getBookID() + "," + myBorrowings.get(i).getReaderID());
				//jumps to the next line
				writeToBorrowings.newLine();
			
			}
			
			writeToBorrowings.flush();
			writeToBorrowings.close();
	
		} catch (IOException e) {
		e.printStackTrace();
		}
		
		}
		
	}
	
	
	public ArrayList<Borrowing> ReadFromBorrowings() {
		
		String currentLine;
		String[] data = new String[2];
		int[] IDs = new int[2];
		
		try {
			
			BufferedReader readBorrowings = new BufferedReader(new FileReader(BorrowingsFile));
		
			while((currentLine = readBorrowings.readLine()) != null) { //will read the entire file line by line
				
				data = currentLine.split(","); //separating the book id from the reader id
				IDs[0] = Integer.parseInt(data[0]); //parsing the book id to integer
				IDs[1] = Integer.parseInt(data[1]); //parsing the reader id to integer
				
				myBorrowings.add(new Borrowing(IDs[0],IDs[1])); //adds a new borrowing object to the array
				
			}
			
			readBorrowings.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return myBorrowings;
	}
	
	
	public boolean ClearBorrowingsFile() {
		
		boolean isFileClear = false;
		isFileClear =  BorrowingsFile.delete();
		
		if(isFileClear) {
		try {
			BorrowingsFile.createNewFile();
			return isFileClear;
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		}
		
		return isFileClear;
	}
	
	
	public boolean isArrayEmpty(ArrayList<Borrowing> borrowings) {
		boolean isEmpty = false;
		isEmpty = borrowings.isEmpty();
		return isEmpty;
	}
	
	
	public int getReader(int bookId) {
		int readerId = 0;
		
		for(int i = 0; i < myBorrowings.size();i++) {
			
			if(bookId == myBorrowings.get(i).getBookID()) {
				readerId = myBorrowings.get(i).getReaderID();
			}
		}
		
		return readerId;
	}

}
