package testrunner;

import com.github.javafaker.Faker;
import controller.User;
import org.apache.commons.configuration.ConfigurationException;
import org.junit.Assert;
import org.junit.Test;
import utils.Utils;

import java.io.IOException;

public class UserTestRunner {
    @Test
    public void a_doLogin() throws ConfigurationException, IOException {
        User user = new User();
        user.callingLoginAPI("salman@grr.la", "1234");
        String messageExpected = "Login successfully";
        Assert.assertEquals(user.getMessage(), messageExpected);
    }

    @Test
    public void b_createNewUser() throws IOException, ConfigurationException {
        User user = new User();
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String password = "1234";
        String phone_number = Utils.generateRandomPhoneNumber(100000, 999999);
        String nid = "100200300";
        String role = "Customer";

        String message = user.createNewUser(name, email, password, phone_number, nid, role);
        Assert.assertEquals("User created successfully", message);
    }
    @Test
    public void c_getUserList() throws IOException {
        User user = new User();
        String id = user.callingUserListAPI();
        System.out.println(id);
        //Assert.assertEquals(id, String.valueOf(81));
    }
    @Test
    public void d_searchByUserId() throws IOException {
        User user=new User();
        String id=user.searchByUserId("83");
        System.out.println(id);
        Assert.assertEquals(id,"83");
    }
}
