/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Map.*;
import java.util.*;
/**
 *
 * @author chsra
 */

public class TestRun {
     static DataReading dr=new DataReading();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
             dr.bookReadAuthor();
             dr.bookReadGenre();
             dr.bookReadLocation();
             dr.bookReadName();
             dr.bookReadNumber();
             
        DataWriting dw=new DataWriting();
        dw.control("Ramayana","Valmiki","4","Mythology","L2A1");
        
        // TODO code application logic here
         Iterator it = dr.Ntou.entrySet().iterator();
         while(it.hasNext()) {
            Map.Entry obj = (Entry)it.next();
            System.out.println(obj.getValue());
         }
}
    
     public DataReading returnObj()
    {
        return dr;
    }
}

