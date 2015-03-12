import java.util.*;

public class Path{
	public static void main(String[] args)throws Exception{
		int fileIndex = Arrays.asList(args).indexOf("-f");
		int countryFileIndex = Arrays.asList(args).indexOf("-c");
		int allRoutesIndex = Arrays.asList(args).indexOf("-a");
		int length = args.length;
		if(fileIndex>=0){
			try{
				Boolean path = false;
				if(countryFileIndex>=0 && allRoutesIndex<0)
					path = SearchPath.findRoutes(args[countryFileIndex+1],args[fileIndex+1],args[length-2],args[length-1],"option");
                if(countryFileIndex>=0 && allRoutesIndex>=0)
                    path = SearchPath.findRoutes(args[countryFileIndex+1],args[fileIndex+1],args[length-2],args[length-1],args[allRoutesIndex]);
                if(countryFileIndex<0 && allRoutesIndex>=0)
                    path = SearchPath.findRoutes("Dummy@File",args[fileIndex+1],args[length-2],args[length-1],args[allRoutesIndex]);
                else
					path = SearchPath.findRoutes("Dummy@File",args[fileIndex+1],args[length-2],args[length-1],"option");
				System.out.println(path);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}else{
			try{
				Boolean path = Paths.findPaths(args[0],args[1]);
				System.out.println(path);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
	}
};