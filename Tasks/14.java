import java.util.*;

public class Level1{
	public static int Unmanned(int L, int N, int [][] track) {
		int otDoLight = 0;
		int result = 0;
		int trafficLight = 0;
		//время светофора
		int summaLight = 0;
		//свет светофора
		boolean red = true;
		//секунды светофора
		int summaRed = 0;
		int timeTest = 0;

		if (L <= track[0][0]) {
			return L;
		}

		//идем циклом по светофорам
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				otDoLight += track[trafficLight][0];
			} else if (trafficLight <= N - 1 && track[trafficLight][0] <= L) {
				//вычисляем время между светофорами
				otDoLight += track[trafficLight][0] - track[trafficLight - 1][0];
			}

			//вычисляем свет светофора
			for (int k = 0; k <= otDoLight; k++) {
				//добавляем секунды светофора
				if (red) {
					summaLight += track[trafficLight][1];
					red = false;
					k += track[trafficLight][1];
				} else {
					summaLight += track[trafficLight][2];
					red = true;
					k +=  track[trafficLight][2];
				}
				//если секунды больше или равно time
				if (summaLight >= otDoLight && red){
					red = false;
				} else
				if (summaLight >= otDoLight){
					red = true;
				}

			}
			//считаем время красного горения
			if (red) {
				summaRed += Math.abs(otDoLight - summaLight);
				timeTest += summaRed;
				summaRed = 0;

			}
			summaLight = 0;
			if (otDoLight < L && trafficLight == N - 1 || track[trafficLight][0] > L) {
				timeTest += L - otDoLight;
			}
			otDoLight += timeTest;
			trafficLight++;
		}
		result += otDoLight;
		return  result;
	}
}
