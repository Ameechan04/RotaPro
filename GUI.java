import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI {
    protected JLabel outputLabel, memoryLabel;
    protected JFrame frame;

    protected Dimension return_screenSize() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    private void create_screen(){
        frame = new JFrame();
        frame.setLayout(new BorderLayout());

        int screenWidth = return_screenSize().width;
        int screenHeight = return_screenSize().height;

        frame.setSize(screenWidth, screenHeight - 50);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public GUI(){
        create_screen();
    }
}