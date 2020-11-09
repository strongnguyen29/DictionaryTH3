package com.trunghieu.dictionary;

import com.trunghieu.dictionary.models.Dictionary;
import com.trunghieu.dictionary.models.Word;

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
}
