/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_pro192;

import java.time.Duration;
import java.util.ArrayList;

/**
 *
 * @author ttp
 */
public class Call extends Phone{
    private Phone from;
    private Phone to;
    private int duration;
    private String check;
    
    public Call() {
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public Call(Phone from, Phone to, int duration) {
        this.from = from;
        this.to = to;
        this.duration = duration;
    }

    public Call(Phone from, Phone to, int duration, String phoneNumber, String customer) {
        super(phoneNumber, customer);
        this.from = from;
        this.to = to;
        this.duration = duration;
    }

    public Phone getFrom() {
        return from;
    }

    public void setFrom(Phone from) {
        this.from = from;
    }

    public Phone getTo() {
        return to;
    }

    public void setTo(Phone to) {
        this.to = to;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    public int getTotalAmount(int duration) {
        int a = duration * 1500;
        int b = 10 * 1500 + (duration - 10) * 1300;
        int c = 10 * 1500 + 50 * 1300 + (duration - 60) * 1000;
        if (duration < 10) {
            return a;
        } else if (duration >= 10 && duration < 60) {
            return b;
        } else {
            return c;
        }
    }
    
    @Override
    public String toString() {
        return "From: " + from + ", To: " + to + ", Duration: " + duration ;
    }
    
    
}
