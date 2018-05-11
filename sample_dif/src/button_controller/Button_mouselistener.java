package button_controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import button_model.Button_model;

public class Button_mouselistener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		Button_model temp = (Button_model)arg0.getSource();
		temp.set_mouseover_icon();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		Button_model temp = (Button_model)arg0.getSource();
		temp.reset_icon();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
