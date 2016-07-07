# rohitpendbhaje-Target

### Instruction to run the program:

Repository URL: [https://github.com/rohit-p/rohitpendbhaje-Target](https://github.com/rohit-p/rohitpendbhaje-Target)

1. To import the project you will need EGit plugin in Eclipse.
   Download the plugin [http://download.eclipse.org/egit/updates/](http://download.eclipse.org/egit/updates/) and clone and import the repository

2. Run the class Driver.java as java application

3. The program will ask several options in the console. Please proceed as follows:
	a. enter the search term you want to search in the given text files
	b. enter option to select the type of search you want

4. Run class PerformanceSearch.java class as java application to see performanance search results

### Running test cases:

1. To run the test case simply right click on package src/termSearch/test and run as jUnit Test

### Assumptions:

1. Search terms are characters, numbers or alphanumeric 
2. Index search techique is doing data preprocessing each time when user is asking for Index search option. but in real       world scenario the data preprocessing technique should be done only once. 
3. Performance search might take significant time depending on processing speed of hardware.


### Which is the better approach?

1. Indexed search approach is the fastest. This is due to data indexing done as a part of data preprocessing. Given program    uses hashmap as an indexing technique for given amount of data.

2. In the program a HashMap has been used which stores each term and its count as a <key, value> pair and this hashmap is    used as a value in another hashmap which stores text file entry as a key.
   
3. So once this data preprocessing is done (which should be a one time process), 'search term count' can be retrieved in       constant time. Thus immensely reducing the search time as compared to String match and Regular expression search        techniques.
