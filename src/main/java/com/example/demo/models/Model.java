package com.example.demo.models;

import com.example.demo.views.ViewFactory;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.eq;

//making a singleton class
public class Model {
    private final ViewFactory viewFactory;
    private  final MongoClient client;
    private final Resident res=null;

    private static Model model;
    private boolean loginFlag = false;

    private Model(){
        this.viewFactory = new ViewFactory();
        this.client = MongoClients.create("mongodb+srv://faizi:1234@cluster0.5rlfwh2.mongodb.net/?retryWrites=true&w=majority");
//        this.res = new Resident("","","",null,null,"","");

    }

    public static synchronized Model getInstance(){
        if(model==null){
            model = new Model();
        }
        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }


    public boolean authenticate(String id, String pswd){
        MongoDatabase database = client.getDatabase("local-gov");
        MongoCollection<Document> collection = database.getCollection("residents");

//        Document dummy = new Document("id","faizi").append("password","123");
//        collection.insertOne(dummy);

        Document query = new Document("id",id);
        FindIterable<Document> results = collection.find(query);
        Document userDoc = results.first();
        String pswd_temp = userDoc.getString("password");
        if(pswd_temp.equals(pswd)){
            loginFlag = true;
            System.out.println("you are in");
            return true;
        }
        else{
            System.out.println("you are out");
            System.out.println(pswd_temp);
            return false;
        }
    }

    public void addToDB(String id, String pswd, String name, String cnic, String uc, String fam, String period){
        MongoDatabase database = client.getDatabase("local-gov");
        MongoCollection<Document> collection = database.getCollection("residents");

        Document dummy = new Document("id",id).append("password",pswd).append("name",name).append("cnic",cnic).append("uc",uc).append("family mem",fam).append("period of residence",period);
        collection.insertOne(dummy);
        System.out.println("data entered");
    }

    public String getDataofId(String username, String attribute){
        MongoDatabase database = client.getDatabase("local-gov");
        MongoCollection<Document> collection = database.getCollection("residents");
        Document query = new Document("id",username);
        FindIterable<Document> results = collection.find(query);
        Document userDoc = results.first();
        return userDoc.getString(attribute);

    }
    public void getUserData(String id) throws InterruptedException {
        MongoDatabase database = client.getDatabase("local-gov");
        MongoCollection<Document> collection = database.getCollection("residents");
        Document query = new Document("id",id);
        FindIterable<Document> results = collection.find(query);
        Document userDoc = results.first();
        Resident.getInstance().setfName(userDoc.getString("name"));
        Resident.getInstance().setGender(userDoc.getString("Gender"));
        Resident.getInstance().setAddress(userDoc.getString("Address"));
        Resident.getInstance().setPhone(userDoc.getString("Phone Number"));
        Resident.getInstance().setProfession(userDoc.getString("Profession"));
        Resident.getInstance().setCnic(userDoc.getString("cnic"));
        Resident.getInstance().setUc(userDoc.getString("uc"));
        Resident.getInstance().setPeriod_of_residence(userDoc.getString("period of residence"));
        Resident.getInstance().setFam_mem(userDoc.getString("family mem"));
        Resident.getInstance().setUsername(userDoc.getString("id"));
        Resident.getInstance().setPassword(userDoc.getString("password"));

    }

    public void updateDB(String id, String gender, String prof, String phone, String email, String org, String marital_status,  String fam_details, String social,String address){
        MongoDatabase database = client.getDatabase("local-gov");
        MongoCollection<Document> collection = database.getCollection("residents");
        Bson filter = eq("id",id);

        Document newFields = new Document();
        newFields.append("Gender", gender);
        Resident.getInstance().setGender(gender);
        newFields.append("Profession", prof);
        Resident.getInstance().setProfession(prof);
        newFields.append("Phone Number", phone);
        Resident.getInstance().setPhone(phone);
        newFields.append("Address", address);
        Resident.getInstance().setAddress(address);
        newFields.append("Email", email);
        newFields.append("Organization", org);
        newFields.append("Marital Status", marital_status);
        newFields.append("Social Work", social);
        newFields.append("Family Details", fam_details);


        // Create an update operation using the $set operator
        Bson update = new Document("$set", newFields);


        // Perform the update operation
        collection.updateOne(filter, update);
        System.out.println("data added");

        // Close the MongoClient
        client.close();
    }

    public void addImgtoDB(String id, byte[] imageData){
        MongoDatabase database = client.getDatabase("local-gov");
        MongoCollection<Document> collection = database.getCollection("residents");
        Bson filter = eq("id",id);
        Document newFields = new Document();
        newFields.append("Profile Pic", imageData);
        Bson update = new Document("$set", newFields);
        collection.updateOne(filter, update);
        System.out.println("img added");
        client.close();
    }

}
