-- 特定のユーザーIDの次回予定日を取得
SELECT * FROM next_schedule WHERE user_id = /* userId */0;

-- 次回予定日を近い順に取得
SELECT * FROM next_schedule ORDER BY next_date ASC;