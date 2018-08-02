INSERT INTO users (email, username, password, type, balance, reported,blocked, able_to_ad,enabled, picture_link,verificated)
VALUES ('semmiertelme13@gmail.com', 'Beagun','$2a$10$hwxmjAI/s3DM5TB78QiVnOzin1Cpi8QVHUlrmtu/nyyONaIJMf37q', 'person', 0, 0, false, true, true, 'https://hir.ma/wp-content/uploads/2016/01/all-1024x853.jpg',true),
       ('user@user.com','user','User1', 'person', 1, 1, false, false, true, 'https://mork.nyugat.hu/Scopes/nyugat2015/var//improxy/NyugatWXGAPicture/22/29/222914_mosomedve.jpg',true);

INSERT INTO users (email, phone, username, full_name, password, type, balance, reported,blocked, able_to_ad,enabled, picture_link, postal_code, city, address, verificated )
VALUES ('lorinc.hunyadi@gmail.com','+36706743245','Lorincke23','Lorinc Hunyadi','$2a$10$hwxmjAI/s3DM5TB78QiVnOzin1Cpi8QVHUlrmtu/nyyONaIJMf37q','person',3,0,false,true,true,'https://image.shutterstock.com/image-photo/portrait-handsome-gardener-black-apron-260nw-465594779.jpg','2074','Perbal','Kossuth utca 66',true),
('msalexapekar@gmail.com', '+36306623455', 'AlexaPekar', 'Alexa Pekar', '$2a$10$hwxmjAI/s3DM5TB78QiVnOzin1Cpi8QVHUlrmtu/nyyONaIJMf37q', 'person', 12, 0, false, true, true, '', '3535', 'Miskolc', 'Bajcsy u. 4.', true),
('krisztiankollar@gmail.com', '+36205623895', 'KrisztianKollar', 'Krisztian Kollar', '$2a$10$hwxmjAI/s3DM5TB78QiVnOzin1Cpi8QVHUlrmtu/nyyONaIJMf37q', 'person', 18, 0, false, true, true, '', '3533', 'Miskolc', 'Kazinczy u. 16.', true);



INSERT INTO ads (advertiser_id, chosen_applicant_id, title, description, payment, category, is_premium, timestamp, type, picture_link)
VALUES (1, 2, 'Looking for babysitter', 'Want a cute person to look after my children.', 500, 'Child care', false, '2018-8-04 10:23:54', 'Hire', 'http://www.thinkhealthmag.com/wp-content/uploads/2013/05/happy-family.jpg'),
(2, null, 'HTML programmer', 'I am a hackerman, I code HTML, I know you need me!', 10000, 'IT', true, '2018-8-04 12:23:54', 'Offer', 'https://cdn01.vulcanpost.com/wp-uploads/2015/12/computer-programmer.jpg'),
(2, null, 'Gardening mowing outdoor solutions', 'Hi, We are a team of 2 professional Gardeners! Contact us today to get a free quotation!', 20, 'Garden', true, '2018-8-05 14:23:54', 'Offer', 'https://www.douglasforestandgarden.ie/wp-content/uploads/2016/05/on-your-bike.jpg'),
(2, null, 'Builder and Plasterer', 'Experienced Builder and Plasterer Specializing in Restoration. Providing quality work and excellent customer service.', 11, 'Construction', true, '2018-8-06 17:23:54', 'Offer', 'https://www.tsjdevelopmentltd.co.uk/uploads/builder.jpg'),
(2, null, 'French Private Lessons & PR Services', 'Newly established by a dynamic professional, Aegean Consultancy provides French and English tuition.', 22, 'Education', true, '2018-8-06 09:23:54', 'Offer', 'https://gazettereview.com/wp-content/uploads/2017/03/teacher1.jpg'),
(2, null, 'Young babysitter', 'Hi! I am Jemma, 22 years old. I love children so much. I am responsible.', 33, 'Child care', true, '2018-8-07 10:23:54', 'Offer', 'https://image.freepik.com/free-photo/young-woman-messaging-on-the-street_1163-3675.jpg'),
(2, null, 'Looking for C# developers', 'Our company needs a C# developer. Maybe you are the one?', 44, 'IT', true, '2018-8-07 11:23:54', 'Hire', 'https://pbs.twimg.com/media/DPYiQPkXcAA8sto.png:large'),
(2, null, 'K&S Express Mowing Service', 'K&S Express Mowing Service offers a great friendly service along with a Affordable Price.', 55, 'Garden', true, '2018-8-08 10:23:54', 'Offer', 'https://blog.fantasticgardeners.co.uk/wp-content/uploads/2016/08/garden-maintenance-by-Fantastic-gardeners.jpg'),
(2, null, 'Plastering & Rendering', 'We Provide all services to do with plastering and rendering across the Staffordshire area.', 55, 'Construction', true, '2018-8-08 12:23:54', 'Offer', 'http://www.plasterers1stopshop.co.uk/blog/wp-content/uploads/2016/02/smiling-plasterers.jpg'),
(2, null, 'Coding lessons', 'Coding lessons available in Java, C#, C++ languages', 55, 'Education', true, '2018-8-09 10:23:54', 'Offer', 'https://udemy-images.udemy.com/course/750x422/1020950_1304.jpg'),
(3, null, 'Searching for gardener', 'Hi, We need a team of 2 professional Gardeners! We want them to be really responsible and gentle with our amazing and beautiful plants. They are our life. So let us know, if you find yourselves appropriate. Cheers!', 44, 'Garden', false, '2018-8-10 19:23:54', 'Hire', 'https://cached.imagescaler.hbpl.co.uk/resize/scaleWidth/620/cached.offlinehbpl.hbpl.co.uk/news/WOH/04_GardenersLantra-20141015031513986.jpg'),
(3, null, 'Indian runner ducks wanted', 'We need indian runner ducks to collect all of the slugs in our backyard! We need them a couple of weeks until they do the work!', 21, 'Garden', false, '2018-8-12 19:43:24', 'Hire', 'https://ih0.redbubble.net/image.60237096.6525/mp,550x550,matte,ffffff,t.3.jpg'),
(1, null, 'Hobbit house for you!', 'Would you like to live your life in a hobbit house? We can make it for you! If you have only little money, you can order a little house! It is guaranted without vertical lines and right angles!', 555, 'Construction', true, '2015-8-18 16:29:24', 'Offer', 'https://i1.wp.com/www.literallydarling.com/wp-content/uploads/2016/06/one-company-is-bringing-your-hobbit-dreams-to-life-the-original-shire-in-matamata-new-z-534986.jpg?resize=800%2C600'),
(1, null, 'Fairy cleaning!', 'I can clean your house wearing high-heels made of glass! It will be fairy!', 65, 'Housework', false, '2017-9-21 12:27:43', 'Offer', 'http://the-cleaning-fairy.co.uk/____impro/1/onewebmedia/cleaningfairy.jpg?etag=%2264ce-53581111%22&sourceContentType=image%2Fjpeg&ignoreAspectRatio&resize=629%2B472&quality=85'),
(3, null, 'Here comes the king of the vacuumcleaners!', 'I am the fastest cleaner with a vacuumcleaner! I can clean your house within an hour! If I am not ready in 60 minutes, you pay nothing and my work is free for you!', 25, 'Housework', true, '2017-2-25 06:09:24', 'Offer', 'http://steamguider.com/wp-content/uploads/2016/06/best-steam-vacuum-cleaner-reviews.jpg'),
(3, null, 'Herbs for your health!', 'Our family business grows fine quality herbs at our farm. We can offer a lot of kinds for almost every health problem. Controlled quality without any chemical stuff to serve your health.', 5, 'Health care', true, '2018-2-01 09:49:24', 'Offer', 'http://bulgariancooking.com/wp-content/uploads/2017/03/o-COOKING-WITH-HERBS-facebook.jpg'),
(1, null, 'We need a Physiotherapy', 'We would like to hire a therapist for physiotherapy at our home twice a week.', 15, 'Health care', false, '2017-2-25 06:09:24', 'Hire', 'http://www.purephysiotherapy.co.uk/wp-content/uploads/2016/08/Fotolia_93677495_L.jpg'),
(1, null, 'I can type your texts', 'If you need someone to type a lot of texts let me know it! Short deadlines can not be a problem anymore!', 12, 'Office', false, '2018-3-25 02:32:24', 'Offer', 'http://1635225677.rsc.cdn77.org/images/typing-tutors.jpg'),
(1, null, 'Freelancer Secretary', 'You can hire me as a deputy of your Secretary to replace her for short-time periods. I can solve common office tasks and problems which can occur at your company.', 20, 'Office', true, '2018-2-10 09:59:24', 'Offer', 'https://3kyfma1tr3gd273qz5237tyv-wpengine.netdna-ssl.com/wp-content/uploads/2017/11/LEGAL-SECRETARY-DIPLOMA.jpg'),
(1, null, 'Pet trainer', 'Trainer for dogs at the weekend! I offer a basic training for every kind of dogs: basic command words, leading on a leash etc.', 17, 'Pets', false, '2018-7-1 12:24:24', 'Offer', 'https://www.cesarsway.com/sites/newcesarsway/files/styles/large_article_preview/public/5-essential-commands-you-can-teach-your-dog_1.jpg?itok=nYOp-YSR'),
(1, null, 'Dog walking', 'I’m looking for someone to take my dog to a walk.', 8, 'Pets', false, '2018-5-25 20:42:24', 'Hire', 'https://www.telegraph.co.uk/content/dam/pets/2016/10/24/66114401heath-PETS_trans_NvBQzQNjv4Bq90JsMauqkzRhOnTEP_rlOpxkSp59y3f5RW3cbWCveiY.jpg?imwidth=1400'),
(1, null, 'Looking people to hiking', 'Hi I’m mad about the hills and forests but I’m new in the town so looking for young people who can join me to  go outside. Woods are waiting for us! Let’s go!', 0, 'Sports', false, '2018-6-30 08:19:44', 'Offer', 'https://www.tgomagazine.co.uk/wp-content/uploads/sites/2/2017/02/Going-solo-820x547.jpg'),
(1, null, 'Personal trainer to get the best shape of your body', 'Personal trainer can lead your training. I offer a personalized program for everyone according ones physical condition. You can choose a lot of activities and we can discuss what is the best for you.', 25, 'Sports', false, '2015-12-05 16:39:24', 'Offer',''),
(3, null, 'Veteran car for ceremonies', 'Make your wedding and family celebrations memorable with the most beautiful oldtimer cars. You can choose from several types.', 225, 'Vehicle', true, '2018-4-12 16:07:12', 'Offer', 'http://www.theashdownclassicweddingcarcollection.co.uk/images/1929-rolls-royce-barker-limousine.jpg'),
(2, null, 'Hire me to do works with a tractor', 'If you haven’t got real machines to cultivate your ground you can hire me to do that: ploughing, harrowing etc.', 35, 'Vehicle', false, '2018-6-25 00:09:24', 'Offer', 'https://calificare-profesionala.com/wp-content/uploads/2016/11/poza_tractorist.jpg'),
(2, null, 'Repairing small issues', 'Dripping water tap? Hanging door handle? Broken windows? I can fix small problems at your house and garden, backyard.', 15, 'Repair', false, '2017-2-05 16:09:24', 'Offer', 'https://irp-cdn.multiscreensite.com/022024fa/dms3rep/multi/desktop/tap_sml-1654x1102.jpg'),
(3, null, 'Bicycle Repair Man', 'Whenever bicycles are broken, or menaced by international communism, Bicycle Repair Man is ready.', 5, 'Repair', false, '2015-12-25 06:09:24', 'Offer', 'https://vignette.wikia.nocookie.net/superheroes/images/1/18/Bicycle_Repairman.jpg/revision/latest?cb=20140525190303'),
(2, null, 'How to write a poem', 'You should be John the Golden, it is cool by the girls! Do you know about versification and rhymes? You can learn it like a real poet!', 1, 'Education', false, '2011-4-01 00:00:01', 'Offer', 'https://i.ytimg.com/vi/0aWK3JbL4Hs/maxresdefault.jpg');


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

