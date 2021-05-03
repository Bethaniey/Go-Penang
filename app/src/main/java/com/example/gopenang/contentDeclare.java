package com.example.gopenang;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class contentDeclare {

    public Bitmap image;
    public String name;
    public String description;
    public String operatingHour;
    public String address;

    public contentDeclare() {}

    public contentDeclare(String name, String description, String operatingHour, String address, Bitmap image) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.operatingHour = operatingHour;
        this.address = address;
    }

    public Bitmap getImage() {
        return image;
    }

    //Convert image retrieve in db to bitmap
    public void setImage (byte[] imageBlob) {
        byte[] bytes = imageBlob;
        this.image = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOperatingHour() {
        return operatingHour;
    }

    public void setOperatingHour(String operatingHour) {
        this.operatingHour = operatingHour;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
