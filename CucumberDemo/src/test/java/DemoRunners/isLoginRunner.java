package DemoRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"Features/isLogin.feature"},
		glue = {"hooks","is"},
		monochrome=true,
		dryRun=false,
		plugin={"pretty","html:target/HtmlReports.html", "junit:target/JunitReports/report.xml"}
)
public class isLoginRunner {

}
