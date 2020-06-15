
# ✨ Building Microservice for Apache Cassandra™ ✨

[![Gitpod ready-to-code](https://img.shields.io/badge/Gitpod-ready--to--code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/DataStax-Academy/microservices-java-workshop-online) 
[![License Apache2](https://img.shields.io/hexpm/l/plug.svg)](http://www.apache.org/licenses/LICENSE-2.0)
[![Discord](https://img.shields.io/discord/685554030159593522)](https://discord.com/widget?id=685554030159593522&theme=dark)

*"In this repository, you'll find everything you need related to the Cassandra Developer Workshop Build Java Microservices for Apache Cassandra. [The first live stream will be June 17th](https://www.youtube.com/watch?v=KAcZg6l9QTw). Past this date the `README.MD` will be updated with the recording. Feel free to bookmark this page for future reference, Enjoy"!* - The Developer Advocates Team.

![SplashScreen](https://github.com/DataStax-Academy/microservices-java-workshop-online/blob/master/z-materials/images/splash.png?raw=true)

The `Cassandra Developer Workshorp` are an interactive experience. Advocates share some knowledge about part of Apache Cassandra™ database but you can interact with them through the chats *([youtube](https://www.youtube.com/channel/UCAIQY251avaMv7bBv5PCo-A) and [discord](https://discord.com/widget?id=685554030159593522&theme=dark))*, by doing  quizzes (menti.com), by doing the exercises below.

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
There are 2 ways to do the exercises, **locally** on your computer and with a **cloud-based IDE named Gitpod.** We recommend you to use your laptop to get the code modifications your are doing. In both case you should start by cloning this repository to download everything (including the slides).

```bash
# Clone the current repository
git clone https://github.com/DataStax-Academy/microservices-java-workshop-online.git

# Access the proper folder
cd microservices-java-workshop-online
```

### 1.2 Setup your computer to run the exercises

We will create a REST API using the Spring framework stack. Those are the pre-requisites on your laptop.

**1.2.a - Install Java JDK8 +**
- ![Windows](https://github.com/DataStax-Academy/kubernetes-workshop-online/blob/master/4-materials/images/windows32.png?raw=true) Please use the following tutorial [Installation of the JDK on Microsoft Windows Platforms](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-microsoft-windows-platforms.html#GUID-A7E27B90-A28D-4237-9383-A58B416071CA)
- ![linux](https://github.com/DataStax-Academy/kubernetes-workshop-online/blob/master/4-materials/images/linux32.png?raw=true) Please use the following tutorial [Installation of the JDK on Linux Platform Platforms](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-linux-platforms.html#GUID-737A84E4-2EFF-4D38-8E60-3E29D1B884B8)
- ![osx](https://github.com/DataStax-Academy/kubernetes-workshop-online/blob/master/4-materials/images/mac32.png?raw=true) Please use the following tutorial [Installation of the JDK on MACOS Platforms](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-macos.html#GUID-2FE451B0-9572-4E38-A1A5-568B77B146DE) or with homebrew:
```bash
brew cask install java
```

**1.2.b - Install Maven**

`TODO`
- ![Windows](https://github.com/DataStax-Academy/kubernetes-workshop-online/blob/master/4-materials/images/windows32.png?raw=true) Please use the following tutorial [Installation of the JDK on Microsoft Windows Platforms](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-microsoft-windows-platforms.html#GUID-A7E27B90-A28D-4237-9383-A58B416071CA)
- ![linux](https://github.com/DataStax-Academy/kubernetes-workshop-online/blob/master/4-materials/images/linux32.png?raw=true) Please use the following tutorial [Installation of the JDK on Linux Platform Platforms](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-linux-platforms.html#GUID-737A84E4-2EFF-4D38-8E60-3E29D1B884B8)
- ![osx](https://github.com/DataStax-Academy/kubernetes-workshop-online/blob/master/4-materials/images/mac32.png?raw=true) Please use the following tutorial [Installation of the JDK on MACOS Platforms](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-macos.html#GUID-2FE451B0-9572-4E38-A1A5-568B77B146DE) or with homebrew:
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

**1.2.d - Install Docker**
Docker is an open-source project that automates the deployment of software applications inside containers by providing an additional layer of abstraction and automation of OS-level virtualization on Linux.
- ![Windows](https://github.com/DataStax-Academy/kubernetes-workshop-online/blob/master/4-materials/images/windows32.png?raw=true) Please use the following installer [Docker Dekstop for Windows Installer](https://download.docker.com/win/stable/Docker%20Desktop%20Installer.exe)
- ![osx](https://github.com/DataStax-Academy/kubernetes-workshop-online/blob/master/4-materials/images/mac32.png?raw=true) Please use the following installer [Docker Dekstop for MAC Installer](https://download.docker.com/mac/stable/Docker.dmg) or [homebrew](https://docs.brew.sh/Installation) with following commands:
```bash
# Fetch latest version of homebrew and formula.
brew update              
# Tap the Caskroom/Cask repository from Github using HTTPS.
brew tap caskroom/cask                
# Searches all known Casks for a partial or exact match.
brew search docker                    
# Displays information about the given Cask
brew cask info docker
# Install the given cask.
brew cask install docker              
# Remove any older versions from the cellar.
brew cleanup
# Validate installation
docker -v
```
- ![linux](https://github.com/DataStax-Academy/kubernetes-workshop-online/blob/master/4-materials/images/linux32.png?raw=true) You can use the following commands:
```bash
# Remove if already install
sudo yum remove docker \
                  docker-client \
                  docker-client-latest \
                  docker-common \
                  docker-latest \
                  docker-latest-logrotate \
                  docker-logrotate \
                  docker-engine
# Utils
sudo yum install -y yum-utils

# Add docker-ce repo
sudo dnf config-manager --add-repo=https://download.docker.com/linux/centos/docker-ce.repo
# Install
sudo dnf -y  install docker-ce --nobest
# Enable service
sudo systemctl enable --now docker
# Get Status
systemctl status  docker

# Logout....Lougin
exit
# Create user
sudo usermod -aG docker $USER
newgrp docker

# Validation
docker images
docker run hello-world
docker -v
```

**1.2.e - Install Docker Compose**

Docker Compose is a tool for defining and running multi-container Docker applications. It uses YAML files to configure the application's services and performs the creation and start-up process of all the containers with a single command. The `docker-compose` CLI utility allows users to run commands on multiple containers at once, for example, building images, scaling containers, running containers that were stopped, and more. Please refer to [Reference Documentation](https://docs.docker.com/compose/install/) if you have for more detailed instructions.

![Windows](https://github.com/DataStax-Academy/kubernetes-workshop-online/blob/master/4-materials/images/windows32.png?raw=true) : Already **included** in the previous package *Docker for Windows*

![osx](https://github.com/DataStax-Academy/kubernetes-workshop-online/blob/master/4-materials/images/mac32.png?raw=true) : Already **included** in the previous package *Docker for Mac*

![linux](https://github.com/DataStax-Academy/kubernetes-workshop-online/blob/master/4-materials/images/linux32.png?raw=true) : To install on linux (centOS) you can use the following commands

```bash
# Download deliverable and move to target location
sudo curl -L "https://github.com/docker/compose/releases/download/1.23.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose

# Allow execution
sudo chmod +x /usr/local/bin/docker-compose
```

### 1.3 How to setup Cloud-based environment ([gitpod](https://www.gitpod.io/))

Click on the following link, you are set :)
[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/DataStax-Academy/microservices-java-workshop-online)

[Back to Table of Content](#toc)

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

📘  **TodoBackend.com** also provides a client, one of the TodoMVC we saw before. [https://www.todobackend.com/client/index.html) to work with the API. As before pick one of the `endpoints` listed before adn try the client.

![TodoBackendClient](https://github.com/DataStax-Academy/microservices-java-workshop-online/blob/master/z-materials/images/todobackend-runclient.png?raw=true)

**📗 Expected output**

![TodoBackendClient](https://github.com/DataStax-Academy/microservices-java-workshop-online/blob/master/z-materials/images/todobackend-output-client.png?raw=true)

**OUR MISSION NOW SHOUD WE ACCEPT IT IT TO RUN THE REST API ON OUR ENVIRONMENT**



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





