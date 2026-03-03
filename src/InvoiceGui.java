import javax.swing.*;
import java.awt.*;

public class InvoiceGui extends JFrame {

    private JTextField titleField, customerField, addressField;
    private JTextField productField, priceField, quantityField;
    private JTextArea invoiceArea;

    private Invoice invoice;

    public InvoiceGui() {
        setTitle("Invoice Generator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(7, 2));

        inputPanel.add(new JLabel("Invoice Title:"));
        titleField = new JTextField();
        inputPanel.add(titleField);

        inputPanel.add(new JLabel("Customer Name:"));
        customerField = new JTextField();
        inputPanel.add(customerField);

        inputPanel.add(new JLabel("Customer Address:"));
        addressField = new JTextField();
        inputPanel.add(addressField);

        inputPanel.add(new JLabel("Product Name:"));
        productField = new JTextField();
        inputPanel.add(productField);

        inputPanel.add(new JLabel("Unit Price:"));
        priceField = new JTextField();
        inputPanel.add(priceField);

        inputPanel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        inputPanel.add(quantityField);

        JButton addButton = new JButton("Add Line Item");
        JButton generateButton = new JButton("Generate Invoice");

        invoiceArea = new JTextArea();
        invoiceArea.setEditable(false);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(invoiceArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(generateButton);
        add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            if (invoice == null) {
                invoice = new Invoice(titleField.getText(), new Customer(customerField.getText(), addressField.getText()));
            }
            Product product = new Product(productField.getText(), Double.parseDouble(priceField.getText()));
            LineItem item = new LineItem(product, Integer.parseInt(quantityField.getText()));
            invoice.addLineItem(item);
            invoiceArea.setText(invoice.toString());
        });

        generateButton.addActionListener(e -> {
            if (invoice != null) {
                invoiceArea.setText(invoice.toString());
            }
        });

        setVisible(true);
    }
}
