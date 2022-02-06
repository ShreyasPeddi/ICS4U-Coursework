package view;

import java.awt.Color;

import javax.swing.*;

public class NumberPanel extends JPanel{
	
	private JLabel instructionLabel = new JLabel("Click the button to pick the next number");
	public JButton nextButton = new JButton("0");
	
	public NumberPanel() {
		
		setBackground(Color.cyan);
		setBounds(0,0,600,100);
		
		add(instructionLabel);
		add(nextButton);
		
	}

	public JLabel getInstructionLabel() {
		return instructionLabel;
	}

	public void setInstructionLabel(JLabel instructionLabel) {
		this.instructionLabel = instructionLabel;
	}

	public JButton getNextButton() {
		return nextButton;
	}

	public void setNextButton(JButton nextButton) {
		this.nextButton = nextButton;
	}

	
}
