# spb-hibernate-logging

1. Generate eventId in filter for every request and print out to log the following: what url + method were invoked in the request and also print out the response body, attached with eventId
2. Diagnostics controller returns from datasource how many active connections are in the pool how many are idle and what's the max num of connections
3. Logged with aspect all service methods invoked and how long they took to complete, attached eventId with MDC
4. Enabled hibernate logging statistics


Links:
http://localhost:8080/swagger-ui/index.html
http://localhost:8080/h2-console/
