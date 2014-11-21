package javaspell;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import pt.tumba.spell.DefaultWordFinder;
import pt.tumba.spell.SpellChecker;
import pt.tumba.spell.TeXWordFinder;

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
	    	 testList.add("1murugan");
	    	 testList.add("of");
	    	 testList.add("shamee");
	    	 testList.add("string");
	    	 testList.add("1mango");

	    	 searchWord(testList,"1m");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void searchWord(String testText, String expected){ 	  
		    TeXWordFinder finder = new TeXWordFinder(testText);  
		    while(finder.hasNext()){
			    String found = finder.next();   
			    if(found.contains(expected)){
			    	System.out.println(found);	 
			    }
		    }
	 } 
	private static void searchWord(List<String> testList, String expected){ 
		String testWord=testList.toString().replaceAll("\\[|\\]", "").replaceAll(", ","\t");
	    TeXWordFinder finder = new TeXWordFinder(testWord);  
	    while(finder.hasNext()){
		    String found = finder.next();   
		    if(found.contains(expected)){
		    	System.out.println(found);	 
		    }
	    }
	} 

}
