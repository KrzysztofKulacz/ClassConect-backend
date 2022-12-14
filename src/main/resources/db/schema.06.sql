ALTER TABLE classconect.public.member
    ADD COLUMN role VARCHAR(255);

ALTER TABLE classconect.public.team
    ADD COLUMN title VARCHAR(255) UNIQUE;

ALTER TABLE classconect.public.team
    ADD COLUMN description VARCHAR(255);

