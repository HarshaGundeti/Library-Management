/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;
import java.io.*;
import java.time.LocalDate;
/**
 *
 * @author chsra
 */
public class DataWritingUser {
    DataReading rObj;
    DataWritingUser()
    {
        TestRun ntr=new TestRun();
        rObj=ntr.returnObj();
    }    
    public void writeidbooks(String book,String id,boolean k)
    {
        try
        {
            
            String bd;
            LocalDate myObj = LocalDate.now();
            bd=book+myObj.toString();
            rObj.itob.putIfAbsent(id,new ArrayList<String>());
            rObj.itob.get(id).add(bd);
            BufferedWriter writer = new BufferedWriter(
                                    new FileWriter("/Users/rohithputha/Desktop/testrun2/bookDate.txt", k)  //Set true for append mode
                                );  
                  if(rObj.itob.size()>0)
                      writer.newLine();   //Add new line
                  writer.write(id+bd);
                  writer.close();
                  // ****bookstoID*****
            rObj.btoi.putIfAbsent(book,new ArrayList<String>());
            rObj.btoi.get(book).add(id);
                BufferedWriter writer1 = new BufferedWriter(
                                    new FileWriter("/Users/rohithputha/Desktop/testrun2/bookid.txt", k)  //Set true for append mode
                                );  
                  if(rObj.btoi.size()>0)
                      writer1.newLine();   //Add new line
                  writer1.write(book+id);
                  writer1.close();
        }
        catch(Exception e)
        {
        }
    }

    
}
