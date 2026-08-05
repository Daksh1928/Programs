import  java.io.*;

public class LaunchIO2 {

    public static  void main(String...args) throws IOException {
        String filepath = "D:\\Programs\\FullStack\\beckEnd\\Bacics2\\InputOutputData\\java.txt";
        FileWriter writer =null;
        boolean flag = false;
        try{
            File file1 = new File(filepath);
             writer = new FileWriter(file1);

             writer.write("Hello my name is Brin'O corner. I am a professional street car racer. DO race for fun only ");
             writer.write("\t");
             writer.write(65);
             writer.write(122);
             flag = true;
        }catch(Exception e)
        {
            IO.println("ERROR! OCCURE here ");
        }
        finally {
            if (flag) {
                IO.println("Execution Succesfully Completed ");
            }
            writer.close();
        }
    }
}
