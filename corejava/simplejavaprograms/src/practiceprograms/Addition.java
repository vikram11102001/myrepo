package practiceprograms;
public class Addition{
static{
	System.out.println("this is static block 1");
}
    public static void main(String args[]){
        int sum;
        sum = sum(50, 10);
        System.out.println("The sum of two numbers a and b is: " + sum);
    }
    public static int sum(int a, int b){
        int sum = a + b;  
        return sum;
    }
static{
	System.out.println("this is static block 2");
}

}
