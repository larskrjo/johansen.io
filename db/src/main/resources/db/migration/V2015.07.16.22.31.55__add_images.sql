CREATE TABLE Image (
  id char(36) NOT NULL,
  url varchar(512) NOT NULL,
  description varchar(512) NOT NULL,
  size varchar(250) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX size_index (`size`)
);

# Full page images
INSERT INTO Image (id, url, description, size) values ('b9045cfd-cc23-48ff-a0b7-286d2396b32b', 'resources/imgs/norway-front-page.jpg', 'Norway, Northern Lights.', '1920x1200');

# Header images
INSERT INTO Image (id, url, description, size) values ('2edfee92-f387-4fd6-bbb3-6b850dbb7709', 'resources/imgs/san-francisco-bridge-2.jpg', 'San Francisco, Golden Gate Bridge.', '1920x300');
INSERT INTO Image (id, url, description, size) values ('dbe70cd0-e4bc-4acd-a750-670477d8fdcd', 'resources/imgs/san-francisco-bridge.jpg', 'San Francisco, Golden Gate Bridge.', '1920x300');
INSERT INTO Image (id, url, description, size) values ('f97ac077-7865-4c58-ad28-9123bd1ea7c8', 'resources/imgs/norway-mountain.jpg', 'Norway, Mountains.', '1920x300');
INSERT INTO Image (id, url, description, size) values ('6b5bcf54-be2c-46e3-840b-720338b620e6', 'resources/imgs/norway-mountain-2.jpg', 'Norway, Mountains.', '1920x300');

# Section images
INSERT INTO Image (id, url, description, size) values ('1c66a701-8d5a-469f-bb62-304072a2b393', 'resources/imgs/dropbox.png', 'Dropbox.', '960x600');
INSERT INTO Image (id, url, description, size) values ('85beec1a-ea98-426b-a449-f1e2d623bc8c', 'resources/imgs/dropbox.png', 'Dropbox.', '960x600');
INSERT INTO Image (id, url, description, size) values ('48c47123-0a1d-465b-93f5-cdbb2a934e35', 'resources/imgs/dropbox.png', 'Dropbox.', '960x600');
INSERT INTO Image (id, url, description, size) values ('3f09b245-6c12-423f-a292-b88592b042d8', 'resources/imgs/dropbox.png', 'Dropbox.', '960x600');