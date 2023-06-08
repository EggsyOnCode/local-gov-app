package com.example.demo.models;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.time.LocalDate;
abstract public class Complaint {

    private int id;

    private String complain_type;

    private String complaint_content;
    public final LocalDate current_time = LocalDate.now();
    /*
    public static synchronized Complaint getInstance(){
        if(comp==null){
            comp = new Complaint();
        }
        return comp;
    }
*/
    public abstract void setComplainType();

    public String getComplain_type() {
        return complain_type;
    }

    public void setComplain_type(String complain_type) {
        this.complain_type = complain_type;
    }

    public String getComplaint_content() {
        return complaint_content;
    }

    public void setComplaint_content(String complaint_content) {
        this.complaint_content = complaint_content;
    }


/* how tf do I add to Db?
    public void addToDB(String complaint_type, String complaint_content){
        MongoDatabase database = client.getDatabase("local-gov");
        MongoCollection<Document> collection = database.getCollection("residents");

        Document dummy = new Document("id",id).append("complaint_type", complaint_type).append("complaint_content", complaint_content);
        collection.insertOne(dummy);
        System.out.println("Complaint Registered");
    }

 */
}




