package in.weargenius.serialinterface;
import in.weargenius.logging.LogMessage;

import com.pi4j.wiringpi.Serial;

public class SerialCommunication {
	public static void main(String args[]){
		System.out.println(new SerialCommunication().sendCommand(new char[]{0x41,0x54,0x0D},8,true));
	}
	public String sendCommand(char[] commandBuffer,int expectedBytes,boolean printResponseToConsole){
        try {
			char[] responseBytes= new char[expectedBytes];
			int fd = Serial.serialOpen(Serial.DEFAULT_COM_PORT,9600);
			if (fd == -1) {
			    new LogMessage(0,"Failed to open Serial Port",null);
			    return null;
			}
			for(int bytesCounter=0;bytesCounter<commandBuffer.length;bytesCounter++){
				
				Serial.serialPutchar(fd,commandBuffer[bytesCounter]);
			}
				Thread.sleep(1000);
			int dataavail = Serial.serialDataAvail(fd);           
			int bytesCounter=0;
			while(dataavail !=0 && bytesCounter<expectedBytes) {
				responseBytes[bytesCounter] =(char) Serial.serialGetchar(fd);
			    dataavail = Serial.serialDataAvail(fd);
			    bytesCounter++;
			}
			bytesCounter=0;
			if(printResponseToConsole){
				for (int k=0;k<expectedBytes;k++)
					System.out.println((char)responseBytes[k]);
			}
			return new String(responseBytes);
			} catch (InterruptedException e) {
			    new LogMessage(1,"Error Fetching Data",e);
		}
		return null;
	}
}
