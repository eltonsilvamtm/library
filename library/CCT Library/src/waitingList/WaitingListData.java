package waitingList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import book.LibraryData;
import book.LibraryRecords;
import reader.ReaderData;
import reader.ReaderRecords;

/**
 * This class is responsible for the administration of the waiting list 
 * All the custom made queue methods are being processed on this class
 * @author elton
 */
public class WaitingListData implements WaitingListDataInterface{
	
	private File waitingListFile = new File("waitingList.csv");
	private HashMap<LibraryRecords, ArrayList<ReaderRecords>> allTheLists = new HashMap<>();
	private LibraryData bookToCompare = new LibraryData();
	private LibraryRecords book = new LibraryRecords();
	private ReaderData readerData = new ReaderData();
	private ArrayList<ReaderRecords> readers = new ArrayList<>();
	
	public WaitingListData() {
		ReadData();
	}


	@Override
	public void ReadData() {
		
		String currentLine = null;
		String[] data = new String[2]; //map key, book id. and reader id
		int bookId, readerId;
		allTheLists.clear(); //clears the hash map so that we transfer all the values of the file to the hash map
		
		try {
			
			BufferedReader readWaitingList = new BufferedReader(new FileReader(waitingListFile));
			
			while((currentLine = readWaitingList.readLine()) != null) { //read the file line by line till it gets to the end of the content
				
				data = currentLine.split(",");
				bookId = Integer.parseInt(data[0]); //book id
				readerId = Integer.parseInt(data[1]); //reader id
				book = bookToCompare.getBook(bookId); //gets a book that corresponds to the book id entered
				
				if(allTheLists.containsKey(book)) { //if the book already exists just add the reader to the array
					
					readers.clear(); // clear current array
					readers = allTheLists.get(book); //extracts the current array on the list
					readers.add(readerData.getAreader(readerId)); // add the new reader to the array
					allTheLists.replace(book, readers); //replace the array on the hash map with the updated one
					
				}else { //else create a new record on the hash map
					
					readers.clear(); //make sure that the array has no objects once it is a new waiting list
					readers.add(readerData.getAreader(readerId)); //adds a reader to the list
					allTheLists.put(book, readers); //inserts a new waiting list to the hash map
					
				}
			}
			
			readWaitingList.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void WriteData() {
		
		boolean isFileClear = ClearFile();
		
		if(isFileClear) {
			
			try {
				
				BufferedWriter writeWaitingLists = new BufferedWriter(new FileWriter(waitingListFile, true)); //creates an instance of the file writer
				
				//loop through book by book and then writes the book id for each reader that is contained on that waiting list
				for (Entry<LibraryRecords, ArrayList<ReaderRecords>> entry : allTheLists.entrySet()) {
					
				    book = entry.getKey(); //gets the book object
				    readers = entry.getValue(); //gets all the readers that are waiting for that book
				    
				    for(int i = 0; i < readers.size(); i++) { //loop through all the readers and write them one by one with the book id
				    	
				    	writeWaitingLists.write(book.getId() + "," + readers.get(i).getId()); //write the new list on the file
				}
			}
			
			writeWaitingLists.flush();
			writeWaitingLists.close();
			
			}catch (IOException e) {
				
				e.printStackTrace();
			}
		}else {
			System.out.println("File could not be written");
		}
		
	}

	
	@Override
	public boolean ClearFile() {
		
		boolean isFileClear = false;
		isFileClear =  waitingListFile.delete();
		
		if(isFileClear) {
		try {
			waitingListFile.createNewFile();
			return isFileClear;
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		}
		
		return isFileClear;
	}

	
	@Override
	public boolean isReaderQueued(int bookId, int readerId) {
		
		boolean isBookQueued = isBookQueued(bookId);
		boolean isReaderQueued = false;
		
		if(isBookQueued) { //if the book is already on the hash map then we need to check if the reader is on the waiting list
			
			readers.clear(); //clearing the previous array
			book = bookToCompare.getBook(bookId); //gets a book that corresponds to the book id entered
			readers = allTheLists.get(book); // get the waiting list records object that are waiting for that book and pass it to the array of readers
			isReaderQueued = readers.contains(readerData.getAreader(readerId)); //check if the reader is on the waiting list
			
		}
		
		return isReaderQueued;
	}

	
	@Override
	public boolean isBookQueued(int bookId) {
		
		book = bookToCompare.getBook(bookId); //gets a book that corresponds to the book id entered
		boolean isBookQueued = allTheLists.containsKey(book);
		return isBookQueued;
		
	}

	
	@Override
	public boolean enqueueBook(int bookId, int readerId) {
		
		boolean isBookQueued = isBookQueued(bookId);
		boolean isBookListed = false;
		
		if(isBookQueued) { //the book already exists on the hash map, therefore the list just need to be updated
			
			enqueueReader(bookId, readerId); //updates the waiting list with the new reader
			return isBookListed;
			
		}else { //creates a new record on the hash map if the book does not have a waiting list
			
			readers.clear(); //clears the previous array
			book = bookToCompare.getBook(bookId); //gets a book that corresponds to the book id entered
			readers.add(readerData.getAreader(readerId)); //adds the first reader to the waiting list
			
			//creates a new waiting list and only updates the file if the result is not null
			allTheLists.put(book, readers);
			isBookListed = true;
			WriteData(); //updates the data on the csv file
			return isBookListed;
			
			}
	}

	@Override
	public boolean enqueueReader(int bookId, int readerId) {
		
		boolean isReaderQueued = isReaderQueued(bookId, readerId);
		boolean isReaderListed = false;
		
		if(isReaderQueued) { //if the reader exists on a waiting list
			
			System.out.println("Reader is already on the waiting list for this book, please try another book");
			return isReaderListed;
			
		}else { //reader needs to be added to the book's waiting list
			
			readers.clear(); // clear current array
			book = bookToCompare.getBook(bookId); //gets a book that corresponds to the book id entered
			readers = allTheLists.get(book); // get the waiting list records object that are waiting for that book
			readers.add(readerData.getAreader(readerId)); // add the new reader to the array
			
			//only replace the array on the hash map for the updated one if the result is not null
			allTheLists.replace(book, readers);
			isReaderListed = true;
			WriteData(); //updates the data on the csv file
			return isReaderListed;
			}
	
	}

	@Override
	public void dequeueBook(int bookId) {
			
			readers.clear(); // clear current array
			book = bookToCompare.getBook(bookId); //gets a book that corresponds to the book id entered
			readers = allTheLists.get(book); // get the waiting list records object that are waiting for that book
			
			//only removes the book if there is only one reader waiting for it and 
			//only updates the file if there are no issues with the deletion of the waiting list on the hash map
			if(readers.size() == 1 && allTheLists.remove(book) != null) { 
				
				allTheLists.remove(book); //removes the book
				WriteData(); //updates the csv file 

			}else { //it is not the last record so we will remove only the reader on the top of the queue
				
				dequeueReader(bookId);
			}
	}
	
	
	@Override
	public void dequeueReader(int bookId){
		
			readers.clear(); // clear current array
			book = bookToCompare.getBook(bookId); //gets a book that corresponds to the book id entered
			readers = allTheLists.get(book); // get the waiting list records object that are waiting for that book
			
			if(readers.size() == 1) { //if it is the last reader we need to delete the waiting list as a whole
				
				dequeueBook(bookId);
				
			}else {
				
				readers.remove(0); //always delete the top reader because it is a queue
				allTheLists.replace(book, readers); // swap the old array with the new one which the reader was deleted
				WriteData(); //updates the csv file
			
			}
		
	}

	@Override
	public ReaderRecords getNextReader(int bookId) {
		
		readers.clear(); // clear current array
		book = bookToCompare.getBook(bookId); //gets a book that corresponds to the book id entered
		readers.addAll(allTheLists.get(book)); // get the waiting list records object that are waiting for that book
		System.out.println(readers.get(0).getFullName());
		return readers.get(0);
	}
	

}
