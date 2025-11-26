import com.intuit.karate.junit5.Karate;
import org.junit.jupiter.api.AfterAll;

import static utils.EmailSender.sendEmail;

public class TestRunner {
    @Karate.Test
    Karate testTags() {
        return Karate.run("halkKatilim/agreements/agreements.feature").tags("agreements").relativeTo(getClass());
    }

    @AfterAll
    public static void tearDown() {
        String testType = System.getProperty("testType");
        if (testType.equals("api")) {
            // sendEmail();
        }
    }
}