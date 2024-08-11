/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thuy Linh
 */
@Entity
@Table(name = "notification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notification.findAll", query = "SELECT n FROM Notification n"),
    @NamedQuery(name = "Notification.findById", query = "SELECT n FROM Notification n WHERE n.id = :id"),
    @NamedQuery(name = "Notification.findByContent", query = "SELECT n FROM Notification n WHERE n.content = :content"),
    @NamedQuery(name = "Notification.findByAdress", query = "SELECT n FROM Notification n WHERE n.adress = :adress"),
    @NamedQuery(name = "Notification.findByTime", query = "SELECT n FROM Notification n WHERE n.time = :time"),
    @NamedQuery(name = "Notification.findByActive", query = "SELECT n FROM Notification n WHERE n.active = :active"),
    @NamedQuery(name = "Notification.findByCreatedDate", query = "SELECT n FROM Notification n WHERE n.createdDate = :createdDate")})
public class Notification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @Column(name = "adress")
    private String adress;
    @Basic(optional = false)
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "user_id_be_invited", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userIdBeInvited;
    @JoinColumn(name = "user_id_invite", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userIdInvite;

    public Notification() {
    }

    public Notification(Integer id) {
        this.id = id;
    }

    public Notification(Integer id, String content, String adress, Date time) {
        this.id = id;
        this.content = content;
        this.adress = adress;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUserIdBeInvited() {
        return userIdBeInvited;
    }

    public void setUserIdBeInvited(User userIdBeInvited) {
        this.userIdBeInvited = userIdBeInvited;
    }

    public User getUserIdInvite() {
        return userIdInvite;
    }

    public void setUserIdInvite(User userIdInvite) {
        this.userIdInvite = userIdInvite;
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
        if (!(object instanceof Notification)) {
            return false;
        }
        Notification other = (Notification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vtl.pojo.Notification[ id=" + id + " ]";
    }
    
}
