ATS Spec solutions.com Automation Framework
•	Input:- 
o	.properties file:- 	src/test/resources/Properties/config.properties
o	Excel:- 			src/test/resources/Excel.TestData.xlsx
•	Output:- 
o	Extent report:-		target/extent.html
o	Logs:-			src/test/resources/Logs
•	Runner:- 				src/test/resources/Runners/testng.xml

Framework structure details:-
Src/main/java:- 
•	com.ats_base:-		Initialize the few common objects like driver, .properties file,
Extent report and log4j. Other classes will extent this class to utilize these objects.
•	com.ats_Listeners:- 	TestNg listeners class.
•	com.atsPages:- 		Web Elements of all the pages.
•	com.ats_utilities:- 		All the common utilities needed for any project to automate.

Src/test/java: - 

•	com.ats_createproject:-	 Actual automated test cases i.e. create new project.
•	com.ats_helper:- 		This class contains common methods of spec solutions application.

Src/test/resources:-
•	Excel:- 			to input the data and control the execution
•	Executables:- 		browser executable files
•	Extent config:-	 	Extent report configuration
•	Logs:- 			Logs are stored here
•	Properties: - 		Log4J configuration and input details (url, username etc.)
•	Runners: - 			TestNg xml.
