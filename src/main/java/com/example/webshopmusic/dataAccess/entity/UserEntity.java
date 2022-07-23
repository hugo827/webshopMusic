package com.example.webshopmusic.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="customer")
public class UserEntity {

    @Id
    @Column(name="id_customer")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="username")
    private String username;
    @Column(name="email")
    private String email;
    @Column(name="firstname")
    private String firstname;
    @Column(name="lastname")
    private String lastname;
    @Column(name="phone")
    private String phone;
    @Column(name="password")
    private String password;
    @Column(name="postcode")
    private int postcode;
    @Column(name="country")
    private String country;
    @Column(name="city")
    private String city;
    @Column(name="number_house")
    private String number_house;
    @Column(name="street")
    private String street;
    @Column(name="authorities")
    private String authorities;
    @Column(name="account_non_expired")
    private Boolean accountNonExpired;
    @Column(name="account_non_locked")
    private Boolean accountNonLocked;
    @Column(name="credentials_non_expired")
    private Boolean credentialsNonExpired;
    @Column(name="enabled")
    private Boolean enabled;

    @OneToMany(mappedBy="user", fetch=FetchType.LAZY)
    private Collection<OrderEntity> orderEntities;

    public UserEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumber_house() {
        return number_house;
    }

    public void setNumber_house(String number_house) {
        this.number_house = number_house;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Collection<OrderEntity> getOrderEntities() {
        return orderEntities;
    }

    public void setOrderEntities(Collection<OrderEntity> orderEntities) {
        this.orderEntities = orderEntities;
    }
}
