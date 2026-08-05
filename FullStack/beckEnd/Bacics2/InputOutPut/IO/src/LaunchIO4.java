import java.io.*;


    void main() throws IOException {
        String filepath = "D:\\Programs\\FullStack\\beckEnd\\Bacics2\\InputOutputData\\serial.txt";
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;

        try{
            File file1 = new File(filepath);
            writer = new FileWriter(file1 , true);
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.newLine();
            bufferedWriter.write("Hii I an Paul walker also known as Brin 'O corner of fast and furious series ");
        }catch(Exception e)
        {
            IO.println("ERROR! here ");
        }
        finally {
            assert bufferedWriter != null;
            bufferedWriter.flush();
            bufferedWriter.close();
            System.out.println("Finally block called program terminated ");
        }
    }

