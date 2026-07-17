import java.util.ArrayList;

public class LaunchGen2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(1+2);
        list.add(2+2);
        list.add(3+2);
        list.add(4+2);
        System.out.println(list.get(0));
        int a = list.get(3);
        System.out.println(a);
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("Devanshu");  
        list2.add("Daksh");
        list2.add("Evanshu");
        list2.add("Devanshu");
        System.out.println(list2.get(0));
        for(int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));
        }
        
    }

}
