package ru.alexnov.wellcementing.Tables;

import javax.swing.table.AbstractTableModel;

import ru.alexnov.wellcementing.MainWindow;
import ru.alexnov.wellcementing.Program;

public class MudsTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return MainWindow.index7;
	}
	
	//Переопределяем метод, возвращающий названия столбцов
	public String getColumnName(int colIndex) {
		switch (colIndex){
		case 0:
			return "Объем порции, м3";
		case 1:
			return "Плотность, кг/м3";
		case 2:
			return "Вязкость, Па*с";
		case 3:
			return "ДНС, Па";
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
		return Program.muds[rowIndex][colIndex];
	}
	
	public void setValueAt(Object nval, int rowIndex, int colIndex){
		double nval1 = Double.parseDouble(nval.toString());
		Program.muds[rowIndex][colIndex] = nval1;
		fireTableCellUpdated(rowIndex, colIndex);
}

}
