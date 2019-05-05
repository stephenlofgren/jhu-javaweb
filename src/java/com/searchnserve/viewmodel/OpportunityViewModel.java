/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.searchnserve.viewmodel;

import com.searchnserve.model.Opportunity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stephen
 */
public class OpportunityViewModel implements Serializable{
    private String modelName = "OpportunityViewModel";
    private Opportunity opportunity;
    private boolean favorite;

    /**
     * @return the modelName
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * @param modelName the modelName to set
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * @return the opportunity
     */
    public Opportunity getOpportunity() {
        return opportunity;
    }

    /**
     * @param opportunity the opportunity to set
     */
    public void setOpportunity(Opportunity opportunity) {
        this.opportunity = opportunity;
    }

    /**
     * @return the isFavorite
     */
    public boolean isFavorite() {
        return favorite;
    }

    /**
     * @param isFavorite the isFavorite to set
     */
    public void setFavorite(boolean isFavorite) {
        this.favorite = isFavorite;
    }
}