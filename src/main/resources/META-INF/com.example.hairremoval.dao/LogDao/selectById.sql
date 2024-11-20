-- 主キーに基づいて特定の履歴を取得
SELECT * FROM log
WHERE user_id = /* userId */ 0
AND body_code = /* bodyCode */ ''
AND session_count = /* sessionCount */ 0;