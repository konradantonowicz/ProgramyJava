package com.company.ProgramGeneratorZapytanSQlite;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ZapisOdczytPliku {

    public void writeToPosition(String data, int pozycjaStart, int pozycjaKoniec) {
        RandomAccessFile writer = null;
        StringBuilder sb = new StringBuilder();
        try {
            writer = new RandomAccessFile("kolumny.dat", "rw");
            writer.seek(pozycjaStart);
            writer.writeUTF(sb.append(" ".repeat(Math.max(0, pozycjaKoniec - pozycjaStart))).toString());
            writer.seek(pozycjaStart);
            writer.writeUTF(data.trim());
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public String readFromPosition(int pozycjaStart) {
        RandomAccessFile reader;
        String result = null;



            try {
                reader = new RandomAccessFile("kolumny.dat", "r");


                reader.seek(pozycjaStart);
                result = reader.readUTF();
                reader.close();


            } catch (IOException e) {
                e.printStackTrace();
            }



        return result;
    }



}


