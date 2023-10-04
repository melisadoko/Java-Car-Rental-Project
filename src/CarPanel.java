import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**In this class, several GUI components are placed. Here the user fills in his data and selects the car he will rent.
 * It is composed of 4 JTextField components respectively to complete the first name, last name, age and mobile phone number.
 * A JComboBox has been created to select the car. The state machines are pre-defined by us (the creators of the application).
 * It is possible to return to the first page (btn1) or to go to the next page, after completing the data (btn2). We have also
 * shown 5 photos of cars (one for each car) and a large photo for decoration reasons.
 */
public class CarPanel implements ActionListener{
	
	//Declare global variables and create the Container
	
	private Container c=new Container();
	private JFrame frame=new JFrame();
	private JLabel title,lab;
	private JTextField firstName,surn,agee,telephone;
	private JLabel image,car1,car2,car3,car4,car5;
	private JComboBox cars;
	private JButton btn1,btn2;
	//5 objects of type Car have been created that show the cars we have in stock and the corresponding price
	Car m1=new Car("MERCEDES-BENZ S-CLASS",25000);
	Car m2=new Car("PORSCHE CAYENNE",30000);
	Car m3=new Car("RANGE ROVER",20000);
	Car m4=new Car("VOLKSWAGEN TOURAN",6000);
	Car m5=new Car("BMW SERIA 5",18000);

	/*Below we have the constructor, which gives the title, dimensions and visibility to the frame and fills the panel (for this, another method has been created to better manage the code)
    Also, in the constructor, variables are filled which will later appear  on the page that will be printed!*/

	public CarPanel() {
		frame.setTitle("Cars");
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
  /*In the following lines (51-160) we have created one of the components and appear the images*/
	
	private void fillPanel() {

		
       //Return button...we have added Action Listener
		
		btn1=new JButton("Return");
		btn1.setBounds(30,20,120,25);		
		btn1.setContentAreaFilled(false);
		btn1.setFocusPainted(false);
		btn1.setBorderPainted(true);
		btn1.setIcon(new ImageIcon(("img3.png")));
		btn1.addActionListener(this);
		btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));		
		c.add(btn1);
		
		ImageIcon img=new ImageIcon("img5.jpeg");
		image = new JLabel(img); // transform it 
		image.setBounds(600,50, 350, 550);
		c.add(image);
		
		title=new JLabel("Rent a car!");
		title.setBounds(100, 10,300, 150);
		title.setFont(new Font("Serif", Font.ITALIC, 36));
		title.setForeground(Color.RED);
		c.add(title);
		
		//Below, Textboxes are placed,each of which has a specific label
		
		lab=new JLabel("Name:");
		lab.setBounds(50,145,70, 15);
		lab.setFont(new Font("Arial", Font.PLAIN, 14));
		lab.setForeground(Color.black);
		c.add(lab);

		firstName=new JTextField();
		firstName.setBounds(120,140,180,23);
		c.add(firstName);
		
		lab=new JLabel("Surname:");
		lab.setBounds(50,185,70, 15);
		lab.setFont(new Font("Arial", Font.PLAIN, 14));
		lab.setForeground(Color.black);
		c.add(lab);

		surn=new JTextField();
		surn.setBounds(120,180,180,23);
		c.add(surn);
		
		lab=new JLabel("Age:");
		lab.setBounds(50,225,70, 15);
		lab.setFont(new Font("Arial", Font.PLAIN, 14));
		lab.setForeground(Color.black);
		c.add(lab);

		agee=new JTextField();
		agee.setBounds(120,220,180,23);
		c.add(agee);
		
		lab=new JLabel("Phone No:");
		lab.setBounds(50,265,70, 15);
		lab.setFont(new Font("Arial", Font.PLAIN, 14));
		lab.setForeground(Color.black);
		c.add(lab);

		telephone=new JTextField();
		telephone.setBounds(120,260,180,23);
		c.add(telephone);
		
		lab=new JLabel("Car:");
		lab.setBounds(50,305,70, 15);
		lab.setFont(new Font("Arial", Font.PLAIN, 14));
		lab.setForeground(Color.black);
		c.add(lab);
		
		//	Creating a ComboBox to show the cars created above
		
		cars=new JComboBox();
		cars.addItem(m1.getType());
		cars.addItem(m2.getType());
		cars.addItem(m3.getType());
		cars.addItem(m4.getType());
		cars.addItem(m5.getType());
		cars.setBounds(120,300,180,23);
        c.add(cars);
        //Images placement
        ImageIcon img1=new ImageIcon("img6.jpg");
		car1 = new JLabel(img1); // transform it 
		car1.setBounds(0,350, 200, 60);
		c.add(car1);
		
		ImageIcon img2=new ImageIcon("img7.jpg");
		car2 = new JLabel(img2); // transform it 
		car2.setBounds(175,350, 200, 60);
		c.add(car2);
		
		ImageIcon img3=new ImageIcon("img8.jpg");
		car3 = new JLabel(img3); // transform it 
		car3.setBounds(350,350, 200, 60);
		c.add(car3);
		
		ImageIcon img4=new ImageIcon("img9.jpg");
		car4 = new JLabel(img4); // transform it 
		car4.setBounds(0,460, 200, 60);
		c.add(car4);
		
		ImageIcon img5=new ImageIcon("img10.jpg");
		car5 = new JLabel(img5); // transform it 
		car5.setBounds(175,460, 200, 60);
		c.add(car5);
		//The second button makes it possible to go to the next page (in which the days when the car will be rented are selected and the invoice is printed)
		btn2=new JButton("Continue");
		btn2.setBounds(400,480,120,25);		
		btn2.setContentAreaFilled(false);
		btn2.setFocusPainted(false);
		btn2.setBorderPainted(true);
		btn2.setIcon(new ImageIcon(("img4.png")));
		btn2.addActionListener(this);
		btn2.setCursor(new Cursor(Cursor.HAND_CURSOR));		
		c.add(btn2);
		
	}
	//	In the following lines we have added ActionListener to the buttons
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//If the first button is clicked, it goes to the first page
		if(e.getSource()==btn1)
		{
	          FirstPage f1=new FirstPage();	          
	          frame.setVisible(false);
		}
		//If the second button is clicked (the event is triggered by it) and all the validations are completed (after checking the input data), it goes to the next page
		if(e.getSource()==btn2) {
			
			Car  m=m1;//In the lines below, we check the which car to display on the next page (we have selected it)
			if(cars.getSelectedItem()==m2.getType())
				m=m2;
			if(cars.getSelectedItem()==m3.getType())
				m=m3;
			if(cars.getSelectedItem()==m4.getType())
				m=m4;
			if(cars.getSelectedItem()==m5.getType())
				m=m5;
			//Create an object of type Validation to check the input data
			String name=firstName.getText().trim();
			String surname=surn.getText().trim();
			String age=agee.getText().trim();
			String teleph=telephone.getText().trim();
			Validation validate=new Validation();
			//If everything's alright, go to the next page
			if(validate.controlString(name) && validate.controlString(surname) && validate.controlNumber(age) && validate.controlTelephoneNumber(teleph)) {
				//I've used the substring method of the Strings to get a certain number of characters, as well as toUpperCase to capitalize only the first letter of the first name and last name
				RentPanel f2=new RentPanel(name.substring(0, 1).toUpperCase() + name.substring(1),surname.substring(0, 1).toUpperCase() + surname.substring(1),age,teleph, m);//we pass as arguments to the constructor the parameters that it expects in the specified order
				frame.setVisible(false);
			}
			else {
				//The fields have not been filled in correctly...display a message
				JOptionPane.showMessageDialog(null, "Careful! Enter data correctly!");
			}
			
		}
	}
}
