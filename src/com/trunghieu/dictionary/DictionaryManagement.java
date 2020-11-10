package com.trunghieu.dictionary;

import com.trunghieu.dictionary.models.Dictionary;
import com.trunghieu.dictionary.models.Word;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DictionaryManagement {


    protected Dictionary dictionary;

    protected Scanner scanner;

    /**
     * Constructor
     *
     * @param dictionary Dictionary
     */
    public DictionaryManagement(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Nhap du lieu tu ban phim
     *
     * @param count so luong tu moi se them vao
     */
    public void insertFromCommandline(int count) {

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
     * Xuất từ điển hiện tại ra file
     */
    public void dictionaryExportToFile() {
        StringBuilder content = new StringBuilder();

        for (Word word : dictionary.getListWords()) {
            content.append("\n").append(word.toString());
        }

        boolean success = FileDictionaryManager.writeToFile(content.toString());
        if (success) System.out.println("Xuất file thành công.");
        else System.out.println("Xuất file thất bại.");
    }

    /**
     * Tra tu dien
     */
    public void dictionaryLookup() {

        System.out.println("Tra từ điển Anh - Viet::");

        while (true) {
            System.out.println("\nNhập từ cần tra (Nhập /q để thoát): ");
            String target = scanner.nextLine();
            if (target.equalsIgnoreCase("/q")) {
                break;
            }
            for (Word word : dictionary.getListWords()) {
                if (word.getTarget().equalsIgnoreCase(target)) {
                    System.out.println("Kết quả: ");
                    System.out.println("- " + word.getTarget() + ": " + word.getExplain() + "\t\t\n");
                    break;
                }
            }
            System.out.println("Không tìm được kết quả nào phù hợp!");
        }
    }

    /**
     * Tìm kiếm từ trong từ điển
     */
    public void dictionarySearch() {
        System.out.println("Tìm kiếm từ điển Anh - Viet::");

        while (true) {
            System.out.println("\nNhập từ cần tìm (Nhập /q để thoát): ");
            String target = scanner.nextLine();
            if (target.equalsIgnoreCase("/q")) {
                break;
            }
            Pattern pattern = Pattern.compile("^" + target.toLowerCase() + "[a-zA-Z]*$");
            ArrayList<Word> results = new ArrayList<>();
            for (Word word : dictionary.getListWords()) {

                if (pattern.matcher(word.getTarget().toLowerCase()).matches()) {
                    results.add(word);
                }
            }
            System.out.println("Kết quả: ");

            if (results.size() > 0) {
                for (Word word : results) {
                    System.out.println("- " + word.getTarget() + ": " + word.getExplain() + "\t\t");
                }
            } else {
                System.out.println("Không tìm được kết quả nào phù hợp!");
            }
        }
    }

    /**
     * Them tu moi tu dong lenh
     */
    public void add() {
        System.out.println("Thêm từ mới vào từ điển.");
        System.out.println("Nhập từ tiếng anh:");
        String target = scanner.nextLine();
        // Kiem tra xem tu da co trong tu dien chua

        for (Word word : dictionary.getListWords()) {
            if (word.getTarget().equalsIgnoreCase(target)) {
                System.out.println("Từ này đã có trong từ điển.");
                System.out.println("- " + word.getTarget() + ": " + word.getExplain() + "\t\t\n");
                return;
            }
        }

        System.out.println("Nhập giải nghĩa tiếng viêt:");

        String explain = scanner.nextLine();
        this.dictionary.add(target, explain);
        System.out.println("Thêm từ mới thành công:");
        System.out.println("- " + target + ":  " + explain);
    }

    /**
     * Sửa từ trong từ điển
     */
    public void edit() {
        System.out.println("Sửa từ có trong từ điển.");
        System.out.println("Nhập từ tiếng anh cần sửa:");
        String target = scanner.nextLine();
        Word wordEdit = null;
        int indexEdit = 0;
        for (Word word : dictionary.getListWords()) {
            if (word.getTarget().equalsIgnoreCase(target)) {
                System.out.println("- " + word.getTarget() + ": " + word.getExplain() + "\t\t\n");
                wordEdit = word;
                break;
            } else {
                indexEdit++;
            }
        }

        if (wordEdit != null) {

            System.out.println("Nhập giải nghĩa tiếng viêt mới:");
            String explain = scanner.nextLine();
            this.dictionary.update(indexEdit, new Word(target, explain));

            System.out.println("Cập nhật thành công");
        } else {
            System.out.println("Không tồn tại từ này trong từ điển!");
        }
    }

    /**
     * Xóa từ trong từ điển
     */
    public void delete() {
        System.out.println("Xóa từ có trong từ điển.");
        System.out.println("Nhập từ tiếng anh cần xóa:");
        String target = scanner.nextLine();
        for (Word word : dictionary.getListWords()) {
            if (word.getTarget().equalsIgnoreCase(target)) {
                this.dictionary.remove(word);
                System.out.println("Xóa thành công");
                break;
            }
        }
    }
}
