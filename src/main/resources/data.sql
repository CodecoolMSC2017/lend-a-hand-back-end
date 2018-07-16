INSERT INTO users (id, email, user_name, password, type, balance, reported,blocked, able_to_ad)
VALUES (1, 'semmiertelme13@gmail.com', 'Beagun','Jancsika13', 'person', 0, 0, false, true),
       (2, 'user@user.com','user','User1', 'person', 1, 1, false, false);

INSERT INTO ads (id, advertiser_id, chosen_applicant_id, title, description, payment, category, is_premium)
VALUES (1, 1, 2, 'Looking for babysitter', 'Want a cute person to look after my children.', 500, 'Babysitting', false),
(2, 2, 1, 'HTML programmer', 'I am a hackerman, I code HTML, I know you need me!', 10000, 'IT', true);
