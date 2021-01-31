package testRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/GoogleSearch.feature",
glue= {"StepDefinition"	},
plugin = {"de.monochromata.cucumber.report.PrettyReports:target/cucumber",
		"pretty","html:test-output",
		"json:target/cucumber-report/cucumber-report.json"},
dryRun = false, monochrome = true)


public class Runner {
	
}
