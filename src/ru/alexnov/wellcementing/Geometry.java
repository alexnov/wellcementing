package ru.alexnov.wellcementing;

public class Geometry {
	
	//Расчет длины участка, на котором происходит изменение зенитного угла
		//z1, z2 - начальный и конечный зенитный угол
		//h1, h2 - глубина по вертикали начала и конца участка
		public static double round_lenght(double z1, double z2, double h1, double h2){
			double l = (Math.abs(z1-z2)*(h2-h1))/(Math.abs(Math.sin(z1*3.14/180)-Math.sin(z2*3.14/180))*57.296);
			return l;
		}
		
		//Расчет длины тангенциального участка
		//z - зенитный угол
		//h1, h2 - глубина по вертикали начала и конца участка
		public static double str_lenght(double z, double h1, double h2){
			double l = (h2-h1)/Math.cos(z*3.14/180);
			return l;
		}
		
		//Расчет высоты участка с изменением зенитного угла
		//z1, z2 - начальный и конечный зенитный угол
		//l1, l2 - длина начала и конца участка
		public static double round_height(double z1, double z2, double l1, double l2){
			double h = (57.296*(l2-l1)*Math.abs(Math.sin(z1*3.14/180)-Math.sin(z2*3.14/180)))/Math.abs(z2-z1);
			return h;
		}
		//Расчет высоты тангенциального участка
		//l1, l2 - длина начала и конца участка
		//z - зенитный угол
		public static double str_height(double l1, double l2, double z){
			double h = (l2-l1)*Math.cos(z*3.14/180);
			return h;
		}
		
		//Метод для расчета длины по стволу в таблице, если изменяется зенитный угол
		public static void CalcRoundLenght(int RowIndex){
			//Присваиваем значения переменным
			//зенитный угол в начале участка
			double z1 = Program.massiv[RowIndex-1][1];
			//зенитный угол в конце участка
			double z2 = Program.massiv[RowIndex][1];
			//глубина по вертикали начала участка
			double h1 = Program.massiv[RowIndex-1][0];
			//глубина по вертикали конца участка
			double h2 = Program.massiv[RowIndex][0];
			//расчет длины участка
			double rez = round_lenght(z1, z2, h1, h2);
			//cуммируем с длиной предыдущего участка
			double finalrez = rez + Program.massiv[RowIndex-1][2];
			//перезаписываем текущий элемент массива
			Program.massiv[RowIndex][2] = (Math.round(finalrez*100))/100.0;
			return;
		}
		
		//Метод для расчета длины по стволу в таблице, при постоянном зенитном угле
		public static void StraightLenght(int RowIndex){
			//Присваиваем значения переменным
					//зенитный угол
					double z = Program.massiv[RowIndex-1][1];
					//глубина по вертикали начала участка
					double h1 = Program.massiv[RowIndex-1][0];
					//глубина по вертикали конца участка
					double h2 = Program.massiv[RowIndex][0];
					//Расчет длины участка
					double rez = str_lenght(z, h1, h2);
					//суммируем с длиной предыдущего участка
					double finalrez = rez + Program.massiv[RowIndex-1][2];
					//перезаписываем текущий элемент массива
					Program.massiv[RowIndex][2] = (Math.round(finalrez*100))/100.0;
					return;
		};
		
		//Сравнение зенитного угла на текущем и предыдущем участках
		public static void CompareAngle(int RowIndex){
			//Сравниваем, равны ли зенитные углы на теущем и предыдущем участках
			if (Program.massiv[RowIndex-1][1] == Program.massiv[RowIndex][1]){
				StraightLenght(RowIndex);
			}
			else{
				CalcRoundLenght(RowIndex);
			}
			return;
		}
		
		//Метод для нахождения последнего значимого элемента массива профиля
		public static int lastElement(){
			int i = 0;
			//Проверяем, не равен ли нулю текущий элемент (глубина)
			while (Program.massiv[i][0]!=0.0 && i < 100){
				i++;
			}
			if (i==0) return i;
			return i-1;
		}
		
		//Метод для нахождения последнего значимого элемента массива предыдущей колонны
			public static int lastPreviousElement(){
				int i = 0;
				//Проверяем, не равен ли нулю текущий элемент (глубина)
				while (Program.previous[i][0]!=0.0 && i < 10){
					i++;
				}
				if (i==0) return i;
				return i-1;
			}
			
			//Метод для нахождения последнего значимого элемента массива открытого ствола
			public static int lastOpenholeElement(){
				int i = 0;
				//Проверяем, не равен ли нулю текущий элемент (глубина)
				while (Program.openhole[i][0]!=0.0 && i < 10){
					i++;
				}
				if (i==0) return i;
				return i-1;
			}
			
			//Метод для нахождения последнего значимого элемента массива цементируемой колонны
					public static int lastCasingElement(){
						int i = 0;
						//Проверяем, не равен ли нулю текущий элемент (глубина)
						while (Program.casing[i][0]!=0.0 && i < 10){
							i++;
						}
						if (i==0) return i;
						return i-1;
					}
		
		//Метод для нахождения интервала, в котором находится заданная глубина по вертикали
		public static int findInt(double j){
			int i = 0;
			int i1 = lastElement();
			while (j >= Program.massiv[i][0] && i < i1){
				i++;
			}
			if (i==0){return i;};
			return i-1;
		}
		
		//Находим зенитный угол в произвольной точке
		//Исходные данные
		//j - введенная пользователем глубина по вертикали
		public static double findAngle(double j){
			int i0 = findInt(j);
			double h0 = Program.massiv[i0][0];
			double h1 = Program.massiv[i0+1][0];
			double z0 = Program.massiv[i0][1];
			double z1 = Program.massiv[i0+1][1];
			//находим интенсивность изменения зенитного угла
			double dz = (z1 - z0)/(h1 - h0);
			//находим текущий зенитный угол
			double z = (j-h0)*dz + z0;
			
			return z;
		}
		
		//Находим глубину по стволу в произвольной точке
		public static double findLenght(double j1){
			double current = 0.0;
			//находим интервал, в котором находится заданная глубина
			int k0 = findInt(j1);
			//находим зенитный угол в этой точке
			double w1 = findAngle(j1);
			//начало интервала
			double j0 = Program.massiv[k0][0];
			double w0 = Program.massiv[k0][1];
			//Считаем длину интервала
			if (w1 == w0){
				current = str_lenght(w0, j0, j1);
			}
			else {
				current = round_lenght(w0, w1, j0, j1);
			}
			//Считаем общую длину по стволу до заданной точки
			double lenght = current + Program.massiv[k0][2];
			if (lenght < j1){ return j1;}
			return (Math.round(lenght*100))/100.0;
		}
		
		//Метод для нахождения интервала, в котором находится заданная глубина по стволу
			public static int findInt2(double j){
				int i = 0;
				int i1 = lastElement();
				while (j >= Program.massiv[i][2] && i < i1){
					i++;
				}
				if (i==0) return i;
				return i-1;
			}
			
			//Находим зенитный угол в произвольной точке
			//Исходные данные
			//j - введенная пользователем глубина по стволу
			public static double findAngle2(double j){
				int i0 = findInt2(j);
				double l0 = Program.massiv[i0][2];
				double l1 = Program.massiv[i0+1][2];
				double z0 = Program.massiv[i0][1];
				double z1 = Program.massiv[i0+1][1];
				//находим интенсивность изменения зенитного угла
				double dz = (z1 - z0)/(l1 - l0);
				//находим текущий зенитный угол
				double z = (j-l0)*dz + z0;
				
				return z;
			}
			
			//Находим глубину по вертикали в произвольной точке
			public static double findHeight(double j1){
				double current = 0.0;
				//находим интервал, в котором находится заданная глубина
				int k0 = findInt2(j1);
				//находим зенитный угол в этой точке
				double w1 = findAngle2(j1);
				//начало интервала
				double j0 = Program.massiv[k0][2];
				double w0 = Program.massiv[k0][1];
				//Считаем длину интервала
				if (w1 == w0){
					current = str_height(j0, j1, w0);
				}
				else {
					current = round_height(w0, w1, j0, j1);
				}
				//Считаем общую длину по вертикали до заданной точки
				double lenght = current + Program.massiv[k0][0];
				if (lenght > j1){ return j1;}
				return (Math.round(lenght*100))/100.0;
			
			}

}
