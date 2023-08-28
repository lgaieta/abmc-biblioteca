package com.mycompany.abmc.biblioteca;
import javax.swing.JOptionPane;

public class ABMCBiblioteca {
    public static void main(String[] args) {
        new Home().setVisible(true);
        JOptionPane.showMessageDialog(null, "Base de datos conectada!!");
    }
}
