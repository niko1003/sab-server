
INSERT INTO roles(name, created_at, updated_at) VALUES('ROLE_USER', now(), now()) ON CONFLICT DO NOTHING;
INSERT INTO roles(name, created_at, updated_at) VALUES('ROLE_MODERATOR', now(), now()) ON CONFLICT DO NOTHING;
INSERT INTO roles(name, created_at, updated_at) VALUES('ROLE_ADMIN', now(), now()) ON CONFLICT DO NOTHING;


INSERT INTO priorities(name, description, created_at, updated_at) VALUES('CRITICAL', 'critical events', now(), now()) ON CONFLICT DO NOTHING;
INSERT INTO priorities(name, description, created_at, updated_at) VALUES('MAJOR', 'major events', now(), now()) ON CONFLICT DO NOTHING;
INSERT INTO priorities(name, description, created_at, updated_at) VALUES('NORMAL', 'normal events', now(), now()) ON CONFLICT DO NOTHING;
INSERT INTO priorities(name, description, created_at, updated_at) VALUES('MINOR', 'minor events', now(), now()) ON CONFLICT DO NOTHING;
INSERT INTO priorities(name, description, created_at, updated_at) VALUES('TRIVIAL', 'trivial events', now(), now()) ON CONFLICT DO NOTHING;

INSERT INTO privacy_levels(name, description, created_at, updated_at) VALUES('PUBLIC', 'visible for everyone', now(), now()) ON CONFLICT DO NOTHING;
INSERT INTO privacy_levels(name, description, created_at, updated_at) VALUES('BAND', 'visible for fellow band members', now(), now()) ON CONFLICT DO NOTHING;
INSERT INTO privacy_levels(name, description, created_at, updated_at) VALUES('PRIVATE', 'visible for me, + invitations', now(), now()) ON CONFLICT DO NOTHING;

