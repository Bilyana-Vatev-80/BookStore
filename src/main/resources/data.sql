INSERT INTO roles (id, role)
VALUES (1, 'ADMIN');
INSERT INTO roles (id, role)
VALUES (2, 'USER');

INSERT INTO users (id, first_name, last_name, username, email, address, password)
VALUES (1, 'Admin', 'Adminov', 'admin',
        'admin.adminov@abv.bg', 'Sofia, Alexander Malinov Str.',
        '713ced98f52887220162f4a73fc4109ac9a76bb919a888ffb41fed4f922148b158f84bdef58778a3');
INSERT INTO users (id, first_name, last_name, username, email, address, password)
VALUES (2, 'User', 'Userov', 'user',
        'user.userov@abv.bg', 'Sofia, Alexander Malinov Str.',
        '713ced98f52887220162f4a73fc4109ac9a76bb919a888ffb41fed4f922148b158f84bdef58778a3');

INSERT INTO users_roles (`user_entity_id`, `roles_id`)
VALUES (1, 1);
INSERT INTO users_roles (`user_entity_id`, `roles_id`)
VALUES (1, 2);
INSERT INTO users_roles (`user_entity_id`, `roles_id`)
VALUES (2, 2);

INSERT INTO categories (id, category)
VALUES (1, 'FICTION');
INSERT INTO categories (id, category)
VALUES (2, 'CRIME_AND_THRILLER');
INSERT INTO categories (id, category)
VALUES (3, 'ROMANCE');
INSERT INTO categories (id, category)
VALUES (4, 'FANTASY');
INSERT INTO categories (id, category)
VALUES (5, 'SCIENCE_FICTION');
INSERT INTO categories (id, category)
VALUES (6, 'SCIENCE');
INSERT INTO categories (id, category)
VALUES (7, 'CLASSICS');
INSERT INTO categories (id, category)
VALUES (8, 'CHILDREN');
INSERT INTO categories (id, category)
VALUES (9, 'HISTORY');
INSERT INTO categories (id, category)
VALUES (10, 'ART');
INSERT INTO categories (id, category)
VALUES (11, 'DYSTOPIA');
INSERT INTO categories (id, category)
VALUES (12, 'HORROR');
INSERT INTO categories (id, category)
VALUES (13, 'POETRY');

INSERT INTO publishing_houses (id, name, description, image_url)
VALUES (1, 'Сиела',
        'Cъздaдeнo пpeз 1991 г., c нaд 250 зaглaвия гoдишнo в ĸaтaлoгa нa Cиeлa cи дaвaт cpeщa ĸaĸтo извecтни, тaĸa и пo-мaлĸo пoпyляpни aвтopи oт цeлия cвят. Bпeчaтлявaщo пopтфoлиo вĸлючвa бългapcĸa и пpeвoднa xyдoжecтвeнa литepaтypa, жaнpoвa литepaтypa, нexyдoжecтвeни тeĸcтoвe, иcтopия, пътyвaнe, мyзиĸa, ĸyлинapия, ĸpитиĸa и юpидичecĸи ĸниги. Πpeз пocлeднитe двe гoдини издaтeлcтвo Cиeлa paбoти ocoбeнo ycъpднo в yтвъpждaвaнeтo нa YА и дeтcĸaтa литepaтypa.',
        'https://res.cloudinary.com/nzlateva/image/upload/v1635023437/web-bookstore-app/publishing-house-pics/ciela_shid2m.jpg');
INSERT INTO publishing_houses (id, name, description, image_url)
VALUES (2, 'Изток-Запад',
        'Издaтeлcтвo „Изтoĸ-Зaпaд” e ocнoвaнo пpeз eceнтa нa 2002 г. Дo тoзи мoмeнт в ĸaтaлoгa мy имa нaд 1000 peaлизиpaни зaглaвия, гpyпиpaни тeмaтичнo в гoлeмитe пopeдици „Изтoĸ“, „Зaпaд“ и „Бългapия“. „Изтoĸ-Зaпaд“ paбoти нaй-вeчe в oблacтитe нa филocoфиятa, ĸyлтypoлoгиятa, aнтpoпoлoгиятa, иcтopиятa, иĸoнoмиĸaтa, пpaĸтичecĸaтa и тeopeтичecĸaтa пcиxoлoгия, изoбщo нa пoзнaниeтo зa чoвeĸa и oбщecтвoтo. Hapeд c тoвa нeмaлъĸ дял oт ĸнижнaтa мy пpoдyĸция ce пaдa нa бeлeтpиcтиĸaтa, пyблициcтиĸaтa, здpaвeтo и бизнec-yмeниятa. C лoгoтo нa издaтeлcтвoтo ce нaлoжиxa бeлeтpиcтични и дoĸyмeнтaлни пopeдици ĸaтo „Bъpxoвe“, „Маgіса“, „Teзaypyc“, „Зaбpaвeнитe бългapи“, „Cпaceнaтa иcтopия“, ĸaĸтo и лyĸcoзнитe джoбни бижyтa oт ĸoлeĸциятa „Гoлeмитe мaлĸи ĸниги“.',
        'https://res.cloudinary.com/nzlateva/image/upload/v1635023437/web-bookstore-app/publishing-house-pics/iztok-zapad_k3in0e.jpg');
INSERT INTO publishing_houses (id, name, description, image_url)
VALUES (3, 'БАРД',
        'He cлyчaйнo мотото нa БAPД e „Kнигитe, ĸoитo чeтe cвeтът“, зaщoтo зaглaвиятa, ĸoитo излизaт c мapĸaтa нa издaтeлcтвoтo, oглaвявaт нe caмo poднитe, нo и cвeтoвнитe читaтeлcĸи ĸлacaции. Бoгaтaтa жaнpoвa пaлитpa вĸлючвa: фaнтacтиĸa, фeнтъзи, тpилъpи, нayчнoпoпyляpнa литepaтypa, cвeтoвнa ĸлacиĸa, cъвpeмeнни poмaни, миcтиĸa и eзoтepиĸa, пoпyляpнa пcиxoлoгия, дeтcĸи ĸниги. C лoгoтo нa БAPД излизaт eдни oт нaй-пoзнaтитe и oбичaни издaтeлcĸи пopeдици „Kpaлeтe нa тpилъpa“, „Избpaнa cвeтoвнa фaнтacтиĸa“ и „Beлиĸи мaйcтopи нa фeнтъзитo и фaнтacтиĸaтa“.',
        'https://res.cloudinary.com/nzlateva/image/upload/v1635023437/web-bookstore-app/publishing-house-pics/bard_fjz0vf.jpg');
INSERT INTO publishing_houses (id, name, image_url)
VALUES (4, 'Захарий Стоянов',
        'https://res.cloudinary.com/nzlateva/image/upload/v1635023437/web-bookstore-app/publishing-house-pics/default-ph-picture_cy6xdw.png');
INSERT INTO publishing_houses (id, name, image_url)
VALUES (5, 'Абагар Холдинг',
        'https://res.cloudinary.com/nzlateva/image/upload/v1635023437/web-bookstore-app/publishing-house-pics/default-ph-picture_cy6xdw.png');
INSERT INTO publishing_houses (id, name, description, image_url)
VALUES (6, 'Колибри',
        'Koлибpи e в aвaнгapдa нa издaтeлcĸия бизнec в Бългapия. Cъздaдeнo пpeз 1990 г., нeпocpeдcтвeнo cлeд пoлитичecĸитe пpoмeни в cтpaнaтa, пpeз гoдинитe издaтeлcтвoтo ce yтвъpди cъc cвoя бeзĸoмпpoмиceн пpoфecиoнaлизъм и oтгoвopнo oтнoшeниe ĸъм ĸлиeнти и пapтньopи. Eдин cплoтeн eĸип cтoи в ocнoвaтa нa peзyлтaти, ĸoитo ce пocтигaт c ycъpдиe, пocлeдoвaтeлнocт и бeзycлoвнa любoв ĸъм литepaтypaтa.

Днec Koлибpи e бpaнд, пoпyляpeн ĸaĸтo в Бългapия, тaĸa и oтвъд нeйнитe пpeдeли. B ĸaтaлoгa cи Koлибpи имa нaд 1200 чeтивa. Bcяĸa гoдинa издaтeлcтвoтo пyблиĸyвa oĸoлo 120 нoви зaглaвия, ĸaĸтo и дeceтĸи дoпeчaтĸи нa пo-cтapи издaния. Taм фигypиpaт eдни oт нaй-бляcĸaвитe имeнa в cвeтoвнaтa бeлeтpиcтиĸa. Блaгoдapeниe нa Koлибpи бългapcĸият читaтeл ce зaпoзнa ĸaĸтo c yтвъpдeни, тaĸa и c нaбиpaщи пoпyляpнocт aвтopи oт paзлични cтpaни и ĸoнтинeнти, пpeдcтaвитeли нa paзлични жaнpoвe, eпoxи и идeйни тeчeния. ',
        'https://res.cloudinary.com/nzlateva/image/upload/v1635023437/web-bookstore-app/publishing-house-pics/colibri_ojrog4.jpg');
INSERT INTO publishing_houses (id, name, description, image_url)
VALUES (7, 'HarperCollins',
        '',
        'https://res.cloudinary.com/nzlateva/image/upload/v1635023437/web-bookstore-app/publishing-house-pics/default-ph-picture_cy6xdw.png');
INSERT INTO publishing_houses (id, name, description, image_url)
VALUES (8, 'Simon & Schuster',
        '',
        'https://res.cloudinary.com/nzlateva/image/upload/v1635023437/web-bookstore-app/publishing-house-pics/default-ph-picture_cy6xdw.png');
INSERT INTO publishing_houses (id, name, description, image_url)
VALUES (9, 'Penguin Random House',
        '',
        'https://res.cloudinary.com/nzlateva/image/upload/v1635023437/web-bookstore-app/publishing-house-pics/default-ph-picture_cy6xdw.png');


INSERT INTO pictures (id, url)
VALUES (1,
        'https://res.cloudinary.com/nzlateva/image/upload/v1635019989/web-bookstore-app/book-cover-pics/default-book-cover_as0qlg.jpg');
INSERT INTO pictures (id, url)
VALUES (2,
        'https://res.cloudinary.com/nzlateva/image/upload/v1635019990/web-bookstore-app/book-cover-pics/hronikite-na-ambar-1_gfj7c1.jpg');
INSERT INTO pictures (id, url)
VALUES (3,
        'https://res.cloudinary.com/nzlateva/image/upload/v1635019989/web-bookstore-app/book-cover-pics/sybrani-razkazi-5_em0jsa.jpg');
INSERT INTO pictures (id, url)
VALUES (4,
        'https://res.cloudinary.com/nzlateva/image/upload/v1635019990/web-bookstore-app/book-cover-pics/vlastelinyt_vsersh.jpg');
INSERT INTO pictures (id, url)
VALUES (5,
        'https://res.cloudinary.com/nzlateva/image/upload/v1635019990/web-bookstore-app/book-cover-pics/uwe_ycfjq2.jpg');
INSERT INTO pictures (id, url)
VALUES (6,
        'https://res.cloudinary.com/nzlateva/image/upload/v1635022316/web-bookstore-app/authors-pics/talkien_zo2eds.jpg');
INSERT INTO pictures (id, url)
VALUES (7,
        'https://res.cloudinary.com/nzlateva/image/upload/v1635173921/web-bookstore-app/authors-pics/default-author-pic_rc5wzc.png');
INSERT INTO pictures (id, url)
VALUES (8,
        'https://res.cloudinary.com/nzlateva/image/upload/v1635022070/web-bookstore-app/authors-pics/Dostoevsky_c7cqok.jpg');
INSERT INTO pictures (id, url)
VALUES (9,
        'https://res.cloudinary.com/nzlateva/image/upload/v1635022070/web-bookstore-app/authors-pics/Asimov_wz1nzu.jpg');
INSERT INTO pictures (id, url)
VALUES (10,
        'https://res.cloudinary.com/nzlateva/image/upload/v1638480650/web-bookstore-app/book-cover-pics/Brave-New-World_nmus8h.jpg');
INSERT INTO pictures (id, url)
VALUES (11,
        'https://res.cloudinary.com/nzlateva/image/upload/v1638479388/web-bookstore-app/authors-pics/Ray_Bradbury_tyae7t.jpg');
INSERT INTO pictures (id, url)
VALUES (12,
        'https://res.cloudinary.com/nzlateva/image/upload/v1638479709/web-bookstore-app/book-cover-pics/Fahrenheit_451_zo4ahc.jpg');
INSERT INTO pictures (id, url)
VALUES (13,
        'https://res.cloudinary.com/nzlateva/image/upload/v1638480036/web-bookstore-app/authors-pics/George_Orwell_tplbdw.jpg');
INSERT INTO pictures (id, url)
VALUES (14,
        'https://res.cloudinary.com/nzlateva/image/upload/v1638479922/web-bookstore-app/book-cover-pics/1984_ygwpq6.jpg');


INSERT INTO authors (id, first_name, last_name, description, picture_id)
VALUES (1, 'Джон Р. Р.', 'Толкин',
        'Джон Роналд Руел Толкин, CBE (на английски: John Ronald Reuel Tolkien) е британски писател, смятан за основател на жанра фентъзи с романа си „Хобитът“ (The Hobbit) и неговото продължение трилогията „Властелинът на пръстените“ (The Lord of the Rings).',
        6);
INSERT INTO authors (id, first_name, last_name, description, picture_id)
VALUES (2, 'Роджър', 'Зелазни',
        'Роджър Джоузеф Зелазни (на английски: Roger Joseph Zelazny) е американски автор на научна фантастика, фентъзи и стихове[1] роден на 13 май 1937 г. Юклид, Охайо, и починал 14 юни 1995 г. в Санта Фе, Ню Мексико.
Зелазни е една от най-значимите фигури в съвременния фентъзи жанр и научна фантастика.[2] В началото на 60-те години на XX век печели бърза слава на един от най-добрите представители на Новата вълна на фантастиката.[1] Носител е на наградите Небюла три пъти и Хюго шест пъти, включително за романите си Господарят на светлината (1968) и ...And Call Me Conrad (1966) (по-късно публикуван като This Immortal).
Писателят има изключителен талант в измислянето и изобразяването на светове с правдоподобни магически системи, сили и свръхестествени същества. Впечатляващите описания на детайли от приложната магия в измислените от него светове го отличават от останалите автори в областта. Научната фантастика на Зелазни е силно повлияна от митология и поезия, включително френската, британската и американската класика от късния 19 век и ранния 20 век. Честа тема са богове или хора, превърнали се в богове. Романите и късите разкази на Зелазни обичайно включват образи от класическата митология, вписани в модерния свят.',
        7);
INSERT INTO authors (id, first_name, last_name, description, picture_id)
VALUES (3, 'Фьодор', 'Достоевски',
        'Фьодор Миха̀йлович Достоевски е руски писател и публицист, най-известен със своите романи „Престъпление и наказание“, „Братя Карамазови“, „Идиот“ и „Бесове“.
Литературното творчество на Достоевски изследва човешката психика в тревожните политически, обществени и духовни условия на руското общество през XIX век. Като изявен славянофил, националист и монархист, в творбите си той критикува буржоазията, Запада в навечерието на епохата на материализма и нихилизма. Смятан от мнозина за основоположник или пряк предшественик на европейския екзистенциализъм, неговите „Записки от подземието“ са определяни като „най-доброто въведение в екзистенциализма, писано някога".[5] Достоевски започва да пише от средата на 40-те години на XIX век, като първите му произведения са повлияни от реалисти и романтици – Дикенс, Гогол, Балзак и др. Въпреки това най-известни са творбите от последните му години – „Престъпление и наказание“, „Идиот“ и „Братя Карамазови“. Достоевски често е определян и като един от най-значимите психолози в историята на световната литература.[6] Написва общо 11 романа, 3 новели, 17 разказа и 3 есета.',
        8);
INSERT INTO authors (id, first_name, last_name, description, picture_id)
VALUES (4, 'Айзък', 'Азимов',
        'Айзък Азимов (на английски: Isaac Asimov, рождено име – Исаак Юдович Азимов) е американски писател на фантастични и научно-популярни творби и биохимик от руско-еврейски произход.
Азимов написва или редактира над 500 тома, а общият брой на написаните от него писма и пощенски картички е оценен на около 90 000. Негови творби има в девет от десетте категории в Десетичната система на Дюи – всички без „Философия“.[1] Азимов е смятан за един от майсторите в жанра научна фантастика и заедно с Робърт Хайнлайн и Артър Кларк е считан за един от „големите трима“ писатели-фантасти на времето си.[2]
Вероятно най-известната творба на Азимов е поредицата за „Фондацията“; неговите други главни поредици са тези за Галактическата империя и за роботите, които по-късно също обвързва с Фондацията. Неговото творчество е удостоено с пет награди „Хюго“ (1963, 1966, 1973, 1977, 1983 г.), две награди „Небюла“ (1972, 1976 г.) и други.
Азимов е дългогодишен, но неохотен член на Менса; описва ги като „интелектуално войнствени“. Повече удоволствие му доставя да бъде президент на Американската асоциация на хуманистите.
На негово име е наречен астероидът 5020 Азимов, две различни награди „Айзък Азимов“ и списанието „Asimov''s Science Fiction“.',
        9);
INSERT INTO authors (id, first_name, last_name, description, picture_id)
VALUES (5, 'Фредрик', 'Бакман',
        'Фредрик Бакман (на шведски: Fredrik Backman) е шведски журналист, блогър и писател, автор на бестселъри в жанровете съвременен роман и сатира.',
        7);
INSERT INTO authors (id, first_name, last_name, description, picture_id)
VALUES (6, 'Aldous', 'Huxley',
        '',
        7);
INSERT INTO authors (id, first_name, last_name, description, picture_id)
VALUES (7, 'Ray', 'Bradbury',
        'Ray Douglas Bradbury was an American author and screenwriter. One of the most celebrated 20th-century American writers, he worked in a variety of modes, including fantasy, science fiction, horror, mystery, and realistic fiction.',
        11);
INSERT INTO authors (id, first_name, last_name, description, picture_id)
VALUES (8, 'George', 'Orwell',
        'Eric Arthur Blair known by his pen name George Orwell, was an English novelist, essayist, journalist and critic. His work is characterised by lucid prose, biting social criticism, total opposition to totalitarianism, and outspoken support of democratic socialism.',
        13);


INSERT INTO books (id, isbn, title, description, picture_id, added_on, modified, active, pages_count, copies,
                   release_year,
                   price, language,
                   publishing_house_id, author_id, creator_id)
VALUES (1, '9547394169', 'Братя Карамазови',
        'Шедьоврите на световната литература са кардиналите, които крепят огромното и невидимо мироздание на човешкия дух. Във всяко време, когато са поставени на изпитание нравствените устои на отделната личност или цели нации, великата творба е като спасителна слънчева стълба в бездната на отчаянието, хаоса и неверието. Романът "Братя Карамазови" е един от най-ярките в творчеството на Фьодор Достоевски и заема своето достойно място в така нареченото Петокнижие на автора, редом с "Идиот", "Престъпление и наказание", "Бесове"... В него характерната за Достоевски тема за страданието и просветлението е особено мащабно застъпена, а образите, които великият майстор е изваял с перото си, са се превърнали в емблематични за всяко поколение.',
        1,
        UTC_TIMESTAMP(), UTC_TIMESTAMP(),
        true, 934, 3, 2003, 30.00, 'BULGARIAN',
        4, 3, 1);
INSERT INTO books (id, isbn, title, description, picture_id, added_on, modified, active, pages_count, copies,
                   release_year,
                   price, language,
                   publishing_house_id, author_id, creator_id)
VALUES (2, '9789545841958', 'Хрониките на Амбър 1',
        '“Хрониките на Амбър” са си спечелили заслужено място като класика на всички времена сред шедьоврите на творческото въображение.
Амбър е единственият истински свят, който се отразява в безброй огледални светове Сенки, подвластни на Принцовете на Амбър. Кралското семейство е разединено от завист и подозрения. Изчезването на родоначалника Оберон е засилило вътрешните конфликти и тронът е уязвим за узурпатори. Станете свидетели на титаничната битка за надмощие на Земята и в Царството на Хаоса, където силите на Амбър и Хаоса водят непрестанна борба за власт посредством заговори и смели ходове.',
        2,
        UTC_TIMESTAMP(), UTC_TIMESTAMP(),
        true, 576, 5, 2014, 29.99, 'BULGARIAN',
        3, 2, 1);
INSERT INTO books (id, isbn, title, picture_id, added_on, modified, active, pages_count, copies, release_year, price,
                   language,
                   publishing_house_id, author_id, creator_id)
VALUES (3, '9549513971', 'Събрани разкази; т.5',
        3,
        UTC_TIMESTAMP(), UTC_TIMESTAMP(),
        true, 288, 2, 2001, 7.00, 'BULGARIAN',
        5, 4, 1);
INSERT INTO books (id, isbn, title, description, picture_id, added_on, modified, active, pages_count, copies,
                   release_year,
                   price, language,
                   publishing_house_id, author_id, creator_id)
VALUES (4, '9789545841705', 'Властелинът на Пръстените',
        'Не е възможно да се предадат на посягащия за пръв път към тази книга всичките й достойнства, нейния мащаб и великолепие.
Криволичещ от епичното до комичното, от пасторалното до диаболичното, сюжетът пресъздава по възхитителен начин герои и сцени в един изцяло измислен, но напълно правдоподобен свят на джуджета, елфи и хора.
Пред вас е пълното издание на един невероятен роман, който не ще ви даде миг покой до последната страница… и дълги години след това.',
        4,
        UTC_TIMESTAMP(), UTC_TIMESTAMP(),
        true, 1088, 4, 2001, 46.99, 'BULGARIAN',
        3, 1, 1);
INSERT INTO books (id, isbn, title, description, picture_id, added_on, modified, active, pages_count, copies,
                   release_year,
                   price, language,
                   publishing_house_id, author_id, creator_id)
VALUES (5, '978954091017Х', 'Престъпление и наказание',
        'Шедьоврите на световната литература са кариатидите, които крепят огромното и невидимото мироздание на човешкия дух. Във всяко време, когато са поставени на изпитание нравствените устои на отделната личност или цели нации, великата творба е като спасителна слънчева стълба в бездната на отчаянието, хаоса и неверието.
Поредицата „Шедьовър" представя на българския читател образци на световната литература. В този том, драги читателю, ти предстои среща с един от великите романи на Достоевски - „Престъпление и наказание". Всичко ли е позволено на човека, мъртъв ли е неговият вътрешен бог? Всяко престъпление е човешко, а наказанието следва невидимите проявления на божествената воля, която спасява човешкото у човека.',
        1,
        UTC_TIMESTAMP(), UTC_TIMESTAMP(),
        true, 512, 1, 2011, 30.00, 'BULGARIAN',
        4, 3, 1);
INSERT INTO books (id, isbn, title, description, picture_id, added_on, modified, active, pages_count, copies,
                   release_year,
                   price, language,
                   publishing_house_id, author_id, creator_id)
VALUES (6, '9789542815075', 'Човек на име Уве',
        'Уве е на 59, заклет почитател и притежател на сааб, вдовец. Тъгата по любимата му Соня го кара всеки ден да пожелава смъртта си.
Вечно недоволен и гневен, наричат го изпълнения с горчивина кошмарен съсед, лесноизбухлив. Понякога Уве се пита защо наричат даден човек кисел, след като не обикаля улиците с фалшива усмивка. Той е темерут – от хората, които сочат с пръст онези, които не одобряват, и се отнасят към тях като към крадци, хванати пред прозореца. Но за него да спаси човешки живот е дреболия. Има железни принципи и е постигнал непоклатима рутина в действията си. Защо ли започва да ги нарушава?

Една сутрин бъбрива млада двойка с две весели дъщерички се нанасят в съседна къща и случайно смачкват пощенската му кутия. Случката води до комичния и трогателен разказ за безпризорна котка, неочаквано приятелство и древното изкуство да дадеш на заден с ремарке. Всичко, което се случва, ще промени киселия старец и ще разтърси до основи кварталното сдружение на обитателите.',
        5,
        UTC_TIMESTAMP(), UTC_TIMESTAMP(),
        true, 294, 5, 2014, 14.00, 'BULGARIAN',
        1, 5, 1);
INSERT INTO books (id, isbn, title, description, picture_id, added_on, modified, active, pages_count, copies,
                   release_year,
                   price, language,
                   publishing_house_id, author_id, creator_id)
VALUES (7, '9780060850524', 'Brave New World',
        'Welcome to New London. Everybody is happy here. Our perfect society achieved peace and stability through the prohibition of monogamy, privacy, money, family and history itself. Now everyone belongs.

You can be happy too. All you need to do is take your Soma pills.

Discover the brave new world of Aldous Huxley''s classic novel, written in 1932, which prophesied a society which expects maximum pleasure and accepts complete surveillance - no matter what the cost.',
        10,
        UTC_TIMESTAMP(), UTC_TIMESTAMP(),
        true, 288, 3, 2006, 20.00, 'ENGLISH',
        7, 6, 1);
INSERT INTO books (id, isbn, title, description, picture_id, added_on, modified, active, pages_count, copies,
                   release_year,
                   price, language,
                   publishing_house_id, author_id, creator_id)
VALUES (8, '9781451673319', 'Fahrenheit 451',
        'Internationally acclaimed with more than 5 million copies in print, Fahrenheit 451 is Ray Bradbury''s classic novel of censorship and defiance, as resonant today as it was when it was first published nearly 50 years ago.',
        12,
        UTC_TIMESTAMP(), UTC_TIMESTAMP(),
        true, 256, 2, 2012, 25.00, 'ENGLISH',
        8, 7, 1);
INSERT INTO books (id, isbn, title, description, picture_id, added_on, modified, active, pages_count, copies,
                   release_year,
                   price, language,
                   publishing_house_id, author_id, creator_id)
VALUES (9, '9780451524935', '1984',
        'Portrays a terrifying vision of life in the future when a totalitarian government, considered a "Negative Utopia," watches over all citizens and directs all activities, becoming more powerful as time goes by.',
        14,
        UTC_TIMESTAMP(), UTC_TIMESTAMP(),
        true, 336, 4, 1990, 25.00, 'ENGLISH',
        9, 8, 1);

INSERT INTO books_categories (book_entity_id, categories_id)
VALUES (1, 1);
INSERT INTO books_categories (book_entity_id, categories_id)
VALUES (1, 7);
INSERT INTO books_categories (book_entity_id, categories_id)
VALUES (2, 1);
INSERT INTO books_categories (book_entity_id, categories_id)
VALUES (2, 4);
INSERT INTO books_categories (book_entity_id, categories_id)
VALUES (3, 1);
INSERT INTO books_categories (book_entity_id, categories_id)
VALUES (3, 5);
INSERT INTO books_categories (book_entity_id, categories_id)
VALUES (4, 1);
INSERT INTO books_categories (book_entity_id, categories_id)
VALUES (4, 4);
INSERT INTO books_categories (book_entity_id, categories_id)
VALUES (5, 1);
INSERT INTO books_categories (book_entity_id, categories_id)
VALUES (5, 7);
INSERT INTO books_categories (book_entity_id, categories_id)
VALUES (6, 1);
INSERT INTO books_categories (book_entity_id, categories_id)
VALUES (7, 1);
INSERT INTO books_categories (book_entity_id, categories_id)
VALUES (7, 11);
INSERT INTO books_categories (book_entity_id, categories_id)
VALUES (8, 1);
INSERT INTO books_categories (book_entity_id, categories_id)
VALUES (8, 11);
INSERT INTO books_categories (book_entity_id, categories_id)
VALUES (9, 1);
INSERT INTO books_categories (book_entity_id, categories_id)
VALUES (9, 11);

INSERT INTO orders (id, order_time, price, status, customer_id)
VALUES (1, '2021-01-03 21:45:00.080751', 30.00, 'DELIVERED', 1);
INSERT INTO order_items (id, book_id, order_id, quantity)
VALUES (1, 1, 1, 1);

INSERT INTO orders (id, order_time, price, status, customer_id)
VALUES (2, '2021-02-10 21:45:00.080751', 30.00, 'DELIVERED', 1);
INSERT INTO order_items (id, book_id, order_id, quantity)
VALUES (2, 1, 2, 1);

INSERT INTO orders (id, order_time, price, status, customer_id)
VALUES (3, '2021-03-16 21:45:00.080751', 36.99, 'DELIVERED', 1);
INSERT INTO order_items (id, book_id, order_id, quantity)
VALUES (3, 2, 3, 1);
INSERT INTO order_items (id, book_id, order_id, quantity)
VALUES (4, 3, 3, 1);

INSERT INTO orders (id, order_time, price, status, customer_id)
VALUES (4, '2021-04-18 21:45:00.080751', 46.99, 'DELIVERED', 1);
INSERT INTO order_items (id, book_id, order_id, quantity)
VALUES (5, 4, 4, 1);

INSERT INTO orders (id, order_time, price, status, customer_id)
VALUES (5, '2021-05-03 21:45:00.080751', 30.00, 'DELIVERED', 1);
INSERT INTO order_items (id, book_id, order_id, quantity)
VALUES (6, 5, 5, 1);

INSERT INTO orders (id, order_time, price, status, customer_id)
VALUES (6, '2021-06-07 21:45:00.080751', 14.00, 'DELIVERED', 1);
INSERT INTO order_items (id, book_id, order_id, quantity)
VALUES (7, 6, 6, 1);

INSERT INTO orders (id, order_time, price, status, customer_id)
VALUES (7, '2021-07-10 21:45:00.080751', 20.00, 'DELIVERED', 1);
INSERT INTO order_items (id, book_id, order_id, quantity)
VALUES (8, 7, 7, 1);

INSERT INTO orders (id, order_time, price, status, customer_id)
VALUES (8, '2021-08-20 21:45:00.080751', 25.00, 'DELIVERED', 1);
INSERT INTO order_items (id, book_id, order_id, quantity)
VALUES (9, 8, 8, 1);

INSERT INTO orders (id, order_time, price, status, customer_id)
VALUES (9, '2021-09-03 21:45:00.080751', 25.00, 'DELIVERED', 1);
INSERT INTO order_items (id, book_id, order_id, quantity)
VALUES (10, 9, 9, 1);

INSERT INTO orders (id, order_time, price, status, customer_id)
VALUES (10, '2021-10-05 21:45:00.080751', 29.99, 'DELIVERED', 1);
INSERT INTO order_items (id, book_id, order_id, quantity)
VALUES (11, 2, 10, 1);