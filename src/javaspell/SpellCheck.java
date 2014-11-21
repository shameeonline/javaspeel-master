package javaspell;

import static org.junit.Assert.assertEquals;
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
	        
	  	    searchWord("1murugan of shamee string 1mango","1m");   

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

}
