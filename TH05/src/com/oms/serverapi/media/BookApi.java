package com.oms.serverapi.media;

import java.util.ArrayList;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.oms.bean.Book;
import com.oms.bean.Media;
import com.oms.serverapi.Connect;
import com.oms.serverapi.abstractmedia.IBookApi;

public class BookApi extends Connect implements IBookApi {
	private static BookApi instance;

	private BookApi() {
		super();
	}

	public static synchronized BookApi getInstance() {
		if (instance == null)
			instance = new BookApi();
		return instance;
	}

	@Override
	public ArrayList<Media> getAllMedias() {
		WebTarget webTarget = client.target(PATH).path("medias");

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();

		ArrayList<Media> res = response.readEntity(new GenericType<ArrayList<Media>>() {
		});
		System.out.println(res);
		return res;
	}

	public ArrayList<Book> getBooks(Map<String, String> queryParams) {
		WebTarget webTarget = client.target(PATH).path("books");

		if (queryParams != null) {
			for (String key : queryParams.keySet()) {
				String value = queryParams.get(key);
				webTarget = webTarget.queryParam(key, value);
			}
		}

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		ArrayList<Book> res = response.readEntity(new GenericType<ArrayList<Book>>() {
		});
		System.out.println(res);
		return res;
	}

	public Book updateBook(Book book) {
		WebTarget webTarget = client.target(PATH).path("books").path(book.getId());

		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.post(Entity.entity(book, MediaType.APPLICATION_JSON));

		Book res = response.readEntity(Book.class);
		return res;
	}

}
