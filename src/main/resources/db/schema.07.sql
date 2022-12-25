ALTER TABLE classconect.public.team
    ADD COLUMN team_name VARCHAR(255);
ALTER TABLE classconect.public.team
    ADD COLUMN image_url VARCHAR(255);
ALTER TABLE classconect.public.team
    ADD COLUMN description VARCHAR(255);

ALTER TABLE classconect.public.team
    ADD CONSTRAINT unique_team_name UNIQUE (team_name)

