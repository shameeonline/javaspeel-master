package javaspell;

import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import pt.tumba.spell.DefaultWordFinder;
import pt.tumba.spell.Phonetic;
import pt.tumba.spell.SpellChecker;
import pt.tumba.spell.StringUtils;
import pt.tumba.spell.TeXWordFinder;
import pt.tumba.spell.TernarySearchTrie;

public class SpellCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SpellChecker spellCheck = new SpellChecker();
	       // spellCheck.initialize ("dict/english.txt.gz", "dict/common-misspells.txt.gz", "dict/jargon.txt.gz");
	     try {
/*			spellCheck.initialize ("C:/code/workspace-trunk-cstool/javaspell-master/src/english.txt.gz");
			String word = spellCheck.findMostSimilar ("hello");
	        assertEquals ("hello", word);
	        System.out.println(word);*/
	        
	  	    //searchWord("1murugan of shamee string 1mango","1m"); 
	    	 List<String> testList=new ArrayList<String>();
	    	 testList.add("1murugan   KKKKKK 123");
	    	 testList.add("of 1murugan");
	    	 testList.add("shamee becuase");
	    	 testList.add("string");
	    	 testList.add("1mango");
	    	 testList.add("");
	    	 
	   		//for(String s:testList)
	    	 //searchWord(s,"1m");
	    	 searchTernarySearchTrie(testList,"1m");
	   		 
	   		//searchWordUsingRegex(testList, "^1M");
	   		//searchNewWord("C:\\tavant\\jaspell\\test.txt","1m");
	   		// System.out.println("Search string");
	   		// searchWord("1murugan","1m");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void searchWord(String testText, String expected){ 	  
		    TeXWordFinder finder = new TeXWordFinder(testText);  
		    //System.out.println(finder.getText().startsWith(expected));
		   // while(finder.hasNext()){
			 //   String found = finder.next();   
			   // System.out.print(found);	
		   // System.out.println(StringUtils.getInstance().matchStrings(finder.getText(),expected));
		    
		    if(StringUtils.getInstance().matchStrings(finder.getText(),expected)==expected.length()){
		    	 System.out.println(finder.getText());
		    }
			    /*if(finder.getText().startsWith(expected)){		    	
			    	System.out.println(testText);	 
			    }*/
		    //}
		   // System.out.println();
	 } 
	private static void searchWord(List<String> testList, String expected){ 
	   	 for(String testText:testList){
	 	    TeXWordFinder finder = new TeXWordFinder(testText);  
	 	    if(finder.getText().startsWith(expected)){		    	
		    	System.out.println(testText);	 
		    }	
	 	    /*
	 	    if(finder.getText().matches(expected)){
	 	    	System.out.println(testText);
	 	    }
	 	    finder.startsSentence();
	 	   */
	   	}
	}
	private static void searchNewWord(String fname,String expected){ 
   			TernarySearchTrie tst;
			try {
				tst = new TernarySearchTrie(new File(fname));
				//tst = new TernarySearchTrie();
				//tst.createReader(new File(fname),true);
				System.out.println(tst.matchPrefix(expected));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	} 
	//startsSentence() 
	
	private static void searchWordUsingRegex(List<String> testList, String expected){
	    for(String testText: testList){
	    	TeXWordFinder finder = new TeXWordFinder(testText);
	    	if(finder.getText().matches(expected));
	    		System.out.println("Found : " + testText );
	    }

	}
	private static void searchTernarySearchTrie(List<String> testList,String expected){ 
			TernarySearchTrie tst;
		try {
			 File tmp = File.createTempFile("text", "tmp");
			 tst = new TernarySearchTrie(createTempFile(tmp,testList));
			 System.out.println("Hai " +tst.matchPrefix(expected));
		     tmp.deleteOnExit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	// This create the temp file and add to bag for checking
    public synchronized static  File createTempFile(File tmp,List<String> testList) throws IOException {       
        BufferedWriter out = new BufferedWriter(new FileWriter(tmp)); 
        for(String str:testList){
        	out.write(str+"\n");
        }
        out.close();
        return tmp;
    }
}
