import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public abstract class UserScreen extends GUI {
    /*
    protected JPanel mainPanel;
    protected JPanel leftPanel;
    protected JPanel topPanel;

    public JPanel getSubmitPass() {
        return submitPass;
    }

    public void setSubmitPass(JPanel submitPass) {
        this.submitPass = submitPass;
    }

    protected JPanel submitPass;
    protected User user;
    protected Admin admin;


    public UserScreen(User user) {
        super();
        this.user = user;

        int screenWidth = return_screenSize().width;
        int screenHeight = return_screenSize().height;

        leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(300, screenHeight - 50));
        leftPanel.setBackground(Color.decode("#8AA29E"));
        leftPanel.setLayout(null);
        frame.add(leftPanel, BorderLayout.WEST);


        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(screenWidth, 58));
        topPanel.setBackground(Color.decode("#8AA29E"));
        frame.add(topPanel, BorderLayout.NORTH);


        mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#E3F2FD"));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        mainPanel.setLayout(null);

        frame.add(mainPanel, BorderLayout.CENTER);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        add_profile_image();
        add_labels();
        exit_button();
        logout_button();
        account_details_button();
    }

    public UserScreen(User userX) {
        super();
        this.userX = userX;

        int screenWidth = return_screenSize().width;
        int screenHeight = return_screenSize().height;

        leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(300, screenHeight - 50));
        leftPanel.setBackground(Color.decode("#8AA29E"));
        leftPanel.setLayout(null);
        frame.add(leftPanel, BorderLayout.WEST);


        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(screenWidth, 58));
        topPanel.setBackground(Color.decode("#8AA29E"));
        frame.add(topPanel, BorderLayout.NORTH);


        mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#E3F2FD"));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        mainPanel.setLayout(null);

        frame.add(mainPanel, BorderLayout.CENTER);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        add_labels();
        exit_button();
        logout_button();
    }

    public UserScreen(Admin admin) {
        super();
        this.admin = admin;

        int screenWidth = return_screenSize().width;
        int screenHeight = return_screenSize().height;

        leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(300, screenHeight - 50));
        leftPanel.setBackground(Color.decode("#8AA29E"));
        leftPanel.setLayout(null);
        frame.add(leftPanel, BorderLayout.WEST);


        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(screenWidth, 58));
        topPanel.setBackground(Color.decode("#8AA29E"));
        frame.add(topPanel, BorderLayout.NORTH);


        mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#E3F2FD"));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        mainPanel.setLayout(null);

        frame.add(mainPanel, BorderLayout.CENTER);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        add_labels();
        exit_button();
        logout_button();
    }

    protected void add_profile_image() {
        ImageIcon image = new ImageIcon("SolarApplication/images/profile.png");
        JLabel imageLabel = new JLabel();
        imageLabel.setIcon(image);

        imageLabel.setOpaque(true);
        imageLabel.setBackground(Color.GRAY);


        if (image.getIconWidth() == -1) {
            imageLabel.setText("Image not found");
            imageLabel.setHorizontalAlignment(JLabel.CENTER);
            imageLabel.setVerticalAlignment(JLabel.CENTER);
        }


        imageLabel.setBounds(25, 1, 250, 250);
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        leftPanel.add(imageLabel);
        leftPanel.revalidate();
        leftPanel.repaint();
    }


    protected void add_labels() {
        outputLabel = new JLabel("USER SCREEN");
        outputLabel.setBounds(10, 20, 150, 25);
        outputLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        mainPanel.add(outputLabel);

        memoryLabel = new JLabel("development test only");
        memoryLabel.setBounds(10, 40, 150, 25);
        memoryLabel.setForeground(Color.BLUE);
        mainPanel.add(memoryLabel);
    }

    protected void exit_button() {
        JButton exitB = new JButton("exit");
        exitB.setBounds(25, 700, 80, 30);
        exitB.setFont(new Font("Arial", Font.PLAIN, 16));
        exitB.setOpaque(true);
        exitB.setBackground(Color.decode("#D44646"));
        exitB.setForeground(Color.decode("#FFFFFF"));
        exitB.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // 1-point border
        leftPanel.add(exitB);

        exitB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });
    }

    protected void logout_button() {
        JButton logOut = new JButton("Log Out");
        logOut.setBounds(25, 630, 250, 50);
        logOut.setFont(new Font("Inter", Font.PLAIN, 20));
        logOut.setOpaque(true);
        logOut.setBackground(Color.decode("#D44646"));
        logOut.setForeground(Color.decode("#FFFFFF"));
        logOut.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        leftPanel.add(logOut);

        logOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                try {
                    Main.main(new String[]{}); // Replace MainClass with the name of your main application class
                } catch (Exception ex) {
                    ex.printStackTrace(); // Handle potential exceptions during restart
                }

            }

        });
    }

    protected void account_details_button() {
        JButton accountDetails = new JButton("Account Details");
        accountDetails.setBounds(25, 350, 250, 50);
        accountDetails.setFont(new Font("Inter", Font.PLAIN, 20));
        accountDetails.setOpaque(true);
        accountDetails.setBackground(Color.decode("#686963"));
        accountDetails.setForeground(Color.decode("#FFFFFF"));
        accountDetails.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // 1-point border
        leftPanel.add(accountDetails);

        accountDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view_account_details(user);
            }

        });
    }

    protected void view_account_details(UserInfo user) {
        JFrame account_details_frame = new JFrame(user.getFirstname() + " " + user.getSurname() + "'s Account Details");
        account_details_frame.setSize(400, 550);
        account_details_frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        account_details_frame.setVisible(true);
        account_details_frame.setResizable(false);

        JPanel curr_panel = new JPanel();
        curr_panel.setLayout(null);
        account_details_frame.add(curr_panel);
        curr_panel.setBackground(Color.decode("#8AA29E"));

        outputLabel = new JLabel(user.getFirstname() + " " + user.getSurname() + "'s Details");
        outputLabel.setBounds(20, 10, 380, 100);
        outputLabel.setFont(new Font("Arial", Font.BOLD, 20));
        curr_panel.add(outputLabel);

        outputLabel = new JLabel("Firstname: " + user.getFirstname());
        outputLabel.setBounds(45, 80, 300, 100);
        outputLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        curr_panel.add(outputLabel);

        outputLabel = new JLabel("Surname: " + user.getSurname());
        outputLabel.setBounds(45, 115, 300, 100);
        outputLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        curr_panel.add(outputLabel);

        outputLabel = new JLabel("ID/username: " + user.getUserId());
        outputLabel.setBounds(45, 150, 300, 100);
        outputLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        curr_panel.add(outputLabel);

        outputLabel = new JLabel("email: " + user.getEmail());
        outputLabel.setBounds(45, 185, 300, 100);
        outputLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        curr_panel.add(outputLabel);

        JButton changePasswordButton = new JButton("Change Password");
        changePasswordButton.setBounds(100, 340, 200, 50);
        changePasswordButton.setFont(new Font("Inter", Font.PLAIN, 18));
        changePasswordButton.setOpaque(true);
        changePasswordButton.setBackground(Color.decode("#686963"));
        changePasswordButton.setForeground(Color.decode("#FFFFFF"));
        changePasswordButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        curr_panel.add(changePasswordButton);

        JButton closeButton = new JButton("Close");
        closeButton.setBounds(100, 425, 200, 50);
        closeButton.setFont(new Font("Inter", Font.PLAIN, 18));
        closeButton.setOpaque(true);
        closeButton.setBackground(Color.decode("#686963"));
        closeButton.setForeground(Color.decode("#FFFFFF"));
        closeButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        curr_panel.add(closeButton);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                account_details_frame.dispose();
            }
        });

        // Add action listener for the change password button
        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openChangePasswordDialog();
            }
        });
    }

    private void openChangePasswordDialog() {
        JFrame changePasswordFrame = new JFrame("Change Password");
        changePasswordFrame.setSize(300, 500);
        changePasswordFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        changePasswordFrame.setVisible(true);
        changePasswordFrame.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        changePasswordFrame.add(panel);
        panel.setBackground(Color.decode("#8AA29E"));

        JLabel newPasswordLabel = new JLabel("New Password:");
        newPasswordLabel.setBounds(20, 10, 380, 100);
        newPasswordLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(newPasswordLabel);

        JPasswordField newPasswordField = new JPasswordField();
        newPasswordField.setBounds(20, 100, 240, 25);
        panel.add(newPasswordField);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(20, 150, 380, 100);
        confirmPasswordLabel.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(confirmPasswordLabel);

        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(20, 240, 240, 25);
        panel.add(confirmPasswordField);

        JButton submitPass = new JButton("Submit Password");
        submitPass.setBounds(30, 340, 200, 50);
        submitPass.setFont(new Font("Inter", Font.PLAIN, 18));
        submitPass.setOpaque(true);
        submitPass.setBackground(Color.decode("#29c240"));
        submitPass.setForeground(Color.decode("#FFFFFF"));
        submitPass.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel.add(submitPass);
    }

     */
}