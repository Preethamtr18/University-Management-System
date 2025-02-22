package university.management.system;

import com.sun.source.tree.WhileLoopTree;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class StudentLeave extends JFrame implements ActionListener {

    Choice choiceRollNo,choTime;
    JDateChooser seldate;
    JButton submit,cancel;

    StudentLeave(){

        getContentPane().setBackground(new Color(210,232,252));

        JLabel heading=new JLabel("Apply Leave (Student)");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);

        JLabel RollNoSE=new JLabel("Search By Roll Number");
        RollNoSE.setBounds(60,100,200,20);
        RollNoSE.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(RollNoSE);

        choiceRollNo=new Choice();
        choiceRollNo.setBounds(60,130,200,20);
        add(choiceRollNo);

        try{
            conn c=new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from student");

            while(resultSet.next()){
                choiceRollNo.add(resultSet.getString("rollno"));

            }

        }catch (Exception e){
            e.printStackTrace();

        }

        JLabel lbldate=new JLabel("Date");
        lbldate.setBounds(60,180,200,20);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbldate);

        seldate=new JDateChooser();
        seldate.setBounds(60,210,200,25);
        add(seldate);

        JLabel time=new JLabel("Time Duration");
        time.setBounds(60,260,200,20);
        time.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(time);

        choTime=new Choice();
        choTime.setBounds(60,290,200,20);
        choTime.add("Full Day");
        choTime.add("Half Day");
        add(choTime);

        submit=new JButton("Submit");
        submit.setBounds(60,350,100,25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBounds(200,350,100,25);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);



        setSize(500,550);
        setLocation(550,100);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String rollno=choiceRollNo.getSelectedItem();
            String date=((JTextField)seldate.getDateEditor().getUiComponent()).getText();
            String time=choTime.getSelectedItem();

            String q="insert into studentleave values('"+rollno+"','"+date+"','"+time+"')";
            try{
                conn c=new conn();
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Leave Confirmed");
            }catch (Exception E){
                E.printStackTrace();
            }
        }else{//cancel
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new StudentLeave();
    }
}
