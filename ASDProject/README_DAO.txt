The following part explains how the Data persistence of the framework works, how to use it for any rental 
application, what kind of pattern used and where. 

FRAMEWORK DAO (Data Access Object)

For persistence, we used simple a file system. Every class will be persisted on different files named by the 
name of the class under ‘datastorage’ directory. If the directory and/or files doesn’t exist it will be created.
 When using file to write the objects, every transaction need to read the whole object and do the update or 
 remove and then rewrite the everything back. To avoid this in our application control the pertinence by a 
 time interval, every interval it will be flashed to the file. All transaction will be done in memory. 
 Thus, improving the performance.
 
When dive to how objects are persisted, in the DAO we have one generic DAO interface and implementation that 
takes care of all the common persistence tasks (save, remove, find all). For the other framework domains, they 
will extend this interface/class and add their own specific implementation. 

The framework has two types of domain class, one abstract class that can be extended by application and add any
 behavior and/or properties and the other one is concrete class that if the application developer wants to use 
 the class as it is, he will have the option. The later class will extend the abstract class of the same class. 
 Because of these we will have two types of DAO for each domain class. These are one for abstract class that is 
 a generic one and will be inherited by application domain class. The other for the concrete class to be used 
 as it is. When inherited class type and class should be passed for constructor.
 
 The writing and read part from file and to file uses a proxy and singleton pattern. For the singleton 
 (FileInstance) is for opening closing the. The singleton is applied using enum. Then proxy is used the access 
 the actual list of each class to write is to file and write it. We have a proxy interface with two methods
 write and read. Then is there is the actual class that has the implementation and involved with actual writing 
 and reading working with the singleton. Other than the actual implantation class there is the proxy class that 
 as association with implementation. Then the generic DAO will use the proxy to do these jobs. The generic DAO 
 will not have any means to use the actual application it can only uses the proxy.
 
HOW TO USE DAO FOR THE APPLICATION

To build application’s DAO simply inherit a A[DamainDaoImpl] and pass class type and name to the super class 
constructor. And any additional behavior you need other than add, remove, update, find all, find by Id and 
name.