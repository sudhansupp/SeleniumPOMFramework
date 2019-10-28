package com.demo.util;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class JSONRead {
	
		EnvProperty envObject = null;
		public EnvProperty getJSONData() {
		
		try {
			String path = System.getProperty("user.dir")+"\\TestData\\TextData\\Env.json";
		
			Object obj = new JSONParser().parse(new FileReader(path));

				// typecasting obj to JSONObject
				JSONObject jsonObject = (JSONObject) obj;

				// getting env
				String env = (String) jsonObject.get("env");
				System.out.println("--ENV_TENANT--{} " + env);

				// getting envProperties
				Map mapProperties = ((Map) jsonObject.get(env));
				// iterating envProperties Map
				Iterator<Map.Entry> iterator = mapProperties.entrySet().iterator();
				envObject = new EnvProperty();
				while (iterator.hasNext()) {
					Map.Entry pair = iterator.next();
					if(pair.getKey().toString().equals("url")) {
						envObject.setUrl(pair.getValue().toString());
					}else if(pair.getKey().toString().equals("username")) {
						envObject.setUsername(pair.getValue().toString());
					}else if(pair.getKey().toString().equals("password")) {
						envObject.setPassword(pair.getValue().toString());
					}
				}
				System.out.println(envObject.toString());
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return envObject;
	}
		

	
}