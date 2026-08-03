package com.devanshu.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.devanshu.model.StudentInfo;

public class LaunchStandardApp {

	public static void main(String[] args) {
		Configuration config = null;
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		FileInputStream fis = null;
        byte image[] = null;
        char textFile[] = null;
        FileReader reader = null;
		config=new Configuration();
		config.configure();
		sessionFactory=config.buildSessionFactory();
		session=sessionFactory.openSession();
		try {
			 fis = new FileInputStream("D:\\Programs\\FullStack\\beckEnd\\Hibernet\\HibernateLOBs\\Image");
			image =  new byte[fis.available()];
			fis.read(image);
			File file = new File("D:\\Programs\\FullStack\\beckEnd\\Hibernet\\HibernateLOBs\\Image\\Infoabout.txt");
			 reader = new FileReader(file);
			 textFile =new char[(int)file.length()];
			 reader.read(textFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		StudentInfo  student = new StudentInfo();
		student.setsName("Devnashu");
		student.setsCity("Mumbai");
		student.setImage(image);
		student.setTextFile(textFile);
		
		
		try
		
		
	}

}
