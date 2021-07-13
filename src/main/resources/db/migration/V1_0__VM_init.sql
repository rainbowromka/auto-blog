/**
 * Необходимо что бы заработал Hibernate.
 */
CREATE SEQUENCE autoblog.hibernate_sequence;

CREATE TABLE autoblog.auto_events (
    /**
     * ID события.
     */
    id BIGINT NOT NULL CONSTRAINT auto_events_pkey PRIMARY KEY,

    /**
     * Тип события.
     */
    auto_event_type VARCHAR,

    /**
     * Дата события.
     */
    event_date TIMESTAMP,

    /**
     * Пробег автомобиля.
     */
    mileage BIGINT,

    /**
     * Стоимость услуги, во время события. Либо NULL.
     */
    price FLOAT
);

/**
 * Дополнительные поля для события - заправка Авто.
 */
CREATE TABLE autoblog.auto_events_refueling (
  /**
   * ID события.
   */
  id BIGINT NOT NULL
    CONSTRAINT auto_events_refueling_pkey PRIMARY KEY
    CONSTRAINT auto_events_refueling_id_fk REFERENCES autoblog.auto_events,

  /**
   * стоимость за литр бензина.
   */
  psc_price FLOAT NOT NULL,

  /**
   * Объем заправленого бензина в литрах.
   */
  value FLOAT NOT NULL,

  /**
   * Признак того, что машина заправлена максимально - бак полный.
   */
  is_full BOOLEAN,

  /**
   * Расход топлива в литрах на 100 километров.
   */
  arrage_value FLOAT
);

/**
 * Таблица Технического обслуживания.
 */
CREATE TABLE autoblog.auto_events_maintenance (
  /**
   * ID события.
   */
  id BIGINT NOT NULL
    CONSTRAINT auto_events_maintenance_pkey PRIMARY KEY
    CONSTRAINT auto_events_maintenance_id_fk REFERENCES autoblog.auto_events,

  /**
   * Комментарий к техническому обслуживанию.
   */
  comment VARCHAR
);

CREATE TABLE autoblog.users (
    /**
     * Id пользователя.
     */
    id BIGINT PRIMARY KEY,
    /**
     * Имя пользователя.
     */
    user_name VARCHAR UNIQUE,

    /**
     * Пароль.
     */
    password VARCHAR NOT NULL,

    /**
     * Роль.
     */
    role VARCHAR NOT NULL
);


CREATE SEQUENCE autoblog.auto_event_sequence START WITH 1;
CREATE SEQUENCE autoblog.user_sequence START WITH 1;