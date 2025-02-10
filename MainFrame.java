import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;

public class MainFrame extends JFrame{
    private static final long serialVersionUID = 1L;
    // JButton addLineButton1, addLineButton2, closeFrameButton;
    // JPanel buttonPanel;
    // JTextArea textArea;
    // JScrollPane textScrollPane;
    // JMenuBar menuBar;
    // JMenu dropDownMenu;
    // JToolBar toolBar;
    JPanel mediaListPanel;
    JButton refreshMediaList;
    JTextArea mediaListArea;
    JScrollPane mediaListScrollPane;
    JPanel searchAndPlayPanel;

    JPanel searchPanel;
    JPanel searchFieldButtonPanel; //contains the text field and the button to search an entity
    JTextField searchField;
    JButton searchButton;
    JTextArea searchResult;//text area to show the search results


    JPanel playPanel;
    JPanel playFieldButtonPanel;
    JTextField playField;
    JButton playButton;
    JTextArea playResult;


    // class AddText1 extends AbstractAction {
    //     public AddText1() {super("Add Hello world");}
    //     public void actionPerformed(ActionEvent e) {
    //         textArea.append("Hello world !\n");
    //     }
    // }

    // class AddText2 extends AbstractAction {
    //     public AddText2() {super("Add Goodbye world");}
    //     public void actionPerformed(ActionEvent e) {
    //         textArea.append("Goodbye world !\n");
    //     }
    // }

    // class CloseAction extends AbstractAction {
    //     public CloseAction() {super("Exit");}

    //     public void actionPerformed(ActionEvent e) {
    //         System.exit(0);;
    //     }
    // }

    public static void main(String argv[]) {
        new MainFrame();
    }

    public MainFrame() {
        // addLineButton1 = new JButton(new AddText1());
        // addLineButton2 = new JButton(new AddText2());
        // closeFrameButton = new JButton(new CloseAction());
        // buttonPanel = new JPanel();
        // textArea = new JTextArea();
        // textScrollPane = new JScrollPane(textArea);
        // dropDownMenu=new JMenu("Menu");
        // toolBar = new JToolBar();
        // menuBar = new JMenuBar();

        // JMenuItem addLine1MI = new JMenuItem(new AddText1());
        // JMenuItem addLine2MI = new JMenuItem(new AddText2());
        // JMenuItem closeMI = new JMenuItem(new CloseAction());

        // // add menu bar and drop down menu
        // dropDownMenu.add(addLine1MI);
        // dropDownMenu.add(addLine2MI);
        // dropDownMenu.add(closeMI);
        // menuBar.add(dropDownMenu);

        // //add buttons to tool bar
        // toolBar.add(new JButton(new AddText1()));
        // toolBar.add(new JButton(new AddText2()));
        // toolBar.add(new JButton(new CloseAction()));


        // //add buttons to south panel
        // buttonPanel.add(addLineButton1);
        // buttonPanel.add(addLineButton2);
        // buttonPanel.add(closeFrameButton);

        // //add elements to the frame
        // add(buttonPanel, BorderLayout.SOUTH);
        // add(textScrollPane, BorderLayout.CENTER);
        // add(toolBar, BorderLayout.NORTH);
        // setJMenuBar(menuBar);

        mediaListPanel = new JPanel();
        refreshMediaList = new JButton("Refresh media list");
        mediaListArea = new JTextArea();
        mediaListArea.setEditable(false);
        mediaListScrollPane = new JScrollPane(mediaListArea);

        searchAndPlayPanel = new JPanel();
        searchPanel = new JPanel();
        searchFieldButtonPanel = new JPanel();
        searchField = new JTextField();
        searchButton = new JButton("Search");
        searchResult = new JTextArea();
        searchResult.setEditable(false);
        playPanel = new JPanel();
        playFieldButtonPanel = new JPanel();
        playField = new JTextField();
        playButton = new JButton("Play");
        playResult = new JTextArea();
        playResult.setEditable(false);

        add(mediaListPanel, BorderLayout.WEST);
        mediaListPanel.setLayout(new BoxLayout(mediaListPanel, BoxLayout.Y_AXIS));
        mediaListPanel.add(refreshMediaList);
        mediaListPanel.add(mediaListScrollPane);

        add(searchAndPlayPanel, BorderLayout.CENTER);
        searchAndPlayPanel.setLayout(new BoxLayout(searchAndPlayPanel, BoxLayout.Y_AXIS));
        searchAndPlayPanel.add(searchPanel);
        searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.Y_AXIS));
        searchPanel.add(searchFieldButtonPanel);
        searchFieldButtonPanel.setLayout(new BoxLayout(searchFieldButtonPanel, BoxLayout.X_AXIS));
        searchFieldButtonPanel.add(searchField);
        searchFieldButtonPanel.add(searchButton);
        searchPanel.add(searchResult);

        searchAndPlayPanel.add(playPanel);
        playPanel.setLayout(new BoxLayout(playPanel, BoxLayout.Y_AXIS));
        playPanel.add(playFieldButtonPanel);
        playFieldButtonPanel.setLayout(new BoxLayout(playFieldButtonPanel, BoxLayout.X_AXIS));
        playFieldButtonPanel.add(playField);
        playFieldButtonPanel.add(playButton);
        playPanel.add(playResult);


        setTitle("Remote control");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();//compute positions
        setVisible(true);//show on screen
    }
}