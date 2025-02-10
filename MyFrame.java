import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;

public class MyFrame extends JFrame{
    private static final long serialVersionUID = 1L;
    JButton addLineButton1, addLineButton2, closeFrameButton;
    JPanel buttonPanel;
    JTextArea textArea;
    JScrollPane textScrollPane;
    JMenuBar menuBar;
    JMenu dropDownMenu;
    JToolBar toolBar;

    class AddText1 extends AbstractAction {
        public AddText1() {super("Add Hello world");}
        public void actionPerformed(ActionEvent e) {
            textArea.append("Hello world !\n");
        }
    }

    class AddText2 extends AbstractAction {
        public AddText2() {super("Add Goodbye world");}
        public void actionPerformed(ActionEvent e) {
            textArea.append("Goodbye world !\n");
        }
    }

    class CloseAction extends AbstractAction {
        public CloseAction() {super("Exit");}

        public void actionPerformed(ActionEvent e) {
            System.exit(0);;
        }
    }

    public static void main(String argv[]) {
        new MyFrame();
    }

    public MyFrame() {
        addLineButton1 = new JButton(new AddText1());
        addLineButton2 = new JButton(new AddText2());
        closeFrameButton = new JButton(new CloseAction());
        buttonPanel = new JPanel();
        textArea = new JTextArea();
        textScrollPane = new JScrollPane(textArea);
        dropDownMenu=new JMenu("Menu");
        toolBar = new JToolBar();
        menuBar = new JMenuBar();

        JMenuItem addLine1MI = new JMenuItem(new AddText1());
        JMenuItem addLine2MI = new JMenuItem(new AddText2());
        JMenuItem closeMI = new JMenuItem(new CloseAction());

        // add menu bar and drop down menu
        dropDownMenu.add(addLine1MI);
        dropDownMenu.add(addLine2MI);
        dropDownMenu.add(closeMI);
        menuBar.add(dropDownMenu);

        //add buttons to tool bar
        toolBar.add(new JButton(new AddText1()));
        toolBar.add(new JButton(new AddText2()));
        toolBar.add(new JButton(new CloseAction()));


        //add buttons to south panel
        buttonPanel.add(addLineButton1);
        buttonPanel.add(addLineButton2);
        buttonPanel.add(closeFrameButton);

        //add elements to the frame
        add(buttonPanel, BorderLayout.SOUTH);
        add(textScrollPane, BorderLayout.CENTER);
        add(toolBar, BorderLayout.NORTH);
        setJMenuBar(menuBar);


        //add action to south buttons
        // addLineButton1.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         textArea.append("Line added by button 1.\n");
        //     }
        // });
        // addLineButton2.addActionListener((e)->textArea.append("Line added by button 2.\n"));
        // closeFrameButton.addActionListener(e->System.exit(0));



        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();//compute positions
        setVisible(true);//show on screen
    }
}