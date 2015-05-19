package ru.alexnov.wellcementing.Tables;

import javax.swing.table.AbstractTableModel;

import ru.alexnov.wellcementing.Geometry;
import ru.alexnov.wellcementing.MainWindow;
import ru.alexnov.wellcementing.Program;

public class PreviousTableModel extends AbstractTableModel {

	@Override
	//���������� �������� � �������
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	//���������� ����� � �������
	public int getRowCount() {
		// TODO Auto-generated method stub
		return MainWindow.index2;
	}
	
	//�������������� �����, ������������ �������� ��������
			public String getColumnName(int colIndex) {
				switch (colIndex){
				case 0:
					return "�� ���������";
				case 1:
					return "�� ������";
				case 2:
					return "�������� �������, �";
				case 3:
					return "������� ������, �";
				}
				return "";
			}
			
	//�������������� �����, ����� ������� ������ ��������������
	public boolean isCellEditable(int rowIndex, int colIndex){
	return true;
			}

	@Override
	public Object getValueAt(int rowIndex, int colIndex) {
		try {
			return Program.previous[rowIndex][colIndex];}
catch (java.lang.NullPointerException e) {return "err";}	
	}
	
	//������ �������� ������� � ������
		public void setValueAt(Object nval, int rowIndex, int colIndex) {
		switch (colIndex){
		//������� �� ���������
		case 0:
				//����������� ������ � �����
				double nval1 = Double.parseDouble(nval.toString());
				//������� ������� �� ������ � ���� �����
				double nval2 = Geometry.findLenght(nval1);
				//���������� ����� �������� �����
				Program.previous[rowIndex][colIndex] = nval1;
				Program.previous[rowIndex][colIndex+1] = nval2;
				//��������� ������ �������
				fireTableCellUpdated(rowIndex, colIndex);
				fireTableCellUpdated(rowIndex, colIndex+1);
				return;
				
		//������� �� ������
		case 1:
			//����������� ������ � �����
			double nval3 = Double.parseDouble(nval.toString());
			//������� ������� �� ��������� � ���� �����
			double nval4 = Geometry.findHeight(nval3);
			//���������� ����� �������� �����
			Program.previous[rowIndex][colIndex] = nval3;
			Program.previous[rowIndex][colIndex-1] = nval4;
			//��������� ������ �������
			fireTableCellUpdated(rowIndex, colIndex);
			fireTableCellUpdated(rowIndex, colIndex-1);
			return;
			
		//�������� ������� �������� �������
		case 2:
			//����������� ������ � �����
			double nval5 = Double.parseDouble(nval.toString());
			//���������� ����� �������� �����
			Program.previous[rowIndex][colIndex] = nval5;
			//��������� ������ �������
			fireTableCellUpdated(rowIndex, colIndex);
			return;
		//������� ������
		case 3:
			//����������� ������ � �����
			double nval6 = Double.parseDouble(nval.toString());
			//���������� ����� �������� �����
			Program.previous[rowIndex][colIndex] = nval6;
			//��������� ������ �������
			fireTableCellUpdated(rowIndex, colIndex);
			return;
		}
		}

}
