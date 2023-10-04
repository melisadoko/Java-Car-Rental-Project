import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.time.Year;
import java.util.*;
/** In this class, some GUI components are placed.Here, the user can continue with the process of renting the car. 
 * It is composed of 8 JTextField components, some of which are filled automatically by the car we have chosen to rent. The date when 
 * receiving and returning the car is completed by the user and based on it we calculate how many days the car will be rented. 
 *  To select additional modifications, 3 JCheckboxes have been created. 3 buttons have been created: one that returns you to the previous page, 
 *  the other that calculates the total and the last one that prints the invoice. Checked additional items are added to the total.
 */
public class RentPanel implements ActionListener,Printable{
	
	//Declare global variables and create the Container

	private Container c=new Container();
	private JFrame frame=new JFrame();
	private JLabel title,lab;
	private JTextField price,date1,month1,date2,month2,car,days,total;
	private JLabel car1,car2;
	private JButton btn1,btn2,tot;
	private JCheckBox sht1,sht2,sht3;
    private String name,surname,age,tel;
	private Car chosenCar;
	
	/*Below we have the constructor, which gives the title, dimensions and visibility to the frame and fills the panel (for this, another method has been created to better manage the code)
      Also, in the constructor, variables are filled which will later appear  on the page that will be printed!*/
	public RentPanel(String name,String surname,String age,String tel,Car m) {
		this.name=name;
		this.surname=surname;
		this.age=age;
		this.tel=tel;
		this.chosenCar=m;
		frame.setTitle("Rent a car");
		frame.setBackground(Color.gray);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    frame.setSize(1000, 700);
	    frame.setLayout(null);
	    frame.getContentPane().add(c);
	    c.setSize(1000,650);
	    c.setLocation(0,0);
	    fillPanel();
	    JPanel p=new JPanel();
	    c.add(p);
	    p.setBackground(Color.white);
	    p.setSize(1000,700);
	    frame.setVisible(true);
	}
	 /*In the following lines(55-204) we have created one of the components and appear the images*/
	private void fillPanel() {
		//Return button...we have add ActionListeners
		btn1=new JButton("Return");
		btn1.setBounds(30,20,120,25);		
		btn1.setContentAreaFilled(false);
		btn1.setFocusPainted(false);
		btn1.setBorderPainted(true);
		btn1.setIcon(new ImageIcon(("img3.png")));
		btn1.addActionListener(this);
		btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));		
		c.add(btn1);

		
		title=new JLabel("Information!");
		title.setBounds(100, 10,300, 150);
		title.setFont(new Font("Serif", Font.ITALIC, 36));
		title.setForeground(Color.RED);
		c.add(title);
		
		lab=new JLabel("Car:");
		lab.setBounds(50,145,70, 15);
		lab.setFont(new Font("Arial", Font.PLAIN, 14));
		lab.setForeground(Color.black);
		c.add(lab);
		
      //The textfield is filled with the name of the car we have chosen to rent
		
		car=new JTextField();
		car.setText(chosenCar.getType());
		car.setBounds(120,140,180,23);
		car.setEditable(false);
		c.add(car);

		lab=new JLabel("Price:");
		lab.setBounds(50,185,70, 15);
		lab.setFont(new Font("Arial", Font.PLAIN, 14));
		lab.setForeground(Color.black);
		c.add(lab);
	      //The textfield is filled with the price of the car we have chosen to rent

		price=new JTextField();
		price.setText(chosenCar.getPrice()+"");
		price.setBounds(120,180,180,23);
		price.setEditable(false);
		c.add(price);
		//Textfields have been created respective labels of the date of receiving and return of the car
		lab=new JLabel("Date of receiving:");
		lab.setBounds(50,225,120, 15);
		lab.setFont(new Font("Arial", Font.PLAIN, 14));
		lab.setForeground(Color.black);
		c.add(lab);

		date1=new JTextField();
		date1.setBounds(170,220,30,23);
		c.add(date1);
		
		lab=new JLabel("Month:");
		lab.setBounds(220,225,70, 15);
		lab.setFont(new Font("Arial", Font.PLAIN, 14));
		lab.setForeground(Color.black);
		c.add(lab);

		month1=new JTextField();
		month1.setBounds(270,220,30,23);
		c.add(month1);
		
		lab=new JLabel("Date of returning:");
		lab.setBounds(50,265,120, 15);
		lab.setFont(new Font("Arial", Font.PLAIN, 14));
		lab.setForeground(Color.black);
		c.add(lab);

		date2=new JTextField();
		date2.setBounds(170,260,30,23);
		c.add(date2);
		
		lab=new JLabel("Month:");
		lab.setBounds(220,265,70, 15);
		lab.setFont(new Font("Arial", Font.PLAIN, 14));
		lab.setForeground(Color.black);
		c.add(lab);

		month2=new JTextField();
		month2.setBounds(270,260,30,23);
		c.add(month2);
		
		lab=new JLabel("Total Days:");
		lab.setBounds(50,305,120, 15);
		lab.setFont(new Font("Arial", Font.PLAIN, 14));
		lab.setForeground(Color.black);
		c.add(lab);

		days=new JTextField();
		days.setBounds(170,300,130,23);
		days.setEditable(false);//set the TextField to Readonly
		c.add(days);
	
		title=new JLabel("Additional Items!");
		title.setBounds(600, 10,300, 150);
		title.setFont(new Font("Serif", Font.ITALIC, 36));
		title.setForeground(Color.RED);
		c.add(title);
        //Additional elements are defined as checkboxes
		sht1=new JCheckBox("Snow tires (6000)");
		sht1.setBounds(600,145,200,20);
		sht1.setContentAreaFilled(false);
		sht1.setFocusPainted(false);
		sht1.setBorderPainted(false);
		sht1.addActionListener(this);
		
		sht2=new JCheckBox("Snow chains (1500)");
		sht2.setBounds(600,185,200,20);
		sht2.setContentAreaFilled(false);
		sht2.setFocusPainted(false);
		sht2.setBorderPainted(false);
		sht2.addActionListener(this);
		
		sht3=new JCheckBox("Parking tickets (3000)");
		sht3.setBounds(600,225,200,20);
		sht3.setContentAreaFilled(false);
		sht3.setFocusPainted(false);
		sht3.setBorderPainted(false);
		sht3.addActionListener(this);
		c.add(sht1);c.add(sht2);c.add(sht3);
		//Total: A button with actionListener on click of which we calculate the number of days and the total to be paid
		tot=new JButton("Totali");
		tot.setBounds(600,285,70,25);
		tot.addActionListener(this);
		tot.setFocusable(false);
		tot.setCursor(new Cursor(Cursor.HAND_CURSOR));
		c.add(tot);
		
		total=new JTextField();
		total.setBounds(700,285,100,25);
		total.setEditable(false);
		c.add(total);
		//2 images have been created for decoration reasons
		ImageIcon img1=new ImageIcon("img12.jpg");
		car1 = new JLabel(img1); // transform it 
		car1.setBounds(50,400, 250, 140);
		c.add(car1);
		
		ImageIcon img2=new ImageIcon("img13.png");
		car2 = new JLabel(img2); // transform it 
		car2.setBounds(650,400, 250, 140);
		c.add(car2);
		//After filling in the fields, clicking the button below prints the invoice
		btn2=new JButton("Print");
		btn2.setBounds(400,480,120,25);		
		btn2.setFocusPainted(false);
		btn2.setBorderPainted(true);
		btn2.setIcon(new ImageIcon(("img11.png")));
		btn2.addActionListener(this);
		btn2.setCursor(new Cursor(Cursor.HAND_CURSOR));		
		c.add(btn2);
		
	}
	
	//Add ActionListener to buttons 
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Validation validate=new Validation();//We create an object of type Validation that controls the data (below the control)
		String day1=date1.getText();//filled values ​​are taken
		String day2=date2.getText();
		String firstMont=month1.getText();
		String secondMonth=month2.getText();
		//If the first button is clicked, it goes to the previous page
		if(e.getSource()==btn1)
		{
			  CarPanel f1=new CarPanel();
	          frame.setVisible(false);
		}
		/*If we click the 'tot' button, we make it possible to calculate the total amount to be paid that if the dates of receiving and returning have been completed.*/
		if(e.getSource()==tot) {
			//if everything is completed according to the specified format, the total and number of days are calculated
			if(validate.controlMonth(day1) && validate.controlMonth(day2) && validate.controlMonth(firstMont) && validate.controlMonth(secondMonth)) {
				Calculation a=new Calculation();//An object of type Calculation is created that is used later to calculate the days and the total
				days.setText(a.calculateDays(Integer.parseInt(day1),Integer.parseInt(day2),Integer.parseInt(firstMont),Integer.parseInt(secondMonth))+"");
	            int totalAmount=a.calculatePrice(chosenCar.getPrice(),Integer.parseInt(days.getText()));
	            if(sht1.isSelected()) //If the elements are checked, they are added to the total
	            	totalAmount+=6000;
	            if(sht2.isSelected())
	            	totalAmount+=1500;
	            if(sht3.isSelected())
	            	totalAmount+=3000;
	            total.setText(totalAmount+"");//gives value to the total
			}
			else {
				JOptionPane.showMessageDialog(null, "Careful! The day/month when you want to receive and deliver the car must be specified!");
			}
			
		}
		/*If the btn2 button is clicked, a PrinterJob type object is created which will enable us to print the invoice and generate it in pdf format*/
		
		if(e.getSource()==btn2) {
			String totalAmount1=total.getText();
			String NoDays=days.getText();
			//If all the fields are filled in, the invoice is printed!
			if(validate.controlDates(day1) && validate.controlDates(day2) && validate.controlMonth(firstMont) && validate.controlMonth(secondMonth) && validate.controlNumber(totalAmount1) && validate.controlNumber(NoDays)) 
			{
				PrinterJob job = PrinterJob.getPrinterJob();
		         job.setPrintable(this);
		         boolean ok = job.printDialog();
		         if (ok) {	            
		        	 try {
		                  job.print();
		             } 
		             catch (PrinterException ex) {
		              System.out.println(ex.getMessage());
		             }
		         }
			}
			else {
				JOptionPane.showMessageDialog(null, "Careful! All fields must be completed!");
			}
			
		}
	}

	//In the following lines, we have created the invoice in which we display all the necessary information
	
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		// TODO Auto-generated method stub
		if (pageIndex == 0) { 
			
		GregorianCalendar c=new GregorianCalendar();
		Year thisyear=Year.now();
		Graphics2D g2d = (Graphics2D)graphics;
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
		
		graphics.drawString("**********************************************", 220, 40);
		graphics.drawString("Your Car",270, 70);
		graphics.drawString("**********************************************", 220, 100);
		graphics.drawString("Client: "+name+" "+surname,270,130);
		graphics.drawString("Phone Number: "+tel,270,220);
		graphics.drawString("Age: "+age,270,160);
		graphics.drawString("Car: "+chosenCar.getType(),270,250);
		graphics.drawString("Date of Receiving: "+Integer.parseInt(date1.getText())+"/"+Integer.parseInt(month1.getText())+"/"+thisyear,270,280);
		graphics.drawString("Date of returning: "+Integer.parseInt(date2.getText())+"/"+Integer.parseInt(month2.getText())+"/"+thisyear,270,310);
		graphics.drawString("********************************************",220,340);
		graphics.drawString("Total: "+total.getText()+" All",270,370);
		graphics.drawString("********************************************",220,400);

		return PAGE_EXISTS;
	}
		else {
			return NO_SUCH_PAGE;
		}
	}

}
