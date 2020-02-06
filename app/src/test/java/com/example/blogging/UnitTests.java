package com.example.blogging;

import com.example.blogging.Bbl.Userbbl;
import com.example.blogging.Model.Usermodel;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class UnitTests {
    private Userbbl userbbl;

    @Before
    public void setup(){
        userbbl = new Userbbl();
    }

    @Test
    public void testLogin() {
        String email = "Las@gmail.com";
        String password = "12364";

        Usermodel login = userbbl.login(email,password);
        assertEquals(false, login.getToken().isEmpty());
    }





    }
