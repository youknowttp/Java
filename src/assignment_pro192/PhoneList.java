/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_pro192;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ttp
 */
public class PhoneList extends Phone {

    ArrayList<Phone> phones = new ArrayList<>();
    int numOfPhone = 0; // Lưu số phần tử tạm thời trong ListPhone

    public PhoneList() {
    }

    @Override
    public String toString() {
        return "PhoneList{" + "phones=" + phones + '}';
    }
    
    public void ReadDataFromFile(String filename) {     
        try {
            FileReader reader = new FileReader(filename);
            BufferedReader buf = new BufferedReader(reader);
            while (true) {
                try {
                    String s = buf.readLine();
                    if (s == null) {
                        break;
                    }
                    String[] items = s.split("[|]");
                    Phone phone = new Phone(items[0], items[1]);
//                    System.out.println(phone.toString());
                    phones.add(phone);
                    System.out.println(s);
                } catch (IOException ex) {
                    Logger.getLogger(ASSIGNMENT_PRO192.class.getName()).log(Level.SEVERE, null, ex);
                }
            }//1.2 2.1 0.7 0.625 1.8    
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(ASSIGNMENT_PRO192.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File khong ton tai");
        }
    }
    
    
    public void sortPhoneByName() {

        Collections.sort(phones, new Comparator<Phone>() {

            @Override
            public int compare(Phone t, Phone t1) {
                return (t.getCustomer().compareTo(t1.getCustomer()));
                }
            }
        );

        System.out.println("Danh sách số điện thoại theo tên khách hàng:  ");
        for (int i = 0; i < phones.size(); i++) {
            System.out.println("Tên khách hàng: " + phones.get(i).getCustomer() + " - Số điện thoại: " + phones.get(i).getPhoneNumber());
        }

    }

    
}
