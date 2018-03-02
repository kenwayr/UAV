import java.io.*;
import java.util.*;

/**
 * An Interface Class for the UAV Controller
 * Connects to WiFi onboard Pi Zero and sends/receives instructions
 * An active localhost on the Pi Zero is a must in order for this to run properly.
 * @author  Team UAV
 */
public class Interface{
    /**
     * Represents the local IP of the localhost on Pi Zero (Ex. 192.168.43.10)
     */
    public String hostAddr = "**Local IP of Wifi**";
    /**
     * Handles transmission of instruction as a String coded entry to Pi Zero
     */
    public String send(String message){
        return "OK";
    }
    /**
     * Handles transmission of a request as a String coded entry to Pi Zero
     */
    public String request(String message){
        return "OK";   
    }
}