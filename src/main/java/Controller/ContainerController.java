package Controller;

import Model.Container;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class ContainerController implements IContainerController {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Container> listCon = new ArrayList<Container>();
    static ArrayList<Container> lisConDongLanh = new ArrayList<Container>();
    static  ArrayList<Container> listConThuong = new ArrayList<Container>();
    static ArrayList<Container> listConBiHuHong = new ArrayList<Container>();

    @Override
    public ArrayList<Container> addContainer(ArrayList<Container> listCon) {
        while (true) {
            System.out.println("Bạn có muốn nhập thêm một Container vào danh sách hay không? Mời chọn \n[1. THÊM , 2. THOÁT]");
            System.out.println("_________________________________________");
            System.out.print("Chọn: ");
            String temp = scanner.nextLine();
            if (temp.equals("1")) {
                boolean checkTypeContainer = true;
                Container c = new Container();
                System.out.print("Nhập mã ID: ");
                c.idCon = checkNhapSo();
                System.out.print("Nhập chiều dài container: ");
                c.lengthCon = checkNhapSo();
                System.out.print("Nhập chiều cao container: ");
                c.heightCon = checkNhapSo();
                while (true) {
                    System.out.print("Nhập loại container: ");
                    c.typeCon = scanner.nextLine();
                    if (c.typeCon.equals("thường") || c.typeCon.equals("đông lạnh")) {
                        checkTypeContainer = false;
                        break;
                    } else {
                        System.out.println("WARNING: Chỉ được phép nhập 'thường' hoặc 'đông lạnh'! ");
                        continue;

                    }
                }
                System.out.print("Nhập trạng thái: ");
                c.flagCon = checkNhapBoolean();

                listCon.add(c);
                System.out.println("_________________________________________");


            }
            if (temp.equals("2")) {
                break;
            }
        }
        return listCon;
    }


    @Override
    public ArrayList<Container> displayContainer(ArrayList<Container> listCon) {
        if (listCon.size() == 0) {
            System.out.println("Hiện không có tồn tại container nào trong danh sách!");
        } else {
            System.out.println("DANH SÁCH CONTAINER: ");
            for (Container c : listCon
            ) {
                System.out.println(c.toString());
            }
        }
        return listCon;
    }

    @Override
    public ArrayList<Container> deleteContainer(ArrayList<Container> listCon) {
        if (listCon.size() == 0) {
            System.out.println("Hiện không có tồn tại container nào trong danh sách!");
        } else {
            System.out.print("Nhập mã id container muốn xóa: ");
            int temp = scanner.nextInt();
            boolean timThay = false;
            for (Container cc : listCon
            ) {
                if (temp == cc.idCon) {
                    listCon.remove(cc);
                    timThay = true;
                    break;
                }
            }
            if (timThay = false) {
                System.out.println("Không có mã id container tương ứng nào trong danh sách!");
            }
        }
        return listCon;
    }

    @Override
    public ArrayList<Container> editContainer(ArrayList<Container> listCon) {
        if (listCon.size() == 0) {
            System.out.println("Hiện không có tồn tại container nào trong danh sách!");
        } else {
            boolean timThay = false;
            Container cnew = new Container();
            System.out.println("Nhập id của container bạn muốn chỉnh sửa thông tin:");
            int s = scanner.nextInt();
            for (Container c : listCon
            ) {
                if (c.idCon == s) {
                    timThay = true;
                    boolean checkTypeContainer = true;
                    System.out.println("THỰC HIỆN CHỈNH SỬA CONTAINER MÃ [ " + c.idCon + " ]");
                    System.out.print("Mời nhập mã id cần chỉnh sửa: ");
                    cnew.idCon = scanner.nextInt();
                    System.out.print("Nhập chiều dài container cần chỉnh sửa: ");
                    cnew.lengthCon = checkNhapSo();
                    System.out.print("Nhập chiều cao container cần chỉnh sửa: ");
                    cnew.heightCon = checkNhapSo();
                    while (true) {
                        System.out.print("Nhập loại container cần chỉnh sửa: ");
                        cnew.typeCon = scanner.nextLine();
                        if (cnew.typeCon.equals("thường") || cnew.typeCon.equals("đông lạnh")) {
                            checkTypeContainer = false;
                            break;
                        } else {
                            System.out.println("WARNING: Chỉ được phép nhập 'thường' hoặc 'đông lạnh'! ");
                            continue;
                        }
                    }
                    System.out.print("Nhập trạng thái mới: ");
                    cnew.flagCon = checkNhapBoolean();

                    listCon.remove(c);
                    listCon.add(cnew);
                    break;
                }
            }
            if (timThay == false) {
                System.out.println("Không tìm thấy mã id của container cần chỉnh sửa!");
            }
        }
        return listCon;
    }

    public ArrayList<Container> locDanhSachTatCaContainer(ArrayList<Container> listCon) {
        boolean timThay = false;
        if (listCon.size() == 0) {
            System.out.println("Hiện không có danh sách container nào!");
        } else {
            System.out.println("DANH SÁCH CONTAINER THƯỜNG");
            for (Container c : listCon) {
                if (c.typeCon.equals("thường")) {
                    timThay = true;
                    System.out.println(c.toString());
                }
            }

            System.out.println("_________________________________________");
            System.out.println("DANH SÁCH CONTAINER ĐÔNG LẠNH");
            for (Container c : listCon) {
                if (c.typeCon.equals("đông lạnh")) {
                    timThay = true;
                    System.out.println(c.toString());
                }
            }
            if (timThay = false) {
                System.out.println("Null");
            }
        }


        return listCon;
    }

    public ArrayList<Container> locContainerHuHong(ArrayList<Container> listCon) {
        ArrayList<Container> listConBiHungHong = new ArrayList<Container>();
        int count = 0;
        for (Container c : listCon
        ) {
            if (c.flagCon.equals(true)) {
                count += 1;
                listConBiHuHong.add(c);
            }
        }
        if (listConBiHuHong.size() == 0) {
            System.out.println("Hiện không có container nào bị hư hỏng.");
        } else {
            System.out.println("Hiên có " + count + " cointainer bị hư hỏng");
            System.out.println("┌────────────────────────────────┐");
            System.out.println("| DANH SÁCH CONTAINER BỊ HƯ HỎNG |");
            System.out.println("└────────────────────────────────┘");
            System.out.println(listConBiHuHong);
        }
        return listConBiHuHong;
    }

    public int checkNhapSo() {
        int n;
        while (true) {
            String s = scanner.nextLine();
            if (s.trim().equals("")) {
                System.out.println("");
                System.out.println("WARNING: Không được phép nhập chuỗi rỗng!");
                continue;
            } else {
                try {
                    n = Integer.parseInt(s);
                    break;
                } catch (Exception e) {
                    System.out.println("WARNING: Chỉ được phép nhập số!");
                    continue;
                }
            }
        }
        return n;
    }

    public ArrayList<Container> locContainerThuong(ArrayList<Container> listCon) {
        ArrayList<Container> listConThuong = new ArrayList<Container>();
        int count = 0;
        for (Container cc : listCon
        ) {

            if (cc.typeCon.equals("thường")) {
                listConThuong.add(cc);
                count++;
            }
        }
        if (listConThuong.size() == 0) {
            System.out.println("Hiện không không có bất kì container thường nào trong danh sách!");
        } else {
            System.out.println("Hiên có " + count + " cointainer thường");
            System.out.println("┌────────────────────────────────┐");
            System.out.println("|   DANH SÁCH CONTAINER THƯỜNG   |");
            System.out.println("└────────────────────────────────┘");
            System.out.println(listConThuong);
        }
        return listConThuong;
    }

    public ArrayList<Container> locContainerDongLanh(ArrayList<Container> listCon)
    {
        int count =0;
        ArrayList<Container> lisConDongLanh = new ArrayList<Container>();
        for (Container c: listCon
             ) {
            if(c.typeCon.equals("đông lạnh"))
            {
                lisConDongLanh.add(c);
                count++;
            }
        }
        if(lisConDongLanh.size()==0)
        {
            System.out.println("Hiện không có container đông lạnh nào trong danh sách!");
        }
        else {
            System.out.println("Hiên có " + count + " cointainer thường");
            System.out.println("┌─────────────────────────────────┐");
            System.out.println("|  DANH SÁCH CONTAINER ĐÔNG LẠNH  |");
            System.out.println("└─────────────────────────────────┘");
            System.out.println(lisConDongLanh);
        }
        return lisConDongLanh;
    }

    public static boolean checkNhapBoolean() {
        boolean temp = true;
        while (true) {
            String s = scanner.nextLine();
            if (s.trim().equals("")) {
                System.out.println("WARNING: Không được phép nhập chuỗi rỗng!");
                continue;
            } else if (s.equals("true") || s.equals("false")) {
                temp = Boolean.parseBoolean(s);
                break;
            } else {
                System.out.println("WARNING: Chỉ được phép nhập true hoặc false!");
            }
        }
        return temp;
    }
}
