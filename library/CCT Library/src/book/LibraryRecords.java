package book;

public class LibraryRecords {
	private int id;
	private String title;
	private String author;
	
	public LibraryRecords(int id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
	}
	
	public LibraryRecords() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}

}
