Implemented Club Mahindra search and review project by following POM design structure which mainly of low redundancy and programmer friendly.  
Tech - Maven project, Selenium with TestNG framework.
Required dependencies are included in pom file.

Tests can be ran from testng.xml file
Which in turn interact with the below classes
    HomePageTest -  is testing class which is included in testNG.
    TestBase - launches browser as per property set in property file.
    HomePage - This is page class which holds all the webElements and action on it.
    testUtil - used for utils method.
    config.properties - used for configuration






