CREATE TABLE member_team
(
    member_id UUID UNIQUE,
    team_id   UUID UNIQUE
);

ALTER TABLE member_team
    ADD CONSTRAINT member_team_pk
        PRIMARY KEY (member_id, team_id);

ALTER TABLE member_team
    ADD CONSTRAINT member_join_fk
        FOREIGN KEY (member_id)
            REFERENCES classconect.public.member;

ALTER TABLE member_team
    ADD CONSTRAINT team_join_fk
        FOREIGN KEY (team_id)
            REFERENCES classconect.public.team;

ALTER TABLE classconect.public.team
ADD COLUMN group_admin UUID UNIQUE