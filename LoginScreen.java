import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import javax.swing.border.LineBorder;


public class LoginScreen extends GUI {
    JPanel foregroundP, backgroundP,logoPanel;
    String username, password;
    protected JPanel centralPanel, backgroundPanel;
    private JTextField usernameField, IDresetField;
    private JPasswordField passwordField;
    private JButton signInButton, forgotButton, clearButton, signUpButton, submitResetButton;
    private JLabel label, label2, enterIDlabel, enterPasswordLabel, errorMessage;
    public LoginScreen(){
        super();
        System.out.println("LOGIN SCREEN CREATED");
        int screenWidth = return_screenSize().width;
        int screenHeight = frame.getContentPane().getHeight();

        foregroundP = new JPanel();
        foregroundP.setBackground(Color.decode("#E3F2FD"));
        foregroundP.setLayout(null);
        int Pwidth = screenWidth - 1000;
        int Pheight = screenHeight - 75;
        foregroundP.setBounds((screenWidth / 2) - (Pwidth / 2), (screenHeight / 2) - (Pheight / 2), Pwidth, Pheight);

        backgroundP = new JPanel();
        backgroundP.setBackground(Color.decode("#BCCCDC"));
        backgroundP.setLayout(null);
        backgroundP.setBounds(1, 1, screenWidth, screenHeight);

        frame.add(foregroundP);
        frame.add(backgroundP);
        frame.setLayout(null);
        add_labels();
        add_buttons();

        foregroundP.revalidate();
        foregroundP.repaint();

        JLabel label = new JLabel("");
        label.setBounds(50, 160, 300, 50);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setForeground(Color.decode("#D85461"));

        JLabel label2 = new JLabel("");
        label2.setBounds(50, 260, 300, 50);
        label2.setFont(new Font("Arial", Font.BOLD, 18));
        label2.setForeground(Color.decode("#D85461"));
    }

    private void clear_labels(){

        if (label != null) {
            if (!Objects.equals(label.getText(), "")) {
                foregroundP.remove(label);
            }
        }

        if (label2 != null) {
            if (!Objects.equals(label2.getText(), "")) {
                foregroundP.remove(label2);
            }
        }

        foregroundP.revalidate();
        foregroundP.repaint();
    }


    private void add_labels() {

        Font font = new Font("Segoe UI Light", Font.PLAIN, 60);
        JLabel label = new JLabel("RotaPro");
        label.setFont(font);
        label.setForeground(Color.decode("#686963"));
        FontMetrics metrics = label.getFontMetrics(font);
        int textHeight = metrics.getHeight();
        int textWidth = metrics.stringWidth(label.getText());
        label.setBounds((foregroundP.getWidth() / 2) - (textWidth / 2),1,300,60);
        foregroundP.add(label);


        font = new Font("Arial", Font.PLAIN, 45);
        label = new JLabel("Sign In");
        label.setFont(font);
        label.setForeground(Color.decode("#686963"));
        metrics = label.getFontMetrics(font);
        textWidth = metrics.stringWidth(label.getText());
        label.setBounds((foregroundP.getWidth() / 2) - (textWidth / 2),textHeight + 10,300,50);
        foregroundP.add(label);

        int fieldWidth = foregroundP.getWidth() - 100;
        enterIDlabel = new JLabel("Username");
        enterIDlabel.setForeground(Color.decode("#686963"));
        enterIDlabel.setBounds((foregroundP.getWidth() / 2) - (fieldWidth / 2), 200, 300, 30);
        enterIDlabel.setFont(new Font("Arial", Font.PLAIN, 22));
        foregroundP.add(enterIDlabel);

        usernameField = new JTextField("Enter your username");
        usernameField.setFont(new Font("Arial", Font.PLAIN, 18));
        usernameField.setForeground(Color.decode("#686963"));
        usernameField.setBackground(Color.WHITE);
        usernameField.setBounds((foregroundP.getWidth() / 2) - (fieldWidth / 2), 230, fieldWidth, 60);
        foregroundP.add(usernameField);

        Border defaultBorder = new LineBorder(Color.LIGHT_GRAY, 2);
        Border hoverBorder = new LineBorder(Color.decode("#6089B1"), 2);

        usernameField.setBorder(defaultBorder);

        usernameField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                usernameField.setBorder(hoverBorder);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                usernameField.setBorder(defaultBorder);
            }
        });




        enterPasswordLabel = new JLabel("Password");
        enterPasswordLabel.setForeground(Color.decode("#686963"));
        enterPasswordLabel.setBounds((foregroundP.getWidth() / 2) - (fieldWidth / 2), 310, 240, 30);
        enterPasswordLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        foregroundP.add(enterPasswordLabel);





        passwordField = new JPasswordField("");
        passwordField.setFont(new Font("Arial", Font.PLAIN, 18));
        passwordField.setBounds((foregroundP.getWidth() / 2) - (fieldWidth / 2), 340, fieldWidth, 60);
        passwordField.setForeground(Color.GRAY);
        foregroundP.add(passwordField);

        passwordField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                passwordField.setBorder(hoverBorder);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                passwordField.setBorder(defaultBorder);
            }
        });



    }

    private void add_buttons(){
        int fieldWidth = foregroundP.getWidth() - 100;
        signInButton = new JButton("Sign In");
        signInButton.setBounds((foregroundP.getWidth() / 2) - (fieldWidth / 2), 450, fieldWidth,60);
        signInButton.setFont(new Font("Inter", Font.PLAIN, 25));
        signInButton.setOpaque(true);
        signInButton.setBackground(Color.decode("#9AA6B2"));
        signInButton.setForeground(Color.decode("#FFFFFF"));
        foregroundP.add(signInButton);
        signInButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                signInButton.setBackground(Color.decode("#79838C"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                signInButton.setBackground(Color.decode("#9AA6B2"));            }
        });

        int forgotWidth = 240;
        forgotButton = new JButton("Forgot Password?");
        forgotButton.setBounds((foregroundP.getWidth() / 2) - (forgotWidth / 2), 540, forgotWidth,40);
        forgotButton.setFont(new Font("Inter", Font.PLAIN, 15));
        forgotButton.setOpaque(true);
        forgotButton.setBackground(Color.decode("#D85461"));
        forgotButton.setForeground(Color.decode("#FFFFFF"));
        foregroundP.add(forgotButton);

        forgotButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                forgotButton.setBackground(Color.decode("#C42131"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                forgotButton.setBackground(Color.decode("#D85461"));            }
        });

        signUpButton = new JButton("New? Sign Your Company Up!");
        signUpButton.setBounds(10, foregroundP.getHeight() - 40, 230,30);
        signUpButton.setFont(new Font("Inter", Font.BOLD, 12));
        signUpButton.setOpaque(true);
        signUpButton.setBackground(Color.decode("#3351DA"));
        signUpButton.setForeground(Color.decode("#FFFFFF"));
        foregroundP.add(signUpButton);

        signUpButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                signUpButton.setBackground(Color.decode("#213695"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                signUpButton.setBackground(Color.decode("#3351DA"));            }
        });

    }

    public JButton getClearButton() {
        return clearButton;
    }

    public void setClearButton(JButton clearButton) {
        this.clearButton = clearButton;
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }

    public void setSignUpButton(JButton signUpButton) {
        this.signUpButton = signUpButton;
    }

    public JButton getLoginButton() {
        return signInButton;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public void setUsernameField(JTextField usernameField) {
        this.usernameField = usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JButton getSignInButton() {
        return signInButton;
    }

    public void setSignInButton(JButton signInButton) {
        this.signInButton = signInButton;
    }

    public JButton getForgotButton() {
        return forgotButton;
    }

    public void setForgotButton(JButton forgotButton) {
        this.forgotButton = forgotButton;
    }


    public JFrame getFrame() {
        return frame; // Method to return the JFrame
    }

    public void printInvalidUsername() {
        clear_labels();
        enterIDlabel.setText("Please enter a valid username");
        enterIDlabel.setForeground(Color.RED);
        enterIDlabel.setFont(new Font("Arial", Font.BOLD, 18));

        enterPasswordLabel.setText("Enter your password");
        enterPasswordLabel.setForeground(Color.decode("#FFFFFF"));

        foregroundP.revalidate();
        foregroundP.repaint();

    }

    public void printInvalidPassword() {
        clear_labels();
        enterIDlabel.setText("Enter Used ID");
        enterIDlabel.setForeground(Color.decode("#FFFFFF"));

        enterPasswordLabel.setText("Your password is incorrect");
        enterPasswordLabel.setFont(new Font("Arial", Font.BOLD, 18));
        enterPasswordLabel.setForeground(Color.RED);
        foregroundP.revalidate();
        foregroundP.repaint();

    }

    public void reset_password_screen(){
        JFrame amend_frame = new JFrame("Reset Password");
        int y = 0;
        amend_frame.setSize(320, 400);
        amend_frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        amend_frame.setVisible(true);
        amend_frame.setResizable(false);

        JPanel curr_panel = new JPanel();
        curr_panel.setLayout(null);
        amend_frame.add(curr_panel);
        curr_panel.setBackground(Color.decode("#686963"));

        JLabel outputLabel = new JLabel("Reset Your Password:");
        outputLabel.setBounds(50, 10, 300, 100);
        outputLabel.setForeground(Color.WHITE);

        outputLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        curr_panel.add(outputLabel);



        outputLabel = new JLabel("Enter Your ID:");
        outputLabel.setBounds(50, 75, 300, 100);
        outputLabel.setFont(new Font("Inter", Font.PLAIN, 20));
        outputLabel.setForeground(Color.WHITE);
        curr_panel.add(outputLabel);

        IDresetField = new JTextField("");
        IDresetField.setForeground(Color.GRAY);
        curr_panel.add(IDresetField);
        IDresetField.setBounds(10, 150, 280, 40);

        errorMessage = new JLabel("");
        errorMessage.setBounds(50, 160, 300, 100);
        errorMessage.setFont(new Font("Inter", Font.PLAIN, 20));
        errorMessage.setForeground(Color.RED);
        curr_panel.add(errorMessage);

        submitResetButton = new JButton("Reset Password");
        submitResetButton.setBounds(10, 250, 280, 50);
        submitResetButton.setFont(new Font("Inter", Font.PLAIN, 20));
        submitResetButton.setOpaque(true);
        submitResetButton.setBackground(Color.decode("#8AA29E"));
        submitResetButton.setForeground(Color.decode("#ffffff"));
        submitResetButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        curr_panel.add(submitResetButton);

        JButton closeButton = new JButton("close");
        closeButton.setBounds(10, 310, 280, 50);
        closeButton.setFont(new Font("Inter", Font.PLAIN, 20));
        closeButton.setOpaque(true);
        closeButton.setBackground(Color.decode("#D85461"));
        closeButton.setForeground(Color.decode("#ffffff"));
        closeButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        curr_panel.add(closeButton);


        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amend_frame.dispose();
            }
        });
    }
    public void clear_fields() {
        usernameField.setText("");
        passwordField.setText("");
    }

    public void close(){
        frame.dispose();
    }


    public JButton getSubmitResetButton() {
        return submitResetButton;
    }

    public void setSubmitResetButton(JButton submitResetButton) {
        this.submitResetButton = submitResetButton;
    }

    public JTextField getIDresetField() {
        return IDresetField;
    }

    public JLabel getErrorMessage() {
        return errorMessage;
    }

    public void updateErrorMessage(String message) {
        errorMessage.setText(message);    }

    public void setErrorMessage(JLabel errorMessage) {
        this.errorMessage = errorMessage;
    }
}



