package ru.alexnov.wellcementing;

public class CementsVolume {
	//Расчет объема тампонажного раствора
		public static double calcCementVolume(double top, double bottom){
			return calcWellVolume(top, bottom) - calcCasingVolume(top, bottom);
		}
		
		//расчет объема скважины в заданном интервале
		//Проверяем, где находится тампонажный раствор:
		//1 - весь в открытом стволе
		//2 - часть в открытом стволе, часть в межколонном пространстве
		//3 - весь в межколонном пространстве
		private static double calcWellVolume(double top, double bottom){
			//Проверяем, находится ли верх цементного раствора выше башмака предыдущей колонны
			int shoeindex = Geometry.lastPreviousElement();
			double shoe = Program.previous[shoeindex][1]; //глубина по стволу башмака предыдущей колонны
			if (top > shoe) { return calcOpenHoleVolume(top, bottom);}
			//Проверяем, не находится ли весь раствор в межколонном пространстве
			if (bottom < shoe) {return calcPreviousVolume(top, bottom);}
			else {return calcOpenHoleVolume(shoe, bottom) + calcPreviousVolume(top, shoe);}
		}
		
		//Вычисление объема скважины в интервале открытого ствола
		private static double calcOpenHoleVolume(double top, double bottom){
			
			return calcOpenHole(bottom) - calcOpenHole(top);
		}
		
		//Вычисление объема скважины в межколонном пространстве
		private static double calcPreviousVolume(double top, double bottom){
			return calcPrevious(bottom) - calcPrevious(top);
		}
		
		//Вычисление объема обсадной колонны
		private static double calcCasingVolume(double top, double bottom){
			return calcCasing(top) - calcCasing(bottom);
		}
		
		//Объем обсадной колонны от устья до заданной глубины
		private static double calcCasing(double height){
			double casing = 0.0;
			int i = 0;
			while (i<=Geometry.lastCasingElement()){
				if (height >= Program.casing[i][1]) {casing = casing + calcCasingUnit(i);}
				else {casing = casing + calcPartCasingUnit(i, height); break;}
				i++;
			}
			return casing;
		};
		
		//Объем интервала от начала открытого ствола до заданной глубины
		private static double calcOpenHole(double height){
			double openhole = 0.0;
			int i = 0;
			while (i<=Geometry.lastOpenholeElement()){
				if (height >= Program.openhole[i][1]) {openhole = openhole + calcOpenUnit(i);}
				else {openhole = openhole + calcPartOpenUnit(i,height); break;}
				i++;
			}
			return openhole;
		}
		
		//Объем единичного интервала в обсадной колонне
		private static double calcCasingUnit(int i){
			double vol = 0.0;
			if (i<1){
				//Глубина по стволу
				double lenght = Program.casing[i][1];
				//Наружный диаметр
				double dn = Program.casing[i][2];
				vol = (Math.PI/4)*Math.pow(dn, 2)*lenght;
			}
			else{
				//Глубина по стволу текущего участка
				double lenght1 = Program.casing[i][1];
				//Глубина по стволу предыдущего участка
				double lenght0 = Program.casing[i-1][1];
				//Наружный диаметр
				double dn = Program.casing[i][2];
				vol = (Math.PI/4)*Math.pow(dn, 2)*(lenght1-lenght0);
			}
			return vol;
		}
		
		//Объем единичного интервала в открытом стволе
		private static double calcOpenUnit(int i){
			double vol = 0.0;
			if (i<1){
				//номинальный диаметр открытого ствола
				double dn = Program.openhole[i][2];
				//коэффициент кавернозности
				double kk = Program.openhole[i][3];
				//глубина по стволу
				double l = Program.openhole[i][1];
				//Башмак предыдущей колонны
				double lp = Program.previous[Geometry.lastPreviousElement()][1];
				vol = (Math.PI/4)*Math.pow(dn,2)*kk*(l-lp);
			}
			else {
				//номинальный диаметр открытого ствола
				double dn = Program.openhole[i][2];
				//коэффициент кавернозности
				double kk = Program.openhole[i][3];
				//глубина по стволу текущего участка
				double l1 = Program.openhole[i][1];
				//глубина по стволу предыдущего участка
				double l0 = Program.openhole[i-1][1];
				vol = (Math.PI/4)*Math.pow(dn,2)*kk*(l1-l0);
			}
			return vol;
		}
		
		//Объем части интервала обсадной колонны
		private static double calcPartCasingUnit(int i, double height){
			double vol = 0.0;
			if (i<1){
				//Наружный диаметр
				double dn = Program.casing[i][2];
				vol = (Math.PI/4)*Math.pow(dn, 2)*height;
			}
			else{
				//Глубина по стволу предыдущего участка
				double lenght = Program.casing[i-1][1];
				//Наружный диаметр
				double dn = Program.casing[i][2];
				vol = (Math.PI/4)*Math.pow(dn, 2)*(height-lenght);
			}
		return vol;
			
		}
		
		//Объем части интервала в открытом стволе
		private static double calcPartOpenUnit(int i, double bottom){
			double vol = 0.0;
			if (i<1) {
				//номинальный диаметр открытого ствола
				double dn = Program.openhole[i][2];
				//коэффициент кавернозности
				double kk = Program.openhole[i][3];
				//Башмак предыдущей колонны
				double lp = Program.previous[Geometry.lastPreviousElement()][1];
				vol = (Math.PI/4)*Math.pow(dn,2)*kk*(bottom-lp);
			}
			else {
				//номинальный диаметр открытого ствола
				double dn = Program.openhole[i][2];
				//коэффициент кавернозности
				double kk = Program.openhole[i][3];
				//глубина по стволу предыдущего участка
				double l0 = Program.openhole[i-1][1];
				vol = (Math.PI/4)*Math.pow(dn,2)*kk*(bottom-l0);
			}
			return vol;
		}
		
		//Расчет объема скважины в межколонном пространстве от устья до заданной глубины
		private static double calcPrevious(double depth){
			double vol = 0.0;
			int i = 0;
			while (i<=Geometry.lastPreviousElement()){
				if (depth >= Program.previous[i][1]){vol = vol + calcPreviousUnit(i);}
				else {vol = vol + calcPartPreviousUnit(i, depth); break;}
				i++;
			}
			return vol;
		}
		
		//Расчет объема единичного интервала в интервале предыдущей колонны
		private static double calcPreviousUnit(int i){
			double vol = 0.0;
			double l0 = 0.0;
			//Глубина по стволу текущего участка
			double l1 = Program.previous[i][1];
			//Глубина по стволу предыдущего участка
			if (i>0) {l0 = Program.previous[i-1][1];}
			//Наружный диаметр колонны
			double dn = Program.previous[i][2];
			//Толщина стенки
			double delta = Program.previous[i][3];
			//Внутренний диаметр колонны
			double dv = dn - 2*delta;
			vol = (Math.PI/4)*Math.pow(dv,2)*(l1-l0);
			return vol;
		}
		//Расчет объема части единичного интервала в интервале предыдущей колонны
		private static double calcPartPreviousUnit(int i, double depth){
			double vol = 0.0;
			double l0 = 0.0;
			//Глубина по стволу текущего участка
					double l1 = Program.previous[i][1];
					//Глубина по стволу предыдущего участка
					if (i>0) {l0 = Program.previous[i-1][1];}
					//Наружный диаметр колонны
					double dn = Program.previous[i][2];
					//Толщина стенки
					double delta = Program.previous[i][3];
					//Внутренний диаметр колонны
					double dv = dn - 2*delta;
					vol = (Math.PI/4)*Math.pow(dv,2)*(depth-l0);
			return vol;
		}

}
