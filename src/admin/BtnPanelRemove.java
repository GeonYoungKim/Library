package admin;

public class BtnPanelRemove {
	
	AdminBtnEventHandler adminBtnEventHandler;
	
	public BtnPanelRemove(AdminBtnEventHandler adminBtnEventHandler){
		this.adminBtnEventHandler=adminBtnEventHandler;
	}
	
	public void remove(){
		adminBtnEventHandler.btnPanel.removeAll();
	}

}
