
import java.io.File;
import java.util.*;
import java.io.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rohithputha
 */
public class DataWriting {
       //FileWriter f,f2,f3,f4,f5;
       
       int ucode;
       String ucodestr;
       DataReading rObj=new DataReading(); 
       
       DataWriting (){
            try{
             /*f= new FileWriter("C:\\Users\\chsra\\OneDrive\\Desktop\\LibraryManagement\\booksname.txt");
             f2=new FileWriter("C:\\Users\\chsra\\OneDrive\\Desktop\\LibraryManagement\\booksauthor.txt");
             f3=new FileWriter("C:\\Users\\chsra\\OneDrive\\Desktop\\LibraryManagement\\booksnumber.txt");
             f4=new FileWriter("C:\\Users\\chsra\\OneDrive\\Desktop\\LibraryManagement\\booksgenre.txt");
             f5=new FileWriter("C:\\Users\\chsra\\OneDrive\\Desktop\\LibraryManagement\\bookslocation.txt");*/
            TestRun ntr=new TestRun();
            rObj=ntr.returnObj();
            /*    rObj.bookReadAuthor();
            //dr.bookReadAuthor();
             rObj.bookReadGenre();
             rObj.bookReadLocation();
             rObj.bookReadName();
             rObj.bookReadNumber();*/
             ucode=rObj.Ntou.size()+1;
             rObj.counter=ucode;
             
             ucodestr=ucodeString();
            }
            catch(Exception e){
                //Display error
            }
       }
       
       public String ucodeString(){
           String s=Integer.toString(ucode);
           while(s.length()!=6){
               s='0'+s;
           }
           return s;
       }
       
       public void control(String Name,String Author,String Number,String genre,String location){
          /* for (Map.Entry<String,String> entry : rObj.utoN.entrySet())  
            System.out.println("Key = " + entry.getKey() + 
                             ", Value = " + entry.getValue()); */
           System.out.println(rObj.Ntou.size());
           if(rObj.Ntou.containsKey(Name)){
               
               String tUCode=rObj.Ntou.get(Name);
                String tbn=rObj.utobn.get(tUCode);
               String tt=tbn;
               int tk=Integer.parseInt(tbn);
               tk+=Integer.parseInt(Number);
               tbn=Integer.toString(tk);
               WriteBn(tUCode,tbn);
               rObj.utobn.put(tUCode,tbn);
               
           }
           else
           {
               WriteAuthor(Author);
               WriteName(Name);
               WriteNumber(Number);
               WriteGenre(genre);
               WriteLocation(location);
               rObj.Ntou.put(Name,ucodestr);
               rObj.utoA.put(ucodestr,Author);
               rObj.utoN.put(ucodestr,Name);
               rObj.utobn.put(ucodestr, Number);
               rObj.utog.put(ucodestr,genre);
               rObj.utol.put(ucodestr,location);
              // ArrayList<String> temp=rObj.Atou.get(Author);
               
               try
               {
                 rObj.Atou.get(Author).add(ucodestr);
               }
               catch(Exception e)
               {
                   System.out.println("Exception Found");
               }
                 rObj.Atou.put(Author, rObj.Atou.get(Author));
           }
       }
       public void WriteBn(String code,String bn)
       {
           try
           {
                File F;
                F=new File("C:\\Users\\chsra\\OneDrive\\Desktop\\LibraryManagement\\booksnumber.txt");
                Scanner sc=new Scanner(F);
                String s="";
                while(sc.hasNextLine())
                {
                    String temp=sc.nextLine();
                    if(temp.substring(0,6).equals(code))
                    {
                       temp=temp.substring(0,6)+bn; 
                    }    
                    s=s+ temp;
                    s=s+"\n";
                }
               
     
              BufferedWriter writer = new BufferedWriter(
                                new FileWriter("C:\\Users\\chsra\\OneDrive\\Desktop\\LibraryManagement\\booksnumber.txt", false)  //Set true for append mode
                            );  
              //writer.newLine();   //Add new line
              writer.write(s);
              writer.close();
           }
           catch(Exception e)
           {
               //
           }
               
       }    
       
       public void WriteAuthor(String Aname)
       {
          try
          {
              String textToAppend =ucodestr+Aname;
     
              BufferedWriter writer = new BufferedWriter(
                                new FileWriter("C:\\Users\\chsra\\OneDrive\\Desktop\\LibraryManagement\\booksauthor.txt", true)  //Set true for append mode
                            );  
              if(rObj.Ntou.size()>0)
                  writer.newLine();   //Add new line
              writer.write(textToAppend);
              writer.close();
          }
          catch(Exception e)
          {// Display error
          }
       }
       
        public void WriteName(String Bname)
        {
          try
          {
              String textToAppend =ucodestr+Bname;
     
              BufferedWriter writer = new BufferedWriter(
                                new FileWriter("C:\\Users\\chsra\\OneDrive\\Desktop\\LibraryManagement\\booksname.txt", true)  //Set true for append mode
                            );  
             if(rObj.Ntou.size()>0)
                writer.newLine();   //Add new line
              writer.write(textToAppend);
              writer.close();
          }
          catch(Exception e){// Display error
          }
        }
        
         public void WriteNumber(String Number)
         {
             try
             {
                 String textToAppend =ucodestr+Number;
     
              BufferedWriter writer = new BufferedWriter(
                                new FileWriter("C:\\Users\\chsra\\OneDrive\\Desktop\\LibraryManagement\\booksnumber.txt", true)  //Set true for append mode
                            );  
              if(rObj.Ntou.size()>0)
                   writer.newLine();   //Add new line
              writer.write(textToAppend);
              writer.close();
             }
             catch(Exception e)
             {// Display error
             }
         }
         public void WriteGenre(String genre)
         {
             try
             {
                 String textToAppend =ucodestr+genre;
     
              BufferedWriter writer = new BufferedWriter(
                                new FileWriter("C:\\Users\\chsra\\OneDrive\\Desktop\\LibraryManagement\\booksgenre.txt", true)  //Set true for append mode
                            );  
              if(rObj.Ntou.size()>0)
                writer.newLine();   //Add new line
              writer.write(textToAppend);
              writer.close();
             }
             catch(Exception e)
             {// Display error
             }
         }
         public void WriteLocation(String location)
         {
             try
             {
                 String textToAppend =ucodestr+location;
     
              BufferedWriter writer = new BufferedWriter(
                                new FileWriter("C:\\Users\\chsra\\OneDrive\\Desktop\\LibraryManagement\\bookslocation.txt", true)  //Set true for append mode
                            );  
             if(rObj.Ntou.size()>0)
                writer.newLine();   //Add new line
              writer.write(textToAppend);
              writer.close();
             }
             catch(Exception e)
             {// Display error
             }
         }
       
  }

