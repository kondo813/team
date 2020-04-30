SET foreign_key_checks=1;

USE smiledb;

INSERT INTO mst_user
(user_name, password, family_name, first_name, family_name_kana, first_name_kana, gender)
VALUES("yamada@gmail.com", "123456", "山田", "花子", "やまだ", "はなこ", 1);

INSERT INTO mst_category
(category_name, category_description)
VALUES("フード","犬用のご飯です");

INSERT INTO mst_category
(category_name, category_description)
VALUES("おもちゃ","犬用の遊び道具です");

INSERT INTO mst_category
(category_name, category_description)
VALUES("家","犬用のおうちです");

INSERT INTO mst_product
(product_name, product_name_kana, product_description,category_id, price, image_full_path, release_date, release_company)
VALUES("ドックフード（ドライ）1.5kg","どっぐふーど（どらい）1.5kg","1才～6才　成犬用　小型犬用の小粒サイズ、自然素材の栄養バランスの優れたドックフードです。","1","1900","/img/dogfood.jpg","2017/2/30","スマイリードッグ");

INSERT INTO mst_product
(product_name, product_name_kana, product_description,category_id, price, image_full_path, release_date, release_company)
VALUES("ボーンガム（5本入り)","ぼーんがむ（5ほんいり）","小型～中型犬用　大切な愛犬の歯の健康のために、美味しく食べられるミルク味です。","1","1300","/img/bone.jpg","2020/1/20","スマイリードッグ");

INSERT INTO mst_product
(product_name, product_name_kana, product_description,category_id, price, image_full_path, release_date, release_company)
VALUES("ボール（2個入り）","ぼーる（2こいり）","小・中・大型犬に対応。弾力性、耐久性に優れ、水遊びにも使えます。","2","800","/img/ball.jpg","2020/04/01","スマイリードッグ");

INSERT INTO mst_product
(product_name, product_name_kana, product_description,category_id, price, image_full_path, release_date, release_company)
VALUES("フリスビー","ふりすびー","犬専用の天然ゴムで作られているので、愛犬と遊ぶ際にも安心してご利用いただけます。","2","1500","/img/flyingdisc.jpg","2020/04/01","スマイリードッグ");

INSERT INTO mst_product
(product_name, product_name_kana, product_description,category_id, price, image_full_path, release_date, release_company)
VALUES("大型犬用ハウス","おおがたけんようはうす","大型犬に最適！体高約70cmまで対応。プラスチック製で組み立ても簡単です。","3","9300","/img/house_red.jpg","2019/10/10","スマイリードッグ");

INSERT INTO mst_product
(product_name, product_name_kana, product_description,category_id, price, image_full_path, release_date, release_company)
VALUES("中型犬用ハウス","ちゅうがたけんようはうす","中型犬におススメ！青色屋根の可愛い木製ハウスです。体高約40cmまで対応しています。","3","7000","/img/house_blue.jpg","2018/04/01","スマイリードッグ");
