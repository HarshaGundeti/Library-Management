/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testrun;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Map.*;
import java.util.*;
/**
 *
 * @author chsra
 */

public class TestRun {
     static DataReading dr=new DataReading();
     static DataWriting dw=new DataWriting();
     static DataWritingUser dwu=new DataWritingUser();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
             dr.bookReadAuthor();
             dr.bookReadGenre();
             dr.bookReadLocation();
             dr.bookReadName();
             dr.bookReadNumber();
             dr.booksAndDate();
             dr.booksid();
             dr.idOwe();
             dr.idPassword();
        //TestRun tr=new TestRun();
        //dw.AddUser("180283");
        //deleteUser("180010");
        //deleteOwe("180010");
        //returnBook("180283","000283");
       // returnBookId("000018","180118");
        //dw.control("pokiri","puri","5","movie","L6A1");
        //dw.control("brahmotsavam","srikanth","2","movie","L6A1");
             
       deletebook("000009");
        //dwu.writeidbooks("0000283","180283",true);
        // TODO code application logic here
         /*Iterator it = dr.itob.entrySet().iterator();
         while(it.hasNext()) {
            Map.Entry obj = (Entry)it.next();
            System.out.println(obj.getValue());
         }*/
       // System.out.println(userdata("180636"));
}
    
     public DataReading returnObj()
    {
        return dr;
    }
     public static ArrayList<String> userdata(String id)
     {
       return dr.itob.get(id);
     }
     public static String UToBName(String ucode)
     {
         return dr.utoN.get(ucode);
     }
     public static String UToAName(String ucode)
     {
         return dr.utoA.get(ucode);
     }
     public static String UToGenre(String ucode)
     {
         return dr.utog.get(ucode);
     }
     public static String UToLocation(String ucode)
     {
         return dr.utol.get(ucode);
     }
     public static String UToBN(String ucode)
     {
         return dr.utobn.get(ucode);
     }
     public static String BToucode(String Bname)
     {
         return dr.Ntou.get(Bname);
     }
     public static ArrayList<String> AToBName(String Aname)
     {
         return dr.Atou.get(Aname);
     }
     public static String bookminus(String ucode)
     {
         int k=dr.btoi.get(ucode).size();
         String s=dr.utobn.get(ucode);
         int l=Integer.parseInt(s)-k;
         return Integer.toString(l);
     }  
     public static void deleteUser(String id)
     {
          // System.out.println("Hello");  
            dr.itop.remove(id);
            
            
            //System.out.println("Hello2");  
         /*   Iterator it = dr.itop.entrySet().iterator();
         while(it.hasNext()) {
            Map.Entry obj = (Entry)it.next();
            System.out.println(obj.getKey());
         }*/
         //System.out.println("Hello3");  
            int cnt=0;
            boolean k=false;
            for( Map.Entry<String,String>i:dr.itop.entrySet())
            {
                try
                {
                    String textToAppend =i.getKey()+i.getValue();
                   /* if(cnt==0)
                        k=false;
                    else
                        k=true;*/
                     BufferedWriter writer = new BufferedWriter(
                                      new FileWriter("C:\\Users\\chsra\\OneDrive\\Desktop\\LibraryManagement\\idPassword.txt",k)  //Set true for append mode
                                  );  
                    if(dr.itop.size()>0&&k==true)
                        writer.newLine();   //Add new line
                    writer.write(textToAppend);
                    //dr.itop.put(id,"0000");
                    writer.close();
                   
                    k=true;
                }
                catch(Exception e)
                {// Display error
                }
           }
            k=false;
           /*
               
           }*/
            
         
     }
     public static void deleteOwe(String id)
     {
      boolean k=false;
      dr.itoo.remove(id);
         for( Map.Entry<String,String>i:dr.itoo.entrySet())
            {
                try
                {
                    String textToAppend =i.getKey()+i.getValue();
                    
                     BufferedWriter writer = new BufferedWriter(
                                      new FileWriter("C:\\Users\\chsra\\OneDrive\\Desktop\\LibraryManagement\\owe.txt",k)  //Set true for append mode
                                  );  
                    if(dr.itoo.size()>0&&k==true)
                        writer.newLine();   //Add new line
                    writer.write(textToAppend);
                    //dr.itop.put(id,"0000");
                    writer.close();
                   
                    k=true;
                }
                catch(Exception e)
                {
                    System.out.println("Exception found in deleteOwe()");
                }
            }
                
     }
     public static void returnBook(String id,String book)
     {
           //dr.itob.remove(id);
         ArrayList<String> al=dr.itob.get(id);
         if(al.size()>1)
         {
             for(int i=0;i<al.size();i++)
             { 
                 String s=al.get(i).substring(0,6);
                 if(s.equals(book))
                 {
                   al.remove(i);
                   break;
                 }
             }
             dr.itob.put(id, al);
         }
         else
         {
             dr.itob.remove(id);
         }
           boolean k=false;
           for( Map.Entry<String,ArrayList<String>>i:dr.itob.entrySet())
           {
               ArrayList<String> temp=i.getValue();
               for(int j=0;j<temp.size();j++)
               {
                   returnBookMain(temp.get(j),i.getKey(),k);
                   k=true;
               }
             }
     
     }
     public static void returnBookMain(String book,String id,boolean k)
     {
          //dr.itob.putIfAbsent(id,new ArrayList<String>());
           // dr.itob.get(id).add(bd);
         try
         {    
            BufferedWriter writer = new BufferedWriter(
                                    new FileWriter("C:\\Users\\chsra\\OneDrive\\Desktop\\LibraryManagement\\bookDate.txt", k)  //Set true for append mode
                                );  
                  if(dr.itob.size()>0&&k==true)
                      writer.newLine();   //Add new line
                  writer.write(id+book);
                  writer.close();
         }
         catch(Exception e)
         {
             System.out.println("Exception found in returnBookMain()");
         }
     }
     public static void returnBookId(String book,String id)
     {
        ArrayList<String> ab=dr.btoi.get(book);
         Iterator it = dr.btoi.entrySet().iterator();
         while(it.hasNext()) {
            Map.Entry obj = (Entry)it.next();
            System.out.println(obj.getKey());}
        if(ab.size()>1)
         {
             System.out.println("Hi hello1");
            //al.remove(id);
             for(int i=0;i<ab.size();i++)
             { 
                 String s=ab.get(i);
                 if(s.equals(id))
                 {
                   ab.remove(i);
                   break;
                 }
             }
            dr.btoi.put(book, ab);
         }
         else
         {
             System.out.println("Hi hello2");
             dr.btoi.remove(book);
         }
        boolean k=false;
           for( Map.Entry<String,ArrayList<String>>i:dr.btoi.entrySet())
           {
               ArrayList<String> temp=i.getValue();
               for(int j=0;j<temp.size();j++)
               {
                   returnBookIdMain(temp.get(j),i.getKey(),k);
                   k=true;
               }
             }
     }
     public static void returnBookIdMain(String id,String book,boolean k)
     {
         try
         {    
            BufferedWriter writer = new BufferedWriter(
                                    new FileWriter("C:\\Users\\chsra\\OneDrive\\Desktop\\LibraryManagement\\bookid.txt", k)  //Set true for append mode
                                );  
                  if(dr.btoi.size()>0&&k==true)
                      writer.newLine();   //Add new line
                  writer.write(book+id);
                  writer.close();
         }
         catch(Exception e)
         {
             System.out.println("Exception found in returnBookIdMain()");
         }
     }
     public static void deletebook(String book)
     {
         dr.utobn.put(book,"0");
         boolean k=false;
         for( Map.Entry<String,String>i:dr.utobn.entrySet())
         {
             try
                {
                    String textToAppend =i.getKey()+i.getValue();
                    
                     BufferedWriter writer = new BufferedWriter(
                                      new FileWriter("C:\\Users\\chsra\\OneDrive\\Desktop\\LibraryManagement\\booksnumber.txt",k)  //Set true for append mode
                                  );  
                    if(dr.utobn.size()>0&&k==true)
                        writer.newLine();   //Add new line
                    writer.write(textToAppend);
                    //dr.itop.put(id,"0000");
                    writer.close();
                   
                    k=true;
                }
                catch(Exception e)
                {
                    System.out.println("Exception found in deletebook()");
                }
         }
     }
}

