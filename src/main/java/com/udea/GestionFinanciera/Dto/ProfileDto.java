package com.udea.GestionFinanciera.Dto;

import com.udea.GestionFinanciera.Entity.Profile;

import java.util.Date;

public class ProfileDto {

    private Long id;
    private String image;
    private String phone;

    public Profile toEntity(){
        Profile profile = new Profile();
        profile.setId(this.id);
        profile.setImage(this.image);
        profile.setPhone(this.phone);
        return profile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
