package in.weargenius.sim900;

import in.weargenius.serialinterface.SerialCommunication;

public class CheckModuleStatus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new CheckModuleStatus().check());
	}
	public boolean check(){
		if(new SerialCommunication().sendCommand(new char[]{0x41,0x54,0x0D},8,true).toLowerCase().contains("ok"))
			return true;
		else
			return false;
	}
}
