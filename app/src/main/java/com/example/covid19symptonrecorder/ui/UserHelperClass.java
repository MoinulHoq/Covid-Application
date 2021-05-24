package com.example.covid19symptonrecorder.ui;

public class UserHelperClass {

    String FirstName, LastName, emailID, Gender, DateOfBirth, PhoneNo, DescriptionOfSmyptom, NumberofDay;


    public UserHelperClass(String DescriptionOfSmyptom, String NumberofDay){
        this.DescriptionOfSmyptom=DescriptionOfSmyptom;
        this.NumberofDay=NumberofDay;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public UserHelperClass(String gender, String PhoneNo, String lastName, String dateOfBirth, String emailI, String firstName) {
        FirstName = firstName;
        LastName = lastName;
        this.emailID = emailI;
        Gender = gender;
        DateOfBirth = dateOfBirth;
        this.PhoneNo=PhoneNo;

    }

}