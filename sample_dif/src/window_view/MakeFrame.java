package window_view;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.ComponentEvent; 
import java.awt.event.ComponentListener;

import javax.swing.*;
import button_text_generator.*;
class MainFrame extends JFrame implements ComponentListener{
	final JFileChooser fc = new JFileChooser();
	JPanel left_panel;
	JPanel right_panel;
	
	public MainFrame() {
		int width, height;
		width = 1000;
		height = 1000;
		setLayout(null);
		setSize(width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SE 18 NOM");
		
		left_panel = new Button_text_panel();
		right_panel = new Button_text_panel();
		left_panel.setBackground(Color.white);
		right_panel.setBackground(Color.white);
		//make both panels
		this.add(left_panel);
		this.add(right_panel);
		//add both panels to main frame
		this.addComponentListener(this);
	}
	public void componentResized(ComponentEvent e) 
	   {
		  left_panel.setBounds((int)(getWidth() * 0.2), (int)(getHeight() * 0.1), 
			      (int)(getWidth() * 0.35), (int)(getHeight() * 0.8));
	  	  right_panel.setBounds((int)(getWidth() * 0.6), (int)(getHeight() * 0.1), 
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
}


public class MakeFrame{
	
	public static void main(String[] args) {
		MainFrame f = new MainFrame();
		f.setVisible(true);
	}
}