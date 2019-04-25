# Banking Account Management Project
An application for bank manager to perform various operations on user accounts which exposes some APIs to do some operations.

### Tools and Technology Used

- [Eclipse IDE Tool](https://www.eclipse.org/downloads/packages/release/oxygen/3a/eclipse-ide-java-developers) - IDE for Development
- [JAVA](https://www.oracle.com/technetwork/java/javaee/downloads/jdk8-downloads-2133151.html) - A class based object oriented programming language
- [MySql](https://www.mysql.com/downloads/) - Database-as-a-Service for MySql
- [Postman](https://www.getpostman.com/) - Postman Simplifies API Development

### How to run

[Assuming you have Mysql installed and the mysql server is running at http://localhost:3306]

This application is tested on Java 8

```sh
$ Download code : https://github.com/vneema/banking-account-management.git
$ Open "banking-account-management" directory in eclipse.
$ Select option : Run as "banking-account-management"
```

### Testing

- Open the postman and go to the link 'http://localhost:8080/', if it says `"API is Working"`
- Then test the app by following apis:
  - AddAccount : http://localhost:8080/services/addAccount [POST]
  - GetAll : http://localhost:8080/services/getAll [GET]
  - GetAllUsersWithDeductedAmount : http://localhost:8080/services/deductTaxFromEachAccount [PUT]
  - GetAllTotalBalance : http://localhost:8080/services/getAllBalanceAmount [GET]
  - GetLowestBalance : http://localhost:8080/services/getLowestAccountBalance [GET]
    Note: you have to pass name and balance parameters in the body as json for AddAccount api
   Note: you have to pass percentage parameter in the body as json for GetAllUsersWithDeductedAmount api
