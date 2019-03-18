# Building-RESTful-Service-in-Java-using-JAX-RS-and-Jersey-Currency-Converter-

REST defines a set of architectural principles by which we can design Web services that focus on a system’s resources, including how resource states are addressed and transferred over HTTP by a wide range of clients written in different languages.

Java API for RESTful Web Services (JAX-RS), is a set of APIs to create REST service. In this tutorial I developed a Currency Converter REST-API service using Jersey RESTful Web Services framework. Project type selected as Maven Project to add required jar libraries. File format was defined as JSON (JavaScript Object Notation).

Below is the result of my work;

**Test 1: USD currency converter without parameter**
![alt text](https://i.ibb.co/wRFj9xn/Building-RESTful-Service-in-Java-using-JAX-RS-and-Jersey-1.png)

**Test 2: USD currency converter with parameter**
![alt text](https://i.ibb.co/56zB5xw/Building-RESTful-Service-in-Java-using-JAX-RS-and-Jersey-2.png)

**Project organisation and code details**

![alt text](https://i.ibb.co/b681cNg/project-organisation.png)

![alt text](https://i.ibb.co/th8kRTq/1.png)

![alt text](https://i.ibb.co/2ncVvBC/2.png)

**Project Object Model (pom.xml) Configuration **
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>RESTfulServiceWithJersey</groupId>
  <artifactId>RESTfulServiceWithJersey</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>war</packaging>
  <build>
    <sourceDirectory>src</sourceDirectory>
    <plugins>
      <plugin>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.7.0</version>
        <configuration>
          <source>1.8</source>
          <target>1.8</target>
        </configuration>
      </plugin>
      <plugin>
        <artifactId>maven-war-plugin</artifactId>
        <version>3.0.0</version>
        <configuration>
          <warSourceDirectory>WebContent</warSourceDirectory>
        </configuration>
      </plugin>
    </plugins>
  </build>
  <dependencies>
		<dependency>
			<groupId>asm</groupId>
			<artifactId>asm</artifactId>
			<version>3.3.1</version>
		</dependency>
		<dependency>
			<groupId>com.sun.jersey</groupId>
			<artifactId>jersey-bundle</artifactId>
			<version>1.19.4</version>
		</dependency>
		<dependency>
			<groupId>org.json</groupId>
			<artifactId>json</artifactId>
			<version>20170516</version>
		</dependency>
		<dependency>
			<groupId>com.sun.jersey</groupId>
			<artifactId>jersey-server</artifactId>
			<version>1.19.4</version>
		</dependency>
		<dependency>
			<groupId>com.sun.jersey</groupId>
			<artifactId>jersey-core</artifactId>
			<version>1.19.4</version>
		</dependency>
	</dependencies>
</project>
```

**USDService.java - Service class file**
```
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

```
