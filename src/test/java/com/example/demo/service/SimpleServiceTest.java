package com.example.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertThrows;

/*
 * Author : Egor Lesko
 * Date Created: 2023/01/06
 */

@SpringBootTest
class SimpleServiceTest {
    @Autowired
    private SimpleService objectUnderTest;
    @Autowired
    private DataSource dataSource;

    @BeforeEach
    void truncateTables() {
        try (Connection con = dataSource.getConnection(); Statement st = con.createStatement();) {
            st.execute("truncate table `hibernate_sequences`;");
            st.execute("truncate table `simple_entity`;");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testSaveAllAndFailWhenSequenceExists() {
        assertThrows(DataIntegrityViolationException.class, () -> {
            try (Connection con = dataSource.getConnection(); Statement st = con.createStatement();) {
                st.execute("insert into `hibernate_sequences` VALUES (1, 'SimpleEntity', 1)");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            objectUnderTest.saveAllAndGet();
        });

    }

    @Test
    void testSaveAllAndGetWhenSequenceExistsButGreaterThanIncrementSize() {
        try (Connection con = dataSource.getConnection(); Statement st = con.createStatement();) {
            st.execute("insert into `hibernate_sequences` VALUES (1, 'SimpleEntity', 20000)");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        objectUnderTest.saveAllAndGet();
    }

    @Test
    void testSaveAllAndGetWhenSequenceDoesNotExist() {
        objectUnderTest.saveAllAndGet();
    }

}