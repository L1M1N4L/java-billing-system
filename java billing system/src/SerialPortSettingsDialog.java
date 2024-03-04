import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SerialPortSettingsDialog extends JDialog {
    private SimpleHyperterminal parent;

    public SerialPortSettingsDialog(SimpleHyperterminal parent) {
        super(parent, "Serial Port Settings", true);
        this.parent = parent;
        setSize(300, 250);
        setLayout(new GridLayout(6, 2, 10, 10));

        // Serial Port Selection
        JLabel portLabel = new JLabel("Serial Port:");
        String[] portNames = {"COM1", "COM2", "COM3", "COM4"}; // Add more if needed
        JComboBox<String> portComboBox = new JComboBox<>(portNames);

        // Baud Rate Selection
        JLabel baudRateLabel = new JLabel("Baud Rate:");
        Integer[] baudRates = {9600, 19200, 38400, 57600, 115200}; // Add more if needed
        JComboBox<Integer> baudRateComboBox = new JComboBox<>(baudRates);

        // Data Bits Selection
        JLabel dataBitsLabel = new JLabel("Data Bits:");
        Integer[] dataBits = {5, 6, 7, 8};
        JComboBox<Integer> dataBitsComboBox = new JComboBox<>(dataBits);

        // Stop Bits Selection
        JLabel stopBitsLabel = new JLabel("Stop Bits:");
        Integer[] stopBits = {1, 2};
        JComboBox<Integer> stopBitsComboBox = new JComboBox<>(stopBits);

        // Parity Selection
        JLabel parityLabel = new JLabel("Parity:");
        String[] parityOptions = {"None", "Even", "Odd"};
        JComboBox<String> parityComboBox = new JComboBox<>(parityOptions);

        // OK Button
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fetch selected settings and save them
                String selectedPort = (String) portComboBox.getSelectedItem();
                int selectedBaudRate = (Integer) baudRateComboBox.getSelectedItem();
                int selectedDataBits = (Integer) dataBitsComboBox.getSelectedItem();
                int selectedStopBits = (Integer) stopBitsComboBox.getSelectedItem();
                String selectedParity = (String) parityComboBox.getSelectedItem();

                // Update settings in the parent window
                parent.updateSettings(selectedPort, selectedBaudRate, selectedDataBits, selectedStopBits, selectedParity);
                dispose();
            }
        });

        // Cancel Button
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // Add components to the dialog
        add(portLabel);
        add(portComboBox);
        add(baudRateLabel);
        add(baudRateComboBox);
        add(dataBitsLabel);
        add(dataBitsComboBox);
        add(stopBitsLabel);
        add(stopBitsComboBox);
        add(parityLabel);
        add(parityComboBox);
        add(okButton);
        add(cancelButton);

        setLocationRelativeTo(parent);
    }
}
