# spb-hibernate-logging

1. Generate eventId in filter for every request and print out to log the following: what url + method were invoked in the request and also print out the response body, attached with eventId
2. Diagnostics controller returns from datasource how many active connections are in the pool how many are idle and what's the max num of connections
3. Enabled hibernate logging statistics BUT... don't know how to attach generated eventId to hibernate logs..
