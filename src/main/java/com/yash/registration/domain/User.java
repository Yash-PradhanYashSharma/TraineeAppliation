package com.yash.registration.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * This is domain class which can be used for transfer of data from layer to
 * layer.It represents a User in our registration application. 
 * 
 * @author husain.m
 *
 */
@Entity
public class User {
    
	/**
	 * Id is to uniquely identify a User.
	 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	/**
	 * user-name of user. This has to be an email.
	 */
    @Email(message = "Username must be an e-mail")
    @NotBlank(message = "Please enter a username ")
    @Column(unique = true)
    private String username;
	
	/**
	 * The first and last name of the user.
	 */
    @NotBlank(message = "Name is mandatory")
    private String fullname;
	
	/**
	 * Password for authentication of user.
	 */
    @NotBlank(message = "Password is Required")
    private String password;
	
	/**
	 * Time stamp of user Creation.
	 */
    private Date created_at;
	
    public User(Long id,
            @Email(message = "Username must be an e-mail") @NotBlank(message = "Please enter a username ") String username,
            @NotBlank(message = "Name is mandatory") String fullname,
            @NotBlank(message = "Password is Required") String password, Date created_at) {
        super();
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.password = password;
        this.created_at = created_at;
    }

    public User() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", fullname=" + fullname + ", password=" + password
                + ", created_at=" + created_at + "]";
    }

}
