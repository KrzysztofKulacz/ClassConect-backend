drop table if exists user1 CASCADE;
drop table if exists group1 CASCADE;
drop table if exists post CASCADE;
drop table if exists user1_groups CASCADE;

create table user1 (
                       id uuid not null,
                       username varchar(255),
                       password varchar(255),
                       email varchar(255),
                       is_account_non_expired boolean,
                       is_account_non_locked boolean,
                       is_credentials_non_expired boolean,
                       is_enabled boolean,
                       authorities varchar(255)
);

ALTER TABLE user1
    add constraint PK_user1 primary key (id);

create table group1 (
                        group_admin uuid not null,
                        subject varchar(255),
                        password varchar(255)
);

ALTER TABLE group1
    add constraint PK_group1 primary key (group_admin);

create table post (
                      id uuid not null,
                      title varchar(255),
                      text  varchar(255),
                      user1 uuid not null,
                      group1 uuid not null
);

ALTER TABLE post
    add constraint PK_post primary key (id);

CREATE TABLE user1_groups (
    users_id uuid not null ,
    groups_group_admin uuid not null
);

ALTER TABLE user1_groups
    add constraint PK_user_group primary key (users_id, groups_group_admin);

ALTER TABLE user1_groups
    add constraint user_group_fk
        foreign key (users_id)
            references user1;
ALTER TABLE user1_groups
    add constraint group_user_fk
        foreign key (groups_group_admin)
            references group1;


ALTER TABLE post
    add constraint user_post_fk
        foreign key (user1)
            references user1;

ALTER TABLE post
    add constraint group_post_fk
        foreign key (group1)
            references group1