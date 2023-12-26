package practiceprograms;

abstract class Language {
  public void display() {
    System.out.println("This is Java Programming");
  }
}

class AbstractClass extends Language {

  public static void main(String[] args) {
    Main obj = new Main();
    obj.display();
  }
}