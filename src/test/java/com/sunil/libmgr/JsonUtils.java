package com.sunil.libmgr;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonUtils {
    public static List<Book> readBooksFromJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        BooksWrapper wrapper = objectMapper.readValue(new File(filePath), BooksWrapper.class);
        return wrapper.getBooks();
    }

    private static class BooksWrapper {
        private List<Book> books;

        public List<Book> getBooks() {
            return books;
        }

        public void setBooks(List<Book> books) {
            this.books = books;
        }
    }
}
