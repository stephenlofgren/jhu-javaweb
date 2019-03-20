package com.searchNServe;

import javax.persistence.*;
import javax.servlet.*;
import com.searchNServe.data.EMFUtil;
import com.searchNServe.data.GenericEntityDB;
import com.searchNServe.data.OpportunityDB;
import com.searchNServe.model.Opportunity;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener()
public class DerbyDBInitializingListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        
        //example create object
        Opportunity o = new Opportunity();
        o.setContactName("Stephen Lofgren");
        o.setTitle("Tutoring at the YMCA");
        o.setDescription("Helping younger students with their homework");
        o.setEmailAddress("fakevolunteeringcontact@ymca.org");
        o.setCity("Basking Ridge");
        o.setState("New Jersey");
        GenericEntityDB.<Opportunity>insert(o);
        o = new Opportunity();
        o.setContactName("Stephen Lofgren");
        o.setTitle("Work Study Program with Bridgewater-Raritan High School");
        o.setDescription("Perform routine task to help keep the Y looking nice and clean (windows in the lobby and pool area- these get so dirty from all of the water being kicked up, cleaning tables and chairs in the all purpose room, picking up the parking lot/grounds/pool deck/balcony, etc.");
        o.setEmailAddress("fakevolunteeringcontact@ymca.org");
        o.setCity("Basking Ridge");
        o.setState("New Jersey");
        GenericEntityDB.<Opportunity>insert(o);
        o = new Opportunity();
        o.setContactName("Stephen Lofgren");
        o.setTitle("Child Care Infant/Toddler Classroom Volunteer");
        o.setDescription("Volunteers will ensure safety and supervision of children birth-2.5 years; actively engage children and participate in age appropriate activities; assist Classroom Teachers with daily games/activities; snack/lunch preparation and clean-up, including bottle and spoon-feeding infants; provide support in meeting children’s physical and emotional needs; perform additional duties requested by the Childcare Director or Lead Classroom Teacher.");
        o.setEmailAddress("fakevolunteeringcontact@ymca.org");
        o.setCity("Somerville");
        o.setState("New Jersey");
        GenericEntityDB.<Opportunity>insert(o);
        o = new Opportunity();
        o.setContactName("Stephen Lofgren");
        o.setTitle("Clerical Assistant");
        o.setDescription("The Bridgewater YMCA Membership Department is seeking clerical office assistance to aid in scanning of documents, shredding, filing, alphabetizing, organizing computer files and more. This is a wonderful opportunity for someone who wishes to learn more about administrative work within a non-profit organization. Volunteers should be comfortable utilizing a printer/copier/scanner, performing basic computer tasks, and alphabetizing. The Y is flexible and will work with your schedule to determine the best times for you to come in!\n" +
"*Please contact Eddie or Jessica when you sign up prior to visiting The Y to volunteer*");
        o.setEmailAddress("fakevolunteeringcontact@ymca.org");
        o.setCity("Bridgewater");
        o.setState("New Jersey");
        GenericEntityDB.<Opportunity>insert(o);
        o = new Opportunity();
        o.setContactName("Stephen Lofgren");
        o.setTitle("Committee: Financial Assistance Volunteer");
        o.setDescription("Commit to an hour meeting on the third Tuesday of every month to review, discuss and approve financial assistance applications in our confidential process. A staff liaison provides an overview of every new and renewal application eligible for assistance. Seeking a volunteer for a three year commitment. Committee meets on the third Tuesday of every month from 11a - 12pm.");
        o.setEmailAddress("fakevolunteeringcontact@ymca.org");
        o.setCity("Somerville");
        o.setState("New Jersey");
        GenericEntityDB.<Opportunity>insert(o);
        o = new Opportunity();
        o.setContactName("Stephen Lofgren");
        o.setTitle("Committee: Togetherhood Volunteer");
        o.setDescription("Togetherhood is the Y's member-led volunteer service program. It activates Y members to work together to plan and lead service projects that respond to local community needs. Togetherhood creates social change and demonstrates that we're a charity dedicated to strengthening community through social responsibility.");
        o.setEmailAddress("fakevolunteeringcontact@ymca.org");
        o.setCity("Hillsborough");
        o.setState("New Jersey");
        GenericEntityDB.<Opportunity>insert(o);
        o = new Opportunity();
        o.setContactName("Stephen Lofgren");
        o.setTitle("Dance Class Assistant");
        o.setDescription("Assist YMCA dance instructors conduct class by providing support and assisting new participants in learning steps and routines. Help to make all children feel comfortable and assist instructor with music. \n" +
"Must be attentive, have basic dance knowledge, possess energy and a positive attitude, as well as have Background Check clearance if 18yrs or older. \n" +
"Sept-June, time varies by class schedule (please contact Nicole Mamary regarding class schedule).");
        o.setEmailAddress("fakevolunteeringcontact@ymca.org");
        o.setCity("Sommerset Hills");
        o.setState("New Jersey");
        GenericEntityDB.<Opportunity>insert(o);
        o = new Opportunity();
        o.setContactName("Stephen Lofgren");
        o.setTitle("Race for the Cure");
        o.setDescription("Thanks to events like Komen's Race for the Cure®, we have invested over $2 billion dollars to fulfill our promise, playing a critical role in virtually every major advancement in breast cancer. But, there is still work to be done, and we need your help. Your donations and fundraising dollars will help us get to the finish line.");
        o.setEmailAddress("fakevolunteeringcontact@ymca.org");
        o.setCity("Ocean City");
        o.setState("New Jersey");
        GenericEntityDB.<Opportunity>insert(o);
        
        
        Opportunity sameOp;
        sameOp = OpportunityDB.selectOpportunityByTitle("Tutoring at the YMCA");

        //List<Opportunity> ops = OpportunityDB.selectOpportunityRandom(4);
        
        //clean up the example and demo run simple update query
        EMFUtil.runUpdate("delete from Opportunity");
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        //DBUtil.destroyDB();
    }
}
