package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame implements ActionListener {
    Main_class(){
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1540,750,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        add(img);

        JMenuBar mb=new JMenuBar();

        //new Information

        JMenu newInfo=new JMenu("New Information");
        newInfo.setForeground(Color.BLACK);
        newInfo.addActionListener(this);
        mb.add(newInfo);

        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInfo.add(facultyInfo);

        JMenuItem studentInfo =new JMenuItem("New Student Information");
        studentInfo.setBackground(Color.WHITE);
        studentInfo.addActionListener(this);
        newInfo.add(studentInfo);

        // Details

        JMenu details=new JMenu("View Details");
        details.setForeground(Color.BLACK);
        details.addActionListener(this);
        mb.add(details);

        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        JMenuItem studentdetails =new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.WHITE);
        studentdetails.addActionListener(this);
        details.add(studentdetails);

        //Leave
        JMenu leave=new JMenu("Apply Leave");
        leave.setForeground(Color.BLACK);
        leave.addActionListener(this);
        mb.add(leave);

        JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
        facultyLeave.setBackground(Color.WHITE);
        facultyLeave.addActionListener(this);
        leave.add(facultyLeave);

        JMenuItem studentLeave =new JMenuItem("Student Leave");
        studentLeave.setBackground(Color.WHITE);
        studentLeave.addActionListener(this);
        leave.add(studentLeave);

        //Leave Details
        JMenu leaveDetails=new JMenu("Leave Details");
        leaveDetails.setForeground(Color.BLACK);
        leaveDetails.addActionListener(this);
        mb.add(leaveDetails);

        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setBackground(Color.WHITE);
        facultyLeaveDetails.addActionListener(this);
        leaveDetails.add(facultyLeaveDetails);

        JMenuItem studentLeaveDetails =new JMenuItem("Student Leave Details");
        studentLeaveDetails.setBackground(Color.WHITE);
        studentLeaveDetails.addActionListener(this);
        leaveDetails.add(studentLeaveDetails);

        //Exams
        JMenu exam=new JMenu("Examination");
        exam.setForeground(Color.BLACK);
        exam.addActionListener(this);
        mb.add(exam);

        JMenuItem ExaminationDetails = new JMenuItem("Examination Results");
        ExaminationDetails.setBackground(Color.WHITE);
        ExaminationDetails.addActionListener(this);
        exam.add(ExaminationDetails);

        JMenuItem EnterMarks =new JMenuItem("Enter Marks");
        EnterMarks.setBackground(Color.WHITE);
        EnterMarks.addActionListener(this);
        exam.add(EnterMarks);

        //Update Info
        JMenu updateInfo=new JMenu("Update Details");
        updateInfo.setForeground(Color.BLACK);
        updateInfo.addActionListener(this);
        mb.add(updateInfo);

        JMenuItem updatefacultyInfo = new JMenuItem("Update Faculty Details");
        updatefacultyInfo.setBackground(Color.WHITE);
        updatefacultyInfo.addActionListener(this);
        updateInfo.add(updatefacultyInfo);

        JMenuItem updatestudentInfo =new JMenuItem("Update Student Details");
        updatestudentInfo.setBackground(Color.WHITE);
        updatestudentInfo.addActionListener(this);
        updateInfo.add(updatestudentInfo);

        //fee
        JMenu fee=new JMenu("Fee Details");
        fee.setForeground(Color.BLACK);
        fee.addActionListener(this);
        mb.add(fee);

        JMenuItem feeStructure = new JMenuItem("Fee Structure");
        feeStructure.setBackground(Color.WHITE);
        feeStructure.addActionListener(this);
        fee.add(feeStructure);

        JMenuItem feeForm =new JMenuItem("Student Fee Form");
        feeForm.setBackground(Color.WHITE);
        feeForm.addActionListener(this);
        fee.add(feeForm);

        //Utility
        JMenu utility=new JMenu("Utility");
        utility.setForeground(Color.BLACK);
        utility.addActionListener(this);
        mb.add(utility);

        JMenuItem Calculator = new JMenuItem("Calculator");
        Calculator.setBackground(Color.WHITE);
        Calculator.addActionListener(this);
        utility.add(Calculator);

        JMenuItem NotePad =new JMenuItem("NotePad");
        NotePad.setBackground(Color.WHITE);
        NotePad.addActionListener(this);
        utility.add(NotePad);

        //about
        JMenu about=new JMenu("About");
        about.setForeground(Color.BLACK);
        about.addActionListener(this);
        mb.add(about);

        JMenuItem About = new JMenuItem("about");
        About.setBackground(Color.WHITE);
        About.addActionListener(this);
        about.add(About);

        //Exit
        JMenu Exit=new JMenu("Exit");
        Exit.setForeground(Color.BLACK);
        Exit.addActionListener(this);
        mb.add(Exit);

        JMenuItem exit = new JMenuItem("Exit");
        exit.setBackground(Color.WHITE);
        exit.addActionListener(this);
        Exit.add(exit);




        setJMenuBar(mb);


        setSize(1540,850);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String sm=e.getActionCommand();
        if(sm.equals("Exit")){
            System.exit(15);
        } else if (sm.equals("Calculator")) {
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (sm.equals("NotePad")) {
            try{
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (sm.equals("New Faculty Information")) {
            new Addfaculty();
            
        } else if (sm.equals("New Student Information")) {
            new AddStudent();
            
        } else if (sm.equals("View Faculty Details")) {
            new teacherDetail();
            
        } else if (sm.equals("View Student Details")) {
            new studentDetail();

        } else if (sm.equals("Faculty Leave")){
            new TeacherLeave();

        } else if (sm.equals("Student Leave")) {
            new StudentLeave();

        } else if (sm.equals("Faculty Leave Details")) {
            new TeacherLeaveDetails();
            
        } else if (sm.equals("Student Leave Details")) {
            new StudentLeaveDetails();
            
        } else if (sm.equals("Update Faculty Details")) {
            new UpdateTeacher();
            
        } else if (sm.equals("Update Student Details")) {
            new updateStudent();

        } else if (sm.equals("Enter Marks")) {
            new EnterMarks();

        } else if (sm.equals("Examination Results")) {
            new ExaminationDetails();

        } else if (sm.equals("Fee Structure")) {
            new FeeStructure();

        }else if (sm.equals("Student Fee Form")){
            new StudentFeeForm();
        } else if (sm.equals("about")) {
            new About();

        }
    }

    public static void main(String[] args) {
        new Main_class();
    }
}
