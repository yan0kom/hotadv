CREATE TABLE `addresses` (
  `id` bigint NOT NULL AUTO_INCREMENT,  
  `zip_code` varchar(6) DEFAULT NULL,
  `city` varchar(100) NOT NULL,  
  `street` varchar(150) NOT NULL,
  `house` varchar(50) NOT NULL,  
  `apartment` varchar(25) DEFAULT NULL,  
  PRIMARY KEY (`id`)
);

CREATE TABLE `companies` (
  `id` bigint NOT NULL AUTO_INCREMENT,  
  `name` varchar(100) NOT NULL,
  `legal_form` varchar(10) DEFAULT NULL,
  `address_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `KEY_companies_address_id` (`address_id`),
  CONSTRAINT `FK_companies_address_id` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`id`)
);

CREATE TABLE `branches` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `address_id` bigint NOT NULL,
  `company_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `KEY_branches_address_id` (`address_id`),
  KEY `KEY_branches_company_id` (`company_id`),
  CONSTRAINT `FK_branches_address_id` FOREIGN KEY (`address_id`) REFERENCES `addresses` (`id`),
  CONSTRAINT `FK_branches_company_id` FOREIGN KEY (`company_id`) REFERENCES `companies` (`id`)
);
