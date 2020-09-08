#!/bin/bash
mvn clean
mvn package
mvn -Dtest=HandEvaluatorServiceImplTest,DeckServiceImplTest test
java -jar target/FiveCardDrawPoker-0.0.1-SNAPSHOT.jar