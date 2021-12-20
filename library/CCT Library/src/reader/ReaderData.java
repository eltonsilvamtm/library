package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderData implements ReaderDataInterface{
	
	private File readersCatalog = new File("ReadersCatalog.csv");
	private ArrayList<ReaderRecords> records = new ArrayList<>();
	private ArrayList<ReaderRecords> temporary = new ArrayList<>();
	
	public ReaderData() {
		
		LoadReaderData();
		
	}

	@Override
	public ArrayList<ReaderRecords> LoadReaderData() {
		
		String data[];
		String Content, name, surname, email;
		int id;
		
		try {
			
			BufferedReader MyReader = new BufferedReader(new FileReader(readersCatalog));
			Content = MyReader.readLine(); //reads the first line
			
			while(Content != null) { //reads the whole file line by line
				
				data = Content.split(",");
				id = Integer.parseInt(data[0]); //parsing a string to an integer
				name = data[1];
				surname = data[2];
				email = data[3];
				
				records.add(new ReaderRecords(id, name, surname, email)); //storing the reader objects into an array 
				Content = MyReader.readLine(); //reads the rest of the file
			
			}
			
			MyReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return records;
	}
	
	@Override
	public ArrayList<ReaderRecords> getAllReaders(){
		return records;
	}
	
	public ReaderRecords getAreader(int readerId){
		ReaderRecords reader = new ReaderRecords();
		
		for(int i = 0; i < records.size(); i++) { //loop through the readers archive till it finds an id that matches with the one that the user entered
			
			if(readerId == records.get(i).getId()) { //comparing ids through the array
				reader = records.get(i); //storing a reader info in a reader object
				return reader;
			}
		}
		
		return reader;
	}
	
	@Override
	public void BubleSortReader() {
		
		String readerA, readerB;
		
		for(int i = 0; i < records.size() ; i++) { // loop through the array of books one by one to check its neighbour
			
			for(int j = i + 1; j < records.size(); j++) { //loop through the array of readers to get the next reader
				
				readerA = records.get(i).getFullName(); //saves the name of the position '0' to compare
				readerB = records.get(j).getFullName(); //saves the name of the position '1' to compare
				
				if((readerA.compareToIgnoreCase(readerB)) > 0) { //if A is bigger than B both objects need to be swapped
					
					temporary.add(records.get(i)); //saves the record on the temporary array
					records.set(i, records.get(j)); //moves B where A was
					records.set(j, temporary.get(0)); //moves A where B was
					temporary.clear(); // clears the temporary array
					
				}
			}
		}
	}
	
	@Override
	public void BubleSortEmail() {
		
		String emailA, emailB;
		
		for(int i = 0; i < records.size() ; i++) { // loop through the array of books one by one to check its neighbour
			
			for(int j = i + 1; j < records.size(); j++) {  //loop through the array of readers to get the next reader
				
				emailA = records.get(i).getEmail(); //saves the email of the position '0' to compare
				emailB = records.get(j).getEmail(); //saves the email of the position '1' to compare
				
				if((emailA.compareToIgnoreCase(emailB)) > 0) { //if A is bigger than B both objects need to be swapped
					
					temporary.add(records.get(i)); //saves the record on the temporary array
					records.set(i, records.get(j));  //moves B where A was
					records.set(j, temporary.get(0));  //moves A where B was
					temporary.clear(); // clears the temporary array
					
				}
			}
		}
	}
	
	@Override
	public void BubleSortID() {
		
		int idA, idB;
		
		for(int i = 0; i < records.size() ; i++) { // loop through the array of books one by one to check its neighbour
			
			for(int j = i + 1; j < records.size(); j++) { //loop through the array of readers to get the next reader
				
				idA = records.get(i).getId(); //saves the email of the position '0' to compare
				idB = records.get(j).getId(); //saves the email of the position '1' to compare
				
				if(idA > idB) { //if A is bigger than B both objects need to be swapped
					
					temporary.add(records.get(i)); //saves the record on the temporary array
					records.set(i, records.get(j)); //moves B where A was
					records.set(j, temporary.get(0));  //moves A where B was
					temporary.clear(); // clears the temporary array
					
				}
			}
		}
	}
	
	public void printAReader(ReaderRecords reader) {
		
		System.out.print("ID: " + reader.getId());
		System.out.print("  ");
		System.out.print("Name: " + reader.getFullName());
		System.out.print("  ");
		System.out.print("email: " + reader.getEmail());
		System.out.println("");
	}

	@Override
	public void printReaders(ArrayList<Integer> id) {
		
		for(int i = 0; i < id.size();i++) { //loop through the array that contains all the readers ids that need o be printed
				
				System.out.print("ID: " + records.get(id.get(i)).getId());
				System.out.print("  ");
				System.out.print("Name: " + records.get(id.get(i)).getFullName());
				System.out.print("  ");
				System.out.print("email: " + records.get(id.get(i)).getEmail());
				System.out.println("");
				
			}
	}
	
	@Override
	public void printAllReaders() {
		
		for(int i = 0; i < records.size();i++) { //loop through the whole array and print all the objects stored
			
			System.out.print(records.get(i).getId());
			System.out.print("   ");
			System.out.print(records.get(i).getFullName());
			System.out.print("   ");
			System.out.print(records.get(i).getEmail());
			System.out.println();
			
		}
	}
	
	@Override
	public boolean searchReaderID(int readerId) {
		
		boolean isreaderId = false;
		
		for(int i = 0; i < records.size(); i++) { //look for a record that matches with one of the readers ids
			if(readerId == records.get(i).getId()) {
				isreaderId = true;
			}
		}
		return isreaderId;
	}
	

}
