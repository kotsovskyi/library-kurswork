package com.bionic.edu.controller;

import javax.inject.Named;

@Named
public class ViewController {

    public String redirectToBooksView() {
        return "books";
    }

    public String redirectToMembersView(){
        return "members";
    }
}
