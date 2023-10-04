/** The class Calculation will be used to calculate total and number of days in the application
 * For this we have created 2 functions: the first calculates the number of days, the second the total amount
 */
public class Calculation {   
	
    public int calculateDays(int day1,int day2,int month1,int month2) {
    	int days=0;
    	if(month1 != month2) {
    	int startDays=0;
    	if(month1==1 || month1==3 || month1==5 || month1==7 || month1==8 || month1==10 || month1==12)
    		startDays=(31-day1);
    	else if(month1==2)
    		startDays=(28-day1);
    	else 
    		startDays=(30-day1);
    	for(int i=month1+1;i<month2;i++) {
    		if(i==2)
    			days+=28;
    		else if(i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12)
    			days+=31;
    		else
    			days+=30;
    	}
    	days=days+startDays+day2;
    } 
    	else
    		days=day2-day1;
    	return days;
    }
    
    public int calculatePrice(int price,int days) {
    	int totalPrice;
    	totalPrice=days*price;
    	return totalPrice;
    }
}
