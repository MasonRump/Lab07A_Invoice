import java.util.ArrayList;

public class Invoice {
    private String title;
    private Customer customer;
    private ArrayList<LineItem> lineItems;

    public Invoice(String title, Customer customer) {
        this.title = title;
        this.customer = customer;
        this.lineItems = new ArrayList<>();
    }

    public void addLineItem(LineItem item) {
        lineItems.add(item);
    }

    public double getTotal() {
        double total = 0;
        for (LineItem item : lineItems) {
            total += item.getLineTotal();
        }
        return total;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=================================\n");
        sb.append("Invoice: ").append(title).append("\n");
        sb.append("=================================\n");
        sb.append("Customer: ").append(customer).append("\n");
        sb.append("Line Items:\n");
        for (LineItem item : lineItems) {
            sb.append("  ").append(item).append("\n");
        }
        sb.append("---------------------------------\n");
        sb.append("Total: $").append(String.format("%.2f", getTotal()));
        return sb.toString();
    }
}
