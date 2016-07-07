package termSearch.test;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import termSearch.search.StringMatchSearch;

/**
 * 
 * Test class to test String match search method
 * 
 * @author rohit
 *
 */
public class StringMatchSearchTest {
	
	Scanner scanner;
	StringMatchSearch strMatchSearch;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		strMatchSearch = new StringMatchSearch();
		String fileName = "F:/my projects/target/Target/SampleFiles/testMatchFile.txt";
		File file = new File(fileName);
		scanner = new Scanner(new FileReader(file));
		System.out.println();
	}

	@After
	public void tearDown() throws Exception {
		
		scanner.close();
	}

	
	@Test
	public void searchTermFoundTest() {
		
		
		String testSearchTerm1 = "articles";
		int countTerm1 = 0;
		
		while(scanner.hasNextLine())
		{
			String s = scanner.nextLine();
			String[] arr = s.split(" ");

			for(String str: arr)
			{
				if(str.equals(testSearchTerm1))
				{
					countTerm1++;
				}
			}	
		}
		
		assertEquals(1,countTerm1);
	}
	
	@Test
	public void searchTermNotFoundTest(){
		
		String testSearchTerm2 = "";
		int countTerm2 = 0;
		
		while(scanner.hasNextLine())
		{
			String s = scanner.nextLine();
			String[] arr = s.split(" ");

			for(String str: arr)
			{
				if(str.equals(testSearchTerm2))
				{
					countTerm2++;
				}
			}	
		}
		
		assertEquals(0,countTerm2);
	}
	
	
}
