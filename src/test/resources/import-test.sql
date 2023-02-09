

INSERT INTO users (id, uid, token, username) VALUES (100, '123', 'asd', 'test');
INSERT INTO users (id, uid, token, username) VALUES (200, '1234', 'asdd', 'test2');
INSERT INTO users (id, uid, token, username) VALUES (300, '12345', 'asddd', 'test3');

INSERT INTO users_users VALUES (100, 200);
INSERT INTO users_users VALUES (200, 100);



