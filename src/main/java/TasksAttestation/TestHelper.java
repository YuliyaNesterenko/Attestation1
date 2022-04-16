package TasksAttestation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class TestHelper {
    private TestHelper() {
    }

    private static long RndLong(long lLeftLimit, long lRightLimit) {
        /*
            Генерация случайного числа типа long в заданных границах
        */
        long lGenerateLong = (long) ((Math.random() * lRightLimit - lLeftLimit + 1) + lLeftLimit);
        return lGenerateLong;
    }

    public static long GetRndLong() {
        /*
            Генерация случайного числа типа long в максимальном диапазоне
        */
        long lLeftLimit = Long.MIN_VALUE, lRightLimit = Long.MAX_VALUE;
        long lResult = RndLong(lLeftLimit, lRightLimit);
        System.out.println("Случайное число типа long: " + lResult);
        return lResult;
    }

    private static Date RndDate(long lLeftLimit, long lRightLimit) {
        /*
            Генерация случайной даты в заданных границах
        */
        Date dDate = new Date();
        dDate.setTime(RndLong(0L, lRightLimit));
        return dDate;
    }

    public static Date GetRndDate() {
        /*
            Генерация случайной даты от 1970 до текущего момента
        */
        Date dDate = new Date();
        long lRightLimit = dDate.getTime();
        long lLeftLimit = 0L;
        dDate = RndDate(lLeftLimit, lRightLimit);
        System.out.println(dDate.toString());
        return dDate;
    }

    public static String DateFormat(String firstDate) throws ParseException {
        /*
            преобразует дату в выбраный формат
        */
        SimpleDateFormat firstFormat = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat secondFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(secondFormat.format(firstFormat.parse(firstDate)));
        return secondFormat.format(firstFormat.parse(firstDate));
    }

    private static char RndChar() {
        /*
            Случайный символ из маленьких английских букв
        */
        Random random = new Random();
        char cSymbol = (char) (random.nextInt(26) + 'a');
        return cSymbol;
    }

    private static String RndString(int iSizeString, int iMaxSizeWord) {
        /*
            Генерация строки состоящей из iSizeString шт. слов, сформированных из iMaxSizeWord шт.
            сучайных маленьких английских букв.
            Каждое слово начинается с заглавной буквы и разделено пробелом.
        */
        String sString = "", sTemp;
        int iSize;

        for (int i = 0; i < iSizeString; i++) { //цикл на количество слов
            sTemp = "";
            iSize = (int) RndLong(1, iMaxSizeWord); // генерация длинны слова
            for (int j = 0; j < iSize; j++) { //цикл на формирование слова
                sTemp = sTemp + RndChar();
                if (j == 0) {             //формирование первой буквы слова как заглавной
                    sTemp = sTemp.toUpperCase();
                }
            }
            sString = sString + " " + sTemp; // формирование строки
        }
        return sString;
    }

    public static String GetRndString() {
         /*
            Генерация строки состоящей из 3 слов, сформированных из максимум 15 сучайных маленьких английских букв.
         */
        int iSizeString = 3, iMaxSizeWord = 15;
        System.out.println("Строка из трех слов: " + RndString(iSizeString, iMaxSizeWord));
        return RndString(iSizeString, iMaxSizeWord);
    }

    private static Double StringToDouble(String sNumber) {
        /*
            Преобразует строку в число типа Double
        */

        return Double.parseDouble(sNumber);
    }


    public static Double GetDouble(String sNumber) {
        /*
        Преобразует строку в число типа Double, если это невозможно, возвращает Infinity
        */
        double doublePass;
        try {
            return StringToDouble(sNumber);

        } catch (NumberFormatException error) {
            doublePass = Double.POSITIVE_INFINITY;
            System.out.println(doublePass);
        }
        return doublePass;
    }

    private static BufferedReader getBufferReader(String filePath) throws FileNotFoundException {

        FileReader fileReader = new FileReader(filePath);
        return new BufferedReader(fileReader);
    }

    public static HashMap<Object, Object> readFile(String filePath) throws IOException {

        String[] strings = new String[3];
        String[] words;
        BufferedReader reader = getBufferReader(filePath);
        HashMap<Object, Object> hashmap = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            String line = reader.readLine();
            strings[i] = line;
            words = strings[i].split("::");
            for (int j = 0; j < 2; j++) {
                hashmap.put(words[0], words[1]);
            }
        }
        return hashmap;
    }

    public static void main(String[] args) {

    }
}
