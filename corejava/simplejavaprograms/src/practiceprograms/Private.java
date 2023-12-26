package practiceprograms;

class Data {
    private String name;
    public void setName(String name) {
       System.out.println("The name is " + name);
    }
}
public class Main {
    public static void main(String[] main){
        Data d = new Data();
	d.setName("Programiz");
    }
}