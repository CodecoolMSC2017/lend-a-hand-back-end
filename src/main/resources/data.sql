INSERT INTO users (email, username, password, type, balance, reported,blocked, able_to_ad,enabled, picture_link)
VALUES ('semmiertelme13@gmail.com', 'Beagun','$2a$10$hwxmjAI/s3DM5TB78QiVnOzin1Cpi8QVHUlrmtu/nyyONaIJMf37q', 'person', 0, 0, false, true, true, 'https://hir.ma/wp-content/uploads/2016/01/all-1024x853.jpg'),
       ('user@user.com','user','User1', 'person', 1, 1, false, false, true, 'https://mork.nyugat.hu/Scopes/nyugat2015/var//improxy/NyugatWXGAPicture/22/29/222914_mosomedve.jpg');

INSERT INTO users (email, phone, username, full_name, password, type, balance, reported,blocked, able_to_ad,enabled, picture_link, postal_code, city, address )
VALUES ('lorinc.hunyadi@gmail.com','+36706743245','Lorincke23','Hunyadi Lorinc','$2a$10$hwxmjAI/s3DM5TB78QiVnOzin1Cpi8QVHUlrmtu/nyyONaIJMf37q','person',3,0,false,true,true,'https://image.shutterstock.com/image-photo/portrait-handsome-gardener-black-apron-260nw-465594779.jpg','2074','Perbal','Kossuth utca 66');


INSERT INTO ads (advertiser_id, chosen_applicant_id, title, description, payment, category, is_premium, timestamp, type)
VALUES (1, 2, 'Looking for babysitter', 'Want a cute person to look after my children.', 500, 'Babysitting', false, '2018-8-04 10:23:54', 'Hire'),
(2, 1, 'HTML programmer', 'I am a hackerman, I code HTML, I know you need me!', 10000, 'IT', true, '2018-8-04 12:23:54', 'Offer'),
(2, 1, 'Gardening mowing outdoor solutions', 'Hi, We are a team of 2 professional Gardeners! Contact us today to get a free quotation!', 20, 'Garden', true, '2018-8-05 14:23:54', 'Offer'),
(2, 1, 'Builder and Plasterer', 'Experienced Builder and Plasterer Specializing in Restoration. Providing quality work and excellent customer service.', 11, 'Building', true, '2018-8-06 17:23:54', 'Offer'),
(2, 1, 'French Private Lessons & PR Services', 'Newly established by a dynamic professional, Aegean Consultancy provides French and English tuition.', 22, 'Learning', true, '2018-8-06 09:23:54', 'Offer'),
(2, 1, 'Young babysitter', 'Hi! I am Jemma, 22 years old. I love children so much. I am responsible.', 33, 'Babysitting', true, '2018-8-07 10:23:54', 'Offer'),
(2, 1, 'Looking for C# developers', 'Our company needs a C# developer. Maybe you are the one?', 44, 'IT', true, '2018-8-07 11:23:54', 'Hire'),
(2, 1, 'K&S Express Mowing Service', 'K&S Express Mowing Service offers a great friendly service along with a Affordable Price.', 55, 'Garden', true, '2018-8-08 10:23:54', 'Offer'),
(2, 1, 'Plastering & Rendering', 'We Provide all services to do with plastering and rendering across the Staffordshire area.', 55, 'Building', true, '2018-8-08 12:23:54', 'Offer'),
(2, 1, 'Coding lessons', 'Coding lessons available in Java, C#, C++ languages', 55, 'Learning', true, '2018-8-09 10:23:54', 'Offer'),
(3, 2, 'Searching for gardener', 'Hi, We need a team of 2 professional Gardeners! We want them to be really responsible and gentle with our amazing and beautiful plants. They are our life. So let us know, if you find yourselves appropriate. Cheers!', 44, 'Garden', false, '2018-8-10 19:23:54', 'Hire');

INSERT INTO authorities (username, authority) values ('Beagun', 'ADMIN'),
                                                    ('Lorincke23','USER'),
                                                    ('user','USER');
INSERT INTO employee_ratings (rater_id, rated_id, rating)
VALUES (1,2,5),
(1,3,2),
(2,1,4),
(2,3,1),
(3,2,1),
(3,1,5);


INSERT INTO employer_ratings (rater_id, rated_id, rating)
VALUES (1,2,2),
(1,3,1),
(2,1,5),
(2,3,3),
(3,2,4),
(3,1,2);

