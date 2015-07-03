package ru.alexnov.wellcementing.Tables;

import javax.swing.table.AbstractTableModel;

import ru.alexnov.wellcementing.CementsVolume;
import ru.alexnov.wellcementing.MainWindow;
import ru.alexnov.wellcementing.Program;

public class CementsTableModel extends AbstractTableModel {

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return MainWindow.index5;
	}
	
	//Переопределяем метод, возвращающий названия столбцов
	public String getColumnName(int colIndex) {
		switch (colIndex){
		case 0:
			return "От (низ), м";
		case 1:
			return "До (верх), м";
		case 2:
			return "Объем, м3";
		case 3:
			return "Плотность, кг/м3";
		case 4:
			return "Вязкость, Па*с";
		case 5:
			return "ДНС, Па";
		}
		return "";
	}
	
	//Переопределяем метод, чтобы сделать ячейки редактируемыми
	public boolean isCellEditable(int rowIndex, int colIndex){
		switch (colIndex){
		case 0:
			return true;
		case 1:
			return true;
		case 2:
			return false;
		case 3:
			return true;
		case 4:
			return true;
		case 5:
			return true;
		}
		return true;
	}

	@Override
	public Object getValueAt(int rowIndex, int colIndex) {
		// TODO Auto-generated method stub
		return Program.cements[rowIndex][colIndex];
	}
	
	//Запись элемента таблицы в массив
	public void setValueAt(Object nval, int rowIndex, int colIndex) {
		switch (colIndex){
		//Нижняя граница
		case 0:
			//Преобразуем строку в число и записываем его
			double nval1 = Double.parseDouble(nval.toString());
			Program.cements[rowIndex][colIndex] = nval1;
			//Рассчитываем значение объема цемента
Program.cements[rowIndex][colIndex+2] = CementsVolume.calcCementVolume(Program.cements[rowIndex][colIndex+1], nval1);
			//Обновляем ячейки таблицы
			fireTableCellUpdated(rowIndex, colIndex);
			fireTableCellUpdated(rowIndex, colIndex+2);
			return;
		case 1:
			//Преобразуем сроку в число и записываем его
			double nval2 = Double.parseDouble(nval.toString());
			Program.cements[rowIndex][colIndex] = nval2;
			//Рассчитываем значение объема цемента
Program.cements[rowIndex][colIndex+1] = CementsVolume.calcCementVolume(nval2, Program.cements[rowIndex][colIndex-1]);
			//Обновляем ячейки таблицы
			fireTableCellUpdated(rowIndex, colIndex);
			fireTableCellUpdated(rowIndex, colIndex+1);
		}
	}

}
