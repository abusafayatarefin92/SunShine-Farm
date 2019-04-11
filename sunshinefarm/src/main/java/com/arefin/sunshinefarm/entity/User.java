package com.arefin.sunshinefarm.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "password", nullable = true)
    private String password;

    @Column(name = "email", nullable = false)
    @NotBlank(message = "Enter your email")
    @Email
    private String email;

    @Column(name = "mobile", unique = true)
    @NotBlank(message = "Enter your mobile")
    private String mobile;

    @Column(name = "name", unique = true, nullable = false)
    @NotBlank(message = "Enter your Name")
    @Size(min = 1,max = 50,message = "Hey, Size must be between 1 and 50")
    private String name;

    @Column(name = "registration_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date registrationDate;

    private  boolean enabled;

    @Column(nullable = false)
    private  String confirmationToken;

    //////File Upload==============
    @Column(nullable = true)
    private long fileSize;
    private String fileName;
    //  @Lob
    // private byte[] file;
    private String filePath;
    private String fileExtension;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "u_id"),
            inverseJoinColumns = @JoinColumn(name = "r_id")
    )
    private Set<Role> roles;

    public User() {
    }

    public User(@NotBlank(message = "Enter your username") String userName, @NotBlank(message = "Enter your email") String email, @NotBlank(message = "Enter your mobile") String mobile, @NotBlank(message = "Enter your Name") String name, Date registrationDate, boolean enabled, String confirmationToken, Set<Role> roles) {
        this.userName = userName;
        this.email = email;
        this.mobile = mobile;
        this.name = name;
        this.registrationDate = registrationDate;
        this.enabled = enabled;
        this.confirmationToken = confirmationToken;
        this.roles = roles;
    }

    public User(User user){
        this.userName = user.userName;
        this.password = user.password;
        this.email = user.email;
        this.mobile = user.mobile;
        this.name = user.name;
        this.registrationDate = user.registrationDate;
        this.enabled = user.enabled;
        this.confirmationToken = user.confirmationToken;
        this.fileSize = user.fileSize;
        this.fileName = user.fileName;
        this.filePath = user.filePath;
        this.fileExtension = user.fileExtension;
        this.roles = user.roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return enabled == user.enabled &&
                fileSize == user.fileSize &&
                Objects.equals(id, user.id) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(mobile, user.mobile) &&
                Objects.equals(name, user.name) &&
                Objects.equals(registrationDate, user.registrationDate) &&
                Objects.equals(confirmationToken, user.confirmationToken) &&
                Objects.equals(fileName, user.fileName) &&
                Objects.equals(filePath, user.filePath) &&
                Objects.equals(fileExtension, user.fileExtension) &&
                Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, email, mobile, name, registrationDate, enabled, confirmationToken, fileSize, fileName, filePath, fileExtension, roles);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", name='" + name + '\'' +
                ", registrationDate=" + registrationDate +
                ", enabled=" + enabled +
                ", confirmationToken='" + confirmationToken + '\'' +
                ", fileSize=" + fileSize +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileExtension='" + fileExtension + '\'' +
                ", roles=" + roles +
                '}';
    }
}
