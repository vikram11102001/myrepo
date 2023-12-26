package practiceprograms;

public class Subtraction{
    public static void main(String args[]){
        int diff;
        diff = diff(50, 10);
        System.out.println("The difference b/w two numbers a and b is: " + diff);
    }
    public static int diff(int a, int b){
        int diff = a - b;  
        return diff;
    }
}