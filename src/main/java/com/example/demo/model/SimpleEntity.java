/*
 * *************************************************************************
 * * Yaypay CONFIDENTIAL   2023
 * * All Rights Reserved. * *
 * NOTICE: All information contained herein is, and remains the property of Yaypay Incorporated and its suppliers, if any.
 * The intellectual and technical concepts contained  herein are proprietary to Yaypay Incorporated
 * and its suppliers and may be covered by U.S. and Foreign Patents, patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material  is strictly forbidden unless prior written permission is obtained  from Yaypay Incorporated.
 */


package com.example.demo.model;
/*
 * Author : Egor Lesko
 * Date Created: 2023/01/06
 */

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "simple_entity")
@DynamicUpdate
@ToString(of = "id")
public class SimpleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "SimpleEntity")
    @GenericGenerator(
            name = "SimpleEntity",
            strategy = "org.hibernate.id.enhanced.TableGenerator",
            parameters = {
                    @Parameter(name = "table_name", value = "hibernate_sequences"),
                    @Parameter(name = "segment_value", value = "SimpleEntity"),
                    @Parameter(name = "increment_size", value = "10000")
            }
    )
    private Long id;

    @Column(name = "data")
    private String data;

    public void setData(String data) {
        this.data = data;
    }


    public String getData() {
        return data;
    }
}
