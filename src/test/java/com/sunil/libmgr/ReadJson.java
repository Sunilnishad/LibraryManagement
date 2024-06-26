package com.sunil.libmgr;

import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadJson {
	 private String input_title;
     private String input_author;
     private String input_ISBN;
     private String input_genre;
     private int input_publicationYear;
     private String input_department;
     private boolean input_availability;

    public String getInput_title() {
		return input_title;
	}

	public void setInput_title(String input_title) {
		this.input_title = input_title;
	}

	public String getInput_author() {
		return input_author;
	}

	public void setInput_author(String input_author) {
		this.input_author = input_author;
	}

	public String getInput_ISBN() {
		return input_ISBN;
	}

	public void setInput_ISBN(String input_ISBN) {
		this.input_ISBN = input_ISBN;
	}

	public String getInput_genre() {
		return input_genre;
	}

	public void setInput_genre(String input_genre) {
		this.input_genre = input_genre;
	}

	public int getInput_publicationYear() {
		return input_publicationYear;
	}

	public void setInput_publicationYear(int input_publicationYear) {
		this.input_publicationYear = input_publicationYear;
	}

	public String getInput_department() {
		return input_department;
	}

	public void setInput_department(String input_department) {
		this.input_department = input_department;
	}

	public boolean isInput_availability() {
		return input_availability;
	}

	public void setInput_availability(boolean input_availability) {
		this.input_availability = input_availability;
	}

	public static void main(String[] args) {
		String filePath = "F:\\LibraryManager\\src\\main\\resources\\test-data.json";
		ReadJson rj = new ReadJson();
        rj.load(filePath,0);
               
      
    }
	public void load(String filePath,int r)
	{
		 try {
	            // Read file content into a string
	            String content = new String(Files.readAllBytes(Paths.get(filePath)));

	            // Parse the JSON string
	            JSONObject jsonObject = new JSONObject(content);

	            // Get the 'books' array
	            JSONArray books = jsonObject.getJSONArray("books");

	            // Iterate over the array and print each book's details
	          
	                JSONObject book = books.getJSONObject(r);
	             
	                setInput_title(book.getString("title"));
	                setInput_author(book.getString("author"));
	                setInput_ISBN(book.getString("ISBN"));
	                setInput_genre(book.getString("genre"));
	                setInput_publicationYear(book.getInt("publicationYear"));
	                setInput_department(book.getString("department"));
	                setInput_availability(book.getBoolean("availability"));
	             
	          
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	}
}
