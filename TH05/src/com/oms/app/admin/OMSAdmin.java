package com.oms.app.admin;

import java.awt.BorderLayout;
import java.lang.reflect.InvocationTargetException;

import javax.swing.*;

import com.oms.components.media.book.controller.AdminBookPageController;
import com.oms.factory.AdminPageFactory;

@SuppressWarnings("serial")
public class OMSAdmin extends JFrame {
	static {
		AdminPageFactory.getInstance().registerProduct("book", AdminBookPageController.class);
//		AdminPageFactory.getInstance().registerProduct("cd", AdminCdPageController.class);
//		AdminPageFactory.getInstance().registerProduct("dvds", AdminDvdPageController.class);
	}

	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 550;

	public OMSAdmin(OMSAdminController controller) throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		JPanel rootPanel = new JPanel();
		setContentPane(rootPanel);

		BorderLayout layout = new BorderLayout();
		rootPanel.setLayout(layout);

		JTabbedPane tabbedPane = new JTabbedPane();
		rootPanel.add(tabbedPane, BorderLayout.CENTER);

		JPanel bookPage = AdminPageFactory.getInstance().createProduct("book");
//		JPanel bookPage = controller.getBookPage();
		tabbedPane.addTab("Books", null, bookPage, "Books");

		
		tabbedPane.addTab("Compact Discs", null, new JPanel(), "Compact Discs");
		
		tabbedPane.addTab("Digital Video Discs", null, new JPanel(), "Digital Video Discs");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Online Media System for Administrator");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setVisible(true);
	}

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					new OMSAdmin(new OMSAdminController());
				} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
						| IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
}