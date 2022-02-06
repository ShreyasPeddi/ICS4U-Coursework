package view;


import javax.swing.JFrame;


public class BingoGameFrame extends JFrame{
	
	NumberPanel numberPanel = new NumberPanel();
	BingoCardPanel cardPanel = new BingoCardPanel();
	
	
	public BingoGameFrame() {
		
		setSize(600,700);
		setLayout(null);
		setTitle("Bingo Game");
		
		add(numberPanel);
		add(cardPanel);
		setVisible(true);
	}

	public NumberPanel getNumberPanel() {
		return numberPanel;
	}

	public void setNumberPanel(NumberPanel numberPanel) {
		this.numberPanel = numberPanel;
	}

	public BingoCardPanel getCardPanel() {
		return cardPanel;
	}

	public void setCardPanel(BingoCardPanel cardPanel) {
		this.cardPanel = cardPanel;
	}

	
}
