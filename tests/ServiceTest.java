import com.japanredsun.Model.Badge;
import com.japanredsun.Service.Implement.ServiceImp;
import com.japanredsun.Service.Service;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceTest {

    private Service service = new ServiceImp();
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void evaluate() {
        // Point < 0
        Assert.assertEquals(null,service.evaluate(-5));
        // 0 < Point < 25
        Assert.assertEquals("Noob",service.evaluate(5).getGrade());
        // 25 < Point < 50
        Assert.assertEquals("Beginner",service.evaluate(28).getGrade());
        // 50 < Point < 100
        Assert.assertEquals("Intermediate",service.evaluate(55).getGrade());
        //  Point >= 100
        Assert.assertEquals("Advanced",service.evaluate(100).getGrade());
    }

    @Test
    public void calculatePb() {
        // Point 0
        Badge badge1 = service.evaluate(0);
        double pb1 = service.calculatePb(badge1,0);
        Assert.assertTrue("Not Equal", 0 - pb1 == 0);

        //Point 30
        Badge badge2 = service.evaluate(30);
        double pb2 = service.calculatePb(badge2,30);
        Assert.assertTrue("Not Equal", 0.2 - pb2 == 0);

        // Point 110
        Badge badge3 = service.evaluate(110);
        double p3 = service.calculatePb(badge3,110);
        Assert.assertTrue("Not Equal",0 - p3 == 0); // Max level
    }
}