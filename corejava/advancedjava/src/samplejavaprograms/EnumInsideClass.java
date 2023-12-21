package samplejavaprograms;

//enum declaration inside a class.

public class EnumInsideClass {
	enum Color {
		RED,
		GREEN,
		BLUE;
	}

	// Driver method
	public static void main(String[] args)
	{
		Color c1 = Color.RED;
		System.out.println(c1);
	}
}
