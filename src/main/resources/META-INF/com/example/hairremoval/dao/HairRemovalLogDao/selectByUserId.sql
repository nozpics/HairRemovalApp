-- 特定のユーザーIDに関する全ての履歴を取得
SELECT ha.date,body_part.name,ha.session_count FROM hairremoval_log ha
JOIN body_part ON ha.body_code = body_part.body_code
WHERE ha.user_id = /* userId */0
ORDER BY date DESC;