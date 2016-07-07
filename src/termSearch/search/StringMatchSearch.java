package termSearch.search;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * This class searches the string with String match approach
 * @author rohit
 *
 */
public class StringMatchSearch implements IMethodReader {

	@Override
	public void search(String searchTerm){

		Scanner scanner1 = null;
		Scanner scanner2 = null;
		Scanner scanner3 = null;
		int file1Count = 0;
		int file2Count = 0;
		int file3Count = 0;

		try
		{
			long start = System.currentTimeMillis();
			File file1 = new File("F:/my projects/target/Target/SampleFiles/french_armed_forces.txt");
			scanner1 = new Scanner(new FileReader(file1));

			while(scanner1.hasNextLine())
			{
				String s = scanner1.nextLine();
				String[] arr = s.split(" ");

				for(String str: arr)
				{
					if(str.equals(searchTerm))
					{
						file1Count++;
					}
				}	
			}

			System.out.println(file1.getName()+" - "+file1Count+" matches");

			File file2 = new File("F:/my projects/target/Target/SampleFiles/hitchhikers.txt");
			scanner2 = new Scanner(new FileReader(file2));


			while(scanner2.hasNextLine())
			{
				String s = scanner2.nextLine();
				String[] arr = s.split(" ");

				for(String str: arr)
				{
					if(str.equals(searchTerm))
					{
						file2Count++;
					}
				}	
			}

			System.out.println(file2.getName()+" - "+file2Count+" matches");

			File file3 = new File("F:/my projects/target/Target/SampleFiles/warp_drive.txt");
			scanner3 = new Scanner(new FileReader(file3));

			while(scanner3.hasNextLine())
			{
				String s = scanner3.nextLine();
				String[] arr = s.split(" ");

				for(String str: arr)
				{
					if(str.equals(searchTerm))
					{
						file3Count++;
					}
				}	
			}

			System.out.println(file3.getName()+" - "+file3Count+" matches");

			long end = System.currentTimeMillis();

			System.out.println("Elapsed Time: "+(end-start)+" ms");
		}
		catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		finally{

			scanner1.close();
			scanner2.close();
			scanner3.close();

		}

	}

}
