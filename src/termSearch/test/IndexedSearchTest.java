package termSearch.test;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test class to test Indexed Search  
 * 
 * @author rohit
 *
 */
public class IndexedSearchTest {

	private Scanner scanner = null;
	private Map<String, Integer> termCountMap = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		String fileName = "F:/my projects/target/Target/SampleFiles/testMatchFile.txt";
		File file = new File(fileName);
		scanner = new Scanner(new FileReader(file));
		termCountMap = new HashMap<String, Integer>();
		
		while(scanner.hasNextLine())
		{
			String s = scanner.nextLine();

			String[] arr = s.split(" ");

			for(String str: arr)
			{
				if(termCountMap.containsKey(str))
				{
					int count = termCountMap.get(str);
					termCountMap.put(str, count+1);
				}
				else
					termCountMap.put(str, 1);
			}			
		}
		
	}

	@After
	public void tearDown() throws Exception {
		
		scanner.close();
	}

	@Test
	public void testSearchTermFound() {
		
		@SuppressWarnings("rawtypes")
		Iterator iterator = termCountMap.entrySet().iterator();
		String searchTerm = "articles";
		
		while(iterator.hasNext())
		{
			@SuppressWarnings("unchecked")
			Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)iterator.next();
			
			if(entry.getKey().equals(searchTerm))
			{
				int count = entry.getValue();
				assertEquals(1, count);
			}
		}
	}
	
	@Test
	public void testSearchTermNotFound() {
		
		@SuppressWarnings("rawtypes")
		Iterator iterator = termCountMap.entrySet().iterator();
		String searchTerm = "the";
		
		while(iterator.hasNext())
		{
			@SuppressWarnings("unchecked")
			Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>)iterator.next();
			
			if(entry.getKey().equals(searchTerm))
			{
				int count = entry.getValue();
				assertEquals(0, count);
			}
		}
		
	}

}
