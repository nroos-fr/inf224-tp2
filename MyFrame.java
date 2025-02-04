import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;

public class MyFrame extends JFrame{
    private static final long serialVersionUID = 1L;
    JButton addLineButton1, addLineButton2, closeFrameButton;
    JPanel buttonPanel;
    JTextArea textArea;
    JScrollPane textScrollPane;

    public static void main(String argv[]) {
        new MyFrame();
    }

    public MyFrame() {
        addLineButton1 = new JButton("Add line of text");
        addLineButton2 = new JButton("Add another line of text");
        closeFrameButton = new JButton("Exit");
        buttonPanel = new JPanel();
        textArea = new JTextArea();
        textScrollPane = new JScrollPane(textArea);

        buttonPanel.add(addLineButton1);
        buttonPanel.add(addLineButton2);
        buttonPanel.add(closeFrameButton);

        add(buttonPanel, BorderLayout.SOUTH);
        add(textScrollPane, BorderLayout.CENTER);



        addLineButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.append("Line added by button 1.\n");
            }
        });

        addLineButton2.addActionListener((e)->textArea.append("Line added by button 2.\n"));
        closeFrameButton.addActionListener(e->System.exit(0));


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();//compute positions
        setVisible(true);//show on screen
    }
}