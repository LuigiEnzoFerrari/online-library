CREATE TABLE book (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    available BOOLEAN NOT NULL DEFAULT TRUE,
    stock INT NOT NULL
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY NOT NULL,
    login VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE reservation (
    id SERIAL PRIMARY KEY,
    userId INT NOT NULL,
    bookId INT NOT NULL,
    FOREIGN KEY (userId) REFERENCES users(id),
    FOREIGN KEY (bookId) REFERENCES book(id)
);

CREATE TABLE review (
    id SERIAL PRIMARY KEY,
    userId INT NOT NULL,
    bookId INT NOT NULL,
    reviews VARCHAR(255),
    FOREIGN KEY (userId) REFERENCES users(id),
    FOREIGN KEY (bookId) REFERENCES book(id)
);

