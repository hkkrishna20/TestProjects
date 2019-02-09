
public class TestClass {
	
	private static TestClass testClasse = new TestClass();
	private  TestClass() {
		
		System.out.println("Creating...");
	}
	
	public static TestClass getInstance() {
		
		return testClasse;
	}
	

}
