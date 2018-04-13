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
        Assert.assertEquals(null,service.evaluate(-5));
        Assert.assertEquals("Noob",service.evaluate(5).getGrade());
        Assert.assertEquals("Beginner",service.evaluate(28).getGrade());
        Assert.assertEquals("Intermediate",service.evaluate(55).getGrade());
        Assert.assertEquals("Advanced",service.evaluate(100).getGrade());
    }

    @Test
    public void calculatePb() {
    }
}