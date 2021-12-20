package controller;

public interface NavigationInterface {
	
	/**
	 * first thing that the user is going to see
	 */
	public void welcomeMenu();
	
	/**
	 * this menu pops up every time a task was finished
	 */
	public void optionsMenu();
	
	/**
	 * decides which action will be taken
	 * @param option number that corresponds to the action
	 */
	public void navigationMenu(int option);
	
	/**
	 * decides which action will be taken on the secondary menus
	 * @param option number that corresponds to the action
	 */
	public void subMenuOption(int option);
	
	/**
	 * navigation through the find menu where the user can decide if they want to find readers or books 
	 */
	public void findMenu();
	
	/**
	 * menu to look for a book and/or sort the library archive
	 */
	public void findABookMenu();
	
	/**
	 * menu to look for readers and/or sort the readers archive
	 */
	public void findAReaderMenu();
	
	/**
	 * menu in charge of borrowing books for readers 
	 */
	public void borrowMenu();
	
	/**
	 * menu in charge of returning books to the library
	 */
	public void returnABook();
	
	/**
	 * where you can see the history of a book or a reader
	 * you can check how many people borrowed a certain book and 
	 * how many books a certain reader borrowed
	 */
	public void historyMenu();
	
	/**
	 * check a book's history
	 * it displays all the readers that have already borrowed that book
	 */
	public void bookHistory();
	
	/**
	 * check a reader's history
	 * how many books a reader has borrowed
	 */
	public void readerHistory();
	
	/**
	 * create, update, and/or delete waiting lists
	 */
	public void waitingList();
	
	/**
	 * create a new waiting or adds a reader to an existent waiting list
	 */
	public void addToWaitingList();
	
	/**
	 * remove a reader from a waiting list or remove the entire waiting list if there is only one reader there
	 */
	public void removeFromWaitingList();

}
