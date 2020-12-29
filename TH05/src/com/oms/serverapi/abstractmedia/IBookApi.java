package com.oms.serverapi.abstractmedia;

import java.util.ArrayList;
import java.util.Map;

import com.oms.bean.Book;
import com.oms.bean.Media;

public interface IBookApi {
	public ArrayList<Media> getAllMedias();

	public ArrayList<Book> getBooks(Map<String, String> queryParams);

	public Book updateBook(Book book);
}
