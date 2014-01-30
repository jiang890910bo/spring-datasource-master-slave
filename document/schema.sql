 DROP SCHEMA IF EXISTS spring_datasource_master;
 CREATE SCHEMA IF NOT EXISTS spring_datasource_master DEFAULT CHARACTER SET utf8;
 USE spring_datasource_master;
 CREATE TABLE IF NOT EXISTS `t_user` (
 `id` int auto_increment,
 `username` varchar(12) DEFAULT NULL,
 `password` varchar(12) DEFAULT NULL,
 `birthday` date DEFAULT NULL,
 PRIMARY KEY(id))
 ENGINE=InnoDB DEFAULT CHARSET=utf8;
 GRANT ALL ON spring_datasource_master.* TO 'master'@'127.0.0.1' IDENTIFIED BY 'master';
 INSERT INTO t_user values(1,'master','pwd','2008-08-08');

 DROP SCHEMA IF EXISTS spring_datasource_slave01;
 CREATE SCHEMA IF NOT EXISTS spring_datasource_slave01 DEFAULT CHARACTER SET utf8;
 USE spring_datasource_slave01;
 CREATE TABLE IF NOT EXISTS `t_user` (
 `id` int auto_increment,
 `username` varchar(12) DEFAULT NULL,
 `password` varchar(12) DEFAULT NULL,
 `birthday` date DEFAULT NULL,
 PRIMARY KEY(id))
 ENGINE=InnoDB DEFAULT CHARSET=utf8;
 GRANT ALL ON spring_datasource_slave01.* TO 'slave01'@'127.0.0.1' IDENTIFIED BY 'slave01';
 INSERT INTO t_user values(1,'slave01','pwd','2008-08-08');

 DROP SCHEMA IF EXISTS spring_datasource_slave02;	
 CREATE SCHEMA IF NOT EXISTS spring_datasource_slave02 DEFAULT CHARACTER SET utf8;
 USE spring_datasource_slave02;
 CREATE TABLE IF NOT EXISTS `t_user` (
 `id` int auto_increment,
 `username` varchar(12) DEFAULT NULL,
 `password` varchar(12) DEFAULT NULL,
 `birthday` date DEFAULT NULL,
 PRIMARY KEY(id))
 ENGINE=InnoDB DEFAULT CHARSET=utf8;
 GRANT ALL ON spring_datasource_slave02.* TO 'slave02'@'127.0.0.1' IDENTIFIED BY 'slave02';
 INSERT INTO t_user values(1,'slave02','pwd','2008-08-08');
