-- 既存の次回予定日を更新
UPDATE next_schedule
SET body_code = /* nextSchedule.bodyCode */'test',
    next_date = /* nextSchedule.nextDate */NULL
WHERE user_id = /* nextSchedule.userId */1;