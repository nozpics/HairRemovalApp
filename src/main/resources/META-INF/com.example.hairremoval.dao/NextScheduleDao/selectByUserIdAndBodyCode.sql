-- ユーザーIDと脱毛部位に基づいて次回の予定日を取得
SELECT * FROM next_schedule
WHERE user_id = /* userId */ 0
AND body_code = /* bodyCode */ '';