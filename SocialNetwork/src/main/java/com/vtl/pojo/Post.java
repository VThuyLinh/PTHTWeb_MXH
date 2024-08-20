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
@Table(name = "post")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p"),
    @NamedQuery(name = "Post.findById", query = "SELECT p FROM Post p WHERE p.id = :id"),
    @NamedQuery(name = "Post.findByTopic", query = "SELECT p FROM Post p WHERE p.topic = :topic"),
    @NamedQuery(name = "Post.findByContent", query = "SELECT p FROM Post p WHERE p.content = :content"),
    @NamedQuery(name = "Post.findByLikeHahaHeart", query = "SELECT p FROM Post p WHERE p.likeHahaHeart = :likeHahaHeart"),
    @NamedQuery(name = "Post.findByCreatedDate", query = "SELECT p FROM Post p WHERE p.createdDate = :createdDate"),
    @NamedQuery(name = "Post.findByActive", query = "SELECT p FROM Post p WHERE p.active = :active")})
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "topic")
    private String topic;
    @Basic(optional = false)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @Column(name = "like_haha_heart")
    private boolean likeHahaHeart;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Basic(optional = false)
    @Column(name = "active")
    private boolean active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postId")
    private Set<Image> imageSet;
    @JoinColumn(name = "major_id", referencedColumnName = "id")
    @ManyToOne
    private Major majorId;
    @JoinColumn(name = "user_post_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User userPostId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postId")
    private Set<Comment> commentSet;

    public Post() {
    }

    public Post(Integer id) {
        this.id = id;
    }

    public Post(Integer id, String topic, String content, boolean likeHahaHeart, Date createdDate, boolean active) {
        this.id = id;
        this.topic = topic;
        this.content = content;
        this.likeHahaHeart = likeHahaHeart;
        this.createdDate = createdDate;
        this.active = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getLikeHahaHeart() {
        return likeHahaHeart;
    }

    public void setLikeHahaHeart(boolean likeHahaHeart) {
        this.likeHahaHeart = likeHahaHeart;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @XmlTransient
    public Set<Image> getImageSet() {
        return imageSet;
    }

    public void setImageSet(Set<Image> imageSet) {
        this.imageSet = imageSet;
    }

    public Major getMajorId() {
        return majorId;
    }

    public void setMajorId(Major majorId) {
        this.majorId = majorId;
    }

    public User getUserPostId() {
        return userPostId;
    }

    public void setUserPostId(User userPostId) {
        this.userPostId = userPostId;
    }

    @XmlTransient
    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
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
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vtl.pojo.Post[ id=" + id + " ]";
    }
    
}
