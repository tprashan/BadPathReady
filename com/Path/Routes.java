import java.util.*;

class Routes{
	public static Queue<String> queue = new LinkedList<String>();

	public static String giveKeyFromMapValue(String fileName,String src){
    	Map<String,List<String>> db =  ReadFileInput.createDataBaseFromFileInput(fileName);
		String dummyString="dummy@String";
		for (String keyCity : db.keySet()) {
			if(db.get(keyCity).contains(src))
				return keyCity;
		}
		return dummyString;
	}

	public static Boolean isDirectRoutes(String fileName,String src,String des){
    	Map<String,List<String>> db =  ReadFileInput.createDataBaseFromFileInput(fileName);
		String key = giveKeyFromMapValue(fileName,src); 
 		if((db.get(src)!=null && db.get(src).contains(des)) || key.equals(des)){
 			queue.add(src);queue.add(des);
			return true;
 		}
		return false;
	}

	public static Boolean isPathExists(String fileName,String src,String des){
		Map<String,List<String>> db =  ReadFileInput.createDataBaseFromFileInput(fileName);
		for(String city: db.get(src)) {
			if((db.keySet().contains(city)) && db.get(city).contains(des)){
				queue.add(city);queue.add(des);
				return true;
			}
		}
		for(String city: db.get(src))
			if(!queue.contains(city)) return isRoute(fileName,city,des);
		return false;
	}

	public static Boolean findReverseRoutes(String fileName,String src,String des){
		Map<String,List<String>> db =  ReadFileInput.createDataBaseFromFileInput(fileName);
		String key = giveKeyFromMapValue(fileName,src);
		if(key.equals(des)) { queue.add(des);return true;}

		if(db.get(key)!=null && db.get(key).contains(des)){ queue.add(key);queue.add(des);return true;}

		if(db.keySet().contains(key)){
			if(queue.size()>0 && queue.element().equals(src)){ queue.clear();queue.add(src);}
			if(queue.size()>0 && queue.element().equals(key)){ queue.clear();queue.add(src);}

			if(isDirectRoutes(fileName,key,des) || isRoute(fileName,key,des)) return true;
			return findReverseRoutes(fileName,key,des);
		}
		return false;
	}

	public static Boolean isRoute(String fileName,String src,String des){
		Map<String,List<String>> db =  ReadFileInput.createDataBaseFromFileInput(fileName);
		if(src.equals(des)) return true;
		if(db.keySet().contains(src)){
			queue.add(src);
			return isPathExists(fileName,src,des);
		}
		if(!(db.keySet().contains(src))){
			queue.add(src);
			return findReverseRoutes(fileName,src,des);
		}
		return false;
	}

    public static void removeInvalidPath(){
        LinkedList<String>list =((LinkedList<String>)queue);
        Queue<String> dltQueue = new LinkedList<String>();
        for(String city:list){
            int firstIndex =list.indexOf(city);
            int lastIndex =list.lastIndexOf(city);
            if(firstIndex!=lastIndex){
                for(int i=firstIndex;i<lastIndex;i++){
                    dltQueue.add(list.get(i));
                }
                for (String rmcity:dltQueue ) {
                    queue.remove(rmcity);
                }
                break;
            }
        }
    }

}