package com.trunghieu.dictionary;

import com.trunghieu.dictionary.models.Dictionary;
import com.trunghieu.dictionary.models.Word;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileDictionaryManager {

    protected static final String FILE_DIR = "D:\\Hieu\\Java\\DictionaryTH\\src\\res\\dictionaries.txt";

    /**
     * Get ArrayList<Word> from file
     *
     * @return ArrayList<Word>
     */
    public static ArrayList<Word> loadDataFromFile() {
        ArrayList<Word> list = new ArrayList<>();
        try {
            File myObj = new File(FILE_DIR);
            Scanner myReader = new Scanner(myObj);
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
}
