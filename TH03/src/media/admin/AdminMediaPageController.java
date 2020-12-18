package media.admin;

import com.oms.bean.Media;

import abstractdata.ADataListPane;
import abstractdata.ADataPageController;

public abstract class AdminMediaPageController extends ADataPageController<Media> {
	
	
	public AdminMediaPageController() {
		super();
	}
	
	@Override
	public ADataListPane<Media> createListPane(){
		return new AdminMediaListPane(this);
	}
}
