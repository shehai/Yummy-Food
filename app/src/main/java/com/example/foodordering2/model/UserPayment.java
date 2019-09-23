package com.example.foodordering2.model;

public class UserPayment {

    private String Name;
    private String Price;
    private String FoodNo;
    private String ContactNo;
    private String PaymentMtehod;

    public UserPayment() {

    }

    public String getName() {
        return Name;
    }

    public String getPrice() {
        return Price;
    }

    public String getFoodNo() {
        return FoodNo;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public String getPaymentMtehod() {
        return PaymentMtehod;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public void setFoodNo(String foodNo) {
        FoodNo = foodNo;
    }

    public void setContactNo(String contactNo) {
        ContactNo = contactNo;
    }

    public void setPaymentMtehod(String paymentMtehod) {
        PaymentMtehod = paymentMtehod;
    }
}