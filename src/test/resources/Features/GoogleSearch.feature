Feature: Check Google Search Functionality

Scenario Outline: Google Search Functionality
	
	Given user in on Google site
	When user search <string>
	And click on Enter
	Then user validate number of gumtree links available in search result
	When user navigate to each gumtree link and validate title and NoOfresult
	
	Examples:
	| string |
	| Cars in London |