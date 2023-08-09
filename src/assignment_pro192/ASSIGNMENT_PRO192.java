/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_pro192;

import java.awt.Menu;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ttp
 */
public class ASSIGNMENT_PRO192 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        PhoneList pl = new PhoneList();
        CallList call = new CallList();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            System.out.println("1-Đọc thông tin danh sách các số điện thoại");
            System.out.println("2-Tính tiền cuộc gọi");
            System.out.println("3-Sắp xếp danh sách số điện thoại theo tên khách hàng");
            System.out.println("4-Sắp xếp danh sách cuộc gọi theo tên khách hàng gọi đi hoặc theo số tiền phải trả của cuộc gọi");
            System.out.println("5-Tìm danh sách các cuộc gọi đi của một số điện thoại nào đó");
            System.out.println("6-Tính tổng tiền phải trả của từng số điện thoại");
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            //  System.out.println(ops);
            System.out.println("Nhập chức năng: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("----------Phones------------");
                    pl.ReadDataFromFile("C:\\Users\\ttp\\Documents\\Phones.txt");
                    System.out.println("-----------Calls-----------");
                    call.ReadDataFromFile("C:\\Users\\ttp\\Documents\\Calls.txt", pl);
                    break;
                case 2:
                    System.out.println("Số tiền: ");
                    for (Call c : call.calls) {
                        System.out.println(c.toString() + " -> Số tiền: " + c.getTotalAmount(c.getDuration()) + "đ");
                    }
                    break;
                case 3:
                    pl.sortPhoneByName();
                    break;
                case 4:
//                    call.sortByCustomerName();
                    break;
                case 5:
                    call.findCallListByPhone(pl);
                    break;
                case 6:
                    call.getTotalAmount(pl);
                    break;

            }
        } while (choice > 0 && choice <= 6);
    }

}
