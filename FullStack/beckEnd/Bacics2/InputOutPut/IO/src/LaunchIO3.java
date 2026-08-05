import java.io.*;

public class LaunchIO3 {

    public static  void main(String...args) throws IOException {
        String filepath = "D:\\Programs\\FullStack\\beckEnd\\Bacics2\\InputOutputData\\java.txt";
        FileReader reader = null;


        try{
            File file1 = new File(filepath);
            reader = new FileReader(file1);

            int a = reader.read();
            while (a!= -1) {
                IO.print((char) a);
                a = reader.read();
            }

        }catch(Exception e)
        {
            IO.println("ERROR! OCCURE here ");
        }
        finally {

        }
    }
}
