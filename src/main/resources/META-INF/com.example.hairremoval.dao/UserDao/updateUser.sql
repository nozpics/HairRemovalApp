-- 既存のユーザー情報を更新
UPDATE users
SET user_name = /* user.user_name */ '',
    password_hash = /* user.password_hash */ ''
WHERE user_id = /* user.user_id */ 0;