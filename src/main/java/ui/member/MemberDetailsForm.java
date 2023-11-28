package ui.member;

import entities.Book;
import entities.Member;
import java.awt.HeadlessException;
import services.DBConnection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import services.BookStore;
import services.MemberStore;

public class MemberDetailsForm extends javax.swing.JFrame {
    DBConnection db = null;
    String dni;
    Member currentMember;
    
    boolean isEditable = false;
    
    public MemberDetailsForm(String dni) {
        initComponents();
        this.dni = dni;
        loadBooks();
    }

    final void loadBooks() {
        db = new DBConnection();

        try {
            Member member = MemberStore.get(db, dni);
            currentMember = member;
            Title.setText(member.name);
            FieldDni.setText(member.dni);
            FieldName.setText(member.name);
            FieldSurname.setText(member.surname);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    void editingLogic() {
        if (isEditable == false) {
            isEditable = true;
            ButtonEdit.setText("Confirmar");
        } else {
            isEditable = false;

            String newDni = FieldDni.getText();
            String newName = FieldName.getText();
            String newSurname = FieldSurname.getText();
            
            String query = "UPDATE socio SET nombre = ?, apellido = ? WHERE dni = ?";

            try {
                db.open();
                
                PreparedStatement statement = db.connection.prepareStatement(query);
                statement.setString(1, newName);
                statement.setString(2, newSurname);
                statement.setString(3, newDni);

                statement.execute();
                JOptionPane.showMessageDialog(null, "Socio editado correctamente.");
                Title.setText(newName);
                db.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            ButtonEdit.setText("Editar");
        }
        FieldName.setEditable(isEditable);
        FieldSurname.setEditable(isEditable);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        Header = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        GoBackButton = new javax.swing.JButton();
        FieldsContainer = new javax.swing.JPanel();
        Fields = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        FieldDni = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        FieldName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        FieldSurname = new javax.swing.JTextField();
        Buttons = new javax.swing.JPanel();
        ButtonEdit = new javax.swing.JButton();
        ButtonDelete = new javax.swing.JButton();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Añadir nuevo libro");
        setSize(new java.awt.Dimension(376, 131));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        Title.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        Title.setForeground(new java.awt.Color(8, 8, 8));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Title.setText("Nombre del socio");

        GoBackButton.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        GoBackButton.setText("Volver");
        GoBackButton.setPreferredSize(new java.awt.Dimension(72, 32));
        GoBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GoBackButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(Title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                .addComponent(GoBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GoBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        getContentPane().add(Header);

        Fields.setLayout(new java.awt.GridLayout(6, 2));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel4.setText("DNI");
        Fields.add(jLabel4);

        FieldDni.setEditable(false);
        FieldDni.setBackground(new java.awt.Color(255, 255, 255));
        FieldDni.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        FieldDni.setPreferredSize(new java.awt.Dimension(64, 32));
        Fields.add(FieldDni);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel6.setText("Nombre");
        Fields.add(jLabel6);

        FieldName.setEditable(false);
        FieldName.setBackground(new java.awt.Color(255, 255, 255));
        FieldName.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        FieldName.setPreferredSize(new java.awt.Dimension(64, 32));
        Fields.add(FieldName);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        jLabel5.setText("Apellido");
        Fields.add(jLabel5);

        FieldSurname.setEditable(false);
        FieldSurname.setBackground(new java.awt.Color(255, 255, 255));
        FieldSurname.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        FieldSurname.setPreferredSize(new java.awt.Dimension(64, 32));
        Fields.add(FieldSurname);

        javax.swing.GroupLayout FieldsContainerLayout = new javax.swing.GroupLayout(FieldsContainer);
        FieldsContainer.setLayout(FieldsContainerLayout);
        FieldsContainerLayout.setHorizontalGroup(
            FieldsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 479, Short.MAX_VALUE)
            .addGroup(FieldsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(FieldsContainerLayout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(Fields, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24)))
        );
        FieldsContainerLayout.setVerticalGroup(
            FieldsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
            .addGroup(FieldsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(FieldsContainerLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(Fields, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)))
        );

        getContentPane().add(FieldsContainer);

        ButtonEdit.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        ButtonEdit.setForeground(new java.awt.Color(8, 8, 8));
        ButtonEdit.setText("Editar");
        ButtonEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonEditMouseClicked(evt);
            }
        });

        ButtonDelete.setBackground(new java.awt.Color(204, 0, 0));
        ButtonDelete.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        ButtonDelete.setForeground(new java.awt.Color(255, 255, 255));
        ButtonDelete.setText("Eliminar");
        ButtonDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButtonDeleteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ButtonsLayout = new javax.swing.GroupLayout(Buttons);
        Buttons.setLayout(ButtonsLayout);
        ButtonsLayout.setHorizontalGroup(
            ButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ButtonsLayout.createSequentialGroup()
                .addContainerGap(281, Short.MAX_VALUE)
                .addComponent(ButtonEdit)
                .addGap(16, 16, 16)
                .addComponent(ButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        ButtonsLayout.setVerticalGroup(
            ButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ButtonsLayout.createSequentialGroup()
                .addGroup(ButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        getContentPane().add(Buttons);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    void returnToMembersList() {
        this.dispose();
        new MembersListForm().setVisible(true);
    }

    private void GoBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GoBackButtonMouseClicked
        returnToMembersList();
    }//GEN-LAST:event_GoBackButtonMouseClicked

    private void ButtonDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonDeleteMouseClicked
        int isSure = JOptionPane.showConfirmDialog(null, "¿Estás seguro de borrar el socio?", "Borrar el libro", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (isSure == JOptionPane.NO_OPTION) {
            return;
        }

        try {
            MemberStore.delete(db, dni);
            JOptionPane.showMessageDialog(null, "Socio eliminado correctamente.");
            returnToMembersList();
        } catch (HeadlessException ex) {
            System.out.println(ex);
        }

    }//GEN-LAST:event_ButtonDeleteMouseClicked

    private void ButtonEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonEditMouseClicked
        editingLogic();
    }//GEN-LAST:event_ButtonEditMouseClicked

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
            java.util.logging.Logger.getLogger(MemberDetailsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemberDetailsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemberDetailsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemberDetailsForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MemberDetailsForm("47155476").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonDelete;
    private javax.swing.JButton ButtonEdit;
    private javax.swing.JPanel Buttons;
    private javax.swing.JTextField FieldDni;
    private javax.swing.JTextField FieldName;
    private javax.swing.JTextField FieldSurname;
    private javax.swing.JPanel Fields;
    private javax.swing.JPanel FieldsContainer;
    private javax.swing.JButton GoBackButton;
    private javax.swing.JPanel Header;
    private javax.swing.JLabel Title;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
