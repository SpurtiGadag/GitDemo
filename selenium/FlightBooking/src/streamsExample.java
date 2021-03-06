import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;

import com.google.common.collect.Streams;

public class streamsExample {

	public static void main(String[] args) {
		Stream.of("Abhijeeth","Rama","Alekhya","Don","Adam").filter(s->s.startsWith("A")).forEach(s->System.out.println(s));
		//map to uppercase
		Stream.of("Abhijeeth","Rama","Alekhya","Don","Adam").filter(s->s.startsWith("R")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		//merging two diff lists
		List<String> name1=Arrays.asList("Abhijeeth","Rama","Alekhya","Don","Adam");
		List<String> name=Arrays.asList("Man","Women","Monkey","Bear","Dear");
		Stream<String> newstream=Stream.concat(name.stream(), name1.stream());
		//If there is name Adam then assert pass
		boolean flag=newstream.anyMatch(s->s.equalsIgnoreCase("Adam"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		
		List<Integer> a=Arrays.asList(3,2,2,7,5,1,9,7);
		//Print Unique number
		a.stream().distinct().forEach(s->System.out.println(s));
		//Sorted order collect  to list and display index 2
		List<Integer> li=a.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(li.get(2));
		//limit the output to 2 nos
		name1.stream().filter(s->s.startsWith("A")).limit(2).forEach(s->System.out.println(s));

	}

}
