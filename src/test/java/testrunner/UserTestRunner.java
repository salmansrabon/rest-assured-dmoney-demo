package testrunner;

import controller.User;
import org.apache.commons.configuration.ConfigurationException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class UserTestRunner {
    @Test
    public void doLogin() throws ConfigurationException, IOException {
        User user=new User();
        user.callingLoginAPI("salman@grr.la","1234");
        String messageExpected="Login successfully";
        Assert.assertEquals(user.getMessage(),messageExpected);
    }
    @Test
    public void getUserList() throws IOException {
        User user=new User();
        String id= user.callingUserListAPI();
        System.out.println(id);
        Assert.assertEquals(id,String.valueOf(58));
    }
}
