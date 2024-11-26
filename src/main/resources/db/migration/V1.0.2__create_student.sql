CREATE TABLE student
(
    id       INT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(50)        NULL,
    score    DOUBLE             NOT NULL,
    address  VARCHAR(255)       NULL,
    clazz_id INT                NULL,
    avt      VARCHAR(50)        NULL,
    CONSTRAINT pk_student PRIMARY KEY (id)
);

ALTER TABLE student
    ADD CONSTRAINT FK_STUDENT_ON_CLAZZ FOREIGN KEY (clazz_id) REFERENCES clazz (id);