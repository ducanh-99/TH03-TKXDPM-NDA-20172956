package media.admin;

import java.util.List;
import java.util.Map;



import com.oms.bean.Media;

import api.MediaApi;
import media.search.BookSearchPane;
import media.search.MediaSearchPane;
import media.singlepane.BookSinglePane;
import media.singlepane.MediaSinglePane;

public class AdminBookPageController extends AdminMediaPageController {

	public AdminBookPageController() {
		super();
	}


	@Override
	public List<? extends Media> search(Map<String, String> searchParams) {
		return new MediaApi().getBooks(searchParams);
	}

	@Override
	public MediaSinglePane createSinglePane() {
		return new BookSinglePane();
	}

	@Override
	public MediaSearchPane createSearchPane() {
		return new BookSearchPane();
	}
}
