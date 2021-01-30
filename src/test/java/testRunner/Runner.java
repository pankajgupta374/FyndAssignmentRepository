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
//	@SuppressWarnings("unchecked")
//	@AfterClass
//	public static void tearDown() {
//		File reportOutputDirectory = new File("target/maven-cucumber-report");
//		List jsonFiles = new ArrayList<>();
//		jsonFiles.add("target/cucumber-report/cucumber-report.json");
//		Configuration configuration = new Configuration(reportOutputDirectory, "Sample Test Project");
//		configuration.setBuildNumber("011");
//		configuration.addClassifications("Platform", "Windows");
//		configuration.addClassifications("Browser", "Chrome");
//		configuration.setSortingMethod(SortingMethod.NATURAL);
//		configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
//
//		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
//		Reportable result = reportBuilder.generateReports();
//		// and here validate 'result' to decide what to do if report has failed
//	}
}
