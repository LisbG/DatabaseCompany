# Database - Company

> status: Developing

### It's a CRUD application that manage a company, their workers and active contracts.

## Technologies used:

<table>
<tr>
<td>Java</td>
<td>MySql</td>
</tr>

<tr>
<td>jdk - 17</td>
<td>8.0</td>
</tr>
</table>

## MySql Queries:

~~~
create database CompanyModel;
~~~

~~~
create table Company(CompanyId int auto_increment primary key,
    CompanyName varchar(80),
    CompanyEmail varchar(100));
~~~

~~~
create table Department(DepartmentId int auto_increment primary key,
    DepartmentName varchar(20));
~~~

~~~
create table WorkLevel(WorkLevelId int auto_increment primary key,
    WorkerLevelName varchar(20));
~~~

~~~
CREATE TABLE Worker (
    WorkerId INT AUTO_INCREMENT PRIMARY KEY,
    WorkerName VARCHAR(60),
    WorkerBaseSalary DOUBLE,
    CompanyId INT,
    CONSTRAINT fk_CompanyId FOREIGN KEY (CompanyId)
        REFERENCES company (CompanyId)
);
~~~

~~~
CREATE TABLE Contract (
    ContractId INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    ContractValuePerHour DOUBLE,
    ContractTotalHours INT,
    ContractDate DATE,
    WorkerId INT,
    CONSTRAINT WorkerId_fk FOREIGN KEY (WorkerId)
      REFERENCES worker (WorkerId)
)
~~~
