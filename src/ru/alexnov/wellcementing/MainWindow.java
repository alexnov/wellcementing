package ru.alexnov.wellcementing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import ru.alexnov.wellcementing.Tables.CementingCasingTableModel;
import ru.alexnov.wellcementing.Tables.OpenHoleTableModel;
import ru.alexnov.wellcementing.Tables.PreviousTableModel;
import ru.alexnov.wellcementing.Tables.ProfileTableModel;

public class MainWindow extends JFrame {
	
	public static int index = 1;//�������
	public static int index2 = 1;//���������� �������
	public static int index3 = 1;//�������� �����
	public static int index4 = 1;//������������� �������
	public static int index5 = 1;//�������
	
	//������� ��������� �������
	ProfileTableModel profileSample = new ProfileTableModel();
	//������� ��������� ������ �� ���������� ��������
	PreviousTableModel previousSample = new PreviousTableModel();
	//������� ��������� ������ �� ��������� ������
	OpenHoleTableModel openholeSample = new OpenHoleTableModel();
	//������� ��������� ������ �� ������������� �������
	CementingCasingTableModel casingSample = new CementingCasingTableModel();
	
	//��������� ������� ������� + - ��������� ������� � �������� � ��������� ������� �������
	private void plusProfileActionPerformed(ActionEvent e) {
		index = index+1;
		profileSample.fireTableStructureChanged();
	}
	//��������� ������� ������� "-" - �������� ��������� ������
		//�������� ������� �� �������� � ��������� ������� �������
		private void minusProfileActionPerformed(ActionEvent e) {
			// TODO add your code here
			if (index ==0){
			Program.massiv[index-1][0] = 0.0;
			Program.massiv[index-1][1] = 0.0;
			Program.massiv[index-1][2] = 0.0;
			index = index-1;
			profileSample.fireTableStructureChanged();
			}
			else {
JOptionPane.showMessageDialog(scroll1, "������ ������ ������ �������", "������", JOptionPane.ERROR_MESSAGE);
			}
		}
		//������ ������� ������������ �������
		private void calcProfileActionPerformed(ActionEvent e){
			ProfileCalcucator calc = new ProfileCalcucator();
			calc.setVisible(true);
		}
		//��������� ������� ������� + - ��������� ������� � �������� � ��������� ������� ���������� �������
		private void plusPreviousActionPerformed(ActionEvent e){
			index2 = index2+1;
			previousSample.fireTableStructureChanged();
		}
		//��������� ������� ������� "-" - �������� ��������� ������
				//�������� ������� �� �������� � ��������� ������� ���������� �������
		private void minusPreviousActionPerformed(ActionEvent e){
			if (index2 ==0){
			Program.previous[index2-1][0] = 0.0;
			Program.previous[index2-1][1] = 0.0;
			Program.previous[index2-1][2] = 0.0;
			Program.previous[index2-1][3] = 0.0;
			index2 = index2-1;
			previousSample.fireTableStructureChanged();
			}
			else {
JOptionPane.showMessageDialog(scroll1, "������ ������ ������ �������", "������", JOptionPane.ERROR_MESSAGE);
			}
		}
		//��������� ������� ������� + - ��������� ������� � �������� � ��������� ������� ��������� ������
		private void plusOpenholeActionPerformed(ActionEvent e){
			index3 = index3+1;
			openholeSample.fireTableStructureChanged();
		}
		//��������� ������� ������� "-" - �������� ��������� ������
		//�������� ������� �� �������� � ��������� ������� ��������� ������
		private void minusOpenholeActionPerformed(ActionEvent e){
			if (index3 ==0){
			Program.openhole[index3-1][0] = 0.0;
			Program.openhole[index3-1][1] = 0.0;
			Program.openhole[index3-1][2] = 0.0;
			Program.openhole[index3-1][3] = 0.0;
			index3 = index3-1;
			openholeSample.fireTableStructureChanged();
		}
		else {
JOptionPane.showMessageDialog(scroll1, "������ ������ ������ �������", "������", JOptionPane.ERROR_MESSAGE);
		}
		}
		//��������� ������� ������� + - ��������� ������� � �������� � ��������� ������� ������������� �������
				private void plusCasingActionPerformed(ActionEvent e){
					index4 = index4+1;
					casingSample.fireTableStructureChanged();
				}
				//��������� ������� ������� "-" - �������� ��������� ������
				//�������� ������� �� �������� � ��������� ������� ������������� �������
				private void minusCasingActionPerformed(ActionEvent e){
					if (index4 ==0){	
				Program.casing[index4-1][0] = 0.0;
				Program.casing[index4-1][1] = 0.0;
				Program.casing[index4-1][2] = 0.0;
				Program.casing[index4-1][3] = 0.0;
				index4 = index4-1;
				casingSample.fireTableStructureChanged();
				}
					else {
JOptionPane.showMessageDialog(scroll1, "������ ������ ������ �������", "������", JOptionPane.ERROR_MESSAGE);
								}
				}
		
		JTabbedPane tabPanel = new JTabbedPane();
	    JScrollPane scroll1 = new JScrollPane();
		JScrollPane scroll2 = new JScrollPane();
		JPanel panel10 = new JPanel();
		JPanel panel100 = new JPanel();
		JLabel label1 = new JLabel("�������������");
		JLabel label2 = new JLabel("����");
		JLabel label3 = new JLabel("��������");
		JTextField fieldName = new JTextField();
		JTextField bushName = new JTextField();
		JTextField wellNumber = new JTextField();
		JPanel panel1 = new JPanel();
		JPanel panel200 = new JPanel();
		JLabel label4 = new JLabel("������� ��������");
		JPanel panel201 = new JPanel();
		JButton calcProfile = new JButton("�����������");
		JButton plusProfile = new JButton("+");
		JButton minusProfile = new JButton("-");
		JPanel panel20 = new JPanel();
		JPanel panel300 = new JPanel();
		JLabel label5 = new JLabel("���������� �������");
		JPanel panel301 = new JPanel();
		JButton plusPrevious = new JButton("+");
		JButton minusPrevious = new JButton("-");
		JPanel panel30 = new JPanel();
		JScrollPane scroll200 = new JScrollPane();
		JTable previousTable = new JTable(previousSample);
		JPanel panel400 = new JPanel();
		JLabel label6 = new JLabel("�������� �����");
		JPanel panel401 = new JPanel();
		JButton plusOpenhole = new JButton("+");
		JButton minusOpenhole = new JButton("-");
		JPanel panel40 = new JPanel();
		JScrollPane scroll300 = new JScrollPane();
		JTable openholeTable = new JTable(openholeSample);
		JPanel panel500 = new JPanel();
		JLabel label7 = new JLabel("������������� �������");
		JPanel panel501 = new JPanel();
		JButton plusCasing = new JButton("+");
		JButton minusCasing = new JButton("-");
		JPanel panel50 = new JPanel();
		JScrollPane scroll400 = new JScrollPane();
		JTable casingTable = new JTable(casingSample);
		JPanel panel101 = new JPanel();
		JScrollPane scroll100 = new JScrollPane();
		JTable profileTable = new JTable(profileSample);
		JOptionPane message = new JOptionPane();
		//����
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem openItem = new JMenuItem("Open");
		JMenuItem saveItem = new JMenuItem("Save");
		JMenuItem saveasItem = new JMenuItem("Save As...");
	
	public MainWindow(){
		
		super("���� �������� ������");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(620, 650);
		//�������� ����
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(saveasItem);
		menuBar.add(fileMenu);
		
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel10.setLayout(new BoxLayout(panel10, BoxLayout.Y_AXIS));
		panel100.setLayout(new FlowLayout());
		fieldName.setPreferredSize(new Dimension(100,20));
		bushName.setPreferredSize(new Dimension(50,20));
		wellNumber.setPreferredSize(new Dimension(50,20));
				//������ � �������� ������� ��������
				panel200.setLayout(new FlowLayout(FlowLayout.LEFT));
				panel200.add(label4);
				//������ � ����� �������� - ��� ������� � �����������
				panel201.setLayout(new FlowLayout(FlowLayout.RIGHT));
				panel201.add(calcProfile);
				panel201.add(minusProfile);
				panel201.add(plusProfile);
				//���������� ��� ������ � �����
				panel20.setLayout(new BoxLayout(panel20, BoxLayout.X_AXIS));
				panel20.add(panel200);
				panel20.add(panel201);
				//������ � �������� ���������� �������
				panel300.setLayout(new FlowLayout(FlowLayout.LEFT));
				panel300.add(label5);
				//������ � ����� �������� - ��� ������� ���������� �������
				panel301.setLayout(new FlowLayout(FlowLayout.RIGHT));
				panel301.add(minusPrevious);
				panel301.add(plusPrevious);
				//���������� ��� ������ � �����
				panel30.setLayout(new BoxLayout(panel30, BoxLayout.X_AXIS));
				panel30.add(panel300);
				panel30.add(panel301);
				//������� ��� ���������� �������
				previousTable.setPreferredSize(new Dimension(580, 80));
				scroll200.setViewportView(previousTable);
				previousTable.setPreferredScrollableViewportSize(new Dimension(580, 80));
				//������ � �������� �������� �����
				panel400.setLayout(new FlowLayout(FlowLayout.LEFT));
				panel400.add(label6);
				//������ � ����� �������� - ��� ������� ��������� ������
				panel401.setLayout(new FlowLayout(FlowLayout.RIGHT));
				panel401.add(minusOpenhole);
				panel401.add(plusOpenhole);
				//���������� ��� ������ � �����
				panel40.setLayout(new BoxLayout(panel40, BoxLayout.X_AXIS));
				panel40.add(panel400);
				panel40.add(panel401);
				//������� ��� ��������� ������
				openholeTable.setPreferredSize(new Dimension(580, 80));
				scroll300.setViewportView(openholeTable);
				openholeTable.setPreferredScrollableViewportSize(new Dimension(580, 80));
				//������ � �������� ������������� �������
				panel500.setLayout(new FlowLayout(FlowLayout.LEFT));
				panel500.add(label7);
				//������ � ����� �������� - ��� ������� ������������� �������
				panel501.setLayout(new FlowLayout(FlowLayout.RIGHT));
				panel501.add(minusCasing);
				panel501.add(plusCasing);
				//���������� ��� ������ � ����
				panel50.setLayout(new BoxLayout(panel50, BoxLayout.X_AXIS));
				panel50.add(panel500);
				panel50.add(panel501);
				//������� ��� ������������� �������
				casingTable.setPreferredSize(new Dimension(580, 80));
				scroll400.setViewportView(casingTable);
				casingTable.setPreferredScrollableViewportSize(new Dimension(580, 80));
				panel101.setLayout(new BoxLayout(panel101, BoxLayout.X_AXIS));
				profileTable.setPreferredSize(new Dimension(580, 80));
				profileTable.setPreferredScrollableViewportSize(new Dimension(580, 80));
				
				scroll100.setViewportView(profileTable);
				setJMenuBar(menuBar);
				
				//��������� �������
				//������� +
				plusProfile.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						plusProfileActionPerformed(e);
					}
				
				});
				//������� -
				minusProfile.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						minusProfileActionPerformed(e);
					}
				
				});
				
				//����������� �������
				calcProfile.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						calcProfileActionPerformed(e);
					}
				});
				
				//���������� ������� +
				plusPrevious.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						plusPreviousActionPerformed(e);
					}
				});
				//���������� ������� -
				minusPrevious.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						minusPreviousActionPerformed(e);
					}
				});
				//�������� ����� + 
				plusOpenhole.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						plusOpenholeActionPerformed(e);
					}
				});
				//�������� ����� -
				minusOpenhole.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						minusOpenholeActionPerformed(e);
					}
				});
				//������������� ������� + 
				plusCasing.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						plusCasingActionPerformed(e);
					}
				});
				//������������� ������� -
				minusCasing.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						minusCasingActionPerformed(e);
					}
				});
				
				
				
				panel1.add(panel10);
				panel1.add(panel20);
				panel1.add(scroll100);
				panel1.add(panel30);
				panel1.add(scroll200);
				panel1.add(panel40);
				panel1.add(scroll300);
				panel1.add(panel50);
				panel1.add(scroll400);
			
				panel10.add(panel100);
				
				panel100.add(label1);
				panel100.add(fieldName);
				panel100.add(label2);
				panel100.add(bushName);
				panel100.add(label3);
				panel100.add(wellNumber);	
				
		scroll1.setViewportView(panel1);
		
		tabPanel.addTab("����������� ��������", scroll1);
		tabPanel.addTab("��������������� ��������", scroll2);
		
		getContentPane().add(tabPanel);
		
		
		
	}
}
