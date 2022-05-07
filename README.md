# LeapSquare assignment.

A few points before we start into the project,
- I spent quite alot of time working with golang and I got stuck with the mysql driver and I couldn't get anywhere. But 
since I wanted to submit this assignment, I did it in java-spring boot, using the regular MVC pattern.
- One of the endpoints `update`, under it's functionality is calling the repository twice, once to delete the resource
and once to create a new resource instead of directly just updating with a single query. I considered doing that but again
  time constraints to submit the assignment and I had the two different services/repositories created for the previous tasks
  of this assignment. But I could do it, if you still want me to, wouldn't take long to create a new service and repository and test the same.
  
----------
### Implemented points

- Run the project using `mvn spring-boot:run` and the project will run on http://localhost:8082.

- I've added `open-api` for API documentation and it can be accessed on http://localhost:8082/api-docs/
  
- 
```
swagger 3 has been buggy with my local maven so didn't use swagger.
``` 