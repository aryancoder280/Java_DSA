package basics;

public class Constructor {
	final String name;
	public Constructor() {
		name = "";
		;
	}
	public Constructor(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	public static void print() {
		System.out.println("my name is " + new Constructor("Aryan").name);
	}

	public static void main(String[] args) {
		Constructor.print();
	}
}
