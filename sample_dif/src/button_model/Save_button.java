package button_model;

import java.awt.Dimension;
import java.awt.Frame;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import button_controller.Load_button_actionlistener;
import button_controller.Save_button_actionlistener;
import compare_algorithm.String_object;
import data_model.GUI_data_model;
import window_view.Icon_image_load;

public class Save_button extends Button_model {

	private final String default_image_path = "icon_image/save/save.png";
	private final String pushed_image_path = "icon_image/save/save_push.png";
	private final String mouseover_image_path = "icon_image/save/save_mouseover.png";
	private GUI_data_model gui_data_model;

	public Save_button(GUI_data_model gui_data_model) {

		// construct and set default image.
		super(Icon_image_load.load_image("icon_image/save/save.png"));

		// load image.
		this.default_icon = Icon_image_load.load_image(default_image_path);
		this.pushed_icon = Icon_image_load.load_image(pushed_image_path);
		this.mouseover_icon = Icon_image_load.load_image(mouseover_image_path);

		// Set tooltip String.
		this.tooltip_text = "Save";

		// set current icon image default.
		this.current_icon = default_icon;

		// make buttons transparent.
		this.setContentAreaFilled(false);
		// delete borderline.
		this.setBorderPainted(false);
		// set button size.
		this.setPreferredSize(new Dimension(24, 24));

		Save_button_actionlistener actionlistener = new Save_button_actionlistener();
		this.addActionListener(actionlistener);
		this.setGui_data_model(gui_data_model);
	}

	public File getSaveFile(String fileName) {
		// create frame
		Frame f = new Frame();
		File fileTemp = null;
		String fileNameTemp;
		// create file dialog
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
		// create file filter
		fileChooser.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT (*.txt)", "txt");
		fileChooser.addChoosableFileFilter(filter);

		// recursive, input previous file name
		if (fileName != "") {
			fileChooser.setSelectedFile(new File(fileName));
		}

		// print file dialog 
		if (fileChooser.showSaveDialog(f) == JFileChooser.APPROVE_OPTION) {

			// if user doesn't add file extension
			fileNameTemp = fileChooser.getSelectedFile().toString();
			if (!fileNameTemp.endsWith(".txt") && !fileNameTemp.endsWith(".txt")) {
				fileNameTemp += ".txt";
			}

			// if file that has same name is exist
			fileTemp = new File(fileNameTemp);
			if (fileTemp.exists()) {
				int r = JOptionPane.showConfirmDialog(f, fileTemp.getName() + "이(가) 이미 있습니다. 바꾸시겠습니까?", "다른 이름으로 저장 확인",
						JOptionPane.YES_NO_OPTION);
				if (r == JOptionPane.NO_OPTION) {
					// recursive
					getSaveFile(fileNameTemp);
				}
			}

		}

		return fileTemp;
	}

	public void savefile(File file, List<String_object> list) throws IOException {
		int cnt = 0;
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		for (cnt = 0; cnt != list.size(); cnt++) {
			bw.write(list.get(cnt).get_string());
			bw.newLine();
		}
		bw.close();
	}
	public void text_to_list(int value){		
		if(value == 1) {
			StringTokenizer left_token = new StringTokenizer(gui_data_model.getLeft_text_area().getText(), "\n");
			// tokenize for insert that  data in list
			int cnt;
			gui_data_model.getLeft_list().clear();
			// delete before data in left or right list
			
			for (cnt = left_token.countTokens(); cnt > 0; cnt--) {
				gui_data_model.getLeft_list().add(new String_object(left_token.nextToken()));
			}
		}
		if(value == 0) {
			StringTokenizer right_token = new StringTokenizer(gui_data_model.getRight_text_area().getText(), "\n");
			// tokenize for insert that  data in list
			int cnt;
			gui_data_model.getRight_list().clear();
			// delete before data in left or right list
			
			for (cnt = right_token.countTokens(); cnt > 0; cnt--) {
				gui_data_model.getLeft_list().add(new String_object(right_token.nextToken()));
			}
		}
	}

	public GUI_data_model getGui_data_model() {
		return gui_data_model;
	}

	public void setGui_data_model(GUI_data_model gui_data_model) {
		this.gui_data_model = gui_data_model;
	}
}
