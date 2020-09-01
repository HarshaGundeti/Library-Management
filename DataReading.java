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
        File f,f2,f3,f4,f5,f6,f7,f8,f9;
        int counter;
        HashMap<String,ArrayList<String>> Atou=new HashMap<String,ArrayList<String>>();
        HashMap<String,String> Ntou=new HashMap<String,String>();
        HashMap<String,String> utoA=new HashMap<String,String>();
        HashMap<String,String> utoN=new HashMap<String,String>();
        HashMap<String,String> utobn=new HashMap<String,String>();
        HashMap<String,String> utog=new HashMap<String,String>();
        HashMap<String,String> utol=new HashMap<String,String>();
        HashMap<String,String> itop=new HashMap<String,String>();
        HashMap<String,String> itoo=new HashMap<String,String>();
        HashMap<String,ArrayList<String>> itob=new HashMap<String,ArrayList<String>>();
        HashMap<String,ArrayList<String>> btoi=new HashMap<String,ArrayList<String>>();
        DataReading(){
             bookname="";
             f= new File("/Users/rohithputha/Desktop/testrun2/booksname.txt");
             f2=new File("/Users/rohithputha/Desktop/testrun2/booksauthor.txt");
             f3=new File("/Users/rohithputha/Desktop/testrun2/booksnumber.txt");
             f4=new File("/Users/rohithputha/Desktop/testrun2/booksgenre.txt");
             f5=new File("/Users/rohithputha/Desktop/testrun2/bookslocation.txt");
             f6=new File("/Users/rohithputha/Desktop/testrun2/idPassword.txt");
             f7=new File("/Users/rohithputha/Desktop/testrun2/bookDate.txt");
             f8=new File("/Users/rohithputha/Desktop/testrun2/owe.txt");
             f9=new File("/Users/rohithputha/Desktop/testrun2/bookid.txt");
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
                   utoA.put(ucode,Aname);
                   Atou.putIfAbsent(Aname,new ArrayList<String>());
                   Atou.get(Aname).add(ucode);
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
        public void idPassword()
        {
           try{
               Scanner sc=new Scanner(f6);
               while(sc.hasNextLine()){
                   String s=sc.nextLine();
                   String id=s.substring(0,6);
                   String password=s.substring(6);
                   itop.put(id,password);
               }
           }
           catch(Exception e)
           {
               
           }
        }
         public void idOwe()
        {
           try{
               Scanner sc=new Scanner(f8);
               while(sc.hasNextLine()){
                   String s=sc.nextLine();
                   String id=s.substring(0,6);
                   String owe=s.substring(6);
                   itoo.put(id,owe);
               }
           }
           catch(Exception e)
           {
               
           }
        }
        public void booksAndDate()
        {
           try{
               Scanner sc=new Scanner(f7);
               while(sc.hasNextLine())
               {
                   String s=sc.nextLine();
                   String id=s.substring(0,6);

                   String datebook=s.substring(6);
                  
                   itob.putIfAbsent(id,new ArrayList<String>());
                   itob.get(id).add(datebook);
               }
               
               
               
           }
           catch(Exception e)
           {
               
           }
           
           
        }
        public void booksid()
        {
           try{
               Scanner sc=new Scanner(f9);
               while(sc.hasNextLine()){
                   String s=sc.nextLine();
                   String book=s.substring(0,6);
                   
                   String id=s.substring(6);
                   ArrayList<String> al=new ArrayList<String>();
                   btoi.putIfAbsent(book,new ArrayList<String>());
                   btoi.get(book).add(id);
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

