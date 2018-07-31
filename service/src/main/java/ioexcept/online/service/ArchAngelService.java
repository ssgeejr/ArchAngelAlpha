package ioexcept.online.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.mongodb.client.*;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.json.*;
import org.json.JsonObject;
import static com.mongodb.client.model.Filters.eq;

@Path("/")
public class ArchAngelService {
	private MongoConnectionmanager connMan = null;
	private  MongoDatabase mongodb = null;

	@POST
	@Path("/fetch")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response lookupResource(@FormParam("car") String car){
	    try {	
	    	System.out.println("@@@@@@@@@@@@@@@@@@@@@");
	    	System.out.println("CAR: " + car);
	    	return Response.status(200).build();
	    }catch(Exception ex) {
	    	ex.printStackTrace();
	    	return Response.status(Response.Status.PRECONDITION_FAILED).build();
	    }
	}		
		
		
	@POST
	@Path("/query")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response query(InputStream incomingData) {
		int responseCode = 200;
		System.out.println("^^^^^^^^^^^^^^^^^^^^^");
		StringBuilder incomingJSONData = new StringBuilder();
		MongoDatabase mongodb = null;
		MongoConnectionmanager connMan = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				incomingJSONData.append(line);
			}
			org.json.JsonObject jsonObject = new org.json.JsonObject().parse(incomingJSONData.toString()).getAsJsonObject();
			String key = jsonObject.get("car").getAsString();
//			String value = jsonObject.get("value").getAsString();
			System.out.println("car: " + car); //John
//			System.out.println("value: " + value);
			
			System.out.println("==========>> Open Connection <<==========");
			openConnection();
			System.out.println("__________>> END [Open Connection] <<__________");
			System.out.println("==========>> Fetch Filtered Record <<==========");
			MongoCollection<Document> collection = mongodb.getCollection("gsma");
//			"Marketing Name" : "A53",
			
			
			Document olethaFilter = collection.find(eq(car, car)).first().pretty();
//			Document olethaFilter = collection.find(eq("city", "Olathe")).first();
			System.out.println(olethaFilter.toJson());
			System.out.println("__________>> END [Fetch Filtered Record] <<__________");
			incomingJSONData.setLength(0);
			incomingJSONData.append(olethaFilter.toJson());
			System.out.println(olethaFilter.toJson());
		}catch(Exception ex) {
			System.out.println("Error Parsing: - ");
			responseCode = 406;		//Not Acceptable
			ex.printStackTrace();
			incomingJSONData.setLength(0);
			incomingJSONData.append(ex.getMessage());
		}finally {
			if (connMan != null) connMan.closeConnection();
		}
		
		
		System.out.println("Return Code [" + responseCode + "] Response [" + incomingJSONData.toString() + "]");
		return Response.status(responseCode).entity(incomingJSONData.toString()).build();
	}
 
	@GET
	@Path("/verify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response verifyRESTService(InputStream incomingData) {
		System.out.println("Verfied ArchAngelService online ...");
//		String result = "";
// return HTTP response 200 in case of success
		return Response.status(200).entity("Success").build();
	}
 
	
	private void openConnection() throws Exception{
		// update the connection manager for you configuration
		System.out.println("==========>> Open Connection <<==========");
		connMan = new MongoConnectionmanager();
		mongodb = connMan.getDatabase("sku");
		System.out.println("__________>> END [Open Connection] <<__________");
	}

	
}


/*

@Path("/messages")
public class MessageResource {
 
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createMessage(@FormParam("name") String name,
                                @FormParam("message") String message,
                                @FormParam("thelist") List<String> list) {
        if(name.trim().length() > 0 && message.trim().length() > 0 && !list.isEmpty()) {
            // Note 1: Normally you would persist the new message to a datastore
            // of some sort. I'm going to pretend I've done that and
            // use a unique id for it that obviously points to nothing in
            // this case.
            // Note 2: The way I'm returning the data should be more like the commented
            // out piece, I am being verbose for the sake of showing you how to
            // get the values and show that it was read.
            return Response.created(URI.create("/messages/" + String.valueOf(UUID.randomUUID()))).entity(
                    name+ ": " + message + " --> the items: " + list.get(0) + " - " + list.get(1)).build();
 
            // This is a more real world "return"
            //return Response.created(URI.create("/messages/" + String.valueOf(UUID.randomUUID()))).build();
        }
        return Response.status(Response.Status.PRECONDITION_FAILED).build();
    }
}





*/