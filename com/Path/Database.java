import java.util.*;

class Database{
	public static Map<String,List<String>> createDataBase(){
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		map.put("Bangalore", new ArrayList<String>(Arrays.asList("Singapore")));
		map.put("Singapore", new ArrayList<String>(Arrays.asList("Seoul","Dubai")));
		map.put("Seoul", new ArrayList<String>(Arrays.asList("Beijing")));
		map.put("Beijing", new ArrayList<String>(Arrays.asList("Tokyo")));
		map.put("Dubai", new ArrayList<String>(Arrays.asList("Lucknow")));
		map.put("Lucknow", new ArrayList<String>(Arrays.asList("Ci")));
		return map;
	}
}