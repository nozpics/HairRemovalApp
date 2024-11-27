-- 既存の脱毛部位情報を更新する
UPDATE body_part
SET name = /* bodyPart.name */'test'
WHERE body_code = /* bodyPart.bodyCode */'test';