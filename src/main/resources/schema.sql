DROP TABLE IF EXISTS messages;
DROP TABLE IF EXISTS applications;
DROP TABLE IF EXISTS ads;
DROP TABLE IF EXISTS employer_ratings;
DROP TABLE IF EXISTS employee_ratings;
DROP TABLE IF EXISTS users CASCADE;

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
  FOREIGN KEY (ad_id) REFERENCES ads("id") ON DELETE CASCADE,
  FOREIGN KEY (applicant_id) REFERENCES users("id") ON DELETE CASCADE
);

CREATE TABLE messages (
  sender_id INTEGER NOT NULL,
  reciever_id INTEGER NOT NULL,
  text TEXT NOT NULL,
  timestamp TEXT NOT NULL,
  FOREIGN KEY (sender_id) REFERENCES users("id") ON DELETE CASCADE,
  FOREIGN KEY (reciever_id) REFERENCES users("id") ON DELETE CASCADE
);
