insert into user_tb(username, password, email, createdAt) values('ssar', '1234', 'ssar@nate.com', now());
insert into user_tb(username, password, email, createdAt) values('cos', '1234', 'cos@nate.com', now());
insert into user_tb(username, password, email, createdAt) values('love', '1234', 'love@nate.com', now());
insert into user_tb(username, password, email, createdAt) values('abc', '1234', 'abc@nate.com', now());


insert into board_tb(title, userId, createdAt) values('첫 번째 글입니다.', 1, now());
insert into board_tb(title, userId, createdAt) values('두 번째 글입니다.', 1, now());
insert into board_tb(title, userId, createdAt) values('세 번째 글입니다.', 1, now());
insert into board_tb(title, userId, createdAt) values('네 번째 글입니다.', 1, now());
insert into board_tb(title, userId, createdAt) values('다섯 번째 글입니다.', 1, now());
insert into board_tb(title, userId, createdAt) values('여섯 번째 글입니다.', 2, now());
insert into board_tb(title, userId, createdAt) values('일곱 번째 글입니다.', 2, now());
insert into board_tb(title, userId, createdAt) values('여덟 번째 글입니다.', 2, now());
insert into board_tb(title, userId, createdAt) values('아홉 번째 글입니다.', 2, now());
insert into board_tb(title, userId, createdAt) values('열 번째 글입니다.', 2, now());


commit;