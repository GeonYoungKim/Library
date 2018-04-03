package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlllistBtnEventHandler implements ActionListener {
	
	ClientBtnEventHandler2 clientBtnEventHandler2;
	
	public AlllistBtnEventHandler(ClientBtnEventHandler2 clientBtnEventHandler2){
		this.clientBtnEventHandler2=clientBtnEventHandler2;
	}
	
	public void actionPerformed(ActionEvent e){
		clientBtnEventHandler2.listPanel.removeAll();
		clientBtnEventHandler2.btnPanel.removeAll();
		clientBtnEventHandler2.x=0;
		
		clientBtnEventHandler2.actionPerformed(e);
	}

}
