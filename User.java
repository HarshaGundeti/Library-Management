
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rohithputha
 */
public class User {
    
    private String idno;
    private TestRun tr;
    private DataWriting dw;
    private DataReading dr;
    User(String id){
        idno=id;
        tr=new TestRun();
        dw=tr.returnObjw();
        dr=tr.returnObj();
    }
    
    
   
    public void addsingleUser(){
           
          dw.AddUser(idno);
            
     }
    
    public void deletesingleUser(){
        try{
              
        if(!dr.itob.containsKey(idno))
        {
            
           
               tr.deleteUser(idno);
               tr.deleteOwe(idno);
            
                    
        }
        else{
            new dialogbox(idno+ " could not be deleted because student owes some books");
           }
        
        
         }
           catch(Exception e)
           {
              new dialogbox("error"); 
           }
    }
    
}
