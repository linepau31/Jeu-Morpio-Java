import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToe implements ActionListener {

	Random random = new Random();
	JFrame frame = new JFrame();
	JPanel title_panel = new JPanel();
	JPanel button_panel = new JPanel();
	JLabel textfield = new JLabel();
	JButton[] buttons =new JButton[9];
	boolean player1_turn;
	
	TicTacToe() {
		
		// cration de la fenetre
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		//creation du titre
		textfield.setBackground(new Color(125, 0, 159));
		textfield.setForeground(new Color(254,0,212));
		textfield.setFont(new Font("Ink Free", Font.BOLD,75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText("Morpion");
		textfield.setOpaque(true);
		
		title_panel.setLayout(new BorderLayout()); // fenetre responsive
		title_panel.setBounds(0,0,800,100); // spécifier la position et la taille d'un composant
		
		button_panel.setLayout(new GridLayout(3,3)); // grille des btns
		button_panel.setBackground(new Color(150,150,150)); // couleur de fond des btns
		
		for(int i=0;i<9;i++) { // creer les 9 boutons
			buttons[i] = new JButton();
			button_panel.add(buttons[i]);
			buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		//appel pour visualiser
		title_panel.add(textfield);
		frame.add(title_panel,BorderLayout.NORTH);
		frame.add(button_panel);
		
		firstTurn(); // appel de la methode
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { // interface d'ecoute d'action ActionListener
		
		for(int i=0;i<9;i++) {
			if(e.getSource()==buttons[i]) { 
				if(player1_turn) {
					if(buttons[i].getText()=="") { //btn vide
						buttons[i].setForeground(new Color(255, 0, 158)); // couleur du X
						buttons[i].setText("X"); // au clic affiche X
						player1_turn=false;
						textfield.setText("au tour du O"); // titre affiche
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0, 166, 255));
						buttons[i].setText("O");
						player1_turn=true;
						textfield.setText("au tour du X");
						check();
					}
				}
			}			
		}
	}
	
	public void firstTurn() { 
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(random.nextInt(2)==0) {
			player1_turn=true;
			textfield.setText("Le X commence");
		}else {
			player1_turn=false;
			textfield.setText("Le O commence");
		}
	}

	public void check() { 
		//vérifie les conditions X win 
				if(
						(buttons[0].getText()=="X") &&
						(buttons[1].getText()=="X") &&
						(buttons[2].getText()=="X")
						) {
					xWins(0,1,2);
				}
				if(
						(buttons[3].getText()=="X") &&
						(buttons[4].getText()=="X") &&
						(buttons[5].getText()=="X")
						) {
					xWins(3,4,5);
				}
				if(
						(buttons[6].getText()=="X") &&
						(buttons[7].getText()=="X") &&
						(buttons[8].getText()=="X")
						) {
					xWins(6,7,8);
				}
				if(
						(buttons[0].getText()=="X") &&
						(buttons[3].getText()=="X") &&
						(buttons[6].getText()=="X")
						) {
					xWins(0,3,6);
				}
				if(
						(buttons[1].getText()=="X") &&
						(buttons[4].getText()=="X") &&
						(buttons[7].getText()=="X")
						) {
					xWins(1,4,7);
				}
				if(
						(buttons[2].getText()=="X") &&
						(buttons[5].getText()=="X") &&
						(buttons[8].getText()=="X")
						) {
					xWins(2,5,8);
				}
				if(
						(buttons[0].getText()=="X") &&
						(buttons[4].getText()=="X") &&
						(buttons[8].getText()=="X")
						) {
					xWins(0,4,8);
				}
				if(
						(buttons[2].getText()=="X") &&
						(buttons[4].getText()=="X") &&
						(buttons[6].getText()=="X")
						) {
					xWins(2,4,6);
				}
				
				//vérifie les conditions O win 
				if(
						(buttons[0].getText()=="O") &&
						(buttons[1].getText()=="O") &&
						(buttons[2].getText()=="O")
						) {
					oWins(0,1,2);
				}
				if(
						(buttons[3].getText()=="O") &&
						(buttons[4].getText()=="O") &&
						(buttons[5].getText()=="O")
						) {
					oWins(3,4,5);
				}
				if(
						(buttons[6].getText()=="O") &&
						(buttons[7].getText()=="O") &&
						(buttons[8].getText()=="O")
						) {
					oWins(6,7,8);
				}
				if(
						(buttons[0].getText()=="O") &&
						(buttons[3].getText()=="O") &&
						(buttons[6].getText()=="O")
						) {
					oWins(0,3,6);
				}
				if(
						(buttons[1].getText()=="O") &&
						(buttons[4].getText()=="O") &&
						(buttons[7].getText()=="O")
						) {
					oWins(1,4,7);
				}
				if(
						(buttons[2].getText()=="O") &&
						(buttons[5].getText()=="O") &&
						(buttons[8].getText()=="O")
						) {
					oWins(2,5,8);
				}
				if(
						(buttons[0].getText()=="O") &&
						(buttons[4].getText()=="O") &&
						(buttons[8].getText()=="O")
						) {
					oWins(0,4,8);
				}
				if(
						(buttons[2].getText()=="O") &&
						(buttons[4].getText()=="O") &&
						(buttons[6].getText()=="O")
						) {
					oWins(2,4,6);
				}
	}
	
	public void xWins(int a, int b, int c) { // si X gagne
		buttons[a].setBackground(Color.GREEN); // les 3 btns couleur vert
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("X Gagne"); // affiche le titre du gagnant
	}
	
	public void oWins(int a, int b, int c) { // si O a gagne
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		for(int i=0;i<9;i++) {
			buttons[i].setEnabled(false);
		}
		textfield.setText("O Gagne");
	}
	
}
