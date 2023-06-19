/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import controladores.ObraJpaController;
import controladores.UsuarioJpaController;
import controladores.exceptions.NonexistentEntityException;
import entidades.Obra;
import entidades.Usuario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;

/**
 *
 * @author 34616
 */
public class GestionObras extends javax.swing.JFrame {

    private static UsuarioJpaController ujc;
    private static ObraJpaController ojc;

    public GestionObras() {
        ujc = new UsuarioJpaController(Persistence.createEntityManagerFactory("artebd"));
        ojc = new ObraJpaController(Persistence.createEntityManagerFactory("artebd"));
        initComponents();
        this.setLocationRelativeTo(null);
        String listaToString = "Codigo\t Nombre \t Autor \t Descripcion \t Año \t Categoría \n";
        List<Obra> lista = ojc.findObraEntities();
        for (Obra o : lista) {
            listaToString += o.toString();
        }

        tabla.setText(listaToString);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTextArea();
        nombreObra = new javax.swing.JLabel();
        nombreInsert = new javax.swing.JTextField();
        descrip = new javax.swing.JLabel();
        categoriaInsert = new javax.swing.JTextField();
        categoria = new javax.swing.JLabel();
        descripcionInsert = new javax.swing.JTextField();
        codAutor = new javax.swing.JLabel();
        codAutorInsert = new javax.swing.JTextField();
        codObra = new javax.swing.JLabel();
        codObraInsert = new javax.swing.JTextField();
        insertar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        info = new javax.swing.JLabel();
        atras = new javax.swing.JButton();
        imagenFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFondo.setBackground(new java.awt.Color(255, 255, 255));
        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setBackground(new java.awt.Color(255, 255, 255));
        titulo.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        titulo.setForeground(new java.awt.Color(165, 1, 17));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        titulo.setText("Obra");
        panelFondo.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 160, 60));

        tabla.setEditable(false);
        tabla.setColumns(20);
        tabla.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabla.setRows(5);
        jScrollPane1.setViewportView(tabla);

        panelFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 800, 290));

        nombreObra.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nombreObra.setForeground(new java.awt.Color(230, 123, 133));
        nombreObra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nombreObra.setText("Título");
        panelFondo.add(nombreObra, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, 120, 30));

        nombreInsert.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nombreInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreInsertActionPerformed(evt);
            }
        });
        panelFondo.add(nombreInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, 280, 30));

        descrip.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        descrip.setForeground(new java.awt.Color(230, 123, 133));
        descrip.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        descrip.setText("Categoría");
        panelFondo.add(descrip, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 560, 120, 30));

        categoriaInsert.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        categoriaInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaInsertActionPerformed(evt);
            }
        });
        panelFondo.add(categoriaInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 560, 280, 30));

        categoria.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        categoria.setForeground(new java.awt.Color(230, 123, 133));
        categoria.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        categoria.setText("Descripcion");
        panelFondo.add(categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, 120, 30));

        descripcionInsert.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        descripcionInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descripcionInsertActionPerformed(evt);
            }
        });
        panelFondo.add(descripcionInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, 280, 30));

        codAutor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        codAutor.setForeground(new java.awt.Color(230, 123, 133));
        codAutor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        codAutor.setText("Código obra");
        panelFondo.add(codAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 600, 170, 30));

        codAutorInsert.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        codAutorInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codAutorInsertActionPerformed(evt);
            }
        });
        panelFondo.add(codAutorInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 600, 60, 30));

        codObra.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        codObra.setForeground(new java.awt.Color(230, 123, 133));
        codObra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        codObra.setText("Código autor");
        panelFondo.add(codObra, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 600, 170, 30));

        codObraInsert.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        codObraInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codObraInsertActionPerformed(evt);
            }
        });
        panelFondo.add(codObraInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 600, 60, 30));

        insertar.setBackground(new java.awt.Color(217, 135, 143));
        insertar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        insertar.setForeground(new java.awt.Color(255, 255, 255));
        insertar.setText("Insertar");
        insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarActionPerformed(evt);
            }
        });
        panelFondo.add(insertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 480, 100, 30));

        eliminar.setBackground(new java.awt.Color(217, 135, 143));
        eliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        eliminar.setForeground(new java.awt.Color(255, 255, 255));
        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        panelFondo.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 520, 100, 30));

        actualizar.setBackground(new java.awt.Color(217, 135, 143));
        actualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        actualizar.setForeground(new java.awt.Color(255, 255, 255));
        actualizar.setText("Actualizar");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });
        panelFondo.add(actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 480, 100, 30));

        info.setBackground(new java.awt.Color(255, 255, 255));
        info.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        info.setForeground(new java.awt.Color(103, 181, 181));
        panelFondo.add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 600, 390, 30));

        atras.setBackground(new java.awt.Color(217, 135, 143));
        atras.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        atras.setForeground(new java.awt.Color(255, 255, 255));
        atras.setText("Atras");
        atras.setMaximumSize(new java.awt.Dimension(83, 23));
        atras.setMinimumSize(new java.awt.Dimension(83, 23));
        atras.setPreferredSize(new java.awt.Dimension(83, 23));
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });
        panelFondo.add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 520, 100, 30));

        imagenFondo.setIcon(new javax.swing.ImageIcon("C:\\Users\\FX506\\Documents\\NetBeansProjects\\ejersRecuProg\\ProyectoFinalNoeliaP\\src\\main\\resources\\fotos\\menu2.jpeg")); // NOI18N
        imagenFondo.setText("jLabel1");
        panelFondo.add(imagenFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 660));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void categoriaInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriaInsertActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoriaInsertActionPerformed

    private void nombreInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreInsertActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreInsertActionPerformed

    private void insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarActionPerformed

        ojc.create(new Obra(nombreInsert.getText(), categoriaInsert.getText(), descripcionInsert.getText(), new Usuario(Integer.valueOf(codAutorInsert.getText()))));
        categoriaInsert.setText("");
        nombreInsert.setText("");
        descripcionInsert.setText("");
        codAutorInsert.setText("");
        info.setText("Obra introducida correctamente");
        String listaToString = "Codigo\t Nombre \t Autor \t Descripcion \t Año \t Categoría \n";
        List<Obra> lista = ojc.findObraEntities();
        for (Obra o : lista) {
            listaToString += o.toString();
        }

        tabla.setText(listaToString);
    }//GEN-LAST:event_insertarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed

        try {
            ojc.destroy(Integer.valueOf(codObraInsert.getText()));
            info.setText("Obra con codigo " + codObraInsert.getText() + " eliminada correctamente");
        } catch (NonexistentEntityException ex) {
            info.setText("Codigo erroneo, introduzca un codigo valido");
        }
        codObraInsert.setText("");
        String listaToString = "Codigo\t Nombre \t Autor \t Descripcion \t Año \t Categoría \n";
        List<Obra> lista = ojc.findObraEntities();
        for (Obra o : lista) {
            listaToString += o.toString();
        }

        tabla.setText(listaToString);
    }//GEN-LAST:event_eliminarActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        try {
            Obra o=ojc.findObra(Integer.valueOf(codObraInsert.getText()));
            ojc.edit(new Obra(Integer.valueOf(codObraInsert.getText()),nombreInsert.getText(), categoriaInsert.getText(), o.getAñoPublicacion(), descripcionInsert.getText(), o.getAutorId(), o.getPuntuacion()));
            info.setText("Obra con codigo " + codObraInsert.getText() + " modificada correctamente");
        } catch (Exception ex) {
            info.setText("Codigo erroneo, introduzca un codigo valido");
        }
        categoriaInsert.setText("");
        nombreInsert.setText("");
        descripcionInsert.setText("");
        codAutorInsert.setText("");
        String listaToString = "Codigo\t Nombre \t Autor \t Descripcion \t Año \t Categoría \n";
        List<Obra> lista = ojc.findObraEntities();
        for (Obra o : lista) {
            listaToString += o.toString();
        }

        tabla.setText(listaToString);
    }//GEN-LAST:event_actualizarActionPerformed

    private void codAutorInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codAutorInsertActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codAutorInsertActionPerformed

    private void atrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasActionPerformed
        VentanaPrincipal v = new VentanaPrincipal();
        v.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_atrasActionPerformed

    private void descripcionInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descripcionInsertActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descripcionInsertActionPerformed

    private void codObraInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codObraInsertActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codObraInsertActionPerformed

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
            java.util.logging.Logger.getLogger(GestionObras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionObras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionObras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionObras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GestionObras().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JButton atras;
    private javax.swing.JLabel categoria;
    private javax.swing.JTextField categoriaInsert;
    private javax.swing.JLabel codAutor;
    private javax.swing.JTextField codAutorInsert;
    private javax.swing.JLabel codObra;
    private javax.swing.JTextField codObraInsert;
    private javax.swing.JLabel descrip;
    private javax.swing.JTextField descripcionInsert;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel imagenFondo;
    private javax.swing.JLabel info;
    private javax.swing.JButton insertar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreInsert;
    private javax.swing.JLabel nombreObra;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JTextArea tabla;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
