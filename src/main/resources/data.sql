INSERT INTO users (id, email, username, password, type, balance, reported,blocked, able_to_ad,enabled)
VALUES (1, 'semmiertelme13@gmail.com', 'Beagun','Jancsika13', 'person', 0, 0, false, true, true),
       (2, 'user@user.com','user','User1', 'person', 1, 1, false, false, true);

INSERT INTO ads (id, advertiser_id, chosen_applicant_id, title, description, payment, category, is_premium)
VALUES (1, 1, 2, 'Looking for babysitter', 'Want a cute person to look after my children.', 500, 'Babysitting', false),
(2, 2, 1, 'HTML programmer', 'I am a hackerman, I code HTML, I know you need me!', 10000, 'IT', true);

INSERT INTO authorities (user_id, authority) values (1, 'ADMIN'),
                                                    (2,'USER');
