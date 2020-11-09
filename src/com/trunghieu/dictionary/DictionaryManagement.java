package com.trunghieu.dictionary;

import com.trunghieu.dictionary.models.Dictionary;
import com.trunghieu.dictionary.models.Word;

import java.io.File;
import java.util.Scanner;

public class DictionaryManagement {


    protected Dictionary dictionary;

    /**
     * Constructor
     *
     * @param dictionary Dictionary
     */
    public DictionaryManagement(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    /**
     * Nhap du lieu tu ban phim
     *
     * @param count so luong tu moi se them vao
     */
    public void insertFromCommandline(int count) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Thêm từ mới vào từ điển Anh - Việt:");

        for (int i = 0; i < count; i++) {
            System.out.println("Nhập từ tiếng anh:");
            String target = scanner.nextLine();

            System.out.println("Nhập giải nghĩa tiếng viêt:");

            String explain = scanner.nextLine();
            this.dictionary.add(target, explain);
        }

    }

    /**
     * Load data from file
     */
    public void insertFromFile() {
        this.dictionary.addAll(FileDictionaryManager.loadDataFromFile());
    }

    /**
     * Tra tu dien
     */
    public void dictionaryLookup() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Tra từ điển Anh - Viet::");

        while (true) {
            System.out.println("Nhập từ cần tra: ");
            String target = scanner.nextLine();
            for (Word word : dictionary.getListWords()) {
                if (word.getTarget().equalsIgnoreCase(target)) {
                    System.out.println("Kết quả: ");
                    System.out.println("- " + word.getTarget() + ": " + word.getExplain() + "\t\t\n");
                }
            }
        }
    }
}
