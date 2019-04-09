/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.searchnserve.viewmodel;

import com.searchnserve.model.Opportunity;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author stephen
 */
public class OpportunitiesViewModel implements Serializable{
    private String modelName = "OpportunitiesViewModel";
    private List<Opportunity> opportunities;
    private String searchString;

    /**
     * @return the opportunities
     */
    public List<Opportunity> getOpportunities() {
        return opportunities;
    }

    /**
     * @param opportunities the opportunities to set
     */
    public void setOpportunities(List<Opportunity> opportunities) {
        this.opportunities = opportunities;
    }

    /**
     * @return the searchString
     */
    public String getSearchString() {
        return searchString;
    }

    /**
     * @param searchString the searchString to set
     */
    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

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
}
