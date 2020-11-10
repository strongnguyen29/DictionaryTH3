package com.trunghieu.dictionary;

import com.trunghieu.dictionary.models.Dictionary;
import com.trunghieu.dictionary.models.Word;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileDictionaryManager {

    protected static final String FILE_DIR = "\\src\\res\\dictionaries.txt";

    /**
     * Get ArrayList<Word> from file
     *
     * @return ArrayList<Word>
     */
    public static ArrayList<Word> loadDataFromFile() {
        ArrayList<Word> list = new ArrayList<>();
        try {
            File file = new File(System.getProperty("user.dir") + FILE_DIR);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {

                String str = myReader.nextLine();
                String[] strs = str.split("\t");
                if (strs.length == 2) {
                    list.add(new Word(strs[0], strs[1]));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
        return list;
    }

    /**
     * Ghi noi dung vao file
     *
     * @param content String
     * @return boolean
     */
    public static boolean writeToFile(String content) {
        FileOutputStream fos = null;
        File file;
        try {
            //Specify the file path here
            file = new File(Main.BASE_PATH + FILE_DIR);

            fos = new FileOutputStream(file);

            if (!file.exists()) {
                file.createNewFile();
            }

            byte[] bytesArray = content.getBytes();

            fos.write(bytesArray);
            fos.flush();
            return true;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ioe) {
                System.out.println("Error in closing the Stream");
            }
        }
        return false;
    }

}
