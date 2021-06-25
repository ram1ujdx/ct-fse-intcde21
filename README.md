# Steps and Instructions

## Running Docker Containers on EC2

### SSH to your instance -

```text

1. Launch a new ec2 instance
2. save the key to your local machine
3. install putty
4. generate ppk from pem and save it
5. run putty and mention the public ip address of ec2
6. add ssh->auth->browse->add the saved ppk file
7. open

```

### Installing docker on ec2

```text

1. sudo yum update -y
2. sudo yum install docker -y
3. sudo service docker start
4. Add ec2-user to the docker group 
sudo usermod -a -G docker ec2-user
5. docker  -v

```


## Running Spring Boot Apps with Mysql On Docker

### Running Mysql On Docker

```bash

docker run -d -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=docker -e MYSQL_USER=docker -e MYSQL_PASSWORD=password -p 3306:3306 --name mysql mysql

```

### Running app with Mysql (Through Host Network)

```bash
docker run -d -p 5000:5000 -e RDS_HOSTNAME=3.17.157.238 -e RDS_DB_NAME=docker -e RDS_PORT=3306 -e RDS_PASSWORD=password --name rest-api-db-app rest-api-db-app 
```

### Running app with Mysql (Link Based Communication)

```bash
docker run -d -p 5000:5000 -e RDS_HOSTNAME=mysql --link mysql -e RDS_DB_NAME=docker -e RDS_PORT=3306 -e RDS_PASSWORD=password --name rest-api-db-app rest-api-db-app 
```

### Running app with Mysql (Network Based Communication)

* Create a network

```bash
docker network create app-network
```

* Run Mysql on app-network :

```bash
docker run -d --network=app-network -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=docker -e MYSQL_USER=docker -e MYSQL_PASSWORD=password -p 3306:3306 --name mysql mysql
```

* Run Java on app-network :

```bash
docker run -d -p 5000:5000 --network=app-network -e RDS_HOSTNAME=mysql -e RDS_DB_NAME=docker -e RDS_PORT=3306 -e RDS_PASSWORD=password --name rest-api-db-app rest-api-db-app 
```



### Persisting Mysql Data:

* Create a docker volume

```bash
docker volume create app-data
```
* Running Mysql Container with the volume

```bash
docker run -d --network=app-network -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=docker -e MYSQL_USER=docker -e MYSQL_PASSWORD=password -p 3306:3306 --volume add-data:/var/lib/mysql --name mysql mysql
```

