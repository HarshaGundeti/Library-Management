/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Map.*;
import java.util.*;
/**
 *
 * @author chsra
 */

public class TestRun {
     static DataReading dr;
     static DataWriting dw=new DataWriting();
     static DataWritingUser dwu=new DataWritingUser();
    /**
     * @param args the command line arguments
     */
     
    TestRun(){
             dr=new DataReading();
             
             
             dr.bookReadAuthor();
             dr.bookReadGenre();
             dr.bookReadLocation();
             dr.bookReadName();
             dr.bookReadNumber();
             dr.booksAndDate();
             dr.booksid();
             dr.idOwe();
             dr.idPassword();
    }
    public static void main(String[] args) {
        
        
             
        //TestRun tr=new TestRun();
        //dw.AddUser("180283");
        //deleteUser("180010");
        //deleteOwe("180010");
        //returnBook("180025","000001");
        //returnBookId("000001","180025");
        //dw.control("pokiri","puri","5","movie","L6A1");
        //dw.control("brahmotsavam","srikanth","2","movie","L6A1");
             
       //deletebook("000009");
        //dwu.writeidbooks("000002","180025",true);
        // TODO code application logic here
//         Iterator it = dr.itob.entrySet().iterator();
//         while(it.hasNext()) {
//            Map.Entry obj = (Entry)it.next();
//            System.out.println(obj.getValue());
//         }
       // System.out.println(userdata("180636"));
}
    
     public DataReading returnObj()
    {
        return dr;
    }
    public DataWriting returnObjw()
    {
        return dw;
    }
    public DataWritingUser returnObju(){
        return dwu;
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
     public static int bookminus(String ucode)
     {
         int k=dr.btoi.get(ucode).size();
         String s=dr.utobn.get(ucode);
         int l=Integer.parseInt(s)-k;
         return l;
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
                                      new FileWriter("/Users/rohithputha/Desktop/testrun2/idPassword.txt",k)  //Set true for append mode
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
                                      new FileWriter("/Users/rohithputha/Desktop/testrun2/owe.txt",k)  //Set true for append mode
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
     public static void returnBook(String id,String book,Userobjclass userobj)
     {
           
         ArrayList<String> al=userobj.dr.itob.get(id);
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
             userobj.dr.itob.put(id, al);
         }
         else
         {
            userobj.dr.itob.remove(id);
         }
           boolean k=false;
           for( Map.Entry<String,ArrayList<String>>i:userobj.dr.itob.entrySet())
           {
               ArrayList<String> temp=i.getValue();
               for(int j=0;j<temp.size();j++)
               {
                   returnBookMain(temp.get(j),i.getKey(),k,userobj);
                   k=true;
               }
           }
     
     }
     public static void returnBookMain(String book,String id,boolean k,Userobjclass userobj)
     {
          //dr.itob.putIfAbsent(id,new ArrayList<String>());
           // dr.itob.get(id).add(bd);
         try
         {    
            BufferedWriter writer = new BufferedWriter(
                                    new FileWriter("/Users/rohithputha/Desktop/testrun2/bookDate.txt", k)  //Set true for append mode
                                );  
                  if(userobj.dr.itob.size()>0&&k==true)
                      writer.newLine();   //Add new line
                  writer.write(id+book);
                  writer.close();
         }
         catch(Exception e)
         {
             System.out.println("Exception found in returnBookMain()");
         }
     }
     public static void returnBookId(String book,String id,Userobjclass userobj)
     {
        ArrayList<String> ab=userobj.dr.btoi.get(book);
         Iterator it =userobj.dr.btoi.entrySet().iterator();
         while(it.hasNext()) {
            Map.Entry obj = (Entry)it.next();
            System.out.println(obj.getKey());}
        if(ab.size()>1)
         {
             
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
          userobj.dr.btoi.put(book, ab);
         }
         else
         {
            userobj.dr.btoi.remove(book);
         }
        boolean k=false;
           for( Map.Entry<String,ArrayList<String>>i:userobj.dr.btoi.entrySet())
           {
               ArrayList<String> temp=i.getValue();
               for(int j=0;j<temp.size();j++)
               {
                   returnBookIdMain(temp.get(j),i.getKey(),k,userobj);
                   k=true;
               }
             }
     }
     public static void returnBookIdMain(String id,String book,boolean k,Userobjclass userobj)
     {
         try
         {    
            BufferedWriter writer = new BufferedWriter(
                                    new FileWriter("/Users/rohithputha/Desktop/testrun2/bookid.txt", k)  //Set true for append mode
                                );  
                  if(userobj.dr.btoi.size()>0&&k==true)
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
                                      new FileWriter("/Users/rohithputha/Desktop/testrun2/booksnumber.txt",k)  //Set true for append mode
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
     
     public boolean ispresentUser(String id){
         if(dr.itop.containsKey(id))return true;
         return false;
     }
     
     
     public static void changeowe(String owing,String id){
         dr.itoo.put(id,owing);
         boolean k=false;
         for( Map.Entry<String,String>i:dr.itoo.entrySet())
         {
             try
                {
                    String textToAppend =i.getKey()+i.getValue();
                    
                     BufferedWriter writer = new BufferedWriter(
                                      new FileWriter("/Users/rohithputha/Desktop/testrun2/owe.txt",k)  //Set true for append mode
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
                    System.out.println("Exception found in changeowe()");
                }
         }
     }
     
     
     
      public void writeidbooks(String book,String id,boolean k,Userobjclass userobj)
    {
        try
        {
            
            String bd;
            LocalDate myObj = LocalDate.now();
            bd=book+myObj.toString();
            userobj.dr.itob.putIfAbsent(id,new ArrayList<String>());
            userobj.dr.itob.get(id).add(bd);
            BufferedWriter writer = new BufferedWriter(
                                    new FileWriter("/Users/rohithputha/Desktop/testrun2/bookDate.txt", k)  //Set true for append mode
                                );  
                  if(userobj.dr.itob.size()>0)
                      writer.newLine();   //Add new line
                  writer.write(id+bd);
                  writer.close();
                  // ****bookstoID*****
            userobj.dr.btoi.putIfAbsent(book,new ArrayList<String>());
            userobj.dr.btoi.get(book).add(id);
                BufferedWriter writer1 = new BufferedWriter(
                                    new FileWriter("/Users/rohithputha/Desktop/testrun2/bookid.txt", k)  //Set true for append mode
                                );  
                  if(userobj.dr.btoi.size()>0)
                  writer1.newLine();   //Add new line
                  
                  writer1.write(book+id);
                  writer1.close();
        }
        catch(Exception e)
        {
        }
    }

}

