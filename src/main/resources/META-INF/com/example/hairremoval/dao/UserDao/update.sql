-- 既存のユーザー情報を更新
UPDATE users
SET user_name = /* user.user_name */'test',
    password_hash = /* user.password_hash */'hash'
WHERE user_id = /* user.user_id */1;