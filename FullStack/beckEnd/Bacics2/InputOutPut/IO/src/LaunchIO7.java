import java.io.*;

static class Student  implements Serializable
{
    private int id;
    private String name;
    transient private int age;

    public Student(int id,String name,int age)
    {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public void  disp()
    {
        IO.println("Id : "+ id);
        IO.println("Name : "+name);
        IO.println("Age : "+ age);
    }

}


 void main(){
     String filepath = "D:\\Programs\\FullStack\\beckEnd\\Bacics2\\InputOutputData\\java.txt";
//    Student stu = new Student(1, "Alex Rana", 19);
//    stu.disp();
     try {
//         FileOutputStream fileOutputStream = new FileOutputStream(filepath);
//         BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
//         ObjectOutputStream objectOutputStream =  new ObjectOutputStream(bufferedOutputStream);
//         objectOutputStream.writeObject(stu);
//         IO.println("Operation completed ");
//         objectOutputStream.close();
//         fileOutputStream.close();
          FileInputStream fileInputStream = new FileInputStream(filepath);
          BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
          ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
             Student st1 = (Student) objectInputStream.readObject();
         st1.disp();

     } catch (FileNotFoundException e) {
         throw new RuntimeException(e);
     }
     catch (IOException e){
         e.printStackTrace();
     }
     catch (ClassNotFoundException e) {
         throw new RuntimeException(e);
     }
 }


