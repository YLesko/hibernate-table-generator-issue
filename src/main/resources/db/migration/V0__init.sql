CREATE TABLE simple_entity
(
    `id`   bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `data` varchar(128) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `hibernate_sequences`
(
    `sequence_name` varchar(100) NOT NULL,
    `next_val`      bigint(20) DEFAULT NULL,
    PRIMARY KEY (`sequence_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;