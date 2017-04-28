package com.example.sterlingortiz.smithguru;

/**
 * Created by Sterling Ortiz on 4/28/2017.
 */

public class UserAccounts {
    private String serviceProvider;
    private String acctUsername;
    private String acctPassword;

    public UserAccounts(String accountUsername, String accountPassword, String accountEmail){
        serviceProvider = accountUsername;
        acctUsername = accountPassword;
        acctPassword = accountEmail;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public String getAcctUsername() {
        return acctUsername;
    }

    public void setAcctUsername(String acctUsername) {
        this.acctUsername = acctUsername;
    }

    public String getAcctPassword() {
        return acctPassword;
    }

    public void setAcctPassword(String acctPassword) {
        this.acctPassword = acctPassword;
    }
}