-- 新しい次回予定日をデータベースに挿入
INSERT INTO next_schedule (user_id, body_code, next_date)
VALUES (/* nextSchedule.user_id */1, /* nextSchedule.body_code */'test', /* nextSchedule.next_date */NULL);