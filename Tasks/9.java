import java.util.*;
/*
Итан Хант с невероятным трудом пробирается в секретное хранилище данных Синдиката, в подводный бункер под электростанцией. На добытой им флешке хранятся детали банковских счетов верхушки Синдиката на сумму несколько миллиардов долларов, однако она закрыта "красным портфелем" -- очень сложной технологией шифрования.


Ваша миссия: реализовать алгоритм шифрования "Красного портфеля", который не под силу даже специалистам MI-6.

На вход программы подаётся строка текста, состоящая из строчных букв и пробелов. Из строки удаляются все пробелы и определяется её длина N.

На основании N вычисляется размер матрицы, в которую будет упакован исходный текст: из N извлекается квадратный корень, и его нижняя граница берётся как число строк матрицы, а верхняя граница -- как число столбцов. Если их произведение меньше N, увеличивайте количество строк.

Например, есть строка текста

отдай мою кроличью лапку
Она преобразуется в

отдаймоюкроличьюлапку
Длина этой строки -- 21, квадратный корень -- 4.58.
21 элемент в матрицу размером 4x5 элементов не упаковывается, значит, берём матрицу 5x5:

отдай
моюкр
оличь
юлапк
у
И наконец выдаём зашифрованный результат, выдавая символы по столбцам сверху вниз и слева направо, и разделяя столбцы пробелами:

омоюу толл дюиа акчп йрьк
Напишите код, зашифровывающий текстовое сообщение, и декодировщик, расшифровывающий его.

Функция

string TheRabbitsFoot(string s, bool encode)
получает исходную строку s и либо зашифровывает её (encode = true), либо расшифровывает (encode = false), только конечно без исходных пробелов.
*/

public class Level1{
public  static String TheRabbitsFoot(String s, Boolean encode){
		String result = "";
		StringBuilder builder = new StringBuilder();
		StringBuilder builderCopy = new StringBuilder();
		String[] stringDemo = s.split(" ");
		String[][] myAray;
		//вычисляем корень
		if (encode) {
			builder = new StringBuilder(s.replaceAll("\\s", ""));
			double sqrt = Math.sqrt(builder.length());
			int arayLench = (int) Math.round(sqrt);
			myAray = new String[arayLench][arayLench];
			//переводим в матрицу
			for (int i = 0; i < arayLench; i++){
				for (int k = 0; k < arayLench; k++){
					if (k < builder.length()) {
						myAray[i][k] = String.valueOf(builder.charAt(k));
					}
					if (k == arayLench - 1 && !builder.isEmpty()){
						builder.delete(0, arayLench);
					}
				}
			}//проходимся по массиву и записываем в builder
			for ( int e = 0; e < arayLench; e++){
				for (int d = 0; d < arayLench; d++){
					if (myAray[d][e] != null){
						builderCopy.append(myAray[d][e]);
					}
					if(d == arayLench - 1 && e != arayLench - 1){
						builderCopy.append(" ");
					}
				}
			}
			return result = new String(builderCopy);
		} else {
			//обратная расшифровка
			myAray = new String[stringDemo.length][stringDemo.length];
			for (int i = 0; i < stringDemo.length; i++) {
				for (int k = 0; k < stringDemo.length; k++) {
					if (k < stringDemo[i].length()) {
						myAray[i][k] = String.valueOf(stringDemo[i].charAt(k));
					}
				}
			}
			for (int i = 0; i < 5; i++) {
				for (int k = 0; k < 5; k++) {
					if (myAray[k][i] != null) {
						builder.append(myAray[k][i]);
					}
				}
			}
		}
		return result = new String(builder);
	}
}