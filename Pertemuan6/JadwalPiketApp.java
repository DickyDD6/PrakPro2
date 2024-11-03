/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pertemuan6;

/**
 *
 * @author ASUS
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JadwalPiketApp extends JFrame {
    private JTextField namaField;
    private JTextArea tugasArea;
    private JRadioButton pagiButton, siangButton;
    private JCheckBox konfirmasiCheckBox;
    private JComboBox<String> hariComboBox;
    private JList<String> anggotaList;
    private JSlider durasiSlider;
    private JSpinner waktuSpinner;
    private JTable jadwalTable;
    private DefaultTableModel tableModel;

    public JadwalPiketApp() {
        // Frame utama
        setTitle("Aplikasi Jadwal Piket");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem jadwalMenuItem = new JMenuItem("Input Jadwal Piket");
        JMenuItem aboutMenuItem = new JMenuItem("Tentang");

        jadwalMenuItem.addActionListener(e -> tampilkanFormInput());
        aboutMenuItem.addActionListener(e -> JOptionPane.showMessageDialog(null, "Jadwal Piket"));
        
        menu.add(jadwalMenuItem);
        menu.add(aboutMenuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Panel Input menggunakan GridBagLayout
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Form Input Jadwal Piket"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Nama
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Nama:"), gbc);
        gbc.gridx = 1;
        namaField = new JTextField();
        inputPanel.add(namaField, gbc);

        // Tugas
        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(new JLabel("Tugas:"), gbc);
        gbc.gridx = 1;
        tugasArea = new JTextArea(3, 20);
        inputPanel.add(new JScrollPane(tugasArea), gbc);

        // Shift
        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(new JLabel("Shift:"), gbc);
        gbc.gridx = 1;
        pagiButton = new JRadioButton("Pagi");
        siangButton = new JRadioButton("Malam");
        ButtonGroup shiftGroup = new ButtonGroup();
        shiftGroup.add(pagiButton);
        shiftGroup.add(siangButton);
        JPanel shiftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        shiftPanel.add(pagiButton);
        shiftPanel.add(siangButton);
        inputPanel.add(shiftPanel, gbc);

        // Konfirmasi Kehadiran
        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(new JLabel("Kehadiran:"), gbc);
        gbc.gridx = 1;
        konfirmasiCheckBox = new JCheckBox("Konfirmasi kehadiran");
        inputPanel.add(konfirmasiCheckBox, gbc);

        // Hari
        gbc.gridx = 0;
        gbc.gridy = 4;
        inputPanel.add(new JLabel("Hari:"), gbc);
        gbc.gridx = 1;
        hariComboBox = new JComboBox<>(new String[]{"Senin", "Selasa", "Rabu", "Kamis", "Jumat"});
        inputPanel.add(hariComboBox, gbc);

        // Anggota
        gbc.gridx = 0;
        gbc.gridy = 5;
        inputPanel.add(new JLabel("Anggota:"), gbc);
        gbc.gridx = 1;
        anggotaList = new JList<>(new String[]{"A", "B", "C", "D", "E"});
        anggotaList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        inputPanel.add(new JScrollPane(anggotaList), gbc);

        // Durasi Piket
        gbc.gridx = 0;
        gbc.gridy = 6;
        inputPanel.add(new JLabel("Durasi (jam):"), gbc);
        gbc.gridx = 1;
        durasiSlider = new JSlider(1, 8, 1);
        durasiSlider.setMajorTickSpacing(1);
        durasiSlider.setPaintTicks(true);
        durasiSlider.setPaintLabels(true);
        inputPanel.add(durasiSlider, gbc);

        // Waktu Mulai
        gbc.gridx = 0;
        gbc.gridy = 7;
        inputPanel.add(new JLabel("Waktu Mulai:"), gbc);
        gbc.gridx = 1;
        waktuSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(waktuSpinner,"dd/MM/yyyy");
        waktuSpinner.setEditor(dateEditor);
        inputPanel.add(waktuSpinner, gbc);
        
   
        // Tombol Simpan
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton saveButton = new JButton("Simpan");
        saveButton.addActionListener(e -> simpanData());
        inputPanel.add(saveButton, gbc);

        add(inputPanel, BorderLayout.WEST);

        // Tabel untuk menampilkan data jadwal piket
        tableModel = new DefaultTableModel(new String[]{"Nama", "Tugas", "Shift", "Hari", "Anggota", "Durasi", "Waktu Mulai"}, 0);
        jadwalTable = new JTable(tableModel);
        jadwalTable.setPreferredScrollableViewportSize(new Dimension(500, 400));
        jadwalTable.setFillsViewportHeight(true);

        // Panel Tabel
        JPanel tablePanel = new JPanel();
        tablePanel.setBorder(BorderFactory.createTitledBorder("Daftar Jadwal Piket"));
        tablePanel.add(new JScrollPane(jadwalTable));

        add(tablePanel, BorderLayout.CENTER);

        setVisible(true);
    }

    // Menampilkan form input (untuk clear field jika diperlukan)
    private void tampilkanFormInput() {
        namaField.setText("");
        tugasArea.setText("");
        pagiButton.setSelected(false);
        siangButton.setSelected(false);
        konfirmasiCheckBox.setSelected(false);
        hariComboBox.setSelectedIndex(0);
        anggotaList.clearSelection();
        durasiSlider.setValue(1);
        waktuSpinner.setValue(new java.util.Date());
    }

    // Simpan data ke tabel
    private void simpanData() {
        String nama = namaField.getText();
        String tugas = tugasArea.getText();
        String shift = pagiButton.isSelected() ? "Pagi" : siangButton.isSelected() ? "Malam" : "";
        String hari = (String) hariComboBox.getSelectedItem();
        String anggota = String.join(", ", anggotaList.getSelectedValuesList());
        int durasi = durasiSlider.getValue();
        String waktuMulai = waktuSpinner.getValue().toString();

        tableModel.addRow(new Object[]{nama, tugas, shift, hari, anggota, durasi, waktuMulai});
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JadwalPiketApp::new);
    }
}