package javaspell;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String line="COW say MOO MOO";
	    //String pattern = "(.*)(\\d+)(.*)";
		String pattern = "COW";
	    
		Pattern p=Pattern.compile(pattern);
	    Matcher matcher=p.matcher(line);
	    
	    replaceAll(matcher,"CAT");
	    
	    line="COWsayMOOMOOCOUCHW";
	    //String pattern = "(.*)(\\d+)(.*)";
		pattern = "C*W";
		
		p=Pattern.compile(pattern);
		matcher=p.matcher(line);
		
		replaceAll(matcher,"-");
	    
		 
	   // System.out.println(matcher.groupCount());
	    if(matcher.find()){
	    	System.out.println(matcher.group(0));
	    	System.out.println(matcher.lookingAt());
	    	//System.out.println(matcher.group(2));
	    }	    
	}
	public static  void replaceAll(Matcher matcher,String replace){
		//System.out.println("" +matcher.group(0));
		System.out.println(matcher.replaceAll(replace));
	}

}
