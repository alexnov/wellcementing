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
	
	//������ ��
	private void okButtonActionPerformed(ActionEvent e){
		this.setVisible(false);
	}
	
	//������� �� ���������
	private void vertFieldActionPerformed(ActionEvent e){
		//����������� ������ � �����
		Double vert1 = Double.parseDouble(vertField.getText());
		//������� ������� �� ������
		Double lenght1 = Geometry.findLenght(vert1);
		//��������� ����� � ������
		String len = lenght1.toString();
		//���������� �������� � ��������� ����
		depthField.setText(len);
	}
	
	//������� �� ������
	private void depthFieldActionPerformed(ActionEvent e){
		//����������� ������ � �����
		Double lenght1 = Double.parseDouble(depthField.getText());
		//������� ������� �� ���������
		Double vert1 = Geometry.findHeight(lenght1);
		//��������� ������ � �����
		String ver = vert1.toString();
		//���������� �������� � ��������� ����
		vertField.setText(ver);
		
	}
	
	private JPanel dialogPane = new JPanel();
	private JPanel contentPane = new JPanel();
	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel buttonBar = new JPanel();
	private JLabel label1 = new JLabel("�� ���������");
	private JLabel label2 = new JLabel("�� ������");
	private JTextField vertField = new JTextField();
	private JTextField depthField = new JTextField();
	private JButton okButton = new JButton("OK");
	
	public ProfileCalcucator(){
		
		super("����������� ������� ��������");
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
		
		//��������
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
		
		//������ ��
		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				okButtonActionPerformed(e);
			}
		});
		//���������
		vertField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				vertFieldActionPerformed(e);
			}
		});
		//�� ������
		depthField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				depthFieldActionPerformed(e);
			}
		});
		
	}

}
