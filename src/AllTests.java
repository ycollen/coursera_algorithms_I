import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



@RunWith(Suite.class)
@SuiteClasses({ 
	PercolationConstructionUnitTest.class,
	PercolationOpenUnitTest.class,
	PercolationIsFullUnitTest.class,
	PercolationStatsUnitTest.class,
	PercolatesUnitTest.class
})
public class AllTests {

}
