CREATE TABLE book (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    available BOOLEAN NOT NULL DEFAULT TRUE,
    stock INT NOT NULL DEFAULT 1
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY NOT NULL,
    login VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE reservation (
    id SERIAL PRIMARY KEY,
    userid INT NOT NULL,
    bookid INT NOT NULL,
    FOREIGN KEY (userid) REFERENCES users(id),
    FOREIGN KEY (bookid) REFERENCES book(id)
);

CREATE TABLE review (
    id SERIAL PRIMARY KEY,
    userid INT NOT NULL,
    bookid INT NOT NULL,
    review VARCHAR(255),
    FOREIGN KEY (userid) REFERENCES users(id),
    FOREIGN KEY (bookid) REFERENCES book(id)
);

