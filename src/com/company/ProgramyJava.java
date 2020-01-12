package com.company;

import com.company.ProgramGeneratorZapytanSQlite.ProgramGeneratorZapytanSQlite;
import com.company.ProgramGeneratorZapytanSQlite.ZapisOdczytPliku;
import com.company.ProgramOdnosniki.ProgramOdnosniki;
import com.company.ProgramYouTubeDownload.ProgramYouTubeDownload;


import javax.swing.*;
import java.awt.*;
import java.io.File;


public class ProgramyJava {
    private JFrame frame;

    public ProgramyJava() {
        OknoGlowne();
        sprawdzCzyJestPlik();
    }
    private void OknoGlowne() {
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setSize(800, 800);
        frame.setTitle("Wszystkie Programy");
        frame.add(this.Panel_South(), "South");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private JButton ProgramGeneratorSqlite() {
        JButton programGenerator = new JButton("GeneratorSQlite");
        programGenerator.addActionListener((e) -> {
            this.usun_komponenty();
            ProgramGeneratorZapytanSQlite programGeneratorZapytanSQlite = new ProgramGeneratorZapytanSQlite();
            frame.add(programGeneratorZapytanSQlite.generatorSQlite_panel_center(), "Center");
            frame.add(programGeneratorZapytanSQlite.generatorSQlite_panel_north(), "North");
            frame.add(this.Panel_South(), "South");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
        return programGenerator;
    }

    private JButton ProgramOdnosniki()
    {
        JButton programOdnosniki = new JButton("Odnośniki");
        programOdnosniki.addActionListener((e) -> {
           usun_komponenty();
            ProgramOdnosniki programOdnosniki1 = new ProgramOdnosniki();
            frame.add(programOdnosniki1.Odnosniki_panel_01(), "North");
            frame.add(programOdnosniki1.Odnosniki_panel_02(), "Center");
            frame.add(this.Panel_South(), "South");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
        return programOdnosniki;
    }
    private JButton ProgramYoutube()
    {
        JButton programYoutube = new JButton("Youtube-dl");
        programYoutube.addActionListener((e) -> {
            this.usun_komponenty();
  ProgramYouTubeDownload programYouTubeDownload = new ProgramYouTubeDownload();
            frame.add(programYouTubeDownload.youtube_dl_Panel_NORTH(), "North");
            frame.add(programYouTubeDownload.youtube_dl_Panel_Center(), "Center");
            frame.add(this.Panel_South(), "South");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
        return programYoutube;
    }

    private JPanel Panel_South() {
        JPanel panel3 = new JPanel();
        panel3.add(ProgramGeneratorSqlite());
        panel3.add(ProgramOdnosniki());
        panel3.add(ProgramYoutube());
        return panel3;
    }

    private void usun_komponenty() {
        frame.getContentPane().removeAll();
        frame.getContentPane().repaint();
    }

    private void sprawdzCzyJestPlik()
    {
        ZapisOdczytPliku zapisOdczytPliku = new ZapisOdczytPliku();
        String sciezkaBazyDanych = "/home/";
        String nazwaKsiegi = "nazwa ksiegi";

        String rowid = "rowid";
        String rozdzialy = "rozdzialy";
        String temat = "temat";

        String Obszar1 = "obszar1";
        String Obszar2 = "obszar2";
        if (new File("kolumny.dat").isFile())
        {
            System.out.println("plik jest");
        }
        else
        {
            System.out.println("pliku nie ma!! -> tworze plik");
            zapisOdczytPliku.writeToPosition(sciezkaBazyDanych,0,50);
            System.out.println("sciezka bazy danych="+zapisOdczytPliku.readFromPosition(0));
            zapisOdczytPliku.writeToPosition(nazwaKsiegi,50,100);
            System.out.println("nazwa ksiegi="+zapisOdczytPliku.readFromPosition(50));
            zapisOdczytPliku.writeToPosition(rowid,100,200);
            System.out.println("rowid="+zapisOdczytPliku.readFromPosition(100));
            zapisOdczytPliku.writeToPosition(rozdzialy,200,300);
            System.out.println("rozdzialy="+zapisOdczytPliku.readFromPosition(200));
            zapisOdczytPliku.writeToPosition(temat,300,400);
            System.out.println("temat="+zapisOdczytPliku.readFromPosition(300));
            zapisOdczytPliku.writeToPosition(Obszar1,400,5000);
            System.out.println("obszar 1="+zapisOdczytPliku.readFromPosition(400));
            zapisOdczytPliku.writeToPosition(Obszar2,5000,10000);
            System.out.println("obszar 2="+zapisOdczytPliku.readFromPosition(5000));
        }
    }



    public static void main(String[] args) {

        new ProgramyJava();
    }


}
