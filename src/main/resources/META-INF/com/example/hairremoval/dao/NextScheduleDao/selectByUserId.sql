-- 特定のユーザーIDの次回予定日を取得し、日付順にソート
SELECT MAX(ne.next_date) as nextDate,body_part.name as name,MAX(ha.session_count)+1 as sessionCount
   FROM next_schedule ne
   JOIN hairremoval_log ha ON ne.user_id = ha.user_id AND ne.user_id= /* userId */0 AND ne.body_code = ha.body_code
   JOIN body_part ON ne.body_code = body_part.body_code
   GROUP BY ne.body_code
   ORDER BY nextDate ASC;