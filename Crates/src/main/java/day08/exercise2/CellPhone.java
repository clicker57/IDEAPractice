package day08.exercise2;

import org.springframework.util.StringUtils;

import static java.lang.Thread.sleep;

public class CellPhone extends Telephone implements Elec, Net {
    private boolean powerStatus = false;
    private String netType = "unknown";

    public CellPhone(String netType) {
        this.netType = netType;
    }

    public CellPhone() {}

    public boolean on() {
        if (!powerStatus) {
            powerStatus = true;
            System.out.println("CellPhone has powered on.");
        }
        return powerStatus;
    }

    public boolean off() {
        if (powerStatus) {
            powerStatus = false;
            System.out.println("CellPhone has powered off.");
        }
        return powerStatus;
    }

    public String getInterNet() {
        return netType;
    }

    public void sendCall(String name) {
        if (powerStatus) {
            System.out.println("I'm making a call to " + name);
        } else {
            System.out.println("The cellphone is off. Please power it on first.");
        }
    }

    public void getCall(String name) {
        if (powerStatus) {
            System.out.println(name + " is calling me now.");
        } else {
            System.out.println("The cellphone keeps silent.");
        }
    }

    public void sendSMS(String name, String text) {
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(text)) {
            throw new RuntimeException("Cannot send sms to no name.");
        }
        if (powerStatus) {
            System.out.println("Message [" + text + "] is sending to " + name);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("SMS is sent.");
        } else {
            System.out.println("The cellphone is off and shows nothing.");
        }
    }
}
