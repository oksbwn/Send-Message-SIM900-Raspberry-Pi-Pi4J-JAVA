package in.weargenius.logging;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


public class LogMessage {
	Logger logger = Logger.getLogger(LogMessage.class);
	public static void main(String[] args) {
		new LogMessage(1,"WearGenius",null);
	}
	public LogMessage(int type, String message,Exception e){
		BasicConfigurator.configure();
		switch(type){
			case 0:
				logger.info(message);
				break;
			case 1:
				logger.error(message,e);
				break;
			default:
				break;
		}
	}
}
