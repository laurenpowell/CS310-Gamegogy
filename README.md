Gamegogy
=====

CS310 Group Scrum Project

### Description:
This project is a Gamegogy Leaderboard. It displays a student's total points and rank, and compares this score to their class mates. The instuctor has a view of the students individual names and grades, while the student can only see the ranks. 

### Installation:
- This project uses both Java and Gradle to run the project and for testing. 

### Java 
  - https://www.java.com/en/download/
  - javac "filename" - to compile
  - java "filename" - to run

### Gradle
- run terminal app
```bash
 // run with gradle
$ gradle run
 // build and run the JAR using java
$ gradle build && java -jar ./build/libs/CS310-Gamegogy-0.0.1.jar
```
- create coverage reports
```bash
$ gradle jacocoTestReport
```

- run junit tests
```bash
$ gradle test
```

- run robot acceptance tests
```bash
$ gradle runrobot
```
### Credits:
 - Nathan Faucett
 - Nathan Pell
 - Hyderick Sarrell
 - Blake Rowan
 - Lauren Powell
