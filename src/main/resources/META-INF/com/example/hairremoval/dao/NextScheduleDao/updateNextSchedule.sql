-- 既存の次回予定日を更新
UPDATE next_schedule
SET body_code = /* nextSchedule.body_code */ '',
    next_date = /* nextSchedule.next_date */ NULL
WHERE user_id = /* nextSchedule.user_id */ 0;