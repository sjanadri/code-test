package com.ge.exercise1;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    Parser parser;

    @Before
    public void setUp() {
        try {
            Class parserClass = Class.forName("com.ge.exercise1.MyParser");
            parser = (Parser) parserClass.newInstance();
        } catch (Exception e) {
            Assume.assumeNoException(e);
        }
    }

    @Test
    public void parseApplicationDataSimpleTest() {
        String simpleTestData = "Application[name:SimpleApp,groups:[Group[groupId:1,name:SimpleGroup,Users[User[id:2,firstName:Beth,lastName:Jones]]]],Users[User[id:2,firstName:Beth,lastName:Jones]]]";
        Application app = parser.parseApplicationData(simpleTestData);

        assertEquals("SimpleGroup", app.getGroup("1").getGroupName());
        assertEquals(1, app.getGroup("1").size);

        assertEquals("Beth", app.getUser("1").getFirstName());
        assertEquals("Jones", app.getUser("1").getFirstName());
    }
}