import java.util.*;
import java.util.LinkedList;

class AllRoutes{
//    public static Queue<String> queue = new LinkedList<String>();
    public static ArrayList<String> route = new ArrayList<String>();
    public static Map<Integer,ArrayList<String>> allPaths  = new HashMap<Integer,ArrayList<String>>();
    private static int count;

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
            route.add(src);route.add(des);
            return true;
        }
        return false;
    }

    public static Boolean isPathExists(String fileName,String src,String des){
        Map<String,List<String>> db =  ReadFileInput.createDataBaseFromFileInput(fileName);
        for(String city: db.get(src)) {
            if((db.keySet().contains(city)) && db.get(city).contains(des)){
                route.add(city);route.add(des);
                allPaths.put(count++, (ArrayList<String>)route.clone());
                route.clear();
                return true;
            }
        }
        for(String city: db.get(src))
            if(!route.contains(city)) return isRoute(fileName,city,des);
        return false;
    }

    public static Boolean findReverseRoutes(String fileName,String src,String des){
        Map<String,List<String>> db =  ReadFileInput.createDataBaseFromFileInput(fileName);
        String key = giveKeyFromMapValue(fileName,src);
        if(key.equals(des)) { route.add(des);
            allPaths.put(count++, (ArrayList<String>)route.clone());
            route.clear();
            return true;
        }

        if(db.get(key)!=null && db.get(key).contains(des)){ route.add(key);route.add(des);
            allPaths.put(count++, (ArrayList<String>)route.clone());
            route.clear();
            return true;
        }

        if(db.keySet().contains(key)){
            if(route.size()>0 && route.get(0).equals(src)){ route.clear();route.add(src);}

            if(isDirectRoutes(fileName,key,des) || isRoute(fileName,key,des)){
                allPaths.put(count++, (ArrayList<String>)route.clone());
                return true;
            }
            return findReverseRoutes(fileName,key,des);
        }
        return false;
    }

    public static Boolean isRoute(String fileName,String src,String des){
        Map<String,List<String>> db =  ReadFileInput.createDataBaseFromFileInput(fileName);
        if(src.equals(des)){
            allPaths.put(count++, (ArrayList<String>)route.clone());
            route.clear();
            return true;
        }
        if(db.keySet().contains(src)){
            route.add(src);
            return isPathExists(fileName,src,des);
        }
        if(!(db.keySet().contains(src))){
            route.add(src);
            return findReverseRoutes(fileName,src,des);
        }
        return false;
    }
}