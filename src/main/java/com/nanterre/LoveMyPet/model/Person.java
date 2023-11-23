package com.nanterre.LoveMyPet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public Integer idPerson;

  private String LastName;
  private String FirstName;
  private String Email;
  private String PhoneNumber;
  private String Address;
  private String Password;
  private String ImageUrl;

  public Integer getIdPerson() {
    return idPerson;
  }

  public void setIdPerson(Integer IdPerson) {
    this.idPerson = IdPerson;
  }

  public String getLastName() {
    return LastName;
  }

  public void setLastName(String LastName) {
    this.LastName = LastName;
  }

  public String getFirstName() {
    return FirstName;
  }

  public void setFirstName(String FirstName) {
    this.FirstName = FirstName;
  }

  public String getEmail() {
    return Email;
  }

  public void setEmail(String Email) {
    this.Email = Email;
  }

  public String getPhoneNumber() {
    return PhoneNumber;
  }

  public void setPhoneNumber(String PhoneNumber) {
    this.PhoneNumber = PhoneNumber;
  }

  public String getAddress() {
    return Address;
  }

  public void setAddress(String Address) {
    this.Address = Address;
  }

  public String getPassword() {
    return Password;
  }

  public void setPassword(String Password) {
    this.Password = Password;
  }

  public String getImageUrl() {
    return ImageUrl;
  }

  public void setImageUrl(String ImageUrl) {
    this.ImageUrl = ImageUrl;
  }
}