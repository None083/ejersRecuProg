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
        consultar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        info = new javax.swing.JLabel();
        atras = new javax.swing.JButton();
        imagenFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        titulo.setText("Obra");
        panelFondo.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 140, 40));

        tabla.setEditable(false);
        tabla.setColumns(20);
        tabla.setRows(5);
        jScrollPane1.setViewportView(tabla);

        panelFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 800, 290));

        nombreObra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        nombreObra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nombreObra.setText("Titulo");
        panelFondo.add(nombreObra, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 80, 30));

        nombreInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreInsertActionPerformed(evt);
            }
        });
        panelFondo.add(nombreInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, 230, 30));

        descrip.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        descrip.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        descrip.setText("Categoría");
        panelFondo.add(descrip, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 80, 30));

        categoriaInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaInsertActionPerformed(evt);
            }
        });
        panelFondo.add(categoriaInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 540, 230, 30));

        categoria.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        categoria.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        categoria.setText("Descripcion");
        panelFondo.add(categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, 80, 30));

        descripcionInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descripcionInsertActionPerformed(evt);
            }
        });
        panelFondo.add(descripcionInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 500, 230, 30));

        codAutor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        codAutor.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        codAutor.setText("Código obra");
        panelFondo.add(codAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 620, 130, 30));

        codAutorInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codAutorInsertActionPerformed(evt);
            }
        });
        panelFondo.add(codAutorInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 580, 60, 30));

        codObra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        codObra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        codObra.setText("Código autor");
        panelFondo.add(codObra, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 580, 130, 30));

        codObraInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codObraInsertActionPerformed(evt);
            }
        });
        panelFondo.add(codObraInsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 620, 60, 30));

        insertar.setText("Insertar");
        insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarActionPerformed(evt);
            }
        });
        panelFondo.add(insertar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 510, 80, -1));

        consultar.setText("Consultar");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });
        panelFondo.add(consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 510, -1, -1));

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        panelFondo.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 550, 80, -1));

        actualizar.setText("Actualizar");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });
        panelFondo.add(actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 550, -1, -1));
        panelFondo.add(info, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 490, 310, 30));

        atras.setText("Atras");
        atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasActionPerformed(evt);
            }
        });
        panelFondo.add(atras, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 550, -1, -1));

        imagenFondo.setIcon(new javax.swing.ImageIcon("C:\\Users\\34616\\Desktop\\programacion\\ProyectoFinalNoeliaP\\src\\main\\resources\\fotos\\menu 2.jpeg")); // NOI18N
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

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        String listaToString = "Codigo\t Nombre \t Autor \t Descripcion \t Año \t Categoría \n";
        List<Obra> lista = ojc.findObraEntities();
        for (Obra o : lista) {
            listaToString += o.toString();
        }

        tabla.setText(listaToString);
    }//GEN-LAST:event_consultarActionPerformed

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
    private javax.swing.JButton consultar;
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