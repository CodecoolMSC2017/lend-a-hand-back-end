INSERT INTO users (email, username, password, type, balance, reported,blocked, able_to_ad,enabled)
VALUES ('semmiertelme13@gmail.com', 'Beagun','$2a$10$hwxmjAI/s3DM5TB78QiVnOzin1Cpi8QVHUlrmtu/nyyONaIJMf37q', 'person', 0, 0, false, true, true),
       ('user@user.com','user','User1', 'person', 1, 1, false, false, true);

INSERT INTO ads (advertiser_id, chosen_applicant_id, title, description, payment, category, is_premium)
VALUES (1, 2, 'Looking for babysitter', 'Want a cute person to look after my children.', 500, 'Babysitting', false),
(2, 1, 'HTML programmer', 'I am a hackerman, I code HTML, I know you need me!', 10000, 'IT', true);

INSERT INTO authorities (username, authority) values ('Beagun', 'ADMIN'),
                                                    ('user','USER');
