

CREATE TABLE `hibernate_sequences` (

  `sequence_name` varchar(255) DEFAULT NULL,
 
 `sequence_next_hi_value` int(11) DEFAULT NULL

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `UK_k8d0f2n7n88w1a16yhua64onx` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

CREATE TABLE `players` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(100) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `childrendetails` varchar(200) DEFAULT NULL,
  `emailaddress` varchar(255) NOT NULL,
  `haschildren` bit(1) NOT NULL,
  `income` bigint(20) NOT NULL,
  `isMarried` bit(1) NOT NULL,
  `phonenumber` varchar(255) NOT NULL,
  `playername` varchar(50) NOT NULL,
  `rank` varchar(255) NOT NULL,
  `ratingscore` int(11) NOT NULL,
  `sportscategory` varchar(255) NOT NULL,
  `spousename` varchar(255) DEFAULT NULL,
  `teamname` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_1y1lfm93h38yldgmd35w2ex9v` (`playername`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


CREATE TABLE `teams` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(100) DEFAULT NULL,
  `emailaddress` varchar(255) NOT NULL,
  `foundedinyear` int(11) DEFAULT NULL,
  `income` int(11) NOT NULL,
  `numberofplayers` int(11) NOT NULL,
  `phonenumber` varchar(255) NOT NULL,
  `ratingscore` int(11) NOT NULL,
  `sportscategory` varchar(255) NOT NULL,
  `teamname` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_pnsjw12011jnf6w11pnd26kob` (`teamname`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


CREATE TABLE `deals` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amounttransactioned` double NOT NULL,
  `dealname` varchar(50) NOT NULL,
  `numberofplayersbought` int(11) NOT NULL,
  `numberofplayerssold` int(11) NOT NULL,
  `sportscategory` varchar(255) NOT NULL,
  `valability` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_acwgecynm6d8qd4erou0blear` (`dealname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
