package ra.entity;

import java.util.Scanner;

public class Product {
    private String productid;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String descriptions;
    private boolean status;

    public Product() {
    }

    public Product(String productid, String productName, float importPrice, float exportPrice, int quantity, String descriptions, boolean status) {
        this.productid = productid;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
        this.profit = calProfit();
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getProfit() {
        return profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public float calProfit() {
        return this.exportPrice - this.importPrice;
    }


    public void inputData(Scanner scanner, Product[] arrProduct) {
        System.out.println("Nhập mã sản phẩm: ");
        this.productid = scanner.nextLine();
        // Kiểm tra mã sản phẩm không được trùng lặp
        for (Product product : arrProduct) {
            if (product != null && product.getProductid().equals(this.productid)) {
                System.out.println("Mã sản phẩm đã tồn tại. Vui lòng nhập lại.");
                return;
            }
        }

        System.out.println("Nhập tên sản phẩm: ");
        this.productName = scanner.nextLine();

        System.out.println("Nhập giá nhập: ");
        this.importPrice = scanner.nextFloat();

        System.out.println("Nhập giá xuất: ");
        this.exportPrice = scanner.nextFloat();
        // Kiểm tra giá xuất phải lớn hơn ít nhất 20% so với giá nhập
        while (this.exportPrice < this.importPrice * 1.2) {
            System.out.println("Giá xuất phải lớn hơn ít nhất 20% so với giá nhập. Vui lòng nhập lại.");
            this.exportPrice = scanner.nextFloat();
        }

        System.out.println("Nhập số lượng sản phẩm: ");
        this.quantity = scanner.nextInt();
        // Kiểm tra số lượng sản phẩm phải lớn hơn 0
        while (this.quantity <= 0) {
            System.out.println("Số lượng sản phẩm phải lớn hơn 0. Vui lòng nhập lại.");
            this.quantity = scanner.nextInt();
        }

        scanner.nextLine();
        System.out.println("Nhập mô tả sản phẩm: ");
        this.descriptions = scanner.nextLine();

        System.out.println("Nhập trạng thái sản phẩm (true - Đang bán, false - Không bán): ");
        this.status = scanner.nextBoolean();
    }

    public void displayData() {
        String statusStr = this.status ? "Đang bán" : "Không bán";
        System.out.println("Mã sản phẩm: " + this.productid);
        System.out.println("Tên sản phẩm: " + this.productName);
        System.out.println("Giá nhập: " + this.importPrice);
        System.out.println("Giá xuất: " + this.exportPrice);
        System.out.println("Lợi nhuận: " + this.profit);
        System.out.println("Số lượng: " + this.quantity);
        System.out.println("Mô tả: " + this.descriptions);
        System.out.println("Trạng thái: " + statusStr);
    }
}