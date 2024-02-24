# Oauth2 Authorization Server 

OAuth authorization server will serve as an authentication source for both the article resource and client servers.

## Dependency 
* Java 21
* spring boot 3.2.3
* oauth2-authorization-server 
* oauth2-client
* spring security 
* h2 database

## Set oauth2 client on application.yml 

``` 
spring:
  security:
    oauth2:
      client:
        registration:
          google-idp:
            provider: google
            client-id: ${GOOGLE_CLIENT_ID:google-client-id}
            client-secret: ${GOOGLE_CLIENT_SECRET:google-client-secret}
            scope: openid, https://www.googleapis.com/auth/userinfo.profile, https://www.googleapis.com/auth/userinfo.email
            client-name: Sign in with Google
```

## Endpoints
http://localhost:9000/oauth2/token [POST]

``` 
client_id=messaging-client
client_secret=secret
grant_type=client_credentials
```

http://localhost:9000/.well-known/oauth-authorization-server [GET]



## H2 Database 
http://localhost:9000/h2

``` 
user=sa
password=test
```
DDL & DML: src/main/resources/data.sql





