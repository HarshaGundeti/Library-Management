/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rohithputha
 */
import java.io.*;
import java.util.*;


//import com.google.common.collect.Table; 
public class DataReading {
        String bookname;
        File f,f2,f3,f4,f5;
        int counter;
        HashMap<String,ArrayList<String>> Atou=new HashMap<String,ArrayList<String>>();
        HashMap<String,String> Ntou=new HashMap<String,String>();
        HashMap<String,String> utoA=new HashMap<String,String>();
        HashMap<String,String> utoN=new HashMap<String,String>();
        HashMap<String,String> utobn=new HashMap<String,String>();
        HashMap<String,String> utog=new HashMap<String,String>();
        HashMap<String,String> utol=new HashMap<String,String>();
        DataReading(){
             bookname="";
             f= new File("C:\\Users\\chsra\\OneDrive\\Desktop\\LibraryManagement\\booksname.txt");
             f2=new File("C:\\Users\\chsra\\OneDrive\\Desktop\\LibraryManagement\\booksauthor.txt");
             f3=new File("C:\\Users\\chsra\\OneDrive\\Desktop\\LibraryManagement\\booksnumber.txt");
             f4=new File("C:\\Users\\chsra\\OneDrive\\Desktop\\LibraryManagement\\booksgenre.txt");
             f5=new File("C:\\Users\\chsra\\OneDrive\\Desktop\\LibraryManagement\\bookslocation.txt");
             counter=0;
        }
        public void bookReadAuthor()
        {
           try{
               Scanner sc=new Scanner(f2);
               while(sc.hasNextLine()){
                   String s=sc.nextLine();
                   String ucode=s.substring(0,6);
                   String Aname=s.substring(6);
                   ArrayList<String> temp=Atou.get(Aname);
                   temp.add(ucode);
                   Atou.put(Aname, temp);
                   utoA.put(ucode,Aname);
               }
           }
           catch(Exception e)
           {
               
           }
        }
        public void bookReadName()
        {
           try{
               Scanner sc=new Scanner(f);
               while(sc.hasNextLine()){
                   String s=sc.nextLine();
                   String ucode=s.substring(0,6);
                   String Bname=s.substring(6);
                   Ntou.put(Bname, ucode);
                   utoN.put(ucode,Bname);
                   
               }
           }
           catch(Exception e)
           {
               
           }
        }
        
         public void bookReadNumber()
        {
           try{
               Scanner sc=new Scanner(f3);
               while(sc.hasNextLine()){
                   String s=sc.nextLine();
                   String ucode=s.substring(0,6);
                   String Bnumber=s.substring(6);
                   //Ntou.put(Bname, ucode);
                   utobn.put(ucode,Bnumber);
               }
           }
           catch(Exception e)
           {
               
           }
        }
        
         public void bookReadGenre()
        {
           try{
               Scanner sc=new Scanner(f4);
               while(sc.hasNextLine()){
                   String s=sc.nextLine();
                   String ucode=s.substring(0,6);
                   String BGenre=s.substring(6);
                   utog.put(ucode,BGenre);
               }
           }
           catch(Exception e)
           {
               
           }
        }
         
          public void bookReadLocation()
        {
           try{
               Scanner sc=new Scanner(f5);
               while(sc.hasNextLine()){
                   String s=sc.nextLine();
                   String ucode=s.substring(0,6);
                   String BLocation=s.substring(6);
                   utol.put(ucode,BLocation);
               }
           }
           catch(Exception e)
           {
               
           }
        }
        
        public int returncounter()
        {
            System.out.println("Hi!!!");
            return utoN.size();
        }
        
}

