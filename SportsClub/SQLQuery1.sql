CREATE DATABASE Students;
GO

USE Students;
GO

CREATE TABLE marks (
    id INT PRIMARY KEY,
    student_name VARCHAR(50),
    subject VARCHAR(50),
    mark INT
);
INSERT INTO marks (id, student_name, subject, mark) VALUES
(1, 'John Doe', 'Mathematics', 85),
(2, 'Jane Smith', 'Mathematics', 90),
(3, 'Alice Johnson', 'Science', 95),
(4, 'Bob Brown', 'History', 75),
(5, 'Charlie Davis', 'Geography', 80);
