package com.trunghieu.dictionary.models;

import java.util.ArrayList;

public class Dictionary {

    /**
     * Mảng Word
     */
    protected ArrayList<Word> listWords;

    /**
     * Constructor
     */
    public Dictionary() {
        this.listWords = new ArrayList<>();
    }

    /**
     * Get Array
     *
     * @return ArrayList<Word>
     */
    public ArrayList<Word> getListWords() {
        return this.listWords;
    }

    /**
     * Set ArrayList
     *
     * @param listWords ArrayList<Word>
     */
    public void setListWords(ArrayList<Word> listWords) {
        this.listWords = listWords;
    }

    /**
     * Thêm từ mới vào từ điển
     *
     * @param target String
     * @param explain String
     */
    public void add(String target, String explain) {
        this.listWords.add(new Word(target, explain));
    }

    /**
     * Add all;
     * @param list ArrayList<Word>
     */
    public void addAll(ArrayList<Word> list) {
        this.listWords.addAll(list);
    }

    /**
     * Cap nhat lai phan tu
     * @param index chi muc
     * @param word tu sua
     */
    public void update(int index, Word word) {
        this.listWords.set(index, word);
    }

    /**
     * Xóa phần tử
     * @param word Word
     */
    public void remove(Word word) {
        this.listWords.remove(word);
    }

    public void sortAsc() {

    }
}
