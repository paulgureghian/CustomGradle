# CustomGradle


<img src="free gradle.png" width="200" height="200">



This app implements Java and Android libraries, Google Cloud Endpoint, and a deployed back-end app engine. Gradle build scripts are used to create dependencies between modules, define build types, and product flavors. the app produces two build variants: free debug and paid debug. 

A Google Cloud Endpoint module is deployed to a back-end app engine implemented for fetching data from the Java library which passes it to the app module which passes the data to a dependent Android module, where it is displayed in the UI. 
 
Finally an AsyncTask class file is implemented to make the query to the endpoint on a worker thread instead of the main thread. an AsyncTask test class is also included to test the AsyncTask class fucntionality. 
