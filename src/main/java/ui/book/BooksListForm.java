/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui.book;

import services.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import services.BookStore;

public class BooksListForm extends javax.swing.JFrame {

    DBConnection db = null;
    DefaultTableModel tableModel = new DefaultTableModel();

    /**
     * Creates new form BooksList
     */
    public BooksListForm() {
        initComponents();

        BooksTable.setModel(tableModel);

        db = new DBConnection();

        try {
            ResultSet result = BookStore.getAll(db);
            
            ResultSetMetaData resultMetaData = result.getMetaData();
            int numberOfColumns = resultMetaData.getColumnCount();

            tableModel.addColumn("N° Libro");
            tableModel.addColumn("Nombre");
            tableModel.addColumn("Autor");
            tableModel.addColumn("Descripción");
            tableModel.addColumn("Género");

            while (result.next()) {
                Object[] filas = new Object[numberOfColumns];

                for (int i = 0; i < numberOfColumns; i++) {
                    filas[i] = result.getObject(i + 1);
                }

                tableModel.addRow(filas);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        BooksTable = new javax.swing.JTable();
        Title = new javax.swing.JLabel();
        NewBookButton = new javax.swing.JButton();
        SearchTextField = new javax.swing.JTextField();
        BackButton = new javax.swing.JButton();
        SearchButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de libros - Biblioteca E.E.S.T. N°1");

        BooksTable.setForeground(new java.awt.Color(8, 8, 8));
        BooksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        BooksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BooksTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(BooksTable);

        Title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Title.setForeground(new java.awt.Color(8, 8, 8));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Title.setText("Lista de libros - Biblioteca E.E.S.T. N°1");

        NewBookButton.setBackground(new java.awt.Color(76, 0, 0));
        NewBookButton.setForeground(new java.awt.Color(255, 255, 255));
        NewBookButton.setText("Nuevo Libro");
        NewBookButton.setBorder(null);
        NewBookButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        NewBookButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        NewBookButton.setMaximumSize(new java.awt.Dimension(113, 32));
        NewBookButton.setMinimumSize(new java.awt.Dimension(113, 32));
        NewBookButton.setPreferredSize(new java.awt.Dimension(95, 32));
        NewBookButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NewBookButtonMouseClicked(evt);
            }
        });

        SearchTextField.setForeground(new java.awt.Color(8, 8, 8));
        SearchTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        SearchTextField.setToolTipText("Buscar por nombre");
        SearchTextField.setMinimumSize(new java.awt.Dimension(178, 32));
        SearchTextField.setName(""); // NOI18N
        SearchTextField.setPreferredSize(new java.awt.Dimension(178, 32));
        SearchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchTextFieldKeyPressed(evt);
            }
        });

        BackButton.setForeground(new java.awt.Color(8, 8, 8));
        BackButton.setText("Volver");
        BackButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BackButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BackButton.setMaximumSize(new java.awt.Dimension(77, 32));
        BackButton.setMinimumSize(new java.awt.Dimension(77, 32));
        BackButton.setName(""); // NOI18N
        BackButton.setPreferredSize(new java.awt.Dimension(77, 36));
        BackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackButtonMouseClicked(evt);
            }
        });

        SearchButton1.setForeground(new java.awt.Color(8, 8, 8));
        SearchButton1.setText("Buscar");
        SearchButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SearchButton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        SearchButton1.setMaximumSize(new java.awt.Dimension(77, 32));
        SearchButton1.setMinimumSize(new java.awt.Dimension(77, 32));
        SearchButton1.setName(""); // NOI18N
        SearchButton1.setPreferredSize(new java.awt.Dimension(77, 36));
        SearchButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(SearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(SearchButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NewBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Title)
                    .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SearchTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SearchButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(NewBookButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );

        SearchTextField.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewBookButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewBookButtonMouseClicked
        new CreateBookForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_NewBookButtonMouseClicked

    void searchBooks() {
        String name = SearchTextField.getText();

        String query = "SELECT * FROM libro WHERE nombre LIKE ?";

        try {
            PreparedStatement statement = db.connection.prepareStatement(query);
            statement.setString(1, "%" + name + "%");

            System.out.println(statement);

            ResultSet result = statement.executeQuery();
            ResultSetMetaData resultMetaData = result.getMetaData();
            int numberOfColumns = resultMetaData.getColumnCount();

            tableModel.setRowCount(0);

            while (result.next()) {
                Object[] filas = new Object[numberOfColumns];

                for (int i = 0; i < numberOfColumns; i++) {
                    filas[i] = result.getObject(i + 1);
                }

                tableModel.addRow(filas);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    private void BackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackButtonMouseClicked
        new Home().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackButtonMouseClicked

    private void BooksTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BooksTableMouseClicked
        int selectedId = (int) BooksTable.getModel().getValueAt(BooksTable.getSelectedRow(), 0);
        new BookDetailsForm(selectedId).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BooksTableMouseClicked

    private void SearchTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchTextFieldKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            searchBooks();
        }
    }//GEN-LAST:event_SearchTextFieldKeyPressed

    private void SearchButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchButton1MouseClicked
        searchBooks();
    }//GEN-LAST:event_SearchButton1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BooksListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BooksListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BooksListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BooksListForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BooksListForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JTable BooksTable;
    private javax.swing.JButton NewBookButton;
    private javax.swing.JButton SearchButton1;
    private javax.swing.JTextField SearchTextField;
    private javax.swing.JLabel Title;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}