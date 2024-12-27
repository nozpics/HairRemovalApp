-- 既存のユーザー情報を更新
UPDATE users
SET user_name = /* userName */'test',
    password_hash = /* passwordHash */'hash'
WHERE user_id = /* userId */1;