/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Thuy Linh
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByFirstname", query = "SELECT u FROM User u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "User.findByLastname", query = "SELECT u FROM User u WHERE u.lastname = :lastname"),
    @NamedQuery(name = "User.findByPhone", query = "SELECT u FROM User u WHERE u.phone = :phone"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByRole", query = "SELECT u FROM User u WHERE u.role = :role"),
    @NamedQuery(name = "User.findByAvatar", query = "SELECT u FROM User u WHERE u.avatar = :avatar"),
    @NamedQuery(name = "User.findByActive", query = "SELECT u FROM User u WHERE u.active = :active"),
    @NamedQuery(name = "User.findByYear", query = "SELECT u FROM User u WHERE u.year = :year"),
    @NamedQuery(name = "User.findByStudentId", query = "SELECT u FROM User u WHERE u.studentId = :studentId"),
    @NamedQuery(name = "User.findByCover", query = "SELECT u FROM User u WHERE u.cover = :cover"),
    @NamedQuery(name = "User.findByDegree", query = "SELECT u FROM User u WHERE u.degree = :degree"),
    @NamedQuery(name = "User.findByCreatedDate", query = "SELECT u FROM User u WHERE u.createdDate = :createdDate")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "role")
    private String role;
    @Basic(optional = false)
    @Column(name = "avatar")
    private String avatar;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "year")
    private String year;
    @Column(name = "student_id")
    private String studentId;
    @Basic(optional = false)
    @Column(name = "cover")
    private String cover;
    @Column(name = "degree")
    private String degree;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIdInvite")
    private Set<Notification> notificationSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userPostId")
    private Set<Post> postSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Set<Comment> commentSet;
    @JoinColumn(name = "department", referencedColumnName = "id")
    @ManyToOne
    private Department department;
    @JoinColumn(name = "major", referencedColumnName = "id")
    @ManyToOne
    private Major major;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String firstname, String lastname, String phone, String email, String role, String avatar, String cover, Date createdDate) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.role = role;
        this.avatar = avatar;
        this.cover = cover;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @XmlTransient
    public Set<Notification> getNotificationSet() {
        return notificationSet;
    }

    public void setNotificationSet(Set<Notification> notificationSet) {
        this.notificationSet = notificationSet;
    }

    @XmlTransient
    public Set<Post> getPostSet() {
        return postSet;
    }

    public void setPostSet(Set<Post> postSet) {
        this.postSet = postSet;
    }

    @XmlTransient
    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vtl.pojo.User[ id=" + id + " ]";
    }
    
}
