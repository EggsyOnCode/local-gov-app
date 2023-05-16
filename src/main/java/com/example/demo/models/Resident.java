package com.example.demo.models;


import com.sun.javafx.beans.event.AbstractNotifyListener;

public class Resident {
    private  String fName;

    private byte[] profilePic;
    private  String cnic;
    private  String profession;

    public byte[] getProfilePic() {
        return profilePic;
    }

    public String getProfession() {
        return profession;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String address;
    private  String gender;
    private String phone;
    private  String uc;
    private  String period_of_residence;

    private  String fam_mem;

    private static Resident res;
    private  String username;
    private  String password;


    private Resident() {

    }

    public static synchronized Resident getInstance(){
        if(res==null){
            res = new Resident();
        }
        return res;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public void setUc(String uc) {
        this.uc = uc;
    }

    public void setPeriod_of_residence(String period_of_residence) {
        this.period_of_residence = period_of_residence;
    }

    public void setFam_mem(String fam_mem) {
        this.fam_mem = fam_mem;
    }

    public static void setRes(Resident res) {
        Resident.res = res;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getfName() {
        return fName;
    }


    public String getCnic() {
        return cnic;
    }

    public String getUc() {
        return uc;
    }

    public void setProfilePic(byte[] profilePic) {
        this.profilePic = profilePic;
    }

    public String getPeriod_of_residence() {
        return period_of_residence;
    }


    public String getFam_mem() {
        return fam_mem;
    }


    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }
}
