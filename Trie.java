


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Map.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rohithputha
 */
public class Trie { 
	
	
	static final int ALPHABET_SIZE = 27; 
	static TestRun tr=new TestRun();
        static DataReading dr=tr.returnObj();
	
	static class TrieNode 
	{ 
		TrieNode[] children = new TrieNode[ALPHABET_SIZE]; 
	
		
		boolean isEndOfWord; 
		
		TrieNode(){ 
			isEndOfWord = false; 
			for (int i = 0; i < ALPHABET_SIZE; i++) 
				children[i] = null; 
		} 
	}; 
	
        
        Trie(){
            root=new TrieNode();
        }        
	static TrieNode root; 
	static ArrayList<String> results=new ArrayList<String>();
	
	static void insert(String key) 
	{ 
		int level; 
		int length = key.length(); 
		int index; 
	
		TrieNode pCrawl = root; 
	
		for (level = 0; level < length; level++) 
		{ 
			index = key.charAt(level) - 'a';
                         if(key.charAt(level)==32)index=26;
			if (pCrawl.children[index] == null) 
				pCrawl.children[index] = new TrieNode(); 
	
			pCrawl = pCrawl.children[index]; 
		} 
	
		// mark last node as leaf 
		pCrawl.isEndOfWord = true; 
	} 
        
        
	
	// Returns true if key presents in trie, else false 
	static boolean search(String key) 
	{ 
		int level; 
		int length = key.length(); 
		int index; 
		TrieNode pCrawl = root; 
	        
		for (level = 0; level < length; level++) 
		{ 
			index = key.charAt(level) - 'a'; 
	                if(key.charAt(level)==32)index=26;
			if (pCrawl.children[index] == null) 
				return false; 
	
			pCrawl = pCrawl.children[index]; 
		} 
	
		return (pCrawl != null && pCrawl.isEndOfWord); 
	} 
	
	
        static TrieNode presearch(String key){
             int level=0;
             int length=key.length();
             int index;
             TrieNode pcrawl=root;
             for (level=0;level<length;level++){
                 index=key.charAt(level)-'a';
                 if(key.charAt(level)==32)index=26;
                 
                 if(pcrawl.children[index]==null)return null;
                 
                 pcrawl=pcrawl.children[index];
                 
             }
             return pcrawl;
        }
        
        
        static void recsearch(TrieNode pcrawl,String word){
              for(int i=0;i<27;i++){
                  
                   if(pcrawl.children[i]!=null){
                       
                       if(i==26)word=word+ (char)(32);
                       else word=word+(char)(i+'a');
                       
                       recsearch(pcrawl.children[i],word);
                       
                       word=word.substring(0,word.length()-1);
                       
                   }
              }
              
              if(pcrawl.isEndOfWord==true){
                  String ucode=dr.Ntou.get(word);
                  String number=dr.utobn.get(ucode);
                  
                  if(!number.equals("0"))
                  { results.add(word);
                  System.out.println(word);
                  }
              }
              return;
        }
           
        static void recsearchA(TrieNode pcrawl,String word){
              for(int i=0;i<27;i++){
                  
                   if(pcrawl.children[i]!=null){
                       
                       if(i==26)word=word+ (char)(32);
                       else word=word+(char)(i+'a');
                       
                       recsearchA(pcrawl.children[i],word);
                       
                       word=word.substring(0,word.length()-1);
                       
                   }
              }
              
              if(pcrawl.isEndOfWord==true){
                    results.add(word);
                 }
              return;
        }
            
        public void insertall()
        { 
            
            for (Map.Entry<String,String> i : dr.Ntou.entrySet()) 
            {
                insert(i.getKey().toLowerCase());
            } 
            
        }
        public void insertallA(){
             for (Map.Entry<String,ArrayList<String>> i : dr.Atou.entrySet()) 
            {
                insert(i.getKey().toLowerCase());
            } 
        }
        public ArrayList<String> control(String key){
            insertall();
            results.clear();
            TrieNode node =presearch(key.toLowerCase());
            if(node!=null)recsearch(node,key.toLowerCase());
            System.out.println(results);
            return results;
           
        }
        
        public ArrayList<String> controlA(String key){
            
            results.clear();
            insertallA();
            TrieNode node=presearch(key.toLowerCase());
            if(node!=null)recsearchA(node,key.toLowerCase());
            return results;
            
        }
                
//	public static void main(String args[]) 
//	{ 
//		// Input keys (use only 'a' through 'z' and lower case) 
//		String keys[] = {"harry potter","harry","dbz"}; 
//	
//		String output[] = {"Not present in trie", "Present in trie"}; 
//	
//	
//		root = new TrieNode(); 
//	
//		// Construct trie 
//		int i; 
//		for (i = 0; i < keys.length ; i++) 
//			insert(keys[i]); 
//	
//		
//                results="";
//                TrieNode current=presearch("harry");
//                if(current!=null)recsearch(current,"harry");
//                System.out.println(results);
//                //System.out.println("----@@----");
//		
//	} 
} 
