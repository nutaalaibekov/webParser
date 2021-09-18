create table website
(
    id          serial primary key,
    url         varchar(100) not null unique,
    description varchar(300)
);

create table data_category
(
    id          serial primary key,
    name        varchar(100) not null,
    description varchar(200),
    parent_id   integer
);

create table webpage
(
    id          serial primary key,
    url         varchar(300) not null unique,
    category_id integer references data_category (id),
    website_id  integer references website (id)
);


create table webpage_parse_scheduler
(
    id                 serial primary key,
    time_unit          varchar(255) not null,
    time_amount        integer not null,
    last_parsed_date   timestamp,
    created_date       timestamp,
    web_page_id        integer references webpage (id)
);

create table webpage_data
(
    id           serial primary key,
    json_data    text,
    data_id      text unique,
    created_date timestamp,
    webpage_id   integer references webpage (id)
);

create table webpage_parse_config
(
    id                 serial primary key,
    data_node_type     varchar(255) not null,
    data_property_name varchar(255) not null,
    is_data_id         boolean      not null,
    element_selector   varchar(255) not null,
    element_part       varchar(255) not null,
    element_part_key   varchar(255),
    webpage_id         integer references webpage (id)
);


insert into webpage_parse_config(data_node_type, data_property_name, is_data_id, element_selector, element_part, element_part_key, webpage_id)
values('ROOT', data_property_name, is_data_id, element_selector, element_part, element_part_key, webpage_id);
