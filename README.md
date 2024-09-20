# Enkel rest server

## Överblick
Detta projekt är en **Java 21** REST server som hanterar bilrelaterad data.
Det innehåller flera moduler, som delar upp ansvarsområden i olika lager, 
tex **web**, **affärslogik**, **databas** och **felhantering**.
**Maven** används för att bygga detta projekt.

## Innehåll
- [Moduler](#moduler)
- [Vad demonstreras](#vad-demonstreras)
- [Maven faser](#maven-faser)
- [Köra applikationen](#köra-applikationen)
- [REST API](#rest-api)


## Moduler

Projektet innehåller följande moduler:

### 1. **Api**
- Denna modul innehåller REST API:et för att visa bilar.
- Just nu är enbart R:et implementerat i det som skulle kunna vara CRUD.

### 2. **Affärslogik**
- Implementerar affärslogiken för funktionerna i api:et
- Hämtar data från databasen.

### 3. **DB Module**
- Innehåller koden för att hantera databaskopplingen.

### 4. **Error Module**
- Global felhantering för applikationen.
- Ger dig meningsfull information om vad som gick fel. 


## Vad demonstreras
- **Java 21**.
- **Spring Boot** för REST API:et och hantering av beroenden.
- **Maven** för att bygga, köra och testa appen, samt hantering av beroenden.
- **JUnit 5** unit testning.
- **Spring Test & TestContainers** för integrationstestning.
- **H2 Database** för bildatan.


## Maven faser
Mavens byggprocess är uppdelad i olika faser:
(se pom.xml för vilka filer som ingår i unit- respektive integrationstester)

1. **Compile** (`mvn compile`): Kompilerar all kod.
2. **Test** (`mvn test`): Kör **unit tests** from the `src/test/java` katalogen. 
Dessa tester har inga externa beroenden, som tex databaser.
3. **Package** (`mvn package`): Paketerar applikationen i en JAR/WAR fil.
4. **Verify** (`mvn verify`): Kör **integration tester** . 
De här testerna tar normalt sett lite längre tid att köra beroende på externa resurser.
5. **Install** (`mvn install`): Installerer artefakten i det lokala Maven repot.


## Köra applikationen

För att köra applikationen lokalt, följ dessa steg:

1. Klona repot
2. Importera koden i IntelliJ (använd pom.xml)
3. Kompilera
4. Starta applikationen


## REST API

* http://localhost:8080/api/v1/car (visa alla bilar)
* http://localhost:8080/api/v1/car/random (visa slumpmässig bil)
* http://localhost:8080/api/v1/car/random?manufacturer=Tesla (visa slumpmässig bil från specifik biltillverkare)
* http://localhost:8080/api/v1/car/random?manufacturer=Alset (visa felmeddelande)