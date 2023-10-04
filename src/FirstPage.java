import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**In this class we create the first page of the program.
 * It consists of 1 image placed in the center of the screen to give the idea that it is a program that makes it possible to rent cars.
 * This idea is also given by the title displayed above the image.
 * At the end we display a clickable button that allows the user to go to another page to rent cars
 */
public class FirstPage implements ActionListener{
	
	//Declare global variables and create the Container
	private Container c=new Container();
	private JFrame frame=new JFrame();
	private JLabel lab1;
	private JButton btn1;
	private JLabel img1;
	
	//Below we have the constructor, which gives the title, dimensions and visibility to the frame and fills the panel (for this, another method has been created to better manage the code)
	public FirstPage() {
		frame.setTitle("Makina me qera");
		frame.setBackground(Color.gray);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//On closing, the object is deleted from memory
	    frame.setResizable(false);
	    frame.setSize(1000, 700);
	    frame.setLayout(null);    //Null layout... as it'll be seen below, the elements are mechanically placed
	    frame.getContentPane().add(c);
	    c.setSize(1000,650);
	    c.setLocation(0,0);
	    mbushPanelin();
	    JPanel p=new JPanel();
	    c.add(p);
	    p.setBackground(Color.white);
	    p.setSize(1000,700);
	    frame.setVisible(true);
	}
	
	//This method makes it possible for the panel to display the title as well as the photo. A button has also been created that sends us to the next page
	
	private void mbushPanelin() {
		lab1=new JLabel("Your Car!");
		lab1.setBounds(400, 35,200, 200);
		lab1.setFont(new Font("Serif", Font.ITALIC, 36));
		lab1.setForeground(Color.RED);
		c.add(lab1);
		ImageIcon image=new ImageIcon("img1.jpg");
		img1 = new JLabel(image); // transform it 
		img1.setBounds(120,180, 720, 300);
		c.add(img1);
		btn1=new JButton("Rent a car");
		btn1.setBackground(Color.gray);
		btn1.setBounds(380, 530, 200, 30);
		btn1.setContentAreaFilled(true);
		btn1.setFocusPainted(false);
		btn1.setBorderPainted(true);
		btn1.setIcon(new ImageIcon(("img2.png")));
		btn1.addActionListener(this);//Add ActionListeners
		btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));		
		c.add(btn1);
	}
	
	/*The EventListener: It is called by clicking on the created button. At this moment, an object of CarPanel type is created
     *The existing frame is not visible (that's why we make it visible (false)), but the following page is displayed*/
	public void actionPerformed(ActionEvent e)
	{
		frame.setVisible(false);
		CarPanel p=new CarPanel();
	}
}
