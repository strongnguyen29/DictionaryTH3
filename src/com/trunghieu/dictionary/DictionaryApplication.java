package com.trunghieu.dictionary;

import com.trunghieu.dictionary.models.Dictionary;
import com.trunghieu.dictionary.models.Word;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class DictionaryApplication {

    private JTextField searchField;
    private JList<Word> listWords;
    private JTextArea textExplain;
    private JPanel appView;

    private final Dictionary dictionary;

    public DictionaryApplication() {
        dictionary = new Dictionary();
        insertFromFile();

        listWords.setListData(dictionary.getListWords().toArray(new Word[0]));
        listWords.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Word word = listWords.getSelectedValue();
                if (word != null) {
                    textExplain.setText("Nghĩa tiếng việt:\n- " + word.getTarget() + " : " + word.getExplain());
                }
            }
        });

        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actionSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actionSearch();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actionSearch();
            }
        });
    }

    /**
     * Ham chay
     * @param args String array
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Dictionary TH");
        frame.setContentPane(new DictionaryApplication().appView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Load data from file
     */
    private void insertFromFile() {
        this.dictionary.addAll(FileDictionaryManager.loadDataFromFile());
    }

    /**
     * Xuất từ điển hiện tại ra file
     */
    private void dictionaryExportToFile() {
        StringBuilder content = new StringBuilder();

        for (Word word : dictionary.getListWords()) {
            content.append("\n").append(word.getTarget()).append("\t").append(word.getExplain());
        }

        boolean success = FileDictionaryManager.writeToFile(content.toString());
        if (success) System.out.println("Xuất file thành công.");
        else System.out.println("Xuất file thất bại.");
    }

    /**
     *
     */
    private void actionSearch() {
        String target = searchField.getText();
        ArrayList<Word> results = new ArrayList<>();

        if (target.length() == 0) {
            results.addAll(dictionary.getListWords());
        } else {
            Pattern pattern = Pattern.compile("^" + target.toLowerCase() + "[a-zA-Z]*$");
            for (Word word : dictionary.getListWords()) {
                if (pattern.matcher(word.getTarget().toLowerCase()).matches()) {
                    results.add(word);
                }
            }
        }

        listWords.setListData(results.toArray(new Word[0]));
        listWords.updateUI();
    }
}
