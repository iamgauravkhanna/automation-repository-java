## klov.

[![Join the chat at https://gitter.im/anshooarora/klov](https://badges.gitter.im/anshooarora/klov.svg)](https://gitter.im/anshooarora/klov?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge) [![Codacy Badge](https://api.codacy.com/project/badge/Grade/ee786f7b7f7f4947b4953398428efa18)](https://www.codacy.com/app/anshooarora/klov?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=anshooarora/klov&amp;utm_campaign=Badge_Grade)

#### Demo:  [klov.herokuapp.com](http://klov.herokuapp.com)

Reporting server for Extent API. * klov replaces ExtentX.

### Download

Download latest copy from [extentreports.com](http://extentreports.com/community/)


### Klov Installation

1. Install MongoDB 3.2 (other versions may not work correctly) (skip if you have this already)
2. Install Redis-Server (skip if you do not plan to use Redis, see section "Using Klov Without Redis")
3. Run Klov:

```java
java -jar klov-0.0.3.jar
```

#### MongoDB Settings

You can configure your MongoDB environment settings from `application.properties`:

```java
# data.mongodb
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=klov
```

#### Redis settings

You can configure your Redis server settings from `application.properties`:

```java
# redis, session
spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.session.SessionAutoConfiguration
spring.session.store-type=redis
server.session.timeout=-1
spring.redis.host=localhost
spring.redis.port=6379
```

#### Using Klov without Redis

To use Klov without Redis, simply uncomment this line in `application.properties`:

```
spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.session.SessionAutoConfiguration
```


#### Default admin

```
user:  root
password:  password
```

### Setting up KlovReporter with ExtentReports API

```java
KlovReporter klov = new KlovReporter();

// specify mongoDb connection
klov.initMongoDbConnection("localhost", 27017);

// specify project
// ! you must specify a project, other a "Default project will be used"
klov.setProjectName("Java");

// you must specify a reportName otherwise a default timestamp will be used
klov.setReportName("AppBuild");

// URL of the KLOV server
// you must specify the server URL to ensure all your runtime media is uploaded
// to the server
klov.setKlovUrl("http://localhost");

// finally, attach the reporter:
extent.attachReporter(klov);
```