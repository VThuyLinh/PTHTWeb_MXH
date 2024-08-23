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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thuy Linh
 */
@Entity
@Table(name = "group_notification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupNotification.findAll", query = "SELECT g FROM GroupNotification g"),
    @NamedQuery(name = "GroupNotification.findById", query = "SELECT g FROM GroupNotification g WHERE g.id = :id"),
    @NamedQuery(name = "GroupNotification.findByCreatedDate", query = "SELECT g FROM GroupNotification g WHERE g.createdDate = :createdDate")})
public class GroupNotification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Groupp groupId;
    @JoinColumn(name = "no_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Notification noId;

    public GroupNotification() {
    }

    public GroupNotification(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Groupp getGroupId() {
        return groupId;
    }

    public void setGroupId(Groupp groupId) {
        this.groupId = groupId;
    }

    public Notification getNoId() {
        return noId;
    }

    public void setNoId(Notification noId) {
        this.noId = noId;
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
        if (!(object instanceof GroupNotification)) {
            return false;
        }
        GroupNotification other = (GroupNotification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vtl.pojo.GroupNotification[ id=" + id + " ]";
    }
    
}
