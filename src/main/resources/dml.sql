
insert into website(url, description) values(url, description);

insert into data_category(name, description, parent_id) values(name, description, parent_id);

insert into webpage(url, category_id, website_id) values(url, category_id, website_id);

insert into webpage_data(json_data, data_id, created_date, webpage_id)
                  values(json_data, data_id, created_date, webpage_id);


insert into webpage_parse_config(data_node_type, data_property_name, is_data_id, element_selectory, element_part_type, element_part_id, webpage_id)
                  values(data_node_type, data_property_name, is_data_id, element_selectory, element_part_type, element_part_id, webpage_id);

