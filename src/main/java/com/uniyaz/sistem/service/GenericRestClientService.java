package com.uniyaz.sistem.service;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.primefaces.shaded.json.JSONObject;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public abstract class GenericRestClientService<T> {

	private static Gson g = new Gson();

	private Class<T> entityClass;

	public GenericRestClientService(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public List<T> findAll(String remoteAddress) throws Exception {
		URL url = new URL(remoteAddress);
		List<T> response = new ArrayList<T>();
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output;
		while ((output = br.readLine()) != null) {
			JSONObject result = new JSONObject(output);
			JsonArray jsonArray = new JsonParser().parse(result.get("data").toString()).getAsJsonArray();
			for (int i = 0; i < jsonArray.size(); i++) {
				T type = g.fromJson(jsonArray.get(i), entityClass);
				response.add(type);
			}
		}
		return response;
	}

	@SuppressWarnings("deprecation")
	public T find(String remoteAddress) throws Exception {
		URL url = new URL(remoteAddress);
		T response = null;
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output;
		while ((output = br.readLine()) != null) {
			JSONObject result = new JSONObject(output);
			JsonObject jsonArray = new JsonParser().parse(result.get("data").toString()).getAsJsonObject();
			if (!jsonArray.isEmpty()) {
				response = g.fromJson(jsonArray, entityClass);
			}
		}
		return response;
	}

	public T post(String remoteAddress, T entity) throws Exception {
		T responseRetVal = null;
		URL url = new URL(remoteAddress);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setDoOutput(true);

		String jsonInputString = "";
		Gson gsonBuilder = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		jsonInputString = gsonBuilder.toJson(entity);
		java.io.OutputStream os = con.getOutputStream();
		byte[] input = jsonInputString.getBytes("utf-8");
		os.write(input, 0, input.length);

		int responseCode = con.getResponseCode();

		String aa = con.getResponseMessage();

		InputStream inputa = con.getInputStream();
		String encoding = con.getContentEncoding();
		encoding = encoding == null ? "UTF-8" : encoding;
		String body = IOUtils.toString(inputa, encoding);

		JSONObject result = new JSONObject(body);

		String data = result.get("data").toString().replace("[", "");
		data = data.replace("]", "");
		String success = result.get("success").toString().replace("[", "");
		success = success.replace("]", "");
		String message = result.get("message").toString().replace("[", "");
		message = message.replace("]", "");

		if (success == "false") {
			throw new Exception(message);
		}

		responseRetVal = g.fromJson(data, entityClass);

		BufferedReader br = null;
		if (100 <= con.getResponseCode() && con.getResponseCode() <= 399) {
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else {
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}

		if (responseCode == 201) {

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			responseRetVal = g.fromJson(response.toString(), entityClass);
		}

		return responseRetVal;
	}

	public T update(String remoteAddress, T entity) throws Exception {
		T responseRetVal = null;
		URL url = new URL(remoteAddress);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("PUT");
		con.setRequestProperty("Content-Type", "application/json");
		con.setDoOutput(true);

		String jsonInputString = "";
		Gson gsonBuilder = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		jsonInputString = gsonBuilder.toJson(entity);
		java.io.OutputStream os = con.getOutputStream();
		byte[] input = jsonInputString.getBytes("utf-8");
		os.write(input, 0, input.length);

		int responseCode = con.getResponseCode();

		String aa = con.getResponseMessage();

		InputStream inputa = con.getInputStream();
		String encoding = con.getContentEncoding();
		encoding = encoding == null ? "UTF-8" : encoding;
		String body = IOUtils.toString(inputa, encoding);

		JSONObject result = new JSONObject(body);

		String data = result.get("data").toString().replace("[", "");
		data = data.replace("]", "");
		String success = result.get("success").toString().replace("[", "");
		success = success.replace("]", "");
		String message = result.get("message").toString().replace("[", "");
		message = message.replace("]", "");

		if (success == "false") {
			throw new Exception(message);
		}

		responseRetVal = g.fromJson(data, entityClass);

		BufferedReader br = null;
		if (100 <= con.getResponseCode() && con.getResponseCode() <= 399) {
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else {
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}

		if (responseCode == 201) {

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			responseRetVal = g.fromJson(response.toString(), entityClass);
		}

		return responseRetVal;
	}

	public String delete(String remoteAddress, T entity) throws Exception {
		T responseRetVal = null;
		URL url = new URL(remoteAddress);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("DELETE");
		con.setRequestProperty("Content-Type", "application/json");
		con.setDoOutput(true);

		String jsonInputString = "";
		Gson gsonBuilder = new GsonBuilder().create();
		jsonInputString = gsonBuilder.toJson(entity);
		java.io.OutputStream os = con.getOutputStream();
		byte[] input = jsonInputString.getBytes("utf-8");
		os.write(input, 0, input.length);

		int responseCode = con.getResponseCode();

		String aa = con.getResponseMessage();

		InputStream inputa = con.getInputStream();
		String encoding = con.getContentEncoding();
		encoding = encoding == null ? "UTF-8" : encoding;
		String body = IOUtils.toString(inputa, encoding);

		JSONObject result = new JSONObject(body);

		String success = result.get("success").toString().replace("[", "");
		success = success.replace("]", "");

		String message = null;

		if (success == "false") {
			message = result.get("message").toString().replace("[", "");
			message = message.replace("]", "");
			throw new Exception(message);
		} else {
			message = result.get("message").toString().replace("[", "");
			message = message.replace("]", "");
			return message;
		}
	}

	public String delete(String remoteAddress) throws Exception {

		URL url = new URL(remoteAddress);
		String message = null;
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("DELETE");
		conn.setRequestProperty("Accept", "application/json");
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output;
		while ((output = br.readLine()) != null) {
			JSONObject result = new JSONObject(output);
			
			
			String success = result.get("success").toString().replace("[", "");
			success = success.replace("]", "");

			

			if (success == "false") {
				message = result.get("message").toString().replace("[", "");
				message = message.replace("]", "");
				throw new Exception(message);
			} else {
				message = result.get("message").toString().replace("[", "");
				message = message.replace("]", "");
				return message;
			}
			
			 
		}
		return message;
	}

	public String update(String remoteAddress) throws Exception {

		URL url = new URL(remoteAddress);
		String response = null;
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("PUT");
		conn.setRequestProperty("Accept", "application/json");
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output;
		while ((output = br.readLine()) != null) {
			JSONObject result = new JSONObject(output);
			JsonObject jsonArray = new JsonParser().parse(result.get("data").toString()).getAsJsonObject();
			if (!jsonArray.isEmpty()) {
				response = (String) g.fromJson(jsonArray, entityClass);
			}
		}
		return response;
	}

}