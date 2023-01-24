import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**Ne kete klase kemi krijimin e faqjes se pare te programit. 
 * Ajo eshte e perbere nga 1 imazh i vendosur ne qender te ekranit per te dhene idene se eshte nje program qe ben te mundur qeramarrje/qeradhenie makinash.
 * Kjo ide jepet dhe nga titulli qe afishohet siper imazhit.
 * Ne fund shfaqim nje buton te klikueshem qe i mundeson perdoruesit kalimin ne faqe tjeter per te marre makinat me qera
 */
public class FaqjaPare implements ActionListener{
	
	//Deklarojme variablat globale si dhe krijojme Container-in
	private Container c=new Container();
	private JFrame frame=new JFrame();
	private JLabel lab1;
	private JButton btn1;
	private JLabel img1;
	
	//Me poshte kemi konstruktorin, i cili i jep titullin,permasat dhe vizibilitet kornizes si dhe  mbush panelin(per kete eshte krijuar nje metode tjeter per ta menaxhuar me mire kodin) 
	public FaqjaPare() {
		frame.setTitle("Makina me qera");
		frame.setBackground(Color.gray);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Ne mbyllje,objekti fshihet nga kujtesa
	    frame.setResizable(false);
	    frame.setSize(1000, 700);
	    frame.setLayout(null);    //Layout-i null...sic edhe do shihet me poshte elementet jane vendosur mekanikisht
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
	
	//Kjo metode ben te mundur qe ne panel te shfaqet titulli si dhe fotoja. Eshte krijuar gjithashtu dhe nje buton qe na dergon ne faqen tjeter
	
	private void mbushPanelin() {
		lab1=new JLabel("Makina Juaj!");
		lab1.setBounds(400, 35,200, 200);
		lab1.setFont(new Font("Serif", Font.ITALIC, 36));
		lab1.setForeground(Color.RED);
		c.add(lab1);
		ImageIcon image=new ImageIcon("img1.jpg");
		img1 = new JLabel(image); // transform it 
		img1.setBounds(120,180, 720, 300);
		c.add(img1);
		btn1=new JButton("Merr me qera");
		btn1.setBackground(Color.gray);
		btn1.setBounds(380, 530, 200, 30);
		btn1.setContentAreaFilled(true);
		btn1.setFocusPainted(false);
		btn1.setBorderPainted(true);
		btn1.setIcon(new ImageIcon(("img2.png")));
		btn1.addActionListener(this);//butonit i shtohet degjues ngjarjesh
		btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));		
		c.add(btn1);
	}
	
	/*Degjuesi i ngjarjes. Thirret ne click te butonit te krijuar. Me kete moment krijohet nje objekt i tipit PaneliMakinat 
	 * Frame ekzistues nuk eshte i dukshem(ndaj e kemi bere visible(false)),por shfaqet faqja ne vijim*/
	public void actionPerformed(ActionEvent e)
	{
		frame.setVisible(false);
		PaneliMakinat p=new PaneliMakinat();
	}
}
