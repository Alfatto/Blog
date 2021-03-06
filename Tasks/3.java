import java.util.*;
/*
Государство Кругов подготовило группу элитных десантников, которые должны в кратчайший срок спасти соседнюю братскую страну -- Государство Квадратов, где внезапно начались гражданские бунты против интернета. Территория Государства Квадратов представляет собой прямоугольник из NxM квадратных областей, где каждая область имеет координаты 1 .. N , 1 .. M.

Десантники в день 1 высаживаются в L областей, заданных их координатами (x1, y1), (x2,y2), ... , (xl, yl) и защищают их от бунтовщиков. На следующий день (день 2) они захватывают все соседние области, прилегающие к этим областям с четырёх сторон (по вертикали и горизонтали), и далее каждый следующий день этот процесс повторяется, пока не будут взяты под контроль все бунтующие области без исключения.

Генштаб Государства Кругов требует точный план освобождения Государства Квадратов -- на какой день оно будет полностью контролироваться десантниками.

Например:



В первый день под контроль взяты две области (заштрихованы); во второй -- 8 областей (две с первого дня, сплошные синие, и шесть в текущий день, заштрихованы).
В третий день (результирующее значение -- 3) вся территория Государства Квадратов оказывается под контролем десантников.

Функция

int ConquestCampaign(int N, int M, int L, int [] battalion) 
получает первыми двумя параметрами размер Государства Квадратов NxM, а battalion содержит массив из L*2 целых чисел (L >= 1) с индексацией с нуля, в котором каждый чётный (с чётным индексом) элемент содержит очередную координату области высадки по первому измерению N, а каждый нечётный (с нечётным индексом) элемент содержит очередную координату области высадки по второму измерению M.
Не исключено, что в связи с неразберихой в командовании координаты областей высадки могут дублироваться.
На примере с картинки параметры будут такими: N = 3, M = 4, L = 2, battalion = [2,2, 3,4]

Возвращает функция день, начиная с 1, когда все области будут взяты под контроль.
*/

public class Level1{
public static int ConquestCampaign(int N, int M, int L, int [] battalion) {
		int day = 0;
		if (L != 0) {
			day = 1;
		}
		int[][] oks = new int[N][M];
		int[][] oksCopy = new int[N][M];
		boolean prowerka;

		for (int i = 0; i < battalion.length; i++) {
			if (i != 0 & i % 2 != 0) {
				oks[battalion[i - 1] - 1][battalion[i] - 1] = 1;
			}
		}
		do {
			prowerka = false;
			for (int i = 0; i < oks.length; i++) {
				for (int k = 0; k < oks[0].length; k++) {
					if (oks[i][k] == 1) {
						if (k > 0) {
							oksCopy[i][k] = 1;
							oksCopy[i][k - 1] = 1;
						}
						if (k < oks[0].length - 1) {
							oksCopy[i][k + 1] = 1;
							oksCopy[i][k] = 1;
						}
						if (i > 0) {
							oksCopy[i][k] = 1;
							oksCopy[i - 1][k] = 1;
						}
						if (i < oks.length - 1) {
							oksCopy[i + 1][k] = 1;
							oksCopy[i][k] = 1;
						}
					}
				}
			}

			for (int i = 0; i < oks.length; i++) {
				for (int k = 0; k < oks[0].length; k++) {
					oks[i][k] = oksCopy[i][k];
				}
			}

			for (int i = 0; i < oks.length; i++) {
				for (int k = 0; k < oks[0].length; k++) {
					if (oks[i][k] == 0) {
						prowerka = true;
					}
				}
			}

			if (prowerka == false && day == 1){
				return day;
			}
			
			day++;

		} while (prowerka != false);
		return day;
	}
	
}