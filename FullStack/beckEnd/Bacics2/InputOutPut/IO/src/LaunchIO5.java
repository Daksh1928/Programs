import  java.io.*;


public class LaunchIO5 {
     public static void main() throws IOException {
         String filepath = "D:\\Programs\\FullStack\\beckEnd\\Bacics2\\InputOutputData\\java.txt";
         FileReader reader = null;
         BufferedReader bufferedReader = null;

         try{
             File file1 = new File(filepath);
             reader = new FileReader(file1);
             bufferedReader = new BufferedReader(reader);
             bufferedReader.read();
            String str =  bufferedReader.readLine();

            while (str!=null)
            {
                IO.println(str);
                str =  bufferedReader.readLine();
            }

         }catch(Exception e)
         {
             IO.println("ERROR! here ");
         }
         finally {
             bufferedReader.close();
             System.out.println("Finally block called program terminated ");
         }
     }
}
