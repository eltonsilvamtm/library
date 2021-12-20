package reader;

public class ReaderRecords {
	
	private int id;
	private String name;
	private String surname;
	private String email;
	
	public ReaderRecords(int id, String name, String surname, String email) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
	}
	
	public ReaderRecords() {
		
	}
	
	public int getId() {
		return id;
	}
	
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getEmail() {
		return email;
	}

	public String getFullName() {
		return this.name.trim() + " " + this.surname.trim();
	}
	

}
