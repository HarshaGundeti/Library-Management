
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import static java.awt.PageAttributes.ColorType.COLOR;
import java.awt.event.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rohithputha
 */
public class DU extends JFrame {
    static JFrame frame;
    static JList list;
    static JScrollPane scroll;
    static JButton back;
    static JButton search;
    static JTextField searchbar1;
    static JPanel panel;
    static String[] categories={"GEEks","for","geeks"};
    
     public static void the()
     {
         
        frame=new JFrame("Delete User");
        back=new JButton("back");
        search=new JButton("search");    
        searchbar1=new JTextField(60);
        panel=new JPanel(true);
        
        
        frame.setSize(700,500);
        frame.setVisible(true);
        
        
        
        back.setBounds(620,450,70,30);
        frame.add(back);
        back.setVisible(true);
        
        search.setBounds(500,125,70,30);
        frame.add(search);
        search.setVisible(true);        
        
        
  
        searchbar1.setBounds(200,125,200,20);
        frame.add(searchbar1);
        searchbar1.setVisible(true);
        
        list=new JList(categories);
        scroll=new JScrollPane(list);
        panel.setBounds(10, frame.getHeight() - 60, frame.getWidth() - 20, 60);
        //scroll.setPreferredSize(new Dimension(100,100));
        panel.add(scroll);
        frame.add(panel);
        scroll.setVisible(true);
        panel.setVisible(true);
        
         search.addActionListener(new ActionListener(){  
         public void actionPerformed(ActionEvent e){  
            
         }  
        }); 
     }
};
