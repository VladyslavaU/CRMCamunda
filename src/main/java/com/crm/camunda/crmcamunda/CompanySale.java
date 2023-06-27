package com.crm.camunda.crmcamunda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.camunda.bpm.engine.impl.persistence.entity.Nameable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * CompanySale - an entity that combines the Customer-Company (Customer), Customer Contacts and Activities
 * with Customer Contacts
 * within the framework of a certain service or a set of services purchased by the Customer
 * from the Contractor-Company (Contractor).
 * The same Customer can purchase services or a set of services from the Contractor within the framework
 * of different projects.
 */
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "crm_company_sale")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class CompanySale {

    /**
     * Sale status
     */
    @Getter
    @AllArgsConstructor
    public enum Status {
        LEAD("LEAD"),

        INPROGRESS("INPROGRESS"),

        OPPORTUNITY("OPPORTUNITY"),
        CONTRACT("CONTRACT"),
        PRELEAD("PRELEAD"),
        ARCHIVE("ARCHIVE"),

        DISQUALIFIED("DISQUALIFIED"),
        CONNECTION_REQUEST("CONNECTION REQUEST"),
        SALES_LETTER("SALES LETTER"),
        PING("PING"),
        THANKS_FOR_CONNECTION("THANKS FOR CONNECTION"),
        QUALITY_RESOURCE("QUALITY RESOURCE"),
        THE_SURVEY("THE SURVEY"),
        CASE_STUDY("CASE STUDY"),
        REQUEST_FOR_CALL("REQUEST FOR CALL"),
        FOLLOW_UP("FOLLOW UP"),
        EMAIL_ONE("EMAIL ONE"),
        EMAIL_TWO("EMAIL TWO"),
        EMAIL_THREE("EMAIL THREE"),
        EMAIL_FOUR("EMAIL FOUR"),
        EMAIL_FIVE("EMAIL FIVE"),
        UNDEFINED("UNDEFINED"),
        NOT_NOW("NOT NOW"),
        ARCHIVE_NC("ARCHIVE NC"),
        REVIEW("REVIEW"),
        DRAFT("DRAFT"),
        DISQUALIFIED_NC("DISQUALIFIED NC"),
        ARCHIVE_CONTRACT("ARCHIVE CONTRACT");
        private final String name;
    }

    /**
     * Ranking of a lead by importance (importance criteria are set individually by the head of the sales department)
     */
    @Getter
    @AllArgsConstructor
    public enum Category implements Nameable {
        A("A", false, "AB", null, true, false),
        B("B", false, "AB", null, true, false),
        C_PLUS("C+", false, "C+", null, true, false),
        C("C", false, "C", null, true,  false),
        AA("AA", true, "AB", "Company Size:1000 \n Request: Project / PDS / Team 5+", true, true),
        AB("AB", true, "AB", "Company size:1000 \n Request: 1-4 fte / seprate positions/rare stack", true, true),
        AC("AC", true, "AB", "Сompany size:1000 \n Request: No request / cold lead", true,true),
        BA("BA", true, "AB", "Company size:100-999 \n Request: Project / PDS / Team 5+", true, true),
        BB("BB", true, "AB", "Company size:100-999 \n Request: 1-4 fte / seprate positions/rare stack", true,  true),
        BC("BC", true, "AB", "Company size:100-999 \n Request: No request / cold lead", true,  true),
        CA("CA", true, "C+", "Company size:0-99 \n Request: Project / PDS / Team 5+", true, true),
        CB("CB", true, "C+", "Company size:0-99 \n Request: 1-4 fte / seprate positions/rare stack", true,true),
        CC("CC", true, "C", "Company size:0-99 \n Request: No request / cold lead", true, true),
        D("D", true, "C", "Not qualified (yahoo / gmail)", true,  true),
        A_MINUS("A-", true, "AB", "Company size:1000 \n Request: Not identified", true, false),
        B_MINUS("B-", true, "AB", "Company size:100-999 \n Request: Not identified", true,false),
        UNFILLED("Unfilled", false, null, "UNFILLED", false, false);

        private final String name;
        private final Boolean actualCategory;
        private final String leadReportName;
        private final String tooltip;
        private final Boolean isRelatedToGoogleAds;
        private final Boolean fullInfo;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private Status status;
}
