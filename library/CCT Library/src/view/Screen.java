package view;

public class Screen {
	
	public Screen() {
		
	}
	
	public void welcome() {

		System.out.println("Welcome to CCT Library! Please enter an option:");
		System.out.println("1: Find   2: Borrow   3: Return   4: History   5: Waiting List");
		
	}
	
	public void findSubMenu() {
		
		System.out.println("Please enter an option:");
		System.out.println("1: Find a book   2: Find a reader");
		
	}
	
	public void historySubMenu() {
		
		System.out.println("Please enter an option:");
		System.out.println("1: Reader's history   2: Book's history");
		
	}
	
	public void FindABook() {
		
		System.out.println("Please enter one of options below:");
		System.out.println("Enter a book title or author to look for a book;");
		System.out.println("Enter 'titles' to sort books by title;");
		System.out.println("Enter 'authors' to sort books by author;");
		System.out.println("Enter 'id' to sort books by ID;");
		
	}
	
	public void findAReader() {
		
		System.out.println("Please enter one of options below:");
		System.out.println("Enter a reader name or email to find a reader;");
		System.out.println("Enter 'readers' to sort readers by name;");
		System.out.println("Enter 'emails' to sort books by email;");
		System.out.println("Enter 'id' to sort readers by ID;");
		
	}
	
	public void menuOptions() {
		
		System.out.println("What would you like to do now?");
		System.out.println("1: Find   2: Borrow   3: Return   4: History   5: Waiting List");
		
	}
	
	public void getBookID() {
		
		System.out.print("Please enter a book ID: ");
		
	}

	public void GetReaderID() {
		
		System.out.print("Please enter a reader ID: ");
		
	}
	
	public void waitingListMenu() {
		
		System.out.println("Please enter one of the options:");
		System.out.println("1: Add to WL   2: Remove from WL");
		
	}
	
	public void addToWaitingListMenu() {
		
		System.out.println("Reader successfully added to the waiting list.");
		
	}
	
	public void removeFromWaitingList() {
		
		System.out.println("Reader successfully removed from the waiting list");
		
	}
	
	public void bookAlreadyBorrowed() {
		
		System.out.println("Book already borrowed, would you like to add the reader to a waiting list?");
		System.out.println("1: yes   2: no");
		
	}
	
	public void contactReader() {
		
		System.out.println("Please contact the next reader who wants to borrow this book:");
		
	}
	
	public void borrowToNextReader() {
		
		System.out.println("Would you like to borrow this book to the reader above?");
		System.out.println("1: yes   2: no");
		
	}
	
	public void borrowBook() {
		System.out.println("Title successfully borrowed!"); 
	}

}
