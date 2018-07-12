DROP TABLE IF EXISTS message;
DROP TABLE IF EXISTS application;
DROP TABLE IF EXISTS ad;
DROP TABLE IF EXISTS employer_rating;
DROP TABLE IF EXISTS employee_rating;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    email VARCHAR(32) NOT NULL,
    phone VARCHAR(32),
    user_name VARCHAR(32) NOT NULL,
    password TEXT,
    full_name TEXT,
    type VARCHAR(16) NOT NULL,
    postal_code VARCHAR(16),
    city TEXT,
    address TEXT,
    balance INTEGER NOT NULL,
    reported INTEGER NOT NULL,
    blocked BOOLEAN NOT NULL,
    able_to_ad BOOLEAN NOT NULL
);

CREATE TABLE employee_rating (
  id SERIAL PRIMARY KEY,
  user_id INTEGER NOT NULL,
  rating INTEGER NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users("id") ON DELETE CASCADE
);

CREATE TABLE employer_rating (
  id SERIAL PRIMARY KEY,
  user_id INTEGER NOT NULL,
  rating INTEGER NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users("id") ON DELETE CASCADE
);

CREATE TABLE ad (
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

CREATE TABLE application (
  id SERIAL PRIMARY KEY,
  ad_id INTEGER NOT NULL,
  applicant_id INTEGER NOT NULL,
  message TEXT,
  FOREIGN KEY (ad_id) REFERENCES ad("id") ON DELETE CASCADE,
  FOREIGN KEY (applicant_id) REFERENCES users("id") ON DELETE CASCADE
);

CREATE TABLE message (
  sender_id INTEGER NOT NULL,
  reciever_id INTEGER NOT NULL,
  text TEXT NOT NULL,
  timestamp TEXT NOT NULL,
  FOREIGN KEY (sender_id) REFERENCES users("id") ON DELETE CASCADE,
  FOREIGN KEY (reciever_id) REFERENCES users("id") ON DELETE CASCADE
);
