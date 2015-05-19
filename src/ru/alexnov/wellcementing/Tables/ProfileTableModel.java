package ru.alexnov.wellcementing.Tables;

import javax.swing.table.AbstractTableModel;

import ru.alexnov.wellcementing.Geometry;
import ru.alexnov.wellcementing.MainWindow;
import ru.alexnov.wellcementing.Program;

public class ProfileTableModel extends AbstractTableModel {

	@Override
	//���������� �������� � �������
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 3;
		}

	@Override
	//���������� ����� � �������
		public int getRowCount() {
			// TODO Auto-generated method stub
			return MainWindow.index;
		}

	//������ �������� �������
	@Override
	public Object getValueAt(int rowIndex, int colIndex) {
		// TODO Auto-generated method stub
		try {	
			return Program.massiv[rowIndex][colIndex];}
catch (java.lang.NullPointerException e) {return "err";}		
}
	
	//�������������� �����, ����� ������� ������ ��������������
		public boolean isCellEditable(int rowIndex, int colIndex){
			return true;
		}
		
		//�������������� �����, ������������ �������� ��������
		public String getColumnName(int colIndex) {
			switch (colIndex){
			case 0:
				return "�� ���������";
			case 1:
				return "�������� ����";
			case 2:
				return "�� ������";
			}
			return "";
		}
		
		public void setValueAt(Object nval, int rowIndex, int colIndex) {
			switch (colIndex){
			//������� �� ���������
			case 0:
				
				//���������, �������� �� ������ ������
				if (rowIndex == 0){
									//����������� ������ � �����
					double nval1 = Double.parseDouble(nval.toString());
					//���������� ����� �������� ������
					Program.massiv[rowIndex][colIndex] = nval1;
					Program.massiv[rowIndex][colIndex+2] = nval1;
				}
				else {
					//����������� �������� �������� � ������
					String nv = nval.toString();
					//����������� ������ � �����
					double nval1 = Double.parseDouble(nv);
					//���������� ����� �������� ������
					Program.massiv[rowIndex][colIndex] = nval1;
					Geometry.CompareAngle(rowIndex);
				};
				
				
				//��������� ������ �������
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
