create table website
(
    id          serial primary key,
    uri         varchar(100) not null unique,
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
    uri         varchar(300) not null unique,
    url         varchar(300) not null unique,
    category_id integer references data_category (id),
    website_id  integer references website (id)
);

create table webpage_data
(
    id           serial primary key,
    json_data    text,
    data_id      text,
    created_date timestamp,
    webpage_id   integer references webpage (id)
);


create table webpage_parse_config
(
    id                 serial primary key,
    data_node_type     integer      not null,
    data_property_name varchar(255) not null,
    is_data_id         boolean      not null,
    element_selectory  varchar(255) not null,
    element_part_type  varchar(255) not null,
    element_part_id    varchar(255) not null,
    webpage_id         integer references webpage (id)
);
