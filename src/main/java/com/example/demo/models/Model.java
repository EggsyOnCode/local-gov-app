package com.example.demo.models;

import com.example.demo.views.ViewFactory;
import com.mongodb.client.*;
import org.bson.Document;

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
}
