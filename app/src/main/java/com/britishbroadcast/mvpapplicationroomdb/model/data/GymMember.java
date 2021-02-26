package com.britishbroadcast.mvpapplicationroomdb.model.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "gym_member")
public class GymMember {
    @Override
    public String toString() {
        return "GymMember{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", memberID='" + memberID + '\'' +
                ", phone='" + phone + '\'' +
                ", monthlyPay=" + monthlyPay +
                '}';
    }

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "address")
    private String address;

    @ColumnInfo(name = "member_id")
    private String memberID;

    @ColumnInfo(name = "phone")
    private String phone;

    @ColumnInfo(name = "monthly_pay")
    private double monthlyPay;

    //this will be used for data entry
    @Ignore //Making Room Ignore this one...
    public GymMember(String name, String address, String memberID, String phone, double monthlyPay) {
        this.name = name;
        this.address = address;
        this.memberID = memberID;
        this.phone = phone;
        this.monthlyPay = monthlyPay;
    }

    //this will be used by room
    public GymMember(int id, String name, String address, String memberID, String phone, double monthlyPay) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.memberID = memberID;
        this.phone = phone;
        this.monthlyPay = monthlyPay;
    }

    public double getMonthlyPay() {
        return monthlyPay;
    }

    public void setMonthlyPay(double monthlyPay) {
        this.monthlyPay = monthlyPay;
    }

    public int getId() {
        return id;
    }

    public String getMemberID() {
        return memberID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
