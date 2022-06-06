package javaSream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;


public class JavaStreams {
	
	//@Test
public static void Namecount()
{
	ArrayList<String> names=new ArrayList<String>();
	names.add("Sahil");
	names.add("Abhijeet");
	names.add("Alia");
	names.add("Ram");
	names.add("Adam");
	int count=0;
	for(int i=0;i<names.size();i++)
	{
		String name=names.get(i);
		if(name.startsWith("A"))
		{
			count++;
		}
	}
	System.out.println("Names starting with A: "+count);
		}
	//@Test
	public static void StreamFilter()

	{
		ArrayList<String> names=new ArrayList<String>();
		names.add("Sahil");
		names.add("Abhijeet");
		names.add("Alia");
		names.add("Aam");
		names.add("Adam");
		Long c=names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		long d=Stream.of("Sahil","Aam","Adam","Rahul","Alia").filter(s->s.startsWith("A")).count();
		System.out.println(d);
		names.stream().filter(s->s.length()>8).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>3).limit(2).forEach(s->System.out.println(s));
		}
//@Test
public static void StreamMap()

{ArrayList<String> names=new ArrayList<String>();
names.add("USA");
names.add("INDIA");
names.add("SPAIN");
names.add("FRANCE");
names.add("AUSTRALIA");
	Stream.of("Sahil","Aam","Adam","Rahul","Alia").filter(s->s.endsWith("m")).map(s->s.toUpperCase())
	.forEach(s->System.out.println(s));
	List<String> name1=Arrays.asList("Sahil","Aam","Adam","Rahul","Alia");
	name1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
Stream<String> nameConcat=Stream.concat(names.stream(), name1.stream());
//nameConcat.forEach(s->System.out.println("List is"+s));
boolean flag=nameConcat.anyMatch(s->s.equalsIgnoreCase("Adam"));
Assert.assertTrue(flag);
}
	
@Test
public static void StreamCollect()
	{
		Set<String> ls=Stream.of("Sahil","Aam","Adam","Rahul","Alia","AAM").filter(s->s.endsWith("m")).map(s->s.toUpperCase()).collect(Collectors.toSet());
		System.out.println(ls);
		List<Integer> values=Arrays.asList(1,2,5,22,10,47,3,400,34,2,1,400);
		List<Integer> numberList=values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(numberList);
		
	}


}