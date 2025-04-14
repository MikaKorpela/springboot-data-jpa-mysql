CREATE TABLE IF NOT EXISTS `persons` (
    `person_id` int AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL,
    `address_id` int NULL,
    `employer_id` int NULL,

    `created_at` TIMESTAMP NOT NULL,
    `updated_at` TIMESTAMP NULL,

    FOREIGN KEY (address_id) REFERENCES addresses(address_id),
    FOREIGN KEY (employer_id) REFERENCES employers(employer_id)
);

CREATE TABLE IF NOT EXISTS `employers` (
    `employer_id` int AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL,

   `created_at` TIMESTAMP NOT NULL,
   `updated_at` TIMESTAMP NULL
);

CREATE TABLE IF NOT EXISTS `addresses` (
    `address_id` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `street` varchar(100) NOT NULL,
    `post_code` int NOT NULL,
    `city` varchar(50) NOT NULL,
    `country` varchar(50) NOT NULL,

    `created_at` TIMESTAMP NOT NULL,
    `updated_at` TIMESTAMP DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `professions` (
    `profession_id` int AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL,

    `created_at` TIMESTAMP NOT NULL,
    `updated_at` TIMESTAMP NULL
);

CREATE TABLE IF NOT EXISTS `persons_professions` (
    `person_id` int NOT NULL,
    `profession_id` int NOT NULL,
    FOREIGN KEY (person_id) REFERENCES person(person_id),
    FOREIGN KEY (profession_id) REFERENCES professions(profession_id),
    PRIMARY KEY (`person_id`,`profession_id`)
);
