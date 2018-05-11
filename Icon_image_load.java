package window_view;

import javax.swing.ImageIcon;

public class Icon_image_load {
	
	private ImageIcon edit_unpushed_icon;
	
	public Icon_image_load() 
	{
		this.edit_unpushed_icon = new ImageIcon("icon_image/edit_unpushed_icon.jpg");
	}
	
	static public ImageIcon load_image(String filepath) 
	{
		ImageIcon icon = new ImageIcon(filepath);
		return icon;
	}

	public ImageIcon getEdit_unpushed_icon() 
	{
		return edit_unpushed_icon;
	}
}
