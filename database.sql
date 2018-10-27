 create table users(
      username varchar_ignorecase(50) not null primary key,
      password varchar_ignorecase(50) not null,
      enabled boolean not null);

  create table authorities (
      username varchar_ignorecase(50) not null,
      authority varchar_ignorecase(50) not null,
      constraint fk_authorities_users foreign key(username) references users(username));
      create unique index ix_auth_username on authorities (username,authority);
      
INSERT INTO `users` (`username`, `password`, `enabled`) VALUES ('user1', '$2a$10$os20OiAqjIouGSTjD9ZSsuKehhF2RUAOPHcS6RegqO33aijOHc6lG', true);
INSERT INTO `notesdb`.`authorities` (`username`, `authority`) VALUES ('user1', 'ROLE_USER');


user1 = $2a$10$ioS5OsdpbD53ckW0QGyEVOuWgrxVeB7j4MehFKsAXSXJ9w2LmWYAa