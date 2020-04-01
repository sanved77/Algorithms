# System Design Notes

## Basic Skeleton

1. Write down the requirements of the system, what is should do and what are the operations expected and design APIs
2. Measure the capacity of the system by calculating the total resources needed.
3. Based no the above data, decide what would be the ideal data storage practice
4. Design the system one by one while keeping the services in mind
5. Try to optimize the services by creating microservices
6. Try data optimization using Sharding/Caching or something similar
7. Eradicate single points of failure byt adding Load Balancers

## Concepts
[Database Sharding](https://www.digitalocean.com/community/tutorials/understanding-database-sharding)
[Load Balancers](https://www.nginx.com/resources/glossary/load-balancing/)


 ## Tools
[ZooKeeper](https://zookeeper.apache.org/)
What is ZooKeeper?
ZooKeeper is a centralized service for maintaining configuration information, naming, providing distributed synchronization, and providing group services. All of these kinds of services are used in some form or another by distributed applications. Each time they are implemented there is a lot of work that goes into fixing the bugs and race conditions that are inevitable. Because of the difficulty of implementing these kinds of services, applications initially usually skimp on them, which make them brittle in the presence of change and difficult to manage. Even when done correctly, different implementations of these services lead to management complexity when the applications are deployed.