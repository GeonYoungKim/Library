package admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlllistBtnEventHandler implements ActionListener {
	
	AdminBtnEventHandler adminBtnEventHandler;
	public AlllistBtnEventHandler(AdminBtnEventHandler adminBtnEventHandler){
		this.adminBtnEventHandler=adminBtnEventHandler;
	}
	
	public void actionPerformed(ActionEvent e){
		
		adminBtnEventHandler.listPanel.removeAll();
		adminBtnEventHandler.btnPanel.removeAll();
		adminBtnEventHandler.x=0;
		adminBtnEventHandler.actionPerformed(e);
	}

}
