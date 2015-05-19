package ru.alexnov.wellcementing;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Program {
	
	public static double [][] massiv = new double[100][3];
	public static double [][] previous = new double[10][4];
	public static double [][] openhole = new double[10][4];
	public static double [][] casing = new double[10][4];
	static double [][] cements = new double[5][6];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Инициализация массива профиля скважины
				for (int i = 0; i<100; i++){
					for (int j=0; j<3; j++){
						massiv[i][j] = 0.0;
					}
				}
				//Инициализация массива предыдущей колонны
						for (int i = 0; i<10; i++){
							for (int j=0; j<4; j++){
								previous[i][j] = 0.0;
							}
						}
				//Инициализация массива открытого ствола
						for (int i = 0; i<10; i++){
							for (int j=0; j<4; j++){
								openhole[i][j] = 0.0;
							}
						}
						
						//Инициализация массива открытого ствола
						for (int i = 0; i<10; i++){
							for (int j=0; j<4; j++){
								casing[i][j] = 0.0;
							}
						}
						
						//Инициализация цементов
						for (int i = 0; i<5; i++){
							for (int j=0; j<6; j++){
								cements[i][j] = 0.0;
							}
						}
		
						try {
					          // устанавливаем LookAndFeel
							//UIManager.setLookAndFeel("com.seaglasslookandfeel.SeaGlassLookAndFeel");
							//UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
							UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					      } catch (UnsupportedLookAndFeelException e) {
					          System.err.println("Can't use the specified look and feel on this platform.");
					      } catch (Exception e) {
					          System.err.println("Couldn't get specified look and feel, for some reason.");
					      }
						
		JFrame MyWindow = new MainWindow();
		MyWindow.setVisible(true);

	}

}
