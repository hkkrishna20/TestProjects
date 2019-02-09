import static java.util.stream.Collectors.toList;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestingClass {
	public static void filter(List names, Predicate condition) {
		names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
			System.out.println(name + " ");
		});

		Predicate<String> startsWithJ = (n) -> n.startsWith("J");
		Predicate<String> fourLetterLong = (n) -> n.length() == 4;

		names.stream().filter(startsWithJ.and(fourLetterLong))
				.forEach((n) -> System.out.print("\nName, which starts with 'J' and four letter long is : " + n));

		// Applying 12% VAT on each purchase // Old way:
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		double total = 0;
		for (Integer cost : costBeforeTax) {
			double price = cost + .12 * cost;
			total = total + price;
		}
		System.out.println("Total : " + total);
		// New way:
		costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		double bill = costBeforeTax.stream().map((cost) -> cost + .12 * cost).reduce((sum, cost) -> sum + cost).get();
		System.out.println("Total : " + bill);

	}

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		// Even better

		TestClass t1 = TestClass.getInstance();
		TestClass t2 = TestClass.getInstance();

		Class clazz = Class.forName("TestClass");
		Constructor<TestClass> consts = clazz.getDeclaredConstructor();
		consts.setAccessible(true);
		TestClass ts = consts.newInstance();

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		List<Integer> squares = numbers.stream().map(i -> i * i).collect(Collectors.toList());
		/*
		 * List<Integer> together = Stream.of(asList(1, 2, 3, 4, 5, 6, 7, 8, 9),
		 * asList(1, 2, 3, 4, 5, 6, 7, 8, 9)) .map(i -> i *
		 * i).collect(Collectors.toList());
		 */

		// Create a List with String more than 2 characters
		/*
		 * List<String> filtered = strList.stream().filter(x -> x.length() >
		 * 2).collect(Collectors.toList());
		 * System.out.printf("Original List : %s, filtered list : %s %n", strList,
		 * filtered);
		 */

		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
		String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
		System.out.println(G7Countries);
		
/*		Map<String, Book> result = books.stream() .collect(Collectors.toMap(book -> book.getISBN, book -> book));
Map<String, Book> result = books.stream() .collect(Collectors.toMap(Book::getISBN, b -> b));
Map<String, Book> result = choices.stream()
        .collect(Collectors.toMap(Book::getISBN, Function.identity()))
List cards = Arrays.asList("Visa", "MasterCard", "American Express", "Visa"); Map cards2Length = cards.stream() .collect(Collectors.toMap(Function.identity(), String::length));
String combined = String.join(" and ", "LinkedIn", "Microsoft"); 
System.out.println("string joined by and : " + combined); 
// joining elements from a list of String
  String joined = String .join("|", Arrays.asList("Java", "Android", "Oracle")); 
  System.out.println("String joined by pipe from list : " + joined);
   // joining String elements of an array
     String[] biggies = { "Apple", "Google", "Amazon" }; 
      String fromArray = String.join(",", biggies); 
      System.out.println("String joined by comma from array: " + fromArray); 
List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 12, 18);
 Integer lcm = listOfNumbers.stream()
  .filter(i -> i % 2 == 0) 
  .filter(i -> i % 3 == 0) 
  .findFirst().get(); 


ItemToPrice.entrySet()
.stream()
.sorted(Map.Entry.<String, Integer>comparingByValue())
.forEach(System.out::println)
*/
		
		

	    List<String> numbers1 = Arrays.asList("1", "2", "3", "4", "5", "6");
	    System.out.println("original list: " + numbers1);
	    List<Integer> even = numbers1.stream()
	                                .map(s -> Integer.valueOf(s))
	                                .filter(number -> number % 2 == 0)
	                                .collect(Collectors.toList());
	    System.out.println("processed list, only even numbers: " + even);

	}

	public static List<String> transform(List<String> listOfString) {
		return listOfString.stream()
				// Convert list to Stream
				.map(String::toUpperCase)
				// Convert each element to upper case
				.collect(toList());
		// Collect results into a new list }
	}

}
