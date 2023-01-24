import java.util.regex.*;

/** Ne kete klase kemi krijuar funksione qe bejne te mundur qe te validojme dhe kontrollojme te dhenat hyrese.Keto funksione do te 
 * perdoren me tej ne program. Kemi kontroll per stringje qe te jene sipas formatit te caktuar,per te dhena te tipit numer si dhe per 
 * nr e telefonit,datat dhe muajt e vitit!*/
public class Validime {
	
	public boolean kontrolloString(String st){
		  return Pattern.matches("[a-zA-Z]+", st);    
		}
		 
		public boolean kontrolloNumer(String numri){
		  return Pattern.matches("[0-9]+", numri);
		}
		public boolean kontrolloNumerTeli(String cel){
			  return (Pattern.matches("^06[7-9][0-9]+" ,cel) && cel.length() == 10);
			}
		public boolean kontrolloDatat(String date){
			  return Pattern.matches("^([1-9]|[1-2][0-9]|3[0-1])$",date) ;
			}
		public boolean kontrolloMuajin(String month){
			  return Pattern.matches("(^0?[1-9]$)|(^1[0-2]$)",month) ;
			}

}
