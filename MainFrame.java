import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.util.function.Function;
import java.util.function.Supplier;

public class MainFrame extends JFrame{
    private static final long serialVersionUID = 1L;

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


    public MainFrame(Function<String, String> searchCallback, Function<String, String> playCallback, Supplier<String> refreshMediaListCallback) {        
        mediaListPanel = new JPanel();
        refreshMediaList = new JButton("Refresh media list");
        mediaListArea = new JTextArea();
        mediaListArea.setText(refreshMediaListCallback.get());
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


        //add listeners on buttons
        
        searchButton.addActionListener( e -> {
            String name = searchField.getText();
            System.out.println(name);
            searchResult.setText(searchCallback.apply(name));
        });
        playButton.addActionListener( e -> {
            String name = playField.getText();
            System.out.println(name);
            playResult.setText(playCallback.apply(name));
        });
        refreshMediaList.addActionListener( e -> {
            mediaListArea.setText(refreshMediaListCallback.get());
        });

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