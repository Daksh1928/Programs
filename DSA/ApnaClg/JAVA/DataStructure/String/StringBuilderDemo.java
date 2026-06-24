package DataStructure.String;

public class StringBuilderDemo {

    // Class object created here
    private StringBuilder sb;

    // Constructor
    public StringBuilderDemo() {
        sb = new StringBuilder();
    }

    // Constructor with initial value
    public StringBuilderDemo(String text) {
        sb = new StringBuilder(text);
    }

    // Function to show current value
    public void display() {
        System.out.println("Current StringBuilder = " + sb.toString());
    }

    // append()
    public void appendText(String text) {
        sb.append(text);
    }

    // insert()
    public void insertText(int index, String text) {
        sb.insert(index, text);
    }

    // delete()
    public void deleteText(int start, int end) {
        sb.delete(start, end);
    }

    // deleteCharAt()
    public void deleteCharAtIndex(int index) {
        sb.deleteCharAt(index);
    }

    // replace()
    public void replaceText(int start, int end, String text) {
        sb.replace(start, end, text);
    }

    // reverse()
    public void reverseText() {
        sb.reverse();
    }

    // setCharAt()
    public void setCharacter(int index, char ch) {
        sb.setCharAt(index, ch);
    }

    // setLength()
    public void setBuilderLength(int len) {
        sb.setLength(len);
    }

    // capacity()
    public int getCapacity() {
        return sb.capacity();
    }

    // ensureCapacity()
    public void increaseCapacity(int minimumCapacity) {
        sb.ensureCapacity(minimumCapacity);
    }

    // length()
    public int getLength() {
        return sb.length();
    }

    // charAt()
    public char getCharacterAt(int index) {
        return sb.charAt(index);
    }

    // substring()
    public String getSubstring(int start) {
        return sb.substring(start);
    }

    public String getSubstring(int start, int end) {
        return sb.substring(start, end);
    }

    // indexOf()
    public int findIndex(String text) {
        return sb.indexOf(text);
    }

    // lastIndexOf()
    public int findLastIndex(String text) {
        return sb.lastIndexOf(text);
    }

    // codePointAt()
    public int getCodePointAt(int index) {
        return sb.codePointAt(index);
    }

    // codePointBefore()
    public int getCodePointBefore(int index) {
        return sb.codePointBefore(index);
    }

    // codePointCount()
    public int getCodePointCount(int start, int end) {
        return sb.codePointCount(start, end);
    }

    // toString()
    public String getText() {
        return sb.toString();
    }

    // Main method
    public static void main(String[] args) {
        StringBuilderDemo obj = new StringBuilderDemo("Hello");

        System.out.println("Initial value:");
        obj.display();

        obj.appendText(" Java");
        System.out.println("\nAfter append:");
        obj.display();

        obj.insertText(5, " World");
        System.out.println("\nAfter insert:");
        obj.display();

        obj.deleteText(5, 11);
        System.out.println("\nAfter delete:");
        obj.display();

        obj.replaceText(0, 5, "Hi");
        System.out.println("\nAfter replace:");
        obj.display();

        obj.appendText(" Programming");
        System.out.println("\nAfter more append:");
        obj.display();

        obj.setCharacter(0, 'B');
        System.out.println("\nAfter setCharAt:");
        obj.display();

        System.out.println("\nLength = " + obj.getLength());
        System.out.println("Capacity = " + obj.getCapacity());
        System.out.println("Character at index 1 = " + obj.getCharacterAt(1));
        System.out.println("Substring from 2 = " + obj.getSubstring(2));
        System.out.println("Substring from 0 to 4 = " + obj.getSubstring(0, 4));
        System.out.println("Index of 'Java' = " + obj.findIndex("Java"));
        System.out.println("Last index of 'g' = " + obj.findLastIndex("g"));

        obj.reverseText();
        System.out.println("\nAfter reverse:");
        obj.display();

        obj.increaseCapacity(100);
        System.out.println("\nAfter ensureCapacity(100):");
        System.out.println("Capacity = " + obj.getCapacity());

        obj.setBuilderLength(10);
        System.out.println("\nAfter setLength(10):");
        obj.display();

        System.out.println("\nCode point at index 0 = " + obj.getCodePointAt(0));
    }
}