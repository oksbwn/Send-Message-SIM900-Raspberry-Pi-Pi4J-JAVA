package in.weargenius.sim900;

import in.weargenius.serialinterface.SerialCommunication;

public class ConfigureTextMode {
	public boolean config(){
		if(new SerialCommunication().sendCommand(new char[]{0x41,0x54,0x2B,0x43,0x4D,0x47,0x46,0x3D,0x31,0x0D},15,false).toLowerCase().contains("ok"))
			return true;
		else
			return false;
	}
}
