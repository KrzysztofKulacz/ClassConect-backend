CREATE TABLE team
(
    team_id  UUID UNIQUE,
    subject  VARCHAR(255),
    password VARCHAR(255)
);

ALTER TABLE team
    ADD CONSTRAINT pk_team PRIMARY KEY (team_id);

ALTER TABLE classconect.public.post
    ADD COLUMN team_id UUID UNIQUE;

ALTER TABLE classconect.public.post
    ADD CONSTRAINT post_team_fk
        FOREIGN KEY (team_id)
            REFERENCES team;