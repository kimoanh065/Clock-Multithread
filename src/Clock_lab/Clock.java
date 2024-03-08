package Clock_lab;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JTextField;

public class Clock extends JFrame {
    private JLabel timelabel;
    private Timer timer;
    private int sub = 0; 
    private JTextField txtOanhsClock;

    public Clock() {
        Container con = getContentPane();
        getContentPane().setLayout(null);
        JLabel lbbackground = new JLabel();
        lbbackground.setBackground(new Color(255, 250, 250));
        lbbackground.setBounds(0, 0, 433, 263);
        lbbackground.setOpaque(true);
        
        
        timelabel = new JLabel();
        timelabel.setForeground(Color.ORANGE);
        timelabel.setHorizontalAlignment(SwingConstants.CENTER);
        timelabel.setFont(new Font("Courier New", Font.BOLD, 36));
        timelabel.setBounds(95, 44, 203, 78);

        JButton btnNewButton = new JButton("Open");
        btnNewButton.setBackground(new Color(224, 255, 255));
        btnNewButton.setFont(new Font("Courier New", Font.BOLD, 16));
        btnNewButton.setBounds(254, 179, 85, 21);
        

        JLabel lblNewLabel = new JLabel("Select timezone");
        lblNewLabel.setForeground(new Color(124, 252, 0));
        lblNewLabel.setBackground(new Color(255, 255, 204));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Courier New", Font.BOLD, 15));
        lblNewLabel.setBounds(64, 153, 143, 13);
        

        JComboBox comboBox = new JComboBox();
        comboBox.setBackground(new Color(255, 255, 255));
        comboBox.setBounds(64, 179, 143, 21);
        String[] timeZones = {"-12:00", "-11:00", "-10:00", "-09:00", "-08:00", "-07:00", "-06:00",
                "-05:00", "-04:00", "-03:00", "-02:00", "-01:00", "+00:00 (UTC)", "+01:00", "+02:00",
                "+03:00", "+04:00", "+05:00", "+06:00", "+07:00", "+08:00", "+09:00", "+10:00", "+11:00",
                "+12:00", "+13:00"};
        comboBox.setModel(new DefaultComboBoxModel(timeZones));
        comboBox.setSelectedItem("+07:00");
        
        txtOanhsClock = new JTextField();
        txtOanhsClock.setForeground(SystemColor.textHighlight);
        txtOanhsClock.setFont(new Font("Courier New", Font.BOLD, 15));
        txtOanhsClock.setText("Oanh's Clock");
        txtOanhsClock.setBounds(10, 10, 118, 19);
        getContentPane().add(txtOanhsClock);
        txtOanhsClock.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("UTC");
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 13));
        lblNewLabel_1.setForeground(new Color(255, 0, 0));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1.setBounds(10, 184, 44, 13);
        getContentPane().add(lblNewLabel_1);

        timer = new Timer(1000, e -> updateTime());
        timer.start();

        Date currenttime = new Date();
        SimpleDateFormat Format_time = new SimpleDateFormat("HH:mm:ss");
        timelabel.setText(Format_time.format(currenttime));

        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedTimeZone = (String) comboBox.getSelectedItem();
                String[] split = selectedTimeZone.split(":");
                sub = Integer.parseInt(split[0]) - 7;
                
                updateTime();
            }
        });
        con.add(txtOanhsClock);
        con.add(btnNewButton);
        con.add(timelabel);
        con.add(comboBox);
        con.add(lblNewLabel);
        con.add(lbbackground);
        
        

        setSize(400, 300);
        setTitle("Đồng hồ");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    public void updateTime() {
        Date currenttime = new Date();
        SimpleDateFormat Format_time = new SimpleDateFormat("HH:mm:ss");
        currenttime.setTime(currenttime.getTime() + (sub * 60 * 60 * 1000));
        timelabel.setText(Format_time.format(currenttime));
    }

    public static void main(String[] args) {
        new Clock();
    }
}