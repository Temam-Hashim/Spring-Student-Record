CREATE TYPE ENUM as ENUM('MALE','FEMALE');

ALTER TABLE student ALTER COLUMN gender TYPE ENUM USING (gender::ENUM);