package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BingoCardPanel extends JPanel{
	
	private JLabel cardLabel = new JLabel(new ImageIcon("bingoCard.png"));
	private JLabel[][] numberJLabelArray = new JLabel[5][5];
	

	public BingoCardPanel() {
		
		setLayout(new BorderLayout());
		setBounds(0,90,600,600);
		
		addNumberLabels();
		add(cardLabel);

		
	}
	
	
	public JLabel getCardLabel() {
		return cardLabel;
	}

	public void setCardLabel(JLabel cardLabel) {
		this.cardLabel = cardLabel;
	}

	public JLabel[][] getNumberJLabelArray() {
		return numberJLabelArray;
	}

	public void setNumberJLabelArray(JLabel[][] numberJLabelArray) {
		this.numberJLabelArray = numberJLabelArray;
	}
	
	
	public void addNumberLabels() {
		
		for(int i=0;i<5;i++) {
			
			for(int j=0;j<5;j++) {
				numberJLabelArray[i][j]=new JLabel();
				numberJLabelArray[i][j].setBounds(80+(i*100),(j*100)+75,50,40);
				numberJLabelArray[i][j].setText("0");
				numberJLabelArray[i][j].setFont(new Font("Seif", Font.BOLD,40));
				add(numberJLabelArray[i][j]);
				
			}
			
		}
		
		
		numberJLabelArray[2][2].setBackground(Color.GREEN);
		numberJLabelArray[2][2].setOpaque(true);
	
	}
}
