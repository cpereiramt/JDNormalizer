# JDNormalizer

## Overview

The JDNormalizer is a Java library that provides functionality to normalize job titles. Given a list of ideal (normalized) job titles, it can find the best match for an input job title using the Levenshtein Distance algorithm implemented on apache commons text.

## Features

- Normalizes input job titles to a list of predefined job titles.
- Uses the Levenshtein Distance algorithm to find the closest match.
- Includes unit test for ensuring functionality.

## Prerequisites

- Java 21 or later
- Maven (for building and managing dependencies)

## Getting Started

### Cloning the Repository

```bash
git clone https://github.com/cpereiramt/JDNormalizer.git
cd JDNormalizer
```

### Build
Run the command below to build the project and generate jacoco report on target folder, the jacoco html report will be generated in the target/site/jacoco directory

```bash
mvn clean package
```

### Test

```bash
mvn test
```

## Using the Library
You can use the generated JAR file as a dependency in your own projects.

### Adding the JAR to Your Project
* Copy the generated JAR file from the target directory to a libs directory in your project. 
* Add the JAR file as a dependency in your pom.xml (if using Maven):

 ```bash
<dependency>
    <groupId>com.claytonpereira</groupId>
    <artifactId>JDNormalizer</artifactId>
    <version><project-version></version>
    <scope>system</scope>
    <systemPath>${project.basedir}/libs/JDNormalizer-<project-version>.jar</systemPath>
</dependency>
 ```
### Usage

```java
 public static void main(String[] args) {
        Normalizer normalizer = new Normalizer();
        String[] jobTitles = {"Java engineer", "C# engineer", "Chief Accountant"};

        for (String jt : jobTitles) {
            System.out.println("Input: " + jt + " => Normalized: " + normalizer.normalize(jt));
        }
    }
``

