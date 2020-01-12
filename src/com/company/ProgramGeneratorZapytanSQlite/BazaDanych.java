package com.company.ProgramGeneratorZapytanSQlite;

import javax.swing.*;
import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

class BazaDanych {


    static List<String> polacz(String nazwaKsiegi, String sciezka) {

        List<String> listReversedOrder = null;
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection polaczenie = null;
        try {
            polaczenie = DriverManager.getConnection("jdbc:sqlite:"+sciezka);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("nie !!! Połączyłem się z bazą ");
            JOptionPane.showMessageDialog(null, "Błąd -> " + e.getMessage());
        }

        Statement stat = null;
        try {
            if (polaczenie != null) {
                stat = polaczenie.createStatement();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String szukajSQL = "SELECT * FROM " + nazwaKsiegi;

        ResultSet wynik = null;
        try {
            wynik = stat.executeQuery(szukajSQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSetMetaData rsmd = null;
        try {
            rsmd = wynik.getMetaData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int columnCount = 0;
        try {
            columnCount = rsmd.getColumnCount();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<String> lista = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            try {
                lista.add(rsmd.getColumnName(i));
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


        Iterator<String> reversedStream = new LinkedList<>(lista)
                .descendingIterator();
        listReversedOrder = StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(reversedStream,
                        Spliterator.ORDERED), false).limit(3).collect(
                Collectors.toList());


        try {
            wynik.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stat.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            polaczenie.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return listReversedOrder;
    }


}
