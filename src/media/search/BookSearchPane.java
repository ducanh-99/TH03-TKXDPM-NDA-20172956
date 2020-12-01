package media.search;

import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class BookSearchPane extends PhysicalMediaSearchPane {
	private JTextField publisherField;
	private JTextField languageField;

	public BookSearchPane() {
		super();
	}

	@Override
	public void buildControls() {
		super.buildControls();
		
		JLabel publisherLabel = new JLabel("Publisher");
		publisherField = new JTextField(15);
		int row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		add(publisherLabel, c);
		c.gridx = 1;
		c.gridy = row;
		add(publisherField, c);

		JLabel languageLabel = new JLabel("Language");
		languageField = new JTextField(15);
		row = getLastRowIndex();
		c.gridx = 0;
		c.gridy = row;
		add(languageLabel, c);
		c.gridx = 1;
		c.gridy = row;
		add(languageField, c);
	}
}
