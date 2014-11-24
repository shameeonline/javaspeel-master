package javaspell;

import pt.tumba.spell.TeXWordFinder;
import junit.framework.*;   
import junit.textui.*;   

   
public class TeXWordFinderTester extends TestCase {   
   
  public TeXWordFinderTester(String name){   
    super(name);   
  }   
     
  protected void setUp(){   
       
  }   
     
  protected void tearDown(){   
       
  }   
     
  public void testWordFindA(){   
	  searchWord("1murugan of shamee string 1mango","1m");   
  }  
     
  private void assertAllWordsFound(String text, String[] expected){   
    TeXWordFinder finder = new TeXWordFinder(text);   
    String found;   
    int wordCount = 0;   
    try{   
      for (int i = 0; i < expected.length; i++){   
        found = finder.next();   
        wordCount++;   
        assertEquals(expected[i],found);   
      }   
      found = finder.next();   
      fail("No more words should have been found\nString: '" + found + "'");   
    }catch(Exception e){   
    }finally{   
      assertEquals(expected.length, wordCount);   
    }   
   
  }   
     
  private void assertNotFound(String testText){   
    TeXWordFinder finder = new TeXWordFinder(testText);   
    try{   
      finder.next();   
      fail("\nNo words should have been found!\nWordNotFoundException should have been thrown.\nString: " + testText);   
    }catch (Exception e){   
    }   
   }   
     
  private void searchWord(String testText, String expected){ 	  
    TeXWordFinder finder = new TeXWordFinder(testText);  
    while(finder.hasNext()){
	    String found = finder.next();   
	    if(found.contains(expected)){
	    	System.out.println(found);	 
	    }
    }
   }   
     
  public static void main(String[] args){   
    TestRunner.run(new TestSuite(TeXWordFinderTester.class));   
  }   
     
}   