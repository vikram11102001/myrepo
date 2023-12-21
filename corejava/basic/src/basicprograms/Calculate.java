package basicprograms;

public class Calculate {
	
	int i1;
	int i2;
	
	
	public int getI1() {
		return i1;
	}

	public void setI1(int i1) {
		this.i1 = i1;
	}

	public int getI2() {
		return i2;
	}

	public void setI2(int i2) {
		this.i2 = i2;
	}

	public int add() {
		return getI1() + getI2();
	}
	
	public int sub() {
		
		return getI1() - getI2();
	}
	
	public int mul() {
		return getI1() * getI2();
	}
	public static void main(String[] args) {
		
		Calculate c = new Calculate();
		c.setI1(4);
		c.setI2(2);
		System.out.println(c.add());
		System.out.println(c.sub());
		System.out.println(c.mul());
	}
}
