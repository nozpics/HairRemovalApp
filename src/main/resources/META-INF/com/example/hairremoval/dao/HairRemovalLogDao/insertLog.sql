-- 新しい履歴をデータベースに挿入
INSERT INTO hairremoval_log (user_id, date, body_code, session_count)
VALUES(
1,
date,
(SELECT hairremoval_log.body_code FROM hairremoval_log
    JOIN body_part ON hairremoval_log.body_code = body_part.body_code
    WHERE body_part.name=name LIMIT 1;),
(SELECT IF (
    (hairremoval_log.session_count FROM hairremoval_log
        JOIN body_part ON hairremoval_log.body_code = body_part.body_code
        WHERE body_part.name=name) IS NULL,1,
        MAX(hairremoval_log.session_count)+1 FROM hairremoval_log
        JOIN body_part ON hairremoval_log.body_code = body_part.body_code
        WHERE body_part.name=name))
        );