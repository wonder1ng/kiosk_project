DROP DATABASE IF EXISTS kiosk_db;
CREATE DATABASE kiosk_db;
use kiosk_db;

CREATE TABLE user_role (
	user_role_id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	role VARCHAR(255) NOT NULL
);

CREATE TABLE user (
	user_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	user_role_id TINYINT UNSIGNED NOT NULL,
	sign_id VARCHAR(255) NOT NULL UNIQUE,
	password CHAR(60) NOT NULL,
	phone_number CHAR(13) NOT NULL,
	fax_number CHAR(13) NULL,
	zip_code CHAR(5) NOT NULL,
	street_address VARCHAR(63) NOT NULL,
	detail_address VARCHAR(63) NOT NULL,
	company_name VARCHAR(63) NOT NULL,
	branch VARCHAR(63) NOT NULL,
	business_number CHAR(10) NOT NULL,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE kiosk (
	kiosk_id SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	user_id BIGINT UNSIGNED NOT NULL,
	kiosk_number SMALLINT UNSIGNED NOT NULL,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE category (
	category_id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	cate VARCHAR(63) NOT NULL
);

CREATE TABLE menu_status (
	menu_status_id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	status VARCHAR(63) NOT NULL
);

CREATE TABLE menu (
	menu_id SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(63) NOT NULL,
	image VARCHAR(255) NULL DEFAULT NULL,
	description text NULL,
	price MEDIUMINT UNSIGNED NOT NULL,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	modified_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	menu_status_id TINYINT UNSIGNED NOT NULL,
	category_id TINYINT UNSIGNED NOT NULL
);

CREATE TABLE menu_option (
	menu_option_id SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	menu_id SMALLINT UNSIGNED NOT NULL,
	radio BOOLEAN NOT NULL DEFAULT 1,
	name VARCHAR(63) NOT NULL,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	modified_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	menu_status_id TINYINT UNSIGNED NOT NULL
);

CREATE TABLE option_detail (
	option_detail_id MEDIUMINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	menu_option_id SMALLINT UNSIGNED NOT NULL,
	menu_id SMALLINT UNSIGNED NOT NULL,
	price MEDIUMINT UNSIGNED NOT NULL,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	modified_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	menu_status_id TINYINT UNSIGNED NOT NULL
);

CREATE TABLE payment_method (
	payment_method_id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	method VARCHAR(63) NOT NULL
);

CREATE TABLE sale_type (
	sale_type_id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	type VARCHAR(63) NOT NULL
);

CREATE TABLE sale_status (
	sale_status_id TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	status VARCHAR(63) NOT NULL
);

CREATE TABLE sale (
	sale_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	kiosk_id SMALLINT UNSIGNED NOT NULL,
	price MEDIUMINT UNSIGNED NOT NULL,
	payment_response BOOLEAN NOT NULL,
	created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	completed_at DATETIME NULL,
	received_at DATETIME NULL,
	cancel BOOLEAN NOT NULL DEFAULT 0,
	sale_status_id TINYINT UNSIGNED NOT NULL,
	payment_method_id TINYINT UNSIGNED NOT NULL,
	sale_type_id TINYINT UNSIGNED NOT NULL
);

CREATE TABLE sale_item (
	sale_item_id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	sale_id INT UNSIGNED NOT NULL,
	menu_id SMALLINT UNSIGNED NOT NULL,
	item_sequence TINYINT UNSIGNED NOT NULL,
	price MEDIUMINT UNSIGNED NOT NULL,
	quantity TINYINT UNSIGNED NOT NULL DEFAULT 1
);

ALTER TABLE user
    ADD CONSTRAINT FK_user_user_role_id FOREIGN KEY (user_role_id) REFERENCES user_role(user_role_id);

ALTER TABLE kiosk
    ADD CONSTRAINT FK_kiosk_user_id FOREIGN KEY (user_id) REFERENCES user(user_id);

ALTER TABLE menu
    ADD CONSTRAINT FK_mnus_menu_status_id FOREIGN KEY (menu_status_id) REFERENCES menu_status(menu_status_id),
    ADD CONSTRAINT FK_menu_category_id FOREIGN KEY (category_id) REFERENCES category(category_id);

ALTER TABLE menu_option
    ADD CONSTRAINT FK_mnus_option_menu_id FOREIGN KEY (menu_id) REFERENCES menu(menu_id),
    ADD CONSTRAINT FK_mnus_options_menu_status_id FOREIGN KEY (menu_status_id) REFERENCES menu_status(menu_status_id);

ALTER TABLE option_detail
    ADD CONSTRAINT FK_otions_details_menu_option_id FOREIGN KEY (menu_option_id) REFERENCES menu_option(menu_option_id),
    ADD CONSTRAINT FK_option_detail_menu_id FOREIGN KEY (menu_id) REFERENCES menu(menu_id),
    ADD CONSTRAINT FK_option_detail_statuses_id FOREIGN KEY (menu_status_id) REFERENCES menu_status(menu_status_id);

ALTER TABLE sale
    ADD CONSTRAINT FK_sale_kiosk_id FOREIGN KEY (kiosk_id) REFERENCES kiosk(kiosk_id),
    ADD CONSTRAINT FK_sale_sale_status_id FOREIGN KEY (sale_status_id) REFERENCES sale_status(sale_status_id),
    ADD CONSTRAINT FK_sale_payment_method_id FOREIGN KEY (payment_method_id) REFERENCES payment_method(payment_method_id),
    ADD CONSTRAINT FK_sale_sale_type_id FOREIGN KEY (sale_type_id) REFERENCES sale_type(sale_type_id);

ALTER TABLE sale_item
    ADD CONSTRAINT FK_sale_item_sale_id FOREIGN KEY (sale_id) REFERENCES sale(sale_id),
    ADD CONSTRAINT FK_sale_item_menu_id FOREIGN KEY (menu_id) REFERENCES menu(menu_id);

INSERT INTO user_role(role) VALUES
	("ROLE_ADMIN"),
	("ROLE_MAIN_USER"),
	("ROLE_BRANCH_USER");

INSERT INTO payment_method(method) VALUES
	("카드"),
	("삼성페이");

INSERT INTO sale_status(status) VALUES
	("접수 및 조리"),
	("조리 완료"),
	("수령 완료");

INSERT INTO sale_type(type) VALUES
	("매장"),
	("포장"),
	("배달");

INSERT INTO menu_status(status) VALUES
	("판매"),
	("품절"),
	("숨김"),
	("옵션 추가");
