insert into register values('12', 'winter', '1212', '김겨울', '1998-11-13', 'M', 'winter@gmail.com', '12426', '경기 가평군 가평읍 불기산길 2', '123', '010-1111-1111', '1', 'Nomal', now(), now());


---------------------------------------------------------
-- ** register update
UPDATE register SET id = 'summer', passwd = '2222', name = '김민지', birth = '1972-01-20', gender = 'W', email = 'busan@naver.com', postcode = '47243', address = '부산 부산진구 동천로132번길 34', address1 = '(전포동)', tel = '010-7845-6123', level = '1', grade = 'Nomal', modified = now() WHERE reg_id = '3';

UPDATE register SET id = #{id}, passwd = #{passwd}, name = #{name}, birth = #{birth}, gender = #{gender}, email = #{email}, postcode = #{postcode}, address = #{address}, address1 = #{address1}, tel = #{tel}, level = #{level}, grade = #{grade}, modified = now() WHERE reg_id = #{regId}

UPDATE
    register
SET
    id = #{id},
    passwd = #{passwd},
    name = #{name},
    birth = #{birth},
    gender = #{gender},
    email = #{email},
    postcode = #{postcode},
    address = #{address},
    address1 = #{address1},
    tel = #{tel},
    level = #{level},
    grade = #{grade},
    modified = now()
WHERE
    reg_id = #{regId}