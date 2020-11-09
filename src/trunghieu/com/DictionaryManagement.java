package trunghieu.com;

import trunghieu.com.models.Dictionary;

import java.util.Scanner;

public class DictionaryManagement {

    protected Dictionary dictionary;

    public DictionaryManagement(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

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

}
