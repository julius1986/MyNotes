 create table users(
      username varchar(50) not null primary key,
      password varchar(255) not null,
      enabled boolean not null);

  create table authorities (
      username varchar(50) not null,
      authority varchar(50) not null,
      constraint fk_authorities_users foreign key(username) references users(username));
      create unique index ix_auth_username on authorities (username,authority);
      
INSERT INTO `users` (`username`, `password`, `enabled`) VALUES ('user3', '$2a$10$mBC0aTmSvDGG0sKgifhKtu9q.23YR8BnsJ0ynPAiFcG8Mrz/x.wA6', true);
INSERT INTO `notesdb`.`authorities` (`username`, `authority`) VALUES ('user3', 'ROLE_USER');


user3 = $2a$10$mBC0aTmSvDGG0sKgifhKtu9q.23YR8BnsJ0ynPAiFcG8Mrz/x.wA6