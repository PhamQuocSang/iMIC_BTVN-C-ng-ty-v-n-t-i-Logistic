package Buoi8_RemakeCongTyVanTai;

import Controller.ContainerController;
import Model.Container;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 */
public class GeneralProject {
    static ArrayList<Container> listCon = new ArrayList<Container>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ContainerController cc = new ContainerController();
        while (true) {
            System.out.println("_________________________________________");
            System.out.println("Chọn một trong các phương thức hành động sau: \n1. Thêm \n2. Hiển thị \n3. Xóa \n4. Chỉnh sửa \n5. Lọc danh sách container thường và đông lạnh " +
                    "\n6. Lọc danh sách Container bị hỏng \n7. Lọc danh sách Container thường \n8. Lọc danh sách Container đông lạnh \n9.Thoát");
            System.out.println("_________________________________________");
            System.out.print("Chọn: ");
            String s = scanner.nextLine();
            switch (s) {
                case "1":
                    cc.addContainer(listCon);
                    break;
                case "2":
                    cc.displayContainer(listCon);
                    break;
                case "3":
                    cc.deleteContainer(listCon);
                    break;
                case "4":
                    cc.editContainer(listCon);
                case "5":
                    cc.locDanhSachTatCaContainer(listCon);
                    break;
                case "6":
                    cc.locContainerHuHong(listCon);
                    break;
                case "7":
                    cc.locContainerThuong(listCon);
                    break;
                case "8":
                    cc.locContainerDongLanh(listCon);
                    break;
                case "9":
                    break;
                default:
                    break;
            }
        }
    }
}
