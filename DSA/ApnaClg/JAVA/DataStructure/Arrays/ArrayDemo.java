package DataStructure.Arrays;

import java.util.Arrays;

public class ArrayDemo {
    private int[] arr;
    private int size;

    // Constructor
    public ArrayDemo(int[] arr) {
        this.arr = arr;
        this.size = arr.length;
    }

    // Display array
    public void display() {
        System.out.print("Array = ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Get length
    public int getLength() {
        return size;
    }

    // Search element
    public int search(int value) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // Update element
    public void update(int index, int value) {
        if (index >= 0 && index < size) {
            arr[index] = value;
        } else {
            System.out.println("Invalid index");
        }
    }

    // Reverse array
    public void reverse() {
        int left = 0, right = size - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    // Sort array
    public void sortArray() {
        Arrays.sort(arr);
    }

    // Sum of elements
    public int getSum() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
        }
        return sum;
    }

    // Maximum element
    public int getMax() {
        int max = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Minimum element
    public int getMin() {
        int min = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    // Insert element at end
    public void insertAtEnd(int value) {
        int[] newArr = new int[size + 1];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        newArr[size] = value;
        arr = newArr;
        size++;
    }

    // Delete element by index
    public void deleteByIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index");
            return;
        }

        int[] newArr = new int[size - 1];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (i != index) {
                newArr[j++] = arr[i];
            }
        }
        arr = newArr;
        size--;
    }

    public static void main(String[] args) {
        int[] data = { 50, 20, 40, 10, 30 };
        ArrayDemo obj = new ArrayDemo(data);

        obj.display();

        System.out.println("Length = " + obj.getLength());
        System.out.println("Search 40 at index = " + obj.search(40));

        obj.update(2, 99);
        obj.display();

        obj.reverse();
        obj.display();

        obj.sortArray();
        obj.display();

        System.out.println("Sum = " + obj.getSum());
        System.out.println("Max = " + obj.getMax());
        System.out.println("Min = " + obj.getMin());

        obj.insertAtEnd(60);
        obj.display();

        obj.deleteByIndex(1);
        obj.display();
    }
}