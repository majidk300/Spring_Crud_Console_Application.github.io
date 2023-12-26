package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Stuudent;

import net.bytebuddy.asm.Advice.Exit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        
        StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
//        
//        Stuudent student = new Stuudent(101,"Majid Naseem","Simri Bakhtiyarpur");
//        
//        int r = studentDao.insert(student);
//        
//        System.out.println("done "+ r);
        
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          
          boolean go = true;
          while(go){
        	  System.out.println("Press 1 for add new student");
              System.out.println("Press 2 for display all students");
              System.out.println("Press 3 for get for single details student");
              System.out.println("Press 4 for delete student");
              System.out.println("Press 5 for Update Student");
              System.out.println("Press 6 for Exit");
              System.out.println();
              try {
            	  
            	  int input = Integer.parseInt(br.readLine());
            	  
            	  switch(input) {
            	  
            	  
            	  case 1:
//            		  add a new student
            		  
            		  System.out.println("Enter user Id: ");
            		  int uId = Integer.parseInt(br.readLine());
            		  
            		  System.out.println("Enter user name : ");
            		  String uName = br.readLine();
            		  
            		  System.out.println("Enter user city : ");
            		  String uCity = br.readLine();
            		  
            		  Stuudent student = new Stuudent();
            		  
            		  student.setStudentId(uId);
            		  student.setStudentName(uName);
            		  student.setStudentCity(uCity);
            		  
            		  int r = studentDao.insert(student);
            		  
            		  System.out.println(r + " Successfully student Added");
            		  System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
            		  System.out.println();
            		  
            		  break;
            		  
            	  case 2:
//            		  display all student
            		  List<Stuudent> allStudent = studentDao.getAllStudents();
            		  
            		  for(Stuudent s:allStudent) {
            			  
            			  System.out.println("Student Id : "+ s.getStudentId());
            			  System.out.println("Student Name : "+ s.getStudentName());
            			  System.out.println("Student City : "+ s.getStudentCity());
            			   System.out.println("-----------------------------------------------");
            		  }
            		  System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
            		  System.out.println();

            		  break;
            		  
            	  case 3:
//            		  get single data
            		  System.out.println("Enter student id");
            		  
            		  int us = Integer.parseInt(br.readLine());
            		  
            		  Stuudent st = studentDao.getStudent(us);
            		  
            		  System.out.println(st + "Single student ");
            		  
            		  System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
            		  System.out.println();
            		  break;
            		  
            	  case 4:
//            		  delete a student
            		  System.out.println("Enter student id for delete");
            		  
            		  int dId = Integer.parseInt(br.readLine());
            		  
            		  studentDao.deleteStudent(dId);
            		  
            		  System.out.println("Deleted");
            		  
            		  System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
            		  System.out.println();
            		  break;
            		  
            	  case 5:
//            		  Update Student
            		  System.out.println("Enter id : ");
            		  int id = Integer.parseInt(br.readLine());
            		  
            		  System.out.println("Enter new Name : ");
            		  String newName = br.readLine();
            				  
            		  System.out.println("Enter new City : ");
            		  String newCity = br.readLine();
            		  
            		  Stuudent uStudent = new Stuudent();
            		  uStudent.setStudentId(id);
            		  uStudent.setStudentName(newName);
            		  uStudent.setStudentCity(newCity);
            		  
            		  studentDao.studentUpdate(uStudent);
            		  
            		  System.out.println("Updated "+ studentDao.getStudent(id));
            		  
            		  System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
            		  System.out.println();
            		  break;
            		  
            	  case 6:
//            		  Exit
            		  go = false;
            		  System.out.println("Exit...........................................");
            		  break;
            	  
            	      default:
            	    	  System.out.println("Invalid Input");
            	  }
            	  
              }catch (Exception e) {
            	  System.out.println("Invalid Input Try with Another one!!");
            	  System.out.println(e.getMessage());
              }
              
              System.out.println();
              
              
          }
          
          System.out.println("Thank you for using my  application");
          System.out.println("See you soon!!");
    }
    
}
