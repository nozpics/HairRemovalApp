-- 既存のユーザー情報を更新
UPDATE users
SET user_name = /* user.userName */'test',
    password_hash = /* user.passwordHash */'hash'
WHERE user_id = /* user.userId */1;