package org.example;

import java.io.*;


import static org.example.ReadFromFile.*;

class WriteToFile {

    private static String nameFileInteger = "integers.txt";
    private static String nameFileFloats = "floats.txt";
    private static String nameFileString = "strings.txt";

    private static String prefix = "";
    private static String pathFile = "";


    static void WriteToFile(){

        if (!listLong.isEmpty()) {
            try {
                FileWriter fileWriter = new FileWriter(pathFile + prefix + nameFileInteger, Main.isAppendMode());

                for (int i = 0; i < listLong.size(); i++) {
                        fileWriter.append(listLong.get(i).toString());
                        fileWriter.append("\n");
                    }

                fileWriter.close();

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (!listDouble.isEmpty()){
            try {
                FileWriter fileWriter = new FileWriter(pathFile + prefix + nameFileFloats, Main.isAppendMode());

                    for (int i = 0; i < listDouble.size(); i++) {
                        fileWriter.append(listDouble.get(i).toString());
                        fileWriter.append("\n");
                    }

                fileWriter.close();

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (!listString.isEmpty()) {
            try {
                FileWriter fileWriter = new FileWriter(pathFile + prefix + nameFileString, Main.isAppendMode());
                if (!listString.isEmpty()) {
                    for (int i = 0; i < listString.size(); i++) {
                        if(!listString.get(i).equals("")) {
                            fileWriter.append(listString.get(i));
                            fileWriter.append("\n");
                        }
                    }
                }

                fileWriter.flush();
                fileWriter.close();

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }


    public static void setPrefix(String newPrefix) {
        WriteToFile.prefix = newPrefix;

    }

    public static void setPathFileFile (String newPathFile) {
        WriteToFile.pathFile = newPathFile;
    }



}
