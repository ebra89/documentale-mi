DROP TABLE IF EXISTS archive;

CREATE TABLE IF NOT EXISTS `archive` (
  `id` BIGINT AUTO_INCREMENT  PRIMARY KEY,
  `document_id` BIGINT NOT NULL,
  `archive_user_id` varchar(20) NOT NULL,
  `state` varchar(20) NOT NULL,
  `location` varchar(20) NOT NULL,
  `archive_date` date NOT NULL,
  `create_date` date NOT NULL,
  `create_user` varchar(20) NOT NULL,
  `update_date` date DEFAULT NULL,
  `update_user` varchar(20) DEFAULT NULL
);

