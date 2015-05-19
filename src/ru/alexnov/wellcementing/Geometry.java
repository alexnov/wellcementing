package ru.alexnov.wellcementing;

public class Geometry {
	
	//������ ����� �������, �� ������� ���������� ��������� ��������� ����
		//z1, z2 - ��������� � �������� �������� ����
		//h1, h2 - ������� �� ��������� ������ � ����� �������
		public static double round_lenght(double z1, double z2, double h1, double h2){
			double l = (Math.abs(z1-z2)*(h2-h1))/(Math.abs(Math.sin(z1*3.14/180)-Math.sin(z2*3.14/180))*57.296);
			return l;
		}
		
		//������ ����� ��������������� �������
		//z - �������� ����
		//h1, h2 - ������� �� ��������� ������ � ����� �������
		public static double str_lenght(double z, double h1, double h2){
			double l = (h2-h1)/Math.cos(z*3.14/180);
			return l;
		}
		
		//������ ������ ������� � ���������� ��������� ����
		//z1, z2 - ��������� � �������� �������� ����
		//l1, l2 - ����� ������ � ����� �������
		public static double round_height(double z1, double z2, double l1, double l2){
			double h = (57.296*(l2-l1)*Math.abs(Math.sin(z1*3.14/180)-Math.sin(z2*3.14/180)))/Math.abs(z2-z1);
			return h;
		}
		//������ ������ ��������������� �������
		//l1, l2 - ����� ������ � ����� �������
		//z - �������� ����
		public static double str_height(double l1, double l2, double z){
			double h = (l2-l1)*Math.cos(z*3.14/180);
			return h;
		}
		
		//����� ��� ������� ����� �� ������ � �������, ���� ���������� �������� ����
		public static void CalcRoundLenght(int RowIndex){
			//����������� �������� ����������
			//�������� ���� � ������ �������
			double z1 = Program.massiv[RowIndex-1][1];
			//�������� ���� � ����� �������
			double z2 = Program.massiv[RowIndex][1];
			//������� �� ��������� ������ �������
			double h1 = Program.massiv[RowIndex-1][0];
			//������� �� ��������� ����� �������
			double h2 = Program.massiv[RowIndex][0];
			//������ ����� �������
			double rez = round_lenght(z1, z2, h1, h2);
			//c�������� � ������ ����������� �������
			double finalrez = rez + Program.massiv[RowIndex-1][2];
			//�������������� ������� ������� �������
			Program.massiv[RowIndex][2] = (Math.round(finalrez*100))/100.0;
			return;
		}
		
		//����� ��� ������� ����� �� ������ � �������, ��� ���������� �������� ����
		public static void StraightLenght(int RowIndex){
			//����������� �������� ����������
					//�������� ����
					double z = Program.massiv[RowIndex-1][1];
					//������� �� ��������� ������ �������
					double h1 = Program.massiv[RowIndex-1][0];
					//������� �� ��������� ����� �������
					double h2 = Program.massiv[RowIndex][0];
					//������ ����� �������
					double rez = str_lenght(z, h1, h2);
					//��������� � ������ ����������� �������
					double finalrez = rez + Program.massiv[RowIndex-1][2];
					//�������������� ������� ������� �������
					Program.massiv[RowIndex][2] = (Math.round(finalrez*100))/100.0;
					return;
		};
		
		//��������� ��������� ���� �� ������� � ���������� ��������
		public static void CompareAngle(int RowIndex){
			//����������, ����� �� �������� ���� �� ������ � ���������� ��������
			if (Program.massiv[RowIndex-1][1] == Program.massiv[RowIndex][1]){
				StraightLenght(RowIndex);
			}
			else{
				CalcRoundLenght(RowIndex);
			}
			return;
		}
		
		//����� ��� ���������� ���������� ��������� �������� ������� �������
		public static int lastElement(){
			int i = 0;
			//���������, �� ����� �� ���� ������� ������� (�������)
			while (Program.massiv[i][0]!=0.0 && i < 100){
				i++;
			}
			if (i==0) return i;
			return i-1;
		}
		
		//����� ��� ���������� ���������� ��������� �������� ������� ���������� �������
			public static int lastPreviousElement(){
				int i = 0;
				//���������, �� ����� �� ���� ������� ������� (�������)
				while (Program.previous[i][0]!=0.0 && i < 10){
					i++;
				}
				if (i==0) return i;
				return i-1;
			}
			
			//����� ��� ���������� ���������� ��������� �������� ������� ��������� ������
			public static int lastOpenholeElement(){
				int i = 0;
				//���������, �� ����� �� ���� ������� ������� (�������)
				while (Program.openhole[i][0]!=0.0 && i < 10){
					i++;
				}
				if (i==0) return i;
				return i-1;
			}
			
			//����� ��� ���������� ���������� ��������� �������� ������� ������������� �������
					public static int lastCasingElement(){
						int i = 0;
						//���������, �� ����� �� ���� ������� ������� (�������)
						while (Program.casing[i][0]!=0.0 && i < 10){
							i++;
						}
						if (i==0) return i;
						return i-1;
					}
		
		//����� ��� ���������� ���������, � ������� ��������� �������� ������� �� ���������
		public static int findInt(double j){
			int i = 0;
			int i1 = lastElement();
			while (j >= Program.massiv[i][0] && i < i1){
				i++;
			}
			if (i==0){return i;};
			return i-1;
		}
		
		//������� �������� ���� � ������������ �����
		//�������� ������
		//j - ��������� ������������� ������� �� ���������
		public static double findAngle(double j){
			int i0 = findInt(j);
			double h0 = Program.massiv[i0][0];
			double h1 = Program.massiv[i0+1][0];
			double z0 = Program.massiv[i0][1];
			double z1 = Program.massiv[i0+1][1];
			//������� ������������� ��������� ��������� ����
			double dz = (z1 - z0)/(h1 - h0);
			//������� ������� �������� ����
			double z = (j-h0)*dz + z0;
			
			return z;
		}
		
		//������� ������� �� ������ � ������������ �����
		public static double findLenght(double j1){
			double current = 0.0;
			//������� ��������, � ������� ��������� �������� �������
			int k0 = findInt(j1);
			//������� �������� ���� � ���� �����
			double w1 = findAngle(j1);
			//������ ���������
			double j0 = Program.massiv[k0][0];
			double w0 = Program.massiv[k0][1];
			//������� ����� ���������
			if (w1 == w0){
				current = str_lenght(w0, j0, j1);
			}
			else {
				current = round_lenght(w0, w1, j0, j1);
			}
			//������� ����� ����� �� ������ �� �������� �����
			double lenght = current + Program.massiv[k0][2];
			if (lenght < j1){ return j1;}
			return (Math.round(lenght*100))/100.0;
		}
		
		//����� ��� ���������� ���������, � ������� ��������� �������� ������� �� ������
			public static int findInt2(double j){
				int i = 0;
				int i1 = lastElement();
				while (j >= Program.massiv[i][2] && i < i1){
					i++;
				}
				if (i==0) return i;
				return i-1;
			}
			
			//������� �������� ���� � ������������ �����
			//�������� ������
			//j - ��������� ������������� ������� �� ������
			public static double findAngle2(double j){
				int i0 = findInt2(j);
				double l0 = Program.massiv[i0][2];
				double l1 = Program.massiv[i0+1][2];
				double z0 = Program.massiv[i0][1];
				double z1 = Program.massiv[i0+1][1];
				//������� ������������� ��������� ��������� ����
				double dz = (z1 - z0)/(l1 - l0);
				//������� ������� �������� ����
				double z = (j-l0)*dz + z0;
				
				return z;
			}
			
			//������� ������� �� ��������� � ������������ �����
			public static double findHeight(double j1){
				double current = 0.0;
				//������� ��������, � ������� ��������� �������� �������
				int k0 = findInt2(j1);
				//������� �������� ���� � ���� �����
				double w1 = findAngle2(j1);
				//������ ���������
				double j0 = Program.massiv[k0][2];
				double w0 = Program.massiv[k0][1];
				//������� ����� ���������
				if (w1 == w0){
					current = str_height(j0, j1, w0);
				}
				else {
					current = round_height(w0, w1, j0, j1);
				}
				//������� ����� ����� �� ��������� �� �������� �����
				double lenght = current + Program.massiv[k0][0];
				if (lenght > j1){ return j1;}
				return (Math.round(lenght*100))/100.0;
			
			}

}
