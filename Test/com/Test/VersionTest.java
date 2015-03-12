//package com.Test;
//
//import java.util.*;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
//
//class Adder implements ListMapper<Integer,Integer>{
//	public Integer callback(Integer ele){
//		return ele + 2;
//	}
//}
//
//class convertIntToString implements ListMapper<Integer,String>{
//	public String callback(Integer ele){
//		return ele + "";
//	}
//}
//
//class Multiply implements ListMapper<Double,Double>{
//	public Double callback(Double element){
//		return element * 2.5;
//	}
//}
//
//class convertString implements ListMapper<String,String>{
//	public String callback(String element){
//		return "Hello";
//	}
//}
//
//class returnGreaterThanFive implements ListFilter<Integer>{
//	public Boolean filterCallback(Integer element){
//		return element>5;
//	}
//}
//
//class returnEvenNumber implements ListFilter<Integer>{
//	public Boolean filterCallback(Integer element){
//		return (element%2==0)?true:false;
//	}
//}
//
//class returnOddNumber implements ListFilter<Integer>{
//	public Boolean filterCallback(Integer element){
//		return (element%2!=0)?true:false;
//	}
//}
//
//class addListElements implements ListReducer<Integer,Integer>{
//	public Integer reduceCallback(Integer init , Integer element){
//		return init + element;
//	}
//}
//
//public class VersionTest{
//	private static final double DELTA = 1e-15;
//
//	@Test
//	public void add_2_in_each_element_of_mapList(){
//		List<Integer> list = new ArrayList<Integer>();
//		for(int i=1;i<=5;i++){ list.add(i);}
//		List<Integer> newlist = CollectionUtils.map(list,new Adder());
//		assertEquals((int)newlist.get(0),3);
//		assertEquals((int)newlist.get(4),7);
//	}
//	@Test
//	public void convert_integer_to_string_each_element_of_mapList(){
//		List<Integer> list = new ArrayList<Integer>();
//		for(int i=1;i<=5;i++){ list.add(i);}
//		List<String> newlist = CollectionUtils.map(list,new convertIntToString());
//		assertEquals((String)newlist.get(0),"1");
//		assertEquals((String)newlist.get(4),"5");
//	}
//	@Test
//	public void multiply_2_point_5_in_each_element_of_mapList(){
//		List<Double> list = new ArrayList<Double>();
//		list.add(2.0);
//		list.add(5.5);
//		List<Double> newlist = CollectionUtils.map(list,new Multiply());
//		assertEquals((double)newlist.get(0),5.0,DELTA);
//		assertEquals((double)newlist.get(1),13.75,DELTA);
//	}
//	@Test
//	public void convert_string_to_anotherString_of_mapList(){
//		List<String> list = new ArrayList<String>();
//		list.add("Dolly");
//		List<String> newlist = CollectionUtils.map(list,new convertString());
//		assertEquals((String)newlist.get(0),"Hello");
//	}
//	@Test
//	public void return_number_grreater_than_five(){
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(4);
//		list.add(7);
//		List<Integer> newlist = CollectionUtils.filter(list,new returnGreaterThanFive());
//		assertEquals((int)newlist.get(0),7);
//	}
//	@Test
//	public void return_list_of_even_numbers(){
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(4);
//		list.add(7);
//		List<Integer> newlist = CollectionUtils.filter(list,new returnEvenNumber());
//		assertEquals((int)newlist.get(0),4);
//	}
//	@Test
//	public void return_list_of_odd_numbers(){
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(4);
//		list.add(7);
//		List<Integer> newlist = CollectionUtils.filter(list,new returnOddNumber());
//		assertEquals((int)newlist.get(0),7);
//	}
//	public void return_add_of_all_numbers_of_list(){
//		List<Integer> list = new ArrayList<Integer>();
//		int initial = 2;
//		for(int i=1;i<=5;i++){ list.add(i);}
//		int result = CollectionUtils.reduce(list,new addListElements(),initial);
//		assertEquals(result,17);
//	}
//}