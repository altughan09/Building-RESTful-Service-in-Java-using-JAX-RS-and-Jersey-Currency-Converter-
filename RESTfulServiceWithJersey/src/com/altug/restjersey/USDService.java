package com.altug.restjersey;

/**
 * @author Altughan Ozengi
 * * Description: This program converts USD to other currencies (EUR, PLN, TL).
 * Last updated: 18/03/2019
 */

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;


@Path("/usdservice")
public class USDService {
	
	@GET
	@Produces("application/json")
	public Response convertUSD() throws JSONException {

		JSONObject jsonObject = new JSONObject();
		Double usd = 1.00;
		Double eur;
		Double pln;
		Double tl;
				
		eur = usd / 1.13;
		pln = usd / 0.26;
		tl = usd / 0.18;
		jsonObject.put("USD Value", usd);
		jsonObject.put("EUR Value", eur);
		jsonObject.put("PLN Value", pln);
		jsonObject.put("TRY Value", tl);
		
		String result = "@Produces(\"application/json\") Output: \n\nUSD convertion output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	
	}
	
	@Path("{c}")
	@GET
	@Produces("application/json")
	public Response convertUSDfromInput(@PathParam("c") Double c) throws JSONException {

		JSONObject jsonObject = new JSONObject();
		Double usd = c;
		Double eur;
		Double pln;
		Double tl;
		
		eur = usd / 1.13;
		pln = usd / 0.26;
		tl = usd / 0.18;
 
		jsonObject.put("USD Value", usd);
		jsonObject.put("EUR Value", eur);
		jsonObject.put("PLN Value", pln);
		jsonObject.put("TRY Value", tl);
		
		String result = "@Produces(\"application/json\") Output: \n\nUSD convertion output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	}

	
}
