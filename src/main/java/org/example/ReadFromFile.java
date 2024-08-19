package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.example.DataTypeCheck.IsTypeDouble;
import static org.example.DataTypeCheck.IsTypeLong;


public class ReadFromFile {


    static ArrayList<String> listString = new ArrayList<>();
    static ArrayList<Long> listLong = new ArrayList<>();
    static ArrayList<Double> listDouble = new ArrayList<>();


    public static void readFromFile(List<String> filePaths) {


        List<BufferedReader> readers = new ArrayList<>();
        List<String> currentLines = new ArrayList<>();



        try {
            for (String filePath : filePaths) {
                File filecheck = new File(filePath);
                if (filecheck.exists()) {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
                    readers.add(bufferedReader);
                    currentLines.add(bufferedReader.readLine());
                }
                else System.out.println("Файл " + filePath + " не найден. Проверьте корректность параметров запуска и убедитесь, что файл расположен в корневом каталоге" + "\nДальнейшее выполнение будет без учета файла " + filePath);
            }

            boolean hasMoreLines = true;
            while (hasMoreLines) {
                hasMoreLines = false;
                for (int i = 0; i < readers.size(); i++) {
                    if (currentLines.get(i) != null) {
                        if (IsTypeLong(currentLines.get(i)) == true) {
                            listLong.add(Long.parseLong(currentLines.get(i)));


                        } else if (IsTypeDouble(currentLines.get(i)) == true) {
                            listDouble.add(Double.parseDouble(currentLines.get(i)));

                        } else {
                            listString.add(currentLines.get(i));
                        }

                        currentLines.set(i, readers.get(i).readLine());
                        hasMoreLines = hasMoreLines || currentLines.get(i) != null;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            for (BufferedReader br : readers) {
                try {
                    if (br != null) {
                        br.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }


}
