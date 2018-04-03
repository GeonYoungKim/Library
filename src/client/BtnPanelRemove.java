package client;

public class BtnPanelRemove {
	
	ClientBtnEventHandler2 clientBtnEventHandler2;
	
	public BtnPanelRemove(ClientBtnEventHandler2 clientBtnEventHandler2){
		this.clientBtnEventHandler2=clientBtnEventHandler2;
	}
	
	public void remove(){
		clientBtnEventHandler2.btnPanel.removeAll();
	}

}
