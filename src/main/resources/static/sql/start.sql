INSERT INTO toys (id, name, toy_price, description) values (1, 'Кулич пасхальный', 399.01, 'Дикий жоский мега крут совун белый летать') ON CONFLICT (id) DO NOTHING;
INSERT INTO toys (id, name, toy_price, description) values (2, 'Торт "Бабуле"', 1200, 'Фигурка чека пука крутая умеет стрелять из M4A4 со скинум топливный инжектор') ON CONFLICT (id) DO NOTHING;
INSERT INTO toys (id, name, toy_price, description) values (3, 'Торт футбольный мячик', 2406, 'Крутотенский блюститель закона русский ответ омереке пукает громка') ON CONFLICT (id) DO NOTHING;
INSERT INTO toys (id, name, toy_price, description) values (4, 'Торт снеговик', 899, 'Лютый дебошир стрелок, амогус вахтанг римский юлий цезарь ром крут') ON CONFLICT (id) DO NOTHING;
INSERT INTO toys (id, name, toy_price, description) values (5, 'Шоколад шашки', 540, 'Бабер йода валун крутить двигать Таков путь') ON CONFLICT (id) DO NOTHING;
/*
ALTER TABLE user_roles ADD COLUMN id serial NOT NULL;
ALTER TABLE user_roles ADD CONSTRAINT prima_key PRIMARY KEY (id);
*/
INSERT INTO roles (id, role) VALUES (0, 'ROLE_USER') ON CONFLICT DO NOTHING;
INSERT INTO roles (id, role) VALUES (1, 'ROLE_ADMIN') ON CONFLICT DO NOTHING;

INSERT INTO users (id, name, password, phone_number, sir_name, user_name, account_non_locked) VALUES (0, '-', '$2a$12$UxaX6oq8qWJoSA2qMX9LWeLT0dtaKiS7NcXXDnFFl1wxFNustGxIK', '-', '-', 'admin', true) ON CONFLICT DO NOTHING;
INSERT INTO user_roles(user_id, role_id) VALUES (0, 1) ON CONFLICT DO NOTHING;
