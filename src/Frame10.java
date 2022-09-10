
import java.awt.*;
import java.lang.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class Frame10 extends JFrame implements ActionListener, MouseListener
{
    JLabel bgImgLabel,frameLabel,nameLabel,userNameLabel,passLabel,securityQuesLabel;
    ImageIcon bgImg,showPassIcon,showPassIcon2;
    JButton back,confirm,showPassButton;
    JTextField nameTextField,userNameTextField,securityQuesTextField;
    JPasswordField passField;
    JPanel panel;
    admin admin;

    Frame10()
    {
        super("Frame10 Admin Profile");
        this.setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);

        bgImg=new ImageIcon(this.getClass().getResource("Frame10.jpg"));
        bgImgLabel=new JLabel(bgImg);
        bgImgLabel.setSize(this.getSize());
        panel.add(bgImgLabel);

        frameLabel=new JLabel("*****  | Admin Profile |  *****");
        frameLabel.setBounds(270,15,700,80);
        frameLabel.setForeground(Color.black);
        frameLabel.setFont(new Font("Script MT Bold",Font.PLAIN,40));
        bgImgLabel.add(frameLabel);

        nameLabel=new JLabel("Name");
        nameLabel.setBounds(120,120,200,35);
        nameLabel.setForeground(Color.black);
        nameLabel.setFont(new Font("Times New Roman",Font.BOLD,21));
        bgImgLabel.add(nameLabel);

        nameTextField=new JTextField();
        nameTextField.setBounds(320,120,180,30);
        nameTextField.setFont(new Font("Times New Roman",Font.BOLD,17));
        bgImgLabel.add(nameTextField);

        userNameLabel=new JLabel("User Name");
        userNameLabel.setBounds(120,170,200,35);
        userNameLabel.setForeground(Color.black);
        userNameLabel.setFont(new Font("Times New Roman",Font.BOLD,21));
        bgImgLabel.add(userNameLabel);

        userNameTextField=new JTextField();
        userNameTextField.setBounds(320,170,180,30);
        userNameTextField.setFont(new Font("Times New Roman",Font.BOLD,17));
        bgImgLabel.add(userNameTextField);

        passLabel=new JLabel("Password");
        passLabel.setBounds(120,220,200,35);
        passLabel.setForeground(Color.black);
        passLabel.setFont(new Font("Times New Roman",Font.BOLD,21));
        bgImgLabel.add(passLabel);

        passField=new JPasswordField();
        passField.setBounds(320,220,180,30);
        passField.setFont(new Font("Times New Roman",Font.BOLD,17));
        bgImgLabel.add(passField);

        showPassIcon=new ImageIcon(this.getClass().getResource("showPassIcon.jpg"));
        showPassIcon2=new ImageIcon(this.getClass().getResource("showPass2.jpg"));
        showPassButton=new JButton(showPassIcon);
        showPassButton.setBounds(478,220,70,30);
        showPassButton.addMouseListener(this);
        bgImgLabel.add(showPassButton);

        securityQuesLabel=new JLabel("Security Question");
        securityQuesLabel.setBounds(120,270,200,35);
        securityQuesLabel.setForeground(Color.black);
        securityQuesLabel.setFont(new Font("Times New Roman",Font.BOLD,21));
        bgImgLabel.add(securityQuesLabel);

        securityQuesTextField=new JTextField();
        securityQuesTextField.setBounds(320,270,180,30);
        securityQuesTextField.setFont(new Font("Times New Roman",Font.BOLD,17));
        bgImgLabel.add(securityQuesTextField);

        back=new JButton("Back");
        back.setBounds(50,480,75,40);
        back.addActionListener(this);
        back.addMouseListener(this);
        back.setFocusable(false);
        bgImgLabel.add(back);

        confirm=new JButton("Confirm");
        confirm.setBounds(760,480,90,40);
        confirm.addActionListener(this);
        confirm.addMouseListener(this);
        confirm.setFocusable(false);
        bgImgLabel.add(confirm);

        this.add(panel);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            Frame3p f3p=new Frame3p();
            f3p.setVisible(true);
            this.setVisible(false);

        }
        else if(ae.getSource()==confirm)
        {

            Frame3p f3p=new Frame3p();
            f3p.setVisible(true);
            this.setVisible(false);
            //showMessageDialog(null,"Successfully Updated! ");
        }
    }
    public void mouseClicked(MouseEvent me){}
    public void mousePressed(MouseEvent me){}
    public void mouseReleased(MouseEvent me){}
    public void mouseEntered(MouseEvent me)
    {
        if(me.getSource() == back)
        {
            back.setBackground(Color.black);
            back.setForeground(Color.RED);
        }
        else if(me.getSource() == confirm)
        {
            confirm.setBackground(Color.black);
            confirm.setForeground(Color.green);
        }
    }
    public void mouseExited(MouseEvent me)
    {
        if(me.getSource() == back)
        {
            back.setBackground(Color.WHITE);
            back.setForeground(Color.BLACK);
        }
        else if(me.getSource() == confirm)
        {
            confirm.setBackground(Color.WHITE);
            confirm.setForeground(Color.BLACK);
        }
    }
}