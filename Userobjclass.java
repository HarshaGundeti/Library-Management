/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author rohithputha
 */
public class Userobjclass {
    String idno;
    TestRun tr=new TestRun();
    DataReading dr=tr.returnObj();
    DataWriting dw=tr.returnObjw();
    DataWritingUser dwu=tr.returnObju();
    Userobjclass(String id)
    {
        idno=id;
        
    }
    
    public ArrayList<String> returnbooklist(){
      System.out.println(dr.itob.get(idno));
      if(dr.itob.containsKey(idno)) return dr.itob.get(idno);
      else return new ArrayList<String>();
      
    }
    
    
    public String returnpassword()
    {
        return dr.itop.get(idno);
    }
    public String returnowe()
    {
        return dr.itoo.get(idno);
    }
    public String returnidno()
    {
        return idno;
    }
    public String calculateowe()
    {
        ArrayList<String> booklist=returnbooklist();
        int total=0;
        System.out.println(booklist.size());
        
        for (int i=0;i<booklist.size();i++)
        {
            String s=booklist.get(i);
            s=s.substring(6);
            LocalDate myObj = LocalDate.now();
            String bd=myObj.toString();
            
            
            LocalDate d1 = LocalDate.parse(s, DateTimeFormatter.ISO_LOCAL_DATE);
            LocalDate d2 = LocalDate.parse(bd, DateTimeFormatter.ISO_LOCAL_DATE);
            Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
            long diffDays = diff.toDays();
            if(diffDays>14)
            {
              total=+1;  
            }
        }
        
       int owing=Integer.parseInt(returnowe());
       owing+=total;
       String owe=Integer.toString(owing);
       tr.changeowe(owe,idno);
       return owe;
    }
 }
