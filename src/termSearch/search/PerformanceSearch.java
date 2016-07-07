package termSearch.search;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 * this class deals with Performance testing for the String match, Regular Expression
 * and indexed search techniques
 * 
 * @author rohit
 *
 */
public class PerformanceSearch {

	public static void main(String[] args) {

		Scanner scanner1 = null;
		Scanner scanner2  = null;

		try{
			scanner1 = new Scanner(System.in);

			System.out.println("Search Method:1) String Match 2) Regular Expression 3) Indexed");
			scanner2 = new Scanner(System.in);

			int number = scanner2.nextInt();
			
			SearchMethodFactory searchMethodFactory = new SearchMethodFactory();
			
			// factory method to return appropriate search method
			IMethodReader methodReader = searchMethodFactory.getSearchMethod(number);

			long start  = System.currentTimeMillis();
			
			// generates random search terms 2M times
			for(int i=0; i < 2000000; i++)
			{
				int leftLimit = 97; // letter 'a'
				int rightLimit = 122; // letter 'z'

				Random random = new Random();
				int targetStringLength = random.nextInt(5)+3;

				StringBuilder buffer = new StringBuilder(targetStringLength);
				for (int j = 0; j < targetStringLength; j++) {
					int randomLimitedInt = leftLimit + (int) 
							(new Random().nextFloat() * (rightLimit - leftLimit));
					buffer.append((char) randomLimitedInt);

				}
				String generatedString = buffer.toString();
				methodReader.search(generatedString);
			}
			long end  = System.currentTimeMillis();
			
			System.out.println("total time for 2M search:"+(end-start));
		}

		catch(InputMismatchException e){
			System.out.println("Please enter correct option");
		}

		finally{

			scanner1.close();
			scanner2.close();

		}


	}	
}

