package SeleniumAutomation;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
   	@DataProvider(name="searchText")
  	  public static Object[][] getDataProviderData(){
   		Object[][] searchWords = new Object[3][1];
   		searchWords[0][0] = "Testing";
      	searchWords[1][0] = "WebDriver";
      	searchWords[2][0] = "Java";
      	return searchWords;
   	}
}
