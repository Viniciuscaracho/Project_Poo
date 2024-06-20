package Frames;

import javax.swing.*;

import Classes.Books;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BookDetailDialog extends javax.swing.JDialog {

    public BookDetailDialog(Frame parent, boolean modal, Books book) {
        super(parent, modal);
        initComponents(book);
    }

    private void initComponents(Books book) {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Título: " + book.getTitulo());
        panel.add(titleLabel, BorderLayout.NORTH);

        JLabel publisherLabel = new JLabel("Editora: " + book.getEditora());
        panel.add(publisherLabel, BorderLayout.CENTER);

        StringBuilder autoresStr = new StringBuilder();
        List<String> autores = book.getAutores();
        if (autores.isEmpty()) {
            autoresStr.append("N/A");
        } else {
            for (String autor : autores) {
                autoresStr.append(autor).append(", ");
            }
            autoresStr.setLength(autoresStr.length() - 2);
        }

        JLabel authorsLabel = new JLabel("Autor(es): " + autoresStr);
        panel.add(authorsLabel, BorderLayout.SOUTH);

        JLabel priceLabel = new JLabel("Preço: R$ " + String.format("%.2f", book.getPreco()));
        panel.add(priceLabel, BorderLayout.SOUTH);

        getContentPane().add(panel);

        pack();
        setLocationRelativeTo(null);
    }


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookDetailDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(() -> {
            ArrayList<String> authors = new ArrayList<>();
            authors.add("Author 1");
            authors.add("Author 2");

            Books book = new Books("Example Title", authors, "Example Publisher", true, 100.0);
            BookDetailDialog dialog = new BookDetailDialog(new JFrame(), true, book);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
}