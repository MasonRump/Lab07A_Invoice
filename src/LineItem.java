public class LineItem {
    private Product product;
    private int quantity;

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getLineTotal() {
        return product.getUnitPrice() * quantity;
    }

    public String toString() {
        return product.getName() + " x " + product.getUnitPrice() + " = $" + String.format("%.2f", getLineTotal());
    }
}
