SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

create schema minion_auth collate utf8mb4_unicode_ci;

use minion_auth;

-- oauth2 客户端表
create table oauth_client_details
(
    client_id               varchar(48)   not null
        primary key,
    resource_ids            varchar(256)  null,
    client_secret           varchar(256)  null,
    scope                   varchar(256)  null,
    authorized_grant_types  varchar(256)  null,
    web_server_redirect_uri varchar(256)  null,
    authorities             varchar(256)  null,
    access_token_validity   int           null,
    refresh_token_validity  int           null,
    additional_information  varchar(4096) null,
    autoapprove             varchar(256)  null
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;

-- 数据
INSERT INTO oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) VALUES ('test', null, '{noop}test', 'all', 'password,refresh_token', null, null, null, null, null, 'true');

