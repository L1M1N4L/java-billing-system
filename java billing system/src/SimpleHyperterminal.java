import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleHyperterminal extends JFrame {
    private JTextArea outputTextArea;
    private String selectedPort;
    private int selectedBaudRate;
    private int selectedDataBits;
    private int selectedStopBits;
    private String selectedParity;

    public SimpleHyperterminal() {
        setTitle("Simple Hyperterminal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Output TextArea
        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        add(scrollPane, BorderLayout.CENTER);

        // Serial Port Settings Button
        JButton settingsButton = new JButton("Serial Port Settings");
        settingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SerialPortSettingsDialog settingsDialog = new SerialPortSettingsDialog(SimpleHyperterminal.this);
                settingsDialog.setVisible(true);
            }
        });
        add(settingsButton, BorderLayout.SOUTH);
    }

    // Method to update settings
    public void updateSettings(String port, int baudRate, int dataBits, int stopBits, String parity) {
        this.selectedPort = port;
        this.selectedBaudRate = baudRate;
        this.selectedDataBits = dataBits;
        this.selectedStopBits = stopBits;
        this.selectedParity = parity;

        // Print updated settings (you can do something else with them)
        System.out.println("Settings updated:");
        System.out.println("Port: " + selectedPort);
        System.out.println("Baud Rate: " + selectedBaudRate);
        System.out.println("Data Bits: " + selectedDataBits);
        System.out.println("Stop Bits: " + selectedStopBits);
        System.out.println("Parity: " + selectedParity);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SimpleHyperterminal().setVisible(true);
            }
        });
    }
}
