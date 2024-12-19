import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

public class StaffScreen extends UserScreen{
    private JLabel companyNameLabel;
    public int currentScreen;




    private JButton overviewB, accountDetailsB, viewAllShiftsB,curriculumInfoB,academicYearB,examDetailB, resetAllPasswords, viewDetailsCurrPend, createNewTeacherB, assignTeacherToSubjectB, removeTeacherB, removeTeacherSubjectB,
            viewStudentCurrB, addStudentB,removeStudentB,notifyStudentsB, createNewSubB, editSubB, removeSubB, setExamCountB, changePassB, changeMaxB, setMaxOpSubjectsB, setMinOpSubjectsB, setReqSB
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



        frame.setVisible(true);
        frame.repaint();
        frame.revalidate();
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
                button.setBackground(Color.decode("#528F85"));
                button.setForeground(Color.decode("#FFFFFF"));
            } else {
                button.setBackground(Color.decode("#686963"));
                button.setForeground(Color.decode("#FFFFFF"));
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

    public JButton getCurriculumInfoB() {
        return curriculumInfoB;
    }

    public void setCurriculumInfoB(JButton curriculumInfoB) {
        this.curriculumInfoB = curriculumInfoB;
    }

    public JButton getAcademicYearB() {
        return academicYearB;
    }

    public void setAcademicYearB(JButton academicYearB) {
        this.academicYearB = academicYearB;
    }

    public JButton getExamDetailB() {
        return examDetailB;
    }

    public void setExamDetailB(JButton examDetailB) {
        this.examDetailB = examDetailB;
    }

    public JButton getResetAllPasswords() {
        return resetAllPasswords;
    }

    public void setResetAllPasswords(JButton resetAllPasswords) {
        this.resetAllPasswords = resetAllPasswords;
    }

    public JButton getViewDetailsCurrPend() {
        return viewDetailsCurrPend;
    }

    public void setViewDetailsCurrPend(JButton viewDetailsCurrPend) {
        this.viewDetailsCurrPend = viewDetailsCurrPend;
    }

    public JButton getCreateNewTeacherB() {
        return createNewTeacherB;
    }

    public void setCreateNewTeacherB(JButton createNewTeacherB) {
        this.createNewTeacherB = createNewTeacherB;
    }

    public JButton getAssignTeacherToSubjectB() {
        return assignTeacherToSubjectB;
    }

    public void setAssignTeacherToSubjectB(JButton assignTeacherToSubjectB) {
        this.assignTeacherToSubjectB = assignTeacherToSubjectB;
    }

    public JButton getRemoveTeacherB() {
        return removeTeacherB;
    }

    public void setRemoveTeacherB(JButton removeTeacherB) {
        this.removeTeacherB = removeTeacherB;
    }

    public JButton getRemoveTeacherSubjectB() {
        return removeTeacherSubjectB;
    }

    public void setRemoveTeacherSubjectB(JButton removeTeacherSubjectB) {
        this.removeTeacherSubjectB = removeTeacherSubjectB;
    }

    public JButton getViewStudentCurrB() {
        return viewStudentCurrB;
    }

    public void setViewStudentCurrB(JButton viewStudentCurrB) {
        this.viewStudentCurrB = viewStudentCurrB;
    }

    public JButton getAddStudentB() {
        return addStudentB;
    }

    public void setAddStudentB(JButton addStudentB) {
        this.addStudentB = addStudentB;
    }

    public JButton getRemoveStudentB() {
        return removeStudentB;
    }

    public void setRemoveStudentB(JButton removeStudentB) {
        this.removeStudentB = removeStudentB;
    }

    public JButton getNotifyStudentsB() {
        return notifyStudentsB;
    }

    public void setNotifyStudentsB(JButton notifyStudentsB) {
        this.notifyStudentsB = notifyStudentsB;
    }

    public JButton getCreateNewSubB() {
        return createNewSubB;
    }

    public void setCreateNewSubB(JButton createNewSubB) {
        this.createNewSubB = createNewSubB;
    }

    public JButton getEditSubB() {
        return editSubB;
    }

    public void setEditSubB(JButton editSubB) {
        this.editSubB = editSubB;
    }

    public JButton getRemoveSubB() {
        return removeSubB;
    }

    public void setRemoveSubB(JButton removeSubB) {
        this.removeSubB = removeSubB;
    }

    public JButton getSetExamCountB() {
        return setExamCountB;
    }

    public void setSetExamCountB(JButton setExamCountB) {
        this.setExamCountB = setExamCountB;
    }

    public JButton getChangePassB() {
        return changePassB;
    }

    public void setChangePassB(JButton changePassB) {
        this.changePassB = changePassB;
    }

    public JButton getChangeMaxB() {
        return changeMaxB;
    }

    public void setChangeMaxB(JButton changeMaxB) {
        this.changeMaxB = changeMaxB;
    }

    public JButton getSetMaxOpSubjectsB() {
        return setMaxOpSubjectsB;
    }

    public void setSetMaxOpSubjectsB(JButton setMaxOpSubjectsB) {
        this.setMaxOpSubjectsB = setMaxOpSubjectsB;
    }

    public JButton getSetMinOpSubjectsB() {
        return setMinOpSubjectsB;
    }

    public void setSetMinOpSubjectsB(JButton setMinOpSubjectsB) {
        this.setMinOpSubjectsB = setMinOpSubjectsB;
    }

    public JButton getSetReqSB() {
        return setReqSB;
    }

    public void setSetReqSB(JButton setReqSB) {
        this.setReqSB = setReqSB;
    }
}