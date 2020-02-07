package com.example.blogging;

import android.util.Log;

import com.example.blogging.Bbl.Userbbl;
import com.example.blogging.Model.Usermodel;

import org.junit.Assert;
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
        String email = "las@gmail.com";
        String password = "12345";

        Usermodel user = userbbl.login(email,password);
        Assert.assertNotNull(user);
    }





    }
