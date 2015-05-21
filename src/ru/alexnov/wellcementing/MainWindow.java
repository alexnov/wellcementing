package ru.alexnov.wellcementing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
	
	public static int index = 1;//профиль
	public static int index2 = 1;//предыдущая колонна
	public static int index3 = 1;//открытый ствол
	public static int index4 = 1;//цементируемая колонна
	public static int index5 = 1;//цементы
	
	//создаем экземпляр профиля
	ProfileTableModel profileSample = new ProfileTableModel();
	//создаем экземпляр данных по предыдущим колоннам
	PreviousTableModel previousSample = new PreviousTableModel();
	//создаем экземпляр данных по открытому стволу
	OpenHoleTableModel openholeSample = new OpenHoleTableModel();
	//создаем экземпляр данных по цементируемой колонне
	CementingCasingTableModel casingSample = new CementingCasingTableModel();
	
	//Обработка нажатия клавиши + - добавляем единицу к счетчику и обновляем таблицу профиля
	private void plusProfileActionPerformed(ActionEvent e) {
		index = index+1;
		profileSample.fireTableStructureChanged();
	}
	//Обработка нажатия клавиши "-" - обнуляем последнюю строку
		//отнимаем единицу от счетчика и обновляем таблицу профиля
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
JOptionPane.showMessageDialog(scroll1, "Первую строку нельзя удалить", "Ошибка", JOptionPane.ERROR_MESSAGE);
			}
		}
		//Кнопка запуска калькулятора профиля
		private void calcProfileActionPerformed(ActionEvent e){
			ProfileCalcucator calc = new ProfileCalcucator();
			calc.setVisible(true);
		}
		//Обработка нажатия клавиши + - добавляем единицу к счетчику и обновляем таблицу предыдущей колонны
		private void plusPreviousActionPerformed(ActionEvent e){
			index2 = index2+1;
			previousSample.fireTableStructureChanged();
		}
		//Обработка нажатия клавиши "-" - обнуляем последнюю строку
				//отнимаем единицу от счетчика и обновляем таблицу предыдущей колонны
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
JOptionPane.showMessageDialog(scroll1, "Первую строку нельзя удалить", "Ошибка", JOptionPane.ERROR_MESSAGE);
			}
		}
		//Обработка нажатия клавиши + - добавляем единицу к счетчику и обновляем таблицу открытого ствола
		private void plusOpenholeActionPerformed(ActionEvent e){
			index3 = index3+1;
			openholeSample.fireTableStructureChanged();
		}
		//Обработка нажатия клавиши "-" - обнуляем последнюю строку
		//отнимаем единицу от счетчика и обновляем таблицу открытого ствола
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
JOptionPane.showMessageDialog(scroll1, "Первую строку нельзя удалить", "Ошибка", JOptionPane.ERROR_MESSAGE);
		}
		}
		//Обработка нажатия клавиши + - добавляем единицу к счетчику и обновляем таблицу цементируемой колонны
				private void plusCasingActionPerformed(ActionEvent e){
					index4 = index4+1;
					casingSample.fireTableStructureChanged();
				}
				//Обработка нажатия клавиши "-" - обнуляем последнюю строку
				//отнимаем единицу от счетчика и обновляем таблицу цементируемой колонны
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
JOptionPane.showMessageDialog(scroll1, "Первую строку нельзя удалить", "Ошибка", JOptionPane.ERROR_MESSAGE);
								}
				}
		
		JTabbedPane tabPanel = new JTabbedPane();
	    JScrollPane scroll1 = new JScrollPane();
		JScrollPane scroll2 = new JScrollPane();
		JPanel panel10 = new JPanel();
		JPanel panel100 = new JPanel();
		JLabel label1 = new JLabel("Месторождение");
		JLabel label2 = new JLabel("Куст");
		JLabel label3 = new JLabel("Скважина");
		JTextField fieldName = new JTextField();
		JTextField bushName = new JTextField();
		JTextField wellNumber = new JTextField();
		JPanel panel1 = new JPanel();
		JPanel panel200 = new JPanel();
		JLabel label4 = new JLabel("Профиль скважины");
		JPanel panel201 = new JPanel();
		JButton calcProfile = new JButton("Калькулятор");
		JButton plusProfile = new JButton("+");
		JButton minusProfile = new JButton("-");
		JPanel panel20 = new JPanel();
		JPanel panel300 = new JPanel();
		JLabel label5 = new JLabel("Предыдущая колонна");
		JPanel panel301 = new JPanel();
		JButton plusPrevious = new JButton("+");
		JButton minusPrevious = new JButton("-");
		JPanel panel30 = new JPanel();
		JScrollPane scroll200 = new JScrollPane();
		JTable previousTable = new JTable(previousSample);
		JPanel panel400 = new JPanel();
		JLabel label6 = new JLabel("Открытый ствол");
		JPanel panel401 = new JPanel();
		JButton plusOpenhole = new JButton("+");
		JButton minusOpenhole = new JButton("-");
		JPanel panel40 = new JPanel();
		JScrollPane scroll300 = new JScrollPane();
		JTable openholeTable = new JTable(openholeSample);
		JPanel panel500 = new JPanel();
		JLabel label7 = new JLabel("Цементируемая колонна");
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
		//Меню
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem openItem = new JMenuItem("Open");
		JMenuItem saveItem = new JMenuItem("Save");
		JMenuItem saveasItem = new JMenuItem("Save As...");
	
	public MainWindow(){
		
		super("Ввод исходных данных");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(620, 650);
		//Собираем меню
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
				//Панель с надписью профиль скважины
				panel200.setLayout(new FlowLayout(FlowLayout.LEFT));
				panel200.add(label4);
				//Панель с тремя кнопками - для таблицы и конструктор
				panel201.setLayout(new FlowLayout(FlowLayout.RIGHT));
				panel201.add(calcProfile);
				panel201.add(minusProfile);
				panel201.add(plusProfile);
				//Объединяем две панели в одной
				panel20.setLayout(new BoxLayout(panel20, BoxLayout.X_AXIS));
				panel20.add(panel200);
				panel20.add(panel201);
				//Панель с надписью предыдущая колонна
				panel300.setLayout(new FlowLayout(FlowLayout.LEFT));
				panel300.add(label5);
				//Панель с двумя кнопками - для таблицы предыдущей колонны
				panel301.setLayout(new FlowLayout(FlowLayout.RIGHT));
				panel301.add(minusPrevious);
				panel301.add(plusPrevious);
				//Объединяем две панели в одной
				panel30.setLayout(new BoxLayout(panel30, BoxLayout.X_AXIS));
				panel30.add(panel300);
				panel30.add(panel301);
				//Таблица для предыдущей колонны
				previousTable.setPreferredSize(new Dimension(580, 80));
				scroll200.setViewportView(previousTable);
				previousTable.setPreferredScrollableViewportSize(new Dimension(580, 80));
				//Панель с надписью открытый ствол
				panel400.setLayout(new FlowLayout(FlowLayout.LEFT));
				panel400.add(label6);
				//Панель с двумя кнопками - для таблицы открытого ствола
				panel401.setLayout(new FlowLayout(FlowLayout.RIGHT));
				panel401.add(minusOpenhole);
				panel401.add(plusOpenhole);
				//Объединяем две панели в одной
				panel40.setLayout(new BoxLayout(panel40, BoxLayout.X_AXIS));
				panel40.add(panel400);
				panel40.add(panel401);
				//Таблица для открытого ствола
				openholeTable.setPreferredSize(new Dimension(580, 80));
				scroll300.setViewportView(openholeTable);
				openholeTable.setPreferredScrollableViewportSize(new Dimension(580, 80));
				//Панель с надписью цементируемая колонна
				panel500.setLayout(new FlowLayout(FlowLayout.LEFT));
				panel500.add(label7);
				//Панель с двумя кнопками - для таблицы цементируемой колонны
				panel501.setLayout(new FlowLayout(FlowLayout.RIGHT));
				panel501.add(minusCasing);
				panel501.add(plusCasing);
				//Объединяем две панели в одно
				panel50.setLayout(new BoxLayout(panel50, BoxLayout.X_AXIS));
				panel50.add(panel500);
				panel50.add(panel501);
				//Таблица для цементируемой колонны
				casingTable.setPreferredSize(new Dimension(580, 80));
				scroll400.setViewportView(casingTable);
				casingTable.setPreferredScrollableViewportSize(new Dimension(580, 80));
				panel101.setLayout(new BoxLayout(panel101, BoxLayout.X_AXIS));
				profileTable.setPreferredSize(new Dimension(580, 80));
				profileTable.setPreferredScrollableViewportSize(new Dimension(580, 80));
				
				scroll100.setViewportView(profileTable);
				setJMenuBar(menuBar);
				
				//Обработка событий
				//Профиль +
				plusProfile.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						plusProfileActionPerformed(e);
					}
				
				});
				//Профиль -
				minusProfile.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						minusProfileActionPerformed(e);
					}
				
				});
				
				//Калькулятор профиля
				calcProfile.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						calcProfileActionPerformed(e);
					}
				});
				
				//Предыдущая колонна +
				plusPrevious.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						plusPreviousActionPerformed(e);
					}
				});
				//Предыдущая колонна -
				minusPrevious.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						minusPreviousActionPerformed(e);
					}
				});
				//Открытый ствол + 
				plusOpenhole.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						plusOpenholeActionPerformed(e);
					}
				});
				//Открытый ствол -
				minusOpenhole.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						minusOpenholeActionPerformed(e);
					}
				});
				//Цементируемая колонна + 
				plusCasing.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						plusCasingActionPerformed(e);
					}
				});
				//Цементируемая колонна -
				minusCasing.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						minusCasingActionPerformed(e);
					}
				});
				//Меню открыть файл
				openItem.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						loadFile();
					}
				});
				//Меню сохранить как файл
				saveasItem.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						saveFile();
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
		
		tabPanel.addTab("Конструкция скважины", scroll1);
		tabPanel.addTab("Технологические жидкости", scroll2);
		
		getContentPane().add(tabPanel);
		
		
		
	}
	//Чтение файла
	private void loadFile(){
		JFileChooser fileload = new JFileChooser();
		FileReader myFile = null; 
		BufferedReader buff = null;
		ArrayList<String> FromFile = new ArrayList<String>();
		int ret = fileload.showOpenDialog(null);
		if (ret == JFileChooser.APPROVE_OPTION){
			//Создаём объект файла
			File fileToLoad = fileload.getSelectedFile();
			try{
				//Объект, позволяющий осуществить чтение из файла
				myFile =  new FileReader(fileToLoad);
				//Буфер для записи
				buff = new BufferedReader(myFile);
				//Считываем файл и записываем в массив
				while (true){
					String line = buff.readLine();
					if (line == null) break;
					FromFile.add(line);
				}
				//Синтаксический разбор файла
				String line1 = FromFile.get(0);
				if (line1.equals("dataofoilorgaswell")){
					//Записываем месторождение
					fieldName.setText(FromFile.get(1));
					//Записываем куст
					bushName.setText(FromFile.get(2));
					//Записываем скважину
					wellNumber.setText(FromFile.get(3));
					//Записываем профиль
					int i = 5;
					int j = 0;
					while (!FromFile.get(i).equals("previous")){
						String oneline[] = FromFile.get(i).split(" ");
						Program.massiv[j][0] = Double.parseDouble(oneline[0]);
						Program.massiv[j][1] = Double.parseDouble(oneline[1]);
						Program.massiv[j][2] = Double.parseDouble(oneline[2]);
						index = index + 1;
						profileSample.fireTableStructureChanged();
						i++;
						j++;
					}
					index = index - 1;
					//Записываем предыдущую колонну
					j = 0; i = i+1;
					while (!FromFile.get(i).equals("openhole")){
					String oneline[] = FromFile.get(i).split(" ");
					Program.previous[j][0] = Double.parseDouble(oneline[0]);
					Program.previous[j][1] = Double.parseDouble(oneline[1]);
					Program.previous[j][2] = Double.parseDouble(oneline[2]);
					Program.previous[j][3] = Double.parseDouble(oneline[3]);
					index2 = index2+1;
					previousSample.fireTableStructureChanged();
					i++;
					j++;
					}
					index2 = index2-1;
					//Записываем открытый ствол
					j = 0; i = i+1;
					while (!FromFile.get(i).equals("casing")){
						String oneline[] = FromFile.get(i).split(" ");
						Program.openhole[j][0] = Double.parseDouble(oneline[0]);
						Program.openhole[j][1] = Double.parseDouble(oneline[1]);
						Program.openhole[j][2] = Double.parseDouble(oneline[2]);
						Program.openhole[j][3] = Double.parseDouble(oneline[3]);
						index3 = index3+1;
						openholeSample.fireTableStructureChanged();
						i++;
						j++;
						}
					index3 = index3-1;
					//Записываем цементируемую колонну
					j=0; i = i+1;
					while (!FromFile.get(i).equals("end")){
						String oneline[] = FromFile.get(i).split(" ");
						Program.casing[j][0] = Double.parseDouble(oneline[0]);
						Program.casing[j][1] = Double.parseDouble(oneline[1]);
						Program.casing[j][2] = Double.parseDouble(oneline[2]);
						Program.casing[j][3] = Double.parseDouble(oneline[3]);
						index4 = index4+1;
						casingSample.fireTableStructureChanged();
						i++;
						j++;
						}
					index4 = index4-1;
					
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Неправильный тип файла");
				}
			}catch (IOException e1) {e1.printStackTrace();
			} finally{
				try {
		             buff.close(); 
		             myFile.close();
			}catch (IOException e2) {e2.printStackTrace();}
			}
		}
	}
	private void saveFile(){}
}
