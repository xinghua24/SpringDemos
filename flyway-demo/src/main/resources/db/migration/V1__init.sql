CREATE TABLE IF NOT EXISTS joke (
	jokeid  SERIAL,
	content varchar(255) NOT NULL,
	PRIMARY KEY(jokeid)
)