SELECT MAX(ha.session_count) FROM hairremoval_log ha
JOIN body_part
ON ha.body_code = body_part.body_code AND body_part.name = /* bodyCode */'example' AND ha.user_id= /* userId */0;