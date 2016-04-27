package in.weargenius.main;

import in.weargenius.sim900.CheckModuleStatus;
import in.weargenius.sim900.ConfigureTextMode;
import in.weargenius.sim900.SetReceiverNo;

public class MainCalss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(new CheckModuleStatus().check()){
			System.out.print("In");
			System.out.println(new ConfigureTextMode().config());	
			new SetReceiverNo().sendMessage("","");
		}
	}

}
