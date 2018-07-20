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

@Path("/")
public class ArchAngelService {

	@POST
	@Path("/fetch")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response lookupResource(@FormParam("fieldUno") String uno,
	    @FormParam("fieldDos") String dos){
	    try {	
	    	System.out.println("@@@@@@@@@@@@@@@@@@@@@");
	    	System.out.println("UNO: " + uno);
	    	System.out.println("DOS: " + dos);
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
		System.out.println("^^^^^^^^^^^^^^^^^^^^^");
		StringBuilder incomingJSONData = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
			String line = null;
			while ((line = in.readLine()) != null) {
				incomingJSONData.append(line);
			}
		} catch (Exception e) {
			System.out.println("Error Parsing: - ");
		}
		System.out.println("Data Received: " + incomingJSONData.toString());
 
		// return HTTP response 200 in case of success
		return Response.status(200).entity(incomingJSONData.toString()).build();
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