package com.studentProfile.generator;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class Main {


    public static void main(String [] args) throws Exception {

        Schema schema = new Schema(1,"com.rokan.humaclab.studentprofile.db");
        Entity studentDB = schema.addEntity("Student");
        studentDB.addIdProperty();
        studentDB.addStringProperty("name");
        studentDB.addDateProperty("dob");
        studentDB.addStringProperty("subject");
        studentDB.addDoubleProperty("cgpa");
        studentDB.addStringProperty("university");

        DaoGenerator dg = new DaoGenerator();
        dg.generateAll(schema, "./app/src/main/java");
    }
}
