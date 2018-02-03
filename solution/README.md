README
====

- get dropwizard repo https://github.com/dropwizard/dropwizard
- copy dropwizard example
- cd to dropwizard example folder and follow maven build instructions
- https://github.com/dropwizard/dropwizard/tree/master/dropwizard-example
- mvn package -Dcheckstyle.skip
- java -jar target/dropwizard-example-1.3.0-rc5-SNAPSHOT.jar db migrate example.yml
- edit example.yml to set server http port = 8888
- java -jar target/dropwizard-example-1.3.0-rc5-SNAPSHOT.jar server example.yml


IMPORTANT
====
To avoid unconcious bias, we aim to have your submission reviewed anonymously 
by one of our engineering team. Please try and avoid adding personal 
details to this document such as your name, or using pronouns 
that might indicate your gender.