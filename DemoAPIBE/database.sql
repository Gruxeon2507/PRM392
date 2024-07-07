CREATE DATABASE PRM392_DemoApiDB;
USE PRM392_DemoApiDB; -- Switch to your database
CREATE TABLE Account (
    Id INT PRIMARY KEY, -- Primary key
    Name NVARCHAR(255), -- Name column
    Password NVARCHAR(255), -- Password column
    Detail NVARCHAR(255) -- Detail column
);

INSERT INTO Account (Id, Name, Password, Detail)
VALUES (1, 'John Doe', 'password123', 'Sample detail 1'),
       (2, 'Jane Smith', 'passw0rd', 'Sample detail 2');
