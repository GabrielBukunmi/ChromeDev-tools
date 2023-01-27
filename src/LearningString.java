
public class LearningString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Creating strings using string literal
		String s1 = "FirstName Middlename Surname";
		String s2 = "LastName";

		// Creating string using new keyword. this way, same value can be assigned to
		// two different string objects
		String s = new String("Welcome");
		String s3 = new String("Welcome");

		String[] SplittedString = s1.split(" ");

		// System.out.println(SplittedString[2]);

		for (int i = s1.length() - 1; i >= 0; i--) {
			System.out.println(s1.charAt(i));
		}
	}

}
