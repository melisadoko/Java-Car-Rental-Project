import java.util.regex.*;

/** 
  This class is used to validate and check the input data. It contains functions that will be used further in the program.
 *These functions control whether strings, numbers, phone numbers, dates and months are in the specified format!
 **/
public class Validation {
	
	public boolean controlString(String st){
		  return Pattern.matches("[a-zA-Z]+", st);    
		}
		 
		public boolean controlNumber(String numri){
		  return Pattern.matches("[0-9]+", numri);
		}
		public boolean controlTelephoneNumber(String cel){
			  return (Pattern.matches("^06[7-9][0-9]+" ,cel) && cel.length() == 10);
			}
		public boolean controlDates(String date){
			  return Pattern.matches("^([1-9]|[1-2][0-9]|3[0-1])$",date) ;
			}
		public boolean controlMonth(String month){
			  return Pattern.matches("(^0?[1-9]$)|(^1[0-2]$)",month) ;
			}

}
