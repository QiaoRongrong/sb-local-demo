package com.yf.sblocaldemo.service.joke;


/**
 * 数据预处理
 *
 * 1. SQL: clean records by keywords:
 *      delete from sf_duanzi where content like '%废柴%';
 delete from sf_duanzi where content like '%浮夸%';
 delete from sf_duanzi where content like '%哈哈%';
 delete from sf_duanzi where content like '%哈友%';
 * 2. give userAddTime
 * 3. mediaType
 * 4. shareCount
 * 5. UserId
 * 6. labelId
 * 7. labelName ???
 *
 */

public interface DuanziCleaner {

    void clean();

    void giveUserForAll();

    void giveMediaTypeForAll();

    void giveUserAddTime();

}
