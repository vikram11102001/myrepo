package basicprograms;

public class TestString {
    public static void main(String[] args) {
        String s1 = "chennai";
        String s2 = manipulateString(s1);
        System.out.println("Output: " + s2);
    }

    public static String manipulateString(String input) {
        char[] charArray = input.toCharArray();

        // Change characters at specific indices
        charArray[0] = 'a'; // Index 0: 'c' to 'a'
        charArray[1] = 'm'; // Index 1: 'h' to 'm'
        charArray[2] = '1'; // Index 2: 'e' to '1'
        charArray[3] = '2'; // Index 3: 'n' to '2'
        charArray[4] = '2'; // Index 4: 'n' to '3'
        charArray[5] = '3'; // Index 5: 'a' to '2'
        charArray[6] = 'q'; // Index 6: 'i' to 'q'

        // Convert the character array back to string
        return new String(charArray);
    }
}


