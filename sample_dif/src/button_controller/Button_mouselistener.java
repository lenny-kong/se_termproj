package button_controller;

import java.awt.MouseInfo;
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
		Button_model source = (Button_model)arg0.getSource();
		source.set_mouseover_icon();
		
		//Show tooltip on current mouse location.
		source.show_tooltip(MouseInfo.getPointerInfo().getLocation());
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		Button_model source = (Button_model)arg0.getSource();
		source.reset_icon();
		
		//Hide tooltip.
		source.hide_tooltip();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Button_model source = (Button_model)e.getSource();
		source.set_pushed_icon();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		Button_model source = (Button_model)e.getSource();
		source.reset_icon();
	}

}
