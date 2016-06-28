# worldbank.test

Test Step Expected Result

1 Open the world bank site in a firefox browser.
www.worldbank.org >> World bank site home page should open.
2 Click on the Data tab. >> It should navigate to World bank site Data tab.
3 Click on the "By Country" option below thelabel "Data". >> It should navigate to World bank site "Data" tab "Countries and 
Economies" section i.e. country page.
4 In the Countries and Economies" section, in the "Income Levels" block, click on "High income" item. >> 
It should navigate to World bank site's incomelevel/HIC page.
5 Click on Country Andorra. >> It should navigate to Andorra country specific page.
6 Note the value for following 3 factors:
"GDP at market prices (current US$)"
"Population, total"
"CO2 emissions (metric tons per capita)"
The required data should get noted for the specific country.
7 Navigate back to World bank site's incomelevel/HIC page. >> It should navigate to World bank site's incomelevel/HIC page.
8 Read and note the data as in step 6 for each country.
The required data should get noted for all the countries.
9 Click on Home tab of the country page. >> World bank site home page should open.
10 Close the browser. >> Browser should get closed.
11 Process the data programmatically and log the names of top 3 countries along with their "GDP at market prices (current US$)" value. >>
It should log the names of top 3 countries as per their "GDP at market prices (current US$)" value to the test log.
12 Process the data programmatically and log the names of top 3 countries along with  their Population, total" value. >>
It should log the names of top 3 countries as per their "Population, total" value to the test log.
13 Process the data programmatically and log the names of top 3 countries along with 
their "CO2 emissions (metric tons per capita)" value. >>
It should log the names of top 3 countries as per their "CO2 emissions (metric tons per capita)" value to the test log.
14 Export the all country data for all the 3 factors in the csv format at appropriate location in the Project directory. >>
It should export the specified data in the csv format at appropriate location in the Project directory.
Just the test steps running is not enough, You should take care of various automation aspects while completing this project.
You should create scripts to automate steps and validations when necessary. 
