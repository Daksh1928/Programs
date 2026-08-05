import java.io.*;

public class LaunchIO {


    void main(String... args) {
        String filePath = "D:\\Programs\\FullStack\\beckEnd\\Bacics2\\InputOutputData\\java.txt";
        String foldPath = "D:\\Programs\\FullStack\\beckEnd\\Bacics2\\InputOutputData\\javafolder";
        File file = new File(filePath);
        File fold = new File(foldPath);
        boolean flag = false;

//        IO.println("# Path of the file : " + file.getPath());
//        IO.println("# Path of the folder : " + fold.getPath());
//        IO.println("# Perant of folder JavaFolder : " + fold.getParent() + " \n Parent of File java.txt : " + file.getParent());
//        IO.println("# Is folder : " + file.isDirectory());
//        IO.println("# Is file : " + file.isFile());
//        if (file.getParent().equals(fold.getParent())) {
//            IO.println("This folder and file are siblings ");
//        }
        String filePath2 = "D:\\Programs\\FullStack\\beckEnd\\Bacics2\\InputOutputData";
        File file2 = new File(filePath2);
        String str[] = file2.list();
        int count = 0;
        for(String name:str){
            count++;
            IO.println(name);
        }
IO.println("Number of file inside the Inputoutput folder : "+count);
        try {
            if (!fold.exists()) {
                flag = fold.mkdir();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (flag)
                IO.println("File is created ");
            else
                IO.println("Enable to create");
        }
    }
}
