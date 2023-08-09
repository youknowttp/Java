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
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.UIManager.get;

/**
 *
 * @author ttp
 */
public class CallList extends Call {
    
    ArrayList<Call> calls = new ArrayList<>();
    ArrayList<Phone> phones = new ArrayList<>();
    public CallList() {
    }

    public void ReadDataFromFile(String filename, PhoneList phoneList) {
    
        try {
            FileReader reader = new FileReader(filename);
            BufferedReader buf = new BufferedReader(reader);
            String s ="";
            while (true) {
                try {
                    s = buf.readLine();

                    if (s == null) {
                        break;
                    }
                    String[] items = s.split("[|]");

                    Phone from = new Phone();
                    Phone to = new Phone();
                    for (Phone p : phoneList.phones) { 
                        if (items[0] == null ? (p.getPhoneNumber()) == null : items[0].equals(p.getPhoneNumber())) {
                            from = p;
                        }
                        if (items[1] == null ? (p.getPhoneNumber()) == null : items[1].equals(p.getPhoneNumber())) {
                            to = p;
                        }           
                    }
                    Call call = new Call(from, to , Integer.parseInt(items[2]));
                    calls.add(call);
                    System.out.println(s);
                } catch (IOException ex) {
                    Logger.getLogger(ASSIGNMENT_PRO192.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(ASSIGNMENT_PRO192.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File khong ton tai");
        }

    }

    @Override
    public String toString() {
        return "CallList{" + "calls=" + calls + '}';
    }

    public int getTotalAmount(Phone phone){  
        int sum = 0;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số điện thoại: ");
        String phones = sc.nextLine();
        for(Call call: calls){
            if(call.getFrom().getPhoneNumber().equals(phones))
                sum = sum + call.getTotalAmount(call.getDuration());
        }
        System.out.println("Tóng số tiền: " + sum);
      return sum;
    }
    

    public void findCallListByPhone(Phone phone) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số điện thoại: ");
        String phones = sc.nextLine();
        System.out.println("Danh sách cuộc gọi:");
        for (Call call : calls) {
            
            if (call.getFrom().getPhoneNumber().equals(phones)) {        
                System.out.println(call.toString());
            }
        }
    }
    
//    public void sortByPhoneList(){
//        for(Call call: calls){
//            if(call.getFrom().getPhoneNumber().equals(phone))
//        }
//                
    }
//        public void sortByCustomerName() {
////            for (Call call : calls) {
////               if(call.getFrom().equals(call.getCustomer()))
////                   call.setFrom(call);
////            }
//
////            Collections.sort(calls, new Comparator<Call>() {
////                @Override
////                public int compare(Call t, Call t1) {
////                    return (t.getFrom().compareTo(t1.getFrom()));
////                }
////                });
// if (items[0] == null ? (p.getPhoneNumber()) == null : items[0].equals(p.getPhoneNumber())) {
//                            from = p;
//                        }
//                        if (items[1] == null ? (p.getPhoneNumber()) == null : items[1].equals(p.getPhoneNumber())) {
//                            to = p;
//            System.out.println("Sorted list");
//            for(int i =0;i<calls.size();i++)
//                System.out.println(calls.get(i).getFrom());
    

    

