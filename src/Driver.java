import java.util.InputMismatchException;
import java.util.Scanner;

import termSearch.search.IMethodReader;
import termSearch.search.SearchMethodFactory;

/*
 * 
 * This is a driver class which is a starting point of the program
 * 
 */
public class Driver {


	@SuppressWarnings("resource")
	public static void main(String[] args) {

		Scanner scanner1 = null;
		Scanner scanner2 = null;
		Scanner scanner3 = null;
		while(true){

			try{

				scanner1 = new Scanner(System.in);

				System.out.println("Enter Search Term:");
				String searchTerm = scanner1.nextLine();

				System.out.println("Search Method:1) String Match 2) Regular Expression 3) Indexed");
				scanner2 = new Scanner(System.in);

				int number = scanner2.nextInt();
				SearchMethodFactory searchMethodFactory = new SearchMethodFactory();
				
				// factory method to return appropriate search method according to user option
				IMethodReader methodReader = searchMethodFactory.getSearchMethod(number);
				
				while(methodReader == null)
				{
					System.out.println("Please enter option 1 or option 2 or option 3");
					System.out.println("Search Method:1) String Match 2) Regular Expression 3) Indexed");
					scanner2 = new Scanner(System.in);

					number = scanner2.nextInt();
					methodReader = searchMethodFactory.getSearchMethod(number);
				}
				
				
					System.out.println("Search Results:");
					methodReader.search(searchTerm);
					System.out.println();
					System.out.println("Press 4 to exit or any number to continue");
					scanner3 = new Scanner(System.in);
								
					int option = scanner3.nextInt();
					
					if(option == 4){
	
						System.exit(option);
						
						break;
					}
					
			}

			catch(InputMismatchException e)
			{
				System.out.println("Please enter correct option");
			}
			
			
		}

	}

}
