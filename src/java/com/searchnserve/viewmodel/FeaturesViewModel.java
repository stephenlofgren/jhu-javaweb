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
public class FeaturesViewModel implements Serializable{
    private String modelName = "FeaturesViewModel";
    private List<Opportunity> opportunities;

    /**
     * @return the modelName used to identify the model in a view
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
}
