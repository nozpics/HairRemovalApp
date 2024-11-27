-- 新しい次回予定日をデータベースに挿入
INSERT INTO next_schedule (user_id, body_code, next_date)
VALUES (/* nextSchedule.userId */1, /* nextSchedule.bodyCode */'test', /* nextSchedule.nextDate */NULL);