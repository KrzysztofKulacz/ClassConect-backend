CREATE TABLE member
(
    member_id                  UUID NOT NULL,
    username                   VARCHAR(255),
    password                   VARCHAR(255),
    email                      VARCHAR(255),
    is_account_non_expired     BOOLEAN,
    is_account_non_locked      BOOLEAN,
    is_credentials_non_expired BOOLEAN,
    is_enabled                 BOOLEAN,
    authorities                VARCHAR(255),
    creation_date              TIMESTAMP,
    activation_code            UUID UNIQUE,
    role                       VARCHAR(255)
);

CREATE TABLE post
(
    post_id         UUID NOT NULL,
    title           VARCHAR(255),
    text            VARCHAR(255),
    member_id       UUID NOT NULL,
    team_id         UUID,
    creation_date   TIMESTAMP
);

CREATE TABLE team
(
    team_id         UUID UNIQUE,
    subject         VARCHAR(255),
    password        VARCHAR(255),
    team_admin      UUID,
    creation_date   TIMESTAMP,
    team_name       VARCHAR(255),
    image_url       VARCHAR(255),
    description     VARCHAR(255)
);

CREATE TABLE member_team
  (
      member_id UUID,
      team_id   UUID
  );

ALTER TABLE member
    ADD CONSTRAINT PK_member
        PRIMARY KEY (member_id);

ALTER TABLE team
    ADD CONSTRAINT pk_team PRIMARY KEY (team_id),
    ADD CONSTRAINT unique_team_name UNIQUE (team_name);

ALTER TABLE post
    ADD CONSTRAINT PK_post
        PRIMARY KEY (post_id),

    ADD CONSTRAINT post_member_fk
        FOREIGN KEY (member_id)
            REFERENCES member,

    ADD CONSTRAINT post_team_fk
        FOREIGN KEY (team_id)
            REFERENCES team;

ALTER TABLE member_team
    ADD CONSTRAINT member_team_pk
        PRIMARY KEY (member_id, team_id),

    ADD CONSTRAINT member_join_fk
        FOREIGN KEY (member_id)
            REFERENCES member,

    ADD CONSTRAINT team_join_fk
        FOREIGN KEY (team_id)
            REFERENCES team;



