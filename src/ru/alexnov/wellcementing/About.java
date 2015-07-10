package ru.alexnov.wellcementing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class About extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5980274233927235475L;

	private void okButtonActionPerformed(ActionEvent e) {
		// TODO add your code here
		this.setVisible(false);}
	
	public About(){
		//Инициализируем компоненты
		JButton okButton = new JButton("OK");
		JPanel contentPanel = new JPanel();
		JPanel textPanel = new JPanel();
		textPanel.setPreferredSize(new Dimension(300,200));
		JLabel textLabel = new JLabel();
		textLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		String text = "<html><p align='center'>Программа расчета цементирования обсадных колонн<br>"
				+ "Версия 0.0.2</p></html>";
		textLabel.setText(text);
		textLabel.setHorizontalAlignment(JLabel.CENTER);
		textLabel.setVerticalAlignment(JLabel.CENTER);
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonPanel.add(okButton);
		textPanel.add(textLabel);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		contentPanel.add(textPanel);
		contentPanel.add(buttonPanel);
		setContentPane(contentPanel);
		
		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				okButtonActionPerformed(e);
			}
		});
	}

}
