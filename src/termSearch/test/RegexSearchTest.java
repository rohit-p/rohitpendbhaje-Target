package termSearch.test;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 
 * Test class to test regex search method
 * 
 * @author rohit
 *
 */

public class RegexSearchTest {
	
	private Scanner scanner = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		File file  = new File("F:/my projects/target/Target/SampleFiles/testMatchFile.txt");
		scanner = new Scanner(new FileReader(file));
	}

	@After
	public void tearDown() throws Exception {
		scanner.close();
	}

	@Test
	public void testSearchTermFound() {
		
		int searchTermCount = 0;
		String searchTerm = "articles";
		String searchStr = "\\b"+searchTerm+"\\b";
		
		Pattern pattern = Pattern.compile(searchStr);
		
		while(scanner.hasNextLine())
		{
			String str = scanner.nextLine();
			
			Matcher matcher = pattern.matcher(str);
			
			if(matcher.find())
			{
				searchTermCount++;
			}
		}
		
		assertEquals(1, searchTermCount);
	}
	
	@Test
	public void testSearchTermNotFound(){
		
		int searchTermCount = 0;
		String searchTerm = "the";
		String searchStr = "\\b"+searchTerm+"\\b";
		
		Pattern pattern = Pattern.compile(searchStr);
		
		while(scanner.hasNextLine())
		{
			String str = scanner.nextLine();
			
			Matcher matcher = pattern.matcher(str);
			
			if(matcher.find())
			{
				searchTermCount++;
			}
		}
		
		assertEquals(0, searchTermCount);	
	}

}
