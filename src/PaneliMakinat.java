import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**Ne kete klase jane vendosur disa komponente GUI.Perdoruesi ketu ploteson te dhenat e tij dhe perzgjedh makinen qe do te marr me qera. 
 * Ajo eshte e perbere nga 4 komponente JTextField perkatesisht per te plotesuar emrin,mbiemrin,moshen dhe numrin e celularit. 
 * Per te zgjedhur makinen eshte krijuar nje JComboBox. Makinat gjendje jane te percaktuara me pare nga ne(krijuesit e aplikacionit).
 * Jepet mundesia per tu kthyer tek faqja e pare(btn1) apo per te kaluar tek faqja tjeter,pasi ploteson te dhenat(btn2). Kemi shfaqur gjithashtu 
 * edhe 5 foto makinash(nga nje per cdo makine) dhe nje foto te madhe per arsye zbukurimi.
 */
public class PaneliMakinat implements ActionListener{
	
	//Deklarojme variablat globale si dhe krijojme Container-in
	private Container c=new Container();
	private JFrame frame=new JFrame();
	private JLabel title,lab;
	private JTextField emri,mbiemri,mosha,nrCel;
	private JLabel image,car1,car2,car3,car4,car5;
	private JComboBox makinat;
	private JButton btn1,btn2;
	//Jane krijuar 5 objekte te tipit Makina qe tregojne makinat qe kemi ne ne gjendje dhe cmimin perkates
	Makina m1=new Makina("MERCEDES-BENZ S-CLASS",25000);
	Makina m2=new Makina("PORSCHE CAYENNE",30000);
	Makina m3=new Makina("RANGE ROVER",20000);
	Makina m4=new Makina("VOLKSWAGEN TOURAN",6000);
	Makina m5=new Makina("BMW SERIA 5",18000);

	/*Me poshte kemi konstruktorin, i cili i jep titullin,permasat dhe vizibilitet kornizes si dhe  mbush panelin (per kete eshte krijuar nje metode tjeter
	 *  per ta menaxhuar me mire kodin). 
	 * */ 

	public PaneliMakinat() {
		frame.setTitle("Makinat");
		frame.setBackground(Color.gray);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    frame.setSize(1000, 700);
	    frame.setLayout(null);
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
  /*Ne rreshtat e meposhtem(51-160) kemi krijuar nje nga nje komponentet si dhe jane shfaqur imazhet*/
	
	private void mbushPanelin() {
		
       //Butoni kthehu...i kemi vendosur pergjues ngjarjesh
		
		btn1=new JButton("Kthehu");
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
		
		title=new JLabel("Merr me qera!");
		title.setBounds(100, 10,300, 150);
		title.setFont(new Font("Serif", Font.ITALIC, 36));
		title.setForeground(Color.RED);
		c.add(title);
		
		//me poshte kemi vendosjen e textbox-eve ku secilit i vendosim nje label specifik
		
		lab=new JLabel("Emri:");
		lab.setBounds(50,145,70, 15);
		lab.setFont(new Font("Arial", Font.PLAIN, 14));
		lab.setForeground(Color.black);
		c.add(lab);

		emri=new JTextField();
		emri.setBounds(120,140,180,23);
		c.add(emri);
		
		lab=new JLabel("Mbiemri:");
		lab.setBounds(50,185,70, 15);
		lab.setFont(new Font("Arial", Font.PLAIN, 14));
		lab.setForeground(Color.black);
		c.add(lab);

		mbiemri=new JTextField();
		mbiemri.setBounds(120,180,180,23);
		c.add(mbiemri);
		
		lab=new JLabel("Mosha:");
		lab.setBounds(50,225,70, 15);
		lab.setFont(new Font("Arial", Font.PLAIN, 14));
		lab.setForeground(Color.black);
		c.add(lab);

		mosha=new JTextField();
		mosha.setBounds(120,220,180,23);
		c.add(mosha);
		
		lab=new JLabel("Nr i cel:");
		lab.setBounds(50,265,70, 15);
		lab.setFont(new Font("Arial", Font.PLAIN, 14));
		lab.setForeground(Color.black);
		c.add(lab);

		nrCel=new JTextField();
		nrCel.setBounds(120,260,180,23);
		c.add(nrCel);
		
		lab=new JLabel("Makina:");
		lab.setBounds(50,305,70, 15);
		lab.setFont(new Font("Arial", Font.PLAIN, 14));
		lab.setForeground(Color.black);
		c.add(lab);
		
		//Krijimi i ComboBox-it per te treguar makiant gjendje te krijuar me siper
		
		makinat=new JComboBox();
		makinat.addItem(m1.getTipi());
		makinat.addItem(m2.getTipi());
		makinat.addItem(m3.getTipi());
		makinat.addItem(m4.getTipi());
		makinat.addItem(m5.getTipi());
		makinat.setBounds(120,300,180,23);
        c.add(makinat);
        //Vendosja e imazheve
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
		//Butoni i dyte qe ben te mundur te kalosh ne faqen tjeter(ne te cilen zgjidhen ditet kur do merret me qera makina dhe printohet fatura)
		btn2=new JButton("Vazhdo");
		btn2.setBounds(400,480,120,25);		
		btn2.setContentAreaFilled(false);
		btn2.setFocusPainted(false);
		btn2.setBorderPainted(true);
		btn2.setIcon(new ImageIcon(("img4.png")));
		btn2.addActionListener(this);
		btn2.setCursor(new Cursor(Cursor.HAND_CURSOR));		
		c.add(btn2);
		
	}
	//Ne rreshtat e meposhtem i kemi dhene butonave ActionListener
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//Nese klikohet butoni i pare kalohet ne faqen e pare
		if(e.getSource()==btn1)
		{
	          FaqjaPare f1=new FaqjaPare();	          
	          frame.setVisible(false);
		}
		//Nese klikohet butoni i dyte(ngjarja shkaktohet prej tij) dhe jane plotesuar gjithe validimet(pas kontrollit te te dhenave hyrese) kalohet ne faqen pasuese
		if(e.getSource()==btn2) {
			
			Makina  m=m1;//Ne rreshtat me poshte kontrollojme informacionet per cilen makine do shfaqim ne faqen tjeter(ke kemi zgjedhur?)
			if(makinat.getSelectedItem()==m2.getTipi())
				m=m2;
			if(makinat.getSelectedItem()==m3.getTipi())
				m=m3;
			if(makinat.getSelectedItem()==m4.getTipi())
				m=m4;
			if(makinat.getSelectedItem()==m5.getTipi())
				m=m5;
			//Krijojme nje objekt te tipit Validime per te kontrolluar te dhenat hyrese
			String name=emri.getText().trim();
			String surname=mbiemri.getText().trim();
			String age=mosha.getText().trim();
			String teleph=nrCel.getText().trim();
			Validime valido=new Validime();
			//Nese gjithcka eshte ne rregull kalo ne faqen tjeter
			if(valido.kontrolloString(name) && valido.kontrolloString(surname) && valido.kontrolloNumer(age) && valido.kontrolloNumerTeli(teleph)) {
				//Kam perdorur metoden substring te stringjeve per te marre nje numer te caktuar karakteresh,si dhe toUpperCase pet te bere me shkronje te madhe vetem shkronjen e pare te emrit dhe mbiemrit
				PaneliQera f2=new PaneliQera(name.substring(0, 1).toUpperCase() + name.substring(1),surname.substring(0, 1).toUpperCase() + surname.substring(1),age,teleph, m);//i kalojme si argumenta konstruktorit parametrat qe ai pret sipas radhes se caktuar
				frame.setVisible(false);
			}
			else {
				//Nuk jane plotesuar fushat sic duhet...shfaq mesazh
				JOptionPane.showMessageDialog(null, "Kujdes! Vendos sakte te dhenat!");
			}
			
		}
	}
}
