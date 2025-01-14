import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;

public class StaffScreen extends UserScreen{
    private JLabel companyNameLabel;
    public int currentScreen;




    private JButton overviewB, accountDetailsB, viewAllShiftsB, sendMessageB;
            ;
    // Student st = new Student(10000, "password123", User.Role.STUDENT, "example@email.com", "001" , "Joe", "Bob");

    private ArrayList<Shift> shifts;
    Staff staff;
    public StaffScreen(Staff staff){
        super(staff);
        this.staff = staff;
        currentScreen = 0;
        add_labels(staff);
        add_buttons();
        setToOverview();
        colourSelectedScreenButton();
    }

    @Override
    protected void add_labels(Staff s) {
        outputLabel = new JLabel(s.getFirstname() + " " + s.getSurname());
        outputLabel.setBounds(30, 260, 300, 35);
        outputLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        outputLabel.setForeground(Color.white);
        leftPanel.add(outputLabel);


        outputLabel = new JLabel(s.getRole());
        outputLabel.setBounds(30,295,300,25);
        outputLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        outputLabel.setForeground(Color.white);
        leftPanel.add(outputLabel);

        outputLabel = new JLabel("User ID:" + s.getUserId());
        outputLabel.setBounds(30,325,300,25);
        outputLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        outputLabel.setForeground(Color.white);
        leftPanel.add(outputLabel);




        Font font = new Font("Arial", Font.PLAIN, 30);
        JLabel label = new JLabel(s.getCompanyName());
        label.setFont(font);
        label.setForeground(Color.decode("#FFFFFF"));
        FontMetrics metrics = label.getFontMetrics(font);
        int textWidth = metrics.stringWidth(label.getText());
        label.setBounds((topPanel.getWidth() / 2) - (textWidth / 2),1,300,60);
        topPanel.add(label);




    }

    @Override
    protected void add_labels(Company c) {

    }

    private void setToOverview() {
        mainPanel.setLayout(null);
        clearMainPanel();
        currentScreen = 0;
        colourSelectedScreenButton();

        LocalDate currentDate = LocalDate.now();
        JLabel outputLabel = new JLabel("Welcome " + staff.getFirstname() + "! Today is the " + currentDate + ".");
        outputLabel.setBounds(100, 20, 1200, 100);
        outputLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 35));
        outputLabel.setForeground(Color.decode("#686963"));
        mainPanel.add(outputLabel);

        String currentMonth = currentDate.getMonth().toString();

        outputLabel = new JLabel(currentMonth.charAt(0) + currentMonth.substring(1).toLowerCase() + " " + currentDate.getYear());
        outputLabel.setBounds(100, 70, 1200, 100);
        outputLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
        outputLabel.setForeground(Color.decode("#686963"));
        mainPanel.add(outputLabel);

        outputLabel = new JLabel("Current Hours: TBD");
        outputLabel.setBounds(275, 70, 1200, 100);
        outputLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
        outputLabel.setForeground(Color.decode("#686963"));
        mainPanel.add(outputLabel);

        outputLabel = new JLabel("Last Months Hours: TBD");
        outputLabel.setBounds(475, 70, 1200, 100);
        outputLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
        outputLabel.setForeground(Color.decode("#686963"));
        mainPanel.add(outputLabel);

        outputLabel = new JLabel("Notices");
        outputLabel.setBounds(900, 70, 1200, 100);
        outputLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
        outputLabel.setForeground(Color.decode("#686963"));
        mainPanel.add(outputLabel);

        JTextArea noticeBox = new JTextArea("No recent notices");
        noticeBox.setBounds(800, 150, 300, 375);
        noticeBox.setWrapStyleWord(true); // Word wrapping for multi-line text
        noticeBox.setLineWrap(true); // Enable line wrapping
        noticeBox.setFont(new Font("Arial", Font.PLAIN, 16));
        noticeBox.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Border around text box
        noticeBox.setEditable(false); //
        mainPanel.add(noticeBox);

        sendMessageB = new JButton("Send Message to Manager");
        sendMessageB.setBounds(800, 550, 300,50);
        sendMessageB.setFont(new Font("Inter", Font.PLAIN, 18));
        sendMessageB.setOpaque(true);
        sendMessageB.setBackground(Color.decode("#F29615"));
        sendMessageB.setForeground(Color.decode("#FFFFFF"));
        sendMessageB.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        mainPanel.add(sendMessageB);

        /* if (company.clockInSytem == True) {

         */

        JButton clockInB = new JButton("Clock In");
        clockInB.setBounds(25, 650, 175,50);
        clockInB.setFont(new Font("Inter", Font.PLAIN, 18));
        clockInB.setOpaque(true);
        clockInB.setBackground(Color.decode("#5DA832"));
        clockInB.setForeground(Color.decode("#FFFFFF"));
        clockInB.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        mainPanel.add(clockInB);

        JButton clockOutB = new JButton("Clock Out");
        clockOutB.setBounds(225, 650, 175,50);
        clockOutB.setFont(new Font("Inter", Font.PLAIN, 18));
        clockOutB.setOpaque(true);
        clockOutB.setBackground(Color.decode("#9AA6B2"));
        clockOutB.setForeground(Color.decode("#FFFFFF"));
        clockOutB.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        mainPanel.add(clockOutB);

        outputLabel = new JLabel("Current Shift: " + staff.getCurrentShift());
        outputLabel.setBounds(420, 625, 1200, 100);
        outputLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 20));
        outputLabel.setForeground(Color.decode("#686963"));
        mainPanel.add(outputLabel);

        JPanel square = new JPanel();
        square.setPreferredSize(new Dimension(25, 25));
        square.setBackground(Color.decode("#F29615"));
        square.setLayout(null);
        square.setBounds(25,610,25,25);
        mainPanel.add(square);

        square = new JPanel();
        square.setPreferredSize(new Dimension(25, 25));
        square.setBackground(Color.decode("#5DA832"));
        square.setLayout(null);
        square.setBounds(160,610,25,25);
        mainPanel.add(square);

        square = new JPanel();
        square.setPreferredSize(new Dimension(25, 25));
        square.setBackground(Color.decode("#D62828"));
        square.setLayout(null);
        square.setBounds(300,610,25,25);
        mainPanel.add(square);

        square = new JPanel();
        square.setPreferredSize(new Dimension(25, 25));
        square.setBackground(Color.decode("#8AA29E"));
        square.setLayout(null);
        square.setBounds(410,610,25,25);
        mainPanel.add(square);

        square = new JPanel();
        square.setPreferredSize(new Dimension(25, 25));
        square.setBackground(Color.decode("#686963"));
        square.setLayout(null);
        square.setBounds(520,610,25,25);
        mainPanel.add(square);

        outputLabel = new JLabel("Morning Shift");
        outputLabel.setBounds(55, 570, 800, 100);
        outputLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
        outputLabel.setForeground(Color.decode("#686963"));
        mainPanel.add(outputLabel);

        outputLabel = new JLabel("Evening Shift");
        outputLabel.setBounds(190, 570, 800, 100);
        outputLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
        outputLabel.setForeground(Color.decode("#686963"));
        mainPanel.add(outputLabel);

        outputLabel = new JLabel("Night Shift");
        outputLabel.setBounds(330, 570, 800, 100);
        outputLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
        outputLabel.setForeground(Color.decode("#686963"));
        mainPanel.add(outputLabel);

        outputLabel = new JLabel("Unreleased");
        outputLabel.setBounds(440, 570, 800, 100);
        outputLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
        outputLabel.setForeground(Color.decode("#686963"));
        mainPanel.add(outputLabel);

        outputLabel = new JLabel("Not Working");
        outputLabel.setBounds(550, 570, 800, 100);
        outputLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 16));
        outputLabel.setForeground(Color.decode("#686963"));
        mainPanel.add(outputLabel);

        int currentYear = currentDate.getYear();
        int currentMonthI = currentDate.getMonthValue();
        String[][] calendarData = generateCalendarData(currentYear, currentMonthI);

        String[] columnHeaders = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        DefaultTableModel tableModel = new DefaultTableModel(calendarData, columnHeaders) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JTable calendarTable = new JTable(tableModel);

        int cellSize = 70; // Size for square cells (e.g., 50x50)
        calendarTable.setRowHeight(cellSize);
        for (int i = 0; i < calendarTable.getColumnCount(); i++) {
            calendarTable.getColumnModel().getColumn(i).setPreferredWidth(cellSize);
        }


        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (!isSelected) {
                    cell.setBackground(Color.decode("#8AA29E"));
                }

                if (value != null) {
                    String rawValue = value.toString().replaceAll("<[^>]*>", ""); // Strip HTML tags
                    rawValue = rawValue.trim(); // Clean up extra spaces


                    if (rawValue.length() > 2) {
                        int date = -1;

                        // Extract the date based on content length and delimiters
                        try {
                            if (rawValue.contains("\u200B")) { // If Zero Width Space is used
                                date = Integer.parseInt(rawValue.split("\u200B")[0]);
                            } else if (rawValue.length() > 2 && rawValue.charAt(1) == ':') {
                                // Additional info detected, extract the date (length suggests "7 09:00 - 14:00")
                                date = Integer.parseInt(rawValue.substring(0, 1));
                            } else if (rawValue.length() > 3 && rawValue.charAt(2) == ':') {
                                // Two-digit day, extract accordingly
                                date = Integer.parseInt(rawValue.substring(0, 2));
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Failed to parse date: " + rawValue);
                        }

                        for (Shift shift : staff.getAssignedShifts()) {
                            if (shift.getDate().getDayOfMonth() == date) {
                                switch (shift.getShiftType()) {
                                    case "Morning":
                                        cell.setBackground(Color.decode("#F29615"));
                                        break;
                                    case "Evening":
                                        cell.setBackground(Color.decode("#5DA832"));
                                        break;
                                    case "Night":
                                        cell.setBackground(Color.decode("#D62828"));
                                        break;
                                }
                                cell.setForeground(Color.decode("#686963"));
                                cell.setFont(new Font("Arial", Font.PLAIN, 13));
                            }
                        }
                    } else if (rawValue.isEmpty()) {
                        cell.setBackground(Color.decode("#686963"));
                    } else {
                        cell.setFont(new Font("Arial", Font.PLAIN, 22));
                        cell.setBackground(Color.decode("#8AA29E"));

                    }

                }

                // Set custom font and styling

                cell.setForeground(Color.WHITE);
                setHorizontalAlignment(SwingConstants.CENTER);

                return cell;
            }
        };
        for (int i = 0; i < columnHeaders.length; i++) {
            calendarTable.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }



       // calendarTable.setBounds(25, 150, 1100, 300);

        JTableHeader tableHeader = calendarTable.getTableHeader();
        tableHeader.setFont(new Font("Arial", Font.BOLD, 16));


        JScrollPane scrollPane = new JScrollPane(calendarTable);
        scrollPane.setBounds(25, 150, 600, 450);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(calendarTable.getColumnCount() * cellSize, calendarTable.getRowCount() * cellSize)); // Set the size of the scrollPane to match the table's size

        mainPanel.add(scrollPane);

       // mainPanel.add(calendarTable);
        frame.setVisible(true);
        frame.repaint();
        frame.revalidate();
    }

    public String[][] generateCalendarData(int year, int month) {
        String[][] calendarData = new String[6][7]; // Assume max 6 rows for a month
        int day = 1;
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
        int firstDayIndex = firstDayOfMonth.getDayOfWeek().getValue() % 7;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (i == 0 && j < firstDayIndex || day > firstDayOfMonth.lengthOfMonth()) {
                    // Empty cells for days before the 1st or after the last day of the month
                    calendarData[i][j] = "";
                } else {
                    // Find the shift for the current day
                    Shift shiftForDay = null;
                    for (Shift shift : staff.getAssignedShifts()) {
                        if (shift.getDate().getDayOfMonth() == day && shift.getDate().getMonthValue() == month) {
                            shiftForDay = shift;
                            break;
                        }
                    }

                    // Display the day number, and if there's a shift, display the shift time
                    if (shiftForDay != null) {
                        calendarData[i][j] = "<html>" + day + "<br>" + "\u200B" + shiftForDay.getStartTime() + " - " + shiftForDay.getEndTime() + "</html>";
                    } else {
                        calendarData[i][j] = "<html>" + day + "<br></html>";
                    }

                    // Move to the next day
                    day++;
                }
            }
        }

        return calendarData;
    }
    private void setToAccountDetails() {
        mainPanel.setLayout(null);
        clearMainPanel();
        currentScreen = 1;
        colourSelectedScreenButton();
        JLabel outputLabel = new JLabel("Account Details");
        outputLabel.setBounds(mainPanel.getWidth() / 2 - 200, 0, 500, 100);
        outputLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
        outputLabel.setForeground(Color.decode("#686963"));
        mainPanel.add(outputLabel);

        outputLabel = new JLabel("Hello, " + staff.getFirstname());
        outputLabel.setBounds(100, 50, 500, 100);
        outputLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
        outputLabel.setForeground(Color.decode("#686963"));
        mainPanel.add(outputLabel);

        final int onePercentW = mainPanel.getWidth() / 100;
        final int onePercentH = mainPanel.getHeight() / 100;

        JPanel leftSquare = new JPanel();
        leftSquare.setPreferredSize(new Dimension(25, 25));
        leftSquare.setBackground(Color.decode("#ffffff"));
        leftSquare.setLayout(null);
        leftSquare.setBounds(onePercentW * 4,onePercentH * 22,onePercentW * 28,onePercentH * 45);
        mainPanel.add(leftSquare);

        JPanel middleSquare = new JPanel();
        middleSquare.setPreferredSize(new Dimension(25, 25));
        middleSquare.setBackground(Color.decode("#ffffff"));
        middleSquare.setLayout(null);
        middleSquare.setBounds(onePercentW * 36,onePercentH * 22,onePercentW * 28,onePercentH * 45);
        mainPanel.add(middleSquare);

        JPanel rightSquare = new JPanel();
        rightSquare.setPreferredSize(new Dimension(25, 25));
        rightSquare.setBackground(Color.decode("#ffffff"));
        rightSquare.setLayout(null);
        rightSquare.setBounds(onePercentW * 68,onePercentH * 22,onePercentW * 28,onePercentH * 45);
        mainPanel.add(rightSquare);

        //LEFT SQUARE INFO:
        outputLabel = new JLabel("Next Shift:");
        outputLabel.setBounds(20, 10, 500, 100);
        outputLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 18));
        outputLabel.setForeground(Color.decode("#686963"));
        leftSquare.add(outputLabel);

        Shift nextShift = staff.getNextShift();
        if (nextShift != null) {
            outputLabel = new JLabel(String.valueOf(nextShift.getDate()));
        } else {
            outputLabel = new JLabel("No upcoming shifts.");
        }
        outputLabel.setBounds(20, 50, 500, 100);
        outputLabel.setFont(new Font("Segoe UI Light", Font.PLAIN, 30));
        outputLabel.setForeground(Color.decode("#686963"));
        leftSquare.add(outputLabel);


        frame.setVisible(true);
        frame.repaint();
        frame.revalidate();
    }


    //TODO modify to work with student objects
    private void setToViewAllShifts() {
        mainPanel.setLayout(null);
        clearMainPanel();
        currentScreen = 2;
        colourSelectedScreenButton();
        JLabel outputLabel = new JLabel("Student Management");
        outputLabel.setBounds(mainPanel.getWidth() / 2 - 200, 0, 500, 100);
        outputLabel.setFont(new Font("Arial", Font.BOLD, 30));
        outputLabel.setForeground(Color.decode("#686963"));
        mainPanel.add(outputLabel);

        outputLabel = new JLabel("Student Accounts:");
        outputLabel.setBounds(mainPanel.getWidth() / 2 - 200, 50, 500, 100);
        outputLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        outputLabel.setForeground(Color.decode("#686963"));
        mainPanel.add(outputLabel);

        String[] criteriaOptions = {
                "Surname",
                "Student ID",
                "Academic Year",
                "Pending Subjects",
                "Subject Code",
                "Subject Code (Current Year)",
                "Meeting Cert Requirement",
                "Not Meeting Cert Requirement"
        };

        JComboBox<String> criteriaDropdown = new JComboBox<>(criteriaOptions);
        criteriaDropdown.setFont(new Font("Arial", Font.PLAIN, 16));
        criteriaDropdown.setBounds(800, 50, 250, 50);
        mainPanel.add(criteriaDropdown);






        frame.setVisible(true);
        frame.repaint();
        frame.revalidate();
    }



    protected void colourSelectedScreenButton() {
        JButton[] buttons = {
                overviewB,
                accountDetailsB,
                viewAllShiftsB,
        };

        for (JButton button : buttons) {
            button.addActionListener(e -> {

            });
        }

        for (int i = 0; i < buttons.length; i++) {
            JButton button = buttons[i];

            if (i == currentScreen) {
                button.setBackground(Color.decode("#88BEF4"));
                button.setForeground(Color.decode("#FFFFFF"));
            } else {
                button.setBackground(Color.decode("#D9EAFD"));
                button.setForeground(Color.decode("#686963"));
            }

        }
        frame.repaint();
        frame.revalidate();
    }

    protected void add_buttons(){
        overviewB = new JButton("Overview");
        overviewB.setBounds(25, 360, 250,50);
        overviewB.setFont(new Font("Inter", Font.PLAIN, 20));
        overviewB.setOpaque(true);
        overviewB.setBackground(Color.decode("#686963"));
        overviewB.setForeground(Color.decode("#FFFFFF"));
        overviewB.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        leftPanel.add(overviewB);


        accountDetailsB = new JButton("Account Details");
        accountDetailsB.setBounds(25, 430, 250,50);
        accountDetailsB.setFont(new Font("Inter", Font.PLAIN, 20));
        accountDetailsB.setOpaque(true);
        accountDetailsB.setBackground(Color.decode("#686963"));
        accountDetailsB.setForeground(Color.decode("#FFFFFF"));
        accountDetailsB.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        leftPanel.add(accountDetailsB);

        viewAllShiftsB = new JButton(   "View All Shifts");
        viewAllShiftsB.setBounds(25, 500, 250,50);
        viewAllShiftsB.setFont(new Font("Inter", Font.PLAIN, 20));
        viewAllShiftsB.setOpaque(true);
        viewAllShiftsB.setBackground(Color.decode("#686963"));
        viewAllShiftsB.setForeground(Color.decode("#FFFFFF"));
        viewAllShiftsB.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        leftPanel.add(viewAllShiftsB);


        overviewB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setToOverview();
            }
        });

        accountDetailsB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setToAccountDetails();
            }
        });
        viewAllShiftsB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setToViewAllShifts();
            }
        });

    }



    private void clearMainPanel(){

        mainPanel.removeAll(); // Clear all components
        mainPanel.revalidate(); // Refresh layout
        mainPanel.repaint(); // Repaint the panel

    }

    public JButton getOverviewB() {
        return overviewB;
    }

    public void setOverviewB(JButton overviewB) {
        this.overviewB = overviewB;
    }

    public JButton getAccountDetailsB() {
        return accountDetailsB;
    }

    public void setAccountDetailsB(JButton accountDetailsB) {
        this.accountDetailsB = accountDetailsB;
    }

    public JButton getViewAllShiftsB() {
        return viewAllShiftsB;
    }

    public void setViewAllShiftsB(JButton viewAllShiftsB) {
        this.viewAllShiftsB = viewAllShiftsB;
    }

    public JButton getSendMessageB() {
        return sendMessageB;
    }

    public void setSendMessageB(JButton sendMessageB) {
        this.sendMessageB = sendMessageB;
    }
}