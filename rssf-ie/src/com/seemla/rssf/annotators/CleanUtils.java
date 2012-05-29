package com.seemla.rssf.annotators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CleanUtils {
	
	// A pattern to remove expurious characters from team names 
	// A team name may contain unicode character, digits and some other punctuation marks
	// A team name starts with a unicode characters
	private static final String cleanteam = "\\p{L}[\\p{L}\\d\\s;&-]+";
 	
	private static Pattern cleanTeamPattern  = Pattern.compile(cleanteam);
 	
	public static String cleanTeamname(String s) {
		Matcher m = cleanTeamPattern.matcher(s);
		
		if (m.find()) {
			return m.group();
		} 
		
		return s;
	}

}
