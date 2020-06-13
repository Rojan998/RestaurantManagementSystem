package com.example.mainbinamra;

public class userRegistrationHelper {


    public String UserName,
            Address,
            Email,
            Password,

            PhoneNumber;



    public userRegistrationHelper() {


    }

    public userRegistrationHelper(String name, String address, String email,
                                  String password,  String phoneNumber) {
        UserName = name;
        Address = address;
        Email = email;
        Password = password;

        PhoneNumber = phoneNumber;

    }
}
