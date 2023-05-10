package com.example.demo.models;


public class Resident {
    private final String fName;
    private final String cnic;
    private final String uc;
    private final String period_of_residence;

    private final String fam_mem;

    private static Resident res;
    private final String username;
    private final String password;


    private Resident(String fName, String cnic, String uc, String periodOfResidence, String famMem, String username, String password) {
        this.fName = fName;
        this.cnic = cnic;
        this.uc = uc;
        this.period_of_residence = periodOfResidence;
        this.fam_mem = famMem;
        this.username = username;
        this.password = password;
    }

//    public static synchronized Resident getInstance(){
//        if(res==null){
//            res = new Resident();
//        }
//        return res;
//    }


    public String fNameProperty() {
        return fName;
    }


    public String cnicProperty() {
        return cnic;
    }

    public String ucProperty() {
        return uc;
    }


    public String period_of_residenceProperty() {
        return period_of_residence;
    }


    public String fam_memProperty() {
        return fam_mem;
    }


    public String usernameProperty() {
        return username;
    }


    public String passwordProperty() {
        return password;
    }
}
