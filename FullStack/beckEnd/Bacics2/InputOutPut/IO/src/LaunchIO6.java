import java.io.*;

public class LaunchIO6 {
    public static void main() throws IOException {
        String filepath = "D:\\Programs\\FullStack\\beckEnd\\Bacics2\\InputOutputData\\java.txt";
        FileWriter writer = null;
        PrintWriter printWriter = null;

        try{
            File file1 = new File(filepath);
            writer = new FileWriter(file1 , true);
            printWriter = new PrintWriter(writer);

            printWriter.println(122);
            printWriter.println(65);
            printWriter.println("Hello this message is getting into file using printWriter class of java ");

        }catch(Exception e)
        {
            IO.println("ERROR! here ");
        }
        finally {
             printWriter.close();
            System.out.println("Finally block called program terminated ");
        }
    }

}
