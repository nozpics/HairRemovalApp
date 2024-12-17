-- 新しい次回予定日をデータベースに挿入
INSERT INTO next_schedule(user_id,body_code,next_date)
VALUES(
1,
(SELECT next_schedule.body_code FROM next_schedule JOIN body_part ON next_schedule.body_code = body_part.body_code WHERE body_part.name=name LIMIT 1),
nextDate
);