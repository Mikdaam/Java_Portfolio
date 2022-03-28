public class Main {
	public Main(int foo) {
		super();
		this.foo = foo;
	}

	int foo;
	public static void main(String[] args) {
		System.out.println("Hello Eclipse");
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public int getFoo() {
		return foo;
	}
	
	public void setFoo(int foo) {
		this.foo = foo;
	}
}
