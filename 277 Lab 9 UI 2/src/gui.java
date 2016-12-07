import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class gui extends JFrame {
	//Enum of Colors
	public enum NamedColor {
		RED(Color.red),
		BLUE(Color.blue),
	    YELLOW(Color.yellow),
		GREEN(Color.green),
		BLACK(Color.BLACK),
		PINK(Color.pink),
		ORANGE(Color.orange);
	    private final Color awtColor;

	    private NamedColor(Color awtColor) {
	        this.awtColor = awtColor;
	    }

	    public Color getAwtColor() {
	        return awtColor;
	    }
	}


	// Declare check boxes
	private JCheckBox jchkCentered, jchkBold, jchkItalic;

	// Declare a combo box to hold font names
	private JComboBox jcboFontName = new JComboBox();

	// Declare a combo box to hold font sizes
	private JComboBox jcboFontSize = new JComboBox();
	
	private JComboBox jcboFontColor = new JComboBox();

	// Font name
	private String fontName = "SansSerif";

	// Font style
	private int fontStyle = Font.PLAIN;

	//Font Color
	private NamedColor fontColor = NamedColor.BLACK;
	
	// Font Size
	private int fontSize = 12;


	// Declare a panel for displaying message
	private MessagePanel messagePanel = new MessagePanel("Java is Cool");

	/** Main method */
	public static void main(String[] args) {
		JFrame frame = new gui();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setVisible(true);
	}

	/** Default constructor */
	public gui() {
		setTitle("Message Center");

		// Set the background color of messagePanel
		messagePanel.setBackground(Color.yellow);
		// Find all available font names
		GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fontnames = e.getAvailableFontFamilyNames();
		for (int i = 0; i < fontnames.length; i++)
			jcboFontName.addItem(fontnames[i]);
		jcboFontName.setSelectedItem("" + fontName);

		// Add font sizes into jcboFontSize
		for (int i = 1; i <= 100; i++)
			jcboFontSize.addItem("" + i);
		jcboFontSize.setSelectedItem("" + fontSize);

		NamedColor colors[] = NamedColor.values();
		for(int i = 0; i < colors.length; i++) {
			jcboFontColor.addItem(" " + colors[i]);
		}
		jcboFontColor.setSelectedItem("" + fontColor);
		
		// Hold font name label and combo box
		JPanel p1 = new JPanel(new BorderLayout(10, 10));
		p1.add(new JLabel("Font Name"), BorderLayout.WEST);
		p1.add(jcboFontName, BorderLayout.CENTER);

		// Hold font size label and combo box
		JPanel p2 = new JPanel(new BorderLayout(10, 10));
		p2.add(new JLabel("Font Size"), BorderLayout.WEST);
		p2.add(jcboFontSize, BorderLayout.CENTER);
		
		
		JPanel colorP = new JPanel(new BorderLayout(10, 10));
		colorP.add(new JLabel("Font Color"), BorderLayout.WEST);
		colorP.add(jcboFontColor, BorderLayout.CENTER);

		// Add p1 and p2 into p3
		JPanel p3 = new JPanel(new BorderLayout(10, 10));
		p3.setBorder(new EmptyBorder(10, 10, 10, 10));
		p3.add(p1, BorderLayout.WEST);
		p3.add(colorP, BorderLayout.CENTER);
		p3.add(p2, BorderLayout.EAST);

		// Put three check boxes in panel p
		JPanel p = new JPanel();
		p.add(jchkCentered = new JCheckBox("Centered"));
		p.add(jchkBold = new JCheckBox("Bold"));
		p.add(jchkItalic = new JCheckBox("Italic"));

		// Set keyboard mnemonics
		jchkCentered.setMnemonic('C');
		jchkBold.setMnemonic('B');
		jchkItalic.setMnemonic('I');

		// Place messagePanel, p3, and p in the frame
		setLayout(new BorderLayout());
		add(messagePanel, BorderLayout.CENTER);
		add(p3, BorderLayout.NORTH);
		add(p, BorderLayout.SOUTH);

		// Register listeners on jcboFontName and jcboFontSize
		jcboFontName.addItemListener(new Listener());
		jcboFontSize.addItemListener(new Listener());
		jcboFontColor.addItemListener(new Listener());

		// Register listeners on jchkCentered, jchkBold, and jchkItalic
		jchkCentered.addItemListener(new Listener());
		jchkBold.addItemListener(new Listener());
		jchkItalic.addItemListener(new Listener());
	}

	class Listener implements ItemListener {
		/** Handle check box selection */
		public void itemStateChanged(ItemEvent e) {
			if (e.getSource() == jcboFontName) {
				fontName = (String) (jcboFontName.getSelectedItem());
	
				// Set font for the message
				messagePanel.setFont(new Font(fontName, fontStyle, fontSize));
			} else if(e.getSource() == jcboFontColor) {
				
				fontColor = NamedColor.values()[jcboFontColor.getSelectedIndex()];
				//Set the color for the message
				messagePanel.setForeground(fontColor.getAwtColor());

				
			} else if (e.getSource() == jcboFontSize) {
				fontSize = Integer.parseInt((String) (jcboFontSize.getSelectedItem()));

				// Set font for the message
				messagePanel.setFont(new Font(fontName, fontStyle, fontSize));
			} else if ((e.getSource() == jchkBold) || (e.getSource() == jchkItalic)) {
				fontStyle = Font.PLAIN;

				// Determine a font style
				if (jchkBold.isSelected())
					fontStyle = fontStyle + Font.BOLD;
				if (jchkItalic.isSelected())
					fontStyle = fontStyle + Font.ITALIC;

				// Set font for the message
				messagePanel.setFont(new Font(fontName, fontStyle, fontSize));
			} else if (e.getSource() == jchkCentered) {
				if (jchkCentered.isSelected())
					messagePanel.setCentered(true);
				else
					messagePanel.setCentered(false);
			} 
		}
	}
}