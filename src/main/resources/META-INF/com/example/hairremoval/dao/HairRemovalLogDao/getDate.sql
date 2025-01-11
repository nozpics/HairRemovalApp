-- 部位に基づいて脱毛日を取得
SELECT date FROM hairremoval_log
WHERE user_id = /* userId */0
AND body_code = /* bodyCode */'test'
ORDER BY date DESC
LIMIT 1;
