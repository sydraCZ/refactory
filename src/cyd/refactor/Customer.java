package cyd.refactor;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Administrator on 2017/8/15.
 */
public class Customer {
    private String _name;                                 // 姓名
    private Vector _rentals = new Vector();               // 租借記錄

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        Enumeration rentals = _rentals.elements();
        String result = "Rental Record for " + getName() + "\n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement(); // 取得一筆租借記錄

            // show figures for this rental（顯示此筆租借資料）
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(each.getCharge()) + "\n";
        }

        // add footer lines（結尾列印）
        result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +
                " frequent renter points";
        return result;
    }

    private double getTotalAmount() {
        double totalAmount = 0;                     // 總消費金額
        Enumeration rentals = _rentals.elements();

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement(); // 取得一筆租借記錄
            totalAmount += each.getCharge();
        }
        return totalAmount;
    }

    private double getTotalFrequentRenterPoints() {
        int frequentRenterPoints = 0;       // 常客積點
        Enumeration rentals = _rentals.elements();

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement(); // 取得一筆租借記錄
            // add frequent renter points（累加 常客積點）
            frequentRenterPoints += each.getFrequentRenterPoints();
        }
        return frequentRenterPoints;
    }
}
