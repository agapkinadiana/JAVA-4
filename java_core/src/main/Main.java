package main;

import company.Company;
import director.Director;
import json.JsonGenerator;
import json.JsonReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import serialization.Deserializator;
import serialization.Serializator;
import worker.Admin;
import worker.Worker;
import worker.programmers.Junior;
import worker.programmers.Language;
import worker.programmers.Middle;
import xml.parse.demarshalling.SAXWorker;
import xml.parse.marshalling.MyMarshal;
import xml.tohtml.XSLTransformer;
import xml.validate.ValidatorSAX;

import java.io.InvalidClassException;

public class Main {
    static {
        new DOMConfigurator().doConfigure("log/log4j.xml", LogManager.getLoggerRepository());
    }
    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        LOG.info("start program");

        Director director = Director.getInstance();
        Company company = new Company();
        director.company = company;

        Worker worker2 = new Junior("Boyd", "Isabella", "Charleen", 15, 100, Language.Java);
        Worker worker3 = new Admin("Moody", "Stewart", "Paul", 20, 560);
        Worker worker4 = new Middle("Osborne", "Jennifer", "Sherilyn", 5, 200, Language.C);

        Director.Secretary secretary = new Director.Secretary("Fox", "Rosemary", "Britney", 12, 12);

        director.addWorker(worker2);
        director.addWorker(worker3);
        director.addWorker(worker4);

        System.out.println(director.countWorkers());
        director.sortBySalary();
        System.out.println("_________________________________");
        director.printWorkers();

        //Work with XML and XSD
        ValidatorSAX myValid = new ValidatorSAX();
        myValid.valide();

        MyMarshal.marshal(director);
        LOG.info("marshalling success");

        XSLTransformer.transform();
        LOG.info("transform to html success");

        SAXWorker.parse();
        LOG.info("demarshalling success");

        Serializator.serialization(worker2, "src/files/serializeDirector.data");

        LOG.info("serialization success");
        try {
            Deserializator.deserialization("src/files/serializeDirector.data");
            LOG.info("deserialization success");
        } catch (InvalidClassException e) {
            LOG.info(e);
        }

        JsonReader.parser("src/files/data.json");
        LOG.info("jsonreader success");
        JsonGenerator.serialize(director,"src/files/data1.json" );
        LOG.info("jsonwritter success");
    }
}
