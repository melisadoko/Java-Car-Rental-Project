/** Kemi ndertuar nje klase Llogaritje e cila do te perdoret per te krijuar objekte te tipit llogaritur totalin dhe nr e diteve ne aplikim
 * Per kete kemi krjuar 2 funksione: i pari llogarit nr e diteve, i dyti shumen totale
 */
public class Llogaritje {   
	
    public int llogaritDitet(int dita1,int dita2,int muaji1,int muaji2) {
    	int ditet=0;
    	if(muaji1 != muaji2) {
    	int ditetfill=0;
    	if(muaji1==1 || muaji1==3 || muaji1==5 || muaji1==7 || muaji1==8 || muaji1==10 || muaji1==12)
    		ditetfill=(31-dita1);
    	else if(muaji1==2)
    		ditetfill=(28-dita1);
    	else 
    		ditetfill=(30-dita1);
    	for(int i=muaji1+1;i<muaji2;i++) {
    		if(i==2)
    			ditet+=28;
    		else if(i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12)
    			ditet+=31;
    		else
    			ditet+=30;
    	}
    	ditet=ditet+ditetfill+dita2;
    } 
    	else
    		ditet=dita2-dita1;
    	return ditet;
    }
    
    public int llogaritCmimin(int price,int ditet) {
    	int cmimi;
    	cmimi=ditet*price;
    	return cmimi;
    }
}
