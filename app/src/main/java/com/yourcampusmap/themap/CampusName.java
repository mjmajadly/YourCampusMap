package com.yourcampusmap.themap;

public class CampusName {
    private String state;
    private String uni;

    public CampusName(String state, String uni) {
        this.state = state;
        this.uni = uni;
    }
// whats going on
    public String getRank() {
        return this.state;
    }

    public String getCountry() {
        return this.uni;
    }

}
