package practiceprograms;
class Person {
    private int age;
    public void setAge(int age) {
        System.out.println("My age is " + age);
  }
}

class DataHiding {
  public static void main(String[] args) {
    Person p1 = new Person();
    p1.setAge(24);
  }
}