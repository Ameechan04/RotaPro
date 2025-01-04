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

public class ManagerScreen extends UserScreen{
    private JLabel companyNameLabel;
    public int currentScreen;




    private JButton  overviewB, viewRotaB, createNoticeB, manageEmployeesB,settingsB;

    private ArrayList<Shift> shifts;
    Company company;
    public ManagerScreen(Company company){
        super(company);
        this.company = company;
        currentScreen = 0;
        add_labels(company);
        add_buttons();
        setToOverview();
        colourSelectedScreenButton();
    }


    @Override
    protected void add_labels(Staff s) {
    }

    @Override
    protected void add_labels(Company c) {
        outputLabel = new JLabel(c.getCompany_name());
        outputLabel.setBounds(30, 260, 300, 35);
        outputLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        outputLabel.setForeground(Color.white);
        leftPanel.add(outputLabel);





        Font font = new Font("Arial", Font.PLAIN, 30);
        JLabel label = new JLabel(c.getCompanyName());
        label.setFont(font);
        label.setForeground(Color.decode("#FFFFFF"));
        FontMetrics metrics = label.getFontMetrics(font);
        int textWidth = metrics.stringWidth(label.getText());
        label.setBounds((topPanel.getWidth() / 2) - (textWidth / 2),1,300,60);
        topPanel.add(label);




    }

    private void setToOverview() {
        mainPanel.setLayout(null);
        clearMainPanel();
        currentScreen = 0;
        colourSelectedScreenButton();

        LocalDate currentDate = LocalDate.now();
        JLabel outputLabel = new JLabel("Welcome! Today is the " + currentDate + ".");
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


        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < columnHeaders.length; i++) {
            calendarTable.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }



        JTableHeader tableHeader = calendarTable.getTableHeader();
        tableHeader.setFont(new Font("Arial", Font.BOLD, 16));
        calendarTable.setBounds(25, 150, 1100, 150);
        mainPanel.add(calendarTable);
        frame.setVisible(true);
        frame.repaint();
        frame.revalidate();
    }

    private static String[][] generateCalendarData(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        LocalDate firstDayOfMonth = yearMonth.atDay(1);
        int totalDaysInMonth = yearMonth.lengthOfMonth();
        int firstDayOfWeek = firstDayOfMonth.getDayOfWeek().getValue() % 7; // 0 = Sunday

        // Create a 6x7 grid for the calendar (at most 6 weeks)
        String[][] calendar = new String[6][7];
        int day = 1;

        // Populate the calendar grid
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                if (row == 0 && col < firstDayOfWeek || day > totalDaysInMonth) {
                    calendar[row][col] = ""; // Empty cell
                } else {
                    calendar[row][col] = String.valueOf(day);
                    day++;
                }
            }
        }
        return calendar;
    }
    private void setToAccountDetails() {
        mainPanel.setLayout(null);
        clearMainPanel();
        currentScreen = 1;
        colourSelectedScreenButton();
        JLabel outputLabel = new JLabel("Account Details");
        outputLabel.setBounds(mainPanel.getWidth() / 2 - 200, 0, 500, 100);
        outputLabel.setFont(new Font("Arial", Font.BOLD, 30));
        outputLabel.setForeground(Color.decode("#686963"));
        mainPanel.add(outputLabel);

        outputLabel = new JLabel("Teacher Accounts:");
        outputLabel.setBounds(mainPanel.getWidth() / 2 - 175, 50, 500, 100);
        outputLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        outputLabel.setForeground(Color.decode("#686963"));
        mainPanel.add(outputLabel);


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



    private void setToCurriculum() {
        mainPanel.setLayout(null);
        clearMainPanel();
        currentScreen = 3;
        colourSelectedScreenButton();
        JLabel outputLabel = new JLabel("Curriculum Management");
        outputLabel.setBounds(mainPanel.getWidth() / 2 - 200, 0, 500, 100);
        outputLabel.setFont(new Font("Arial", Font.BOLD, 30));
        outputLabel.setForeground(Color.decode("#686963"));
        mainPanel.add(outputLabel);
        // Subject s = new Subject(ID,CORE,NAME,MAX MARK,PASS MARK, SCHOOL ID) + no of students
        outputLabel = new JLabel("All subjects:");
        outputLabel.setBounds(mainPanel.getWidth() / 2 - 200, 50, 500, 100);
        outputLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        outputLabel.setForeground(Color.decode("#686963"));
        mainPanel.add(outputLabel);

        String[] criteriaOptions = {
                "Name",
                "Subject ID",
                "Teachers",
                "Maximum Possible Marks",
                "Pass Mark",
                "Current Number of Students",
                "Number of Exams",
                "Core Subject",
                "Optional Subject",
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
                viewRotaB,
                createNoticeB,
                manageEmployeesB,
                settingsB
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


        viewRotaB = new JButton("View Rota");
        viewRotaB.setBounds(25, 430, 250,50);
        viewRotaB.setFont(new Font("Inter", Font.PLAIN, 20));
        viewRotaB.setOpaque(true);
        viewRotaB.setBackground(Color.decode("#686963"));
        viewRotaB.setForeground(Color.decode("#FFFFFF"));
        viewRotaB.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        leftPanel.add(viewRotaB);

        createNoticeB = new JButton(   "Create Notice");
        createNoticeB.setBounds(25, 500, 250,50);
        createNoticeB.setFont(new Font("Inter", Font.PLAIN, 20));
        createNoticeB.setOpaque(true);
        createNoticeB.setBackground(Color.decode("#686963"));
        createNoticeB.setForeground(Color.decode("#FFFFFF"));
        createNoticeB.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        leftPanel.add(createNoticeB);

        manageEmployeesB = new JButton("Manage Employees");
        manageEmployeesB.setBounds(25, 570, 250,50);
        manageEmployeesB.setFont(new Font("Inter", Font.PLAIN, 20));
        manageEmployeesB.setOpaque(true);
        manageEmployeesB.setBackground(Color.decode("#686963"));
        manageEmployeesB.setForeground(Color.decode("#FFFFFF"));
        manageEmployeesB.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        leftPanel.add(manageEmployeesB);

        settingsB = new JButton("Settings");
        settingsB.setBounds(25, 640, 250,50);
        settingsB.setFont(new Font("Inter", Font.PLAIN, 20));
        settingsB.setOpaque(true);
        settingsB.setBackground(Color.decode("#686963"));
        settingsB.setForeground(Color.decode("#FFFFFF"));
        settingsB.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        leftPanel.add(settingsB);


        overviewB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setToOverview();
            }
        });

        viewRotaB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setToAccountDetails();
            }
        });
        createNoticeB.addActionListener(new ActionListener() {
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

    public JButton getViewRotaB() {
        return viewRotaB;
    }

    public void setViewRotaB(JButton viewRotaB) {
        this.viewRotaB = viewRotaB;
    }

    public JButton getCreateNoticeB() {
        return createNoticeB;
    }

    public void setCreateNoticeB(JButton createNoticeB) {
        this.createNoticeB = createNoticeB;
    }

    public JButton getManageEmployeesB() {
        return manageEmployeesB;
    }

    public void setManageEmployeesB(JButton manageEmployeesB) {
        this.manageEmployeesB = manageEmployeesB;
    }

    public JButton getSettingsB() {
        return settingsB;
    }

    public void setSettingsB(JButton settingsB) {
        this.settingsB = settingsB;
    }
}
