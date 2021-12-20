package waitingList;

import java.util.ArrayList;
import java.util.HashMap;

import book.LibraryRecords;
import reader.ReaderRecords;

public class WaitingListRecords {
	
	private ArrayList<ReaderRecords> readers = new ArrayList<>();
	
	public WaitingListRecords(ArrayList<ReaderRecords> readers) {
		this.readers = readers;
	}
	
	public WaitingListRecords() {
		
	}

	public ArrayList<ReaderRecords> getReaders() {
		return readers;
	}

}
