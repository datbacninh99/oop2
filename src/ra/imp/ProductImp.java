package ra.imp;

import ra.entity.Product;
import java.util.Scanner;

public class ProductImp {
    private static final int MAX_PRODUCTS = 100;
    private Product[] products;
    private int productCount;

    public ProductImp() {
        products = new Product[MAX_PRODUCTS];
        productCount = 0;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("***********************MENU**************************");
            System.out.println("1. Nhập thông tin n sản phẩm (n nhập từ bàn phím)");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Tính lợi nhuận các sản phẩm");
            System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
            System.out.println("5. Thống kê các sản phẩm theo giá");
            System.out.println("6. Tìm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Nhập sản phẩm");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Cập nhật trạng thái sản phẩm");
            System.out.println("10. Thoát");
            System.out.println("***************************************************");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập số lượng sản phẩm: ");
                    int n = scanner.nextInt();
                    for (int i = 0; i < n; i++) {
                        Product product = new Product();
                        product.inputData(scanner, products);
                        products[productCount++] = product;
                    }
                    break;
                case 2:
                    for (int i = 0; i < productCount; i++) {
                        products[i].displayData();
                    }
                    break;
                case 3:
                    for (int i = 0; i < productCount; i++) {
                        products[i].calProfit();
                    }
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:

                    break;
                case 9:

                    break;
                case 10:
                    System.err.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    public static void main(String[] args) {
        ProductImp productImp = new ProductImp();
        productImp.menu();
    }
}