create schema minion_upms collate utf8mb4_unicode_ci;

create table sys_api
(
    id             varchar(100) not null comment 'id'
        primary key,
    own            varchar(100) null comment '所属项目',
    name           varchar(100) null comment '名称',
    description    varchar(100) null comment '说明',
    path           varchar(256) null comment '路径',
    method         varchar(256) null comment '请求方法',
    authorizations varchar(256) null comment '权限标识'
);

create table sys_menu
(
    id          bigint unsigned                     not null comment 'id'
        primary key,
    name        varchar(20)                         not null comment '名称',
    description varchar(100)                        null comment '说明',
    type        tinyint(1)                          not null comment '1-顶部菜单 2-左侧菜单',
    path        varchar(500)                        not null comment '前端页面路径',
    component   varchar(500)                        not null comment '前端组件路径',
    icon        varchar(500)                        not null comment '菜单图标',
    num         int                                 not null comment '编号',
    parent_num  int                                 not null comment '父级编码',
    order_num   int                                 not null comment '顺序',
    create_time timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '创建时间',
    update_time timestamp                           null comment '更新时间',
    create_uid  bigint unsigned                     not null comment '创建uid',
    update_uid  bigint unsigned                     null comment '更新uid'
);

create table sys_menu_api
(
    id          bigint unsigned                     not null comment 'id'
        primary key,
    mid         bigint unsigned                     not null comment '菜单id',
    aid         varchar(100)                        not null comment 'Api id',
    create_time timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '创建时间',
    update_time timestamp                           null comment '更新时间',
    create_uid  bigint unsigned                     not null comment '创建uid',
    update_uid  bigint unsigned                     null comment '更新uid'
);

create table sys_role
(
    id          bigint unsigned                     not null comment 'id'
        primary key,
    name        varchar(20)                         not null comment '角色名',
    description varchar(255)                        null comment '说明',
    create_time timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '创建时间',
    update_time timestamp                           null comment '更新时间',
    create_uid  bigint unsigned                     not null comment '创建uid',
    update_uid  bigint unsigned                     null comment '更新uid'
);

create table sys_role_menu
(
    id          bigint unsigned                     not null comment 'id'
        primary key,
    rid         bigint unsigned                     not null comment '用户id',
    mid         bigint unsigned                     not null comment '菜单id',
    create_time timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '创建时间',
    update_time timestamp                           null comment '更新时间',
    create_uid  bigint unsigned                     not null comment '创建uid',
    update_uid  bigint unsigned                     null comment '更新uid'
);

create table sys_user
(
    id          bigint unsigned                     not null comment 'id'
        primary key,
    phone       varchar(20)                         not null comment '手机号码',
    email       varchar(100)                        not null comment '邮箱',
    password    varchar(255)                        not null comment '密码',
    dept_id     bigint unsigned                     null comment '部门id',
    create_time timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '创建时间',
    update_time timestamp                           null comment '更新时间',
    create_uid  bigint unsigned                     not null comment '创建uid',
    update_uid  bigint unsigned                     null comment '更新uid',
    deleted     tinyint(1)                          not null comment '1为已删除，0为未删除'
);

create table sys_user_role
(
    id          bigint unsigned                     not null comment 'id'
        primary key,
    uid         bigint unsigned                     not null comment '用户id',
    rid         bigint unsigned                     not null comment '角色id',
    create_time timestamp default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '创建时间',
    update_time timestamp                           null comment '更新时间',
    create_uid  bigint unsigned                     not null comment '创建uid',
    update_uid  bigint unsigned                     null comment '更新uid'
);

