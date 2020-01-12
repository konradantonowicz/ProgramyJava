
package com.company.ProgramOdnosniki;

import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.swing.*;
public class ProgramOdnosniki {
private JTextArea textAreaNumerRozdzialu;
private JTextArea textAreaNumerWersetu;
private JTextArea textAreaNumerID;
private ArrayList<SkrotyKsiagPojo> listaRozdzialowWersetow = new ArrayList<>();
private ArrayList<SkrotyKsiagPojo> listaWersetow = new ArrayList<>();
private JTextArea textAreaSkrotKsiegi;
private String wybor;
private DefaultComboBoxModel<String> modelRozdzialow;
private DefaultComboBoxModel<String> modelWersetow;
private String[] wartoscPoczatkowaRozdzialow = new String[1];
private String[] wartoscPoczatkowaWersetow = new String[1];

public ProgramOdnosniki() {
}

private JLabel label_skrotKsiag() {
return new JLabel("<html>Skrot<br>Księga</html>", SwingConstants.CENTER);
}

private JLabel label_numerRozdzialu() {
return new JLabel("<html>Numer<br>Rozdziału</html>", SwingConstants.CENTER);
}

private JLabel label_numerWersetu() {
return new JLabel("<html>Numer<br>Wersetu</html>", SwingConstants.CENTER);
}

private JLabel label_numerID() {
return new JLabel("<html>Numer<br>&nbsp;&nbsp;&nbsp;&nbsp;ID</html>", SwingConstants.CENTER);
}

private JComboBox<String> ComboBox_SkrotKsiegi() {
String[] skrotyKsiag = new String[]{"1J", "1Kor", "1Krl", "1Krn", "1P", "1Sm", "1Tes", "1Tm", "2J", "2Kor", "2Krl", "2Krn", "2P", "2Sm", "2Tes", "2Tm", "3J", "Ab", "Ag", "Am", "Dn", "Dz", "Ef", "Est", "Ez", "Ezd", "Flm", "Flp", "Ga", "Ha", "Hbr", "Hi", "Iz", "J", "Jud", "Jk", "Jl", "Jon", "Joz", "Jr", "Kaz", "Kol", "Kpł", "Lb", "Lm", "Łk", "Mi", "Mk", "Ml", "Mt", "Na", "Ne", "Obj", "Oz", "Pnp", "Prz", "Ps", "Pwt", "Rdz", "Rt", "Rz", "So", "Szd", "Tt", "Wj", "Za"};
JComboBox<String> comboBoxSkrogKsiegi = new JComboBox<>(skrotyKsiag);
comboBoxSkrogKsiegi.addActionListener((e) -> {
    JComboBox a = (JComboBox)e.getSource();
    this.listaRozdzialowWersetow.clear();
    this.textAreaSkrotKsiegi.append(" " + Objects.requireNonNull(a.getSelectedItem()).toString() + "\n");
    String var3 = Objects.requireNonNull(a.getSelectedItem()).toString();
    byte var4 = -1;
    switch(var3.hashCode()) {
        case 74:
            if (var3.equals("J")) {
                var4 = 33;
            }
            break;
        case 1593:
            if (var3.equals("1J")) {
                var4 = 0;
            }
            break;
        case 1599:
            if (var3.equals("1P")) {
                var4 = 7;
            }
            break;
        case 1624:
            if (var3.equals("2J")) {
                var4 = 8;
            }
            break;
        case 1630:
            if (var3.equals("2P")) {
                var4 = 12;
            }
            break;
        case 1655:
            if (var3.equals("3J")) {
                var4 = 16;
            }
            break;
        case 2113:
            if (var3.equals("Ab")) {
                var4 = 17;
            }
            break;
        case 2118:
            if (var3.equals("Ag")) {
                var4 = 18;
            }
            break;
        case 2124:
            if (var3.equals("Am")) {
                var4 = 19;
            }
            break;
        case 2218:
            if (var3.equals("Dn")) {
                var4 = 20;
            }
            break;
        case 2230:
            if (var3.equals("Dz")) {
                var4 = 21;
            }
            break;
        case 2241:
            if (var3.equals("Ef")) {
                var4 = 22;
            }
            break;
        case 2261:
            if (var3.equals("Ez")) {
                var4 = 24;
            }
            break;
        case 2298:
            if (var3.equals("Ga")) {
                var4 = 28;
            }
            break;
        case 2329:
            if (var3.equals("Ha")) {
                var4 = 29;
            }
            break;
        case 2337:
            if (var3.equals("Hi")) {
                var4 = 31;
            }
            break;
        case 2385:
            if (var3.equals("Iz")) {
                var4 = 32;
            }
            break;
        case 2401:
            if (var3.equals("Jk")) {
                var4 = 35;
            }
            break;
        case 2402:
            if (var3.equals("Jl")) {
                var4 = 36;
            }
            break;
        case 2408:
            if (var3.equals("Jr")) {
                var4 = 39;
            }
            break;
        case 2454:
            if (var3.equals("Lb")) {
                var4 = 43;
            }
            break;
        case 2465:
            if (var3.equals("Lm")) {
                var4 = 44;
            }
            break;
        case 2492:
            if (var3.equals("Mi")) {
                var4 = 46;
            }
            break;
        case 2494:
            if (var3.equals("Mk")) {
                var4 = 47;
            }
            break;
        case 2495:
            if (var3.equals("Ml")) {
                var4 = 48;
            }
            break;
        case 2503:
            if (var3.equals("Mt")) {
                var4 = 49;
            }
            break;
        case 2515:
            if (var3.equals("Na")) {
                var4 = 50;
            }
            break;
        case 2519:
            if (var3.equals("Ne")) {
                var4 = 51;
            }
            break;
        case 2571:
            if (var3.equals("Oz")) {
                var4 = 53;
            }
            break;
        case 2595:
            if (var3.equals("Ps")) {
                var4 = 56;
            }
            break;
        case 2658:
            if (var3.equals("Rt")) {
                var4 = 59;
            }
            break;
        case 2664:
            if (var3.equals("Rz")) {
                var4 = 60;
            }
            break;
        case 2684:
            if (var3.equals("So")) {
                var4 = 61;
            }
            break;
        case 2720:
            if (var3.equals("Tt")) {
                var4 = 63;
            }
            break;
        case 2803:
            if (var3.equals("Wj")) {
                var4 = 64;
            }
            break;
        case 2887:
            if (var3.equals("Za")) {
                var4 = 65;
            }
            break;
        case 10058:
            if (var3.equals("Łk")) {
                var4 = 45;
            }
            break;
        case 49771:
            if (var3.equals("1Sm")) {
                var4 = 4;
            }
            break;
        case 49802:
            if (var3.equals("1Tm")) {
                var4 = 6;
            }
            break;
        case 50732:
            if (var3.equals("2Sm")) {
                var4 = 13;
            }
            break;
        case 50763:
            if (var3.equals("2Tm")) {
                var4 = 15;
            }
            break;
        case 69990:
            if (var3.equals("Est")) {
                var4 = 23;
            }
            break;
        case 70191:
            if (var3.equals("Ezd")) {
                var4 = 25;
            }
            break;
        case 70727:
            if (var3.equals("Flm")) {
                var4 = 26;
            }
            break;
        case 70730:
            if (var3.equals("Flp")) {
                var4 = 27;
            }
            break;
        case 72344:
            if (var3.equals("Hbr")) {
                var4 = 30;
            }
            break;
        case 74665:
            if (var3.equals("Jon")) {
                var4 = 37;
            }
            break;
        case 74677:
            if (var3.equals("Joz")) {
                var4 = 38;
            }
            break;
        case 74841:
            if (var3.equals("Jud")) {
                var4 = 34;
            }
            break;
        case 75204:
            if (var3.equals("Kaz")) {
                var4 = 40;
            }
            break;
        case 75624:
            if (var3.equals("Kol")) {
                var4 = 41;
            }
            break;
        case 75869:
            if (var3.equals("Kpł")) {
                var4 = 42;
            }
            break;
        case 79063:
            if (var3.equals("Obj")) {
                var4 = 52;
            }
            break;
        case 80402:
            if (var3.equals("Pnp")) {
                var4 = 54;
            }
            break;
        case 80536:
            if (var3.equals("Prz")) {
                var4 = 55;
            }
            break;
        case 80685:
            if (var3.equals("Pwt")) {
                var4 = 57;
            }
            break;
        case 82024:
            if (var3.equals("Rdz")) {
                var4 = 58;
            }
            break;
        case 83645:
            if (var3.equals("Szd")) {
                var4 = 62;
            }
            break;
        case 1535389:
            if (var3.equals("1Kor")) {
                var4 = 1;
            }
            break;
        case 1535476:
            if (var3.equals("1Krl")) {
                var4 = 2;
            }
            break;
        case 1535478:
            if (var3.equals("1Krn")) {
                var4 = 3;
            }
            break;
        case 1543729:
            if (var3.equals("1Tes")) {
                var4 = 5;
            }
            break;
        case 1565180:
            if (var3.equals("2Kor")) {
                var4 = 9;
            }
            break;
        case 1565267:
            if (var3.equals("2Krl")) {
                var4 = 10;
            }
            break;
        case 1565269:
            if (var3.equals("2Krn")) {
                var4 = 11;
            }
            break;
        case 1573520:
            if (var3.equals("2Tes")) {
                var4 = 14;
            }
    }

    switch(var4) {
        case 0:
            this.wybor = "62";
            break;
        case 1:
            this.wybor = "46";
            break;
        case 2:
            this.wybor = "11";
            break;
        case 3:
            this.wybor = "13";
            break;
        case 4:
            this.wybor = "09";
            break;
        case 5:
            this.wybor = "52";
            break;
        case 6:
            this.wybor = "54";
            break;
        case 7:
            this.wybor = "60";
            break;
        case 8:
            this.wybor = "63";
            break;
        case 9:
            this.wybor = "47";
            break;
        case 10:
            this.wybor = "12";
            break;
        case 11:
            this.wybor = "14";
            break;
        case 12:
            this.wybor = "61";
            break;
        case 13:
            this.wybor = "10";
            break;
        case 14:
            this.wybor = "53";
            break;
        case 15:
            this.wybor = "55";
            break;
        case 16:
            this.wybor = "64";
            break;
        case 17:
            this.wybor = "31";
            break;
        case 18:
            this.wybor = "37";
            break;
        case 19:
            this.wybor = "30";
            break;
        case 20:
            this.wybor = "30";
            break;
        case 21:
            this.wybor = "44";
            break;
        case 22:
            this.wybor = "49";
            break;
        case 23:
            this.wybor = "17";
            break;
        case 24:
            this.wybor = "26";
            break;
        case 25:
            this.wybor = "15";
            break;
        case 26:
            this.wybor = "57";
            break;
        case 27:
            this.wybor = "50";
            break;
        case 28:
            this.wybor = "48";
            break;
        case 29:
            this.wybor = "35";
            break;
        case 30:
            this.wybor = "58";
            break;
        case 31:
            this.wybor = "18";
            break;
        case 32:
            this.wybor = "23";
            break;
        case 33:
            this.wybor = "43";
            break;
        case 34:
            this.wybor = "65";
            break;
        case 35:
            this.wybor = "59";
            break;
        case 36:
            this.wybor = "29";
            break;
        case 37:
            this.wybor = "32";
            break;
        case 38:
            this.wybor = "06";
            break;
        case 39:
            this.wybor = "24";
            break;
        case 40:
            this.wybor = "21";
            break;
        case 41:
            this.wybor = "51";
            break;
        case 42:
            this.wybor = "03";
            break;
        case 43:
            this.wybor = "04";
            break;
        case 44:
            this.wybor = "25";
            break;
        case 45:
            this.wybor = "42";
            break;
        case 46:
            this.wybor = "33";
            break;
        case 47:
            this.wybor = "41";
            break;
        case 48:
            this.wybor = "39";
            break;
        case 49:
            this.wybor = "40";
            break;
        case 50:
            this.wybor = "34";
            break;
        case 51:
            this.wybor = "16";
            break;
        case 52:
            this.wybor = "66";
            break;
        case 53:
            this.wybor = "28";
            break;
        case 54:
            this.wybor = "22";
            break;
        case 55:
            this.wybor = "20";
            break;
        case 56:
            this.wybor = "19";
            break;
        case 57:
            this.wybor = "05";
            break;
        case 58:
            this.wybor = "01";
            break;
        case 59:
            this.wybor = "08";
            break;
        case 60:
            this.wybor = "45";
            break;
        case 61:
            this.wybor = "36";
            break;
        case 62:
            this.wybor = "07";
            break;
        case 63:
            this.wybor = "56";
            break;
        case 64:
            this.wybor = "02";
            break;
        case 65:
            this.wybor = "38";
    }

    this.listaRozdzialowWersetow.addAll(this.readFile(this.wybor));
    this.stworzRozdzialy(Integer.parseInt((this.listaRozdzialowWersetow.get(this.listaRozdzialowWersetow.size() - 1)).nrKRW.substring(2)));
});
return comboBoxSkrogKsiegi;
}

private JComboBox<String> ComboBox_NumerRozdzialu() {
this.modelRozdzialow = new DefaultComboBoxModel<>(this.wartoscPoczatkowaRozdzialow);
JComboBox<String> comboBoxNumerRozdzialu = new JComboBox<>(this.modelRozdzialow);
comboBoxNumerRozdzialu.addActionListener((e) -> {
    JComboBox rozr = (JComboBox)e.getSource();
    if (rozr.getModel().getSize() == 0) {
        rozr.getModel().setSelectedItem("1");
        this.petlaWersety(Integer.parseInt(Objects.requireNonNull(rozr.getSelectedItem()).toString()));
    } else {
        this.petlaWersety(Integer.parseInt(Objects.requireNonNull(rozr.getSelectedItem()).toString()));
        switch(rozr.getSelectedItem().toString().length()) {
            case 1:
                this.textAreaNumerRozdzialu.append("   " + rozr.getSelectedItem().toString() + "\n");
                break;
            case 2:
                this.textAreaNumerRozdzialu.append("  " + rozr.getSelectedItem().toString() + "\n");
                break;
            case 3:
                this.textAreaNumerRozdzialu.append(" " + rozr.getSelectedItem().toString() + "\n");
        }
    }

    this.stworzWersety(this.listaWersetow.size());
});
return comboBoxNumerRozdzialu;
}

private JComboBox<String> ComboBox_NumerWersetu() {
this.modelWersetow = new DefaultComboBoxModel<>(this.wartoscPoczatkowaWersetow);
JComboBox<String> comboBoxNumerWersetu = new JComboBox<>(this.modelWersetow);
comboBoxNumerWersetu.addActionListener((e) -> {
    JComboBox wer = (JComboBox)e.getSource();
    if (comboBoxNumerWersetu.getModel().getSize() == 0) {
        comboBoxNumerWersetu.getModel().setSelectedItem("1");
    } else {
        int pozycja = Integer.parseInt(Objects.requireNonNull(wer.getSelectedItem()).toString());
        switch(wer.getSelectedItem().toString().length()) {
            case 1:
                this.textAreaNumerWersetu.append("   " + pozycja + "\n");
                break;
            case 2:
                this.textAreaNumerWersetu.append("  " + pozycja + "\n");
                break;
            case 3:
                this.textAreaNumerWersetu.append(" " + pozycja + "\n");
        }

        JTextArea var10000;
        SkrotyKsiagPojo var10001;
        switch((this.listaWersetow.get(pozycja - 1)).nrID.length()) {
            case 1:
                var10000 = this.textAreaNumerID;
                var10001 = this.listaWersetow.get(pozycja - 1);
                var10000.append("     " + var10001.nrID + "\n");
                break;
            case 2:
                var10000 = this.textAreaNumerID;
                var10001 = this.listaWersetow.get(pozycja - 1);
                var10000.append("    " + var10001.nrID + "\n");
                break;
            case 3:
                var10000 = this.textAreaNumerID;
                var10001 = this.listaWersetow.get(pozycja - 1);
                var10000.append("   " + var10001.nrID + "\n");
                break;
            case 4:
                var10000 = this.textAreaNumerID;
                var10001 = this.listaWersetow.get(pozycja - 1);
                var10000.append("  " + var10001.nrID + "\n");
                break;
            case 5:
                var10000 = this.textAreaNumerID;
                var10001 = this.listaWersetow.get(pozycja - 1);
                var10000.append(" " + var10001.nrID + "\n");
        }

        System.out.println((this.listaWersetow.get(pozycja - 1)).nrID);
    }

});
return comboBoxNumerWersetu;
}

private JTextArea TextArea_SkrotKsiegi() {
this.textAreaSkrotKsiegi = new JTextArea();
return this.textAreaSkrotKsiegi;
}

private JTextArea TextArea_NumerRozdzialu() {
this.textAreaNumerRozdzialu = new JTextArea();
return this.textAreaNumerRozdzialu;
}

private JTextArea TextArea_NumerWersetu() {
this.textAreaNumerWersetu = new JTextArea();
return this.textAreaNumerWersetu;
}

private JTextArea TextArea_NumerID() {
this.textAreaNumerID = new JTextArea();
return this.textAreaNumerID;
}

private JButton ButtonCzysc() {
JButton buttonCzysc = new JButton("Czyść");
buttonCzysc.addActionListener((e) -> {
    this.textAreaSkrotKsiegi.setText("");
    this.textAreaNumerRozdzialu.setText("");
    this.textAreaNumerWersetu.setText("");
    this.textAreaNumerID.setText("");
});
return buttonCzysc;
}

public JPanel Odnosniki_panel_01() {
this.wartoscPoczatkowaRozdzialow[0] = "1";
this.wartoscPoczatkowaWersetow[0] = "1";
JPanel panel1 = new JPanel();
panel1.setLayout(new GridLayout(2, 4));
panel1.add(this.label_skrotKsiag());
panel1.add(this.label_numerRozdzialu());
panel1.add(this.label_numerWersetu());
panel1.add(this.label_numerID());
panel1.add(this.ComboBox_SkrotKsiegi());
panel1.add(this.ComboBox_NumerRozdzialu());
panel1.add(this.ComboBox_NumerWersetu());
panel1.add(this.ButtonCzysc());
return panel1;
}

public JPanel Odnosniki_panel_02() {
JPanel panel2 = new JPanel();
panel2.setLayout(new GridLayout(1, 4));
panel2.add(this.TextArea_SkrotKsiegi());
panel2.add(this.TextArea_NumerRozdzialu());
panel2.add(this.TextArea_NumerWersetu());
panel2.add(this.TextArea_NumerID());
return panel2;
}

private List<SkrotyKsiagPojo> readFile(String lokalizacja) {
List<SkrotyKsiagPojo> skrot = new ArrayList<>();
String src = "biblia_mod.csv";
InputStream inputStream = this.getClass().getResourceAsStream(src);
BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

String line;
try {
    while((line = bufferedReader.readLine()) != null) {
        String[] skrotySplit = line.split(",");
        if (skrotySplit[0].substring(0, 2).equals(lokalizacja)) {
            SkrotyKsiagPojo skrotyPojo = new SkrotyKsiagPojo(skrotySplit[0], skrotySplit[1]);
            skrot.add(skrotyPojo);
        }
    }
} catch (IOException var9) {
    System.out.println("jakis błąd");
}

return skrot;
}

private void stworzRozdzialy(int ilosc) {
this.modelRozdzialow.removeAllElements();

for(int x = 0; x < ilosc; ++x) {
    this.modelRozdzialow.addElement(String.valueOf(x + 1));
}

}

private void stworzWersety(int ilosc) {
this.modelWersetow.removeAllElements();

for(int x = 0; x < ilosc; ++x) {
    this.modelWersetow.addElement(String.valueOf(x + 1));
}

}

private void petlaWersety(int rozdzial) {
this.listaWersetow.clear();
for (SkrotyKsiagPojo e : this.listaRozdzialowWersetow) {
    if (Integer.parseInt(e.nrKRW.substring(2)) == rozdzial) {
        this.listaWersetow.add(e);
    }
}

}
}
