package com.company;

import com.company.enums.CoverMaterial;
import com.company.interfaces.IContent;

import java.sql.Time;
import java.util.Date;


public class Newspaper extends BookProto implements IContent, Comparable<Newspaper> {

    public int compareTo(Newspaper o) {
        if (getOutDate() == null || o.getOutDate() == null) {
            return 0;
        }
        return getOutDate().compareTo(o.getOutDate());
    }



    public void BringTheTruth(String message){
        System.out.println(message + " - it is a truth!");
    }

    public void BringTheLie(String message){
        System.out.println(message + " - it is a lie!");
    }


    private Date outDate;

    public Date getOutDate(){
        return outDate;
    }




    public Newspaper(int pagesCount, int cost, Date outDate){
        super(pagesCount, CoverMaterial.PAPER, cost);
        this.outDate = outDate;

        //log.info("The Newspaper was created");
    }

    public Newspaper(){
        super(0, CoverMaterial.PAPER, 0);
        outDate = null;
    }
}
