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
    authorities                VARCHAR(255)
);

CREATE TABLE post
(
    post_id   UUID  NOT NULL,
    title     VARCHAR(255),
    text      VARCHAR(255),
    member_id UUID NOT NULL
);

ALTER TABLE member
    ADD CONSTRAINT PK_member
        PRIMARY KEY (member_id);

ALTER TABLE post
    ADD CONSTRAINT PK_post
        PRIMARY KEY (post_id);

ALTER TABLE post
    ADD CONSTRAINT post_member_fk
        FOREIGN KEY (member_id)
            REFERENCES member;