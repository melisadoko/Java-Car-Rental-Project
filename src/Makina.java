/** Kemi ndertuar nje klase Makina e cila do te perdoret per te krijuar objekte te tipit Makina ne aplikim
 * Variablat perberes te kesaj klase jane tipi dhe cmimiDite
 * Kemi ndetuar konstruktorin dhe kemi krijuar getters per secilin prej variablave
 * Kemi krijuar dhe 2 metoda qe afishojne te dhenat per 2 var e fushes
 */
public class Makina {
	private String tipi;
	private int cmimiDite;
	
	public Makina(String tipi,int cmimi) {
		this.tipi=tipi;
		this.cmimiDite=cmimi;
	}
	
	public String getTipi() {
		return tipi;
	}
	public int getCmimi() {
		return cmimiDite;
	}

}
