package termSearch.search;

/**
 * Factory class which gives back the object back of concrete classes depending on the 
 * user input
 * 
 * @author rohit
 *
 */
public class SearchMethodFactory {

	/**
	 * factory method to return object of implemented class based on
	 * user's entered option
	 * 
	 * @param option - option entered by user
	 * @return object of IMethodReader interface's implementation
	 */
	public IMethodReader getSearchMethod(int option)
	{
		
		if(option == 1)
			return new StringMatchSearch();
		else if(option == 2)
			return new RegexSearch();
		else if(option == 3)
			return new IndexedSearch();
		
		return null;
	}
	
	
	
	
}
