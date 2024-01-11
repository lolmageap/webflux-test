DROP TABLE IF EXISTS food;
CREATE TABLE food
(
    id    bigint NOT NULL AUTO_INCREMENT,
    name  varchar(50),
    price int,
    primary key (id)
)