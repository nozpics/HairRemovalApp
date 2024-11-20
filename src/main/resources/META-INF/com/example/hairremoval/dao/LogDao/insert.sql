-- 新しい履歴をデータベースに挿入
INSERT INTO log (user_id, date, body_code, session_count)
VALUES (/* log.user_id */1, /* log.date */NULL, /* log.body_code */'test', /* log.session_count */1);