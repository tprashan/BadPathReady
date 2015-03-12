class PrintPath{
	public static String printPath(String src,String des){
		String path= "";
		DirectPath.removeinvalidPath();
		if(!DirectPath.queue.element().equals(des))
			path = String.join("->",DirectPath.queue);
		else{
			for(String q : DirectPath.queue)
			  		path+=q.toString()+" -> "; 
		}
		return path;
	}
}

public class Paths{
	public static Boolean findPaths(String src,String des)throws Exception{
	    Boolean directPath = DirectPath.findDirectPath(src,des);
		if(!SearchInDatabase.isCityPresentInDatabase(src))
			throw new Exception("No city Named : "+ src +" in database.");
		if(!SearchInDatabase.isCityPresentInDatabase(des))
			throw new Exception("No city Named : "+des +" in database.");
		if(directPath)
			throw new Exception("Full Path is: "+PrintPath.printPath(src,des));
	    Boolean fullPath = DirectPath.findPath(src,des);
	    if(fullPath)
	    	throw new Exception("Full Path is: "+PrintPath.printPath(src,des)); 
		return fullPath;
	}
}