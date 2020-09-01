/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rohithputha
 */

import java.util.ArrayList;
import javax.swing.*;  
public class dialogbox {  
JFrame f;


dialogbox(String message){  
    f=new JFrame();  
    JOptionPane.showMessageDialog(f,message);  
}  

dialogbox(String ucode,String idno,Userobjclass userobj,int flag){
    
    String Name=userobj.dr.utoN.get(ucode);
    String Author=userobj.dr.utoA.get(ucode);
    String[] options = {"Yes", "No"}; 
    int result=JOptionPane.showOptionDialog(
               f,
                "Name : "+Name+"\n"+"Author : "+Author, 
               "Borrow Book",            
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE,
               null,     //no custom icon
               options,  //button titles
               options[1] //default button
            );
            if(result == JOptionPane.YES_OPTION&&flag==1){
               returnresult(1,ucode,idno,userobj);
            }else if (result == JOptionPane.YES_OPTION&&flag==0){
               returnbookfunc(ucode,idno,userobj);
            }else {
               
            }
         

}

public boolean checkifcanbetaken(String ucode,String idno,Userobjclass userobj){
    ArrayList<String> arlist=new ArrayList<String>();
   
    if(userobj.dr.itob.containsKey(idno)) {arlist=userobj.dr.itob.get(idno);}
    for (int i=0;i<arlist.size();i++){
        System.out.println(arlist.get(i)+"---"+ucode);
        if(arlist.get(i).substring(0,6).equals(ucode))return false;
        
    }
   
    return true;
        
    }
public void returnresult(int res, String ucode, String idno, Userobjclass userobj)
{ 
       
         int k;
         if(userobj.dr.btoi.containsKey(ucode))
              k =userobj.dr.btoi.get(ucode).size();
         else k=0;
         String s=userobj.dr.utobn.get(ucode);
         int l=Integer.parseInt(s)-k;
        
       if(!checkifcanbetaken(ucode,idno,userobj)) new dialogbox("book already taken by you");
       else if(l!=0)
       {
       userobj.tr.writeidbooks(ucode,idno,true,userobj);
       new dialogbox("book issued");
       }
       else new dialogbox("This book is not available");
   
}

public void returnbookfunc(String ucode,String idno,Userobjclass userobj){
    
    userobj.tr.returnBook(idno,ucode,userobj);
    userobj.tr.returnBookId(ucode,idno,userobj);
    
    new dialogbox("Book returned");
    
}

}  
