package com.company.ProgramGeneratorZapytanSQlite;

import javax.swing.*;
import java.awt.*;
import java.io.File;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProgramGeneratorZapytanSQlite {
    private String[] przyciski = new String[]{"Moj_1_Mojzeszowa", "Moj_2_Mojzeszowa", "Moj_3_Mojzeszowa", "Moj_4_Mojzeszowa", "Moj_5_Mojzeszowa", "Ksiega_Jozuego", "Ksiega_Sedziow",
            "Ksiega_Rut", "Ksiega_I_Samuel", "Ksiega_II_Samuel", "I_Ksiega_Krolewska", "II_Ksiega_Krolewska", "I_Ksiega_Kronik", "II_Księga Kronik", "Ksiega_Ezdrasza", "Ksiega_Nehemiasza",
            "Ksiega_Estery", "Ksiega_Hioba", "Psalmy", "Ksiega_Przyslow", "Ksiega_Kaznodziei", "Piesn_Nad_Piesniami", "Ksiega_Izajasza", "Ksiega_Jeremiasza", "Lamentacje", "Ksiega_Ezechiela",
            "Ksiega_Daniela", "Ksiega_Ozeasza", "Ksiega_Joela", "Ksiega_Amosa", "Ksiega_Abdiasza", "Ksiega_Jonasza", "Ksiega_Micheasza", "Ksiega_Nahuma", "Ksiega_Habakuka", "Ksiega_Sofoniasza",
            "Ksiega_Aggeusza", "Ksiega_Zachariasza", "Ksiega_Malachiasza", "Ewangelia_Mateusza", "Ewangelia_Marka", "Ewangelia_Lukasza", "Ewangelia_Jana", "Dzieje_Apostolskie", "List_Do_Rzymian",
            "I_List_Do_Koryntian", "II_List_Do_Koryntian", "List_Do_Galacjan", "List_Do_Efezjan", "List_Do_Filipian", "List_Do_Kolosan", "I_List_Do_Tesaloniczan", "II_List_Do_Tesaloniczan",
            "I_List_Do_Tymoteusza", "II_List_Do_Tymoteusza", "List_Do_Tytusa", "List_Do_Filemona", "List_Do_Hebrajczykow", "List_Jakuba", "I_List_Piotra", "II_List_Piotra", "I_List_Jana", "II_List_Jana",
            "III_List_Jana", "List_Judy", "Ksiega_Objawienia"};

    ZapisOdczytPliku zapisOdczytPliku = new ZapisOdczytPliku();


    private List<String> listaTabel = new ArrayList<>(3);
    private String sciezkaDoBazyDanych = zapisOdczytPliku.readFromPosition(0);
    private String nazwaKsiegi = zapisOdczytPliku.readFromPosition(50);
    private String rowid = zapisOdczytPliku.readFromPosition(100);
    private String rozdzialy = zapisOdczytPliku.readFromPosition(200);
    private String temat = zapisOdczytPliku.readFromPosition(300);
    private String obszar_1 = zapisOdczytPliku.readFromPosition(400);
    private String obszar_2 = zapisOdczytPliku.readFromPosition(5000);

    JTextArea obszarTekstowy1;
    JTextArea obszarTekstowy2;
    JTextArea obszarTekstowy3;
    JLabel JLrowid = new JLabel(rowid);
    JLabel JLsciezkabazydanych = new JLabel(sciezkaDoBazyDanych);
    JLabel JLrozdzialy = new JLabel(rozdzialy);
    JLabel JLtemat = new JLabel(temat);


    private JButton buttonprzyciskiKsiag(String Nazwa) {
        JButton ksiegaDodawana = new JButton(Nazwa);
        obszarTekstowy1.setText(obszar_1);
        obszarTekstowy2.setText(obszar_2);
        obszarTekstowy3.setText(obszar_1 + "\n" + obszar_2);


        ksiegaDodawana.addActionListener(actionEvent -> {
            String ksiegaDodawana1 = actionEvent.getActionCommand() + "_Komentarze ";
            obszarTekstowy1.append("\n|| ifnull(" + ksiegaDodawana1 + "._99_Komentarz, \"\")");
            obszarTekstowy2.append("\n\t LEFT JOIN " + ksiegaDodawana1 + " ON " + ksiegaDodawana1 + "._97_Komentarz_rowid=" + JLtemat.getText() + " AND " + ksiegaDodawana1 + "._98_Dotyczy_Ksiegi=" + zamienNazweKsieginaNumer(nazwaKsiegi));


            zapisOdczytPliku.writeToPosition(obszarTekstowy1.getText(), 400, 5000);
            zapisOdczytPliku.writeToPosition(obszarTekstowy2.getText(), 5000, 10000);

            obszarTekstowy3.setText(obszarTekstowy1.getText() + "\n" + obszarTekstowy2.getText());

        });


        return ksiegaDodawana;
    }

    private JComboBox<String> comboBoxNazwaKsiegi() {
        DefaultComboBoxModel<String> modelBoxNazwaKsiegi = new DefaultComboBoxModel<>(przyciski);
        JComboBox<String> comboNazwaKsiegi = new JComboBox<>(modelBoxNazwaKsiegi);

        comboNazwaKsiegi.setSelectedItem(nazwaKsiegi);

        comboNazwaKsiegi.addActionListener(e -> {
            JComboBox wybor = (JComboBox) e.getSource();
            nazwaKsiegi = (Objects.requireNonNull(wybor.getSelectedItem())).toString();

            polaczZBazaDanych(nazwaKsiegi + "_Komentarze", sciezkaDoBazyDanych);

            JLrowid.setText(listaTabel.get(0));
            JLrozdzialy.setText(listaTabel.get(1));
            JLtemat.setText(listaTabel.get(2));


            obszarTekstowy1.setText("SELECT " + "" + nazwaKsiegi + "_Komentarze." + listaTabel.get(1) + ",Bible.Verse,Bible.Verse,Bible.Scripture \n" + nazwaKsiegi + "_Komentarze." + listaTabel.get(0));
            obszarTekstowy2.setText("\n\tAS " + listaTabel.get(0) + " FROM Bible INNER JOIN " + nazwaKsiegi + " ON " + listaTabel.get(2) + "=Bible._rowid_");
            obszarTekstowy3.setText(obszarTekstowy1.getText() + "\n" + obszarTekstowy2.getText());
            zapisOdczytPliku.writeToPosition(nazwaKsiegi, 50, 100);
            zapisOdczytPliku.writeToPosition(listaTabel.get(0), 100, 200);
            zapisOdczytPliku.writeToPosition(listaTabel.get(1), 200, 300);
            zapisOdczytPliku.writeToPosition(listaTabel.get(2), 300, 400);

        });
        return comboNazwaKsiegi;
    }

    private JLabel etykieta_nazwaksiegi() {
        return new JLabel("Nazwa Ksiegi", SwingConstants.CENTER);
    }

    private JLabel etykieta_rowid() {
        return new JLabel("RowId", SwingConstants.CENTER);
    }

    private JLabel etykieta_rozdzialy() {
        return new JLabel("Rozdziały", SwingConstants.CENTER);
    }

    private JLabel etykieta_temat() {
        return new JLabel("Temat", SwingConstants.CENTER);
    }

    private JLabel wyswietl_sciezkeBazyDanych() {
        return JLsciezkabazydanych;
    }

    private JLabel wyswietl_rowid() {
        return JLrowid;
    }

    private JLabel wyswietl_rozdzial() {
        return JLrozdzialy;
    }

    private JLabel wyswietl_teram() {
        return JLtemat;
    }


    private JButton btnfileChooser() {
        JButton btnfilechooser = new JButton("wybierz plik ...");
        btnfilechooser.addActionListener(actionEvent -> fileChoose());
        return btnfilechooser;
    }

    private JButton btncopy() {
        JButton copy = new JButton("copy");
        copy.addActionListener(actionEvent -> {
            obszarTekstowy3.selectAll();
            obszarTekstowy3.copy();
            copy.transferFocusBackward();
        });


        return copy;
    }

    private void fileChoose() {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSize(300, 300);
        fileChooser.setVisible(true);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            sciezkaDoBazyDanych = selectedFile.getAbsolutePath();
            zapisOdczytPliku.writeToPosition(sciezkaDoBazyDanych, 0, 50);
            JLsciezkabazydanych.setText(selectedFile.getAbsolutePath());

        }

    }


    private JScrollPane textArea1() {
        obszarTekstowy1 = new JTextArea();
        return new JScrollPane(obszarTekstowy1);
    }

    private JScrollPane textArea2() {
        obszarTekstowy2 = new JTextArea();
        return new JScrollPane(obszarTekstowy2);
    }

    private JScrollPane textArea3() {
        obszarTekstowy3 = new JTextArea();

        return new JScrollPane(obszarTekstowy3);
    }

    public JPanel generatorSQlite_panel_north() {
        JPanel panel_1 = new JPanel();
        panel_1.setLayout(new GridLayout(13, 6));
        for (int x = 0; x < 66; ++x) {
            panel_1.add(buttonprzyciskiKsiag(przyciski[x]));
        }
        panel_1.add(etykieta_nazwaksiegi());
        panel_1.add(btnfileChooser());
        panel_1.add(etykieta_rowid());
        panel_1.add(etykieta_rozdzialy());
        panel_1.add(etykieta_temat());
        panel_1.add(btncopy());
        panel_1.add(comboBoxNazwaKsiegi());
        panel_1.add(wyswietl_sciezkeBazyDanych());
        panel_1.add(wyswietl_rowid());
        panel_1.add(wyswietl_rozdzial());
        panel_1.add(wyswietl_teram());


        return panel_1;
    }

    public JPanel generatorSQlite_panel_center() {
        JPanel panel_2 = new JPanel();
        panel_2.setLayout(new GridLayout(1, 3));
        panel_2.add(textArea1());
        panel_2.add(textArea2());
        panel_2.add(textArea3());
        return panel_2;
    }

    private void polaczZBazaDanych(String nazwaKsiegi, String sciezkaBazydanych) {

        listaTabel.clear();
        listaTabel.addAll(BazaDanych.polacz(nazwaKsiegi, sciezkaBazydanych));


    }

    private String zamienNazweKsieginaNumer(String NazwaKsiegi) {
        switch (NazwaKsiegi) {
            case "Moj_1_Mojzeszowa":
                return "1";
            case "Moj_2_Mojzeszowa":
                return "2";
            case "Moj_3_Mojzeszowa":
                return "3";
            case "Moj_4_Mojzeszowa":
                return "4";
            case "Moj_5_Mojzeszowa":
                return "5";
            case "Ksiega_Jozuego":
                return "6";
            case "Ksiega_Sedziow":
                return "7";
            case "Ksiega_Rut":
                return "8";
            case "Ksiega_I_Samuel":
                return "9";
            case "Ksiega_II_Samuel":
                return "10";
            case "I_Ksiega_Krolewska":
                return "11";
            case "II_Ksiega_Krolewska":
                return "12";
            case "I_Ksiega_Kronik":
                return "13";
            case "II Księga Kronik":
                return "14";
            case "Ksiega_Ezdrasza":
                return "15";
            case "Ksiega_Nehemiasza":
                return "16";
            case "Ksiega_Estery":
                return "17";
            case "Ksiega_Hioba":
                return "18";
            case "Psalmy":
                return "19";
            case "Ksiega_Przyslow":
                return "20";
            case "Ksiega_Kaznodziei":
                return "21";
            case "Piesn_Nad_Piesniami":
                return "22";
            case "Ksiega_Izajasza":
                return "23";
            case "Ksiega_Jeremiasza":
                return "24";
            case "Lamentacje":
                return "25";
            case "Ksiega_Ezechiela":
                return "26";
            case "Ksiega_Daniela":
                return "27";
            case "Ksiega_Ozeasza":
                return "28";
            case "Ksiega_Joela":
                return "29";
            case "Ksiega_Amosa":
                return "30";
            case "Ksiega_Abdiasza":
                return "31";
            case "Ksiega_Jonasza":
                return "32";
            case "Ksiega_Micheasza":
                return "33";
            case "Ksiega_Nahuma":
                return "34";
            case "Ksiega_Habakuka":
                return "35";
            case "Ksiega_Sofoniasza":
                return "36";
            case "Ksiega_Aggeusza":
                return "37";
            case "Ksiega_Zachariasza":
                return "38";
            case "Ksiega_Malachiasza":
                return "39";
            case "Ewangelia_Mateusza":
                return "40";
            case "Ewangelia_Marka":
                return "41";
            case "Ewangelia_Lukasza":
                return "42";
            case "Ewangelia_Jana":
                return "43";
            case "Dzieje_Apostolskie":
                return "44";
            case "List_Do_Rzymian":
                return "45";
            case "I_List_Do_Koryntian":
                return "46";
            case "II_List_Do_Koryntian":
                return "47";
            case "List_Do_Galacjan":
                return "48";
            case "List_Do_Efezjan":
                return "49";
            case "List_Do_Filipian":
                return "50";
            case "List_Do_Kolosan":
                return "51";
            case "I_List_Do_Tesaloniczan":
                return "52";
            case "II_List_Do_Tesaloniczan":
                return "53";
            case "I_List_Do_Tymoteusza":
                return "54";
            case "II_List_Do_Tymoteusza":
                return "55";
            case "List_Do_Tytusa":
                return "56";
            case "List_Do_Filemona":
                return "57";
            case "List_Do_Hebrajczykow":
                return "58";
            case "List_Jakuba":
                return "59";
            case "I_List_Piotra":
                return "60";
            case "II_List_Piotra":
                return "61";
            case "I_List_Jana":
                return "62";
            case "II_List_Jana":
                return "63";
            case "III_List_Jana":
                return "64";
            case "List_Judy":
                return "65";
            case "Ksiega_Objawienia":
                return "66";
        }
        return "0";
    }
}
