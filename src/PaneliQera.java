import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.time.Year;
import java.util.*;
/** Ne kete klase jane vendosur disa komponente GUI.Perdoruesi ketu me tej procesin e marrjes se makines me qera. 
 * Ajo eshte e perbere nga 8 komponente JTextField ku disa plotesohen automatikisht nga makina qe kemi zgjedhur per te marre me qera. data e marrjes dhe 
 * kthimit te makines plotesohet nga ne dhe ne baze te saj logariten se sa dite do merret me qera makina. 
 * Per te zgjedhur modifikime shtese jane krijuar 3 JCheckbox. Jane krijaur 3 butona: njeri qe te kthen tek faqja e meparshme, tjetri qe llogarit totalin
 * dhe i fundit qe printon faturen. Elemntet shtese e check-uar i shtohen totalit.
 */
public class PaneliQera implements ActionListener,Printable{
	
	//Deklarojme variablat globale si dhe krijojme Container-in

	private Container c=new Container();
	private JFrame frame=new JFrame();
	private JLabel title,lab;
	private JTextField cmimi,date1,month1,date2,month2,car,dite,totali;
	private JLabel car1,car2;
	private JButton btn1,btn2,tot;
	private JCheckBox sht1,sht2,sht3;
    private String emri,mbiemri,mosha,tel;
	private Makina makina;
	
	/*Me poshte kemi konstruktorin, i cili i jep titullin,permasat dhe vizibilitet kornizes si dhe  mbush panelin(per kete eshte krijuar nje metode tjeter per ta menaxhuar me mire kodin) 
      Gjithashtu ne konstruktor mbushen var e fushes qe do te shfaqen me vone ne faqen qe do te printohet!*/
	public PaneliQera(String em,String mb,String mosha,String cel,Makina m) {
		this.emri=em;
		this.mbiemri=mb;
		this.mosha=mosha;
		this.tel=cel;
		this.makina=m;
		frame.setTitle("Merr me qera");
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
	 /*Ne rreshtat e meposhtem(55-204) kemi krijuar nje nga nje komponentet si dhe jane shfaqur imazhet*/
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

		
		title=new JLabel("Informacion!");
		title.setBounds(100, 10,300, 150);
		title.setFont(new Font("Serif", Font.ITALIC, 36));
		title.setForeground(Color.RED);
		c.add(title);
		
		lab=new JLabel("Makina:");
		lab.setBounds(50,145,70, 15);
		lab.setFont(new Font("Arial", Font.PLAIN, 14));
		lab.setForeground(Color.black);
		c.add(lab);
		
      //Ketu kemi krijuar nje textfield qe mbushet me emrin e makines qe kemi zgjedhur per te marre me qera
		
		car=new JTextField();
		car.setText(makina.getTipi());
		car.setBounds(120,140,180,23);
		car.setEditable(false);
		c.add(car);

		lab=new JLabel("Cmimi:");
		lab.setBounds(50,185,70, 15);
		lab.setFont(new Font("Arial", Font.PLAIN, 14));
		lab.setForeground(Color.black);
		c.add(lab);
	      //Ketu kemi krijuar nje textfield qe mbushet me cmimin e makines qe kemi zgjedhur per te marre me qera

		cmimi=new JTextField();
		cmimi.setText(makina.getCmimi()+"");
		cmimi.setBounds(120,180,180,23);
		cmimi.setEditable(false);
		c.add(cmimi);
		//Me poshte jane krijuar textfield-e me Label-at perkates per daten e marrjes dhe kthimit te makines
		lab=new JLabel("Data e marrjes:");
		lab.setBounds(50,225,120, 15);
		lab.setFont(new Font("Arial", Font.PLAIN, 14));
		lab.setForeground(Color.black);
		c.add(lab);

		date1=new JTextField();
		date1.setBounds(170,220,30,23);
		c.add(date1);
		
		lab=new JLabel("Muaji:");
		lab.setBounds(220,225,70, 15);
		lab.setFont(new Font("Arial", Font.PLAIN, 14));
		lab.setForeground(Color.black);
		c.add(lab);

		month1=new JTextField();
		month1.setBounds(270,220,30,23);
		c.add(month1);
		
		lab=new JLabel("Data e dorezimit:");
		lab.setBounds(50,265,120, 15);
		lab.setFont(new Font("Arial", Font.PLAIN, 14));
		lab.setForeground(Color.black);
		c.add(lab);

		date2=new JTextField();
		date2.setBounds(170,260,30,23);
		c.add(date2);
		
		lab=new JLabel("Muaji:");
		lab.setBounds(220,265,70, 15);
		lab.setFont(new Font("Arial", Font.PLAIN, 14));
		lab.setForeground(Color.black);
		c.add(lab);

		month2=new JTextField();
		month2.setBounds(270,260,30,23);
		c.add(month2);
		
		lab=new JLabel("Dite gjithsej:");
		lab.setBounds(50,305,120, 15);
		lab.setFont(new Font("Arial", Font.PLAIN, 14));
		lab.setForeground(Color.black);
		c.add(lab);

		dite=new JTextField();
		dite.setBounds(170,300,130,23);
		dite.setEditable(false);//percakton qe TextField-i eshte readonly
		c.add(dite);
	
		title=new JLabel("Elemente shtese!");
		title.setBounds(600, 10,300, 150);
		title.setFont(new Font("Serif", Font.ITALIC, 36));
		title.setForeground(Color.RED);
		c.add(title);
        //Elementet shtese jane percaktuar si checkbox-e
		sht1=new JCheckBox("Goma debore (6000)");
		sht1.setBounds(600,145,200,20);
		sht1.setContentAreaFilled(false);
		sht1.setFocusPainted(false);
		sht1.setBorderPainted(false);
		sht1.addActionListener(this);
		
		sht2=new JCheckBox("Mbajtese bagazhesh (1500)");
		sht2.setBounds(600,185,200,20);
		sht2.setContentAreaFilled(false);
		sht2.setFocusPainted(false);
		sht2.setBorderPainted(false);
		sht2.addActionListener(this);
		
		sht3=new JCheckBox("Bileta parkimi (3000)");
		sht3.setBounds(600,225,200,20);
		sht3.setContentAreaFilled(false);
		sht3.setFocusPainted(false);
		sht3.setBorderPainted(false);
		sht3.addActionListener(this);
		c.add(sht1);c.add(sht2);c.add(sht3);
		//Totali:Buton me pergjues ngjarjesh ne click te se cilit llogaritet nr i doiteve dhe totali qe duhet paguar
		tot=new JButton("Totali");
		tot.setBounds(600,285,70,25);
		tot.addActionListener(this);
		tot.setFocusable(false);
		tot.setCursor(new Cursor(Cursor.HAND_CURSOR));
		c.add(tot);
		
		totali=new JTextField();
		totali.setBounds(700,285,100,25);
		totali.setEditable(false);
		c.add(totali);
		//Me poshte jane krijuar 2 imazhe per arsye dekorimi
		ImageIcon img1=new ImageIcon("img12.jpg");
		car1 = new JLabel(img1); // transform it 
		car1.setBounds(50,400, 250, 140);
		c.add(car1);
		
		ImageIcon img2=new ImageIcon("img13.png");
		car2 = new JLabel(img2); // transform it 
		car2.setBounds(650,400, 250, 140);
		c.add(car2);
		//Pasi jane plotesuar fushat,klikimi i butonit te meposhtem printon faturen
		btn2=new JButton("Printo");
		btn2.setBounds(400,480,120,25);		
		btn2.setFocusPainted(false);
		btn2.setBorderPainted(true);
		btn2.setIcon(new ImageIcon(("img11.png")));
		btn2.addActionListener(this);
		btn2.setCursor(new Cursor(Cursor.HAND_CURSOR));		
		c.add(btn2);
		
	}
	
	//Ne rreshtat e meposhtem i kemi dhene butonave ActionListener
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Validime valido=new Validime();//Krijojme nje objekt te tipit Validime qe kontrollon te dhenat(me poshte kontrolli)
		String dita1=date1.getText();//merren vlerat e plotesuara
		String dita2=date2.getText();
		String muaji1=month1.getText();
		String muaji2=month2.getText();
		//Nese klikohet butoni i pare kalohet ne faqen e pare
		if(e.getSource()==btn1)
		{
	          PaneliMakinat f1=new PaneliMakinat();
	          frame.setVisible(false);
		}
		/*Nese klikojme butonin tot bejme te mundur qe nese jane plotesuar datat e marrjes hde kthimit te llogaritet totali qe duhet paguar*/
		if(e.getSource()==tot) {
			//nese gjithcka eshte plotesuar sipas formatit te caktuar llogaritet totali dhe nr i diteve		
			if(valido.kontrolloDatat(dita1) && valido.kontrolloDatat(dita2) && valido.kontrolloMuajin(muaji1) && valido.kontrolloMuajin(muaji2)) {
				Llogaritje a=new Llogaritje();//krijohet nj eobjekt i tipit Llogaritje qe perdoren me vone per te llogaritur ditet dhe totalin
	            dite.setText(a.llogaritDitet(Integer.parseInt(dita1),Integer.parseInt(dita2),Integer.parseInt(muaji1),Integer.parseInt(muaji2))+"");
	            int total=a.llogaritCmimin(makina.getCmimi(),Integer.parseInt(dite.getText()));
	            if(sht1.isSelected()) //Nese elementet jane check-uar i shtohen totalit
	            	total+=6000;
	            if(sht2.isSelected())
	            	total+=1500;
	            if(sht3.isSelected())
	            	total+=3000;
	            totali.setText(total+"");//i jep vlere totalit
			}
			else {
				JOptionPane.showMessageDialog(null, "Kujdes! Duhet percaktuar dita/muaji i marrjes dhe dorezimit te makines!");
			}
			
		}
		/*Nese klikohet butoni btn2,krijohet nje objekt i tipit PrinterJob i cili do te na mundesoje printimin e fatures dhe gjenerimin e saj ne format pdf
		 */
		if(e.getSource()==btn2) {
			String totalAmount=totali.getText();
			String NoDays=dite.getText();
			//nese jane plotesuar te gjitha fushat printohet fatura
			if(valido.kontrolloDatat(dita1) && valido.kontrolloDatat(dita2) && valido.kontrolloMuajin(muaji1) && valido.kontrolloMuajin(muaji2) && valido.kontrolloNumer(totalAmount) && valido.kontrolloNumer(NoDays)) 
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
				JOptionPane.showMessageDialog(null, "Kujdes! Duhet te jene te plotesuara te gjitha fushat!");
			}
			
		}
	}

	//Ne rreshtat e meposhtem kemi krijuar faturen me te gjitha ne te cilat shfaqim gjithe informacionet e nevojshme
	
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		// TODO Auto-generated method stub
		if (pageIndex == 0) { 
			
		GregorianCalendar c=new GregorianCalendar();
		Year thisyear=Year.now();
		Graphics2D g2d = (Graphics2D)graphics;
		g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
		
		graphics.drawString("**********************************************", 220, 40);
		graphics.drawString("Makina juaj",270, 70);
		graphics.drawString("**********************************************", 220, 100);
		graphics.drawString("Klienti: "+emri+" "+mbiemri,270,130);
		graphics.drawString("Numri i telefonit: "+tel,270,220);
		graphics.drawString("Mosha: "+mosha,270,160);
		graphics.drawString("Makina: "+makina.getTipi(),270,250);
		graphics.drawString("Data e marrjes: "+Integer.parseInt(date1.getText())+"/"+Integer.parseInt(month1.getText())+"/"+thisyear,270,280);
		graphics.drawString("Data e kthimit: "+Integer.parseInt(date2.getText())+"/"+Integer.parseInt(month2.getText())+"/"+thisyear,270,310);
		graphics.drawString("********************************************",220,340);
		graphics.drawString("Totali: "+totali.getText()+" All",270,370);
		graphics.drawString("********************************************",220,400);

		return PAGE_EXISTS;
	}
		else {
			return NO_SUCH_PAGE;
		}
	}

}
