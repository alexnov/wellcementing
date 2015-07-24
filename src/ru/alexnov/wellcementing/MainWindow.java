package ru.alexnov.wellcementing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ru.alexnov.wellcementing.Tables.CementingCasingTableModel;
import ru.alexnov.wellcementing.Tables.CementsTableModel;
import ru.alexnov.wellcementing.Tables.MudsTableModel;
import ru.alexnov.wellcementing.Tables.OpenHoleTableModel;
import ru.alexnov.wellcementing.Tables.PreviousTableModel;
import ru.alexnov.wellcementing.Tables.ProfileTableModel;
import ru.alexnov.wellcementing.Tables.SpacersTableModel;

public class MainWindow extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int index = 1;//профиль
	public static int index2 = 1;//предыдущая колонна
	public static int index3 = 1;//открытый ствол
	public static int index4 = 1;//цементируемая колонна
	public static int index5 = 1;//цементы
	public static int index6 = 1;//буферы
	public static int index7 = 1;//буферы
	
	//создаем экземпляр профиля
	ProfileTableModel profileSample = new ProfileTableModel();
	//создаем экземпляр данных по предыдущим колоннам
	PreviousTableModel previousSample = new PreviousTableModel();
	//создаем экземпляр данных по открытому стволу
	OpenHoleTableModel openholeSample = new OpenHoleTableModel();
	//создаем экземпляр данных по цементируемой колонне
	CementingCasingTableModel casingSample = new CementingCasingTableModel();
	//экземпляр данных по буферным жидкостям
	SpacersTableModel spacersSample = new SpacersTableModel();
	//экземпляр данных по цементным растворам
	CementsTableModel cementsSample = new CementsTableModel();
	//экземпляр данных по продавке
	MudsTableModel mudsSample = new MudsTableModel();
	
	//Обработка нажатия клавиши + - добавляем единицу к счетчику и обновляем таблицу профиля
	private void plusProfileActionPerformed(ActionEvent e) {
		index = index+1;
		profileSample.fireTableStructureChanged();
	}
	//Обработка нажатия клавиши "-" - обнуляем последнюю строку
		//отнимаем единицу от счетчика и обновляем таблицу профиля
		private void minusProfileActionPerformed(ActionEvent e) {
			// TODO add your code here
			if (index >1){
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
			if (index2 >1){
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
			if (index3 >1){
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
					if (index4 >1){	
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
				//Обработка нажатия клавиши + - добавляем единицу к счетчику и обновляем таблицу буферов
				private void plusSpacersActionPerformed(ActionEvent e) {
					if (index6>4){
JOptionPane.showMessageDialog(scroll1, "Максимальное количество порций - 5", "Ошибка", JOptionPane.ERROR_MESSAGE);						
					}
					else{
					index6 = index6+1;
					spacersSample.fireTableStructureChanged();}
				}
				//Обработка нажатия клавиши "-" - обнуляем последнюю строку
				//отнимаем единицу от счетчика и обновляем таблицу буфера
				private void minusSpacersActionPerformed(ActionEvent e){
					if (index6>1){
						Program.spacers[index6-1][0] = 0.0;
						Program.spacers[index6-1][1] = 0.0;
						Program.spacers[index6-1][2] = 0.0;
						Program.spacers[index6-1][3] = 0.0;
						index6 = index6-1;
						spacersSample.fireTableStructureChanged();
					}
					else{
JOptionPane.showMessageDialog(scroll1, "Первую строку нельзя удалить", "Ошибка", JOptionPane.ERROR_MESSAGE);						
					}
				}
				//Обработка нажатия клавиши + - добавляем единицу к счетчику и обновляем таблицу цементов
				private void plusCementActionPerformed(ActionEvent e) {
					if (index5>4){
JOptionPane.showMessageDialog(pan22, "Максимальное количество порций - 5", "Ошибка", JOptionPane.ERROR_MESSAGE);						
					}
					else{
					index5 = index5+1;
					cementsSample.fireTableStructureChanged();}
				}
				//Обработка нажатия клавиши "-" - обнуляем последнюю строку
				//отнимаем единицу от счетчика и обновляем таблицу цементов
				private void minusCementActionPerformed(ActionEvent e){
					if (index5>1){
						Program.cements[index5-1][0] = 0.0;
						Program.cements[index5-1][1] = 0.0;
						Program.cements[index5-1][2] = 0.0;
						Program.cements[index5-1][3] = 0.0;
						index5 = index5-1;
						cementsSample.fireTableStructureChanged();
					}
					else{
JOptionPane.showMessageDialog(pan22, "Первую строку нельзя удалить", "Ошибка", JOptionPane.ERROR_MESSAGE);						
					}
				}
				//Обработка нажатия клавиши + - добавляем единицу к счетчику и обновляем таблицу продавки
				private void plusMudsActionPerformed(ActionEvent e) {
					if (index7>4){
JOptionPane.showMessageDialog(pan22, "Максимальное количество порций - 5", "Ошибка", JOptionPane.ERROR_MESSAGE);						
					}
					else{
					index7 = index7+1;
					mudsSample.fireTableStructureChanged();}
				}
				//Обработка нажатия клавиши "-" - обнуляем последнюю строку
				//отнимаем единицу от счетчика и обновляем таблицу продавки
				private void minusMudsActionPerformed(ActionEvent e){
					if (index7>1){
						Program.muds[index7-1][0] = 0.0;
						Program.muds[index7-1][1] = 0.0;
						Program.muds[index7-1][2] = 0.0;
						Program.muds[index7-1][3] = 0.0;
						index7 = index7-1;
						mudsSample.fireTableStructureChanged();
					}
					else{
JOptionPane.showMessageDialog(pan22, "Первую строку нельзя удалить", "Ошибка", JOptionPane.ERROR_MESSAGE);						
					}
				}
				//Чекбокс
				private void muditemStateChanged(ItemEvent e){
					if (mudnomud.isSelected()){
					plusMud.setEnabled(false);
					minusMud.setEnabled(false);
					Program.muds[index7-1][1] = Double.parseDouble(mudW.getText());
					Program.muds[index7-1][2] = Double.parseDouble(mudV.getText());
					Program.muds[index7-1][3] = Double.parseDouble(mudY.getText());
					Program.muds[index7-1][0] = Double.parseDouble(prodavka.getText());
					mudsSample.fireTableDataChanged();
					}
					else {
						plusMud.setEnabled(true);
						minusMud.setEnabled(true);
					}
				}
				//Поле плотности бурового раствора
				DocumentListener mudprodW = new DocumentListener(){
					public void removeUpdate(DocumentEvent event){
						if (mudnomud.isSelected()){
							Program.muds[index7-1][1] = Double.parseDouble(mudW.getText());
							mudsSample.fireTableDataChanged();
						}
					}
					public void insertUpdate(DocumentEvent event){
						if (mudnomud.isSelected()){
							Program.muds[index7-1][1] = Double.parseDouble(mudW.getText());
							mudsSample.fireTableDataChanged();
						}
					}
					public void changedUpdate(DocumentEvent event){}
				};
				//Поле вязкости бурового раствора
				DocumentListener mudprodV = new DocumentListener(){
					public void removeUpdate(DocumentEvent event){
						if (mudnomud.isSelected()){
							Program.muds[index7-1][2] = Double.parseDouble(mudV.getText());
							mudsSample.fireTableDataChanged();
						}
					}
					public void insertUpdate(DocumentEvent event){
						if (mudnomud.isSelected()){
							Program.muds[index7-1][2] = Double.parseDouble(mudV.getText());
							mudsSample.fireTableDataChanged();
						}
					}
					public void changedUpdate(DocumentEvent event){}
				};
				//Поле ДНС бурового раствора
				DocumentListener mudprodY = new DocumentListener(){
					public void removeUpdate(DocumentEvent event){
						if (mudnomud.isSelected()){
							Program.muds[index7-1][3] = Double.parseDouble(mudY.getText());
							mudsSample.fireTableDataChanged();
						}
					}
					public void insertUpdate(DocumentEvent event){
						if (mudnomud.isSelected()){
							Program.muds[index7-1][3] = Double.parseDouble(mudY.getText());
							mudsSample.fireTableDataChanged();
						}
					}
					public void changedUpdate(DocumentEvent event){}
				};
		
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
		JTable previousTable = new JTable(previousSample);
		JPanel panel400 = new JPanel();
		JLabel label6 = new JLabel("Открытый ствол");
		JPanel panel401 = new JPanel();
		JButton plusOpenhole = new JButton("+");
		JButton minusOpenhole = new JButton("-");
		JPanel panel40 = new JPanel();
		JTable openholeTable = new JTable(openholeSample);
		JPanel panel500 = new JPanel();
		JLabel label7 = new JLabel("Цементируемая колонна");
		JLabel label8 = new JLabel("Объем продавки");
		JLabel label9 = new JLabel("м3");
		public static JLabel prodavka = new JLabel("0.0");
		JPanel panel501 = new JPanel();
		JPanel panel502 = new JPanel();
		JButton plusCasing = new JButton("+");
		JButton minusCasing = new JButton("-");
		JPanel panel50 = new JPanel();
		
		JTable casingTable = new JTable(casingSample);
		JPanel panel101 = new JPanel();
		JTable profileTable = new JTable(profileSample);
		JOptionPane message = new JOptionPane();
		//Меню
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("Файл");
		JMenuItem openItem = new JMenuItem("Открыть");
		JMenuItem saveItem = new JMenuItem("Сохранить");
		JMenuItem saveasItem = new JMenuItem("Сохранить как...");
		JMenu aboutMenu = new JMenu("Помощь");
		JMenuItem aboutItem = new JMenuItem("О программе");
		//Вкладка "Технологические жидкости"
		//Главная панель
		JPanel pan = new JPanel();
		//Четыре вложенные панели
		JPanel boxPan[] = new JPanel[4];
		//Семь надписей
		JLabel labels[] = new JLabel[7];
		//Надписи
		String labs[] = {"Буровой раствор",
		"Плотность, кг/м3",
		"Пластическая вязкость, Па*с",
		"Динамическое напряжение сдвига, Па",
		"Буферные жидкости",
		"Тампонажные растворы",
		"Продавочная жидкость"
		};
		//Четыре панели, вложенные в boxPan[0]
		JPanel boxPan0[] = new JPanel[4];
		//Текстовые поля
		JTextField mudW = new JTextField("0.0");
		JTextField mudV = new JTextField("0.0");
		JTextField mudY = new JTextField("0.0");
		//Панели буферной жидкости
		JPanel pan11 = new JPanel();
		JPanel pan12 = new JPanel();
		JPanel pan111 = new JPanel();
		JPanel pan112 = new JPanel();
		//Панели цементного раствора
		JPanel pan21 = new JPanel();
		JPanel pan22 = new JPanel();
		JPanel pan211 = new JPanel();
		JPanel pan212 = new JPanel();
		//Панели продавочной жидкости
		JPanel pan31 = new JPanel();
		JPanel pan32 = new JPanel();
		JPanel pan321 = new JPanel();
		JPanel pan322 = new JPanel();
		JPanel pan33 = new JPanel();
		//Кнопки
		JButton plusSpacer = new JButton("+");
		JButton minusSpacer = new JButton("-");
		JButton plusCement = new JButton("+");
		JButton minusCement = new JButton("-");
		JButton plusMud = new JButton("+");
		JButton minusMud = new JButton("-");
		//таблицы
		JTable spacerTable = new JTable(spacersSample);
		JTable cementTable = new JTable(cementsSample);
		JTable mudTable = new JTable(mudsSample);
		//переключатель
		JCheckBox mudnomud = new JCheckBox("Использовать в качестве продавочной жидкости буровой раствор");
		
	public MainWindow(){
		
		super("Ввод исходных данных");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(620, 650);
		//Собираем меню
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(saveasItem);
		aboutMenu.add(aboutItem);
		menuBar.add(fileMenu);
		menuBar.add(aboutMenu);
		
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
				JScrollPane scroll200 = new JScrollPane(previousTable);
				
				previousTable.setPreferredScrollableViewportSize(new Dimension(580, 70));
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
				JScrollPane scroll300 = new JScrollPane(openholeTable);
				
				openholeTable.setPreferredScrollableViewportSize(new Dimension(580, 70));
				//Панель с надписью цементируемая колонна
				panel500.setLayout(new FlowLayout(FlowLayout.LEFT));
				panel500.add(label7);
				//Панель с двумя кнопками - для таблицы цементируемой колонны
				panel501.setLayout(new FlowLayout(FlowLayout.RIGHT));
				panel501.add(minusCasing);
				panel501.add(plusCasing);
				//Панель с объемом продавки
				panel502.setLayout(new FlowLayout(FlowLayout.CENTER));
				prodavka.setPreferredSize(new Dimension(50,20));
				prodavka.setHorizontalAlignment(SwingConstants.CENTER);
				panel502.add(label8);
				panel502.add(prodavka);
				panel502.add(label9);
				//Объединяем две панели в одно
				panel50.setLayout(new BoxLayout(panel50, BoxLayout.X_AXIS));
				panel50.add(panel500);
				panel50.add(panel501);
				//Таблица для цементируемой колонны
				JScrollPane scroll400 = new JScrollPane(casingTable);
				
				
				casingTable.setPreferredScrollableViewportSize(new Dimension(580, 70));
				panel101.setLayout(new BoxLayout(panel101, BoxLayout.X_AXIS));
				
				profileTable.setPreferredScrollableViewportSize(new Dimension(580, 70));
				
				//Вторая вкладка
				pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));
				for (int i9=0; i9<4; i9++){
					boxPan[i9] = new JPanel();
					boxPan[i9].setLayout(new BoxLayout(boxPan[i9], BoxLayout.Y_AXIS));
				};
				for (int i9=0; i9<4; i9++){
					boxPan0[i9] = new JPanel();
					boxPan0[i9].setLayout(new FlowLayout(FlowLayout.LEADING));
				};
				for (int i9=0; i9<7; i9++){
					labels[i9] = new JLabel(labs[i9]);
				};
				labels[1].setPreferredSize(new Dimension(195,20));
				labels[2].setPreferredSize(new Dimension(195,20));
				mudW.setPreferredSize(new Dimension(50,20));
				mudV.setPreferredSize(new Dimension(50,20));
				mudY.setPreferredSize(new Dimension(50,20));
				//Буферные жидкости
				pan11.setLayout(new BoxLayout(pan11, BoxLayout.X_AXIS));
				pan12.setLayout(new BoxLayout(pan12, BoxLayout.X_AXIS));
				pan111.setLayout(new FlowLayout(FlowLayout.LEFT));
				pan112.setLayout(new FlowLayout(FlowLayout.RIGHT));
				pan111.add(labels[4]);
				pan112.add(minusSpacer);
				pan112.add(plusSpacer);
				pan11.add(pan111);
				pan11.add(pan112);
				JScrollPane scroll21 = new JScrollPane(spacerTable);
				spacerTable.setPreferredScrollableViewportSize(new Dimension(570, 90));
				pan12.add(scroll21);
				
				//Тампонажные растворы
				pan21.setLayout(new BoxLayout(pan21, BoxLayout.X_AXIS));
				pan22.setLayout(new BoxLayout(pan22, BoxLayout.X_AXIS));
				pan211.setLayout(new FlowLayout(FlowLayout.LEFT));
				pan212.setLayout(new FlowLayout(FlowLayout.RIGHT));
				pan211.add(labels[5]);
				pan212.add(minusCement);
				pan212.add(plusCement);
				pan21.add(pan211);
				pan21.add(pan212);
				JScrollPane scroll22 = new JScrollPane(cementTable);
				cementTable.setPreferredScrollableViewportSize(new Dimension(570, 90));
				pan22.add(scroll22);
				//Продавочная жидкость
				pan31.setLayout(new FlowLayout(FlowLayout.CENTER));
				pan32.setLayout(new BoxLayout(pan32, BoxLayout.X_AXIS));
				pan321.setLayout(new FlowLayout(FlowLayout.LEFT));
				pan322.setLayout(new FlowLayout(FlowLayout.RIGHT));
				pan321.add(labels[6]);
				pan322.add(minusMud);
				pan322.add(plusMud);
				pan31.add(mudnomud);
				pan32.add(pan321);
				pan32.add(pan322);
				JScrollPane scroll23 = new JScrollPane(mudTable);
				mudTable.setPreferredScrollableViewportSize(new Dimension(570, 90));
				pan33.add(scroll23);
				
		
				
				
				JScrollPane scroll100 = new JScrollPane(profileTable);
				profileTable.setPreferredScrollableViewportSize(new Dimension(580, 70));
				
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
				//Буферы +
				plusSpacer.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						plusSpacersActionPerformed(e);
					}
				});
				//Буферы -
				minusSpacer.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						minusSpacersActionPerformed(e);
					}
				});
				//Цементы +
				plusCement.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						plusCementActionPerformed(e);
					}
				});
				//Цементы -
				minusCement.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						minusCementActionPerformed(e);
					}
				});
				//Продавки +
				plusMud.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						plusMudsActionPerformed(e);
					}
				});
				//Продавки -
				minusMud.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						minusMudsActionPerformed(e);
					}
				});
				//Чекбокс
				mudnomud.addItemListener(new ItemListener(){
					public void itemStateChanged(ItemEvent e){
						muditemStateChanged(e);
					}
				});
				//Поле плотности бурового раствора
				mudW.getDocument().addDocumentListener(mudprodW);
				//Поле вязкости бурового раствора
				mudV.getDocument().addDocumentListener(mudprodV);
				//Поле ДНС бурового раствора
				mudY.getDocument().addDocumentListener(mudprodY);
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
				//Меню about
				aboutItem.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						About ab = new About();
						ab.setVisible(true);
						ab.setSize(new Dimension(300, 250));
						ab.setResizable(false);
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
				panel1.add(panel502);
				panel1.add(scroll400);
			
				panel10.add(panel100);
				
				panel100.add(label1);
				panel100.add(fieldName);
				panel100.add(label2);
				panel100.add(bushName);
				panel100.add(label3);
				panel100.add(wellNumber);	
				
		boxPan0[0].add(labels[0]);
		boxPan0[1].add(labels[1]);
		boxPan0[1].add(mudW);
		boxPan0[2].add(labels[2]);
		boxPan0[2].add(mudV);
		boxPan0[3].add(labels[3]);
		boxPan0[3].add(mudY);
		boxPan[0].add(boxPan0[0]);
		boxPan[0].add(boxPan0[1]);
		boxPan[0].add(boxPan0[2]);
		boxPan[0].add(boxPan0[3]);
		boxPan[1].add(pan11);
		boxPan[1].add(pan12);
		boxPan[2].add(pan21);
		boxPan[2].add(pan22);
		boxPan[3].add(pan31);
		boxPan[3].add(pan32);
		boxPan[3].add(pan33);
		pan.add(boxPan[0]);
		pan.add(boxPan[1]);
		pan.add(boxPan[2]);
		pan.add(boxPan[3]);
				
		scroll1.setViewportView(panel1);
		scroll2.setViewportView(pan);
		
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
						prodavka.setText(CementingCasingTableModel.casingVolume());
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
	private void saveFile(){
		JFileChooser filesave = new JFileChooser();
		FileWriter myFile = null; 
		BufferedWriter buff = null; 
		int ret = filesave.showSaveDialog(null);
		if (ret == JFileChooser.APPROVE_OPTION) {
			//Создаём объект файла
			File fileToSave = filesave.getSelectedFile();
			try{
				//Объект, позволяющий осуществить запись в файл
				myFile =  new FileWriter(fileToSave);
				//Буфер для записи
				buff = new BufferedWriter(myFile);
				//Записываем первую строку для идентификации формата файла
				buff.write("dataofoilorgaswell");
				buff.newLine();
				//Записываем название месторождения
				buff.write(fieldName.getText());
				buff.newLine();
				//Записываем номер куста
				buff.write(bushName.getText());
				buff.newLine();
				//Записываем номер скважины
				buff.write(wellNumber.getText());
				buff.newLine();
				//Записываем метку для профиля
				buff.write("profile");
				buff.newLine();
				//Получаем последний значимый элемент массива профиля
				int last = Geometry.lastElement();
				//Считываем массив, конвертируем в строки и записываем в файл
				for (int i = 0; i<last+1; i++){
					for (int j=0; j<3; j++){
						Double unit = (Double) Program.massiv[i][j];
						String unit2 = unit.toString() + " ";
						buff.write(unit2);
					}
					buff.newLine();
				}
				//Записываем метку для предыдущей колонны
				buff.write("previous");
				buff.newLine();
				//Получаем последний значимый элемент массива предыдущей колонны
				last = Geometry.lastPreviousElement();
				//Считываем массив, конвертируем в строки и записываем в файл
				for (int i = 0; i<last+1; i++){
					for (int j=0; j<4; j++){
						Double unit = (Double) Program.previous[i][j];
						String unit2 = unit.toString() + " ";
						buff.write(unit2);
					}
					buff.newLine();
				}
				//Записываем метку для открытого ствола
				buff.write("openhole");
				buff.newLine();
				//Получаем последний значимый элемент массива открытого ствола
				last = Geometry.lastOpenholeElement();
				//Считываем массив, конвертируем в строки и записываем в файл
				for (int i = 0; i<last+1; i++){
					for (int j=0; j<4; j++){
						Double unit = (Double) Program.openhole[i][j];
						String unit2 = unit.toString() + " ";
						buff.write(unit2);
					}
					buff.newLine();
				}
				
				//Записываем метку для цементируемой колонны
				buff.write("casing");
				buff.newLine();
				//Получаем последний значимый элемент массива цементируемой колонны
				last = Geometry.lastCasingElement();
				for (int i = 0; i<last+1; i++){
					for (int j=0; j<4; j++){
						Double unit = (Double) Program.casing[i][j];
						String unit2 = unit.toString() + " ";
						buff.write(unit2);
					}
					buff.newLine();
				}
				//Записываем метку для плотности бурового раствора
				buff.write("mud_weight");
				buff.newLine();
				buff.write(mudW.getText());
				buff.newLine();
				//Записываем метку для вязкости бурового раствора
				buff.write("mud_visc");
				buff.newLine();
				buff.write(mudV.getText());
				//Записываем метку для ДНС бурового раствора
				buff.write("mud_yeld");
				buff.newLine();
				buff.write(mudY.getText());
				buff.newLine();
				//Записываем метку для буферных жидкостей
				buff.write("spacers");
				for (int i=0; i<5; i++){
					for (int j=0; j<4; j++){
						Double unit = (Double) Program.spacers[i][j];
						String unit2 = unit.toString() + " ";
						buff.write(unit2);
					}
					buff.newLine();
				}
				//Записываем временную метку конца файла
				buff.write("end");
			}catch (IOException e1) {e1.printStackTrace();
			} finally {
		    	try {
		    		 buff.flush(); 
		             buff.close(); 
		             myFile.close();
		    	} catch (IOException e2) {e2.printStackTrace();}
			}
		}
	}
}
