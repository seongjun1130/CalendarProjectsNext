Create TABLE IF NOT EXISTS users
(
    id          int PRIMARY KEY AUTO_INCREMENT,
    username    varchar(20)  NOT NULL UNIQUE,
    email       varchar(50)  NOT NULL UNIQUE,
    password    varchar(255) NOT NULL,
    role        varchar(50)  NOT NULL,
    created_at  DATETIME,
    modified_at DATETIME
);
CREATE TABLE IF NOT EXISTS schedule
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    title           VARCHAR(50)  NOT NULL,
    scheduledetails VARCHAR(255) NOT NULL,
    weather         VARCHAR(255) NOT NULL,
    created_at      DATETIME,
    modified_at     DATETIME,
    user_id         BIGINT,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS comment
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    comment     VARCHAR(100) NOT NULL,
    created_at  DATETIME,
    modified_at DATETIME,
    schedule_id BIGINT,
    user_name   VARCHAR(20),
    FOREIGN KEY (schedule_id) REFERENCES schedule (id) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS userschedule
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id     BIGINT,
    schedule_id BIGINT,
    role        VARCHAR(255) NOT NULL,
    joined_at   DATETIME,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (schedule_id) REFERENCES schedules (id) ON DELETE CASCADE
);

