package gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Frame1 extends JFrame implements ActionListener,MouseListener
{
    JPanel panel;
    ImageIcon img,room,service,pd,employee;
    JButton guestB,adminB;
    JLabel label,bgImg,rooml,servicel,pdl,employeel;

    public Frame1()
    {

        super("Hotel Name");
        this.setSize(800,600);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel=new JPanel();
        panel.setLayout(null);

        img=new ImageIcon(this.getClass().getResource("Frame1.png"));
        bgImg=new JLabel(img);
        bgImg.setLayout(null);
        bgImg.setSize(this.getSize());
        this.add(bgImg);
       
        label = new JLabel("Welcome To Our Hotel");
		label.setBounds(240,180,500,70);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Script MT Bold",Font.PLAIN,40));
		bgImg.add(label);

        guestB=new JButton("Book Room");
        guestB.setBounds(350,400,110,40);
        guestB.addActionListener(this);
        guestB.addMouseListener(this);
        guestB.setFocusable(false);
        bgImg.add(guestB);

        adminB=new JButton("Admin Login");
        adminB.setBounds(350,320,110,40);
        adminB.addActionListener(this);
        adminB.addMouseListener(this);
        adminB.setFocusable(false);
        bgImg.add(adminB);

         this.add(panel);

    }

    public void actionPerformed(ActionEvent ae) 
    {
        if(ae.getSource()==guestB)
        {
           //showMessageDialog(null, " Work On Progress");
           Frame4 f4=new Frame4();
           f4.setVisible(true);
           this.setVisible(false);
        }
        else if(ae.getSource()==adminB) 
        {
            Frame2 f2=new Frame2();
            f2.setVisible(true);
            this.setVisible(false);
        }
    }
    
    public void mouseClicked(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseEntered(MouseEvent me)
	{
		if(me.getSource() == guestB)
		{
			guestB.setBackground(Color.black);
			guestB.setForeground(Color.green);
		}
		else if(me.getSource() == adminB)
		{
			adminB.setBackground(Color.black);
			adminB.setForeground(Color.GREEN);
		}

	}
	public void mouseExited(MouseEvent me)
	{
		if(me.getSource() == guestB)
		{
			guestB.setBackground(Color.WHITE);
			guestB.setForeground(Color.BLACK);
		}
		else if(me.getSource() == adminB)
		{
			adminB.setBackground(Color.WHITE);
			adminB.setForeground(Color.BLACK);
		}
	
	}
}

