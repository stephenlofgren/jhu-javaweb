/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.searchnserve.viewmodel;
import java.io.Serializable;
import com.searchnserve.model.Testimonial;
import java.util.List;

/**
 *
 * @author stephen
 */
public class TestimonialsViewModel implements Serializable{
    private String modelName = "TestimonialsViewModel";    
    private List<Testimonial> testimonials;

    /**
     * @return the testimonials
     */
    public List<Testimonial> getTestimonials() {
        return testimonials;
    }

    /**
     * @param testimonials the testimonials to set
     */
    public void setTestimonials(List<Testimonial> testimonials) {
        this.testimonials = testimonials;
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
