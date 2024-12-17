//Imports
//import repos.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Controller {
    private String username, password;

    /*
    UserRepo userRepo = new UserRepo();
    SubjectRepo subjectRepo = new SubjectRepo();
    StudentRepo studentRepo = new StudentRepo();
    TeacherRepo teacherRepo = new TeacherRepo();
    SchoolManagerRepo managerRepo = new SchoolManagerRepo();
    AttendanceRepo attendanceRepo = new AttendanceRepo();
    TeachingMaterialRepo materialRepo = new TeachingMaterialRepo();


     */
    //ArrayList<User> users = new ArrayList<>();
    LoginScreen loginScreen;
    Scanner sc = new Scanner(System.in);

    public Controller() {
        SwingUtilities.invokeLater(() -> {
            loginScreen = new LoginScreen();
            loginScreen.getLoginButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                  //  validateLogin();
                }
            });

            loginScreen.getSignUpButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   // handleSignup();
                }
            });

            loginScreen.getForgotButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                 //   forgotPassword();
                }
            });

        });
    }

    public void validateLogin() {
        String userId = loginScreen.getUsernameField().getText();
        char[] passwordA = loginScreen.getPasswordField().getPassword();
        String password = new String(passwordA);
        String role;
        boolean valid;
        boolean validUsername, validPassword = false;
        if (userId.isEmpty() || userId.equals("Enter your username")) {
            loginScreen.printInvalidUsername();
        } else {
            /*
            if (userRepo.validateUsername(userId)) {
                validUsername = true;
                System.out.println("Username is valid");
                if (password.isEmpty() || password.equals("Enter your password")) {
                    loginScreen.printInvalidPassword();
                } else {
                    //password not null:
                    if (userRepo.validatePassword(password, userId)) {
                        //valid password
                        validPassword = true;
                    } else {
                        loginScreen.printInvalidPassword();
                    }
                }
                if (validPassword) {
                    loginScreen.close();
                    System.out.println(userId + " is valid");
                    System.out.println(password + " is their password");
                    role = userRepo.getRole(userId);

                    User.Role roleS;


                    switch (role) {
                        case "Student":
                            // Handle student login
                            ArrayList<Subject> subjects = new ArrayList<>();

                            String studentId = userId;
                            System.out.println("Student detected");

                            // Get student details and subjects

                            roleS = User.Role.valueOf(userRepo.getRole(studentId).toUpperCase());
                            subjects = populateSubjects(studentId);

                            Student student = new Student(studentId, userRepo.getEmail(studentId),
                                    userRepo.getSchoolID(studentId),
                                    studentRepo.getFirstname(studentId),
                                    studentRepo.getSurname(studentId),
                                    studentRepo.getMerit(studentId),
                                    studentRepo.getDemerit(studentId),
                                    subjects,
                                    studentRepo.getCertificate(studentId),
                                    studentRepo.getSchoolYear(studentId)
                            );

                            // view certificate
                            StudentScreen s = new StudentScreen(student);
                            s.getViewCertificate().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    s.viewCertificateScreen();
                                }
                            });
// Fix below
                            break;

                        case "Teacher":
                            System.out.println("Teacher detected");

                            String teacherId = userId;
                            ArrayList<TeacherClass> teacherClassList = populateTeacherClassList(teacherId);
                            Teacher t = new Teacher(teacherId, userRepo.getEmail(teacherId), userRepo.getSchoolID(teacherId), teacherRepo.getDOB(teacherId), teacherRepo.getFirstname(teacherId), teacherRepo.getSurname(teacherId), teacherClassList);
                            TeacherScreen ts = new TeacherScreen(t);

                            ts.getUploadMaterial().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    ts.openTeachingMaterial();
                                    ts.getUpload().addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            String materialName = ts.getMaterialNameField().getText().trim();
                                            String subjectId = ts.getSubjectField().getText().trim();
                                            File filePath = new File(ts.getFilePathLabel().getText());

                                            if (materialName.isEmpty() || subjectId.isEmpty() || ts.getFilePathLabel().getText().equals("No file selected")) {

                                            } else {
                                                if(materialRepo.addTeacherMaterial(materialName, filePath, userRepo.getSchoolID(teacherId), userId, subjectId)){
                                                    System.out.println("File uploaded");
                                                } else {
                                                    System.out.println("File not uploaded, error.");
                                                }

                                                ts.getFilePathLabel().setText("No file selected");
                                                ts.getSubjectField().setText("");
                                                ts.getMaterialNameField().setText("");
                                            }
                                        }
                                    });
                                }
                            });
                            break;

                        case "Manager":
                            System.out.println("Manager detected");
                            String schoolId = userId;
                            roleS = User.Role.valueOf(userRepo.getRole(schoolId).toUpperCase());
                            SchoolManager m = new SchoolManager(schoolId, managerRepo.getEmail(schoolId), managerRepo.getSchoolName(schoolId), managerRepo.getStatus(schoolId), managerRepo.getPhoneNumber(schoolId), managerRepo.getAddress(schoolId), managerRepo.getOptionalSubjectsMax(schoolId), managerRepo.getOptionalSubjectsMin(schoolId), managerRepo.getSubjectPassedReq(schoolId), getStudentsBySchool(schoolId), getTeachersBySchool(schoolId), getSubjectsBySchool(schoolId), getStudentsWaitingReset(schoolId), getTeachersWaitingReset(schoolId));
                            ManagerScreen managerScreen = new ManagerScreen(m);
                            handleManager(managerScreen, m);
                            break;

                        case "Admin":

                            System.out.println("Admin detected");
                            roleS = User.Role.valueOf(userRepo.getRole(userId).toUpperCase());
                            Admin admin = new Admin(userId, populateSchools(), populateApprovedSchools(), populatePendingSchools());
                            AdminScreen adminScreen = new AdminScreen(admin);
                            System.out.println("Admin screen created");
                            break;
                    }
                }

            } else {
                loginScreen.printInvalidUsername();
            }

        }



             */
        }
    }

    private void forgotPassword(){
        loginScreen.reset_password_screen();

        loginScreen.getSubmitResetButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (loginScreen.getIDresetField().getText().trim().isEmpty()) {
                    loginScreen.updateErrorMessage("Please enter an ID");
                } else {

                    /*
                    if (userRepo.validateUsername(loginScreen.getIDresetField().getText())) {
                        String id = loginScreen.getIDresetField().getText();

                        String account_type;
                        if (studentRepo.getAllStudentIDs().contains(id)) {
                            account_type = "Student";
                        } else if (teacherRepo.getAllTeacherIDs().contains(id)) {
                            account_type = "Teacher";
                        } else {
                            account_type = "error";
                        }
                        String schoolID;
                        if (account_type.equals("Student")) {
                            schoolID = studentRepo.getSchoolIDByStudentID(id);
                        } else if (account_type.equals("Teacher")) {
                            schoolID = teacherRepo.getSchoolIDByTeacherID(id);
                        } else {
                            throw new IllegalArgumentException("Invalid account type");
                        }

                        userRepo.addPasswordResetRequest(id, account_type, schoolID);
                        System.out.println("Added");
                        loginScreen.updateErrorMessage("Reset Request Sent");

                    }
                    */




                }


            }
        });

    }

    /*public ArrayList<Subject> populateSubjects(String id) {
        ArrayList<Subject> subjects = new ArrayList<>();

        List<String> subjectIds = studentRepo.getSubjectList(id);

        for (String subjectId : subjectIds) {
            String subject_id = subjectId;
            boolean core_subject = subjectRepo.getCoreSubject(subjectId);
            String subject_name = subjectRepo.getSubjectName(subjectId);
            String max_marks = subjectRepo.getMaxMarks(subjectId);
            String pass_marks = subjectRepo.getPassMarks(subjectId);
            String school_id = subjectRepo.getSchoolID(subjectId);
            boolean pending = subjectRepo.getPending(subjectId);
            float attendance = attendanceRepo.getAttendanceTotal(id, subjectId);
            ArrayList<TeachingMaterial> materials = populateMaterials(subjectId);
            Subject subject = new Subject(subject_id, core_subject, subject_name, max_marks, pass_marks, school_id, pending, materials, attendance);
            subjects.add(subject);
        }
        return subjects;
    }
    */

    /*
    public ArrayList<Student> populateStudents(String teacherId) {
        ArrayList<Student> students = new ArrayList<>();

        List<String> studentIds = studentRepo.getStudentIdsForTeacher(teacherId); // New DB Method

        for (String studentId : studentIds) {
            String firstname = studentRepo.getFirstname(studentId);
            String surname = studentRepo.getSurname(studentId);
            String merit = studentRepo.getMerit(studentId);
            String demerit = studentRepo.getDemerit(studentId);
            boolean certificate = studentRepo.getCertificate(studentId);
            String schoolYear = studentRepo.getSchoolYear(studentId);
            ArrayList<Subject> subjects = null; // Fetch subjects per student

            Student student = new Student(
                    studentId,
                    userRepo.getEmail(studentId),
                    userRepo.getSchoolID(studentId),
                    firstname,
                    surname,
                    merit,
                    demerit,
                    subjects,
                    certificate,
                    schoolYear

            );
            student.setSubjects(populateSubjects(studentId));

            students.add(student);
        }
        return students;
    }
    */

    /*
    public ArrayList<TeachingMaterial> populateMaterials(String subjectId) {
        ArrayList<TeachingMaterial> teachingMaterials = new ArrayList<>();

        List<String> materialIds = materialRepo.getTeachingMaterialIDs(subjectId);

        for (String materialId : materialIds) {
            String materialName = materialRepo.getMaterialName(materialId);
            String uploadDate = materialRepo.getUploadDate(materialId);
            File materialFile = materialRepo.getMaterialPDF(materialId);

            TeachingMaterial teachingMaterial = new TeachingMaterial(materialId, uploadDate, materialName, materialFile, subjectRepo.getSchoolID(subjectId), "100", subjectId);
            teachingMaterials.add(teachingMaterial);
        }
        return teachingMaterials;
    }
    */

    /*
    public ArrayList<Student> getStudentsBySchool(String schoolID) {
        ArrayList<Student> students = new ArrayList<>();

        List<String> studentIds = studentRepo.getStudentIdsForSchool(schoolID);

        for (String studentId : studentIds) {
            String firstname = studentRepo.getFirstname(studentId);
            String surname = studentRepo.getSurname(studentId);
            String merit = studentRepo.getMerit(studentId);
            String demerit = studentRepo.getDemerit(studentId);
            boolean certificate = studentRepo.getCertificate(studentId);
            String schoolYear = studentRepo.getSchoolYear(studentId);
            ArrayList<Subject> subjects = populateSubjects(studentId); // Fetch subjects per student
            Student student = new Student(
                    studentId,
                    userRepo.getEmail(studentId),
                    userRepo.getSchoolID(studentId),
                    firstname,
                    surname,
                    merit,
                    demerit,
                    subjects,
                    certificate,
                    schoolYear
            );

            students.add(student);
        }
        return students;
    }

    public ArrayList<Teacher> getTeachersBySchool(String schoolID) {
        ArrayList<Teacher> teachers = new ArrayList<>();

        List<String> teacherIDs = teacherRepo.getTeacherIdsForSchool(schoolID);

        for (String teacherID : teacherIDs) {
            String dob = teacherRepo.getDOB(teacherID);
            String firstname = teacherRepo.getFirstname(teacherID);
            String surname = teacherRepo.getSurname(teacherID);

            Teacher teacher = new Teacher(
                    teacherID,
                    userRepo.getEmail(teacherID),
                    userRepo.getSchoolID(teacherID),
                    dob,
                    firstname,
                    surname,
                    populateTeacherClassList(teacherID)
            );

            teachers.add(teacher);
        }
        return teachers;
    }

    public ArrayList<Subject> getSubjectsBySchool(String schoolID) {
        ArrayList<Subject> subjects = new ArrayList<>();

        List<String> subjectIDs = subjectRepo.getSubjectIdsForSchool(schoolID);

        for (String subjectID : subjectIDs) {
            String subjectName = subjectRepo.getSubjectName(subjectID);
            String maxMarks = subjectRepo.getMaxMarks(subjectID);
            String passMarks = subjectRepo.getPassMarks(subjectID);
            boolean isCore = subjectRepo.getCoreSubject(subjectID);
            float attendance = attendanceRepo.getAverageAttendance(subjectID);
            boolean isPending = subjectRepo.getPending(subjectID);
            ArrayList<TeachingMaterial> t = populateMaterials(subjectID);
            Subject subject = new Subject(
                    subjectID,
                    isCore,
                    subjectName,
                    maxMarks,
                    passMarks,
                    schoolID,
                    isPending,
                    t,
                    attendance
            );

            subjects.add(subject);
        }
        return subjects;
    }


    public ArrayList<TeacherClass> populateTeacherClassList(String teacherId) {
        ArrayList<TeacherClass> teacherClassList = new ArrayList<>();

        List<String> subjectIds = teacherRepo.getSubjectListForTeacher(teacherId); // New DB Method

        for (String subjectId : subjectIds) {
            String subjectName = subjectRepo.getSubjectName(subjectId);
            String maxMarks = subjectRepo.getMaxMarks(subjectId);
            String passMarks = subjectRepo.getPassMarks(subjectId);
            ArrayList<Student> students = populateStudents(teacherId); // Fetch students per class
            ArrayList<TeachingMaterial> teachingMaterials = populateMaterials(subjectId);

            TeacherClass teacherClass = new TeacherClass(
                    subjectId,
                    subjectName,
                    maxMarks,
                    passMarks,
                    students,
                    teachingMaterials
            );

            teacherClassList.add(teacherClass);
        }

        return teacherClassList;
    }

    public ArrayList<SchoolManager> populateSchools() {
        ArrayList<SchoolManager> schools = new ArrayList<>();
        ArrayList<String> schoolIds = managerRepo.getAllSchoolIds(); // Get all school IDs

        for (String schoolId : schoolIds) {
            String schoolName = managerRepo.getSchoolName(schoolId);
            String address = managerRepo.getAddress(schoolId);
            String phoneNumber = managerRepo.getPhoneNumber(schoolId);
            String email = managerRepo.getEmail(schoolId);
            Integer status = managerRepo.getStatus(schoolId);
            Integer optionalSubjectsMax = managerRepo.getOptionalSubjectsMax(schoolId);
            Integer optionalSubjectsMin = managerRepo.getOptionalSubjectsMin(schoolId);
            Integer subjectPassedReq = managerRepo.getSubjectPassedReq(schoolId);

            // Fetch all students, teachers, and subjects for the school
            ArrayList<Student> allStudents = getStudentsBySchool(schoolId);
            ArrayList<Teacher> allTeachers = getTeachersBySchool(schoolId);
            ArrayList<Subject> allSubjects = getSubjectsBySchool(schoolId);

            // Create a new SchoolManager object with the retrieved data
            SchoolManager m = new SchoolManager(schoolId, managerRepo.getEmail(schoolId), managerRepo.getSchoolName(schoolId), managerRepo.getStatus(schoolId), managerRepo.getPhoneNumber(schoolId), managerRepo.getAddress(schoolId), managerRepo.getOptionalSubjectsMax(schoolId), managerRepo.getOptionalSubjectsMin(schoolId), managerRepo.getSubjectPassedReq(schoolId), getStudentsBySchool(schoolId), getTeachersBySchool(schoolId), getSubjectsBySchool(schoolId), getStudentsWaitingReset(schoolId), getTeachersWaitingReset(schoolId));
            schools.add(m);
        }

        return schools;
    }

    private ArrayList<SchoolManager> populateApprovedSchools() {
        ArrayList<SchoolManager> allSchools = populateSchools(); // Get all schools
        ArrayList<SchoolManager> approvedSchools = new ArrayList<>();
        for (SchoolManager school : allSchools) {
            if (school.getStatus() == 1){ // Check if the school is approved
                approvedSchools.add(school);
            }
        }
        return approvedSchools;
    }

    private ArrayList<SchoolManager> populatePendingSchools() {
        ArrayList<SchoolManager> allSchools = populateSchools(); // Get all schools
        ArrayList<SchoolManager> pendingSchools = new ArrayList<>();
        for (SchoolManager school : allSchools) {
            if (school.getStatus() == 0) { // Check if the school is pending
                pendingSchools.add(school);
            }
        }
        return pendingSchools;
    }


    public void validateLogin() {
        String userId = loginScreen.getUsernameField().getText();
        char[] passwordA = loginScreen.getPasswordField().getPassword();
        String password = new String(passwordA);
        String role;
        boolean valid;
        boolean validUsername, validPassword = false;
        if (userId.isEmpty() || userId.equals("Enter your username")) {
            loginScreen.printInvalidUsername();
        } else {
            if (userRepo.validateUsername(userId)) {
                validUsername = true;
                System.out.println("Username is valid");
                if (password.isEmpty() || password.equals("Enter your password")) {
                    loginScreen.printInvalidPassword();
                } else {
                    //password not null:
                    if (userRepo.validatePassword(password, userId)) {
                        //valid password
                        validPassword = true;
                    } else {
                        loginScreen.printInvalidPassword();
                    }
                }
                if (validPassword) {
                    loginScreen.close();
                    System.out.println(userId + " is valid");
                    System.out.println(password + " is their password");
                    role = userRepo.getRole(userId);

                    User.Role roleS;


                    switch (role) {
                        case "Student":
                            // Handle student login
                            ArrayList<Subject> subjects = new ArrayList<>();

                            String studentId = userId;
                            System.out.println("Student detected");

                            // Get student details and subjects

                            roleS = User.Role.valueOf(userRepo.getRole(studentId).toUpperCase());
                            subjects = populateSubjects(studentId);

                            Student student = new Student(studentId, userRepo.getEmail(studentId),
                                    userRepo.getSchoolID(studentId),
                                    studentRepo.getFirstname(studentId),
                                    studentRepo.getSurname(studentId),
                                    studentRepo.getMerit(studentId),
                                    studentRepo.getDemerit(studentId),
                                    subjects,
                                    studentRepo.getCertificate(studentId),
                                    studentRepo.getSchoolYear(studentId)
                            );

                            // view certificate
                            StudentScreen s = new StudentScreen(student);
                            s.getViewCertificate().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    s.viewCertificateScreen();
                                }
                            });
// Fix below
                            break;

                        case "Teacher":
                            System.out.println("Teacher detected");

                            String teacherId = userId;
                            ArrayList<TeacherClass> teacherClassList = populateTeacherClassList(teacherId);
                            Teacher t = new Teacher(teacherId, userRepo.getEmail(teacherId), userRepo.getSchoolID(teacherId), teacherRepo.getDOB(teacherId), teacherRepo.getFirstname(teacherId), teacherRepo.getSurname(teacherId), teacherClassList);
                            TeacherScreen ts = new TeacherScreen(t);

                            ts.getUploadMaterial().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    ts.openTeachingMaterial();
                                    ts.getUpload().addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            String materialName = ts.getMaterialNameField().getText().trim();
                                            String subjectId = ts.getSubjectField().getText().trim();
                                            File filePath = new File(ts.getFilePathLabel().getText());

                                            if (materialName.isEmpty() || subjectId.isEmpty() || ts.getFilePathLabel().getText().equals("No file selected")) {

                                            } else {
                                                if(materialRepo.addTeacherMaterial(materialName, filePath, userRepo.getSchoolID(teacherId), userId, subjectId)){
                                                    System.out.println("File uploaded");
                                                } else {
                                                    System.out.println("File not uploaded, error.");
                                                }

                                                ts.getFilePathLabel().setText("No file selected");
                                                ts.getSubjectField().setText("");
                                                ts.getMaterialNameField().setText("");
                                            }
                                        }
                                    });
                                }
                            });
                            break;

                        case "Manager":
                            System.out.println("Manager detected");
                            String schoolId = userId;
                            roleS = User.Role.valueOf(userRepo.getRole(schoolId).toUpperCase());
                            SchoolManager m = new SchoolManager(schoolId, managerRepo.getEmail(schoolId), managerRepo.getSchoolName(schoolId), managerRepo.getStatus(schoolId), managerRepo.getPhoneNumber(schoolId), managerRepo.getAddress(schoolId), managerRepo.getOptionalSubjectsMax(schoolId), managerRepo.getOptionalSubjectsMin(schoolId), managerRepo.getSubjectPassedReq(schoolId), getStudentsBySchool(schoolId), getTeachersBySchool(schoolId), getSubjectsBySchool(schoolId), getStudentsWaitingReset(schoolId), getTeachersWaitingReset(schoolId));
                            ManagerScreen managerScreen = new ManagerScreen(m);
                            handleManager(managerScreen, m);
                            break;

                        case "Admin":

                            System.out.println("Admin detected");
                            roleS = User.Role.valueOf(userRepo.getRole(userId).toUpperCase());
                            Admin admin = new Admin(userId, populateSchools(), populateApprovedSchools(), populatePendingSchools());
                            AdminScreen adminScreen = new AdminScreen(admin);
                            System.out.println("Admin screen created");
                            break;
                    }
                }

            } else {
                loginScreen.printInvalidUsername();
            }

        }


    }
    private void handleManager(ManagerScreen managerScreen, SchoolManager managerS) {
        managerScreen.getResetAllPasswords().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                ArrayList<String> idsToReset = new ArrayList<>();
                for (Student s: managerS.getWaitingResetS()) {
                    idsToReset.add(s.getStudentID());
                }
                for (Teacher t: managerS.getWaitingResetT()) {
                    idsToReset.add(t.getTeacherId());
                }

                for (String id: idsToReset) {
                    userRepo.resetPassword(id);
                    userRepo.removePasswordResetRequest(id, userRepo.getSchoolID(id));
                }
            }
        });

    }

    private void handleSignup() {
        SignupScreen signUpScreen = new SignupScreen();

        signUpScreen.getSignUpButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String schoolName = signUpScreen.getSchoolName();
                String address = signUpScreen.getAddress();
                String phone = signUpScreen.getPhone();
                String email = signUpScreen.getEmail();
                String password = signUpScreen.getPassword();
                String confirmPassword = signUpScreen.getConfirmPassword();

                // Validate input
                if (schoolName.isEmpty() || address.isEmpty() || phone.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // call the method to handle the signup logic
                boolean signupSuccess = managerRepo.signUpSchool(schoolName, address, phone, email, password);

                if (signupSuccess) {
                    JOptionPane.showMessageDialog(null, "Sign up successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    signUpScreen.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Sign up failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        signUpScreen.getCancelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUpScreen.close();
            }
        });
    }

    public Teacher getTeachersFromSubject(String subjectId) {
        String schoolID = subjectRepo.getSchoolID(subjectId);
        for (Teacher t : getTeachersBySchool(schoolID)) {
            for (int clas = 0; clas < t.getTeacherClassList().size(); clas++) {
                if (Objects.equals(t.getTeacherClassList().get(clas).getSubjectId(), subjectId)) {
                    return t;
                }
            }

        }
        return null;
    }

    public ArrayList<Teacher> getAllTeachersFromStudentSubjects(Student student) {
        ArrayList<Teacher> classTeachers = new ArrayList<>();
        for (Subject s : student.getSubjects()) {
            classTeachers.add(getTeachersFromSubject(s.getSubject_id()));
        }
        return classTeachers;
    }

    private ArrayList<Student> getStudentsWaitingReset(String schoolID) {
        ArrayList<String> ids = userRepo.getPasswordResetRequests(schoolID, "Student");
        ArrayList<Student> students = new ArrayList<>();

        for (String id : ids) {
            String email = userRepo.getEmail(id);
            String firstname = studentRepo.getFirstname(id);
            String surname = studentRepo.getSurname(id);
            String merit = studentRepo.getMerit(id);
            String demerit = studentRepo.getDemerit(id);
            ArrayList<Subject> subjects = populateSubjects(id);
            boolean earnedCertificate = studentRepo.getCertificate(id);
            String schoolYear = studentRepo.getSchoolYear(id);
            Student student = new Student(
                    id, email, schoolID, firstname, surname, merit, demerit, subjects, earnedCertificate, schoolYear
            );

            students.add(student);
        }

        return students;
    }

    private ArrayList<Student> allStudents(){
        ArrayList<String> IDs = studentRepo.getAllStudentIDs();
        ArrayList<Student> students = new ArrayList<>();

        for (String id : IDs) {
            String email = userRepo.getEmail(id);
            String firstname = studentRepo.getFirstname(id);
            String surname = studentRepo.getSurname(id);
            String merit = studentRepo.getMerit(id);
            String demerit = studentRepo.getDemerit(id);
            String schoolID = studentRepo.getSchoolIDByStudentID(id);
            ArrayList<Subject> subjects = populateSubjects(id);
            boolean earnedCertificate = studentRepo.getCertificate(id);
            String schoolYear = studentRepo.getSchoolYear(id);
            Student student = new Student(
                    id, email, schoolID, firstname, surname, merit, demerit, subjects, earnedCertificate, schoolYear
            );

            students.add(student);
        }
        return students;
    }


    private ArrayList<Teacher> allTeachers() {
        ArrayList<String> IDs = teacherRepo.getAllTeacherIDs();
        ArrayList<Teacher> teachers = new ArrayList<>();

        for (String id : IDs) {
            String email = userRepo.getEmail(id);
            String firstname = teacherRepo.getFirstname(id);
            String surname = teacherRepo.getSurname(id);
            String schoolID = teacherRepo.getSchoolIDByTeacherID(id);
            String dob = teacherRepo.getDOB(id);


            Teacher teacher = new Teacher(
                    id, email, schoolID, dob, firstname, surname,  populateTeacherClassList(id)
            );

            teachers.add(teacher);
        }
        return teachers;
    }

    private ArrayList<Teacher> getTeachersWaitingReset(String schoolID) {
        ArrayList<String> ids = userRepo.getPasswordResetRequests(schoolID, "Teacher");
        ArrayList<Teacher> teachers = new ArrayList<>();

        for (String teacherID : ids) {
            String dob = teacherRepo.getDOB(teacherID);
            String firstname = teacherRepo.getFirstname(teacherID);
            String surname = teacherRepo.getSurname(teacherID);
            Teacher teacher = new Teacher(
                    teacherID,
                    userRepo.getEmail(teacherID),
                    userRepo.getSchoolID(teacherID),
                    dob,
                    firstname,
                    surname,
                    populateTeacherClassList(teacherID)
            );
            teachers.add(teacher);
        }

        return teachers;
    }

    */
}