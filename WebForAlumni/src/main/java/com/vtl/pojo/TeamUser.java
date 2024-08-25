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
@Table(name = "team_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TeamUser.findAll", query = "SELECT t FROM TeamUser t"),
    @NamedQuery(name = "TeamUser.findById", query = "SELECT t FROM TeamUser t WHERE t.id = :id"),
    @NamedQuery(name = "TeamUser.findByCreatedDate", query = "SELECT t FROM TeamUser t WHERE t.createdDate = :createdDate")})
public class TeamUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "created_date")
    private String createdDate;
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @ManyToOne
    private Team groupId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private User userId;

    public TeamUser() {
    }

    public TeamUser(Integer id) {
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

    public Team getGroupId() {
        return groupId;
    }

    public void setGroupId(Team groupId) {
        this.groupId = groupId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof TeamUser)) {
            return false;
        }
        TeamUser other = (TeamUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vtl.pojo.TeamUser[ id=" + id + " ]";
    }
    
}
