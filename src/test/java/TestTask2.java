import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import com.example.task_1.Auth;
import com.example.task_1.MessageSender;
import com.example.task_2.Authorization;
import com.example.task_2.DataBase;
import com.example.task_2.ReportBuilder;


public class TestTask2 {

    @Test
    public void testDBFunctionality(){
        DataBase db = new DataBase();
        assertEquals(db.getUserData(), "hello");
        assertEquals(db.getStaticData(), "hello2");
    }

    @Test
    public void testReportBuilder(){
        DataBase db = new DataBase();
        Authorization auth = new Authorization();
        if (auth.login(db)) {
            ReportBuilder br = new ReportBuilder(db);
        }
    }
}