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
    password VARCHAR(100) NOT NULL,
    full_name TEXT,
    type VARCHAR(16),
    postal_code VARCHAR(16),
    city TEXT,
    address TEXT,
    balance INTEGER ,
    reported INTEGER ,
    blocked BOOLEAN ,
    able_to_ad BOOLEAN ,
    enabled boolean
);

CREATE TABLE authorities (
    user_id INTEGER NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users("id")  ON DELETE CASCADE,
    UNIQUE (user_id, authority)
);

CREATE TABLE employee_ratings (
  id SERIAL PRIMARY KEY,
  rater_id INTEGER NOT NULL,
  rated_id INTEGER NOT NULL,
  rating INTEGER NOT NULL,
  FOREIGN KEY (rater_id) REFERENCES users("id") ON DELETE CASCADE,
  FOREIGN KEY (rated_id) REFERENCES users("id") ON DELETE CASCADE
);

CREATE TABLE employer_ratings (
  id SERIAL PRIMARY KEY,
  rater_id INTEGER NOT NULL,
  rated_id INTEGER NOT NULL,
  rating INTEGER NOT NULL,
  FOREIGN KEY (rater_id) REFERENCES users("id") ON DELETE CASCADE,
  FOREIGN KEY (rated_id) REFERENCES users("id") ON DELETE CASCADE
);

CREATE TABLE ads (
  id SERIAL PRIMARY KEY,
  advertiser_id INTEGER NOT NULL,
  chosen_applicant_id INTEGER,
  title VARCHAR(64) NOT NULL,
  description TEXT NOT NULL,
  payment INTEGER,
  category VARCHAR(32) NOT NULL,
  is_premium BOOLEAN NOT NULL,
  FOREIGN KEY (advertiser_id) REFERENCES users("id") ON DELETE CASCADE,
  FOREIGN KEY (chosen_applicant_id) REFERENCES users("id") ON DELETE CASCADE
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
  text TEXT NOT NULL,
  timestamp TIMESTAMP NOT NULL,
  FOREIGN KEY (sender_id) REFERENCES users("id") ON DELETE CASCADE,
  FOREIGN KEY (receiver_id) REFERENCES users("id") ON DELETE CASCADE
);
