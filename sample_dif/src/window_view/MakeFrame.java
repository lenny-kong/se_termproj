package window_view;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.ComponentEvent; 
import java.awt.event.ComponentListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.*;

class MainFrame extends JFrame implements ComponentListener, ActionListener{
	Left_Panel left_panel;
	Right_Panel right_panel;
	Left_ButtonPanel left_buttonpanel;
	Right_ButtonPanel right_buttonpanel;
	JButton left_file_load = new JButton("Load L");
	JButton left_file_edit = new JButton("Edit L");
	JButton left_file_save = new JButton("Save L");
	JButton right_file_load = new JButton("Load R");
	JButton right_file_edit = new JButton("Edit R");
	JButton right_file_save = new JButton("Save R");
	JTextArea leftText = new JTextArea("",5,50);
	JTextArea rightText = new JTextArea("�������ؽ�Ʈ");
	final JFileChooser fc = new JFileChooser();

	
	public MainFrame() {
		int width, height;
		width = 1000;
		height = 1000;
		setLayout(null);
		setSize(width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SE 18 NOM");
		
		left_panel = new Left_Panel();
		right_panel = new Right_Panel();
		left_panel.setBackground(Color.white);
		right_panel.setBackground(Color.white);
		left_panel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		right_panel.setBorder(BorderFactory.createLineBorder(Color.black, 1));		
		
		left_buttonpanel = new Left_ButtonPanel();
		right_buttonpanel = new Right_ButtonPanel();

		left_buttonpanel.setBackground(Color.YELLOW);
		right_buttonpanel.setBackground(Color.MAGENTA);
		
		leftText.setEditable(false);
		leftText.setAlignmentX(LEFT_ALIGNMENT);
		leftText.setLineWrap(true);
		leftText.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		rightText.setEditable(false);
		rightText.setAlignmentX(LEFT_ALIGNMENT);
		rightText.setLineWrap(true);
		rightText.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		left_buttonpanel.add(left_file_load);
		left_buttonpanel.add(left_file_edit);
		left_buttonpanel.add(left_file_save);
		right_buttonpanel.add(right_file_load);
		right_buttonpanel.add(right_file_edit);
		right_buttonpanel.add(right_file_save);
				
		left_file_load.addActionListener(this);
		left_file_edit.addActionListener(this);
		right_file_load.addActionListener(this);
		right_file_edit.addActionListener(this);
	
		this.add(left_panel);
		this.add(right_panel);
		this.add(leftText);
		this.add(rightText);
		this.add(left_buttonpanel);
		this.add(right_buttonpanel);
		this.addComponentListener(this);
	}
	public void componentResized(ComponentEvent e) 
	   { 
		  left_panel.setBounds((int)(getWidth() * 0.2), (int)(getHeight() * 0.1), 
			      (int)(getWidth() * 0.35), (int)(getHeight() * 0.8));
	  	  right_panel.setBounds((int)(getWidth() * 0.6), (int)(getHeight() * 0.1), 
	    	     (int)(getWidth() * 0.35), (int)(getHeight() * 0.8));
	      left_buttonpanel.setBounds((int)(getWidth() * 0.2), (int)(getHeight() * 0.05), 
	    	      (int)(getWidth()*0.35), (int)(getHeight() * 0.04));   
	      right_buttonpanel.setBounds((int)(getWidth() * 0.6), (int)(getHeight() * 0.05),
	    		  (int)(getWidth()*0.35), (int)(getHeight() * 0.04));
	      leftText.setBounds((int)(getWidth() * 0.2), (int)(getHeight() * 0.1), 
	      (int)(getWidth() * 0.35), (int)(getHeight() * 0.8));
	      rightText.setBounds((int)(getWidth() * 0.6), (int)(getHeight() * 0.1), 
	    	     (int)(getWidth() * 0.35), (int)(getHeight() * 0.8));
	   }
	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == left_file_edit) {
			this.leftText.setEditable(true);
		}
		if(e.getSource() == right_file_edit) {
			this.rightText.setEditable(true);;
		}
		if(e.getSource() == left_file_load) {
			int returnVal = fc.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				String filename = file.getAbsolutePath();
				try
				{
					FileReader reader = new FileReader(filename);
					BufferedReader br = new BufferedReader(reader);
					leftText.read(br, null);
					br.close();
					leftText.requestFocus();
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		}
		if(e.getSource() == right_file_load) {
			int returnVal = fc.showOpenDialog(null);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				String filename = file.getAbsolutePath();
				try
				{
					FileReader reader = new FileReader(filename);
					BufferedReader br = new BufferedReader(reader);
					rightText.read(br, null);
					br.close();
					rightText.requestFocus();
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		}
		
	} 
}
class Left_Panel extends JPanel{}
class Right_Panel extends JPanel{}
class Left_ButtonPanel extends JPanel{}
class Right_ButtonPanel extends JPanel{}

public class MakeFrame{
	
	public static void main(String[] args) {
		MainFrame f = new MainFrame();
		f.setVisible(true);
	}
}