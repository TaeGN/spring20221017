package lecture.p01lombok;

public class App {
	public static void main(String[] args) {
		System.out.println("efseg");
		
		JavaBean2 j2 = new JavaBean2();
		j2.setCompany("tse");
		String s = j2.getCompany();
		System.out.println(s);
	}
}
