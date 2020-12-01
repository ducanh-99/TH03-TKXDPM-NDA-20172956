package main;

import javax.swing.JPanel;

import media.admin.AdminBookPageController;

public class OMSAdminController {



	public JPanel getBookPage() {
		AdminBookPageController controller = new AdminBookPageController();
		return controller.getDataPagePane();
	}

}
