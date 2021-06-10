DROP TABLE IF EXISTS weather;

CREATE TABLE weather (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    city VARCHAR(100) NOT NULL,
    date VARCHAR(20) NOT NULL,
    max_temp VARCHAR(10) NOT NULL,
    avg_temp VARCHAR(10) NOT NULL,
    min_temp VARCHAR(10) NOT NULL,
    number_of_inquiries INT NOT NULL,
);