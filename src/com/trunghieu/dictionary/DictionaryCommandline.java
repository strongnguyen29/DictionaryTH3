package com.trunghieu.dictionary;

import com.trunghieu.dictionary.models.Dictionary;
import com.trunghieu.dictionary.models.Word;

import java.util.Scanner;

public class DictionaryCommandline {

    protected DictionaryManagement dictionaryManagement;

    protected Dictionary dictionary;

    public DictionaryCommandline() {
        this.dictionary = new Dictionary();
        this.dictionaryManagement = new DictionaryManagement(this.dictionary);
    }

    /**
     * Hiển thị danh sách dữ liệu từ điển
     */
    public void showAllWords() {
        System.out.println("==== DICTIONARY TH ====");
        System.out.println("  No\t\t|  English\t\t|  Vietnamese\t\t");

        int i = 1;
        for (Word word : dictionary.getListWords()) {
            System.out.println("  " + i + "\t\t|  " + word.getTarget() + "\t\t|  " + word.getExplain() + "\t\t");
            i++;
        }
        System.out.println("==== END DICTIONARY TH ====");
    }

    /**
     * Ham chay chuong trinh ver 1
     */
    public void dictionaryBasic() {
        dictionaryManagement.insertFromCommandline(5);
        showAllWords();
    }

    /**
     * Ham chay chuong trinh ver 2
     */
    public void dictionaryAdvanced() {
        dictionaryManagement.insertFromFile();
        showAllWords();
        dictionaryManagement.dictionaryLookup();
    }

    /**
     * Ham chay chuong trinh ver 2
     */
    public void dictionaryVer3() {
        dictionaryManagement.insertFromFile();
        showAllWords();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Tra từ điển Anh - Viet::");

        while (true) {
            System.out.println("\n----------------------------------------\n");
            System.out.println("Nhập mã lệnh đẻ thực hiện các hành động:");
            System.out.println(
                    "\nxem : Xem tất cả từ, " +
                    "\ntra : tra từ điển, " +
                    "\ntim: Tìm kiếm, " +
                    "\nthem: thêm từ mới, " +
                    "\nsua: sửa từ đang có, " +
                    "\nxoa: xóa từ đang có" +
                    "\nxuat: Xuất nội dung từ điển hiện tại ra file" +
                    "\n/q: Đóng từ điển"
            );

            String action = scanner.nextLine();
            if (action.equalsIgnoreCase("/q")) {
                System.out.println("Goodbye!");
                break;
            }

            switch (action) {
                case "xem" -> showAllWords();
                case "tra" -> dictionaryManagement.dictionaryLookup();
                case "tim" -> dictionaryManagement.dictionarySearch();
                case "them" -> dictionaryManagement.add();
                case "sua" -> dictionaryManagement.edit();
                case "xoa" -> dictionaryManagement.delete();
                case "xuat" -> dictionaryManagement.dictionaryExportToFile();
                default -> System.out.println("Mã lệnh không đúng!");
            }
        }

    }
}
