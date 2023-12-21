package basicprograms;

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(Student other) {
        this.name = other.name;
        this.age = other.age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class CopyConstructor {
    public static void main(String[] args) {
        
        Student originalStudent = new Student("Vikram", 21);

        Student copiedStudent = new Student(originalStudent);

        System.out.println("Original Student - Name: " + originalStudent.getName() + ", Age: " + originalStudent.getAge());
        System.out.println("Copied Student - Name: " + copiedStudent.getName() + ", Age: " + copiedStudent.getAge());
    }
}

