package JVM;

public class ForTest {
	public static void main(String[] args) {
		double d = 1234.5678;
		Variable a = new Variable(d);
		byte[] b = a.load();
		double c = Transfer.getDouble(b);
		c++;
		System.out.println(c);
	}
}
