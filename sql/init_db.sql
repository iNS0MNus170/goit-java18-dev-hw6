DROP TABLE IF EXISTS project_worker CASCADE;
DROP TABLE IF EXISTS project CASCADE;
DROP TABLE IF EXISTS client CASCADE;
DROP TABLE IF EXISTS worker CASCADE;

CREATE TABLE worker (
                        ID SERIAL PRIMARY KEY,
                        NAME VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) BETWEEN 2 AND 1000),
                        BIRTHDAY DATE NOT NULL CHECK (EXTRACT(YEAR FROM BIRTHDAY) > 1900),
                        LEVEL VARCHAR(10) NOT NULL CHECK (LEVEL IN ('Trainee', 'Junior', 'Middle', 'Senior')),
                        SALARY INTEGER NOT NULL CHECK (SALARY BETWEEN 100 AND 100000)
);


CREATE TABLE client (
                        ID SERIAL PRIMARY KEY,
                        NAME VARCHAR(1000) NOT NULL CHECK (LENGTH(NAME) BETWEEN 2 AND 1000)
);

CREATE TABLE project (
                         ID SERIAL PRIMARY KEY,
                         CLIENT_ID INTEGER REFERENCES client(ID),
                         START_DATE DATE NOT NULL,
                         FINISH_DATE DATE NOT NULL
);

CREATE TABLE project_worker (
                                PROJECT_ID INTEGER REFERENCES project(ID),
                                WORKER_ID INTEGER REFERENCES worker(ID),
                                PRIMARY KEY (PROJECT_ID, WORKER_ID)
);