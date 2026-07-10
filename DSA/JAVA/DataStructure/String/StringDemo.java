package DataStructure.String;

public class StringDemo {
    private String str;

    // Constructor
    public StringDemo(String str) {
        this.str = str;
    }

    // Display current string
    public void display() {
        System.out.println("Current String = " + str);
    }

    // Length
    public int getLength() {
        return str.length();
    }

    // charAt
    public char getCharAt(int index) {
        return str.charAt(index);
    }

    // concat
    public void addText(String text) {
        str = str.concat(text);
    }

    // substring from start
    public String getSubstring(int start) {
        return str.substring(start);
    }

    // substring from start to end
    public String getSubstring(int start, int end) {
        return str.substring(start, end);
    }

    // indexOf
    public int findIndex(String text) {
        return str.indexOf(text);
    }

    // lastIndexOf
    public int findLastIndex(String text) {
        return str.lastIndexOf(text);
    }

    // toUpperCase
    public void convertUpperCase() {
        str = str.toUpperCase();
    }

    // toLowerCase
    public void convertLowerCase() {
        str = str.toLowerCase();
    }

    // trim
    public void removeSpaces() {
        str = str.trim();
    }

    // replace
    public void replaceText(String oldText, String newText) {
        str = str.replace(oldText, newText);
    }

    // startsWith
    public boolean startsWithText(String text) {
        return str.startsWith(text);
    }

    // endsWith
    public boolean endsWithText(String text) {
        return str.endsWith(text);
    }

    // equals
    public boolean isEqual(String text) {
        return str.equals(text);
    }

    // reverse string
    public void reverseString() {
        StringBuilder sb = new StringBuilder(str);
        str = sb.reverse().toString();
    }

    public static void main(String[] args) {
        StringDemo obj = new StringDemo("  Hello Java  ");

        obj.display();

        obj.removeSpaces();
        obj.display();

        obj.addText(" Programming");
        obj.display();

        System.out.println("Length = " + obj.getLength());
        System.out.println("Char at 1 = " + obj.getCharAt(1));
        System.out.println("Substring from 2 = " + obj.getSubstring(2));
        System.out.println("Index of Java = " + obj.findIndex("Java"));

        obj.convertUpperCase();
        obj.display();

        obj.replaceText("JAVA", "WORLD");
        obj.display();

        obj.reverseString();
        obj.display();
    }
}