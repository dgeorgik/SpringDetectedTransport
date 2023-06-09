package com.example.webProjectCNN_jsp.model;

public class Image {

    private String imageName;

    public Image(){

    }
    public Image(String imageName) {
        this.imageName = imageName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
