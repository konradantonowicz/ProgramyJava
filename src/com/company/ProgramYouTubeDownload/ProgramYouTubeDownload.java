

package com.company.ProgramYouTubeDownload;

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.*;
public class ProgramYouTubeDownload {
private ArrayList<String> lista_komenda = new ArrayList<>(6);
private JTextArea txtArea;

public ProgramYouTubeDownload() {
}

private JLabel label_Komenda() {
return new JLabel("<html>Komenda<br>Programu</html>", SwingConstants.CENTER);
}

private JLabel label_opcja1() {
return new JLabel("<html>Opcja<br>nr 1</html>", SwingConstants.CENTER);
}

private JLabel label_opcja2() {
return new JLabel("<html>Opcja<br>nr 2</html>", SwingConstants.CENTER);
}

private JLabel label_opcja3() {
return new JLabel("<html>Opcja<br>nr 3</html>", SwingConstants.CENTER);
}

private JLabel label_opcja4() {
return new JLabel("<html>Opcja<br>nr 4</html>", SwingConstants.CENTER);
}

private JLabel label_adres() {
return new JLabel("<html>Adres<br>URL</html>", SwingConstants.CENTER);
}

private JTextField txtField_komenda() {
JTextField txtF_opcja1 = new JTextField("youtube-dl");
this.lista_komenda.add(txtF_opcja1.getText());
this.lista_komenda.add(" -F ");
this.lista_komenda.add(" ");
this.lista_komenda.add(" ");
this.lista_komenda.add(" -o '%(uploader)s/%(playlist)s/%(playlist_index)s - %(title)s.%(ext)s'");
this.lista_komenda.add(" ");
txtF_opcja1.addKeyListener(new KeyAdapter() {
public void keyReleased(KeyEvent e) {
super.keyReleased(e);
JTextField komendaa = (JTextField)e.getSource();
ProgramYouTubeDownload.this.lista_komenda.set(0, komendaa.getText());
ProgramYouTubeDownload.this.dodajWyniki();
}
});
return txtF_opcja1;
}

private JComboBox<String> combo_opcja1() {
String[] opcje1 = new String[]{" -F ", " -f ", " --extract-audio ", " --playlist-start ", " --playlist-items ", " --no-playlist "};
JComboBox<String> JComboBox_opcja1 = new JComboBox<>(opcje1);
JComboBox_opcja1.addActionListener((e) -> {
    JComboBox a = (JComboBox)e.getSource();
    this.lista_komenda.set(1, Objects.requireNonNull(a.getSelectedItem()).toString());
    this.dodajWyniki();
});
return JComboBox_opcja1;
}

private JTextField txtField_opcja2() {
JTextField txtF_opcja2 = new JTextField("137");
this.lista_komenda.set(2, txtF_opcja2.getText());
txtF_opcja2.addKeyListener(new KeyAdapter() {
public void keyReleased(KeyEvent e) {
super.keyReleased(e);
JTextField textField = (JTextField)e.getSource();
ProgramYouTubeDownload.this.lista_komenda.set(2, textField.getText());
ProgramYouTubeDownload.this.dodajWyniki();
}
});
return txtF_opcja2;
}

private JComboBox<String> combo_opcja3() {
String[] opcje2 = new String[]{" ", " --audio-format mp3 ", " --playlist-end ", " --yes-playlist ", " --no-playlist ", " --playlist-items "};
JComboBox<String> combo_opcja3 = new JComboBox<>(opcje2);
combo_opcja3.addActionListener((f) -> {
    JComboBox b = (JComboBox)f.getSource();
    this.lista_komenda.set(3, Objects.requireNonNull(b.getSelectedItem()).toString());
    this.dodajWyniki();
});
return combo_opcja3;
}

private JTextField txtField_opcja4() {
JTextField txtF_opcja4 = new JTextField(" -o '%(uploader)s/%(playlist)s/%(playlist_index)s - %(title)s.%(ext)s'");
txtF_opcja4.addKeyListener(new KeyAdapter() {
public void keyReleased(KeyEvent e) {
super.keyReleased(e);
JTextField textField = (JTextField)e.getSource();
ProgramYouTubeDownload.this.lista_komenda.set(4, textField.getText());
ProgramYouTubeDownload.this.dodajWyniki();
}
});
return txtF_opcja4;
}

private JTextField txtField_opcja5() {
JTextField txtF_opcja5 = new JTextField();
txtF_opcja5.addKeyListener(new KeyAdapter() {
public void keyReleased(KeyEvent e) {
super.keyReleased(e);
JTextField textField = (JTextField)e.getSource();
ProgramYouTubeDownload.this.lista_komenda.set(5, " '" + textField.getText() + "'");
ProgramYouTubeDownload.this.dodajWyniki();
}
});
return txtF_opcja5;
}

private JScrollPane txtArea() {
this.txtArea = new JTextArea(20, 100);
this.txtArea.setLineWrap(true);
JScrollPane scroll = new JScrollPane(this.txtArea);
this.dodajWyniki();
return scroll;
}

public JPanel youtube_dl_Panel_NORTH() {
JPanel panel_north = new JPanel();
panel_north.setLayout(new GridLayout(2, 6));
panel_north.add(this.label_Komenda());
panel_north.add(this.label_opcja1());
panel_north.add(this.label_opcja2());
panel_north.add(this.label_opcja3());
panel_north.add(this.label_opcja4());
panel_north.add(this.label_adres());
panel_north.add(this.txtField_komenda());
panel_north.add(this.combo_opcja1());
panel_north.add(this.txtField_opcja2());
panel_north.add(this.combo_opcja3());
panel_north.add(this.txtField_opcja4());
panel_north.add(this.txtField_opcja5());
return panel_north;
}

public JPanel youtube_dl_Panel_Center() {
JPanel panel_center = new JPanel();
panel_center.add(this.txtArea());
return panel_center;
}

private void dodajWyniki() {
StringBuilder x = new StringBuilder();
for (Object f : this.lista_komenda) {
    x.append(f);
}

this.txtArea.setText(" ");
this.txtArea.append(x.toString());
}
}
