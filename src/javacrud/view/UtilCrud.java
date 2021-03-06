/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacrud.view;

import java.sql.Connection;
import java.sql.Statement;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javacrud.control.ImageDAO;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javacrud.gestUtil.Utilisateur;
import javacrud.control.UtilisateurDAOImp;
import javacrud.gestUtil.Commune;
import javax.swing.ImageIcon;

/**
 *
 * @author j.bory
 */
public class UtilCrud extends javax.swing.JFrame {

    Connection con;
    Statement st;
    TreeMap<String, Utilisateur> lesUtilisateurs = new TreeMap<String, Utilisateur>();
    UtilisateurDAOImp dao = new UtilisateurDAOImp();
    Utilisateur utilisateur = new Utilisateur();
    String uiNumpost;
    private Commune selectedVille;

    /**
     * Creates new form UtilCrud
     */
    public UtilCrud() {
        initComponents();
        message.setText("Veuillez choisir un utilisateur dans le tableau de droite ou saisir les données à créer");
        chargerLesUtilisateurs();
    }

    private void chargerLesUtilisateurs() {
        lesUtilisateurs.clear();
        lesUtilisateurs = dao.List();
        chargerTableauUtilisateurs();
        
    }

    private void chargerTableauUtilisateurs() {
        DefaultTableModel uiTable = (DefaultTableModel) tbUtilisateur.getModel();

        int j = uiTable.getRowCount();

        for (int i = j - 1; i >= 0; i--) {
            uiTable.removeRow(i);
        }
        for (String pseudo : lesUtilisateurs.keySet()) {
            Utilisateur unUtilisateur = lesUtilisateurs.get(pseudo);
            Object[] row = new Object[3];
            row[0] = unUtilisateur.getUt_nom();
            row[1] = unUtilisateur.getUt_prenom();
            row[2] = unUtilisateur.getUt_pseudo();

            uiTable.addRow(row);
        }
        
    }

    public void changeSelectUt() {
        int i = tbUtilisateur.getSelectedRow();
        TableModel model = tbUtilisateur.getModel();
        Utilisateur unUtilisateur = lesUtilisateurs.get(model.getValueAt(i, 2).toString());
        uiPseudo.setText(unUtilisateur.getUt_pseudo());
        uiNom.setText(unUtilisateur.getUt_nom());
        uiPrenom.setText(unUtilisateur.getUt_prenom());
        uiMP.setText(unUtilisateur.getUt_mp());
        uiMail.setText(unUtilisateur.getUt_mail());
        uiAdr1.setText(unUtilisateur.getUt_adr1());
        uiAdr2.setText(unUtilisateur.getUt_adr2());
        uiCdpost.setText(unUtilisateur.getUt_cdpost());
        uiCommune.setText(unUtilisateur.getUt_commune());
        chargePhotoUt();
    }

    public void alert(String msg) {
        JOptionPane.showMessageDialog(rootPane, msg);
        message.setForeground(new java.awt.Color(51, 102, 0));
        message.setText(msg);
    }

    public void alert(String msg, String titre) {
        JOptionPane.showMessageDialog(rootPane, msg, titre, JOptionPane.ERROR_MESSAGE);
        message.setForeground(new java.awt.Color(204, 0, 51));
        message.setText(msg);
    }
    private void chargePhotoUt() {
        ImageIcon photo = ImageDAO.getUtIcon(this.uiPseudo.getText());
        if (photo != null) {
            this.Avatar.setIcon(photo);
        } else {
            this.Avatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/user-tie_.jpg")));
        }
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanelSaisie = new javax.swing.JPanel();
        Creer = new javax.swing.JButton();
        Modifier = new javax.swing.JButton();
        Supprimer = new javax.swing.JButton();
        Vider = new javax.swing.JButton();
        jLabelNom = new javax.swing.JLabel();
        uiNom = new javax.swing.JTextField();
        jLabelPrenom = new javax.swing.JLabel();
        uiPrenom = new javax.swing.JTextField();
        jLabelPseudo = new javax.swing.JLabel();
        uiPseudo = new javax.swing.JTextField();
        jLabelMail = new javax.swing.JLabel();
        uiMail = new javax.swing.JTextField();
        jLabelMP = new javax.swing.JLabel();
        uiMP = new javax.swing.JTextField();
        jLabelAdr1 = new javax.swing.JLabel();
        uiAdr1 = new javax.swing.JTextField();
        jLabelAdr2 = new javax.swing.JLabel();
        uiAdr2 = new javax.swing.JTextField();
        Ville = new javax.swing.JButton();
        uiCommune = new javax.swing.JTextField();
        jLabelCdpost = new javax.swing.JLabel();
        uiCdpost = new javax.swing.JTextField();
        Photo = new javax.swing.JButton();
        jPanelAvatar = new javax.swing.JPanel();
        Avatar = new javax.swing.JLabel();
        tbScrollPane = new javax.swing.JScrollPane();
        tbUtilisateur = new javax.swing.JTable();
        Entete = new javax.swing.JLabel();
        Parametre = new javax.swing.JButton();
        Mailer = new javax.swing.JButton();
        Quitter = new javax.swing.JButton();
        AuSujet = new javax.swing.JButton();
        Background = new javax.swing.JLabel();
        message = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 680));
        getContentPane().setLayout(null);

        jPanelSaisie.setMinimumSize(new java.awt.Dimension(560, 450));

        Creer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/plus_20.png"))); // NOI18N
        Creer.setText("Creer");
        Creer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreerMouseClicked(evt);
            }
        });
        Creer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreerActionPerformed(evt);
            }
        });

        Modifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/pencil_20.png"))); // NOI18N
        Modifier.setText("Modifier");
        Modifier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ModifierMouseClicked(evt);
            }
        });

        Supprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/minus_20.png"))); // NOI18N
        Supprimer.setText("Supprimer");
        Supprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SupprimerMouseClicked(evt);
            }
        });
        Supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupprimerActionPerformed(evt);
            }
        });

        Vider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/eye-slash_20.png"))); // NOI18N
        Vider.setText("Nouveau");
        Vider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ViderMouseClicked(evt);
            }
        });

        jLabelNom.setText("Nom : ");

        jLabelPrenom.setText("Prénom");

        uiPrenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uiPrenomActionPerformed(evt);
            }
        });

        jLabelPseudo.setText("Utilisateur");

        jLabelMail.setText("Mail");

        uiMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uiMailActionPerformed(evt);
            }
        });

        jLabelMP.setText("Mot de Passe");

        jLabelAdr1.setText("Adresse 1");

        uiAdr1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uiAdr1ActionPerformed(evt);
            }
        });

        jLabelAdr2.setText("Adresse 2");

        Ville.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/info-circle_20.png"))); // NOI18N
        Ville.setText("Ville");
        Ville.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VilleMouseClicked(evt);
            }
        });
        Ville.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VilleActionPerformed(evt);
            }
        });

        jLabelCdpost.setText("Code Postal");

        uiCdpost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uiCdpostActionPerformed(evt);
            }
        });

        Photo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/list_20.png"))); // NOI18N
        Photo.setText("Photo");
        Photo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PhotoMouseClicked(evt);
            }
        });
        Photo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhotoActionPerformed(evt);
            }
        });

        Avatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/user-tie-min.png"))); // NOI18N

        javax.swing.GroupLayout jPanelAvatarLayout = new javax.swing.GroupLayout(jPanelAvatar);
        jPanelAvatar.setLayout(jPanelAvatarLayout);
        jPanelAvatarLayout.setHorizontalGroup(
            jPanelAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAvatarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Avatar)
                .addGap(21, 21, 21))
        );
        jPanelAvatarLayout.setVerticalGroup(
            jPanelAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAvatarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Avatar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelSaisieLayout = new javax.swing.GroupLayout(jPanelSaisie);
        jPanelSaisie.setLayout(jPanelSaisieLayout);
        jPanelSaisieLayout.setHorizontalGroup(
            jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSaisieLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSaisieLayout.createSequentialGroup()
                        .addComponent(Creer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Modifier)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Supprimer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Vider)
                        .addContainerGap())
                    .addGroup(jPanelSaisieLayout.createSequentialGroup()
                        .addComponent(jLabelCdpost)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Ville)
                        .addGap(18, 18, 18)
                        .addComponent(uiCommune, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelSaisieLayout.createSequentialGroup()
                        .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanelSaisieLayout.createSequentialGroup()
                                    .addComponent(jLabelPseudo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(uiPseudo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelSaisieLayout.createSequentialGroup()
                                    .addComponent(jLabelNom)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(uiNom, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelSaisieLayout.createSequentialGroup()
                                    .addComponent(jLabelAdr2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(uiCdpost, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(uiAdr2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanelSaisieLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(uiAdr1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(uiMail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanelSaisieLayout.createSequentialGroup()
                                            .addComponent(jLabelMP)
                                            .addGap(28, 28, 28)
                                            .addComponent(uiMP, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(uiPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabelMail)
                            .addComponent(jLabelPrenom)
                            .addComponent(jLabelAdr1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSaisieLayout.createSequentialGroup()
                                .addComponent(jPanelAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSaisieLayout.createSequentialGroup()
                                .addComponent(Photo)
                                .addGap(69, 69, 69))))))
        );
        jPanelSaisieLayout.setVerticalGroup(
            jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSaisieLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelSaisieLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(uiNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNom))
                        .addGap(13, 13, 13)
                        .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPrenom)
                            .addComponent(uiPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(uiPseudo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPseudo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMail)
                            .addComponent(uiMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelMP)
                            .addComponent(uiMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uiAdr1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAdr1)
                    .addComponent(Photo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAdr2)
                    .addComponent(uiAdr2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCdpost)
                    .addComponent(uiCdpost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ville)
                    .addComponent(uiCommune, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanelSaisieLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Creer)
                    .addComponent(Modifier)
                    .addComponent(Supprimer)
                    .addComponent(Vider))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelSaisie);
        jPanelSaisie.setBounds(340, 80, 560, 440);

        tbScrollPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbScrollPaneMouseClicked(evt);
            }
        });
        tbScrollPane.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbScrollPaneKeyReleased(evt);
            }
        });

        tbUtilisateur.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom", "Prénom", "Utilisateur"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbUtilisateur.setOpaque(false);
        tbUtilisateur.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbUtilisateur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUtilisateurMouseClicked(evt);
            }
        });
        tbScrollPane.setViewportView(tbUtilisateur);
        if (tbUtilisateur.getColumnModel().getColumnCount() > 0) {
            tbUtilisateur.getColumnModel().getColumn(2).setResizable(false);
        }
        tbUtilisateur.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(tbScrollPane);
        tbScrollPane.setBounds(10, 80, 310, 340);

        Entete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/java_64.png"))); // NOI18N
        Entete.setText("CRUD SIMPLIFIE : GESTION DES UTILISATEURS ET AUTRES RESSOURCES");
        getContentPane().add(Entete);
        Entete.setBounds(0, 10, 800, 60);

        Parametre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/wrench._20.png"))); // NOI18N
        Parametre.setText("Paramètres");
        Parametre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ParametreMouseClicked(evt);
            }
        });
        getContentPane().add(Parametre);
        Parametre.setBounds(10, 510, 160, 30);

        Mailer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/envelope_20.png"))); // NOI18N
        Mailer.setText("Mail");
        Mailer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MailerMouseClicked(evt);
            }
        });
        Mailer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MailerActionPerformed(evt);
            }
        });
        getContentPane().add(Mailer);
        Mailer.setBounds(420, 530, 76, 30);

        Quitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/escape_20.png"))); // NOI18N
        Quitter.setText("Quitter");
        Quitter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                QuitterMouseClicked(evt);
            }
        });
        Quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitterActionPerformed(evt);
            }
        });
        getContentPane().add(Quitter);
        Quitter.setBounds(710, 530, 90, 30);

        AuSujet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/info-circle_20.png"))); // NOI18N
        AuSujet.setText("Au Sujet");
        AuSujet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AuSujetMouseClicked(evt);
            }
        });
        AuSujet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AuSujetActionPerformed(evt);
            }
        });
        getContentPane().add(AuSujet);
        AuSujet.setBounds(560, 530, 99, 30);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressource/back_ec.jpg"))); // NOI18N
        Background.setText("jLabel2");
        getContentPane().add(Background);
        Background.setBounds(0, 70, 910, 500);

        message.setText("jLabel2");
        getContentPane().add(message);
        message.setBounds(280, 410, 34, 15);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MailerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MailerMouseClicked
        /*this.dispose();
        new Mail("jeremy.bory@st2msi.net").setVisible(true);*/
        Utilisateur unUtil = new Utilisateur();
        System.out.println(unUtil.getUt_mail());
        try {
            new Mail(uiMail.getText()).setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(UtilCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_MailerMouseClicked

    private void QuitterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QuitterMouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_QuitterMouseClicked

    private void AuSujetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AuSujetMouseClicked
        About auSujet = new About();
        auSujet.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_AuSujetMouseClicked

    private void tbScrollPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbScrollPaneMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbScrollPaneMouseClicked

    private void tbScrollPaneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbScrollPaneKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tbScrollPaneKeyReleased

    private void QuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QuitterActionPerformed

    private void AuSujetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AuSujetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AuSujetActionPerformed

    private void tbUtilisateurMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUtilisateurMouseClicked
        // TODO add your handling code here:
        changeSelectUt();
    }//GEN-LAST:event_tbUtilisateurMouseClicked

    private void MailerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MailerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MailerActionPerformed

    private void PhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhotoActionPerformed
        
    }//GEN-LAST:event_PhotoActionPerformed

    private void uiCdpostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uiCdpostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uiCdpostActionPerformed

    private void VilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VilleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VilleActionPerformed

    private void VilleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VilleMouseClicked
        if (uiCdpost.getText().strip().length() == 5) {
            SelectVille uneVille;
            String cdpost = uiCdpost.getText();
            uneVille = new SelectVille(new javax.swing.JFrame(), true, Integer.parseInt(cdpost), uiNumpost);

            uneVille.setVisible(true);
            this.selectedVille = uneVille.getSelectedVille();

            if (uneVille.getSelected()) {
                uiNumpost = selectedVille.getNum_Postal();
                uiCommune.setText(selectedVille.getNom_Commune());
            } else {
                //alert("Le code postal doit contenir au moins 5 chiffres");
            }

        }

    }//GEN-LAST:event_VilleMouseClicked

    private void uiAdr1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uiAdr1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uiAdr1ActionPerformed

    private void uiMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uiMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uiMailActionPerformed

    private void uiPrenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uiPrenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uiPrenomActionPerformed

    private void ViderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ViderMouseClicked
        // TODO add your handling code here:
        int i = tbUtilisateur.getSelectedRow();
        TableModel model = tbUtilisateur.getModel();
        Utilisateur unUtilisateur = lesUtilisateurs.get(model.getValueAt(i, 2).toString());
        uiNom.setText(null);
        uiPrenom.setText(null);
        uiPseudo.setText(null);
        uiMail.setText(null);
        uiMP.setText(null);
        uiAdr1.setText(null);
        uiAdr2.setText(null);
        uiCdpost.setText(null);
        uiNumpost = null;
        uiCommune.setText(null);
        Avatar.setText(null);
    }//GEN-LAST:event_ViderMouseClicked

    private void SupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupprimerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SupprimerActionPerformed

    private void SupprimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupprimerMouseClicked
        Utilisateur unUtil = new Utilisateur();
        unUtil.setUt_pseudo(uiPseudo.getText());
        dao.delete(unUtil);
        lesUtilisateurs.remove(uiPseudo.getText());
        chargerTableauUtilisateurs();
    }//GEN-LAST:event_SupprimerMouseClicked

    private void ModifierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ModifierMouseClicked
        Utilisateur unUtil = new Utilisateur();
        String pseudo = uiPseudo.getText();
        String mdp = uiMP.getText();
        String phrase = unUtil.updateUtMp(mdp);
        unUtil.setUt_pseudo(pseudo);
        unUtil.setUt_nom(uiNom.getText());
        unUtil.setUt_prenom(uiPrenom.getText());
        unUtil.setUt_mp(uiMP.getText());
        unUtil.setUt_phrase(phrase);
        unUtil.setUt_mail(uiMail.getText());
        unUtil.setUt_adr1(uiAdr1.getText());
        unUtil.setUt_adr2(uiAdr2.getText());
        unUtil.setUt_cdpost(uiCdpost.getText());
        unUtil.setUt_numpost("0");

        chargerTableauUtilisateurs();
        dao.update(unUtil);
    }//GEN-LAST:event_ModifierMouseClicked

    private void CreerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreerActionPerformed

    private void CreerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreerMouseClicked
        // TODO add your handling code here:*
        Utilisateur unUtilisateur = new Utilisateur();

        String mdp = uiMP.getText();
        String phrase = unUtilisateur.updateUtMp(mdp);
        unUtilisateur.setUt_pseudo(uiPseudo.getText());
        unUtilisateur.setUt_nom(uiNom.getText());
        unUtilisateur.setUt_prenom(uiPrenom.getText().toString());
        unUtilisateur.setUt_mp(uiMP.getText());

        unUtilisateur.setUt_phrase(phrase);
        unUtilisateur.setUt_mail(uiMail.getText());
        unUtilisateur.setUt_adr1(uiAdr1.getText());
        unUtilisateur.setUt_adr2(uiAdr2.getText());
        unUtilisateur.setUt_cdpost(uiCdpost.getText());
        unUtilisateur.setUt_numpost("0");

        lesUtilisateurs.put("0", unUtilisateur);

        chargerTableauUtilisateurs();
        dao.create(unUtilisateur);

    }//GEN-LAST:event_CreerMouseClicked

    private void PhotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PhotoMouseClicked
        SelectAvatar sa;
        Boolean photo = true;
        try {
            sa = new SelectAvatar(new javax.swing.JFrame(), true, uiPseudo.getText());
            sa.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(UtilCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PhotoMouseClicked

    private void ParametreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ParametreMouseClicked
        // TODO add your handling code here:
        Parametre p;
        try {
            p = new Parametre(new javax.swing.JFrame(), true);
            p.setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(UtilCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ParametreMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus 2000 look and feel */
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
            java.util.logging.Logger.getLogger(UtilCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UtilCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UtilCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UtilCrud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UtilCrud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AuSujet;
    private javax.swing.JLabel Avatar;
    private javax.swing.JLabel Background;
    private javax.swing.JButton Creer;
    private javax.swing.JLabel Entete;
    private javax.swing.JButton Mailer;
    private javax.swing.JButton Modifier;
    private javax.swing.JButton Parametre;
    private javax.swing.JButton Photo;
    private javax.swing.JButton Quitter;
    private javax.swing.JButton Supprimer;
    private javax.swing.JButton Vider;
    private javax.swing.JButton Ville;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAdr1;
    private javax.swing.JLabel jLabelAdr2;
    private javax.swing.JLabel jLabelCdpost;
    private javax.swing.JLabel jLabelMP;
    private javax.swing.JLabel jLabelMail;
    private javax.swing.JLabel jLabelNom;
    private javax.swing.JLabel jLabelPrenom;
    private javax.swing.JLabel jLabelPseudo;
    private javax.swing.JPanel jPanelAvatar;
    private javax.swing.JPanel jPanelSaisie;
    private javax.swing.JLabel message;
    private javax.swing.JScrollPane tbScrollPane;
    private javax.swing.JTable tbUtilisateur;
    private javax.swing.JTextField uiAdr1;
    private javax.swing.JTextField uiAdr2;
    private javax.swing.JTextField uiCdpost;
    private javax.swing.JTextField uiCommune;
    private javax.swing.JTextField uiMP;
    private javax.swing.JTextField uiMail;
    private javax.swing.JTextField uiNom;
    private javax.swing.JTextField uiPrenom;
    private javax.swing.JTextField uiPseudo;
    // End of variables declaration//GEN-END:variables
}
