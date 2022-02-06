package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Stack;

import model.BingoCard;
import view.BingoGameFrame;

public class BingoGameController implements ActionListener{

	//Fields
	private static Stack<Integer> numberList = new Stack<Integer>();
	BingoGameFrame gameFrame = new BingoGameFrame();
	BingoCard card = new BingoCard();
	
	
	//Constructor
	public BingoGameController() {
		
		//Add the controller class's action listener to control what the next button does
		gameFrame.getNumberPanel().getNextButton().addActionListener(this);
		
		for(int i=1;i<76;i++)
			numberList.add(i);
		
		//Create a random list of numbers to be chosen from
		Collections.shuffle(numberList);
		
		
		//Update the card numbers with the random grid numbers stored in the model
		addCardNumbers();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource()==gameFrame.getNumberPanel().getNextButton()) {
			
			//Pick a new random number
			int currentNum=numberList.pop();
			
			//Check if the random number is on the board
			checkBoard(currentNum);
			gameFrame.getNumberPanel().getNextButton().setText(""+currentNum);
		}

		
	}
	
	//Updates the labels with random numbers
	private void addCardNumbers() {
		
		for(int i=0;i<5;i++) {
			
			for(int j=0;j<5;j++) {
				
				gameFrame.getCardPanel().getNumberJLabelArray()[i][j].setText(""+card.getGrid()[i][j]);
				
			}
		}
		
		gameFrame.getCardPanel().getNumberJLabelArray()[2][2].setText("X");
	}
	
	//Checks if the random number is present in the grid and does appropriate action
	private void checkBoard(int num) {
		
		for(int i=0;i<card.getGrid().length;i++) {
			
			for(int j=0;j<card.getGrid().length;j++) {

				//Highlight the numbers which are picked with green
				if(card.getGrid()[i][j]==num) {
					gameFrame.getCardPanel().getNumberJLabelArray()[i][j].setBackground(Color.GREEN);
					gameFrame.getCardPanel().getNumberJLabelArray()[i][j].setOpaque(true);
					
					//Set the grid number to 0 to indicate that the number was chosen
					card.getGrid()[i][j]=0;
					
					if(card.checkForBingo())
						gameFrame.dispose();
				}
				
			}
		}
	}
	
	
	
}
