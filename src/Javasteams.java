import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class Javasteams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> names = new ArrayList<String>();
		names.add("Orange");
		names.add("Cucumber");
		names.add("Banana");
		names.add("Mango");
		names.add("Beetroot");
		int count = 0;
		for (int i = 0; i < names.size(); i++) {
			String thename = names.get(i);
			if (thename.startsWith("B")) {
				count++;
			}
		}
		System.out.println(count);

		// performing the same logic with stream

		Long count2 =names.stream().filter(s -> s.startsWith("B")).count();
		//.count in this case is a terminal operation
		//filter is an intermediate operation
		//terminal operation will only work if the filter operation returns true
		System.out.println(count2);
		
		//Alternatively, a stream of the strings can be created directly
		//where s -> s is referred to as lambda expression
		//lambda expression takes parameter and return something
		//if a lambda expression only contains one variable, it can be stated directly like
		/**
		 * s->s.method() but if it contains more than one function, it can be in a block of curly braces
		 * expressed as s-> { }
		 */
		Long d=Stream.of("mango","orange","onions","species").filter(s->s.startsWith("o")).count();
		System.out.println(d);
		//when the lambda function action is in a block of curly braces, a return type has to be specified
		
		Long f=Stream.of("mango","opium","orange","onions","species").filter(s->{
			s.startsWith("ma");
			return true;
		}).count();
		System.out.println(f);
		Stream.of("mango","orange","onions","species").filter(s->s.startsWith("o")).forEach(System.out::println);
		
		names.stream().filter(s->s.length()>7).forEach(System.out::println);
		//the result can also be limited using the .limit() function
		names.stream().filter(s->s.length()>7).limit(1).forEach(s->System.out.println(s));
		
		//map action can also be used to perform an action on the filtered result
		Stream.of("Joy","peace","grace","faith").filter(s->s.endsWith("e")).map(s->s.toUpperCase())
		.forEach(System.out::println);
		
		//the method or terminal operation sorted() can also be used on a stream
		//sorted arranges the stream alphabetically
		Stream.of("joy","peace","grace","faith").sorted().map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		/**
		 * Two streams can also be merged into one stream using Stream.concat
		 * which concatenates the streams into one
		 * 
		 */
		
		ArrayList<String> arr1 = new ArrayList<String>();
		arr1.add("Genesis");
		arr1.add("exodus");
		arr1.add("Leviticus");
		arr1.add("Numbers");
		
		ArrayList<String> arr2 = new ArrayList<String>();
		arr2.add("Matthew");
		arr2.add("Mark");
		arr2.add("Luke");
		arr2.add("John");
		
		//now convert both arraylist to streams
		Stream<String> stream1 = arr1.stream();
		Stream<String> stream2 = arr2.stream();
		
		//Concatenate both streams into one stream using Stream.concat() method
		
		Stream<String> newStream= Stream.concat(stream1, stream2);
		//newStream.map(s->s.toLowerCase()).forEach(System.out::println);
		//any Match method can be used on a stream to check if it contains any 
		//item in the stream
		boolean flag= newStream.anyMatch(s->s.equalsIgnoreCase("Mark"));
		Assert.assertTrue(flag);
		
		/**
		 * Another method that can work with stream is .collect()
		 * This is used to put all the result of the stream after a terminal operation
		 * has been performed into a list or any other collection e.g set
		 */
		
		List<String> ls=Stream.of("Samuel","Amos","Obadiah","Micah")
				.filter(s->s.endsWith("h")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
		
		System.out.println(ls.get(0));
		
		//the result in the list in this case will be obadiah and micah ending with "h"
		
		/**
		 * PRINTING UNIQUE NUMBERS IN AN ARRAY USING STREAM and distinct
		 */
	
		
		List<Integer> arrlist=Arrays.asList(7,1,2,2,4,5);
		
		arrlist.stream().sorted().distinct().forEach(System.out::println);
		
		
	} 
	

}
