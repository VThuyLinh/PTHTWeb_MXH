/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtl.pojo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thuy Linh
 */
@Entity
@Table(name = "team_notification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TeamNotification.findAll", query = "SELECT t FROM TeamNotification t"),
    @NamedQuery(name = "TeamNotification.findById", query = "SELECT t FROM TeamNotification t WHERE t.id = :id"),
    @NamedQuery(name = "TeamNotification.findByCreatedDate", query = "SELECT t FROM TeamNotification t WHERE t.createdDate = :createdDate")})
public class TeamNotification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 40)
    @Column(name = "created_date")
    private String createdDate;
    @JoinColumn(name = "no_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Notification noId;
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Team groupId;

    public TeamNotification() {
    }

    public TeamNotification(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Notification getNoId() {
        return noId;
    }

    public void setNoId(Notification noId) {
        this.noId = noId;
    }

    public Team getGroupId() {
        return groupId;
    }

    public void setGroupId(Team groupId) {
        this.groupId = groupId;
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
        if (!(object instanceof TeamNotification)) {
            return false;
        }
        TeamNotification other = (TeamNotification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vtl.pojo.TeamNotification[ id=" + id + " ]";
    }
    
}
