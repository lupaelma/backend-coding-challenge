README
====
Please follow the steps below to review the development activites,
download and run the Expense challenge application.

Java jdk 1.8.0_66 and Maven 3.3.9 have been used to build and run the app.

Running the application
--------------

1. goto to the repository https://github.com/lupaelma/backend-coding-challenge
0. select the branch `luigi-coding-test`
0. create a folder `expensechallenge` on your computer
0. clone the repository branch to the `expensechallenge` folder
0. cd to `repository branch/solution/dropwizard example` folder and execute the commands below
0. mvn package -Dcheckstyle.skip -DskipTests
0. java -jar target/dropwizard-example-1.3.0-rc5-SNAPSHOT.jar db migrate example.yml
0. java -jar target/dropwizard-example-1.3.0-rc5-SNAPSHOT.jar server example.yml
0. now you can access the app @ http://localhost/8080

Reviewing the code
--------------
The changes related to the backend challenge can be reviewed at the PR below.

1. https://github.com/engagetech/backend-coding-challenge/pull/16

Please note I had to modify the gulp build to work on my Windows laptop. 
Some of these changes can perhaps be included in the build script moving forward.
I have not used MySql but continued using the embedded dropwizard H2 database. 
I have not enabled security or authentication.
