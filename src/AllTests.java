import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	PercolationConstructionUnitTest.class,
	PercolationOpenUnitTest.class
})
public class AllTests {

}
