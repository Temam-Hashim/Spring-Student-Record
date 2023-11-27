CREATE  TABLE IF NOT EXISTS student (
    studentId uuid PRIMARY KEY NOT NULL,
    firstName VARCHAR(100) NOT NULL,
    lastName VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    mobile VARCHAR(25) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    gender VARCHAR(6) NOT NULL
    CHECK (
    gender='MALE' OR gender='male' OR
    gender='FEMALE' OR gender='female'
          ),
    created_at TIMESTAMP DEFAULT current_timestamp
    )