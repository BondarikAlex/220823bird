># BirdsManager

>### Oписание создания Jar Project с последующим его преевращением в Docker image запушенным на DockerHab !

>### Далее будет создан и запушен микросервис BirdwatchingCICD на GitHab!

-1. Создание Jar Project. 
   Прежде чем забилдить проект, необходимо предусмотреть отсутствие существующих билдов в корневой папке target .
   - Если таковые иммеются, необходимо сделать копию либо переместить версию билда в другое место!
   - Удаляем содержимое папки target с помощью команды в терминале sudo rm -rf target!
   - Далее билдим проект с помощью mvn clean package!

-2. Создание Dockerfile в корневой директории проекта!
     Прописываем необходимые инструкции в каждом слое!
   - FROM — задаёт базовый (родительский) образ.
   - ARG — задаёт переменные для передачи Docker во время сборки образа.
   - COPY  — копирует в контейнер файлы и папки.
   - ENTRYPOINT — предоставляет команду с аргументами для вызова во время выполнения контейнера. Аргументы не переопределяются.
   
>#### Демонстрация нашего Dockerfile! 
     
   - FROM eclipse-temurin:17.0.8_7-jdk-alpine
   - ARG JAR_FILE=target/spring-app-0.0.1-SNAPSHOT.jar
   - COPY ${JAR_FILE} app.jar
   - ENTRYPOINT ["java","-jar","/app.jar"]
      
-3. Создание Docker image из Jar и запушивание на Docker Hub!
   - В терминале пишем (docker build -t birds:v1 .) - билдим докер образ  указывая что название образа его будет birds а тег v3!
   - Если я правильно понял, необходимо произвести интерактивный вход в реестр с помощью команды docker login! Либо зарегиться на Docker Hub, после повторить процедуру входа (docker login)!
   - После этого сделаем рефактор имени созданного докер образа, указывая названия репы. Делается это для правильной транспортировки образа в Докер хаб, с помощью  команды  docker tag birds:v1  bondariksania/birds:v1 !
   - Создаем репу на докер хабе bondariksania! Далее пушим docker push bondariksania/birds:v1 
-4. Создание правильного docker-compose!
   - Прописываем запуск образов, необходимых для запуска сервиса!
   - Пример: version: "3"
 - services:
 - postgres:
  -  image: postgres:15
   - container_name: postgres
    -environment:
     - POSTGRES_USER: postgres
      -POSTGRES_PASSWORD:   password
      -POSTGRES_DB: postgres
      -PGDATA: /data/postgres
  -  volumes:
   -   - ./postgres:/data/postgres
   - ports:
    -  - 5432:5432
   - restart: unless-stopped23

 - birds:
  -  image: demo:v1
  -  environment:
   -   spring.datasource.url: l
   - ports:
    -  - 8080:8080
   - depends_on:
    -  - postgres
   - networks:
    -  - postgres_default
-5. 
    
  


  
