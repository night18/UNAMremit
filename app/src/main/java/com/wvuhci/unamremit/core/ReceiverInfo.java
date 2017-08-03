package com.wvuhci.unamremit.core;

/**
 * To restore the information of the receiver
 */

public class ReceiverInfo {
    private String firstName;
    private String lastName;
    private int pickupMethod;
    private String bankName;
    private String clabe;

    /**
     * @param name The first name of the receiver
     */
    public void setFirstName(String name){
        firstName = name;
    }

    /**
     * @return receiver's first name
     */
    public String getFirstName(){
        return firstName;
    }

    /**
     * @param name The last name of the receiver
     */
    public void setLastName(String name){
        lastName = name;
    }


    /**
     * @return receiver's last name
     */
    public String getLastName(){
        return lastName;
    }


    /**
     * @param method  0: bank deposit, 1:cash pickup
     */
    public void setPickUpMethod(int method){
        pickupMethod = method;
    }

    /**
     * @return receiver's pickup method
     */
    public int getPickUpMethod(){
        return pickupMethod;
    }

    /**
     * @param bank The bank name which receiver get money
     */
    public void setBankName(String bank){
        bankName = bank;
    }

    /**
     * @return The bank name which receiver get money
     */
    public String getBankName(){
        return bankName;
    }


    public void setClabe(String clabe){
        this.clabe = clabe;
    }

    public String getClabe(){
        return clabe;
    }



}
