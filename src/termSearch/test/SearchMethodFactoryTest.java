package termSearch.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import termSearch.search.IndexedSearch;
import termSearch.search.RegexSearch;
import termSearch.search.SearchMethodFactory;
import termSearch.search.StringMatchSearch;

/**
 * This class tests search factory method to return correct object asked by user
 * 
 * @author rohit
 *
 */
public class SearchMethodFactoryTest {
	
	private SearchMethodFactory searchMethodFactory;
	private static final int STRINGMATCH = 1;
	private static final int REGEXSEARCH = 2;
	private static final int INDEXSEARCH = 3;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		searchMethodFactory = new SearchMethodFactory();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetSearchMethod() {
		
			
		assertTrue(searchMethodFactory.getSearchMethod(STRINGMATCH) instanceof StringMatchSearch);
		assertTrue(searchMethodFactory.getSearchMethod(REGEXSEARCH) instanceof RegexSearch);
		assertTrue(searchMethodFactory.getSearchMethod(INDEXSEARCH) instanceof IndexedSearch);
		
	}
	
	@Test
	public void testGetSearchMethodIncorrectInput(){
		
		assertFalse(searchMethodFactory.getSearchMethod(REGEXSEARCH) instanceof StringMatchSearch);
		
		
	}

}
