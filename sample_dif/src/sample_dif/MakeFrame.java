package sample_dif;
import java.awt.Color;
import java.awt.Dimension; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.ComponentEvent; 
import java.awt.event.ComponentListener; 
import javax.swing.*;

class MainFrame extends JFrame implements ComponentListener{
	Panel1 panel1;
	Panel2 panel2;
	
	public MainFrame() {
		int width, height;
		width = 1000;
		height = 1000;
		setLayout(null);
		setSize(width,height);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SE 18 NOM");
		
		panel1 = new Panel1();
		panel2 = new Panel2();
//		panel1.setBounds(200,100,300,800);
//		panel2.setBounds(600,100,300,800);
		panel1.setBackground(Color.red);
		panel2.setBackground(Color.blue);
		add(panel1);
		add(panel2);
		addComponentListener(this); 

	}
	public void componentResized(ComponentEvent e) 
	   { 
	      panel1.setBounds((int)(getWidth() * 0.2), (int)(getHeight() * 0.1), 
	      (int)(getWidth() * 0.35), (int)(getHeight() * 0.8));        
	      panel2.setBounds((int)(getWidth() * 0.6), (int)(getHeight() * 0.1), 
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


class Panel1 extends JPanel{}
class Panel2 extends JPanel{}



public class MakeFrame{
	
	public static void main(String[] args) {
		MainFrame f = new MainFrame();
		f.setVisible(true);
	}
}