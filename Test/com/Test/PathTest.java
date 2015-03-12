//import java.util.*;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//
//public class PathTest{
//	@Test
//	public void find_path_btwn_Singapore_to_dubai_is_true()throws Exception{
//		String src = "Singapore";
//		String des = "Dubai";
//		Boolean path = DirectPath.findDirectPath(src,des);
//		assertEquals(path,true);
//	}
//	@Test
//	public void find_path_btwn_banglore_to_dubai_is_false()throws Exception{
//		String src = "Banglore";
//		String des = "Dubai";
//		Boolean path = DirectPath.findDirectPath(src,des);
//		assertEquals(path,false);
//	}
//	@Test
//	public void find_path_btwn_dubai_to_Tokyo_is_false()throws Exception{
//		String src = "Dubai";
//		String des = "Tokyo";
//		Boolean path = DirectPath.findDirectPath(src,des);
//		assertEquals(path,false);
//	}
//}