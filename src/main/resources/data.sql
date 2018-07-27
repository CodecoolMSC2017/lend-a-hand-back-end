INSERT INTO users (email, username, password, type, balance, reported,blocked, able_to_ad,enabled, picture_link,verificated)
VALUES ('semmiertelme13@gmail.com', 'Beagun','$2a$10$hwxmjAI/s3DM5TB78QiVnOzin1Cpi8QVHUlrmtu/nyyONaIJMf37q', 'person', 0, 0, false, true, true, 'https://hir.ma/wp-content/uploads/2016/01/all-1024x853.jpg',true),
       ('user@user.com','user','User1', 'person', 1, 1, false, false, true, 'https://mork.nyugat.hu/Scopes/nyugat2015/var//improxy/NyugatWXGAPicture/22/29/222914_mosomedve.jpg',true);

INSERT INTO users (email, phone, username, full_name, password, type, balance, reported,blocked, able_to_ad,enabled, picture_link, postal_code, city, address, verificated )
VALUES ('lorinc.hunyadi@gmail.com','+36706743245','Lorincke23','Hunyadi Lorinc','$2a$10$hwxmjAI/s3DM5TB78QiVnOzin1Cpi8QVHUlrmtu/nyyONaIJMf37q','person',3,0,false,true,true,'https://image.shutterstock.com/image-photo/portrait-handsome-gardener-black-apron-260nw-465594779.jpg','2074','Perbal','Kossuth utca 66',true);


INSERT INTO ads (advertiser_id, chosen_applicant_id, title, description, payment, category, is_premium, timestamp, type, picture_link)
VALUES (1, 2, 'Looking for babysitter', 'Want a cute person to look after my children.', 500, 'Child care', false, '2018-8-04 10:23:54', 'Hire', 'http://www.thinkhealthmag.com/wp-content/uploads/2013/05/happy-family.jpg'),
(2, 1, 'HTML programmer', 'I am a hackerman, I code HTML, I know you need me!', 10000, 'IT', true, '2018-8-04 12:23:54', 'Offer', 'https://cdn01.vulcanpost.com/wp-uploads/2015/12/computer-programmer.jpg'),
(2, 1, 'Gardening mowing outdoor solutions', 'Hi, We are a team of 2 professional Gardeners! Contact us today to get a free quotation!', 20, 'Garden', true, '2018-8-05 14:23:54', 'Offer', 'https://www.douglasforestandgarden.ie/wp-content/uploads/2016/05/on-your-bike.jpg'),
(2, 1, 'Builder and Plasterer', 'Experienced Builder and Plasterer Specializing in Restoration. Providing quality work and excellent customer service.', 11, 'Construction', true, '2018-8-06 17:23:54', 'Offer', 'https://www.tsjdevelopmentltd.co.uk/uploads/builder.jpg'),
(2, 1, 'French Private Lessons & PR Services', 'Newly established by a dynamic professional, Aegean Consultancy provides French and English tuition.', 22, 'Education', true, '2018-8-06 09:23:54', 'Offer', 'https://gazettereview.com/wp-content/uploads/2017/03/teacher1.jpg'),
(2, 1, 'Young babysitter', 'Hi! I am Jemma, 22 years old. I love children so much. I am responsible.', 33, 'Child care', true, '2018-8-07 10:23:54', 'Offer', 'https://www.google.hu/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwihiOqpnb_cAhWO6aQKHURDBOYQjRx6BAgBEAU&url=https%3A%2F%2Fwww.freepik.com%2Ffree-photo%2Fyoung-woman-messaging-on-the-street_1282716.htm&psig=AOvVaw1--aQgCwiVbeavmH-VuDgZ&ust=1532779113573172'),
(2, 1, 'Looking for C# developers', 'Our company needs a C# developer. Maybe you are the one?', 44, 'IT', true, '2018-8-07 11:23:54', 'Hire', 'https://www.google.hu/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjJx5-9nb_cAhWBC-wKHSREBJgQjRx6BAgBEAU&url=https%3A%2F%2Ftwitter.com%2Fbluenetarmenia%2Fstatus%2F933971655663210496&psig=AOvVaw32oK7nn5NH8rxSlyuGKrQk&ust=1532779160312937'),
(2, 1, 'K&S Express Mowing Service', 'K&S Express Mowing Service offers a great friendly service along with a Affordable Price.', 55, 'Garden', true, '2018-8-08 10:23:54', 'Offer', 'https://blog.fantasticgardeners.co.uk/wp-content/uploads/2016/08/garden-maintenance-by-Fantastic-gardeners.jpg'),
(2, 1, 'Plastering & Rendering', 'We Provide all services to do with plastering and rendering across the Staffordshire area.', 55, 'Construction', true, '2018-8-08 12:23:54', 'Offer', 'http://www.plasterers1stopshop.co.uk/blog/wp-content/uploads/2016/02/smiling-plasterers.jpg'),
(2, 1, 'Coding lessons', 'Coding lessons available in Java, C#, C++ languages', 55, 'Education', true, '2018-8-09 10:23:54', 'Offer', 'https://udemy-images.udemy.com/course/750x422/1020950_1304.jpg'),
(3, 2, 'Searching for gardener', 'Hi, We need a team of 2 professional Gardeners! We want them to be really responsible and gentle with our amazing and beautiful plants. They are our life. So let us know, if you find yourselves appropriate. Cheers!', 44, 'Garden', false, '2018-8-10 19:23:54', 'Hire', 'https://cached.imagescaler.hbpl.co.uk/resize/scaleWidth/620/cached.offlinehbpl.hbpl.co.uk/news/WOH/04_GardenersLantra-20141015031513986.jpg'),
(3, null, 'Indian runner ducks wanted', 'We need indian runner ducks to collect all of the slugs in our backyard! We need them a couple of weeks until they do the work!', 21, 'Garden', false, '2018-8-12 19:43:24', 'Hire', 'https://ih0.redbubble.net/image.60237096.6525/mp,550x550,matte,ffffff,t.3.jpg'),
(1, 1, 'Hobbit house for you!', 'Would you like to live your life in a hobbit house? We can make it for you! If you have only little money, you can order a little house! It is guaranted without vertical lines and right angles!', 555, 'Construction', true, '2015-8-18 16:29:24', 'Offer', 'https://i1.wp.com/www.literallydarling.com/wp-content/uploads/2016/06/one-company-is-bringing-your-hobbit-dreams-to-life-the-original-shire-in-matamata-new-z-534986.jpg?resize=800%2C600'),
(1, null, 'Fairy cleaning!', 'I can clean your house wearing high-heels made of glass! It will be fairy!', 65, 'Housework', false, '2017-9-21 12:27:43', 'Offer', 'http://the-cleaning-fairy.co.uk/____impro/1/onewebmedia/cleaningfairy.jpg?etag=%2264ce-53581111%22&sourceContentType=image%2Fjpeg&ignoreAspectRatio&resize=629%2B472&quality=85'),
(3, null, 'Here comes the king of the vacuumcleaners!', 'I am the fastest cleaner with a vacuumcleaner! I can clean your house within an hour! If I am not ready in 60 minutes, you pay nothing and my work is free for you!', 25, 'Housework', true, '2017-2-25 06:09:24', 'Offer', 'http://steamguider.com/wp-content/uploads/2016/06/best-steam-vacuum-cleaner-reviews.jpg'),
(2, 1, 'How to write a poem', 'You should be John the Golden, it is cool by the girls! Do you know about versification and rhymes? You can learn it like a real poet!', 1, 'Education', false, '2011-4-01 00:00:01', 'Offer', 'https://i.ytimg.com/vi/0aWK3JbL4Hs/maxresdefault.jpg');


INSERT INTO authorities (username, authority) values ('Beagun', 'ADMIN'),
                                                    ('Lorincke23','USER'),
                                                    ('user','USER');
INSERT INTO employee_ratings (rater_i, rdated_id, rating)
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

