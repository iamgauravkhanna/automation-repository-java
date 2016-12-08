# RAFTAAR

RAFTAAR (REGRESSION AUTOMATION FRAMEWORK THAT ALLOW ARTIFICIAL RUNS) is an open source automation framework for Web & Mobile Applications 

#Capabilities

 - Automate Web Applications
 - Cross-browser testing on Chrome, Firefox, IE and Safari
 - TestNG, ReportNG & Extent Report integrated for better reporting
 - Interaction with Databases (Oracle,MySQL,MongoDB)
 - Interaction with Excel (xlsx,xls) files
 - Interaction with CSV files
 - Interaction with XML files
 - Interaction with Properties files
 - Support to run Shell Commands
 - Testing Web Services (REST and SOAP)
 - Various Utilities related to Java, Excel, CSV, XML, DB, Shell  
 - Comparing Images
 - Customized HTML Email with Test Results
 
#List of Website Automated

- [Book - The Automated Tester](http://book.theautomatedtester.co.uk/)
- [Webmath](http://www.webmath.com/)
- [IMDB](http://www.imdb.com/)
- [Health Sherpa](https://www.healthsherpa.com/)
- [HDFC](http://www.hdfcbank.com/)
- [Money Control](http://www.moneycontrol.com/)
- [Paytm](https://paytm.com/)
- [Policy Bazar](https://www.policybazaar.com/)

#List of Android Apps Automated

- Calculator
- Phone
- Contacts
- IMDB

#Changelog

### Raftaar_v1.0 (Latest Version)

- Enhanced test reports using reporting libraries (TestNG, ReportNG, Extent Reports, ExtentX)
- Added new capabilities to validate web services response either in JSON or XML for format
- Integrated Rest Assured API
- New Keywords Added
 
### Raftaar_v0.3

- New Keywords added
- Few fixes related to multiple test running
- Sample project added (Refer Implement_Raftaar)

### Raftaar_v0.2

- New Keywords added
- Concept of Variables introduced. A global data dictionary is created at runtime through which we can use variable anywhere with # as prefix
- Concept of Iteration added. A global data dictionary is created at runtime using sheet name and data row number passed in test case
- config.properties added to support user-specific configurations

### Raftaar_v0.1

- Adding Basic Keywords
- Adding Excel utility to read/write from excel files
- Creating Testrunner.log file using Log4j to keep track of logs after each step