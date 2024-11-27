package XoGame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Xo extends JFrame implements ActionListener{

	JPanel titre,cpanel,mainpanel;
	JLabel texte ;
	String turn ;
	JButton[] Bouttons;
	boolean player;
	public void  possibility(int b1,int b2,int b3){
	    texte.setText("WINNER ");
	    Bouttons[b1].setBackground(Color.black);
	    Bouttons[b2].setBackground(Color.black);
	    Bouttons[b3].setBackground(Color.black);
	    
		for(int i=0;i<9;i++) {
			Bouttons[i].setEnabled(false);
					 
		}
		if(Bouttons[b1].getText()=="X")
		texte.setText(" X WINNER");
		else if(Bouttons[b1].getText()=="O") 
			texte.setText(" O WINNER");
		
		
	}
	
	public void Winner() {
		if(Bouttons[0].getText()==Bouttons[2].getText() && Bouttons[1].getText()==Bouttons[2].getText() && Bouttons[1].getText()!= "" )
			possibility(0,1,2);
		else if(Bouttons[0].getText()==Bouttons[3].getText() && Bouttons[6].getText()==Bouttons[3].getText() && Bouttons[0].getText()!= "" )
			possibility(0,3,6);
		
		else if(Bouttons[3].getText()==Bouttons[4].getText() && Bouttons[5].getText()==Bouttons[3].getText() && Bouttons[3].getText()!= "" )
			possibility(3,4,5);
		
		else if(Bouttons[6].getText()==Bouttons[7].getText() && Bouttons[8].getText()==Bouttons[6].getText() && Bouttons[6].getText()!= "" )
			possibility(6,7,8);
		else if(Bouttons[1].getText()==Bouttons[4].getText() && Bouttons[4].getText()==Bouttons[7].getText() && Bouttons[7].getText()!= "" )
			possibility(1,4,7);
		else if(Bouttons[2].getText()==Bouttons[5].getText() && Bouttons[5].getText()==Bouttons[8].getText() && Bouttons[8].getText()!= "" )
			possibility(2,5,8);
		else if(Bouttons[0].getText()==Bouttons[4].getText() && Bouttons[4].getText()==Bouttons[8].getText() && Bouttons[0].getText()!= "" )
			possibility(0,4,8);
		
		else if(Bouttons[2].getText()==Bouttons[4].getText() && Bouttons[4].getText()==Bouttons[6].getText() && Bouttons[2].getText()!= "" )
			possibility(2,4,6);
	
		
		
	}
	
	

	
	public Xo(){
		setTitle("jeu XO");
		setSize(800,800);
		
		texte=new JLabel("Start");
		titre= new JPanel();
		titre.setSize(300,500);
		titre.add(texte);
		
		Bouttons =new JButton[9];
		cpanel=new JPanel(new GridLayout(3,3));
		for(int i=0;i<9;i++) {
			 Bouttons[i]=new JButton();
			 Bouttons[i].setBackground(Color.pink);
			 Bouttons[i].addActionListener(this);
			 cpanel.add(Bouttons[i]);
			 
		}
		cpanel.setBackground(Color.pink);

		
		mainpanel=new JPanel(new BorderLayout());
		mainpanel.add(titre,BorderLayout.NORTH);		
		mainpanel.add(cpanel,BorderLayout.CENTER);	
		
		
	
		
		
		
		setContentPane(mainpanel);
		setVisible(true);
	}
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new Xo();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for (int i=0;i<9;i++) {
			if(e.getSource().equals(Bouttons[i]) ) {
				if(!player) {
				    if (Bouttons[i].getText()==""){
				    	texte.setText(" Joueur X");
				       turn="X";
				       Bouttons[i].setText(turn);
				       player=true;
				       texte.setText(" Joueur O");
				       //turn="O";
				       Winner();
				  		
			}	}
			   else if(Bouttons[i].getText()==""){
				texte.setText(" Joueur O");
				turn="O";
				Bouttons[i].setText(turn);
				player=false;
				//turn="X";
				 texte.setText(" Joueur X");
				 Winner();
				
			}
		}
	}

}}
