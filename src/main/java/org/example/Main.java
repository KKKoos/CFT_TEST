package org.example;


import java.util.*;

import static org.example.ReadFromFile.*;

public class Main {
    static boolean appendMode;

    public static void main(String[] args) {



        if (args.length == 0) {
            System.out.println("Пожалуйста, проверьте правильность введеных параметров запуска <путь к файлу 1> <путь к файлу 2> ... <путь к файлу N>");
            return;
        }

        List <String> Paths = new ArrayList<>();
        for (String arg : args) {
                if(arg.contains(".txt")){
                    Paths.add(arg);
                }
            }
        try {
            ReadFromFile.readFromFile(Paths);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



        int index = 0;

            while (index < args.length) {

                switch (args[index]){

                    case "-a":
                        appendMode = true;
                        break;

                    case "-s":  // краткая статистика
                        String shortStatistic = "Целых чисел: " + listLong.size() + "\n" + "Вещественных чисел: " + listDouble.size() + "\n" + "Cтрок: " + listString.size();
                        System.out.println(shortStatistic);
                        break;

                    case "-f":  // полная статистика
                        DoubleSummaryStatistics fullStatsticLong = listLong.stream()
                                                                        .mapToDouble(Long::doubleValue)
                                                                        .summaryStatistics();
                        DoubleSummaryStatistics fullStatsticDouble = listDouble.stream()
                                                                        .mapToDouble(Double::doubleValue)
                                                                        .summaryStatistics();

                        System.out.println("Целые числа: \nНаибольшее :" + (long) fullStatsticLong.getMax() +  "\nНаименьшее :" + (long) fullStatsticLong.getMin() + "\nСреднее :" + (long) fullStatsticLong.getAverage() + "\nСумма :" + (long) fullStatsticLong.getSum());
                        System.out.println();
                        System.out.println("Вещественные числа: \nНаибольшее :" + fullStatsticDouble.getMax() +  "\nНаименьшее :" +  fullStatsticDouble.getMin() + "\nСреднее :" +  fullStatsticDouble.getAverage() + "\nСумма :" +  fullStatsticDouble.getSum());
                        System.out.println();
                        System.out.println("Строки: \nКоличество строк: " + listString.size() + "\nРазмер самой длинной строки: " + Collections.max(listString, Comparator.comparing(s -> s.length())).length() + "\nРазмер самой короткой строки: " + Collections.min(listString, Comparator.comparing(s -> s.length())).length());

                        break;


                    case "-o":
                        String outputPath;
                        outputPath = args[index + 1];
                        WriteToFile.setPathFileFile(outputPath);
                        index++;
                        break;

                    case "-p":
                        String prefix;
                        prefix = args[index + 1];
                        WriteToFile.setPrefix(prefix);
                        index++;
                        break;
                    }
                    index++;

                }


        try {
           WriteToFile.WriteToFile();
        } catch (Exception e) {
            System.out.println("Проверьте корректность указанного имени входящих файлов");
            throw new RuntimeException(e);
        }


            }




    }
