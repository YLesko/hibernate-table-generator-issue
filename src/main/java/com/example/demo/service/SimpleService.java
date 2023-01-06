/*
 * *************************************************************************
 * * Yaypay CONFIDENTIAL   2023
 * * All Rights Reserved. * *
 * NOTICE: All information contained herein is, and remains the property of Yaypay Incorporated and its suppliers, if any.
 * The intellectual and technical concepts contained  herein are proprietary to Yaypay Incorporated
 * and its suppliers and may be covered by U.S. and Foreign Patents, patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material  is strictly forbidden unless prior written permission is obtained  from Yaypay Incorporated.
 */


package com.example.demo.service;
/*
 * Author : Egor Lesko
 * Date Created: 2023/01/06
 */

import com.example.demo.model.SimpleEntity;
import com.example.demo.repository.SimpleEntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimpleService {
    @Autowired
    private SimpleEntityRepository simpleEntityRepository;

    @Transactional
    public List<SimpleEntity> saveAllAndGet() {
        List<SimpleEntity> entityList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            SimpleEntity simpleEntity = new SimpleEntity();
            simpleEntity.setData(String.valueOf(i));
            entityList.add(simpleEntity);
        }
        return simpleEntityRepository.saveAllAndFlush(entityList);
    }
}
