DROP TABLE IF EXISTS weather;

CREATE TABLE weather (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    city VARCHAR(50) NOT NULL,
    date VARCHAR(10) NOT NULL,
    max_temp VARCHAR(3) NOT NULL,
    avg_temp VARCHAR(3) NOT NULL,
    min_temp VARCHAR(3) NOT NULL,
    number_of_inquiries INT NOT NULL,
);