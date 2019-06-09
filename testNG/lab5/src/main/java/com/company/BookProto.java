package com.company;

import com.company.enums.CoverMaterial;
import java.io.Serializable;
import java.util.logging.Logger;


public abstract class BookProto implements Serializable {

    //protected static final Logger log = Logger.getLogger(BookProto.class.toString());

    public int pagesCount;
    public CoverMaterial coverMaterial;
    public int cost;



    protected BookProto(int pagesCount, CoverMaterial coverMaterial, int cost){
        this.pagesCount = pagesCount;
        this.coverMaterial = coverMaterial;
        this.cost = cost;
    }
    protected BookProto(){
        pagesCount = 0;
        coverMaterial = CoverMaterial.NONE;
        cost = 0;
    }
}
