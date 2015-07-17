package ru.alexnov.wellcementing.Tables;

import javax.swing.table.AbstractTableModel;

import ru.alexnov.wellcementing.Geometry;
import ru.alexnov.wellcementing.MainWindow;
import ru.alexnov.wellcementing.Program;

public class CementingCasingTableModel extends AbstractTableModel {

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return MainWindow.index4;
	}
	//Переопределяем метод, возвращающий названия столбцов
		public String getColumnName(int colIndex) {
			switch (colIndex){
			case 0:
				return "По вертикали, м";
			case 1:
				return "По стволу, м";
			case 2:
				return "Наружный диаметр, м";
			case 3:
				return "Толщина стенки, м";
			}
			return "";
		}
		//Переопределяем метод, чтобы сделать ячейки редактируемыми
		public boolean isCellEditable(int rowIndex, int colIndex){
			return true;
		}

	@Override
	public Object getValueAt(int rowIndex, int colIndex) {
		// TODO Auto-generated method stub
		try {	
			return Program.casing[rowIndex][colIndex];}
catch (java.lang.NullPointerException e) {return "err";}	
	}
	//Запись элемента таблицы в массив
	public void setValueAt(Object nval, int rowIndex, int colIndex){
		switch(colIndex){
		//Глубина по вертикали
		case 0:
			//Преобразуем строку в число
			double nval1 = Double.parseDouble(nval.toString());
			//Находим глубину по стволу в этой точке
			double nval2 = Geometry.findLenght(nval1);
			//Записываем новые значения ячеек
			Program.casing[rowIndex][colIndex] = nval1;
			Program.casing[rowIndex][colIndex+1] = nval2;
			//Обновляем ячейки таблицы
			fireTableCellUpdated(rowIndex, colIndex);
			fireTableCellUpdated(rowIndex, colIndex+1);
			//пересчитываем объем продавки
			MainWindow.prodavka.setText(casingVolume());
			return;
			//Глубина по стволу
		case 1:
			//Преобразуем строку в число
			double nval3 = Double.parseDouble(nval.toString());
			//Находим глубину по вертикали в этой точке
			double nval4 = Geometry.findHeight(nval3);
			//Записываем новые значения ячеек
			Program.casing[rowIndex][colIndex] = nval3;
			Program.casing[rowIndex][colIndex-1] = nval4;
			//Обновляем ячейки таблицы
			fireTableCellUpdated(rowIndex, colIndex);
			fireTableCellUpdated(rowIndex, colIndex-1);
			//пересчитываем объем продавки
			MainWindow.prodavka.setText(casingVolume());
			return;
			//диаметр обсадной колонны
		case 2:
			//Преобразуем строку в число
			double nval5 = Double.parseDouble(nval.toString());
			//Записываем новые значения ячеек
			Program.casing[rowIndex][colIndex] = nval5;
			//Обновляем ячейки таблицы
			fireTableCellUpdated(rowIndex, colIndex);
			//пересчитываем объем продавки
			MainWindow.prodavka.setText(casingVolume());
			return;
			//Толщина стенки
		case 3:
			//Преобразуем строку в число
			double nval6 = Double.parseDouble(nval.toString());
			//Записываем новые значения ячеек
			Program.casing[rowIndex][colIndex] = nval6;
			//Обновляем ячейки таблицы
			fireTableCellUpdated(rowIndex, colIndex);
			//пересчитываем объем продавки
			MainWindow.prodavka.setText(casingVolume());
			return;
		}
		
	}
	
	//Объем обсадной колонны
	public static String casingVolume(){
		//Получаем последний значимый элемент массива
		int last = Geometry.lastCasingElement();
		int i = 0;
		double vol = 0.0;
		while (i<=last){
			//Внутренний диаметр текущего интервала 
			double inner = Program.casing[i][2] - 2.0*Program.casing[i][3];
			//Объем текущего интервала
			if (i==0){
				vol = vol + (Math.PI/4)*inner*inner*Program.casing[i][1];}
			else{
			vol = vol + (Math.PI/4)*inner*inner*(Program.casing[i][1]-Program.casing[i-1][1]);}
			i++;
		}
		double vol1 = (Math.round(vol*100))/100.0;
		return String.valueOf(vol1);
	}


}
