package termSearch.search;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * this class is used to search and counts the number of occurrences of an 
 * input string in the given three text file through index search technique
 *  
 * @author rohit
 *
 */
public class IndexedSearch implements IMethodReader {

	@Override
	public void search(String searchTerm)
	{
		// data preprocessing starts
		Map<File, Map<String, Integer>> fileTermCountMap = dataPreprocessing();
		// data preprocessing ends

		long start = System.currentTimeMillis();

		for(Map.Entry<File, Map<String,Integer>> fileEntry: fileTermCountMap.entrySet())
		{
			int count = 0;
			File file = fileEntry.getKey();
			String fileName = file.getName();
			Map<String,Integer> termCountEntry = fileEntry.getValue();

			for(Map.Entry<String, Integer> termCount: termCountEntry.entrySet())
			{
				if(searchTerm.equals(termCount.getKey()))
				{
					count = termCount.getValue();
					break;
				}
			}

			System.out.println(fileName+" - "+count+" matches");

		}

		long end = System.currentTimeMillis();

		System.out.println("Elapsed Time: "+(end-start)+" ms");

	}

	/**
	 * this method preprocesses the data in the given three text file and stores 
	 * then in LinkedHashMap
	 * 
	 *  
	 * @return Map<File, Map<String, Integer>> - LinkedHashmap to store file as key, hashmap of <input term as key, count as value> as value
	 */
	
	private Map<File, Map<String, Integer>> dataPreprocessing(){


		Scanner scanner1 = null;
		Scanner scanner2 = null;
		Scanner scanner3 = null;

		// keeps the count of given input search term in File1
		Map<String, Integer> termCountMap1 = new HashMap<String, Integer>();
		// keeps the count of given input search term in File2
		Map<String, Integer> termCountMap2 = new HashMap<String, Integer>();
		// keeps the count of given input search term in File3
		Map<String, Integer> termCountMap3 = new HashMap<String, Integer>();

		// keeps the File as key and Map of <word, count> as a value
		Map<File, Map<String, Integer>> fileTermCountMap = new LinkedHashMap<File, Map<String, Integer>>();

		try {

			// File1 data preprocssing starts
			File file1 = new File("F:/my projects/target/Target/SampleFiles/french_armed_forces.txt");
			scanner1 = new Scanner(new FileReader(file1));

			while(scanner1.hasNextLine())
			{
				String s = scanner1.nextLine();

				String[] arr = s.split(" ");

				for(String str: arr)
				{
					if(termCountMap1.containsKey(str))
					{
						int count = termCountMap1.get(str);
						termCountMap1.put(str, count+1);
					}
					else
						termCountMap1.put(str, 1);
				}			
			}

			fileTermCountMap.put(file1, termCountMap1);

			// File 2 preprocessing starts
			File file2 = new File("F:/my projects/target/Target/SampleFiles/hitchhikers.txt");
			scanner2 = new Scanner(new FileReader(file2));

			while(scanner2.hasNextLine())
			{
				String s = scanner2.nextLine();

				String[] arr = s.split(" ");

				for(String str: arr)
				{
					if(termCountMap2.containsKey(str))
					{
						int count = termCountMap2.get(str);
						termCountMap2.put(str, count+1);
					}
					else
						termCountMap2.put(str, 1);
				}			
			}

			fileTermCountMap.put(file2, termCountMap2);


			// File 3 preprocessing starts
			File file3 = new File("F:/my projects/target/Target/SampleFiles/warp_drive.txt");
			scanner3 = new Scanner(new FileReader(file3));

			while(scanner3.hasNextLine())
			{
				String s = scanner3.nextLine();

				String[] arr = s.split(" ");

				for(String str: arr)
				{
					if(termCountMap3.containsKey(str))
					{
						int count = termCountMap3.get(str);
						termCountMap3.put(str, count+1);
					}
					else
						termCountMap3.put(str, 1);
				}			
			}

			fileTermCountMap.put(file3, termCountMap3);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		finally {

			scanner1.close();
			scanner2.close();
			scanner3.close();
		}

		return fileTermCountMap;


	}


}
