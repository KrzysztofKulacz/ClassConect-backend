DROP TABLE IF EXISTS member CASCADE;
DROP TABLE IF EXISTS squad CASCADE;
DROP TABLE IF EXISTS post CASCADE;
DROP TABLE IF EXISTS member_squads CASCADE;

CREATE TABLE member (
                       id UUID NOT NULL,
                       username VARCHAR(255),
                       password VARCHAR(255),
                       email VARCHAR(255),
                       is_account_non_expired BOOLEAN,
                       is_account_non_locked BOOLEAN,
                       is_credentials_non_expired BOOLEAN,
                       is_enabled BOOLEAN,
                       authorities VARCHAR(255),
                       post_id UUID NOT NULL
);

CREATE TABLE post (
                      id UUID NOT NULL,
                      title VARCHAR(255),
                      text  VARCHAR(255),
                      member UUID NOT NULL,
                      squad UUID NOT NULL
);

CREATE TABLE squad (
                       squad_admin UUID NOT NULL,
                       subject VARCHAR(255),
                       password VARCHAR(255),
                       post_id UUID NOT NULL
);

CREATE TABLE member_squads (
                               members_id UUID NOT NULL ,
                               squads_squad_admin UUID NOT NULL
);

-- ######################################################################

ALTER TABLE member
    ADD CONSTRAINT PK_member PRIMARY KEY (id);

ALTER TABLE squad
    ADD CONSTRAINT PK_squad PRIMARY KEY (squad_admin);

ALTER TABLE post
    ADD CONSTRAINT PK_post PRIMARY KEY (id);

ALTER TABLE member_squads
    ADD CONSTRAINT PK_member_squad PRIMARY KEY (members_id, squads_squad_admin);

-- ######################################################################

ALTER TABLE member
    ADD CONSTRAINT member_post_fk
        FOREIGN KEY (post_id)
            REFERENCES post;

ALTER TABLE squad
    ADD CONSTRAINT squad_post_fk
        FOREIGN KEY (post_id)
            REFERENCES post;

ALTER TABLE post
    ADD CONSTRAINT member_post_fk
        FOREIGN KEY (member)
            REFERENCES member;

ALTER TABLE post
    ADD CONSTRAINT squad_post_fk
        FOREIGN KEY (squad)
            REFERENCES squad;

ALTER TABLE member_squads
    ADD CONSTRAINT member_squad_fk
        FOREIGN KEY (members_id)
            REFERENCES member;
ALTER TABLE member_squads
    ADD CONSTRAINT squad_member_fk
        FOREIGN KEY (squads_squad_admin)
            REFERENCES squad;
