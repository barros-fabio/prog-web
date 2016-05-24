/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comparadata;

/**
 *
 * @author fabio
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ComparaData
{
     public static void main( String[] args ) 
    {
    	try{
    		
    		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        	Date date1 = sdf.parse("31/05/2016");
        	Date date2 = sdf.parse("01/06/2016");

        	System.out.println(sdf.format(date1));
        	System.out.println(sdf.format(date2));
        	
        	if(date1.compareTo(date2)>0){
        		System.out.println("Date1 is after Date2");
        	}else if(date1.compareTo(date2)<0){
        		System.out.println("Date1 is before Date2");
        	}else if(date1.compareTo(date2)==0){
        		System.out.println("Date1 is equal to Date2");
        	}else{
        		System.out.println("How to get here?");
        	}
        	
    	}catch(ParseException ex){
    		ex.printStackTrace();
    	}
    }
}
