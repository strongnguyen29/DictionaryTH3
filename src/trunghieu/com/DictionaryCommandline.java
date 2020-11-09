package trunghieu.com;

import trunghieu.com.models.Dictionary;
import trunghieu.com.models.Word;

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
        System.out.println("  No     |  English          |   Vietnamese          ");

        int i = 1;
        for (Word word : dictionary.getListWords()) {
            System.out.println("  " + i + "     |  " + word.getTarget() + "       |   " + word.getExplain() + "      ");
            i++;
        }
        System.out.println("==== END DICTIONARY TH ====");
    }

    /**
     * Ham chay chuong trinh
     */
    public void dictionaryBasic() {
        dictionaryManagement.insertFromCommandline(5);
        showAllWords();
    }
}
