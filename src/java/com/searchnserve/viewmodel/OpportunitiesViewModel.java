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
public class OpportunitiesViewModel implements Serializable{
    private String modelName = "OpportunitiesViewModel";
    private List<Opportunity> opportunities;
    private String searchString;
    private List<Long> favorites;
    private boolean favoriteOnly = false;
    private String cityFilter;
    
    /**
     * @return the opportunities
     */
    public List<Opportunity> getOpportunities() {
        return opportunities;
    }

    public List<Opportunity> getFilteredOpportunities() {
        if(opportunities == null){
            return null;
        }
        
        List<Opportunity> result = new ArrayList<Opportunity>();
        
        for(int i = 0; i  < opportunities.size(); i++){
            Opportunity o = opportunities.get(i);
            if(isMatch(o)){
                result.add(o);
            }
        }
        return result;
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
    
    public boolean isFavorite(long opportunityId){
        if(favorites == null)
            return false;
        return favorites.contains(opportunityId);
    }
    
    private boolean isMatch(Opportunity o){
        if(this.isFavoriteOnly() && !this.isFavorite(o.getId()))
            return false;
        if(this.getCityFilter() != null && this.getCityFilter().toLowerCase().equals(o.getCity().toLowerCase()))
            return false;
        return true;
    }

    /**
     * @return the favorites
     */
    public List<Long> getFavorites() {
        return favorites;
    }

    /**
     * @param favorites the favorites to set
     */
    public void setFavorites(List<Long> favorites) {
        this.favorites = favorites;
    }
    
    public void addFavorite(long opportunityId){
        if(this.favorites == null){
            this.favorites = new ArrayList<Long>();
        }
        this.favorites.add(opportunityId);
    }
    
    public List<String> getCities(){
        if(this.opportunities == null)
            return null;
        List<String> result = new ArrayList<String>();
        for(int i = 0; i < this.opportunities.size(); i++){
            Opportunity o = this.opportunities.get(i);
            if(!result.contains(o.getCity())){
                result.add(o.getCity());
            }
        }
        return result;
    }

    /**
     * @return the favoriteOnly
     */
    public boolean isFavoriteOnly() {
        return favoriteOnly;
    }

    /**
     * @param favoriteOnly the favoriteOnly to set
     */
    public void setFavoriteOnly(boolean favoriteOnly) {
        this.favoriteOnly = favoriteOnly;
    }

    /**
     * @return the cityFilter
     */
    public String getCityFilter() {
        return cityFilter;
    }

    /**
     * @param cityFilter the cityFilter to set
     */
    public void setCityFilter(String cityFilter) {
        this.cityFilter = cityFilter;
    }
    
}
