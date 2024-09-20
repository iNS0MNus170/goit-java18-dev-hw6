INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES
('Olena Ivanova', '1985-01-15', 'Senior', 7000),
('Bohdan Kovalenko', '1990-02-17', 'Middle', 4500),
('Mykola Petrenko', '1995-03-18', 'Junior', 3000),
('Oleksiy Shevchenko', '1987-05-21', 'Senior', 8000),
('Kateryna Tkachenko', '1993-07-22', 'Middle', 4600),
('Andriy Kravets', '2000-08-23', 'Trainee', 500),
('Volodymyr Horbatyuk', '1998-09-24', 'Junior', 2900),
('Halyna Sydorenko', '1997-10-25', 'Trainee', 600),
('Ivan Melnyk', '1992-11-26', 'Middle', 4700),
('Oleh Lyashenko', '1983-12-27', 'Senior', 9000);


INSERT INTO client (NAME) VALUES
('Andriy Bondar'),
('Svitlana Hrytsenko'),
('Oksana Tkach'),
('Yuriy Lytvynenko'),
('Tamara Zaytseva');

INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES
 (1, '2023-01-01', '2024-01-01'),
 (2, '2023-02-01', '2025-02-01'),
 (3, '2023-03-01', '2024-03-01'),
 (4, '2023-04-01', '2026-04-01'),
 (5, '2023-05-01', '2024-11-01'),
 (5, '2023-06-01', '2024-06-01'),
 (2, '2023-07-01', '2025-07-01'),
 (1, '2023-08-01', '2024-08-01'),
 (3, '2023-09-01', '2026-09-01'),
 (5, '2023-10-01', '2024-10-01');

INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
(1, 1), (1, 2), (1, 3),
(2, 3), (2, 4), (2, 5),
(3, 6), (3, 7),
(4, 8), (4, 9), (4, 10),
(5, 1), (5, 2),
(6, 3), (6, 4),
(7, 5), (7, 6),
(8, 7), (8, 8),
(9, 9), (9, 10),
(10, 1), (10, 2), (10, 3);