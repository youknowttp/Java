/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_pro192;

/**
 *
 * @author ttp
 */
public class Phone {
    private String phoneNumber;
    private String customer;

    public Phone() {
    }

    public Phone(String phoneNumber, String customer) {
        this.phoneNumber = phoneNumber;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return  phoneNumber + " - " +  customer ;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
    
    public void displayTotalAmount(){
        System.out.println("Phone number: " + phoneNumber + " Name: " + customer);
    }
//    public int compareTo(Phone obj){
//        int d = this.
//    }

    
            
}
