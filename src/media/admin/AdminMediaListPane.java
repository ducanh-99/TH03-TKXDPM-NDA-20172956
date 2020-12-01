package media.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.oms.bean.Book;
import com.oms.bean.Media;

import abstractdata.ADataListPane;
import abstractdata.ADataPageController;
import abstractdata.ADataSinglePane;
import abstractdata.IDataManageController;
import api.MediaApi;
import editdialog.BookEditDialog;

@SuppressWarnings("serial")
public class AdminMediaListPane extends ADataListPane<Media> {
	public AdminMediaListPane(ADataPageController<Media> controller) {
		this.controller = controller;
	}

	@Override
	public void decorateSinglePane(ADataSinglePane<Media> singlePane) {
		JButton button = new JButton("Edit");
		singlePane.addDataHandlingComponent(button);
		
		button.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				if(controller instanceof AdminMediaPageController) {
					new BookEditDialog(singlePane.getData(), new IDataManageController<Media>() {
						
						@Override
						public void update(Media t) {
							if (t instanceof Book) {
								Book book = (Book) t;
								MediaApi mediaApi = new MediaApi();
								mediaApi.updateBook(book);
								singlePane.updateData(t);
							}
							
						}
						
						@Override
						public void read(Media t) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void delete(Media t) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void create(Media t) {
							// TODO Auto-generated method stub
							
						}
					});
				}
				
			}
		});
	}

}
