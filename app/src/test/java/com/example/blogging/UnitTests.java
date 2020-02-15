package com.example.blogging;

import android.telecom.Call;
import android.util.Log;

import com.example.blogging.Bbl.PostBbl;
import com.example.blogging.Bbl.Userbbl;
import com.example.blogging.Fragment.UserProfileFragment;
import com.example.blogging.Model.Usermodel;
import com.example.blogging.Responseapi.UserResponse;
import com.example.blogging.RetrofitHelper.Helper;

import org.hamcrest.core.IsNot;
import org.hamcrest.core.IsNull;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.security.auth.login.LoginException;

import retrofit2.Response;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class UnitTests {
    private Userbbl userbbl;
    private PostBbl postBbl;

    @Before
    public void setup() {
        userbbl = new Userbbl();
    }

    public void setPostBble() {
        postBbl = new PostBbl();
    }

    @Test
    public void testLogin_validDetails() {
        String email = "sameer@gmail.com";
        String password = "12345";

        Usermodel user = userbbl.login(email, password);
        Assert.assertNotNull(user);
    }

    @Test
    public void testLogin_InvalidDetails() {
        String email = "kekkk@gmail.com";
        String password = "12345";

        Usermodel user = userbbl.login(email, password);
        Assert.assertNull(user);
    }

    @Test
    public void testSignUp_InvalidDetails_ShouldNotRegister() {
        String fname = "samir";
        String lname = "Karki";
        String email = "sameesdfghjklkjhgf";
        String dob = "12-12-1997";
        String number = "987453210";
        String password = "sam00sau35";

        Usermodel newUser = new Usermodel(fname, lname, email, dob, number, password);
        boolean register = userbbl.register(newUser);
        assertFalse(register);

    }

    @Test
    public void testSignUp_ValidDetails_ShouldRegisterANewUser() {
        String fname = "sameeer";
        String lname = "karki";
        String email = "unit@test.com";
        String dob = "1990/6/25";
        String number = "9863014568";
        String password = "sam00sau35";

        Usermodel newUser = new Usermodel(fname, lname, email, dob, number, password);
        boolean register = userbbl.register(newUser);
        assertNotNull(register);

    }

}

