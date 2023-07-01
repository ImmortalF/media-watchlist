-- User table
CREATE TABLE users (
  id SERIAL PRIMARY KEY,
  username VARCHAR(255) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  email VARCHAR(255) UNIQUE NOT NULL,
  role VARCHAR(255) DEFAULT "USER"
);

-- Media table
CREATE TABLE media (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(255),
  type VARCHAR(255) NOT NULL
);

-- Comment table
CREATE TABLE comments (
  id SERIAL PRIMARY KEY,
  commentText VARCHAR(255) NOT NULL,
  userId INT NOT NULL,
  mediaId INT NOT NULL,
  FOREIGN KEY (userId) REFERENCES users(id),
  FOREIGN KEY (mediaId) REFERENCES media(id)
);

-- Status table
CREATE TABLE status (
  id SERIAL PRIMARY KEY,
  userId INT NOT NULL,
  mediaId INT NOT NULL,
  status VARCHAR(255) NOT NULL,
  FOREIGN KEY (userId) REFERENCES users(id),
  FOREIGN KEY (mediaId) REFERENCES media(id)
);
