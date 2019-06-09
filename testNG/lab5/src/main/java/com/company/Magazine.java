package com.company;

import com.company.enums.CoverMaterial;
import com.company.interfaces.IContent;
import java.util.Date;

public class Magazine extends BookProto implements IContent {

    public void BringTheTruth(String message){
        System.out.println(message + " - this is a truth of course.");
    }

    public void BringTheLie(String message){
        System.out.println(message + " - this is a lie, no one cannot to cheat us.");
    }



    public static class Redaction{
        private String name;
        private Date releaseDate;

        public String getName() {
            return name;
        }

        public Date getReleaseDate() {
            return releaseDate;
        }

        private Redaction(String redactionName, Date releaseDate){
            name = redactionName;
            this.releaseDate = releaseDate;
        }
    }

    private Redaction redaction;

    public Redaction getRedaction() {
        return redaction;
    }


    public Magazine(int pagesCount, int cost, String redactionName, Date releaseDate){
        super(pagesCount, CoverMaterial.CARTOON, cost);

        redaction = new Redaction(redactionName, releaseDate);

        //log.info("The Magazine was created");
    }

    public Magazine(){}
}
