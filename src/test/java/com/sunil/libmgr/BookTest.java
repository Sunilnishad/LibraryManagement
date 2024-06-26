package com.sunil.libmgr;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/***
 * Created by Sunil Nishad
 * Created on Date:27/08/2024
 * In this test data is created while object creation.
 */

public class BookTest {
	String filePath;
	
	private ReadJson rjson;
	@BeforeEach
	public void load()
	{
		filePath = "../resources/test-data.json";
		rjson = new ReadJson();
        
	}
	
    @Test
    public void testBookCreation() {
    	rjson.load(filePath,0);
        Book book = new Book(rjson.getInput_title(), rjson.getInput_author(), rjson.getInput_ISBN(), rjson.getInput_genre(), rjson.getInput_publicationYear(), rjson.getInput_department(), true);
        assertEquals(rjson.getInput_title(), book.getTitle());
        assertEquals(rjson.getInput_author(), book.getAuthor());
        assertEquals( rjson.getInput_ISBN(), book.getISBN());
        assertEquals(rjson.getInput_genre(), book.getGenre());
        assertEquals(rjson.getInput_publicationYear(), book.getPublicationYear());
        assertEquals(rjson.getInput_department(), book.getDepartment());
        assertTrue(book.isAvailability());
    }

    @Test
    public void testSetters() {
    	rjson.load(filePath,1);
        Book book = new Book(rjson.getInput_title(), rjson.getInput_author(), rjson.getInput_ISBN(), rjson.getInput_genre(), rjson.getInput_publicationYear(), rjson.getInput_department(), true);
        assertEquals(rjson.getInput_title(), book.getTitle());
        assertEquals(rjson.getInput_author(), book.getAuthor());
        assertEquals( rjson.getInput_ISBN(), book.getISBN());
        assertEquals(rjson.getInput_genre(), book.getGenre());
        assertEquals(rjson.getInput_publicationYear(), book.getPublicationYear());
        assertEquals(rjson.getInput_department(), book.getDepartment());
        assertTrue(book.isAvailability());
        book.setAvailability(false);
        assertFalse(book.isAvailability());
    }
}

