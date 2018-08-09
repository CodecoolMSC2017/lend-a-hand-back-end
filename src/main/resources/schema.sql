DROP TABLE IF EXISTS notifications;
DROP TABLE IF EXISTS messages;
DROP TABLE IF EXISTS applications;
DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS employer_ratings;
DROP TABLE IF EXISTS employee_ratings;
DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    email VARCHAR(32),
    phone VARCHAR(32),
    username VARCHAR(60) UNIQUE NOT NULL,
    password VARCHAR(60) NOT NULL,
    picture_link TEXT,
    full_name TEXT,
    type VARCHAR(16),
    postal_code VARCHAR(16),
    city TEXT,
    address TEXT,
    balance INTEGER ,
    reported INTEGER ,
    blocked BOOLEAN ,
    employee_rating_score NUMERIC ,
    employer_rating_score NUMERIC ,
    able_to_ad BOOLEAN ,
    enabled BOOLEAN,
    verificated BOOLEAN,
    verification_code TEXT
);

CREATE TABLE authorities (
    username VARCHAR(60) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES users("username")  ON DELETE CASCADE,
    UNIQUE (username, authority)
);

CREATE TABLE employee_ratings (
  id SERIAL PRIMARY KEY,
  rater_id INTEGER NOT NULL,
  rated_id INTEGER NOT NULL,
  rating INTEGER NOT NULL,
  rating_text TEXT NOT NULL,
  application_id INTEGER NOT NULL,
  FOREIGN KEY (application_id) REFERENCES applications("id"),
  FOREIGN KEY (rater_id) REFERENCES users("id"),
  FOREIGN KEY (rated_id) REFERENCES users("id") ON DELETE CASCADE
);

CREATE TABLE employer_ratings (
  id SERIAL PRIMARY KEY,
  rater_id INTEGER NOT NULL,
  rated_id INTEGER NOT NULL,
  rating INTEGER NOT NULL,
  rating_text TEXT NOT NULL,
  application_id INTEGER NOT NULL,
  FOREIGN KEY (application_id) REFERENCES applications("id"),
  FOREIGN KEY (rater_id) REFERENCES users("id"),
  FOREIGN KEY (rated_id) REFERENCES users("id") ON DELETE CASCADE
);

CREATE TABLE ads (
  id SERIAL PRIMARY KEY,
  advertiser_id INTEGER NOT NULL,
  title VARCHAR(64) NOT NULL,
  description TEXT NOT NULL,
  picture_link TEXT,
  payment INTEGER,
  category VARCHAR(32) NOT NULL,
  is_premium BOOLEAN NOT NULL,
  timestamp TIMESTAMP NOT NULL,
  type VARCHAR(16) NOT NULL,
  state TEXT NOT NULL,
  FOREIGN KEY (advertiser_id) REFERENCES users("id") ON DELETE CASCADE
);

CREATE TABLE applications (
  id SERIAL PRIMARY KEY,
  ad_id INTEGER NOT NULL,
  applicant_id INTEGER NOT NULL,
  message TEXT,
  timestamp TIMESTAMP NOT NULL,
  state TEXT NOT NULL,
  FOREIGN KEY (ad_id) REFERENCES ads("id") ON DELETE CASCADE,
  FOREIGN KEY (applicant_id) REFERENCES users("id") ON DELETE CASCADE
);

CREATE TABLE messages (
  id SERIAL PRIMARY KEY,
  sender_id INTEGER NOT NULL,
  receiver_id INTEGER NOT NULL,
  application_id INTEGER NOT NULL,
  text TEXT NOT NULL,
  timestamp TIMESTAMP NOT NULL,
  FOREIGN KEY (sender_id) REFERENCES users("id") ON DELETE CASCADE,
  FOREIGN KEY (receiver_id) REFERENCES users("id") ON DELETE CASCADE

);

CREATE TABLE notifications (
  id SERIAL PRIMARY KEY,
  receiver_id INTEGER NOT NULL,
  text TEXT NOT NULL,
  read BOOLEAN NOT NULL,
  FOREIGN KEY (receiver_id) REFERENCES users("id") ON DELETE CASCADE
);
