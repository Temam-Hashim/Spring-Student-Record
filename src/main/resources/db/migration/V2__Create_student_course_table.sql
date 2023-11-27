CREATE TABLE  IF NOT EXISTS course(
    courseId UUID PRIMARY KEY NOT NULL,
    courseName VARCHAR(255) NOT NULL UNIQUE,
    description TEXT NOT NULL,
    teacherName VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS student_course(
    studentId UUID NOT NULL REFERENCES student(studentId),
    courseID UUID NOT NULL REFERENCES course(courseId),
    grade INTEGER NOT NULL CHECK(grade>=0 AND grade<=100),
    start_date DATE DEFAULT CURRENT_DATE,
    end_date DATE NOT NULL,
    UNIQUE(studentId,courseId)
);