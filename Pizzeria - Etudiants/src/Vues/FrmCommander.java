package Vues;

import Controlers.*;
import Tools.ConnexionBDD;
import Tools.ModelJTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class FrmCommander extends JFrame{
    private JPanel pnlRoot;
    private JLabel lblTitre;
    private JLabel lblNumCommande;
    private JTextField txtNumCommande;
    private JLabel lblClients;
    private JComboBox cboClients;
    private JLabel lblLivreurs;
    private JTable tblPizzas;
    private JComboBox cboLivreurs;
    private JButton btnCommander;

    private CtrlClient ctrlClient;
    private CtrlLivreur ctrlLivreur;

    private CtrlCommande ctrlCommande;






    public FrmCommander() throws SQLException, ClassNotFoundException {
        this.setTitle("Commander");
        this.setContentPane(pnlRoot);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);



        ConnexionBDD maCnx = new ConnexionBDD();

        // A vous de jouer

        ModelJTable mdl;


        ctrlClient = new CtrlClient();

        ctrlLivreur = new CtrlLivreur();

        ctrlCommande = new CtrlCommande();


        CtrlPizza pizza = new CtrlPizza();
        mdl = new ModelJTable();
        mdl.loadDatasPizzas(pizza.getAllPizzas());
        tblPizzas.setModel(mdl);


        remplirClient();
        remplitLivreur();






        btnCommander.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // A vous de jouer

                int ligneChoisie = tblPizzas.getSelectedRow();
                int derniereCommande = ctrlCommande.getDernierNumeroDeCommande();
                txtNumCommande.setText(String.valueOf(derniereCommande));





            }
        });
    }

    private void remplirClient() {
        ArrayList<String> clients = ctrlClient.getAllClients();
        for (String client : clients) {
            cboClients.addItem(client);
        }
    }

    private void remplitLivreur() {
        ArrayList<String> livreurs = ctrlLivreur.getAllLivreurs();
        for (String livreur : livreurs) {
            cboLivreurs.addItem(livreur);
        }
    }


}
