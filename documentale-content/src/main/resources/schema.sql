DROP TABLE IF EXISTS document;
DROP TABLE IF EXISTS protocol;

CREATE TABLE IF NOT EXISTS `protocol` (
  `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
  `validation_user`varchar(100),
  `is_valid` BIT,
  `type` varchar(10) NOT NULL,
  `state` varchar(20) NOT NULL,
  `create_date` date NOT NULL,
  `create_user` varchar(20) NOT NULL,
  `update_date` date DEFAULT NULL,
  `update_user` varchar(20) DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `document` (
  `id` BIGINT AUTO_INCREMENT  PRIMARY KEY,
  `ref_number` varchar(10) NOT NULL,
  `owner` varchar(100) NOT NULL,
  `type` varchar(10) NOT NULL,
  `state` varchar(20) NOT NULL,
  `location` varchar(20) NOT NULL,
  `doc_date` date NOT NULL,
  `create_date` date NOT NULL,
  `create_user` varchar(20) NOT NULL,
  `update_date` date DEFAULT NULL,
  `update_user` varchar(20) DEFAULT NULL,
  `protocol_id` BIGINT DEFAULT NULL,
  foreign key (protocol_id) references protocol(id)
);

