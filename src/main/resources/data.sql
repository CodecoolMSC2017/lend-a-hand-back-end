INSERT INTO users (email, username, password, type, balance, reported,blocked, able_to_ad,enabled)
VALUES ('semmiertelme13@gmail.com', 'Beagun','$2a$10$hwxmjAI/s3DM5TB78QiVnOzin1Cpi8QVHUlrmtu/nyyONaIJMf37q', 'person', 0, 0, false, true, true),
       ('user@user.com','user','User1', 'person', 1, 1, false, false, true);

INSERT INTO ads (advertiser_id, chosen_applicant_id, title, description, payment, category, is_premium)
VALUES (1, 2, 'Looking for babysitter', 'Want a cute person to look after my children.', 500, 'Babysitting', false),
(2, 1, 'HTML programmer', 'I am a hackerman, I code HTML, I know you need me!', 10000, 'IT', true),
(2, 1, 'Gardening mowing outdoor solutions', 'Hi, We are a team of 2 professional Gardeners! Contact us today to get a free quotation!', 20, 'Garden', true),
(2, 1, 'Builder and Plasterer', 'Experienced Builder and Plasterer Specializing in Restoration. Providing quality work and excellent customer service.', 11, 'Building', true),
(2, 1, 'French Private Lessons & PR Services', 'Newly established by a dynamic professional, Aegean Consultancy provides French and English tuition.', 22, 'Learning', true),
(2, 1, 'Young babysitter', 'Hi! I am Jemma, 22 years old. I love children so much. I am responsible.', 33, 'Babysitting', true),
(2, 1, 'Looking for C# developers', 'Our company needs a C# developer. Maybe you are the one?', 44, 'IT', true),
(2, 1, 'K&S Express Mowing Service', 'K&S Express Mowing Service offers a great friendly service along with a Affordable Price.', 55, 'Garden', true),
(2, 1, 'Plastering & Rendering', 'We Provide all services to do with plastering and rendering across the Staffordshire area.', 55, 'Building', true),
(2, 1, 'Coding lessons', 'Coding lessons available in Java, C#, C++ languages', 55, 'Learning', true);

INSERT INTO authorities (username, authority) values ('Beagun', 'ADMIN'),
                                                    ('user','USER');
