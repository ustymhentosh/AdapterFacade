import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import com.example.task_1.Auth;
import com.example.task_1.MessageSender;
import com.example.task_1.MyFacebookUser;
import com.example.task_1.MyTwitterUser;
import com.example.task_1.User;

public class TestTask1 {

    @Test
    public void testCreation(){
        Auth auth = new Auth();
        User user_0 = auth.login(0);
        User user_1 = auth.login(1);

        assertTrue(user_0 instanceof MyTwitterUser);
        assertTrue(user_1 instanceof MyFacebookUser);
    }



    @Test
    public void testFunctionality() {
        Auth auth = new Auth();
        MessageSender ms = new MessageSender();

        User user_0 = auth.login(0);
        User user_1 = auth.login(1);

        user_0.setEmail("hello@gmail.com");
        user_1.setEmail("bye@outlook.com");

        user_0.setCountry("USA");
        user_1.setCountry("UK");

        user_0.setLastActiveTime(LocalDate.of(2025, 12, 25));
        user_1.setLastActiveTime(LocalDate.of(2025, 12, 25));

        ms.send("Hello dear user!", user_0, "USA");
        ms.send("Hello some user!", user_1, "UK");

        assertNotEquals(user_0.getCountry(), user_1.getCountry());
        assertEquals(user_0.getLastActiveTime(), user_1.getLastActiveTime());
    }
}