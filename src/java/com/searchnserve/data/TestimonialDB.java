package com.searchnserve.data;

import com.searchnserve.model.Opportunity;
import com.searchnserve.model.Testimonial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author stephen
 */
public class TestimonialDB {
    
    public static Testimonial selectTestimonialById(long id) {
        String qString = "SELECT o FROM Testimonial o where o.id = :id";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        return GenericEntityDB.<Testimonial>selectOne(qString, params, Testimonial.class);
    }

    public static List<Testimonial> selectOpportunityRandom(int max) {
        String qString = "select id from JHUJAVAWEB.TESTIMONIAL order by RANDOM()";
        List o = EMFUtil.getResultList(qString, max);
        List<Testimonial> results = new ArrayList<Testimonial>();
        for(int i = 0; i < o.size(); i++){
            long id = (long)o.get(i);
            Testimonial opp = selectTestimonialById(id);
            results.add(opp);            
        }
        return results;
    }
}