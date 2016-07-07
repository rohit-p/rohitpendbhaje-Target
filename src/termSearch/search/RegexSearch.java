package termSearch.search;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * this class is used to search and counts the number of occurrences of an 
 * input string in the given three text file through regular expression 
 * pattern matching technique
 * 
 * @author rohit
 *
 */

public class RegexSearch implements IMethodReader {

	@Override
	public void search(String searchTerm){

		Scanner scanner1 = null;
		Scanner scanner2 = null;
		Scanner scanner3 = null;
		
		String searchStr = "\\b"+searchTerm+"\\b";
		
		// regular expression pattern filter
		Pattern pattern = Pattern.compile(searchStr);
		int file1Count = 0;
		int file2Count = 0;
		int file3Count = 0;
		try {
			long start = System.currentTimeMillis();

			File file1 = new File("F:/my projects/target/Target/SampleFiles/french_armed_forces.txt");
			scanner1 = new Scanner(new FileReader(file1));

			while(scanner1.hasNextLine())
			{
				String s = scanner1.nextLine();

				Matcher m = pattern.matcher(s);

				while(m.find())
				{
					file1Count++;
				}
			}
			System.out.println(file1.getName()+" - "+file1Count+" matches");

			File file2 = new File("F:/my projects/target/Target/SampleFiles/hitchhikers.txt");
			scanner2 = new Scanner(new FileReader(file2));

			while(scanner2.hasNextLine())
			{
				String s = scanner2.nextLine();

				Matcher m = pattern.matcher(s);

				while(m.find())
				{
					file2Count++;
				}
			}
			System.out.println(file2.getName()+" - "+file2Count+" matches");

			File file3 = new File("F:/my projects/target/Target/SampleFiles/warp_drive.txt");
			scanner3 = new Scanner(new FileReader(file3));

			while(scanner3.hasNextLine())
			{
				String s = scanner3.nextLine();

				Matcher m = pattern.matcher(s);

				while(m.find()){
					file3Count++;
				}
			}
			System.out.println(file3.getName()+" - "+file3Count+" matches");

			long end = System.currentTimeMillis();

			System.out.println("Elapsed Time: "+(end-start)+" ms");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		finally {

			scanner1.close();
			scanner2.close();
			scanner3.close();
		}

	}




}
