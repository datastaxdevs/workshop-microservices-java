
# ✨ Building Microservice for Apache Cassandra™ ✨

[![Gitpod ready-to-code](https://img.shields.io/badge/Gitpod-ready--to--code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/DataStax-Academy/microservices-java-workshop-online) 
[![License Apache2](https://img.shields.io/hexpm/l/plug.svg)](http://www.apache.org/licenses/LICENSE-2.0)
[![Discord](https://img.shields.io/discord/685554030159593522)](https://discord.com/widget?id=685554030159593522&theme=dark)

*"In this repository, you'll find everything you need related to the **Cassandra Developer Workshop Build Java Microservices for Apache Cassandra**. [The first live stream will be June 17th](https://www.youtube.com/watch?v=KAcZg6l9QTw). Past this date the `README.MD` will be updated with the recording. Feel free to bookmark this page for future reference, Enjoy"!* - The Developer Advocates Team.

![SplashScreen](https://github.com/DataStax-Academy/microservices-java-workshop-online/blob/master/z-materials/images/splash.png?raw=true)

`Cassandra Developer Workshorp` are an interactive experiences. Advocates share some knowledge about  Apache Cassandra™ database and you can interact with them through chats *([youtube](https://www.youtube.com/channel/UCAIQY251avaMv7bBv5PCo-A) and [discord](https://discord.com/widget?id=685554030159593522&theme=dark))*, quizzes (menti.com), and  exercises.

# Table of Content
For simplicity all exercises instructions are listed in a single `README.MD` document. As it is quite long we provide you a table of content is provided and after each chapter you can go back to it.

| Sections  | Material Description
|---|---|
| **Slide deck** | [Slidedeck for the workshop](4-materials/presentation.pdf) |
| **Before Starting** | [Bootstraping your environment](4-materials/presentation.pdf) |
| **EXERCISE 1** | [Create your Astra Instance](#exercise-1---create-your-astra-instance) |
| **EXERCISE 2** | [Create the Data Model](#exercise-2----create-the-data-model) |
| **EXERCISE 3** | [Connectivity to Cassandra](#exercise-3----connectivity-to-cassandra) |
| **EXERCISE 4** | [Implement CRUD Repository](#exercise-4----implement-crud-repository) |
| **EXERCISE 5** | [Run and Test the API](#exercise-5---run-and-test-the-api) |
| **EXERCISE 6** | [Spring DATA](#exercise-6---spring-data) |
| **EXERCISE 7** | [Spring Webflux](#exercise-7---spring-webflux) |

## 1. Bootstrapping

### 1.1 Clone the Repository
There are 2 ways to do the exercises, **locally** on your computer and with a **cloud-based IDE named Gitpod.** We recommend you to use your laptop in order to save code modifications and come back later. In both cases you should start by cloning the repository and download everything (including slides).

```bash
# Clone the current repository
git clone https://github.com/DataStax-Academy/microservices-java-workshop-online.git

# Access the proper folder
cd microservices-java-workshop-online
```

### 1.2 Setup your computer to run the exercises

We will create a REST API using the Spring framework. Those are the pre-requisites tools to install on your laptop before starting.

**1.2.a - Install Java JDK8 +**
- ![Windows](https://github.com/DataStax-Academy/kubernetes-workshop-online/blob/master/4-materials/images/windows32.png?raw=true) Please use the following tutorial [Installation of the JDK on Microsoft Windows Platforms](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-microsoft-windows-platforms.html#GUID-A7E27B90-A28D-4237-9383-A58B416071CA)
- ![linux](https://github.com/DataStax-Academy/kubernetes-workshop-online/blob/master/4-materials/images/linux32.png?raw=true) Please use the following tutorial [Installation of the JDK on Linux Platform Platforms](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-linux-platforms.html#GUID-737A84E4-2EFF-4D38-8E60-3E29D1B884B8)
- ![osx](https://github.com/DataStax-Academy/kubernetes-workshop-online/blob/master/4-materials/images/mac32.png?raw=true) Please use the following tutorial [Installation of the JDK on MACOS Platforms](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-macos.html#GUID-2FE451B0-9572-4E38-A1A5-568B77B146DE) or with homebrew:
```bash
brew cask install java
```

**1.2.b - Install Maven**

- ![Windows](https://github.com/DataStax-Academy/kubernetes-workshop-online/blob/master/4-materials/images/windows32.png?raw=true) Foo [Bar](#bar)
- ![linux](https://github.com/DataStax-Academy/kubernetes-workshop-online/blob/master/4-materials/images/linux32.png?raw=true) Foo [Bar](#bar)
- ![osx](https://github.com/DataStax-Academy/kubernetes-workshop-online/blob/master/4-materials/images/mac32.png?raw=true)  Foo [Bar](#bar)
```
brew install maven
```

📘 You should validate your installation with the following command:
```bash
mvn -v
```

📗 Expected output
```bash
Apache Maven 3.6.0 (97c98ec64a1fdfee7767ce5ffb20918da4f719f3; 2018-10-24T20:41:47+02:00)
Maven home: /usr/local/Cellar/maven/3.6.0/libexec
Java version: 12, vendor: Oracle Corporation, runtime: /Library/Java/JavaVirtualMachines/openjdk-12.jdk/Contents/Home
Default locale: en_FR, platform encoding: UTF-8
OS name: "mac os x", version: "10.15.3", arch: "x86_64", family: "mac"
```
**1.2.c - Install an IDE**

You favourite java IDE here are some propositions:
- [Eclipse Spring Tools Suite - STS](https://spring.io/tools#main)
- [IntelliJ](https://www.jetbrains.com/idea/download/index.html)
- [Eclipse](https://www.eclipse.org/downloads/)
- [Visual Code](https://code.visualstudio.com/Download)

### 1.3 How to setup Cloud-based environment ([gitpod](https://www.gitpod.io/))

**📘 Click on the following link**

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/DataStax-Academy/microservices-java-workshop-online)

Please note that a new tab is opened in your browser with an url like `https://<your_uid>.<your_region>.gitpod.io/#/workspace/microservices-java-workshop-online`. Those URL are dynamic and we cannot provide links in advance. Make sure to adapt the URL we provide you with your own ids.

**📘 Maven is preinstall**

Gitpod provides all tools we will need for today including `Maven` and also export port `8080`. For instance in the terminal on the bottom part of the screen you :
```bash
mvn -v
```

**📗 Expected output**
![SplashScreen](https://github.com/DataStax-Academy/microservices-java-workshop-online/blob/master/z-materials/images/gitpod-home.png?raw=true)

[🏠back to table of content](#table-of-content)

## 2. Run the Todo Application

### 2.1 Discovering Todo MVC

**TodoMVC** is a fabulous community contribution that helps developers compare frameworks on the basis of actual project code, not just claims and anecdotes. Michael Mahemoff. TodoMVC is an immensely valuable attempt at a difficult problem - providing a structured way of comparing JS libraries and frameworks.

![TodoMVC](https://github.com/DataStax-Academy/microservices-java-workshop-online/blob/master/z-materials/images/todomvc.png?raw=true)

📘 Access the [http://todomvc.com/](http://todomvc.com/) website and test one application with the framework of your choice.

### 2.2 Discovering Todo Backend

**Todo-Backend** is a shared example to showcase backend tech stacks. The Todo-Backend project defines a simple web API spec - for managing a todo list. Contributors implement that spec using various tech stacks. Those implementations are cataloged below. A spec runner verifies that each contribution implements the exact same API, by running an automated test suite which defines the API.

![TodoBackend](https://github.com/DataStax-Academy/microservices-java-workshop-online/blob/master/z-materials/images/todobackend.png?raw=true)

There are multiple free implementations available already. Some implementations provide endpoints to be tested in `heroku`. [Heroku provide free hosting for a Java application but this is on-demand](https://devcenter.heroku.com/articles/deploying-spring-boot-apps-to-heroku). With `Heroku` The application will be sleeping until you access the endpoint. So it will take 30s for the first person to have the application running.

**Among the available free endpoints we can list**
- `Endpoint#1` : [https://todo-back-springboot220-java12.herokuapp.com/todos](https://todo-back-springboot220-java12.herokuapp.com/todos)
- `Endpoint#2` : [https://todo-quarkus.herokuapp.com/todos](https://todo-quarkus.herokuapp.com/todos)
- `Endpoint#3` : [https://todo-backend-micronaut.herokuapp.com/todos](https://todo-backend-micronaut.herokuapp.com/todos)

📘  **TodoBackend.com** provides first a nice webUI [spec runner](https://www.todobackend.com/specs/index.html) to test API and evaluate if they match the specifications. Use one of the `endpoints` decribed below to evaluate if the API matchs the requirements and `Run Tests`

![TodoBackendTest](https://github.com/DataStax-Academy/microservices-java-workshop-online/blob/master/z-materials/images/todobackend-runtest.png?raw=true)

**📗 Expected output**

![TodoBackendOuput](https://github.com/DataStax-Academy/microservices-java-workshop-online/blob/master/z-materials/images/todobackend-output-host.png?raw=true)

*Note: During the live stream you will be hundreds testing the same endpoint so maybe we could hit some issues - race conditions.*

📘  **TodoBackend.com** also provides a [client](https://www.todobackend.com/client/index.html), to work with the API. As before pick one of the `endpoints` listed before and try the client.

![TodoBackendClient](https://github.com/DataStax-Academy/microservices-java-workshop-online/blob/master/z-materials/images/todobackend-runclient.png?raw=true)

**📗 Expected output**

![TodoBackendClient](https://github.com/DataStax-Academy/microservices-java-workshop-online/blob/master/z-materials/images/todobackend-output-client.png?raw=true)

### 2.3 Start the BackendAPI

Our mission withing the next hour is to implement the backend API and store the data into Apache Cassandra™. We have you cover by providing the skeleton. Let's see what we have.

📘 **Start the backend API**
```bash
# Build the project without tests (you did not implemented them yet TDD baby !)
mvn clean install -Dmaven.test.skip=true

# Navigate to the proper folder
cd wkshop-microservice-2-spring-boot/

# Start the backend API
mvn spring-boot:run
```

**📗 Expected output**

```bash
[...]
INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary for Spring microservices with Apache Cassandra 1.0-SNAPSHOT:
[INFO] 
[INFO] Spring microservices with Apache Cassandra ......... SUCCESS [  4.115 s]
[INFO] + microservice-1-common ............................ SUCCESS [  8.893 s]
[INFO] + microservice-2-spring-boot ....................... SUCCESS [  3.504 s]
[INFO] + microservice-3-spring-data ....................... SUCCESS [  1.369 s]
[INFO] + microservice-4-spring-webflux .................... SUCCESS [  0.311 s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  18.701 s
[INFO] Finished at: 2020-06-15T13:08:57Z
[INFO] ------------------------------------------------------------------------

[...]

 ________                __      __ __           .__                   
 \______ \   _______  __/  \    /  \  | __  _____|  |__   ____ ______  
  |    |  \_/ __ \  \/ /\   \/\/   /  |/ / /  ___/  |  \ /  _ \\____ \ 
  |    `   \  ___/\   /  \        /|    <  \___ \|   Y  (  <_> )  |_> >
 /_______  /\___  >\_/    \__/\  / |__|_ \/____  >___|  /\____/|   __/ 
         \/     \/             \/       \/     \/     \/       |__|    

 Backend API implementation of todobackend.com
 We are using SpringBoot and Apache Cassandra
 The application is started at http://localhost:8080  

14:54:54.773 INFO  com.datastax.sample.TodoBackendApplication         : Starting TodoBackendApplication on clunhost with PID 75757 (/Users/cedricklunven/dev/WORKSPACES/DATASTAX/microservices-java-workshop-online/wkshop-microservice-2-spring-boot/target/classes started by cedricklunven in /Users/cedricklunven/dev/WORKSPACES/DATASTAX/microservices-java-workshop-online/wkshop-microservice-2-spring-boot)
14:54:54.775 INFO  com.datastax.sample.TodoBackendApplication         : No active profile set, falling back to default profiles: default
14:55:03.604 INFO  com.datastax.sample.TodoBackendApplication         : Started TodoBackendApplication in 1.075 seconds (JVM running for 1.492)
```

📘 **Test the API**
You can open a browser and navigate to [http://localhost:8080](http://localhost:8080) if you are on your laptop or [https://<your_uid>.<your_region>.gitpod.io/#/workspace/microservices-java-workshop-online](#) if you are using gitpod.

**📗 Expected output**

![TodoBackendClient](https://github.com/DataStax-Academy/microservices-java-workshop-online/blob/master/z-materials/images/backend-doc.png?raw=true)

[🏠back to table of content](#table-of-content)


## Exercise 2 -  Create the Data Model

Do X Y Z

```
XXX
```

[🏠back to table of content](#table-of-content)

## Exercise 3 -  Connectivity to Cassandra

Do X Y Z

```
XXX
```

[🏠back to table of content](#table-of-content)

## Exercise 4 -  Implement CRUD Repository

Do X Y Z

```
XXX
```

[🏠back to table of content](#table-of-content)

## Exercise 5 - Run and Test the API

Do X Y Z

```
XXX
```

[🏠back to table of content](#table-of-content)

## Exercise 6 - Spring DATA

Do X Y Z

```
XXX
```

[🏠back to table of content](#table-of-content)

## Exercise 7 - Spring Webflux

Do X Y Z

```
XXX
```

[🏠back to table of content](#table-of-content)


THE END.





