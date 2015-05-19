package ru.alexnov.wellcementing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ProfileCalcucator extends JFrame {
	
	//кнопка ОК
	private void okButtonActionPerformed(ActionEvent e){
		this.setVisible(false);
	}
	
	//Глубина по вертикали
	private void vertFieldActionPerformed(ActionEvent e){
		//преобразуем строку в число
		Double vert1 = Double.parseDouble(vertField.getText());
		//находим глубину по стволу
		Double lenght1 = Geometry.findLenght(vert1);
		//переводим число в строку
		String len = lenght1.toString();
		//записываем значение в текстовое поле
		depthField.setText(len);
	}
	
	//Глубина по стволу
	private void depthFieldActionPerformed(ActionEvent e){
		//преобразуем строку в число
		Double lenght1 = Double.parseDouble(depthField.getText());
		//находим глубину по вертикали
		Double vert1 = Geometry.findHeight(lenght1);
		//переводим строку в число
		String ver = vert1.toString();
		//записываем значение в текстовое поле
		vertField.setText(ver);
		
	}
	
	private JPanel dialogPane = new JPanel();
	private JPanel contentPane = new JPanel();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel buttonBar = new JPanel();
	private JLabel label1 = new JLabel("по вертикали");
	private JLabel label2 = new JLabel("по стволу");
	private JTextField vertField = new JTextField();
	private JTextField depthField = new JTextField();
	private JButton okButton = new JButton("OK");
	
	public ProfileCalcucator(){
		
		super("Калькулятор профиля скважины");
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setSize(280, 150);
		setResizable(false);
		
		Container contPane = getContentPane();
		contPane.setLayout(new BorderLayout());
		dialogPane.setLayout(new BorderLayout());
		dialogPane.setBorder(new EmptyBorder(12,12,12,12));
		contentPane.setLayout(new GridLayout(2,1));
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonBar.setLayout(new FlowLayout(FlowLayout.RIGHT));
		label2.setBorder(new EmptyBorder(0,0,0,20));
		vertField.setPreferredSize(new Dimension(70,20));
		depthField.setPreferredSize(new Dimension(70,20));
		okButton.setPreferredSize(new Dimension(55,23));
		
		//Собираем
		panel1.add(label1);
		panel1.add(vertField);
		panel2.add(label2);
		panel2.add(depthField);
		contentPane.add(panel1);
		contentPane.add(panel2);
		buttonBar.add(okButton);
		dialogPane.add(contentPane, BorderLayout.CENTER);
		dialogPane.add(buttonBar, BorderLayout.SOUTH);
		contPane.add(dialogPane, BorderLayout.CENTER);
		setLocationRelativeTo(getOwner());
		
		//Кнопка ОК
		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				okButtonActionPerformed(e);
			}
		});
		//Вертикаль
		vertField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				vertFieldActionPerformed(e);
			}
		});
		//По стволу
		depthField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				depthFieldActionPerformed(e);
			}
		});
		
	}

}
