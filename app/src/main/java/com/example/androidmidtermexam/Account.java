package com.example.androidmidtermexam;

import android.os.Parcel;
import android.os.Parcelable;

public class Account implements Parcelable {

    private int accountNumber ;
    private double balance;
    private String bankName;

    public Account(String bankName, double balance, int accountNumber){
        this.bankName = bankName;
        this.balance = balance;
        this.accountNumber = accountNumber;

    }

    protected Account(Parcel in) {
        accountNumber = in.readInt();
        balance = in.readDouble();
        bankName = in.readString();
    }

    public static final Creator<Account> CREATOR = new Creator<Account>() {
        @Override
        public Account createFromParcel(Parcel in) {
            return new Account(in);
        }

        @Override
        public Account[] newArray(int size) {
            return new Account[size];
        }
    };

    public String getBankName(){
        return bankName;
    }

    public void setBankName(String bankName){
        this.bankName = bankName;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public void set_bankName(double balance){
        this.balance = balance;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(accountNumber);
        dest.writeDouble(balance);
        dest.writeString(bankName);
    }
}
