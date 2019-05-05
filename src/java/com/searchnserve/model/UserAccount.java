/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.searchnserve.model;

import com.searchnserve.data.GenericEntityDB;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author stephen
 */
@Entity
public class UserAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String emailAddress;
    private String passwordHash;
    @OneToMany(
        cascade = CascadeType.ALL,
        orphanRemoval = false
    )
    private List<Opportunity> favorites;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof UserAccount)) {
            return false;
        }
        UserAccount other = (UserAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.searchnserve.model.UserAccount[ id=" + id + " ]";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return the passwordHash
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * @param passwordHash the passwordHash to set
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    /**
     * @return the favorites
     */
    public List<Opportunity> getFavorites() {
        return favorites;
    }

    /**
     * @param favorites the favorites to set
     */
    public void setFavorites(List<Opportunity> favorites) {
        this.favorites = favorites;
    }
    
    public void addFavorite(Opportunity o){
        this.favorites.add(o);
    }

    public void removeFavorite(Opportunity o){
        for(int i = 0; i < this.favorites.size(); i++){
            if(this.favorites.get(i).getId() == o.getId()){
                this.favorites.remove(i);
                return;
            }
        }
        
    }

    public boolean isFavorite(Long opportunityId){
        for(int i = 0; i < favorites.size(); i++){
            if(favorites.get(i).getId() == opportunityId){
                return true;
            }
        }
        return false;
    }
}