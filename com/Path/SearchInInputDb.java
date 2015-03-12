import java.util.*;

class SearchInInputDb{
	public static Boolean isCityPresentInDB(String file,String src){
		Map<String,List<String>> db =  ReadFileInput.createDataBaseFromFileInput(file);
		for(String city: db.keySet())
			if(city.equals(src) || db.get(city).contains(src)) return true;
		return false;
	} 
}