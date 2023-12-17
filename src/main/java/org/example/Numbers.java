// Написать метод, который переведет число из римского формата записи в арабский
package org.example;
import java.awt.*;
import java.util.*;
import static javax.management.Query.and;

public class Numbers {

    //  Заполнение Мапы
    public static void getFigure(HashMap<Character, Integer> figure) {
        figure.put('I', 1);
        figure.put('V', 5);
        figure.put('X', 10);
        figure.put('L', 50);
        figure.put('C', 100);
        figure.put('D', 500);
        figure.put('M', 1000);
    }

    // Сопоставление римского символа арабскому
    public static Integer elemSearch(HashMap<Character, Integer> figur, char ele) {
        for (HashMap.Entry<Character, Integer> entry : figur.entrySet())
            if (entry.getKey().equals(ele)) {
                return entry.getValue();
            }
        return null;
    }

    // Сраснение множеств
/*
    public static boolean good(char[] f) {
        Character[] stringArray = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        HashSet<Character> set = new HashSet<>(Arrays.asList(stringArray));
        Character[] newArray = IntStream.range(0, f.length)
                .mapToObj(i -> f[i])
                .toArray(Character[]::new);
        Arrays.sort(newArray, Collections.reverseOrder());
        HashSet<Character> set1 = new HashSet<>(Arrays.asList(newArray));

        return ;
    }
*/
// Запрос числа
    public static String inputRomeFigure(){
        System.out.println("Введите число римскими цифрами и будет результат арабскими");
        System.out.println("Корректно конвертируются целые числа от 1 до 3 999");
        System.out.println("MMMXLII = 3042");
        System.out.println("Только, пожалуйста, без косяков: " +
                "проверку пользовательского ввода я пока не доделал");
        // тут ещё предполагается сравнение множеств символов
        int k=0;
        String rome = "";
        // char[] romeArray = {};
        while (k == 0) {
            Scanner in = new Scanner(System.in);
            System.out.print("Итак, ваше число: ");
            rome = in.nextLine();
            // romeArray = rome.toCharArray();
            if (rome.isEmpty()) System.out.println("Ну что же так? \n Давайте снова!");
            else  /*if (good(romeArray))*/ k = 1;
        }
        return rome;
    }

    public static void main(String[] args) {
        HashMap<Character, Integer> figure = new HashMap<>();
        getFigure(figure);   // заполнение Мапы
        int arabFigure = 0;
        String rome = inputRomeFigure(); // Запрос римского числа
        char[] romeArray = rome.toCharArray();
        int k = romeArray.length;
        int i = 0;
        while (i<k){     //Пробразование текущего элемента, последующего и проверка на >/<
            i++;
            char elem = romeArray[k-i];
            int arab = elemSearch(figure, elem);
            arabFigure += arab;
            int j = k-(i+1);
            if (j>=0) {
                int l = elemSearch(figure, romeArray[j]);
                if (l<arab) {
                    arabFigure -= l;
                    i++;
                }
            }
        }
        System.out.printf( "%s = %d", rome, arabFigure);

    }
}
