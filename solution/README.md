README
====
Please follow the steps below to review the development activites,
download and run the Expense challenge application.

Java jdk 1.8.0_66 and Maven 3.3.9 have been used to build and run the app.

1. goto to the repository https://github.com/lupaelma/backend-coding-challenge
0. select the branch luigi-coding-test
0. review the branch commits to see the development activities
0. clone the repository to your computer
0. make sure maven is available on your computer
0. cd to solution/dropwizard example folder and execute the commands below
0. mvn package -Dcheckstyle.skip -DskipTests
0. java -jar target/dropwizard-example-1.3.0-rc5-SNAPSHOT.jar db migrate example.yml
0. java -jar target/dropwizard-example-1.3.0-rc5-SNAPSHOT.jar server example.yml
0. now you can access the app @ http://localhost/8080

