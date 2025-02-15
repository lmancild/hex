CREATE TABLE CLIENT (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    CLIENT_ID VARCHAR(255) NOT NULL
);

CREATE TABLE PURCHASE (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    PURCHASE_CODE VARCHAR(255) NOT NULL,
    PURCHASE_PICKUP_DATE DATE NULL,
    PURCHASE_SATUS VARCHAR(255) NOT NULL,
    CLIENT_ID VARCHAR(255) NOT NULL
);


INSERT INTO CLIENT (ID, CLIENT_ID) VALUES (1, '17657952-8');
INSERT INTO PURCHASE (ID, PURCHASE_CODE, PURCHASE_PICKUP_DATE, PURCHASE_SATUS , CLIENT_ID) VALUES(1, 'PX01-20201010', NULL, 'DEV_PEN', 1);