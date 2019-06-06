package cs3220.tag;

import java.io.IOException;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class RomanNumeralTag extends SimpleTagSupport {

    int value;

    public RomanNumeralTag()
    {
  
    }

    public void setValue( int i )
    {
        value = i;
    }

    String Convert2roman(int number) {
    	String res = "We only take numbers that are inbetween 0 and 3999";
    	
    	if(number < 4000 && number > 0)
    	{
	    	String m[] = {"", "M", "MM", "MMM"}; 
	        String c[] = {"", "C", "CC", "CCC", "CD", "D",  
	                            "DC", "DCC", "DCCC", "CM"}; 
	        String x[] = {"", "X", "XX", "XXX", "XL", "L",  
	                            "LX", "LXX", "LXXX", "XC"}; 
	        String i[] = {"", "I", "II", "III", "IV", "V",  
	                            "VI", "VII", "VIII", "IX"}; 
	        // Credit to : geeksforgeeks.org for the conversion method 
	        // Converting to roman 
	        String thousands = m[number/1000]; 
	        String hundereds = c[(number%1000)/100]; 
	        String tens = x[(number%100)/10]; 
	        String ones = i[number%10]; 
	              
	        res = thousands + hundereds + tens + ones; 
    	}     
    	
    	
    	return res;
    }
    
    @Override
    public void doTag() throws JspException, IOException
    {
        JspWriter out = getJspContext().getOut();
        String res = Convert2roman(value);
        out.print(res);
    }

}

