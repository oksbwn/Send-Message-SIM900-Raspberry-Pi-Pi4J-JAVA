package in.weargenius.sim900;

import in.weargenius.serialinterface.SerialCommunication;

public class SetReceiverNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void sendMessage(String no,String Message){
		System.out.println(new SerialCommunication().sendCommand(new char[]{0x41,0x54,0x2B,0x43,0x4D,0x47,0x53,0x3D,0x22,0x2B,0x39,0x31,0x39,0x31,0x32,0x34,0x38,0x35,0x36,0x31,0x34,0x33,0x22}
		,22,false).toLowerCase());
		System.out.println(new SerialCommunication().sendCommand(new char[]{0x0D}
		,5,false).toLowerCase());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Done Configing No");
		
			System.out.println(new SerialCommunication().sendCommand(new char[]{0x48,0x65,0x6C,0x6C,0x6F,0x1A}
		,30,false).toLowerCase());
			System.out.println("Done Sending Message");
	}
}
