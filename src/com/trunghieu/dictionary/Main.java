package com.trunghieu.dictionary;

public class Main {

    public static String BASE_PATH;

    public static void main(String[] args) {
        BASE_PATH = System.getProperty("user.dir");
        DictionaryCommandline commandline = new DictionaryCommandline();

        // Run ver 1.0
        //commandline.dictionaryBasic();

        // Run ver 2.0
        commandline.dictionaryVer3();
    }
}
