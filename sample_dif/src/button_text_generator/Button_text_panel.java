package button_text_generator;
import java.awt.Color;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import button_model.*;

public class Button_text_panel extends JPanel implements ComponentListener{
	JPanel button_panel;
	JPanel text_panel;
	private Edit_button edit_button;
	//private Load_button load_button;
	//private Save_button save_button;
	public JTextArea text_area;
	
	public Button_text_panel() {
		button_panel = new JPanel();
		text_panel = new JPanel();
		button_panel.setBackground(Color.red);
		text_panel.setBackground(Color.green);
		
		edit_button = new Edit_button("edit",null,null); //->to be changed
		//save_button = new Save_button("save");
		//load_button = new Load_button("load");
		button_panel.add(edit_button);
		//button_panel1.add(load_button);
		//button_panel1.add(save_button);
		
		this.add(button_panel);
		this.add(text_panel);
		this.addComponentListener(this);
	}
	
	
	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
	    button_panel.setBounds(0,0, (int)(getWidth()), (int)(getHeight() * 0.08));   
	    text_panel.setBounds(0, (int)(getHeight() * 0.1), (int)(getWidth()), (int)(getHeight() * 0.91));
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
