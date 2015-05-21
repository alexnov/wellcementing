package ru.alexnov.wellcementing.Tables;

import javax.swing.table.AbstractTableModel;

import ru.alexnov.wellcementing.Geometry;
import ru.alexnov.wellcementing.MainWindow;
import ru.alexnov.wellcementing.Program;

public class ProfileTableModel extends AbstractTableModel {

	@Override
	//Количество столбцов в таблице
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 3;
		}

	@Override
	//Количество строк в таблице
		public int getRowCount() {
			// TODO Auto-generated method stub
			return MainWindow.index;
		}

	//Чтение элемента таблицы
	@Override
	public Object getValueAt(int rowIndex, int colIndex) {
		// TODO Auto-generated method stub
		try {	
			return Program.massiv[rowIndex][colIndex];}
catch (java.lang.NullPointerException e) {return "err";}		
}
	
	//Переопределяем метод, чтобы сделать ячейки редактируемыми
		public boolean isCellEditable(int rowIndex, int colIndex){
			return true;
		}
		
		//Переопределяем метод, возвращающий названия столбцов
		public String getColumnName(int colIndex) {
			switch (colIndex){
			case 0:
				return "По вертикали";
			case 1:
				return "Зенитный угол";
			case 2:
				return "По стволу";
			}
			return "";
		}
		
		public void setValueAt(Object nval, int rowIndex, int colIndex) {
			switch (colIndex){
			//Глубина по вертикали
			case 0:
				
				//Проверяем, является ли строка первой
				if (rowIndex == 0){
									//Преобразуем строку в число
					double nval1 = Double.parseDouble(nval.toString());
					//Записываем новое значение ячейки
					Program.massiv[rowIndex][colIndex] = nval1;
					Program.massiv[rowIndex][colIndex+2] = nval1;
				}
				else {
					//Преобразуем вводимое значение в строку
					String nv = nval.toString();
					//Преобразуем строку в число
					double nval1 = Double.parseDouble(nv);
					//Записываем новое значение ячейки
					Program.massiv[rowIndex][colIndex] = nval1;
					Geometry.CompareAngle(rowIndex);
				};
				
				
				//обновляем ячейки таблицы
				fireTableCellUpdated(rowIndex, colIndex);
				fireTableCellUpdated(rowIndex, colIndex+2);
				return;
			case 1:
				String nv1 = nval.toString();
				double nval2 = Double.parseDouble(nv1);
				Program.massiv[rowIndex][colIndex] = nval2;
				Geometry.CompareAngle(rowIndex);
				fireTableCellUpdated(rowIndex, colIndex);
				return;
			case 2:
			}
				
			}
	

}
